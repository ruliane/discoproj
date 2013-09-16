package discoproj;

import discoproj.formes.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FenetreVisu extends JFrame implements MouseListener
{
	private static final long serialVersionUID = -6650902199877450200L;
	/* Variables */
	private JPanel panel;
	private Color couleurFond=Color.BLACK;
	private Color couleurCourante=Color.WHITE;
	private Vector<Forme> formes;
	
	/* Constructeurs */
	public FenetreVisu(int width, int height)
	{
		super("Visualisation");
		panel=new JPanel();
		formes=new Vector<Forme>();
		panel.setPreferredSize(new Dimension(width, height));
		this.add(panel);
		panel.addMouseListener(this);
		this.pack();
	}
	public FenetreVisu()
	{
		this(500, 500);
	}
	
	/* Accesseurs */
	public JPanel getPanel()
	{
		return panel;
	}
	public void setPanel(JPanel newPanel)
	{
		panel=newPanel;
	}
	public Vector<Forme> getFormes()
	{
		return formes;
	}
	public void setFormes(Vector<Forme> formes)
	{
		this.formes=formes;
	}
	public Color getCouleurFond()
	{
		return couleurFond;
	}
	public void setCouleurFond(Color couleurFond)
	{
		this.couleurFond=couleurFond;
	}
	public Color getCouleurCourante()
	{
		return couleurCourante;
	}
	public void setCouleurCourante(Color couleurCourante)
	{
		this.couleurCourante=couleurCourante;
	}

	/* Methodes */
	public void addForme(Forme forme)
	{
		formes.add(forme);
	}
	public void clearFormes()
	{
		formes.clear();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(couleurFond);
		g.fillRect(0, 0, getWidth(), getHeight());
		for(int k=0;k<formes.size();k++)
			formes.elementAt(k).affiche(g);
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseClicked(MouseEvent e)
	{
		this.setVisible(false);
		this.dispose();
		this.setUndecorated(!(this.isUndecorated()));
		this.setVisible(true);
	}
}
