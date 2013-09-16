package discoproj.formes;
import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends Forme
{
	/* Variables */
	private int rayon;

	/* Constructeurs */
	public Cercle(int x, int y, int rayon, Color couleur)
	{
		setX(x);
		setY(y);
		this.rayon=rayon;
		setCouleur(couleur);
	}
	public Cercle(int x, int y, int rayon)
	{
		this(x, y, rayon, Color.WHITE);
	}
	public Cercle()
	{
		this(100, 100, 75);
	}

	/* Accesseurs */

	/* Methodes */
	public void affiche(Graphics g)
	{
		g.setColor(getCouleur());
		g.fillOval(getX()-rayon, getY()-rayon, 2*rayon, 2*rayon);
		g.setColor(Color.BLACK);
		g.fillOval(getX()-(rayon-5), getY()-(rayon-5), (int)(2*rayon-10), (int)(2*rayon-10));
		return;
	}
}
