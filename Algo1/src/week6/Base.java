package week6;

public class Base {

  public Base() {
    System.out.println("Base no arg constructor");
  }
  public void basePublic()
  {
    System.out.println("basePublic");
  }
  private void basePrivate()
  {
    System.out.println("basePrivate");
  }
  protected void baseProtected()
  {
    System.out.println("baseProtected");
  }
  public Base(int a)
  {
   // this();
    System.out.println("Base construtor arg "+ a);
  }

  public static void main(String[] args) {
    Base b = new Base(2);
    b.baseProtected();
    b.basePrivate();

  }

}
