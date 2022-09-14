package Product;
public class Product {

    protected ProductType productType;

    public Product(ProductType productType){
        this.productType = productType;
    }

    public String getCode(){
        return productType.getCode();
    }

    public double getCost(){
        return productType.getCost();
    }

}
