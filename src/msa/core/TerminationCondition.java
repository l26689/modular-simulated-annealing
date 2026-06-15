package msa.core;

public abstract class TerminationCondition<X,Prob extends Problem<X>> {

    protected abstract void init(Prob problem);
    
    protected abstract boolean check(double temperature, X x,boolean isAccepted);
}