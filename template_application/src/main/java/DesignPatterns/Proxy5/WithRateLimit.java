package DesignPatterns.Proxy5;


public class WithRateLimit extends CoinApi {
    private CoinApi realSubject = new BitcoinApi();
    int currentTime = 10;
    int lastCalled = 5;


    @Override
    public int getValueInUSD(int bitcoin) {
        if (currentTime - lastCalled < 5) {
            throw new IllegalCallerException("calling time is exceeded");
        }
        return realSubject.getValueInUSD(bitcoin);
    }
}
