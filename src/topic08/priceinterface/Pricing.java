package topic08.priceinterface;

public class Pricing {

    public static Double diffBruttoNetto(Price p) {
        return p.getBruttoPrice() - p.getNettoPrice();
    }

}
