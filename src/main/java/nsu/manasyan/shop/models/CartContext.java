package nsu.manasyan.shop.models;

public class CartContext {
    private Product product;
    private int amount;
    private int sum;

    //for json
    public CartContext(){}

    public CartContext(Product product, int amount){
        this.product = product;
        this.amount = amount;
        this.sum = amount * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
