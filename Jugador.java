import java.util.Random;
/**
 * Añadir la clase Jugador que permita a un jugador identificado por un nombre (en formato String) ser capaz de tener
 * hasta 5 cartas. El constructor debe admitir el nombre del jugador como parámetro. Además debe haber un método llamado
 * recibirCarta que permita un parametro de tipo Carta y un método llamado verCartasJugador que imprima por pantalla las
 * cartas del jugador, una por linea, y que funcione tenga las cartas que tenga.
 */
public class Jugador
{
    private String name;
    private  Carta[] cartasJugador;
    private int cont33; // controla el while del mt jugarCartaAleatoria()(mt nº__________4)
   // private int cont44; // controla el while del mt jugaCarta()(mt nº__________3)

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String name)
    {
        this.name = name;
        cartasJugador = new Carta[5];
        cont33 = 0;
       // cont44 = 0;
    }

    /**
     * para que el jugador reciba una carta por parámetro.-------------------------------------------------- 1
     */
    public void recibirCarta(Carta carta){
        int cont = 0;
        boolean encontrado = false;
        while(cont < cartasJugador.length && !encontrado){
            if(cartasJugador[cont] == null){
                cartasJugador[cont] = carta;
                encontrado = true;
            }
            cont ++;
        }
    }

    /**
     * muestra las cartas del jugador.  -------------------------------------------------------------------- 2
     */
    public void verCartasJugador(){
        for(int i = 0; i < cartasJugador.length; i ++){
            if(cartasJugador[i] != null){
                System.out.println( " " +cartasJugador[i]);
            }
        }
        System.out.println("=================");
        System.out.println("");
    }

    /**
     * tirarCarta. Admite un parámetro String que indica el nombre de la carta a tirar. El método
     * muestra por pantalla el nombre  la carta tirada. Devuelve la carta tirada.--------------------------  3
     * En caso de que el jugador no tenga cartas o de que el nombre especificado como
     * parámetro no coincida con ninguna carta, devuelve null
     */
    public Carta juegaCarta(String nameCarta){
        Carta cartaJugada = null;
        int cont = 0;
        boolean encontrado = false;
        while(cont < cartasJugador.length && !encontrado){
            cartaJugada = cartasJugador[cont];//---almaceno en la VL el valor que el Arrays tiene en cada iteración.
            //---- paso a comprobar si ese valor no e null, y si su valor es el mismo que el valor del parámetro nameCarta.
            if(cartaJugada != null && cartaJugada.toString().equals(nameCarta)){
                cartaJugada = cartasJugador[cont];// ----------- entonces almaceno el valor.
                cartasJugador[cont] = null;    //---------------  pongo la posición a null.
                encontrado = true;// --------------------------- el bucle while finaliza.
            }
            cont ++;
        }
       // System.out.println(cartaJugada);
        return cartaJugada;
    }

    /**
     * tirarCartaAleatoria. El método muestra por pantalla  la carta tirada. Devuelve -------------------- 4
     * la carta tirada. En caso de que el jugador no tenga cartas, devuelve null.
     */
    public Carta jugarCartaAleatoria(){
        Random ale = new Random();       
        Carta cartaJugada = null;
        boolean encontrado = false;
        while(cont33 < cartasJugador.length && !encontrado && cartasJugador.length > 0){ 
            int cartaAleatoria = ale.nextInt(cartasJugador.length);
            if(cartasJugador[cartaAleatoria] != null ){
                cartaJugada = cartasJugador[cartaAleatoria];
                cartasJugador[cartaAleatoria] = null;
                encontrado = true;
                cont33 ++;
            }
        }
        System.out.println("===== Carta aleatoria");        
        System.out.println(cartaJugada);
        return cartaJugada;
    }

    /**
     * devuelve la carta del jugador que está en el índice pasado como parámetro. ---------------------------55555 55555555555
     */
    public Carta cartaJ(int indiceCarta){
        Carta carta = null;
        carta = cartasJugador[indiceCarta];
        return carta;
    }
    
    /**
     * pone un elemento del array en null.                                   ---------------------------55555 55555555555
     */
    public void poneElementoANull(int indiceCarta){
        cartasJugador[indiceCarta] = null;
    }
    
    /**
     * retorna el nombre del jugador. -------------------------------------------------------------------- 44
     */
    public String getNombreJugador(){
        return name;
    }
}


