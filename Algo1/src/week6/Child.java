package week6;

public class Child  extends Base{

  public Child() {

    System.out.println("Child class no arg");
  }
  private void childPrivate()
  {
    System.out.println("childPrivate");
  }
  protected void childProtected()
  {
    System.out.println("childProtected");
  }
  public void basePublic1()
  {
    System.out.println("childkabasePublic");
  }
  public static void main(String[] args) {
  Child c = new Child();
  c.baseProtected();
  //Base b = new Base(2);
 //b.basePublic();
 //b.baseProtected();
 

  }

}
