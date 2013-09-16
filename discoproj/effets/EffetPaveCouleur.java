package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;

public class EffetPaveCouleur extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetPaveCouleur(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	/* Methodes */
	private void init()
	{
		getVisu().getFormes().clear();
		Color newColor;

		int rectWidth=(int)(getVisu().getWidth()/(0.105*getDensite()));
		int rectHeight=(int)(getVisu().getHeight()/(0.105*getDensite()));

		int startX=0+rectWidth/2;
		int endX=getVisu().getWidth()+rectWidth/2;
		int incrementX=(int)(getVisu().getWidth()/(0.1*getDensite()));

		int startY=0+rectHeight/2;
		int endY=getVisu().getHeight()+rectHeight/2;
		int incrementY=(int)(getVisu().getHeight()/(0.1*getDensite()));

		for (int x=startX;x<endX;x+=incrementX)
			for (int y=startY;y<endY;y+=incrementY)
			{
				newColor=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
				getVisu().addForme(new Rectangle(x, y, rectWidth, rectHeight, newColor));
			}
		getVisu().repaint();
	}

	public void run()
	{
		init();
		Color newColor;
		while(!getFin())
		{
			for(int i=0;i<1+(int)(0.1*getDensite());i++)
			{
				int index=(int)(Math.random()*(getVisu().getFormes().size()));
				Rectangle currentForme=(Rectangle)getVisu().getFormes().get(index);
				newColor=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
				currentForme.setCouleur(newColor);
				currentForme.affiche(getVisu().getPanel().getGraphics()); // On ne redessine que la forme modifiée pour éviter le scintillement
			}
			try
			{
				Thread.sleep((int)(1000-9.6*getVitesse()));
			}
			catch (InterruptedException exception)
			{
			}
		}
	}
	public void setDensite(int densite)
	{
		super.setDensite(densite);
		init();
	}

}
