package model;

public class ComplejoBinomica {
    // 1. Estructura de complejos en forma binomica
    public double componenteReal;
    public double componenteImaginaria;
    
    public ComplejoBinomica () {
        this.componenteReal = 0;
        this.componenteImaginaria = 0;
    }
    
    public ComplejoBinomica (double re,  double im) {
        this.componenteReal = re;
        this.componenteImaginaria = im;
    }
    // 2. Funciones set/get
    public double getComponenteReal () {
        return this.componenteReal;
    }
    
    public void setComponenteReal (double re) {
        this.componenteReal = re;
    }
    
    public double getComponenteImaginaria () {
        return this.componenteImaginaria;
    }
    
    public void setComponenteImaginaria (double im) {
        this.componenteImaginaria = im;
    }
    // 3. Operaciones basicas

    public ComplejoBinomica suma( ComplejoBinomica complejoBin ) {
        this.componenteReal += complejoBin.componenteReal;
        this.componenteImaginaria += complejoBin.componenteImaginaria;
        return this;
    }
    
    public ComplejoBinomica resta( ComplejoBinomica complejoBin ) {
        this.componenteReal -= complejoBin.componenteReal;
        this.componenteImaginaria -= complejoBin.componenteImaginaria;
        return this;
    }

    public ComplejoBinomica complemento( ComplejoBinomica complejoBin ){
        this.componenteImaginaria *= (-1); 
        return this;
    }
 
       
    // 4. Pasajes Polar->Binomica
    public ComplejoBinomica polarABinomica ( ComplejoPolar complejoPol ) {
        this.componenteReal = complejoPol.modulo * Math.cos(complejoPol.argumento);
        this.componenteImaginaria = complejoPol.modulo * Math.sin(complejoPol.argumento);
        return this;
    }
}
