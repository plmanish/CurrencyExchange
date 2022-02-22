public class Ticker {

    private String base_currency;
    private String quote_currency;
    private double bid_price;
    private double ask_price;

    public Ticker(String base_currency, String quote_currency, double bid_price, double ask_price) {
        this.base_currency = base_currency;
        this.quote_currency = quote_currency;
        this.bid_price = bid_price;
        this.ask_price = ask_price;
    }

    public String getBase_currency() {
        return base_currency;
    }

    public String getQuote_currency() {
        return quote_currency;
    }

    public double getBid_price() {
        return bid_price;
    }

    public double getAsk_price() {
        return ask_price;
    }
}
