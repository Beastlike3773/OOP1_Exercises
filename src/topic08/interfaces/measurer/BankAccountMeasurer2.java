package topic08.interfaces.measurer;

public class BankAccountMeasurer2 implements Measurer {
    @Override
    public double measure(Object obj) {
        BankAccount ba = (BankAccount) obj;
        return ba.getBalance();
    }
}
