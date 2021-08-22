package ex1.model.bean;

public class Converter {
    private long amount;
    private double rate;

    public Converter() {
    }

    public Converter(long amount, double rate) {
        this.amount = amount;
        this.rate = rate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
