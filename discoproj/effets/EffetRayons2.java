package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;

public class EffetRayons2 extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetRayons2(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	public void setDensite(int newDensite)
	{
		super.setDensite(newDensite);
		Color couleur;
		getVisu().getFormes().clear();
		for(int k=0;k<newDensite;k+=10)
		{
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			getVisu().addForme((new Ellipse((int)(getVisu().getWidth()*Math.random()), (int)(getVisu().getHeight()*Math.random()), 150, 150, couleur)));
		}
	}
	
	/* Methodes */
	public void run()
	{
		getVisu().getFormes().clear();
		getVisu().repaint();
		int newX, newY;
		Color newColor;
		for(int i=0;i<getDensite() && !getFin();i+=10)
		{
			newX=(int)((Math.random())*getVisu().getWidth());
			newY=(int)((Math.random())*getVisu().getHeight());
			if(getCouleurFixe())
				newColor=getCouleur();
			else
				newColor=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			getVisu().addForme(new Ellipse(newX, newY, 150, 150, newColor));
			getVisu().repaint();
		}
		while(!getFin())
		{
			for(int i=0;i<getVisu().getFormes().size() && !getFin();i++)
			{
				newX=(int)((Math.random())*getVisu().getWidth());
				newY=(int)((Math.random())*getVisu().getHeight());
				if(getCouleurFixe())
					newColor=getCouleur();
				else
					newColor=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
				getVisu().getFormes().get(i).deplacerVers(newX, newY);
				getVisu().getFormes().get(i).setCouleur(newColor);
				getVisu().repaint();
				try
				{
					Thread.sleep((int)(400-3.96*getVitesse()));
				}
				catch (InterruptedException exception)
				{
				}
			}
		}
	}

}
