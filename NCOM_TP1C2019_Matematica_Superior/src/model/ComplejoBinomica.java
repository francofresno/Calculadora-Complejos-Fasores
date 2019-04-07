package model;

/**
 *
 * @author Franco
 */
public class ComplejoBinomica {
    // 1. Estructura de complejos en forma binomica
    public float componenteReal;
    public float componenteImaginaria;
    
    public ComplejoBinomica () {
    }
    
    public ComplejoBinomica (float re,  float im) {
        this.componenteReal = re;
        this.componenteImaginaria = im;
    }
    // 2. Funciones set/get
    public float getComponenteReal () {
        return this.componenteReal;
    }
    
    public void setComponenteReal (float re) {
        this.componenteReal = re;
    }
    
    public float getComponenteImaginaria () {
        return this.componenteImaginaria;
    }
    
    public void setComponenteImaginaria (float im) {
        this.componenteImaginaria = im;
    }
    // 3. Operaciones basicas

}
