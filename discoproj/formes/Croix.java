package discoproj.formes;
import java.awt.Color;
import java.awt.Graphics;

public class Croix extends Forme
{
	/* Variables */
	private int size;

	/* Constructeurs */
	public Croix(int x, int y, int size, Color couleur)
	{
		setX(x);
		setY(y);
		this.size=size;
		setCouleur(couleur);
	}
	public Croix(int x, int y, int size)
	{
		this(x, y, size, Color.WHITE);
	}
	public Croix()
	{
		this(100, 100, 150);
	}

	/* Accesseurs */

	/* Methodes */
	public void affiche(Graphics g)
	{
		g.setColor(getCouleur());
		g.fillRoundRect(getX()-size/16, getY()-size/2, size/8, size, size/16, size/16);
		g.fillRoundRect(getX()-size/2, getY()-size/16, size, size/8, size/16, size/16);
		return;
	}
}