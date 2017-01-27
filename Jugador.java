
/**
 * Añadir la clase Jugador que permita a un jugador identificado por un nombre (en formato String) ser capaz de tener
 * hasta 5 cartas. El constructor debe admitir el nombre del jugador como parámetro. Además debe haber un método llamado
 * recibirCarta que permita un parametro de tipo Carta y un método llamado verCartasJugador que imprima por pantalla las
 * cartas del jugador, una por linea, y que funcione tenga las cartas que tenga.
 */
public class Jugador
{
    private String name;
    private Carta[] cartasJugador;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String name)
    {
        this.name = name;
        cartasJugador = new Carta[5];
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
     * muestra las cartas del jugador.  ------------------------------------------------------------------ 2
     */
    public void verCartasJugador(){
        for(int i = 0; i < cartasJugador.length; i ++){
            if(cartasJugador[i] != null){
                System.out.println( " " +cartasJugador[i]);
            }
        }
    }

    /**
     * tirarCarta. Admite un parámetro String que indica el nombre de la carta a tirar. El método
     * muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada. Devuelve la carta tirada.
     * En caso de que el jugador no tenga cartas o de que el nombre especificado como parámetro no coincida con
     * ninguna carta, devuelve null
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
        System.out.println(cartaJugada);
        return cartaJugada;
    }
    
    /**
     * retorna el nombre del jugador. -------------------------------------------------------------------- 44
     */
    public String getNombreJugador(){
        return name;
    }
}








