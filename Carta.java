
/**
 *Crear una clase llamada Carta con un constructor que admita dos prametros enteros. 
 *El primer parametro indica el valor de la carta y puede ser desde 1 a 7 o desde 10 a 12. 
 *
 *El segundo, indica el palo de la carta y puede ser de 0 a 4 (0 es oros, 1 es copas, 2 es espadas y 3 es bastos). 
 *
 * Crear el metodo toString que devuelve el nombre de la carta (del tipo "As de oros",
 *"siete de espadas", "caballo de bastos") y los metodos getter de ambos atributos que devuelven enteros.
 */
public class Carta
{
    //valor de la carta de 1 a 7 y de 10 a 12
    private int valorCarta;
    // valor del palo (0 es oros, 1 es copas, 2 es espadas y 3 es bastos).
    private int paloCarta;    

    private int posicionValorCarta; //------------------------------------------------------------ para almacenar el valor de la carta.
    // VALOR_CARTAS almacena en orden descendente las cartas que más valor tienen en el juego del tute.
    public static int[] VALOR_CARTAS = {1, 3, 12, 11, 10, 7, 6, 5, 4, 2};

    private int paloCarta2; //*********** unicamente para poder mostrar en el mt____4 la carta que pinta.
    private boolean cartaSuperior; //******* varía de valor en se mt___4, y también se utilizará en el mt_____4bis.
    private boolean ayudante; // ***si en el mt____4 cambia a true, el mt____4bis muestra un mensaje de cartas repetidas.
    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valorCarta, int paloCarta)
    {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
        posicionValorCarta = 0;// ------------------------------------------------------ para almacenar el valor de la carta

        paloCarta2 = 0;//*********** unicamente para poder mostrar en el mt____4 la carta que pinta.
        cartaSuperior = false; ///******* varía de valor en se mt___4, y también se utilizará en el mt_____4bis.
        ayudante = false;
    }

    /**
     * devuelve el valor de la carta en forma de entero.------------------------------------------------------ 1
     */
    public int getValorCarta(){
        return valorCarta;
    }

    /**
     * devuelve el valor de la carta en forma de entero si es 2, 3, 4, 5, 6 o 7
     * y en forma de String si sota, caballo, rey o as. (10, 11, 12 o 1)     -------------------------------- 1bis 
     */
    public String nombreValorCarta(){
        String carta= String.valueOf(valorCarta);//---- el atributo entero 'valorCarta' lo convertimos a String
        if(valorCarta == 1){
            carta = "as";
        }
        else if(valorCarta == 10){
            carta = "sota";
        }
        else if(valorCarta == 11){
            carta = "caballo";
        }
        else if(valorCarta == 12){
            carta = "rey";
        }
        return carta;
    }

    /**
     * devuelve el valor del palo de la carta en forma de entero; 
     * '0 si es oros, 1 si es copas ....'---------------------------------------------------------------------- 2
     */
    public int getPaloCarta(){
        return paloCarta;
    } 

    /**
     * devuelve el palo de la carta en forma de String. (oros, copas, espadas ..) ----------------------------- 2bis
     */
    public String nombrePaloCarta(){
        String palo= String.valueOf(paloCarta);//---- el atributo entero 'paloCarta' lo convertimos a String.
        if(paloCarta == 0){
            palo = "de oros";
        }
        else if(paloCarta == 1){
            palo = "de copas";
        }
        else if(paloCarta == 2){
            palo = "de espadas";
        }
        else if(paloCarta == 3){
            palo = "de bastos";
        }
        return palo;
    }     

    /**
     * devuelve la posicion que el valor de la carta tiene en el Array VALOR_CARTAS.
     *  esta posición la obtengo en el mt_____4.                     ------------------------------------------ 3
     */
    public int getPosicionValorCarta(){
        return posicionValorCarta;
    }    

    /**
     *  que reciba un parámetro de tipo Carta y un parámetro de tipo entero que indica el palo
     *  que pinta. El método devuelve true en caso de que la carta sea superior a la carta pasada 
     *  como parámetro conforme a las reglas del tute recogidas en la Wikipedia y false en caso 
     *  contrario. No hace falta comprobar que el parámetro sea null o no, se asume que no lo es.-------------- 4
     */
    public boolean ganaA(Carta recibida, int palo){
        //boolean cartaSuperior = false;
        boolean encontrado = false;
        if(recibida != null){
            int recibida2 = recibida.getValorCarta(); //almacena el valor de la carta del parámetro; (1, 2, 3 ..... 12). 

            int cont = 0; //----para conocer la posición que el valor de la carta ocupa en el array VALOR_CARTAS, y para el funcionamiento del while.
            int cont2 = 0;
            while(cont < VALOR_CARTAS.length && !encontrado){
                int aux = VALOR_CARTAS[cont]; // -------------------------almacea el valor del indice del array.
                if(recibida2 == aux){
                    posicionValorCarta = cont; //-------------------almaceno en el atributo posicionValorCarta, el valor de la carta.
                    encontrado = true;
                }            
                cont ++;
            }
            if(recibida.getPaloCarta() == getPaloCarta()){
                if(posicionValorCarta > recibida.getPosicionValorCarta()){
                    cartaSuperior = true;
                }
                else if(posicionValorCarta == recibida.getPosicionValorCarta()){//--getPosicionValorCarta() mt___4
                    System.out.println("Error,");
                    System.out.println("Error, baraja con varias cartas iguales al  " +recibida.toString()+  "  !!!!!!");
                    System.out.println("");
                    ayudante = true;//********** si vale true, el mt___4bis también muestra este mensaje de error.*********
                }
            }
            else if( (recibida.getPaloCarta() != getPaloCarta()) && getPaloCarta() == palo ){
                cartaSuperior = true;
            }
            else if( (recibida.getPaloCarta() != getPaloCarta()) && recibida.getPaloCarta() == palo ){
                cartaSuperior = false;
            }
            else if( (getPaloCarta() != recibida.getPaloCarta())){
                cartaSuperior = true;
            }

            //**************Las siguientes dos líneas de código sirven para poder utilizar el mt_____4bis. nada que ver con el ejercicio de clase.
            //paloCarta2 = palo;//***********--------- paso al atributo paloCarta2 el valor del palo pasado en el parámetro.
            //nombrePaloCarta2();//**********--------  este mt pasa el valor int del palo al nombre del palo (oros, copas ...)mt____55
        }
        return cartaSuperior;
    }

    /**
     * Muestra por pantalla el triunfo, el nombre de dos cartas y cual de ellas gana
     *  conforme a las reglas del tute recogidas en la Wikipedia, también devuelbe un boolean.------------------ 4bis
     */
    public boolean ganaA_EnPantalla(Carta recibida, int palo){
        ganaA( recibida, palo); // ------ invocación al mt____4.
        if(!ayudante){//****esta condición quiere  decir que no tenemos cartas repetidas. ver mt____4 *****
            if(cartaSuperior == true){
                System.out.println("Si el triunfo es.- " +nombrePaloCarta2()+ ".\n la carta " +toString()
                    + " gana a la carta " +recibida.toString()+ ".");
                System.out.println("           ============================");
            }
            else if (cartaSuperior == false){
                System.out.println("Si el triunfo es.- " +nombrePaloCarta2()+ ".\n la carta " + toString()
                    + " __no!! gana a la carta " +recibida.toString()+ "." );
                System.out.println("           ============================");
            }
        }
        System.out.println("");
        return cartaSuperior;
    }

    /**
     * devuelve el nombre de la carta. --------------------------------------------------------------------------- 5
     */
    public String toString(){
        String num = nombreValorCarta();
        String name = nombrePaloCarta();
        return num + " " +name; 
        //return nombreValorCarta()+ " " +nombrePaloCarta() ;
    }

    /**
     * devuelve el palo de la carta en forma de String. (oros, copas, espadas ..)
     * UNICAMENTE PARA PODER MOSTRAR EN PANTALLA EL TRIUNFO EN EL mt_________4      ----------------------------- 55
     */
    private String nombrePaloCarta2(){
        String palo= String.valueOf(paloCarta2);//---- el atributo entero 'paloCarta' lo convertimos a String.
        if(paloCarta2 == 0){
            palo = "de oros";
        }
        else if(paloCarta2 == 1){
            palo = "de copas";
        }
        else if(paloCarta2 == 2){
            palo = "de espadas";
        }
        else if(paloCarta2 == 3){
            palo = "de bastos";
        }
        return palo;
    }     
}

