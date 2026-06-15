package msa.core;

public abstract class CoolingSchedule<X,Prob extends Problem<X>,Sol extends Solution<X>> {

    protected abstract void init(Prob problem);

    protected abstract double cool(double temperature,Sol s,boolean isAccepted);
}