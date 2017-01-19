
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCarta.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCarta
{
    /**
     * Default constructor for test class TestCarta
     */
    public TestCarta()
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

    @Test
    public void test01()
    {
        Carta carta1 = new Carta(1, 0);
        assertEquals("as de oros", carta1.toString());
        Carta carta2 = new Carta(2, 0);
        assertEquals("2 de oros", carta2.toString());
        Carta carta3 = new Carta(5, 0);
        assertEquals("5 de oros", carta3.toString());
        Carta carta4 = new Carta(10, 0);
        assertEquals("sota de oros", carta4.toString());
        Carta carta5 = new Carta(11, 0);
        assertEquals("caballo de oros", carta5.toString());        
        Carta carta6 = new Carta(12, 0);
        assertEquals("rey de oros", carta6.toString());      
        
        Carta carta10 = new Carta(1, 1);
        assertEquals("as de copas", carta10.toString());
        Carta carta20 = new Carta(2, 1);
        assertEquals("2 de copas", carta20.toString());
        Carta carta30 = new Carta(5, 1);
        assertEquals("5 de copas", carta30.toString());
        Carta carta40 = new Carta(10, 1);
        assertEquals("sota de copas", carta40.toString());
        Carta carta50 = new Carta(11, 1);
        assertEquals("caballo de copas", carta50.toString());        
        Carta carta60 = new Carta(12, 1);
        assertEquals("rey de copas", carta60.toString());  
        
        Carta carta11 = new Carta(1, 2);
        assertEquals("as de espadas", carta11.toString());
        Carta carta21 = new Carta(2, 2);
        assertEquals("2 de espadas", carta21.toString());
        Carta carta31 = new Carta(5, 2);
        assertEquals("5 de espadas", carta31.toString());
        Carta carta41 = new Carta(10, 2);
        assertEquals("sota de espadas", carta41.toString());
        Carta carta51 = new Carta(11, 2);
        assertEquals("caballo de espadas", carta51.toString());        
        Carta carta61 = new Carta(12, 2);
        assertEquals("rey de espadas", carta61.toString());  
        
        Carta carta12 = new Carta(1, 3);
        assertEquals("as de bastos", carta12.toString());
        Carta carta22 = new Carta(2, 3);
        assertEquals("2 de bastos", carta22.toString());
        Carta carta32 = new Carta(5, 3);
        assertEquals("5 de bastos", carta32.toString());
        Carta carta42 = new Carta(10, 3);
        assertEquals("sota de bastos", carta42.toString());
        Carta carta52 = new Carta(11, 3);
        assertEquals("caballo de bastos", carta52.toString());        
        Carta carta62 = new Carta(12, 3);
        assertEquals("rey de bastos", carta62.toString());         
    }
}