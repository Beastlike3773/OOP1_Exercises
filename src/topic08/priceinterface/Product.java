package topic08.priceinterface;

public class Product implements Price {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double getBruttoPrice() {
        return price * 1.08;
    }

    @Override
    public Double getNettoPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
