import Coin.Coin;
import Product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {

    private int ID;
    private ArrayList<Product> products;
    private HashMap<Double, Integer> totalBalanceHashMap;
    private HashMap<Double, Integer> tempTillHashMap;
    private double balance;

    public VendingMachine(int ID){
        this.ID = ID;
        this.products = new ArrayList<Product>();
        this.totalBalanceHashMap = new HashMap<>();
        this.tempTillHashMap = new HashMap<>();
        this.balance = 0.00;
    }

    public int getID() {
        return ID;
    }

    public int getCountProducts() {
        return products.size();
    }
    public void moveCoinsBetweenWalletAndBalanceHashmaps(Wallet wallet, Coin coin){
        wallet.removeCoinsFromWalletHashmap(coin);
        if (this.acceptCoin(coin)){
            this.addCoinToTempTillHashMapHashMap(coin);
        } else {
            wallet.addCoinToWalletHashmap(coin);
        }
    }

    public void addCoinToTotalBalanceHashMap(Coin coin){
        double coinValue = coin.getCoinValue();
        if(this.totalBalanceHashMap.containsKey(coinValue) && acceptCoin(coin)){
            Integer counter = totalBalanceHashMap.get(coinValue);
            counter++;
            this.totalBalanceHashMap.put(coinValue, counter);
        } else if (acceptCoin(coin)) {
            this.totalBalanceHashMap.put(coinValue, 1);
        }
    }
    public void removeCoinsFromBalanceHashmap(Coin coin){
        double coinValue = coin.getCoinValue();
        if(this.totalBalanceHashMap.containsKey(coinValue) && totalBalanceHashMap.get(coinValue) > 1){
            Integer counter = totalBalanceHashMap.get(coinValue);
            counter--;
            this.totalBalanceHashMap.put(coinValue, counter);
        }
        else {
            this.totalBalanceHashMap.remove(coinValue);
        }
    }
    public double getBalance(){
        for (Double i : totalBalanceHashMap.keySet()){
            balance += i * totalBalanceHashMap.get(i);
        }
        return this.balance;
    }

    public int getCoinHashmapSize() {
        return totalBalanceHashMap.size();
    }
    public void addCoinToTempTillHashMapHashMap(Coin coin){
        double coinValue = coin.getCoinValue();
        if(this.tempTillHashMap.containsKey(coinValue) && acceptCoin(coin)){
            Integer counter = tempTillHashMap.get(coinValue);
            counter++;
            this.tempTillHashMap.put(coinValue, counter);
        } else if (acceptCoin(coin)) {
            this.tempTillHashMap.put(coinValue, 1);
        }
    }
    public double getTempBalance(){
        double tempBalance = 0.00;
        for (Double i : tempTillHashMap.keySet()){
            tempBalance += i * tempTillHashMap.get(i);
        }
        return tempBalance;
    }

    public int getTempTillHashmapSize() {
        return tempTillHashMap.size();
    }
    public void addProductToMachine(Product product){
        products.add(product);
    }
    public void canRemoveProduct(Product product){
        products.remove(product);
    }
    public boolean acceptCoin(Coin coin){
        if (coin.getCoinType().getCoinValue() > 0.02){
            return true;
        }
        else return false;
    }

    public Product findProductByCode(String code) {
        Product productTemp;
        for (int i = 0; i < products.size(); i++) {
            if (code == products.get(i).getCode()) {
                return products.get(i);
            }
        }
        return null;
    }

    public void setTempTillHashMap() {
        this.tempTillHashMap = new HashMap<>();
    }

    public void payForProduct(String code, Wallet wallet){
        Product selectedItem = findProductByCode(code);
        double totalToPay = selectedItem.getCost();
        if (totalToPay > this.getTempBalance()){
            for (Double i : tempTillHashMap.keySet()){
                for(int x = 0; x < tempTillHashMap.get(i); x++){
                    wallet.addCoinsBackToWalletHashmap(i, tempTillHashMap.get(i));
                }
            }
        } else if (totalToPay <= this.getTempBalance()){
            for (Double i : tempTillHashMap.keySet()){
                totalBalanceHashMap.put(i,tempTillHashMap.get(i));
            }
            this.setTempTillHashMap();
            this.canRemoveProduct(selectedItem);
            wallet.addToBasket(selectedItem);
        }
    }
}
