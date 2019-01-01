package Model;

public class Mage extends Personnage{

    /**
     * Constructeur
     * La vie n'est pas prise en compte vue qu'elle correspond a cinq fois le niveau
     * @param niveau le niveau du personnage
     * @param force la force du personnage
     * @param agilite l'agilité du personnage
     * @param intelligence l'intelligence du personnage
     */
    public Mage(int niveau, int force, int agilite, int intelligence, String nom) {
        super(niveau, force, agilite, intelligence, nom);
        System.out.println("Abracadabra, je suis le nouveau Mage niveau "+this.getNiveau()+" je possede "+this.getVie()+
                " de vitalité "+this.getForce()+" de force "+this.getAgilite()+" d'agilité et "+
                this.getIntelligence()+" d'intelligence !");
    }

    /**
     * Attaque Basique - Boule de Feu : Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire.
     * @param ennemi Personnage recevant les degats
     */
    public void AttaqueBasique(Personnage ennemi){

        System.out.println(this.getNom()+" utilise Boule de feu et inflige "+this.getIntelligence()+" de dommages");
        ennemi.RecevoirDegats(this.getIntelligence());
    }

    /**
     * Attaque Spéciale - Soin : Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie.
     * Une vérification du potentiel de point de vie est faite dans la classe personne.
     * Pour profiter du polymorphisme et de l'heritage, je mets un personnage inutile en parametre d'entrée
     */
    public void AttaqueSpeciale(Personnage perso){

        RecevoirSoin(this.getIntelligence()*2);
    }
}
