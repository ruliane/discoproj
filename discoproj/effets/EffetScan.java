package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;

public class EffetScan extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetScan(FenetreVisu visu)
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
		
		int xCentre=(int)((getVisu().getWidth())*Math.random());
		int yCentre=(int)((getVisu().getHeight())*Math.random());
		
		while(!getFin())
		{
			int newX=(int)((getVisu().getWidth())*Math.random());
			int newY=(int)((getVisu().getHeight())*Math.random());
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			while((xCentre != newX || yCentre != newY) && !getFin())
			{
				if(xCentre < newX)
					xCentre+=4;
				if(xCentre > newX)
					xCentre-=5;
				if(yCentre < newY)
					yCentre+=4;
				if(yCentre > newY)
					yCentre-=5;
				getVisu().getFormes().clear();
				getVisu().getFormes().add(new Ellipse(xCentre, yCentre, 150, 150, couleur));
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
