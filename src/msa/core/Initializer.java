package msa.core;

public abstract class Initializer<X,Prob extends Problem<X>,Sol extends Solution<X>> {
    
    protected abstract void init(Prob problem);
    
    protected abstract Sol initialSolution();

    protected abstract double initialTemperature();
}
