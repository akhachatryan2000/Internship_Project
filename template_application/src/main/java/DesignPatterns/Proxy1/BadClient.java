package DesignPatterns.Proxy1;

public class BadClient {

    public void execute() {
        CoinApi caller = new WithRateLimit();
        for (int i = 0; i < 3; i++) {
            try {
                int result = caller.getValueinUSD(500);
                System.out.println("Converted to USD" + result);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }
}
