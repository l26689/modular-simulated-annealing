package msa.core;

public abstract class Initializer<X,Prob extends Problem<X>> {
    
    protected abstract void init(Prob problem);
    
    protected abstract X initialX();

    protected abstract double initialTemperature();
}
