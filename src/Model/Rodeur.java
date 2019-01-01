package Model;

public class Rodeur extends Personnage{

    /**
     * Constructeur
     * La vie n'est pas prise en compte vue qu'elle correspond a cinq fois le niveau
     * @param niveau le niveau du personnage
     * @param force la force du personnage
     * @param agilite l'agilité du personnage
     * @param intelligence l'intelligence du personnage
     */
    public Rodeur(int niveau, int force, int agilite, int intelligence, String nom){
        super(niveau, force, agilite, intelligence, nom);
        System.out.println("fufu, je suis le nouveau rôdeur niveau "+this.getNiveau()+" je possede "+this.getVie()+
                " de vitalité "+this.getForce()+" de force "+this.getAgilite()+" d'agilité et "+
                this.getIntelligence()+" d'intelligence !");
    }

    /**
     * Attaque Basique - Tir à l’Arc : Effectue des dommages égaux à l’agilité du joueur sur l’adversaire.
     * @param ennemi Personnage recevant les dégats
     */
    public void AttaqueBasique(Personnage ennemi){
        System.out.println(this.getNom()+" utilise Tir à l'arc et inflige "+this.getAgilite()+" de dommages");
        ennemi.RecevoirDegats(this.getAgilite());
    }

    /**
     * Attaque Spéciale - Concentration : Le joueur gagne son niveau divisé par 2 en agilité.
     * Pour profiter du polymorphisme et de l'heritage, je mets un personnage inutile en parametre d'entrée
     */
    public void AttaqueSpeciale(Personnage perso){
        int agil;

        agil = this.getAgilite();
        agil +=this.getNiveau()/2;
        this.setAgilite(agil);
        System.out.println(this.getNom()+" utilise la technique concentration et gagne "+this.getNiveau()/2+" d'agilité");
    }
}
