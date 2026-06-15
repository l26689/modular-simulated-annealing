package msa.core;

public interface Solution<X>{
    X getX();
    double getValue();

    void setValue(double value);
    
    Solution<X> clone();
}
