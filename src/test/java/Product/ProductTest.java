package Product;

import Product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    
    Product productCola;
    Product productCrisps;
    Product productSweet;
    
    @Before
    public void SetUp(){
        productCola = new Product(ProductType.COLA);
        productCrisps = new Product(ProductType.CRISPS);
        productSweet = new Product(ProductType.SWEET);
    }

    @Test
    public void hasCost(){
        assertEquals(1.00, productCola.getCost(), 0.0);
    }

    @Test
    public void hasCode() {
        assertEquals("B2", productCrisps.getCode());
    }
}
