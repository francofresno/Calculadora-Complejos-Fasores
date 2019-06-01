package model;

public class Fasores extends ComplejoPolar{
    // 1. Estrucutra fasores
    public double amplitud;
    public double desplazamiento;
    public double fase;
    public char trig;
    
    public Fasores() {
        this.amplitud = 0;
        this.desplazamiento = 0;
        this.fase = 0;
        this.trig = 'c';
    }
    
    public Fasores(double amp, double desplazamiento, double fase,char trig) {
        this.amplitud = amp;
        this.desplazamiento = desplazamiento;
        this.fase = fase;
        this.trig = trig;
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
    
    public char getTrig () {
        return this.trig;
    }
    
    public void setTrig (char trig) {
        this.trig = trig;
    }
    // 3. Funcion de suma de fasores
    
    public Fasores sumarFasores (Fasores f, Fasores g) {
        if(f.trig == 'c' && g.trig!=f.trig){
            g.pasarACoseno(g);
        }
        if(f.trig == 's' && g.trig!=f.trig){
            g.pasarASeno(g);
        }
        double parteRealDeSuma = f.amplitud*Math.cos(f.desplazamiento) + g.amplitud*Math.cos(g.desplazamiento);
        double parteImaginariaDeSuma = f.amplitud*Math.sin(f.desplazamiento) + g.amplitud*Math.sin(g.desplazamiento);
        ComplejoBinomica cBin = new ComplejoBinomica(parteRealDeSuma,parteImaginariaDeSuma);
        ComplejoPolar cPol = new ComplejoPolar();        
        cPol.binomicaAPolar (cBin);
        this.amplitud=cPol.modulo;               
        this.fase=f.fase;
        this.desplazamiento = cPol.argumento;
        this.trig=f.trig;
        return this;
    }
    
    // Resuelve siempre con la parte Real, por eso si viene un fasor con un sin(...), suma Pi/2 
    // para convertirlo en cos
    public Fasores pasarACoseno (Fasores f) {
        f.desplazamiento = f.desplazamiento - (Math.PI/2);
        f.trig = 'c';
        return f;
    }
    
    public Fasores pasarASeno (Fasores f){
        f.desplazamiento = f.desplazamiento + (Math.PI/2);
        f.trig='s';
        return this;
    }
    
}