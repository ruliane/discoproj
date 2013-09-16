package discoproj.formes;
import java.awt.Color;
import java.awt.Graphics;

public class Etoile extends Forme
{
	/* Variables */
	private int size;

	/* Constructeurs */
	public Etoile(int x, int y, int size, Color couleur)
	{
		setX(x);
		setY(y);
		this.size=size;
		setCouleur(couleur);
	}
	public Etoile(int x, int y, int size)
	{
		this(x, y, size, Color.WHITE);
	}
	public Etoile ()
	{
		this(100, 100, 150);
	}

	/* Accesseurs */

	/* Methodes */
	public void affiche(Graphics g)
	{
		g.setColor(getCouleur());
		//int[] x={getX()-size/3, getX()+size/3, getX()+0};
		//int[] y={getY()+size/3, getY()+size/3, getY()-2*size/3};
		int[] x1={getX()-size/3, getX()+size/3, getX()+0};
		int[] y1={getY()+size/3-size/8, getY()+size/3-size/8, getY()-size/3-size/8};
		g.fillPolygon(x1, y1, 3);
		int[] x2={getX()+size/3, getX()-size/3, getX()+0};
		int[] y2={getY()-size/3+size/8, getY()-size/3+size/8, getY()+size/3+size/8};
		g.fillPolygon(x2, y2, 3);
		return;
	}
}