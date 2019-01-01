package Test;

import Utils.utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class utilsTest {


    /**
     * Test unitaire de verification de la méthode VerificatioNiveau
     */
    @Test
    void verificationNiveau() {

        Assertions.assertTrue(utils.VerificationNiveau(1, 2, 3, 6));
    }
}