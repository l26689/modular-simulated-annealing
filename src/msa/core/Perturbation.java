package msa.core;

public abstract class Perturbation<X,Prob extends Problem<X>,Sol extends Solution<X>> {

    protected abstract void init(Prob problem);

    protected abstract Sol perturb(double temperature,Sol s,boolean isAccepted);
}