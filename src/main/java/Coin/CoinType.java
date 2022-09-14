package Coin;

public enum CoinType {
    C1P(0.01),
    C2P(0.02),
    C5P(0.05),
    C10P(0.10),
    C20P(0.20),
    C50P(0.50),
    C£1(1.00),
    C£2(2.00);

    private double coinValue;
    CoinType(double coinValue){
        this.coinValue = coinValue;
    }
    public double getCoinValue(){
        return this.coinValue;
    }
}
