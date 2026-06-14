package msa.problem;

public class Solution implements Cloneable {
    private final double[] x;
    private double value;

    public Solution(double[] x) {
        this.x = x.clone();
        this.value = Double.NaN;
    }


    public double[] getX() {
        return x.clone();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Solution clone() {
        Solution s = new Solution(this.x);
        s.value = this.value;
        return s;
    }
}