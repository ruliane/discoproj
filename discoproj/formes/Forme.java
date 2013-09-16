package discoproj.formes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Forme
{
	/* Variables */
	private int x;
	private int y;
	private Color couleur;

	/* Constructeurs */

	/* Accesseurs */
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public Color getCouleur()
	{
		return couleur;
	}
	public void setCouleur(Color couleur)
	{
		this.couleur=couleur;
	}

	/* Methodes */
	public void deplacerVers(int newX, int newY)
	{
		x=newX;
		y=newY;
		return;
	}
	public void translater(Point deplacement)
	{
		deplacerVers(x + (int)deplacement.getX(), y + (int)deplacement.getY());
		return;
	}
	public void translater(int decalX, int decalY)
	{
		deplacerVers(x+decalX, y+decalY);
		return;
	}
	abstract public void affiche(Graphics g);
}