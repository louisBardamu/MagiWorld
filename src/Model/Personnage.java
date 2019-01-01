package Model;

public abstract class Personnage {

    /**
     * variables de classes
     * Rajout des parametres nom, vieAuDepart
     * nom pour l'affichage de joueur1 puis joueur2
     * VieAuDepart pour eviter de donner plus de points de vie qu'a l'état initial avec la technique soin
     */
    private int niveau;
    private int vie;
    private int force;
    private int agilite;
    private int intelligence;
    private int VieAuDepart;
    private String nom;

    /**
     * Constructeur
     * Rajout d'un parametre pour prendre en compte la technique speciale soin
     * Respect de la contrainte de vie (la vie est egale a cinq fois le niveau),
     * elle ne rentre donc pas dans les parametres d'entrees du constructeur.
     */
    public Personnage(int niveau, int force, int agilite, int intelligence, String nom){
        this.setNiveau(niveau);
        this.setVie(niveau*5);
        this.VieAuDepart = this.getVie();
        this.setForce(force);
        this.setAgilite(agilite);
        this.setIntelligence(intelligence);
        this.setNom(nom);
    }

    // Accesseurs

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Méthode pour cibler la personne et lui administrer ses dégats
     * @param degatsInfliges int valeur des degats
     */
    protected void RecevoirDegats(int degatsInfliges){
        this.setVie(this.getVie() - degatsInfliges);
        System.out.println(this.getNom() + " perd " + degatsInfliges + " de points de vie");
        this.estVivant();
    }

    /**
     * Méthode pour la méthode soin du mage avec une vérification du potentiel de point de vie
     * @param soin int valeur du soin
     */
    protected void RecevoirSoin(int soin){
        if (this.getVie() + soin > VieAuDepart) {
            this.setVie(VieAuDepart);
            System.out.println(this.getNom()+" a gagné " + soin + " et a son maximum de points de vie");
        } else {
            this.setVie(this.getVie() + soin);
            System.out.println(this.getNom()+" a gagné " + soin + " de points de vie");
        }
    }

    /**
     * Méthode pour vérfier si le personnage est vivant
     * @return un booleen qui a true pour valeur si le personnage est vivant
     */
    public boolean estVivant(){
        boolean vivant;

        if(this.getVie()<=0)
            vivant = false;
        else
            vivant = true;
        return vivant;
    }

    /**
     * Methode abstraite pour profiter de l'heritage et faire un appel generique dans le menu
     * @param ennemi personnage qui recevra l'attaque
     */
    abstract public void AttaqueBasique(Personnage ennemi);

    /**
     * Methode abstraite pour profiter de l'heritage et faire un appel generique dans le menu
     * @param perso personnage qui recevra l'attaque ou les bonus
     */
    abstract public void AttaqueSpeciale(Personnage perso);
}
