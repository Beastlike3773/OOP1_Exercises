package topic08.interfaces.animal;

public class AnimalTester {

  /**
   * Main method.
   * @param args unused
   */
  public static void main(String[] args) {
    Animal duck = new Animal();
    
    duck.fly();
    duck.hasWings();
    duck.swim();
  }
  
}
