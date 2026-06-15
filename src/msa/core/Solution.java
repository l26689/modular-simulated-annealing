package msa.core;

public interface Solution<X> extends Cloneable {
    X getX();
    double getValue();

    void setValue(double value);
    
    Solution<X> clone();
}
