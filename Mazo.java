import java.util.ArrayList;
import java.util.Random;
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
        creaMazo();
    }

    /**
     *Crea todas las cartas del mazo.
     */
    private void creaMazo()
    {
        int contL = 1;// -------------- para el nº total de cartas en cada palo.
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
     * consiga mezclar las cartas existentes en ese momento en el mazo.
     */
    public void barajar(){
        Random ale = new Random();
        Carta carta = null;//------------------------------ almacenará la carta que cambiamos de lugar.
        int cont = 0; // ---------------------------------- facilita el uso del bucle while.
        int cont2 = ale.nextInt(352) + baraja.size(); //---- nº aleatorio del total de cartas que se cambiarán de lugar. entre 40 y 391.
        while(cont < cont2){            
            int valor = ale.nextInt(baraja.size());//------- nuevo aleatorio para selecionar una de las cartas de la baraja.
            carta = baraja.remove(valor); //------------------- almaceno la carta eliminada en la VL carta.
            baraja.add(carta);  // ------------------------- pongo nuevamente la carta en la última posición del ArrayList.
            cont ++; // ------el proceso se repite hasta que cont sea igual al valor aleatorio de 'cont2'.
        }        
        //cortar();// ------------ después de haber embarajado, cortamos¡¡¡
    }

    /**
     * después de barajar se corta.
     */
    public void cortar(){
        Random ale = new Random();
        int val = ale.nextInt(25) +7; //nº aleatorio entre 6 y 31. (todas las cartas que estén por encima de la posición que marque
                                    // este nº aleatrio, forman un paquete que pasará a estar colocado debajo de la carta de abajo. )
        int cont = baraja.size();
        for(int i = 0 ; i < val; i ++){
            Carta carta = null;
            carta = baraja.remove(0);
            baraja.add(carta);
        }
    }

    /**
     * devuelva un objeto Carta. Concretamente debe devolver la primera carta del mazo, eliminando esta del mazo.
     */
    public Carta sacarCartaPorDebajo(){
        Carta carta = null;
        if(baraja.size() != 0){
            carta = baraja.get(0);
            baraja.remove(0);
           // System.out.println(carta);
        }
        return carta;
    }
    
    /**
     * devuelva un objeto Carta. Concretamente debe devolver la primera carta del mazo, eliminando esta del mazo.
     */
    public Carta sacarCartaPorEncima(){
        Carta carta = null;
        int numCarta = (baraja.size()) -1;
        if(baraja.size() != 0){
            carta = baraja.get(numCarta);
            baraja.remove(numCarta);
           // System.out.println(carta);
        }
        return carta;
    }

    /**
     * muestra linea a linea todas los nombres de las cartas existentes en el mazo
     */
    public void verCartasDelMazo(){
        int cont = 1;
        for(Carta carta: baraja){
            System.out.println( cont+ ".-  " +carta);
            cont ++;
        }
    }

    /**
     * Devuelve el tamaño de ArrayList
     */
    public int sizeBaraja(){
        return baraja.size();
    }
}

    