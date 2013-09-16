package discoproj.formes;
import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends Forme
{
	/* Variables */
	private int x1, y1, x2, y2;

	/* Constructeurs */
	public Ligne(int x1, int y1, int x2, int y2, Color couleur)
	{
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		setCouleur(couleur);
	}
	public Ligne(int x1, int y1, int x2, int y2)
	{
		this(x1, y1, x2, y2, Color.WHITE);
	}
	public Ligne()
	{
		this(0, 300, 600, 300);
	}

	/* Accesseurs */

	/* Methodes */
	public void affiche(Graphics g)
	{
		g.setColor(getCouleur());
		g.drawLine(x1, y1, x2, y2);
		return;
	}
}