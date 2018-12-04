package topic08.interfaces.mydata;

public class MyDataImpl implements MyData {

  public boolean isNull(String str) {
    System.out.println("** Class MyDataImpl isNull **");
    return str == null ? true : false;
  }

  public static void main(String args[]) {
    MyDataImpl obj = new MyDataImpl();
    obj.print("");
    obj.isNull("abc");
    MyData.isNull("123");
  }
}
