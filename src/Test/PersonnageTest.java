package Test;

import Model.Personnage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    /**
     * Test unitaire pour la méthode estVivant
     */
    @Test
    void estVivant() {
        Personnage attaquant = new Personnage(3, 1, 1, 1, "rené" ) {
            @Override
            public void AttaqueBasique(Personnage ennemi) {}
            @Override
            public void AttaqueSpeciale(Personnage perso) {}};
        assertTrue(attaquant.estVivant());

        Personnage attaquant2 = new Personnage(0, 0, 0, 0, "rené" ) {
            @Override
            public void AttaqueBasique(Personnage ennemi) {}
            @Override
            public void AttaqueSpeciale(Personnage perso) {}};
        assertFalse(attaquant2.estVivant());
    }
}