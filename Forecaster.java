// Name : Jake Peterson
// Class : CIST1400-005   Lab Section
// Colleagues : None
// Resources : None
import java.util.Scanner;
public class Forecaster
{
   public static void main(String[] args)
   {
      int input;
      System.out.println("Welcome to the Weather Forecaster.");
      
      Season s = new Season();
      Temperature t = new Temperature();
      Weather w = new Weather();
      
      input = menu();
      while (input != 6)
      {
         if (input == 1)
         {
            setTemperatureP(t);
         }
         else if (input == 2)
         {
            setSeason(s);
         }
         else if (input == 3)
         {
            setWeather(w, t);
         }
         else if (input == 4)
         {
            forecast(w, t, s);
         }
         else if (input == 5)
         {
            printWeather(w, t);
         }
         else
         {
            System.out.println("Invalid input");
         }
         input = menu();
      }
   }
   //prints the menu code
   public static int menu()
   {
      Scanner scan = new Scanner(System.in);
      int input;
      do
      {
         System.out.println();
         System.out.println("1. Set temperature preference\n" + "2. Set season\n" + "3. Set weather\n" 
            + "4. Get forecast\n" + "5. Print the weather\n" + "6. Quit");
         System.out.print("Enter choice: ");
         input = scan.nextInt();
         System.out.println();
         if (input < 1 || input > 6)
         {
            System.out.println("Invalid input");
         }
      }
      while (input < 1 || input > 6);
      return input;
   }
   //Temperature preference
   public static void setTemperatureP(Temperature t)
   {
      String p;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter temperature preference (C/F): ");
      p = scan.nextLine().toUpperCase();
      if (p.equals("F") || p.equals("C"))
      {
         t.setScale(p.charAt(0));
      }
      else
      {
         System.out.println("Invalid Input");
      }
   }
   //Season input
   public static void setSeason(Season s)
   {
      String result;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter season: ");
      result = scan.nextLine().toLowerCase();
      if (result.equals("winter") || result.equals("summer") || result.equals("spring") 
         || result.equals("fall") || result.equals("autumn"))
      {
         s.setSeason(result);
      }
      else
      {
         System.out.println("Invalid input");
      }
   }
   //Weather input
   public static void setWeather(Weather w, Temperature t)
   {
      int temp;
      int h;
      int ws;
      String wd;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter temperature: ");
      temp = scan.nextInt();
      System.out.print("Enter humidity: ");
      h = scan.nextInt();
      System.out.print("Enter windspeed: ");
      ws = scan.nextInt();
      System.out.print("Enter wind direction: ");
      wd = scan.next();
      System.out.println();
      t.setTemp(temp);
      w.setTemperature(t);
      w.setHumidity(h);
      w.setWindSp(ws);
      w.setWindDir(wd);     
   }
   //Forecast
   public static void forecast(Weather w, Temperature t, Season s)
   {
      String forecast = "";
      if (s.getSeason().equals("winter"))
      {
         double temp = t.getTemp();
         if (t.getScale() == 'C')
         {
            temp = (temp - 9 / 5) + 32;
         }
         if (temp < 10 && w.getWindSp() > 15)
         {
            forecast = "frigid";
         }
         else if (temp >= 10 && temp <= 30 && w.getHumidity() >= 80)
         {
            forecast = "snow";
         }
         else if (temp >= 28 && temp <= 33 && w.getHumidity() >= 60 && w.getHumidity() <= 80)
         {
            forecast = "icy";
         }
         else if (temp > 40)
         {
            forecast = "warm";
         }
         else
         {
            forecast = "cold";
         }         
      }
      else if (s.getSeason().equals("summer"))
      {
         double temp = t.getTemp();
         if (t.getScale() == 'F')
         {
            temp = (temp - 9 / 5) + 32;
         }
         if (temp >= 32 && w.getWindSp() < 10 && w.getHumidity() >= 70)
         {
            forecast = "steamy";
         }
         else if (temp >= 32 && w.getWindSp() >= 20 && w.getHumidity() >= 70)
         {
            forecast = "stormy";
         }
         else if (temp >= 30 && w.getHumidity() < 50)
         {
            forecast = "dry heat";
         }
         else if (temp < 32 && temp >= 30 && w.getWindSp() >= 20)
         {
            forecast = "hot and windy";
         }
         else if (temp >= 30)
         {
            forecast = "hot";
         }
         else
         {
            forecast = "warm";
         }
      }
      else if (s.getSeason().equals("fall") || s.getSeason().equals("autumn"))
      {
         double temp = t.getTemp();
         if (t.getScale() == 'C')
         {
            temp = (temp - 9 / 5) + 32;
         }
         if (temp >= 65 && temp < 80 && w.getWindSp() < 15 && w.getHumidity() <= 60)
         {
            forecast = "nice";
         }
         else if (temp >= 80)
         {
            forecast = "too warm";
         }
         else if (temp >= 40 && temp < 65 && w.getWindSp() > 15)
         {
            forecast = "chilly";
         }
         else if (w.getHumidity() >= 80)
         {
            forecast = "rainy";
         }
         else
         {
            forecast = "typical";
         }
      }
      else if (s.getSeason().equals("spring"))
      {
         double temp = t.getTemp();
         if (t.getScale() == 'C')
         {
            temp = (temp - 9 / 5) + 32;
         }
         if (temp > 65 && temp <= 80 && w.getWindSp() >= 20 && w.getHumidity() >= 80)
         {
            forecast = "stormy";
         }
         else if (temp < 50)
         {
            forecast = "chilly";
         }
         else if (w.getHumidity() < 80 && w.getWindSp() >= 20)
         {
            forecast = "windy";
         }
         else
         {
            forecast = "pleasant";
         }
      }
      System.out.println("Forecast is " + forecast);
   }
   //pirnts the weather
   public static void printWeather(Weather w, Temperature t)
   {
      double degrees = t.getTemp();
      int ws = w.getWindSp();
      int h = w.getHumidity();
      String wd = w.getWindDir();
      
      System.out.println("The weather is currently " + t
         + " with " + h + "% humidity and a " + ws + " mph wind from the " + wd);
   }


}   
      



















   
