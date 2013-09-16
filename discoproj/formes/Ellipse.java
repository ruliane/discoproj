package discoproj.formes;
import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Forme
{
	/* Variables */
	private int width;
	private int height;

	/* Constructeurs */
	public Ellipse(int x, int y, int width, int height, Color couleur)
	{
		setX(x);
		setY(y);
		this.width=width;
		this.height=height;
		setCouleur(couleur);
	}
	public Ellipse(int x, int y, int width, int height)
	{
		this(x, y, width, height, Color.WHITE);
	}
	public Ellipse ()
	{
		this(100, 100, 150, 150);
	}

	/* Accesseurs */

	/* Methodes */
	public void affiche(Graphics g)
	{
		g.setColor(getCouleur());
		g.fillOval(getX()-width/2, getY()-height/2, width, height);
		return;
	}
}