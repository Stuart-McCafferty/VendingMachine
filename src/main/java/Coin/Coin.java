package Coin;

public class Coin {
    protected CoinType coinType;
    public Coin(CoinType cointype){
        this.coinType = cointype;
    }
    public CoinType getCoinType(){
        return coinType;
    }
    public double getCoinValue(){
        return coinType.getCoinValue();
    }

}
