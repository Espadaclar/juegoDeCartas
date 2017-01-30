

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CartaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CartaTest
{
    private Carta carta1_Oros;
    private Carta carta1_Copas;
    private Carta carta1_Epadas;
    private Carta carta1_Bastos;
    private Carta carta7_Oros;
    private Carta carta12_Copas;
    private Carta carta3_Espadas;
    private Carta carta11_Bastos;

    /**
     * Default constructor for test class CartaTest
     */
    public CartaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        carta1_Oros = new Carta(1, 0);
        carta1_Copas = new Carta(1, 1);
        carta1_Epadas = new Carta(1, 2);
        carta1_Bastos = new Carta(1, 3);
        carta7_Oros = new Carta(7, 0);
        carta12_Copas = new Carta(12, 1);
        carta3_Espadas = new Carta(3, 2);
        carta11_Bastos = new Carta(11, 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
