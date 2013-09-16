package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;
import java.util.Vector;

public class EffetRayons1 extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetRayons1(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	/* Methodes */
	public void run()
	{
		getVisu().getFormes().clear();
		getVisu().repaint();
		int newX, newY;
		Color newColor;
		Vector<Forme> newFormes=new Vector<Forme>();
		while(!getFin())
		{
			newFormes.clear();
			for(int i=0;i<getDensite();i+=10)
			{
				newX=(int)((Math.random())*getVisu().getWidth());
				newY=(int)((Math.random())*getVisu().getHeight());
				if(getCouleurFixe())
					newColor=getCouleur();
				else
					newColor=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
				//newFormes.add(new Ellipse(newX, newY, 150, 150, newColor));
				newFormes.add(new Etoile(newX, newY, 150, newColor));
				//newFormes.add(new Croix(newX, newY, 150, newColor));
			}
			getVisu().setFormes(newFormes);
			getVisu().repaint();
			try
			{
				Thread.sleep((int)(1000-9.6*getVitesse()));
			}
			catch (InterruptedException exception)
			{
			}
		}
	}

}
