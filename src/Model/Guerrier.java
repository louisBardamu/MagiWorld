package Model;

public class Guerrier extends Personnage{

    /**
     * Constructeur
     * La vie n'est pas prise en compte vue qu'elle correspond a cinq fois le niveau
     * @param niveau le niveau du personnage
     * @param force la force du personnage
     * @param agilite l'agilité du personnage
     * @param intelligence l'intelligence du personnage
     */
    public Guerrier(int niveau, int force, int agilite, int intelligence, String nom){
        super(niveau, force, agilite, intelligence, nom);
        System.out.println("Woarg, je suis le nouveau Guerrier niveau "+this.getNiveau()+" je possede "+this.getVie()+
                " de vitalité "+this.getForce()+" de force "+this.getAgilite()+" d'agilité et "+
                this.getIntelligence()+" d'intelligence !");
    }

    /**
     * Attaque Basique - Coup d'épée : Effectue des dommages égaux à la force du joueur sur l’adversaire.
     * @param ennemi Personnage recevant le coup d'épée
     */
    public void AttaqueBasique(Personnage ennemi) {

        System.out.println(this.getNom()+" utilise coup d'épée et inflige "+this.getForce()+" de dommages");
        ennemi.RecevoirDegats(this.getForce());
    }

    /**
     * Attaque Spéciale - Coup de Rage : Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire.
     * Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2
     * @param ennemi Personnage recevant l'attaque spéciale
     */
    public void AttaqueSpeciale(Personnage ennemi){

        System.out.println(this.getNom()+" utilise coup de rage et inflige "+this.getForce()*2+" de dommages");
        ennemi.RecevoirDegats(this.getForce()*2);
        this.RecevoirDegats(this.getForce()/2);


    }
}
