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
        ComplejoBinomica b = new ComplejoBinomica(0,2);
        
        a.binomicaAPolar(b);
        
        System.out.println(a.modulo);
        System.out.println(a.argumento);

    }

}
