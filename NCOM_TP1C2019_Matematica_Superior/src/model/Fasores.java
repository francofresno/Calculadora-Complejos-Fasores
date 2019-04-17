package model;

public class Fasores{
    // 1. Estrucutra fasores
    public double amplitud;
    public double fase;
    public double frecuencia;
    
    public Fasores() {
        this.amplitud = 0;
        this.fase = 0;
        this.frecuencia = 0;
    }
    
    public Fasores(double amp, double fase, double frec) {
        this.amplitud = amp;
        this.fase = fase;
        this.frecuencia = frec;
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

}