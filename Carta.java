
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
    private int valorCarta;
    private int paloCarta;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valorCarta, int paloCarta)
    {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
    }

   /**
    * devuelve el valor de la carta.
    */
   public String getValorCarta(){
       String carta = "" + valorCarta;
       if(valorCarta == 1){
           carta = "As " +" ";
       }
       else if(valorCarta == 10){
           carta = "Sota " +" ";
       }
       else if(valorCarta == 11){
           carta = "Caballo " +" ";
       }
       else if(valorCarta == 12){
           carta = "Rey " +" ";
       }
       return carta;
   }
   
   
   
   /**
    * devuelve el palo de la carta.
    */
   public String getPaloCarta(){
       String palo = "";
       if(paloCarta == 0){
           palo = " de oros. ";
       }
       else if(paloCarta == 1){
           palo = " de copas. ";
       }
       else if(paloCarta == 2){
           palo = " de espadas. ";
       }
       else if(paloCarta == 3){
           palo = " de bastos. ";
       }
       return palo;
   } 
   
   /**
    * devuelve el nombre de la carta.
    */
   public String toString(){
       return getValorCarta()+ " " +getPaloCarta() ;
   }
}





