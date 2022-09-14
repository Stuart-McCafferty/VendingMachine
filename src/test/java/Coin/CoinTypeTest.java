package Coin;

import Coin.Coin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class  CoinTypeTest {
    Coin oneP;
    Coin onePound;
    @Before
    public void setUp(){
        oneP = new Coin(CoinType.C1P);
        onePound = new Coin(CoinType.C£1);
    }
    @Test
    public void  getCoinType(){
        assertEquals(CoinType.C1P, oneP.getCoinType());
    }

    @Test
    public void getCoinValue() {
        assertEquals(0.01, oneP.getCoinValue(), 0.00);
    }
    @Test
    public void getCoinValue£1() {
        assertEquals(1.00, onePound.getCoinValue(), 0.00);
    }
}