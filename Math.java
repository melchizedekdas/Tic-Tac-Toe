public class Math
{
  public Math() {}
  
  public static int pow(int x, int y)
  {
    int num = 1;
    for (int i = 1; i <= y; i++)
    {
      num *= x;
    }
    return num;
  }
  
  public static double pow(double x, int y) {
    double num = 1.0D;
    for (int i = 1; i <= y; i++)
    {
      num *= x;
    }
    return num;
  }
  
  public static float pow(float x, int y) {
    float num = 1.0F;
    for (int i = 1; i <= y; i++)
    {
      num *= x;
    }
    return num;
  }
  
  public static double sqrt(int x)
  {
    int i = x;int l = 0;int ln = 0;int sr = 0;
    if (x <= 0)
      return 0.0D;
    while (i > 0)
    {
      l++;
      i /= 10;
    }
    if (l % 2 == 0) {
      ln = l / 2;
    } else
      ln = (l - 1) / 2 + 1;
    int[] temp = new int[ln];
    for (i = 0; i < l; i++)
    {
      int tem = x;int te = 0;
      for (int j = 1; j <= 2; j++)
      {
        te += tem % 10 * pow(10, j);
      }
      temp[(ln - (i + 1))] = te;
    }
    for (i = 0; i < ln; i++)
    {
      int div = 1;
      if (i == 0)
      {
        for (int j = 1; j <= temp[0]; j++)
        {
          if (j * j > temp[0])
          {
            div = j - 1;
            j = x;
          }
          if (j * j == temp[0])
          {
            div = j;
            j = x;
          }
        }
      }
      sr = sr * 10 + temp[i] / div;
      div = div * 10 + temp[i] / div;
    }
    return sr;
  }
  
  public static double sqrt(double x) {
    return StrictMath.sqrt(x);
  }
  
  public static float sqrt(float a) {
    double x = a;
    return (float)StrictMath.sqrt(x);
  }
  
  public static int floor(float x)
  {
    int res = (int)x;
    return res;
  }
  
  public static int floor(double x) {
    int res = (int)x;
    return res;
  }
  
  public static int ceil(float x) {
    int f = floor(x);
    int res = 0;
    if (x > f) {
      res = (int)(x + 1.0F);
    } else
      res = f;
    return res;
  }
  
  public static int ceil(double x) {
    int f = floor(x);
    int res = 0;
    if (x > f) {
      res = (int)(x + 1.0D);
    } else
      res = f;
    return res;
  }
  
  public static int rint(float x) {
    int f = floor(x);
    int res = 0;
    if (x >= f + 0.5D) {
      res = ceil(x);
    } else
      res = floor(x);
    return res;
  }
  
  public static int round(float x) {
    int f = floor(x);
    int res = 0;
    if (x >= f + 0.5D) {
      res = ceil(x);
    } else
      res = floor(x);
    return res;
  }
  
  public static int rint(double x) {
    int f = floor(x);
    int res = 0;
    if (x >= f + 0.5D) {
      res = ceil(x);
    } else
      res = floor(x);
    return res;
  }
  
  public static int round(double x) {
    int f = floor(x);
    int res = 0;
    if (x >= f + 0.5D) {
      res = ceil(x);
    } else
      res = floor(x);
    return res;
  }
  
  public static int abs(int x) {
    int res = 0;
    if (x >= 1) {
      res = x;
    } else
      res = -1 * x;
    return res;
  }
  
  public static float abs(float x) {
    float res = 0.0F;
    if (x >= 1.0F) {
      res = x;
    } else
      res = -1.0F * x;
    return res;
  }
  
  public static double abs(double x) {
    double res = 0.0D;
    if (x >= 1.0D) {
      res = x;
    } else
      res = -1.0D * x;
    return res;
  }
  
  public static int exp(int x) {
    return pow(10, x);
  }
  
  public static int rand(int range) {
    int ans = (int)(Math.random() * range);
    return ans;
  }
  
  public static double random() {
    return Math.random();
  }
}
