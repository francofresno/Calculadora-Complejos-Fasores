package model;

/**
 *
 * @author Franco
 */
public class ComplejoPolar {
    // 1. Estructura de complejos en forma polar
    public double modulo;
    public double argumento;
    
    public ComplejoPolar () {
        this.modulo = 0;
        this.argumento = 0;
    }
    
    public ComplejoPolar(double mod, double arg) {
        this.modulo = mod;
        this.argumento = arg;
    }
    
    // 2. Funciones set/get
    public double getModulo () {
        return this.modulo;
    }
    
    public void setModulo (double mod) {
        this.modulo = mod;
    }
    
    public double getArgumento () {
        return this.argumento;
    }
    
    public void setArgumento (double arg) {
        this.argumento = arg;
    }
    
    // 3. Operaciones avanzadas
    public ComplejoPolar producto( ComplejoPolar complejoPol ) {
        this.modulo *= complejoPol.modulo;
        this.argumento += complejoPol.argumento;
        return this;
    }

    public ComplejoPolar cociente( ComplejoPolar complejoPol ) {
        this.modulo *= 1/complejoPol.modulo;
        this.argumento -= complejoPol.argumento;
        return this;
    }
    
    // 4. Funcion de pasaje polar->binomica
    public ComplejoPolar binomicaAPolar (ComplejoBinomica complejoBin) {
        this.modulo = elModuloDe(complejoBin.componenteReal,complejoBin.componenteImaginaria);
        
        if (complejoBin.componenteReal != 0) {
            this.argumento = Math.toRadians( elArcotangenteDe(complejoBin.componenteReal,complejoBin.componenteImaginaria) );
        } else {
            this.argumento = (Math.PI)/2;
        }
        
        return this;
    }
    
    public double elModuloDe (double re, double im) {
        return Math.sqrt(elCuadradoDe(re) + elCuadradoDe(im));
    }
    
    public double elCuadradoDe (double num) {
        return Math.pow(num, 2);
    }
    
    public double elArcotangenteDe (double re, double im) {
        return Math.atan(re/im);
    }
}
