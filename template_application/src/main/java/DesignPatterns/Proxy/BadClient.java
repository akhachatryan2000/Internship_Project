package DesignPatterns.Proxy;

public class BadClient {

    public void execute() {
        BitcoinApi bitcoinApi = new BitcoinApi();
        WithRateLimit withRateLimit = new WithRateLimit();
        for (int i = 0; i < 3; i++) {
            try {
                int result = withRateLimit.getValueInUSD(50);
                System.out.println(result + " USD");
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }


    }
}
