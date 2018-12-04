package topic08.interfaces.mydata;

public interface MyData {

  default void print(String str) {
    if (!isNull(str))
      System.out.println("Interface MyData Print::" + str);
  }

  static boolean isNull(String str) {
    System.out.println("** Interface MyData isNull **");
    return str == null ? true : "".equals(str) ? true : false;
  }
}
