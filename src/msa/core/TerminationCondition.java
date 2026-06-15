package msa.core;

public abstract class TerminationCondition<X,Prob extends Problem<X>,Sol extends Solution<X>> {

    protected abstract void init(Prob problem);
    
    protected abstract boolean check(double temperature, Sol s,boolean isAccepted);
}