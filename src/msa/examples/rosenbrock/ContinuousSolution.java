package msa.examples.rosenbrock;

import msa.core.Solution;

public class ContinuousSolution implements Solution<double[]> {
    private final double[] x;
    private double value;

    public ContinuousSolution(double[] x) {
        this.x = x.clone();
        this.value = Double.NaN;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Solution<double[]> clone() {
        ContinuousSolution s = new ContinuousSolution(this.x);
        s.value = this.value;
        return s;
    }
    @Override
    public double[] getX() {
        return x.clone();
    }
}