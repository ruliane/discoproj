package discoproj;
import discoproj.effets.*;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.lang.Math;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class FenetreControle extends JFrame implements ActionListener, ItemListener
{
	private static final long serialVersionUID = -7450590022223191017L;
	/* Variables */
	private FenetreVisu visu;
	private Effet effetCourant;
	private Thread threadCourant;
	private ColorChanger colorChanger=new ColorChanger(this);
	private int densite=50;
	private int vitesse=50;
	private boolean couleurFixe=false;
	private Color couleur=Color.WHITE;
	
	/* Constructeurs */
	public FenetreControle(FenetreVisu visu)
	{
		super("Discoproj");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.visu=visu;
		effetCourant=new EffetRayons1(getVisu()); // Vraiment nécessaire ?
		
		JRadioButton radioChoixNoir=new JRadioButton("Ecran noir", true);
		JRadioButton radioChoixRayons1=new JRadioButton("Rayons 1");
		JRadioButton radioChoixRayons2=new JRadioButton("Rayons 2");
		JRadioButton radioChoixScan=new JRadioButton("Scan");
		JRadioButton radioChoixLaser=new JRadioButton("Laser");
		JRadioButton radioChoixLignes=new JRadioButton("Lignes");
		JRadioButton radioChoixZoom=new JRadioButton("Zoom");
		JRadioButton radioChoixBalayage=new JRadioButton("Balayage");
		JRadioButton radioChoixFlower=new JRadioButton("Flower");
		JRadioButton radioChoixStroboscope=new JRadioButton("Stroboscope");
		JRadioButton radioChoixPaveCouleur=new JRadioButton("Pavé couleur");
		radioChoixNoir.setActionCommand("noir");
		radioChoixRayons1.setActionCommand("rayons1");
		radioChoixRayons2.setActionCommand("rayons2");
		radioChoixScan.setActionCommand("scan");
		radioChoixLaser.setActionCommand("laser");
		radioChoixLignes.setActionCommand("lignes");
		radioChoixZoom.setActionCommand("zoom");
		radioChoixBalayage.setActionCommand("balayage");
		radioChoixFlower.setActionCommand("flower");
		radioChoixStroboscope.setActionCommand("stroboscope");
		radioChoixPaveCouleur.setActionCommand("pavecouleur");
		radioChoixNoir.addActionListener(this);
		radioChoixRayons1.addActionListener(this);
		radioChoixRayons2.addActionListener(this);
		radioChoixScan.addActionListener(this);
		radioChoixLaser.addActionListener(this);
		radioChoixLignes.addActionListener(this);
		radioChoixZoom.addActionListener(this);
		radioChoixBalayage.addActionListener(this);
		radioChoixFlower.addActionListener(this);
		radioChoixStroboscope.addActionListener(this);
		radioChoixPaveCouleur.addActionListener(this);
		
		ButtonGroup choixMode=new ButtonGroup();
		choixMode.add(radioChoixNoir);
		choixMode.add(radioChoixRayons1);
		choixMode.add(radioChoixRayons2);
		choixMode.add(radioChoixScan);
		choixMode.add(radioChoixLaser);
		choixMode.add(radioChoixLignes);
		choixMode.add(radioChoixZoom);
		choixMode.add(radioChoixBalayage);
		choixMode.add(radioChoixFlower);
		choixMode.add(radioChoixStroboscope);
		choixMode.add(radioChoixPaveCouleur);
		
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		JButton boutonStart=new JButton("Afficher/masquer la fenetre");
		boutonStart.setActionCommand("demarrer");
		boutonStart.addActionListener(this);
		panel.add(boutonStart);
		
		/* Ajout des differents modes */
		panel.add(radioChoixNoir);
		panel.add(radioChoixRayons1);
		panel.add(radioChoixRayons2);
		panel.add(radioChoixScan);
		panel.add(radioChoixLaser);
		panel.add(radioChoixLignes);
		panel.add(radioChoixZoom);
		panel.add(radioChoixBalayage);
		panel.add(radioChoixFlower);
		panel.add(radioChoixStroboscope);
		panel.add(radioChoixPaveCouleur);
		
		/* Ajout des outils de reglage */
		JSlider densite=new JSlider(1, 100, 50);
		densite.addChangeListener(new NombreSpotAdapter(this));
		densite.setMinorTickSpacing(1);
		JSlider vitesse=new JSlider(1, 100, 50);
		vitesse.addChangeListener(new VitesseAdapter(this));
		vitesse.setMinorTickSpacing(1);
		panel.add(new JLabel("Densite"));
		panel.add(densite);
		panel.add(new JLabel("Vitesse/Sensibilite"));
		panel.add(vitesse);
		
		/* Ajout du choix de la couleur */
		JRadioButton radioCouleurAleatoire=new JRadioButton("Couleur aleatoire", true);
		radioCouleurAleatoire.setActionCommand("couleuraleatoire");
		radioCouleurAleatoire.addActionListener(this);
		JRadioButton radioCouleurVariable=new JRadioButton("Couleur variable");
		radioCouleurVariable.setActionCommand("couleurvariable");
		radioCouleurVariable.addActionListener(this);
		JRadioButton radioCouleurFixe=new JRadioButton("Couleur fixe");
		radioCouleurFixe.setActionCommand("couleurfixe");
		radioCouleurFixe.addActionListener(this);
		
		ButtonGroup choixCouleur=new ButtonGroup();
		choixCouleur.add(radioCouleurAleatoire);
		choixCouleur.add(radioCouleurVariable);
		choixCouleur.add(radioCouleurFixe);
		panel.add(radioCouleurAleatoire);
		panel.add(radioCouleurVariable);
		panel.add(radioCouleurFixe);
		
		JButton couleur=new JButton("Couleur");
		couleur.setActionCommand("couleur");
		couleur.addActionListener(this);
		panel.add(couleur);
		
		/* Affichage */
		panel.setPreferredSize(new Dimension(229, 373));
		add(panel);
		pack();
	}
	
	/* Accesseurs */
	public FenetreVisu getVisu()
	{
		return visu;
	}
	public Effet getEffetCourant()
	{
		return effetCourant;
	}
	public Thread getThreadCourant()
	{
		return threadCourant;
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
	}
	public int getDensite()
	{
		return densite;
	}
	public void setDensite(int densite)
	{
		this.densite=densite;
	}
	public int getVitesse()
	{
		return vitesse;
	}
	public void setVitesse(int vitesse)
	{
		this.vitesse=vitesse;
	}
	
	/* Methodes */
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Width: "+this.getWidth()+" Height: "+this.getHeight());
		if (e.getActionCommand().equals("demarrer"))
			if(visu.isVisible()) // A simplifier
				visu.setVisible(false);
			else
				visu.setVisible(true);
		else if(e.getActionCommand().equals("noir"))
		{
			effetCourant.stop();
			visu.setCouleurFond(Color.BLACK);
			visu.getFormes().clear();
			visu.repaint();
		}
		else if(e.getActionCommand().equals("couleur"))
		{
			Color newCouleur=JColorChooser.showDialog(this, "Choix de la couleur", this.couleur);
			if(newCouleur != null)
			{
				this.couleur=newCouleur;
				effetCourant.setCouleur(newCouleur);
			}
		}
		else if(e.getActionCommand().equals("couleuraleatoire"))
		{
			colorChanger.stop();
			couleurFixe=false;
			effetCourant.setCouleurFixe(false);
		}
		else if(e.getActionCommand().equals("couleurvariable"))
		{
			couleurFixe=true;
			effetCourant.setCouleurFixe(true);
			colorChanger.stop();
			colorChanger=new ColorChanger(this);
			new Thread(colorChanger).start();
		}
		else if(e.getActionCommand().equals("couleurfixe"))
		{
			colorChanger.stop();
			couleurFixe=true;
			effetCourant.setCouleurFixe(true);
		}
		else
		{
			// Arret de l'effet actuel
			effetCourant.stop();
			
			// Lancement du nouvel effet
			if(e.getActionCommand().equals("rayons1"))
				effetCourant=new EffetRayons1(visu);
			else if(e.getActionCommand().equals("rayons2"))
				effetCourant=new EffetRayons2(visu);
			else if(e.getActionCommand().equals("scan"))
				effetCourant=new EffetScan(visu);
			else if(e.getActionCommand().equals("laser"))
				effetCourant=new EffetLaser(visu);
			else if(e.getActionCommand().equals("lignes"))
				effetCourant=new EffetLignes(visu);
			else if(e.getActionCommand().equals("zoom"))
				effetCourant=new EffetZoom(visu);
			else if(e.getActionCommand().equals("balayage"))
				effetCourant=new EffetBalayage(visu);
			else if(e.getActionCommand().equals("flower"))
				effetCourant=new EffetFlower(visu);
			else if(e.getActionCommand().equals("stroboscope"))
				effetCourant=new EffetStroboscope(visu);
			else if(e.getActionCommand().equals("pavecouleur"))
				effetCourant=new EffetPaveCouleur(visu);
			else
				System.out.println("Erreur: effet inconnu");
			
			effetCourant.setDensite(getDensite());
			effetCourant.setVitesse(getVitesse());
			effetCourant.setCouleurFixe(getCouleurFixe());
			effetCourant.setCouleur(getCouleur());
			threadCourant=new Thread(effetCourant);
			threadCourant.start();
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange() == ItemEvent.DESELECTED)
			setCouleurFixe(false);
		else
			setCouleurFixe(true);
		effetCourant.setCouleurFixe(getCouleurFixe());
		effetCourant.setCouleur(getCouleur());
	}
}

class NombreSpotAdapter implements ChangeListener
{
	/* Variables */
	FenetreControle controle;

	/* Constructeurs */
	public NombreSpotAdapter(FenetreControle controle)
	{
		this.controle=controle;
	}
	/* Methodes */
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting())
		{
			controle.setDensite(source.getValue());
			controle.getEffetCourant().setDensite(source.getValue());
		}
	}
}

class VitesseAdapter implements ChangeListener
{
	/* Variables */
	FenetreControle controle;
	/* Constructeurs */
	public VitesseAdapter(FenetreControle controle)
	{
		this.controle=controle;
	}
	/* Methodes */
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting())
		{
			controle.setVitesse(source.getValue());
			controle.getEffetCourant().setVitesse(source.getValue());
		}
	}
}

class ColorChanger implements Runnable
{
	/* Variables */
	FenetreControle controle;
	boolean fin=false;
	
	/* Constructeurs */
	public ColorChanger(FenetreControle controle)
	{
		this.controle=controle;
	}
	/* Methodes */
	public void run()
	{
		Color couleur=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
		Color couleurFinale;
		int rouge, vert, bleu;
		while(!fin)
		{
			System.out.print("Changement de couleur...");
			couleurFinale=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
			while(!couleur.equals(couleurFinale))
			{
				rouge=couleur.getRed();
				vert=couleur.getGreen();
				bleu=couleur.getBlue();
				if(rouge<couleurFinale.getRed())
					rouge++;
				if(rouge>couleurFinale.getRed())
					rouge--;
				if(vert<couleurFinale.getGreen())
					vert++;
				if(vert>couleurFinale.getGreen())
					vert--;
				if(bleu<couleurFinale.getBlue())
					bleu++;
				if(bleu>couleurFinale.getBlue())
					bleu--;
				couleur=new Color(rouge, vert, bleu);
				controle.getEffetCourant().setCouleur(couleur);
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException exception)
				{
				}
			}
			System.out.println("OK");
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException exception)
			{
			}
		}
	}
	public synchronized void stop()
	{
		fin=true;
	}
}
