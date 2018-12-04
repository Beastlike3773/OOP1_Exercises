package topic08.interfaces.animal;

public class Animal implements Fly, Swim{

  @Override
  public void fly() {
    System.out.println("I can fly. I'm a flying animal.");
  }

  @Override
  public boolean hasWings() {
    System.out.println("I haven't wings");
    return false;
  }
  
  @Override
  public void swim() {
    System.out.println("I can swim.");
  }

}
