package model;

/**
 *
 * @author Franco
 */
public class ComplejoBinomica {
    // 1. Estructura de complejos en forma binomica
    public static float componenteReal;
    public static float componenteImaginaria;
    
    public ComplejoBinomica (float re,  float im) {
        componenteReal = re;
        componenteImaginaria = im;
    }
    // 2. Funciones set/get
    public static float getComponenteReal () {
        return componenteReal;
    }
    
    public static void setComponenteReal (float re) {
        componenteReal = re;
    }
    
    public static float getComponenteImaginaria () {
        return componenteReal;
    }
    
    public static void setComponenteImaginaria (float im) {
        componenteReal = im;
    }
    // 3. Operaciones basicas

}
