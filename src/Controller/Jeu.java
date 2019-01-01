package Controller;

import Model.*;
import Utils.*;

public class Jeu {

    /**
     * Le jeu etant uniquement jouable pour et par deux joueurs, je les mets en variables de la classe Jeu
     */
    private Personnage premierJoueur;
    private Personnage secondJoueur;

    /**
     * Constructeur:
     * Ouverture du canal d'entree
     * Creations des joueurs
     * le jeu en lui meme
     * Fermeture du canal d'entree
     */
    public Jeu(){
        Saisie.Initialiser();
        this.premierJoueur = CreationDePersonnage("joueur1");
        this.secondJoueur = CreationDePersonnage("joueur2");
        Combat();
        Saisie.Terminer();
    }

    /**
     * Méthode de création de personnages
     * Vérification des choix du joueur pour les caracteristiques puis appel de la méthode CreationSuivantClasse
     * @param nom String qui aura pour valeur joueur1 puis joueur2 dans l'ordre
     * @return Le personnage instancié par la méthode "CreationSuivantClasse"
     */
    private Personnage CreationDePersonnage(String nom){
        int intForce, intAgilite, intInteligence, intNiveau, intClasse;
        boolean ok;

        intClasse = utils.RetourDeValeur("Veuillez choisir la classe de votre personnage(1: Guerrier, 2: Rôdeur, 3: Mage)", 1, 3);
        do {
            intForce = utils.RetourDeValeur("Force du personnage ?", 0, 100);
            intAgilite = utils.RetourDeValeur("Agilité du personnage ?", 0, 100);
            intInteligence = utils.RetourDeValeur("Intelligence du personnage ?", 0, 100);
            intNiveau = utils.RetourDeValeur("Niveau du personnage ?", 1, 100);

            ok = utils.VerificationNiveau(intForce, intAgilite, intInteligence, intNiveau);
        }while (!ok);

        return creationSuivantClasse(intClasse, intNiveau, intForce, intAgilite, intInteligence, nom);
    }

    /**
     * Méthode d'instanciation de personnage suivant le choix de classe du joueur
     * @param classe int entre 1 et 3
     * @param niveau int le niveau du joueur
     * @param force int la force du joueur
     * @param agilite int l'agilite du joueur
     * @param intelligence int l'intelligence du joueur
     * @param nom String Joueur1 ou Joueur2
     * @return Temporaire Personnage créé
     */
    private Personnage creationSuivantClasse(int classe, int niveau, int force, int agilite, int intelligence, String nom){
        Personnage temporaire = null;

        switch (classe) {
            case 1:
                temporaire = new Guerrier(niveau, force, agilite, intelligence, nom);
                break;
            case 2:
                temporaire = new Rodeur(niveau, force, agilite, intelligence, nom);
                break;
            case 3:
                temporaire = new Mage(niveau, force, agilite, intelligence, nom);
                break;
        }
        return temporaire;
    }

    /**
     * Méthode pour le combat entre les joueurs
     * Boucle tant que les deux personnages sont vivants
     * avec vérification apres chaque attaque
     */
    public void Combat(){
        int reponse;

        do {
            if(this.premierJoueur.estVivant()) {
                System.out.print("joueur1 (" + this.premierJoueur.getVie() + ") ");
                reponse = utils.RetourDeValeur("Veuillez choisir votre action (1: Attaque basique, 2: Attaque spéciale) ", 1, 2);
                switch (reponse) {
                    case 1:
                        this.premierJoueur.AttaqueBasique(this.secondJoueur);
                        break;
                    case 2:
                        this.premierJoueur.AttaqueSpeciale(this.secondJoueur);
                        break;
                }
            }
            else
                System.out.println(premierJoueur.getNom()+" est mort");
            if(this.secondJoueur.estVivant()) {
                System.out.print("joueur2 (" + this.secondJoueur.getVie() + ") ");
                reponse = utils.RetourDeValeur("Veuillez choisir votre action (1: Attaque basique, 2: Attaque spéciale) ", 1, 2);
                switch (reponse) {
                    case 1:
                        this.secondJoueur.AttaqueBasique(this.premierJoueur);
                        break;
                    case 2:
                        this.secondJoueur.AttaqueSpeciale(this.premierJoueur);
                        break;
                }
            }
            else
                System.out.println(secondJoueur.getNom()+" est mort");
        } while((this.premierJoueur.getVie() > 0) && (this.secondJoueur.getVie() > 0));
    }
}
