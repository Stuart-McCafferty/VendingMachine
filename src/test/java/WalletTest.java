import Coin.*;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalletTest {
    Wallet wallet;
    Coin oneP;
    Coin onePound;
    Product productCola;


    @Before
    public void SetUp(){
        wallet = new Wallet(0);
        oneP = new Coin(CoinType.C1P);
        onePound = new Coin(CoinType.C£1);
        productCola = new Product(ProductType.COLA);
    }

    @Test
    public void hasEmptyBalance(){
        assertEquals(0, wallet.getBalance(), 0.0);
    }

    @Test
    public void getCoinHashmap(){
        assertEquals(0, wallet.getCoinHashmapSize());
    }
    @Test
    public void  addCoinToWalletHashmap(){
        wallet.addCoinToWalletHashmap(onePound);
        assertEquals(1, wallet.getCoinHashmapSize());
    }
    @Test
    public void  addCoinsToWalletHashmap(){
        wallet.addCoinToWalletHashmap(onePound);
        wallet.addCoinToWalletHashmap(oneP);

        assertEquals(2, wallet.getCoinHashmapSize());
    }

    @Test
    public void  canAddToBalance(){
        wallet.addCoinToWalletHashmap(onePound);
        wallet.addCoinToWalletHashmap(oneP);
        assertEquals(1.01, wallet.getBalance(), 0.00);
    }
    @Test
    public void canRemoveCoinFromWalletHashmap(){
        wallet.addCoinToWalletHashmap(onePound);
        wallet.addCoinToWalletHashmap(onePound);
        wallet.addCoinToWalletHashmap(oneP);
        assertEquals(2, wallet.getCoinHashmapSize());
        wallet.removeCoinsFromWalletHashmap(onePound);
        assertEquals(2, wallet.getCoinHashmapSize());
        assertEquals(1.01, wallet.getBalance(), 0.00);
        wallet.removeCoinsFromWalletHashmap(onePound);
        assertEquals(1, wallet.getCoinHashmapSize());
        wallet.removeCoinsFromWalletHashmap(oneP);
        assertEquals(0, wallet.getCoinHashmapSize());
    }

    @Test
    public void startsWithEmptyBasket(){
        assertEquals(0, wallet.getSizeOfBasket());

    }
    @Test
    public void canAddToBasket(){
        wallet.addToBasket(productCola);
        assertEquals(1, wallet.getSizeOfBasket());
    }
}
