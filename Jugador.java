
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
     * para que el jugador reciba una carta por parámetro.
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
     * muestra las cartas del jugador.
     */
    public void verCartasJugador(){
        for(int i = 0; i < cartasJugador.length; i ++){
            System.out.println( " " +cartasJugador[i]);
        }
    }
    
}

















