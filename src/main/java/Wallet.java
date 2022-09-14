import Coin.Coin;
import Product.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {
    private double balance;
    private HashMap<Double, Integer> coinHashmap;
    private ArrayList<Product> basket;

    public Wallet(double balance){
        this.balance = balance;
        this.coinHashmap= new HashMap<>();
        this.basket = new ArrayList<Product>();
    }

    public int getSizeOfBasket(){
        return basket.size();
    }

    public void addToBasket(Product product){
        basket.add(product);
    }
    public void addCoinToWalletHashmap(Coin coin){
        double coinValue = coin.getCoinValue();
        if(this.coinHashmap.containsKey(coinValue)){
            Integer counter = coinHashmap.get(coinValue);
            counter++;
            this.coinHashmap.put(coinValue, counter);
        } else {
            this.coinHashmap.put(coinValue, 1);
        }
    }
    public void addCoinsBackToWalletHashmap(double value, int quantity){
        if(this.coinHashmap.containsKey(value)){
            Integer counter = coinHashmap.get(quantity);
            counter++;
            this.coinHashmap.put(value, counter);
        } else {
            this.coinHashmap.put(value, 1);
        }
    }
    public double getBalance(){
        for (Double i : coinHashmap.keySet()){
            balance += i * coinHashmap.get(i);
        }
        return this.balance;
    }

    public int getCoinHashmapSize() {
        return coinHashmap.size();
    }
    public void removeCoinsFromWalletHashmap(Coin coin){
        double coinValue = coin.getCoinValue();
        if(this.coinHashmap.containsKey(coinValue) && coinHashmap.get(coinValue) > 1){
            Integer counter = coinHashmap.get(coinValue);
            counter--;
            this.coinHashmap.put(coinValue, counter);
        }
        else {
            this.coinHashmap.remove(coinValue);
        }
    }
}
