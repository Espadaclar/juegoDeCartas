import java.util.ArrayList;
import java.util.Random;
/**
 * Modificar la clase Jugador para que:
 *- Exista un nuevo método que sea tirarCarta. Admite un parámetro String que indica el nombre de la carta a tirar. El método
 * muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada. Devuelve la carta tirada. En caso de 
 * que el jugador no tenga cartas o de que el nombre especificado como parámetro no coincida con ninguna carta, devuelve null.
 * 
 *- Exista un nuevo método que sea tirarCartaAleatoria. El método muestra por pantalla el nombre del jugador que ha tirado la 
 *carta y la carta tirada. Devuelve la carta tirada. En caso de que el jugador no tenga cartas, devuelve null.
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

        Jugador jugador2 = new Jugador(jugadorHumano);
        jugadores.add(jugador2);//----------------añado el nuevo jugador a la colección de jugadores, será el 1º de la colección.
        carta = null;
        this.jugadorHumano = jugadorHumano;
        cartaQuePinta = "";
        crearJugador(numJugadores); //-----------------(mt___4)

        mostrarBienVenida();//--------------------------da la bien venida a los jugadores y muestra todos sus mombres. (mt_____6)
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
        System.out.println("Carta que pinta.- " +cartaQuePinta );
        System.out.println("");
    }

    /**
     *muestre por pantalla las cartas de un jugador. Para saber qué jugador mostrar,-------------------------- 2
     * indicamos como parámetro del método el nombre del Jugador.
     */
    public void hacerTrampasYVerCartasDeJugador(String name){
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
     *  que muestre las cartas del jugador humano.-------------------------------------------------------------- 3b
     */
    public void verCartasJugadorHumano(){
        hacerTrampasYVerCartasDeJugador(jugadorHumano);
    }

    /**
     * crea el nº de jugadores pasados por parámetro, entre 3 y 5, sino creará 4 por defecto, y los 
     * añade a la colección de jugadores. ----------------------------------------------------------------------- 4
     */
    private void crearJugador(int numJ){
        if(numJ < 3 || numJ > 5){
            numJ = 4;
        }
        int cont = 1;
        Random ale2 = new Random();        
        while(cont < numJ ){
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
        System.out.println("========== Name all player.");
        for(int i = 0; i < jugadores.size(); i++){
            System.out.println(jugadores.get(i).getNombreJugador());
        }
        System.out.println("");
    }

    /**
     * El método
     * muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada.---------666666666666666666666 6
     * Devuelve la carta tirada. En caso de que el jugador no tenga cartas o de que el nombre
     * especificado como parámetro no coincida con ninguna carta, devuelve null
     */
    public Carta tirarCarta(String nameCarta){
        Carta cartaTirada = null;//----- en cada iteración almacena cada una de las cartas de todos los jugadores.
        Carta cartaTirada2 = null;// --- almacena la carta que tira el jugador, o null si no tiene cartas o no existe esa carta.
        int cont = 0;       //---------- para el 1 bucle while.
        boolean encontrado = false; //-- cuando encontrado valga true, el bucle while deja de iterar.
        String nameJugadores = "";  //-- almacena el nombre del jugador que tine la carta pasada por parámetro.

        while(cont < jugadores.size() && !encontrado){
            int cont2 = 0;

            while(cont2 < 5  && !encontrado ){
                //cartaTirada almacena una carta diferente en cada iteración, empezando por la primer carta del 1º jugador.
                cartaTirada = jugadores.get(cont).cartaJ(cont2);
                //en el if comparamos la carta almacenada con la carta pasada en el parámetro nameCarta.
                if(cartaTirada != null && cartaTirada.toString().equals(nameCarta)){
                    //si la carta existe y el jugador tenía cartas, la carta queda almacenada en cartaTirada2.
                    cartaTirada2 = jugadores.get(cont).cartaJ(cont2);;
                    //elimino la carta tirada por el jugador, quedandose este con una menos.
                    jugadores.get(cont).poneElementoANull(cont2);
                    nameJugadores = jugadores.get(cont).getNombreJugador();
                    encontrado = true;
                }
                cont2 ++;
            }
            cont ++;
        }
        if(cartaTirada != null && cartaTirada.toString().equals(nameCarta)){
            System.out.println("Carta jugada por " +nameJugadores+ "\n ===============  " +cartaTirada.toString());
            System.out.println("");
        }
        return cartaTirada2;
    }

    /**
     * para dar la bienVenida. ---------------------------------------------------------------------------------------- 66
     */
    private void mostrarBienVenida(){

        System.out.println("== Bien venidos a la Partida de Julepe \n como jugador humano tenemos a ___________ " +jugadorHumano);
        System.out.println("");
        mostrarJugadores();
    }

}
