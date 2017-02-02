import java.util.ArrayList;
/**
 * Crear una clase Baza que (haz un commit por cada punto):
 *- Tenga un constructor que admita dos parametros. El primero es un entero que indica el número de jugadores que van a tirar carta
 *y el segundo es otro entero que indica el palo que pinta.
 *
 *- Tenga un método llamado addCarta que admita un parámetro de tipo Carta y un segundo parámetro de tipo String. El primer parámetro
 *-representa la carta que tira un jugador a la mesa y que, por tanto, se añade a la baza. No hace falta comprobar que la carta 
 *añadida sea o no null, se supone que es una carta. El segundo parámetro indica el nombre del jugador que tiro la carta. El método
 *no devuelve nada. 
 *
 *Tenga un método llamado getPaloPrimeraCartaDeLaBaza sin parámetros que devuelva un entero que representa el palo
 *de la primera carta añadida a la baza o -1 en caso de que no se haya añadido aún ninguna carta.
 *
 *- Tenga un método llamado cartaQueVaGanandoLaBaza sin parámetros que devuelva un objeto Carta. Este objeto carta es la carta 
 *que va ganando la baza conforme a las normas del julepe. En caso de que la baza este vacía este método devuelve null.
 *
 *- Tenga un método llamado nombreJugadorQueVaGanandoLaBaza que no admite parámetros y que devuelve el nombre del jugador 
 *que va ganando la baza en el momento actual.
 */
public class Baza
{

    private int numJugadores;//indica el número de jugadores que van a tirar carta
    private int pintaPalo;  // indica el palo que pinta
    private ArrayList<Carta> cartasDeLaBaza; // almacena las cartas de la baza.

    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numJugadores, int pintaPalo)
    {
        this.numJugadores = numJugadores; //indica el número de jugadores que van a tirar carta
        this.pintaPalo = pintaPalo; // indica el palo que pinta.

        cartasDeLaBaza = new ArrayList<>();
    }

    /**
     *admite un parámetro de tipo Carta y un segundo parámetro de tipo String. El primer parámetro
     *-representa la carta que tira un jugador a la mesa y que, por tanto, se añade a la baza.
     * No hace falta comprobar que la carta 
     *añadida sea o no null, se supone que es una carta. El segundo parámetro indica el
     * nombre del jugador que tiro la carta. El método no devuelve nada. ------------------------------------------------------ 1
     */
    public void addCarta(Carta cartaDelJugador, String nombreJugador){
        Jugador jugador = new Jugador(nombreJugador);
        cartasDeLaBaza.add(cartaDelJugador);
    }

    /**
     * devuelva un entero que representa el palo de la primera carta añadida a la baza o -1
     * en caso de que no se haya añadido aún ninguna carta. -------------------------------------------------------------------- 2
     */
    public int getPaloPrimeraCartaDeLaBaza(){
        int palo = -1;
        if(!cartasDeLaBaza.isEmpty()){
            palo = cartasDeLaBaza.get(0).getPaloCarta();
        }

        return palo;
    }

    /**
     *devuelva un objeto Carta. Este objeto carta es la carta que va ganando la baza conforme a las normas del julepe.
     * En caso de que la baza este vacía este método devuelve null.
     */
    public Carta cartaQueVaGanandoLaBaza(){
        Carta cartaB = null;
        int cont = 0;
		int cont2 = 1;
        while( cont < cartasDeLaBaza.size() -1 && !cartasDeLaBaza.isEmpty()){	
            //si la condición devuelve true es porque la primera carta de la colección gana a
            // la cartaB, entonces almaceno la 1º carta del Array en al VL cartaB		           
			if(cartasDeLaBaza.get(cont).ganaA(cartasDeLaBaza.get(cont2), pintaPalo)){
                cartaB = cartasDeLaBaza.get(cont);
            }
			else{
				cartaB = cartasDeLaBaza.get(cont +1);
			}
            cont ++;
            cont2++;
        }
        return cartaB;
    }

    /**
     * recorre el ArrayList para comprobar datos ------------------------------------------------------------------------------- 44
     */
    public void mostrarCartasBazas(){
        int cont = 0;
        while(cont < cartasDeLaBaza.size()){
            System.out.println(cartasDeLaBaza.get(cont).toString());
            cont ++;
        }
    }
}



