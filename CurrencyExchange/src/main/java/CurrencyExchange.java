import java.text.DecimalFormat;
import java.util.*;

public class CurrencyExchange {

    Map<String, List<Price>> graph;
    List<String> exchangePath;
    double maxExchangePrice;
    Set<String> visited;

    public void buildGraph(final List<Ticker> tickers) {
        graph = new HashMap<String, List<Price>>();
        for (Ticker ticker : tickers) {
            graph.putIfAbsent(ticker.getBase_currency(), new ArrayList<Price>());
            graph.get(ticker.getBase_currency()).add(new Price(ticker.getQuote_currency(), 1.0/ticker.getBid_price()));

            graph.putIfAbsent(ticker.getQuote_currency(), new ArrayList<>());
            graph.get(ticker.getQuote_currency()).add(new Price(ticker.getBase_currency(), ticker.getAsk_price()));
        }
    }

    public void printGraph() {
        DecimalFormat df = new DecimalFormat("####.#######");
        for (Map.Entry<String, List<Price>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Price prc : entry.getValue())
                System.out.print(prc.getCurrency() + " - " + df.format(prc.getValue()) + ", ");
            System.out.println();
        }
        System.out.println();
    }

    public void getMaxExchangePrice(final String base_curr, final String quote_curr, final double amount) {
        exchangePath = new ArrayList<>();
        visited = new HashSet<>();
        maxExchangePrice = 0;

        List<String> currPath = new ArrayList<>();
        currPath.add(base_curr);
        dfs(base_curr, quote_curr, amount, currPath);

        System.out.println("Exchange path followed");
        for (String curr : exchangePath)
            System.out.print(curr + "  ");
        System.out.println();

        System.out.println("Max exchange value: " + maxExchangePrice);
    }

    private void dfs(String currency, String target, double currExchangePrice, List<String> currPath) {

        if (currency == target) {
            if (maxExchangePrice < currExchangePrice) {
                maxExchangePrice = currExchangePrice;
                exchangePath = new ArrayList<>(currPath);
            }
            return;
        }

        if (!graph.containsKey(currency))
            return;

        visited.add(currency);

        for (Price price : graph.get(currency)) {
            String nextCurr = price.getCurrency();
            double cost = price.getValue();
            if (!visited.contains(nextCurr)) {
                currPath.add(nextCurr);
                dfs(nextCurr, target, cost * currExchangePrice, currPath);
                currPath.remove(currPath.size() - 1);
            }
        }
        visited.remove(visited.size() - 1);
    }
}
