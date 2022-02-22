import com.google.gson.Gson;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();
//        String st1 = "{\"base_currency\": \"USD\", \"quote_currency\": \"BTC\", \"bid_price\": \"1000\", \"ask_price\": \"990\"}";
//        Ticker t1 = gson.fromJson(st1, Ticker.class);
//        String st2 = "{\"base_currency\": \"EUR\", \"quote_currency\": \"BTC\", \"bid_price\": \"1200\", \"ask_price\": \"1150\"}";
//        Ticker t2 = gson.fromJson(st2, Ticker.class);
//        String st3 = "{\"base_currency\": \"USD\", \"quote_currency\": \"ETH\", \"bid_price\": \"200\", \"ask_price\": \"180\"}";
//        Ticker t3 = gson.fromJson(st3, Ticker.class);
//        String st4 = "{\"base_currency\": \"EUR\", \"quote_currency\": \"ETH\", \"bid_price\": \"220\", \"ask_price\": \"210\"}";
//        Ticker t4 = gson.fromJson(st4, Ticker.class);
//        String st5 = "{\"base_currency\": \"ETH\", \"quote_currency\": \"BTC\", \"bid_price\": \"5.6\", \"ask_price\": \"5.5\"}";
//        Ticker t5 = gson.fromJson(st5, Ticker.class);

        Ticker t1 = new Ticker("USD", "BTC", 1000, 990);
        Ticker t2 = new Ticker("EUR", "BTC", 1200, 1150);
        Ticker t3 = new Ticker("USD", "ETH", 200, 180);
        Ticker t4 = new Ticker("EUR", "ETH", 220, 210);
        Ticker t5 = new Ticker("ETH", "BTC", 5.6, 5.5);

        CurrencyExchange exchange = new CurrencyExchange();
        exchange.buildGraph(Arrays.asList(t1, t2, t3, t4, t5));
        exchange.printGraph();

        exchange.getMaxExchangePrice("USD", "EUR", 100);
        exchange.getMaxExchangePrice("EUR", "USD", 100);
    }
}
