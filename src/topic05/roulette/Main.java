package topic05.roulette;

import java.util.Random;

public class Main {

    private static long balance = 0;
    private static Random random;
    private static int playerWins = 0;
    private static int playerLoses = 0;
    private static int nrOfGames = 100000;
    private static long startbalance = 1000;
    private static long endbalance = 1500;


    public static void main(String[] args){
        random = new Random();

        for(int i = 0; i < nrOfGames; i++) {
            visitCasino(startbalance, endbalance);
        }

        System.out.println("Normal Strategy");
        System.out.println("Player won: " + playerWins + " times, Player lost: " + playerLoses + " times.");
        System.out.println("Chance of winning is: " + (double)playerWins * 100 / (double)nrOfGames + "%.");

        playerWins = 0;
        playerLoses = 0;

        for(int i = 0; i < nrOfGames; i++){
            visitCasinoZero(startbalance, endbalance);
        }

        System.out.println("Zero Strategy");
        System.out.println("Player won: " + playerWins + " times, Player lost: " + playerLoses + " times.");
        System.out.println("Chance of winning is: " + (double)playerWins * 100 / (double)nrOfGames + "%.");
    }

    public static boolean playBlack(long amount) throws Exception{
        if(balance < amount){
            playerLoses++;
            throw new Exception("Not enough balance left to play this strategy, balance left: " + balance + ", current bet: " + amount);
        }
        balance -= amount;

        if((random.nextDouble()) <= 18.0/37.0){
            balance += amount * 2;
            //System.out.println("\u001B[32m" + "Player won betting on black with the amount: " + amount + ", balance: " + balance + "\u001B[0m");
            return true;
        }
        return false;
    }
    public static void playStrategyZero() throws Exception{
        try {
            for (int i = 1; ; i *= 2) {
                if (playBlack(i)) {
                    break;
                }
            }
        }
        catch (Exception e){
            if(balance != 0){
                playStrategy();
            }else {

                throw new Exception(e.getMessage());
            }
        }
    }

    public static void playStrategy() throws Exception {
        for (int i = 1; ; i *= 2) {
            if (playBlack(i)) {
                break;
            }
        }
    }

    public static void visitCasino(long startBalance, long endBalance){
        balance = startBalance;

        try{
            while(balance < endBalance){
                playStrategy();
            }
            playerWins++;
        }catch(Exception e){
            //System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
    }

    public static void visitCasinoZero(long startBalance, long endBalance){
        balance = startBalance;

        try{
            while(balance < endBalance){
                playStrategyZero();
            }
            playerWins++;
        }catch(Exception e){
            //System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
    }
}
