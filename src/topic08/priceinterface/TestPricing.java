package topic08.priceinterface;

public class TestPricing {

    /**
     * Main method.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Product p1 = new Product("Gummiboot", 150.0);
        Product p2 = new Product("Sonnencreme", 3.5);

        Double diff = Pricing.diffBruttoNetto(p1);
        System.out.printf("Product %s: The difference is %.2f %n", p1.getName(), diff);

        Hotel hotel = new Hotel("Edelweiss", 10, 200.00);
        Double diff2 = Pricing.diffBruttoNetto(hotel);
        System.out.printf("Hotel %s: The difference is %.2f %n",hotel.getName(),diff2);

    }

}
