package model;

/**
 *
 * @author Franco
 */

import java.lang.Math;

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
    
    public ComplejoPolar potenciaNatural(int exponenete){
        this.modulo = Math.pow(this.modulo,exponenete);
        this.argumento *= exponenete ;
        return this;
    }
    
    public ComplejoPolar radicacionNatural(int indice){
        this.modulo = Math.pow(this.modulo,1/indice);
       // this.argumento = HAY MUCHAS SOLUCIONES, IMPLEMENTACION?;
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
        return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
    }
    
    public double elArcotangenteDe (double re, double im) {
        return Math.atan(re/im);
    }
}
