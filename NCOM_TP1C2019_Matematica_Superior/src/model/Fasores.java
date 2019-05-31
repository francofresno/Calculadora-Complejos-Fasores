package model;

public class Fasores extends ComplejoPolar{
    // 1. Estrucutra fasores
    public double amplitud;
    public double desplazamiento;
    public double fase;
    
    public Fasores() {
        this.amplitud = 0;
        this.desplazamiento = 0;
        this.fase = 0;
    }
    
    public Fasores(double amp, double desplazamiento, double fase) {
        this.amplitud = amp;
        this.desplazamiento = desplazamiento;
        this.fase = fase;
    }
    
    // 2. Funciones set/get
    public double getAmplitud () {
        return this.amplitud;
    }
    
    public void setAmplitud (double amp) {
        this.amplitud = amp;
    }
    
    public double getDesplazamiento () {
        return this.desplazamiento;
    }
    
    public void setDesplazamiento (double desplazamiento) {
        this.desplazamiento = desplazamiento;
    }
    
    public double getFase () {
        return this.fase;
    }
    
    public void setFase (double fase) {
        this.fase = fase;
    }
    // 3. Funcion de suma de fasores
    
    public Fasores sumarFasores (Fasores f, Fasores g) {
        double parteRealDeSuma = f.amplitud*Math.cos(f.desplazamiento) + g.amplitud*Math.cos(g.desplazamiento);
        double parteImaginariaDeSuma = f.amplitud*Math.sin(f.desplazamiento) + g.amplitud*Math.sin(g.desplazamiento);
        double fase = f.fase;
        
        ComplejoBinomica cBin = new ComplejoBinomica(parteRealDeSuma,parteImaginariaDeSuma);
        ComplejoPolar cPol = new ComplejoPolar();
        
        cPol.binomicaAPolar (cBin);
        
        this.argumento = cPol.argumento;
        this.modulo = cPol.modulo;
        this.fase = fase;
        
        return this;
    }
    
    // Resuelve siempre con la parte Real, por eso si viene un fasor con un sin(...), suma Pi/2 
    // para convertirlo en cos
    public Fasores pasarACoseno (Fasores f) {
        f.desplazamiento = f.desplazamiento + (Math.PI/2);
        return f;
    }
    
}