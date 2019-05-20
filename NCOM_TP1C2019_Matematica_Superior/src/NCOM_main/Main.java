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
        
        ComplejoBinomica b = new ComplejoBinomica (3,4);
        ComplejoPolar p = new ComplejoPolar ();
        p=p.binomicaAPolar(b);
        
        System.out.println(b.componenteReal);
        System.out.println(Math.atan2(4,3));
        System.out.println(p.modulo);
        System.out.println(p.argumento);
        
        System.out.println(cp.modulo);
        System.out.println(cp.argumento);
                
        System.out.println(cpp.modulo);
        System.out.println(cpp.argumento);

        
        new MainGUI().setVisible(true);     
    }

}
