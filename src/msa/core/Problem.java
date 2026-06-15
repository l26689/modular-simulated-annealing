package msa.core;

public interface Problem<X> {
    double evaluate(X x);

    X copyX(X x);
}
