package DesignPatterns.Proxy;

public class BitcoinApi extends CoinApi{
    @Override
    public int getValueInUSD(int bitcoinValue) {
        return bitcoinValue*10;

    }
}
