import java.util.ArrayList;
/**
 * Mazo. El constructor de la clase Mazo debe encargrse de crear las 40 cartas de la baraja española y de dejarlas guardadas de alguna forma.
 */
public class Mazo
{
    // instance variables - replace the example below with your own
    private ArrayList<Carta> baraja;
    private Carta carta;

    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        baraja = new ArrayList<>();
    }

    /**
     *Crea todas las cartas del mazo.
     */
    public void creaMazo()
    {
        int contL = 1;// -------------- para el nº de cartas en cada palo.
        int contC = 0;// -------------- para cadad uno de los palos.
        while( contC < 4 ){
            
            contL = 1;
            while( contL <= 12){
                if(contL == 8){
                    contL = 10;
                }
                carta = new Carta(contL, contC);
                baraja.add(carta);
                contL ++;
            }
            contC ++;
        }
    }

    /**
     * muestra linea a linea todas los nombres de las cartas existentes en el mazo
     */
    public void verCartasDelMazo(){

        for(Carta carta: baraja){
            System.out.println( carta);

        }
    }

    /**
     * Devuelve el tamaño de ArrayList
     */
    public int sizeBaraja(){
        return baraja.size();
    }
}

    
    