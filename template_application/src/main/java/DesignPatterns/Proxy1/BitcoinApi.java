package DesignPatterns.Proxy1;

public class BitcoinApi extends CoinApi {
    @Override
    public int getValueinUSD(int bitcoinValue) {
        return bitcoinValue * 10;
    }
}
