package msa.core;

public abstract class Perturbation<X,Prob extends Problem<X>> {

    protected abstract void init(Prob problem);

    protected abstract X perturb(double temperature,X x,boolean isAccepted);
}