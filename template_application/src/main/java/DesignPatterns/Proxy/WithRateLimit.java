package DesignPatterns.Proxy;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.format.DateTimeFormatter;

public class WithRateLimit extends CoinApi {

    private CoinApi realSubject= new BitcoinApi();
    int lastCalled = 5;
    int currentTime = 10;

    @Override
    public int getValueInUSD(int bitcoinValue) {
        if (currentTime - lastCalled < 8) {
            throw new IllegalCallerException("Rate limit exceeded");
        } else {
            int result = realSubject.getValueInUSD(bitcoinValue);
            return result;
        }

    }
}
