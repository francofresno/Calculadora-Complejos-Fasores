package NCOM_main;

import model.ComplejoBinomica;
import model.ComplejoPolar;
import view.MainGUI;


public class Main {
    public static void main(String[] args) {   
              
        
        ComplejoBinomica cb = new ComplejoBinomica(2,4);
        ComplejoPolar cp = new ComplejoPolar();
        cp . potenciaNatural(2) . binomicaAPolar(cb);  
        
        ComplejoPolar cpp = new ComplejoPolar();
        cpp.binomicaAPolar(cb);
        cpp.potenciaNatural(2);
        
        
        System.out.println(cp.modulo);
        System.out.println(cp.argumento);
                
        System.out.println(cpp.modulo);
        System.out.println(cpp.argumento);

        
       // new MainGUI().setVisible(true);     
    }

}
