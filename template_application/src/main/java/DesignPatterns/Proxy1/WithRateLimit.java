package DesignPatterns.Proxy1;

public class WithRateLimit extends CoinApi { //this is the proxy class

    private CoinApi realSubject = new BitcoinApi();
    int currentTime = 10;
    int lastCalled = 5;

    @Override
    public int getValueinUSD(int bitcoinValue) {
        if (currentTime - lastCalled < 5) {
            throw new IllegalCallerException("Call time is exceeded");
        } else
            return realSubject.getValueinUSD(bitcoinValue);
    }
}
