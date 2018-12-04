package topic08.interfaces.animal;

public interface Fly {
  
   public void fly();
   
   // new method
   public default boolean hasWings() {
     System.out.println("I have wings");
     return true;
   }
}
