
import java.util.ArrayList;
import java.util.Random;

/**
 *franciscoJavier
 */
class Apuestas {
    private ArrayList<String> apuesta;

    public Apuestas() {
        apuesta = new ArrayList<String>();
        cargarBombo(); //----------------------- cargamos los 49 nº automáticamente.
    }
    
    /**
     * metodo para cargar el ArrayList con los nº que entran en el bombo.
     */
    private void cargarBombo(){
        for(int i = 1; i < 50; i ++){
            String num= String.valueOf(i);// ---en la VL num almacen los nº enteros, pasado a String.
            apuesta.add(num);
        }
    }
    
    /**
     * mt para generar las apuestas.
     */
    public void agitarBombo(){
        
        Random ale = new Random();
        int num = ale.nextInt(777) +49; // --------- nºde veces que se elige un nº al azar y se coloca en última posición.
        int cont = 0;  // ---------------- para el funcionamiento del bucle while.
        
        while(cont < num){
            int valor = ale.nextInt(apuesta.size());// es uno de los 49 nº elegido aleatoriamente.
            String num2 = null;// --------------almacenará un nº eliminado aleatoriamente del ArrayList.
            num2 = apuesta.remove(valor);
            apuesta.add(num2);
            cont ++;
        }
    }
    
     /**
     * para crear el nº de apuestas que el usuario desee hacer y mostrarlas por pantalla.
     */
    public void presentarBoleto(int numApuestas){
        for(int i = 0; i < numApuestas; i ++){
            agitarBombo();// ----------------- cada vez que realizo una apuesta, descolocó las bolas nuevamente.
            System.out.println(" =========== Apuesta nº.- " +(i));
            for(int num = 0; num < 6; num ++){//----------el bucle itera 6 veces, la cantidad de nº de cada apuesta.
                System.out.println(apuesta.get(num));
            }
            System.out.println("");
        }
    
    }
    
    /**
     * muestra los nº.
     */
    public void mostrarNumeros(){
        int cont = 1;
        for(String numeros: apuesta){
            System.out.println( cont+ ".-  " +numeros);
            cont ++;
        }
    }
    
}