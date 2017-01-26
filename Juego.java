import java.util.ArrayList;
/**
 * En el constructor de Juego se crean tantos jugadores como se especifiquen por parametro y un mazo. Sabemos que nunca
 * se van a especificar menos de 3 ni más de 5 jugadores.
 * 
 * Los nombres de los jugadores deben ser asignados de forma aleatoria entre un conjunto de nombres (dos jugadores no 
 * pueden tener el mismo nombre).
 * 
 * Implementar en esa clase un método llamado repartir que coja el mazo y de 5 cartas a los jugadores creados. La entrega de 
 * cartas debe ser al estilo del reparto que se hace en la realidad, es decir, primero se baraja y luego se entrega una carta
 * a cada jugador. La última carta entregada indica el palo que pinta, que debe registrarse de alguna foma.
 * 
 * Implementa un método llamado verCartasJugador que muestre por pantalla las cartas de un jugador. Para saber qué jugador mostrar,
 * indicamos como parámetro del método el nombre del Jugador.
 */
public class Juego
{
    private ArrayList<Jugador> jugador;// para almacenar jagadores
    private Mazo mazo;
    private int numJugadores;
    
    //Array para poder elegir nombres  aleatoriamente.
    public static String[] NOMBRES = {"Juán", "Francisco Javier", "Lorenzo", "Israel", "Cristian", "Ricardo", "Emilio", "José Ricardo",
            "Luis Enrique","Luis Federico", "Mario", "Nasrrudín", "José Manuel", "Aquiles", "Merquiades", "Francisco José",
            "Narciso", "Gregorio", "Isidoro", "Raquel", "María", "Milagros", "Eva Carmina", "Jacinta", "Blas", "Fulgencio",
            "Salusitano", "Elena", "Gemma", "Fermín", "Amancio", "Esther", "Ángela"};

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numJugadores)
    {
        this.numJugadores = (numJugadores < 3 || numJugadores > 5) ? 4 : numJugadores;
        jugador = new ArrayList<>();
        mazo = new Mazo();
    }

}
