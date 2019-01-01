package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saisie {

    private static BufferedReader cin;

    /**
     * Initialisation du canal d'entrée
     */
    public static void Initialiser(){
        cin = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Fermeture du canal d'entrée
     */
    public static void Terminer(){
        try {
            cin.close();
        } catch (IOException e) {}
    }

    /**
     * Methode qui pose une question et retourne la reponse dans une chaine de caracteres
     * @param question posee via la console
     * @return reponse la chaine de caractere tapee au clavier
     */
    public static String Saisir(String question){
        String reponse;

        reponse = "";
        System.out.print(question);
        try {
            reponse = cin.readLine();
        } catch (IOException e) {}
        return (reponse);
    }
}
