package discoproj.effets;
import discoproj.*;
import discoproj.formes.*;

import java.awt.Color;
import java.util.Vector;

public class EffetFlower extends Effet
{
	/* Variables */
	Vector<Forme> formesInit=new Vector<Forme>();
	
	/* Constructeurs */
	public EffetFlower(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	public void setCouleur(Color couleur)
	{
		super.setCouleur(couleur);
		for(int i=0;i<formesInit.size();i++)
			formesInit.get(i).setCouleur(couleur);
	}
	public void setCouleurFixe(boolean couleurFixe)
	{
		super.setCouleurFixe(couleurFixe);
		if(couleurFixe)
			for(int i=0;i<formesInit.size();i++)
				formesInit.get(i).setCouleur(getCouleur());
		else
			for(int i=0;i<formesInit.size();i++)
				formesInit.get(i).setCouleur(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
	}
	public void setDensite(int densite)
	{
		System.out.println("Ancienne densite : "+getDensite());
		super.setDensite(densite);
		initialiserFormes();
		System.out.println("Nouvelle densite : "+getDensite());
	}
	
	/* Methodes */
	public void run()
	{
		int newX, newY, rayon;
		double rotation=0; // Rotation de l'ensemble a l'instant t
		int sens=1; // Sens de rotation - 1 horaire - -1 anti-horaire
		int xCentre=(getVisu().getWidth())/2;
		int yCentre=(getVisu().getHeight())/2;
		initialiserFormes();
		
		while(!getFin())
		{
			getVisu().clearFormes();
			rayon=getVisu().getHeight()/3;
			for(int i=0;i<formesInit.size();i++)
			{
				double angle=rotation + (i*2*Math.PI/formesInit.size());
				newX=(int)(rayon*Math.cos(angle));
				newY=(int)(rayon*Math.sin(angle));
				getVisu().addForme(new Ellipse(xCentre+newX, yCentre+newY, 50, 50, formesInit.get(i).getCouleur()));
			}
			if(rotation>4*2*Math.PI) // Changement de sens au bout de 4 tours
				sens=-1;
			if(rotation<0)
				sens=1;
			rotation+=sens*0.003*2*Math.PI;
			getVisu().repaint();
			try
			{
				Thread.sleep((int)(11-0.10*getVitesse()));
			}
			catch (InterruptedException exception)
			{
			}
		}
		getVisu().clearFormes();
		getVisu().repaint();
	}
	
	private void initialiserFormes() // Creation initiale des formes
	{
		int newX, newY, rayon;
		Color couleur;
		formesInit.clear();
		
		for(double angle=0;angle<2*Math.PI;angle+=10*2*Math.PI/getDensite())
		{
			rayon=getVisu().getHeight()/3;
			newX=(int)(rayon*Math.cos(angle));
			newY=(int)(rayon*Math.sin(angle));
			if(getCouleurFixe())
				couleur=getCouleur();
			else
				couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			
			formesInit.add(new Ellipse(newX, newY, 50, 50, couleur));
		}
		
		return;
	}

}
