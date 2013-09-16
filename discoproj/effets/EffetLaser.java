package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;

public class EffetLaser extends Effet
{
	/* Variables */
	public EffetLaser(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Constructeurs */
	
	/* Accesseurs */
	/* Methodes */
	public void run()
	{
		Color couleur;
		
		getVisu().getFormes().clear();
		getVisu().repaint();
		
		int x1=(int)((getVisu().getWidth())*Math.random());
		int y1=(int)((getVisu().getHeight())*Math.random());
		int x2=(int)((getVisu().getWidth())*Math.random());
		int y2=(int)((getVisu().getHeight())*Math.random());
		
		while(!getFin())
		{
			int newX1=(int)((getVisu().getWidth())*Math.random());
			int newY1=(int)((getVisu().getHeight())*Math.random());
			int newX2=(int)((getVisu().getWidth())*Math.random());
			int newY2=(int)((getVisu().getHeight())*Math.random());
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			for(int k=0;k<100 && !getFin();k++)
			{
				x1+=(newX1-x1)/75;
				y1+=(newY1-y1)/75;
				x2+=(newX2-x2)/75;
				y2+=(newY2-y2)/75;
				getVisu().getFormes().clear();
				getVisu().getFormes().add(new Ligne(x1, y1, x2, y2, couleur));
				getVisu().getFormes().add(new Ligne(x1+1, y1, x2, y2+1, couleur)); // Pour faire une ligne plus épaisse
				getVisu().getFormes().add(new Ligne(x1, y1-1, x2-1, y2, couleur)); // on en dessine 3
				getVisu().repaint();
				try
				{
					Thread.sleep((int)(42-0.4*getVitesse()));
				}
				catch (InterruptedException exception)
				{
				}
			}
		}
	}

}
