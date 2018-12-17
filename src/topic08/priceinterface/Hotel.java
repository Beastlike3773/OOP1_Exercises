package topic08.priceinterface;

public class Hotel implements Price {

    private String name;
    private int nbrRooms;
    private double roomPrice;

    /**
     * Constructs a Hotel instance.
     * @param name name of the hotel
     * @param nbr number of rooms
     * @double price of a hotel room
     **/
    public Hotel(String name, int nbr, double price) {
        this.name = name;
        this.nbrRooms = nbr;
        this.roomPrice = price;
    }

    public String getName() {
        return name;
    }

    // Entspricht dem Nettopreis
    public double getRoomPrice(){
        return roomPrice;
    }
    public Double getNettoPrice() {
        return getRoomPrice();
    }

    // Entspricht dem Bruttopreis
    public double getRoomPriceVAT(){
        return roomPrice * 1.038f;
    }

    public Double getBruttoPrice() {
        return getRoomPriceVAT();
    }

    public int getNbrRooms() {
        return nbrRooms;
    }

    public void setNbrRooms(int nbrRooms) {
        this.nbrRooms = nbrRooms;
    }

}
