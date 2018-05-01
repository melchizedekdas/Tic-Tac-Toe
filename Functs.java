




public class Functs
{
  public Functs() {}
  
  public static void pause(long mil)
  {
    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    
    do
    {
      end = System.currentTimeMillis();
    } while (end - start < mil);
  }
  
  public static void pause(long mil, long mil2)
  {
    long end = System.currentTimeMillis();
    
    do
    {
      end = System.currentTimeMillis();
    } while (end - mil2 < mil);
  }
}
