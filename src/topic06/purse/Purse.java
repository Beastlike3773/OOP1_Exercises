package topic06.purse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Purse {

    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;
    private static final int PENNY = 1;

    private List<String> coins;

    public List<String> getCoins(){
        return coins;
    }

    public Purse(String... inCoins){
        this.coins = new ArrayList<>();

        for(String coin : inCoins){
            this.coins.add(coin);
        }

        int[] test = new int[12];
    }

    /**
     * Add a coin to the coin
     * @param coinName the name of the coin to add to the purse
     * (Precondition: Coin must exists)
     */
    public void addCoin(String coinName){
        this.coins.add(coinName);
    }

    public void transferTo(Purse other){
        other.coins.addAll(this.coins);
        this.coins.clear();
    }

    public void transferFrom(Purse other){
        this.coins.addAll(other.coins);
        other.coins.clear();
    }

    public int getValue(){
        int retValue = 0;

        for(String coin : this.coins){
            switch(coin){
                case "Quarter":
                    retValue += QUARTER;
                    break;
                case "Dime":
                    retValue += DIME;
                    break;
                case "Nickel":
                    retValue += NICKEL;
                    break;
                case "Penny":
                    retValue += PENNY;
                    break;
                default:
                    retValue += 0;
                    break;
            }
        }

        return retValue;
    }

    public boolean sameValue(Purse other){
        return this.getValue() == other.getValue();
    }

    public boolean sameCoins(Purse other){
        Collections.sort(other.coins);
        Collections.sort(this.coins);

        return this.coins.equals(other.coins);
    }

    public String toString(){
        String outString = "PURSE[";

        if(this.coins.isEmpty()){
            return outString + "]";
        }

        for(String coin : this.coins){
            outString += coin + " ";
        }

        return outString.substring(0, outString.length() - 1) + "]";
    }
}
