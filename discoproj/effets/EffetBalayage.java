package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;
import java.util.Vector;

public class EffetBalayage extends Effet
{
	/* Variables */
	private Vector<Forme> formes;
	
	/* Constructeurs */
	public EffetBalayage(FenetreVisu visu)
	{
		super(visu);
		formes=new Vector<Forme>();
	}
	
	/* Accesseurs */
	public void setCouleurFixe(boolean couleurFixe)
	{
		super.setCouleurFixe(couleurFixe);
		for(int k=0;k<formes.size();k++)
		{
			if(couleurFixe)
				formes.get(k).setCouleur(getCouleur());
			else
				formes.get(k).setCouleur(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		}
	}
	public void setDensite(int newDensite)
	{
		super.setDensite(newDensite);
		Color couleur;
		formes.clear();
		for(int k=0;k<newDensite;k++)
		{
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			formes.add(new Ellipse((int)(getVisu().getWidth()*Math.random()), (int)(getVisu().getHeight()*Math.random()), 30, 30, couleur));
		}
	}
	
	
	/* Methodes */
	public void run()
	{
		Color couleur;
		formes=new Vector<Forme>();
		
		getVisu().clearFormes();
		getVisu().repaint();
		
		/* Creation initiale des formes */
		for(int k=0;k<getDensite();k++)
		{
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			
			formes.add(new Ellipse((int)(getVisu().getWidth()*Math.random()), (int)(getVisu().getHeight()*Math.random()), 30, 30, couleur));
		}
		
		while(!getFin())
		{
			for(int k=0;k<formes.size();k++)
			{
				if (formes.get(k).getX()>getVisu().getWidth())
				{
					formes.get(k).deplacerVers(0, (int)(getVisu().getHeight()*Math.random()));
				}
				else
					formes.get(k).translater(5, 0);
				if(getCouleurFixe())
					formes.get(k).setCouleur(getCouleur());
			}
			getVisu().setFormes(formes);
			getVisu().repaint();
			try
			{
				Thread.sleep((int)(50-0.45*getVitesse()));
			}
			catch (InterruptedException exception)
			{
			}
		}
	}
}
