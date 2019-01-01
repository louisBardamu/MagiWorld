package Utils;

public class utils {

    /**
     * Méthode pour vérifier si la réponse du joueur est un Integer
     * @param reponse String saisie par le joueur
     * @return temp integer saisie par le joueur ou -1 valeur incohérente
     */
    private static int VerificationInt(String reponse){
        int temp;

        try {
            temp=Integer.parseInt(reponse);
        } catch (NumberFormatException e) {
            System.out.println("Votre réponse n'est pas un chiffre");
            temp=-1;
        }

        return temp;
    }

    /**
     * Méthode pour vérifier si la réponse est entre les valeurs mises en conditions
     * @param temp int saisie ou -1 valeur incoherente si la saisie n'etai pas de type Int
     * @param mini int valeur minimum
     * @param maxi int valeur maximum
     * @return ok boolean qui a false pour valeur si saisie incohérente
     */
    private static boolean VerificationValeurDansPortee(int temp, int mini, int maxi){
        boolean ok;

        ok=((temp >= mini) && (temp <= maxi));
        if(!ok)
            System.out.println("Votre réponse doit être comprise entre "+mini+" et "+maxi);
        return ok;
    }

    /**
     * Méthode englobant les vérifications avec un boucle pour relancer la saisie
     * @param question String informant le joueur de la futur caracteristique
     * @param mini int valeur minimum
     * @param maxi int valeur maximum
     * @return intReponse la saisie cohérente
     */
    public static int RetourDeValeur(String question, int mini, int maxi){
        boolean nombreOk;
        int intReponse;
        String reponse;

        do {
            reponse=Saisie.Saisir(question);
            intReponse= VerificationInt(reponse);
            nombreOk=VerificationValeurDansPortee(intReponse, mini, maxi);

        }while(!nombreOk);

        return intReponse;
    }

    /**
     * Methode de verification du niveau
     * La sommme de la force, l'agilité et l'inteligence doivent être egaux au niveau
     * @param force int saisi par le joueur
     * @param agilite int saisi par le joueur
     * @param intelligence int saisi par le joueur
     * @param niveau int saisi par le joueur
     * @return ok boolean qui aura false pour valeur si les criteres ne sont pas reunis
     */
    public static boolean VerificationNiveau(int force, int agilite, int intelligence, int niveau){
        boolean ok;

        ok=false;
        if((force+agilite+intelligence)==niveau)
            ok = true;
        else
            System.out.println("La somme de votre force("+force+"), de votre agilité("+agilite+
                    ") et de votre intelligence("+intelligence+") doit être egale a votre niveau("+niveau+")");
        return ok;
    }

}
