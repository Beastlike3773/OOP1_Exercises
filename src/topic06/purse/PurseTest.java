package topic06.purse;

public class PurseTest {

    public static void main(String[] args){
        Purse a = new Purse();
        a.addCoin("Quarter");
        a.addCoin("Quarter");
        a.addCoin("Dime");
        a.addCoin("Penny");
        a.addCoin("Quarter");
        System.out.println(a);
        System.out.println(a.getValue());

        Purse b = new Purse();
        b.addCoin("Quarter");
        b.addCoin("Quarter");
        b.addCoin("Dime");
        b.addCoin("Penny");
        b.addCoin("Quarter");
        System.out.println(b);
        System.out.println(b.getValue());

        System.out.println(a.sameValue(b));
        System.out.println(a.sameCoins(b));

        Purse c = new Purse ("Quarter","Dime","Dime","Dime","Penny","Quarter","Nickel") ;
        System.out.println(c) ;
        System.out.println(c.getValue());

        System.out.println(a.sameValue(c) ) ;
        System.out.println(a.sameCoins (c) ) ;

        c.transferTo(a);
        System.out.println(a);
        System.out.println(c);

        a.transferFrom( b ) ;
        System.out.println(a);
        System.out.println(b);
    }
}
