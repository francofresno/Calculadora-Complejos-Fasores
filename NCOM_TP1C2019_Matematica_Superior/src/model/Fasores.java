package model;

public class Fasores extends ComplejoPolar{
    // 1. Estrucutra fasores
    public double amplitud;
    public double fase;
    public double frecuencia;
    
    public Fasores() {
        this.amplitud = 0;
        this.fase = 0;
        this.frecuencia = 0;
        this.argumento = 0;
        this.modulo = 0;
    }
    
    public Fasores(double amp, double fase, double frec) {
        this.amplitud = amp;
        this.fase = fase;
        this.frecuencia = frec;
        this.argumento = 0;
        this.modulo = 0;
    }
    
    // 2. Funciones set/get
    public double getAmplitud () {
        return this.amplitud;
    }
    
    public void setAmplitud (double amp) {
        this.amplitud = amp;
    }
    
    public double getFase () {
        return this.fase;
    }
    
    public void setFase (double fase) {
        this.fase = fase;
    }
    
    public double getFrecuencia () {
        return this.frecuencia;
    }
    
    public void setFrecuencia (double frec) {
        this.frecuencia = frec;
    }
    // 3. Funcion de suma de fasores
    
    public Fasores sumarFasores (Fasores f, Fasores g) {
        double parteRealDeSuma = f.amplitud*Math.cos(f.fase) + g.amplitud*Math.cos(g.fase);
        double parteImaginariaDeSuma = f.amplitud*Math.sin(f.fase) + g.amplitud*Math.sin(g.fase);
        double frec = f.frecuencia;
        
        ComplejoBinomica cBin = new ComplejoBinomica(parteRealDeSuma,parteImaginariaDeSuma);
        ComplejoPolar cPol = new ComplejoPolar();
        
        cPol.binomicaAPolar (cBin);
        
        this.argumento = cPol.argumento;
        this.modulo = cPol.modulo;
        this.frecuencia = frec;
        
        return this;
    }
    
    // Resuelve siempre con la parte Real, por eso si viene un fasor con un sin(...), suma Pi/2 
    // para convertirlo en cos
    public Fasores arreglarFase (Fasores f) {
        f.fase = f.fase + (Math.PI/2);
        return f;
    }
    
}