package DesignPatterns.Proxy5;

public class BadClient {

    public void execute() {
        WithRateLimit withRateLimit = new WithRateLimit();
        BitcoinApi bitcoinApi = new BitcoinApi();
        try {
            for (int i = 0; i < 3; i++) {
                int result = withRateLimit.getValueInUSD(500);
                System.out.println(result + " USD");
            }

        } catch (Exception e) {
            System.out.println("Time is exceeded");
        }
    }
}
