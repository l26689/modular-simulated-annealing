package msa.core;

public abstract class CoolingSchedule<X,Prob extends Problem<X>> {

    protected abstract void init(Prob problem);

    protected abstract double cool(double temperature,X x,boolean isAccepted);
}