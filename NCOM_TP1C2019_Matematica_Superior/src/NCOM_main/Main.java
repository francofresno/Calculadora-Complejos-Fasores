package NCOM_main;

import model.ComplejoBinomica;
import model.ComplejoPolar;

/**
 *
 * @author Franco
 */
public class Main {
    public static void main(String[] args) {
        
        // PRUEBAS
        ComplejoPolar a = new ComplejoPolar();
        ComplejoBinomica b = new ComplejoBinomica(1,-1);
        
        a=a.binomicaAPolar(b);
        a=a.potenciaNatural(5);
        b=b.polarABinomica(a);
                
        System.out.println(b.componenteReal);
        System.out.println(b.componenteImaginaria);

    }

}
