import Coin.*;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    VendingMachine vendingMachine;
    ArrayList<Product> products;
    Coin oneP;
    Coin onePound;
    Product productCola;
    Product productCrisps;
    Wallet wallet;


    @Before
    public void SetUp(){
        vendingMachine = new VendingMachine(101);
        oneP = new Coin(CoinType.C1P);
        onePound = new Coin(CoinType.C£1);
        productCola = new Product(ProductType.COLA);
        productCrisps = new Product(ProductType.CRISPS);
        wallet = new Wallet(0.00);


    }

    @Test
    public void hasID(){
        assertEquals(101, vendingMachine.getID());
    }

    @Test
    public void hasEmptyProducts(){
        assertEquals(0, vendingMachine.getCountProducts());
    }

    @Test
    public void startWithEmptyTotal(){
        assertEquals(0.00, vendingMachine.getBalance(), 0.0);
    }
    @Test
    public void nonAcceptableCoinReturnsFalse(){
        assertEquals(false, vendingMachine.acceptCoin(oneP));
    }

    @Test
    public void acceptableCoinReturnsTrue(){
        assertEquals(true, vendingMachine.acceptCoin(onePound));
    }

    @Test
    public void canAddProductToVendingMachine(){
        vendingMachine.addProductToMachine(productCola);
        assertEquals(1, vendingMachine.getCountProducts());
    }

    @Test
    public void canRemoveProductFromVendingMachine(){
        vendingMachine.addProductToMachine(productCola);
        vendingMachine.addProductToMachine(productCrisps);
        vendingMachine.canRemoveProduct(productCola);
        assertEquals(1, vendingMachine.getCountProducts());
    }
    @Test
    public void findProductByCode(){
        vendingMachine.addProductToMachine(productCola);
        vendingMachine.addProductToMachine(productCrisps);
        assertEquals(productCola, vendingMachine.findProductByCode("A1"));
    }

    @Test
    public void cannotFindProductByCode(){
        vendingMachine.addProductToMachine(productCola);
        vendingMachine.addProductToMachine(productCrisps);
        assertEquals(null, vendingMachine.findProductByCode("C3"));
    }

    @Test
    public void canAddToTotalBalance(){
//        wallet.addCoinToWalletHashmap(onePound);
        vendingMachine.addCoinToTotalBalanceHashMap(onePound);
        assertEquals(1.00, vendingMachine.getBalance(), 0.0);
    }

    @Test
    public void cannotAddToTotalBalance() {
//        wallet.addCoinToWalletHashmap(oneP);
        vendingMachine.addCoinToTotalBalanceHashMap(oneP);
        assertEquals(0.00, vendingMachine.getBalance(), 0.0);
    }
    @Test
    public void theBigOne(){
        vendingMachine.addProductToMachine(productCola);
        wallet.addCoinToWalletHashmap(oneP);
        vendingMachine.addCoinToTempTillHashMapHashMap(oneP);
        vendingMachine.payForProduct("A1", wallet);
        assertEquals(1, wallet.getSizeOfBasket());
    }
}
