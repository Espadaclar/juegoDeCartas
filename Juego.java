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
 * 
 * 
 * Vamos a pensar ahora que el primer jugador es siempre el humano que interactua con nuestro programa y el resto, jugadores
 * controlados por el ordenador.
 * 
 * -Modificar la clase Juego para que: El constructor admita como segundo parametro el nombre del jugador humano. Además debe mostrar
 * por pantalla un mensaje de bienvenida y el nombre de cada uno de los jugadores de la partida (incluyendo el humano) .
 * 
 * El metodo repartir debe mostrar por pantalla el palo que pinta con un mensaje del tipo "Pintan bastos" o "Pintan oros" y debe
  *devolver el número asociado con el palo que pinta. 
  *
  *Además debe mostrar por pantalla las cartas que recibe el jugador humano.
 *Añadir un método verCartasJugadorHumano que muestre las cartas del jugador humano.
 * Modificar el nombre del metodo verCartasJugador para que pase a llamarse hacerTrampasYVerCartasDeJugador.
 */
public class Juego
{
    //constante para fijar el nº de cartas que ha de recibir cada jugador.
    public static final int NUM_CARTAS = 5;

    private ArrayList<Jugador> jugadores;//--- para almacenar jagadores
    private Mazo mazo;
    private Carta carta; // --------- para almacenar cada una de las cartas que valla recibiendo cada uno de los jugadores ______(en mt 1).
    private String cartaQuePinta; //----------almacena la carta que pinte el jugador que reparta las cartas ______(en mt 1).
    private int numJugadores;
    
    private String jugadorHumano;//nombre del jugador humano.

    //Array para poder elegir nombres  aleatoriamente.
    public static String[] NOMBRES = {"Juán", "Francisco Javier", "Lorenzo", "Israel", "Cristian", "Ricardo", "Emilio", "José Ricardo",
            "Luis Enrique","Luis Federico", "Mario", "Nasrrudín", "José Manuel", "Aquiles", "Merquiades", "Francisco José",
            "Narciso", "Gregorio", "Isidoro", "Raquel", "María", "Milagros", "Eva Carmina", "Jacinta", "Blas", "Fulgencio",
            "Salusitano", "Elena", "Gemma", "Fermín", "Amancio", "Esther", "Ángela"};

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numJugadores, String jugadorHumano)
    {
        //aplico operador alternativa para asegurar un nº de jugadores correcto.
        this.numJugadores = (numJugadores < 3 || numJugadores > 5) ? 4 : numJugadores;
        jugadores = new ArrayList<>();
        mazo = new Mazo();
        carta = null;
        this.jugadorHumano = jugadorHumano;
        cartaQuePinta = "";
        crearJugador(numJugadores);
        
        mostrarBienVenida();//--------------------------da la bien venida a los jugadores.
        mostrarJugadores();//---------------------------- muestra los jugadores.
    }

    /**
     * reparte cartas entre los jugadores -------------------------------------------------------------------- 1
     */
    public void repartir(){
        mazo.barajar();
        int contCartas = 0;
        while(contCartas < NUM_CARTAS){
            int contJugadores = 0;
            while(contJugadores < jugadores.size()){
                carta = mazo.sacarCartaPorDebajo(); //en cada iteración del bucle while saca y elimina una carta del mazo, y la almacena en 'carta'
                jugadores.get(contJugadores).recibirCarta(carta); // cada jugador va recibiendo la carta almacena en 'carta'.
                cartaQuePinta = carta.toString(); // almacena la carta de cada iteración, termina por quedarse con la última, ¡¡la que pinta!!
                contJugadores ++;                
            }            
            contCartas ++;
        }
        System.out.println("Cata que pinta.- " +cartaQuePinta );
    }

    /**
     *muestre por pantalla las cartas de un jugador. Para saber qué jugador mostrar,-------------------------- 2
     * indicamos como parámetro del método el nombre del Jugador.
     */
    public void verCartasJugador(String name){
        int cont = 0;
        boolean encontrado = false;
         System.out.println("================= Cartas de " +name);
        while(cont < jugadores.size() && !encontrado){
            if(jugadores.get(cont).getNombreJugador().equals(name)){
                jugadores.get(cont).verCartasJugador();
                encontrado = true;
            }
            cont ++;
        }
        System.out.println("========== Carta que pinta.-" +cartaQuePinta);
        System.out.println("");
    }
    
    /**
     * muestra las cartas de los jugadores. ------------------------------------------------------------------ 3
     */
    public void muestraCartasDeTodosLosJugadores(){
        int cont = 0;
        int cont1 = 0;
        while(cont < jugadores.size()){
            System.out.println("================= Cartas de " +jugadores.get(cont).getNombreJugador());
            jugadores.get(cont).verCartasJugador();
            System.out.println("");
            cont ++;
        }
        System.out.println("========== Carta que pinta.-" +cartaQuePinta);
        System.out.println("");
    }

    /**
     * crea el nº de jugadores pasados por parámetro, entre 3 y 5, sino creará 4 por defecto, y los 
     * añade a la colección de jugadores. ----------------------------------------------------------------------- 4
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
     * muestra el nombre de los jugadores creados aleatoriamente.---------------------------------------------------- 5
     */
    public void mostrarJugadores(){
        for(int i = 0; i < jugadores.size(); i++){
            System.out.println(jugadores.get(i).getNombreJugador());
        }
    }
    
    /**
     * para dar la bienVenida.
     */
    private void mostrarBienVenida(){
       
            System.out.println("== Bien venidos a la Partida de Julepe \n como jugador humano tenemos a ___________ " +jugadorHumano
                        + "\n sus contrincantes: ");
      
    }
    
}
















