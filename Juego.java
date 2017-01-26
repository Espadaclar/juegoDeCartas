import java.util.ArrayList;
import java.util.Random;
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
    private ArrayList<Jugador> jugadores;// para almacenar jagadores
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
        //aplico operador alternativa para asegurar un nº de jugadores correcto.
        this.numJugadores = (numJugadores < 3 || numJugadores > 5) ? 4 : numJugadores;
        jugadores = new ArrayList<>();
        mazo = new Mazo();
        crearJugador(numJugadores);
       
    }

    /**
     * crea el nº de jugadores pasados por parámetro, entre 3 y 5, sino creará 4 por defecto, y los añade a la colección de jugadores.
     */
    private void crearJugador(int numJ){
        if(numJ < 3 || numJ > 5){
            numJ = 4;
        }
        int cont = 0;
        Random ale2 = new Random();
        while(cont < numJ){
            int aux = ale2.nextInt(NOMBRES.length);  //aux guarda un nº aleatorio entre 0 y el tamaño de NOMBREs[]          
            if(NOMBRES[aux] != null){    //si  esa posición del Array no es null.
                Jugador jugador = new Jugador(NOMBRES[aux]); // creo el jugador con el nombre que el array tiene en esa posición.
                jugadores.add(jugador); //añado el jugador creado a la colección de jugadores.
                NOMBRES[aux] = null;    // y pogo la posición del array a null, con el fin de que no se repitan nombres en la partida.
            }
            else{          // en caso de que la posición valga null descuento 1 al contador, para poder crear el nº de jugadores
                cont --;  //  señalados en el parámetro numJ.(sino cont contaría sin haberse creado el jugador.)
            }
            cont ++;
        }
    }

    /**
     * muestra el nombre de los jugadores creados aleatoriamente.
     */
    public void mostrarJugadores(){
        for(int i = 0; i < jugadores.size(); i++){
            System.out.println(jugadores.get(i).getNombreJugador());
        }
    }
}



