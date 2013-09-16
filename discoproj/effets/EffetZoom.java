package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;

public class EffetZoom extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetZoom(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	/* Methodes */
	public void run()
	{
		Color couleur;
		
		getVisu().getFormes().clear();
		getVisu().repaint();
		
		while(!getFin())
		{
			int xCentre=(getVisu().getWidth())/2;
			int yCentre=(getVisu().getHeight())/2;
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			for(int taille=0;taille<(int)2*getVisu().getHeight()/3 && !getFin();taille+=5)
			{
				getVisu().getFormes().clear();
				getVisu().getFormes().add(new Cercle(xCentre, yCentre, taille, couleur));
				getVisu().repaint();
				try
				{
					Thread.sleep((int)(52-0.5*getVitesse()));
				}
				catch (InterruptedException exception)
				{
				}
			}
			for(int taille=2*getVisu().getHeight()/3;taille>0 && !getFin();taille-=5)
			{
				getVisu().getFormes().clear();
				getVisu().getFormes().add(new Cercle(xCentre, yCentre, taille, couleur));
				getVisu().repaint();
				try
				{
					Thread.sleep((int)(52-0.5*getVitesse()));
				}
				catch (InterruptedException exception)
				{
				}
			}
		}
	}

}
