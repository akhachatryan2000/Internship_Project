package DesignPatterns.Proxy5;

public class BitcoinApi extends CoinApi {
    @Override
    public int getValueInUSD(int bitcoin) {
        return bitcoin * 10;
    }
}
