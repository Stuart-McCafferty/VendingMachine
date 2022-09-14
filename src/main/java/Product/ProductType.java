package Product;

public enum ProductType {

    COLA(1.00, "A1"),
    CRISPS(0.50, "B2"),
    SWEET(0.65, "C3");

    private double cost;
    private String code;

    ProductType(double cost, String code) {
        this.cost = cost;
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public String getCode() {
        return code;
    }
}
