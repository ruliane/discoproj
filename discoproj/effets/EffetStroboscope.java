package discoproj.effets;
import discoproj.*;
import java.awt.Color;

public class EffetStroboscope extends Effet
{
	/* Variables */
	
	/* Constructeurs */
	public EffetStroboscope(FenetreVisu visu)
	{
		super(visu);
	}
	
	/* Accesseurs */
	/* Methodes */
	public void run()
	{
		getVisu().getFormes().clear();
		while(!getFin())
		{
			getVisu().setCouleurFond(getCouleur());
			getVisu().repaint();
			try
			{
				Thread.sleep(20);
			}
			catch(InterruptedException exception)
			{
			}
			getVisu().setCouleurFond(Color.BLACK);
			getVisu().repaint();
			
			try
			{
				Thread.sleep((int)(504.8-4.798*getVitesse()));
			}
			catch(InterruptedException exception)
			{
			}
		}
		getVisu().setCouleurFond(Color.BLACK);
	}
}
