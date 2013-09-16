package discoproj.effets;
import discoproj.*;
import java.awt.Color;

abstract public class Effet implements Runnable
{
	/* Variables */
	private FenetreVisu visu;
	private boolean couleurFixe=false; // Indique si toutes les formes de l'effet sont de la meme couleur
	private Color couleur=Color.WHITE;
	private int vitesse=50;
	private int densite=50;
	private boolean fin=false;
	
	/* Constructeurs */
	public Effet(FenetreVisu visu)
	{
		this.visu=visu;
		// Initialiser les variables avec celles du FenetreControle ?
	}	
	/* Accesseurs */
	public FenetreVisu getVisu()
	{
		return visu;
	}
	public void setVisu(FenetreVisu visu)
	{
		this.visu=visu;
	}
	public boolean getCouleurFixe()
	{
		return couleurFixe;
	}
	public void setCouleurFixe(boolean couleurFixe)
	{
		this.couleurFixe=couleurFixe;
	}
	public Color getCouleur()
	{
		return couleur;
	}
	public void setCouleur(Color couleur)
	{
		this.couleur=couleur;
		for(int i=0;i<visu.getFormes().size();i++)
			visu.getFormes().get(i).setCouleur(couleur);
	}
	public int getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(int vitesse)
	{
		this.vitesse=vitesse;
	}
	public int getDensite()
	{
		return densite;
	}
	public void setDensite(int densite)
	{
		this.densite=densite;
	}
	public boolean getFin()
	{
		return fin;
	}
	public void setFin(boolean fin)
	{
		this.fin=fin;
	}
	
	/* Methodes */
	abstract public void run();
	public synchronized void stop()
	{
		this.fin=true;
	}
}
