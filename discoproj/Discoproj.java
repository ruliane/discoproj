package discoproj;

public class Discoproj
{
	/* Variables */
	static int LARGEUR_ECRAN=800;
	static int HAUTEUR_ECRAN=600;

	/* Methodes */
	public static void main(String[] args)
	{
		FenetreVisu visu=new FenetreVisu(LARGEUR_ECRAN, HAUTEUR_ECRAN);
		FenetreControle controle=new FenetreControle(visu);
		controle.setVisible(true);
	}
}
