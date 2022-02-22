public class Price {
    private String currency;
    private double value;

    public Price(String currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }
}
