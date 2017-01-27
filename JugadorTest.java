

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JugadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class JugadorTest
{
    private Jugador jugador1;
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Carta carta4;
    private Carta carta5;

    
    
    

    
    
    

    
    

    /**
     * Default constructor for test class JugadorTest
     */
    public JugadorTest()
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
        jugador1 = new Jugador("Juan");
        carta1 = new Carta(1, 0);
        jugador1.verCartasJugador();
        jugador1.recibirCarta(carta1);
        jugador1.verCartasJugador();
        carta2 = new Carta(1, 1);
        jugador1.recibirCarta(carta2);
        jugador1.verCartasJugador();
        carta3 = new Carta(1, 2);
        jugador1.recibirCarta(carta3);
        carta4 = new Carta(1, 3);
        jugador1.recibirCarta(carta4);
        jugador1.verCartasJugador();
        carta5 = new Carta(12, 0);
        jugador1.recibirCarta(carta5);
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
