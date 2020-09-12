public class Weather
{
   private Temperature temp;
   private int humidity;
   private int windspeed;
   private String windDirection;
   private Season s;
   public Weather()
   {
      temp = new Temperature();
      humidity = 50;
      windspeed = 0;
      windDirection = "N";
      s = new Season();
   }
   public Weather(double t, char sc, String whichSeason)
   {
      this();
      if (t >= -50 && t <= 150 && sc == 'C' || sc == 'F')
      {
         temp.set(t, sc);
      }
      humidity = 50;
      windspeed = 0;
      windDirection = "W";
      whichSeason = whichSeason.toLowerCase();
      if (whichSeason.equals("summer") || whichSeason.equals("spring") || whichSeason.equals("fall")
         || whichSeason.equals("winter") || whichSeason.equals("autumn"))
      {
         s.setSeason(whichSeason);
      }
   }
   public String getSeason()
   {
      return s.getSeason();
   }
   public void setSeason(String newSeason)
   {
      s.setSeason(newSeason);
   }
   public Temperature getTemp()
   {
      return temp;
   }
   public int getHumidity()
   {
      return humidity;
   }
   public int getWindSp()
   {
      return windspeed;
   }
   public String getWindDir()
   {
      return windDirection;
   }
   public void setTemperature(Temperature t)
   { 
      t = new Temperature();
   }
   public void setHumidity(int h)
   {
      if (h >= 0 && h <= 100)
      {
         this.humidity = h;
      }
   }
   public void setWindSp(int sp)
   {
      if (sp >= 0)
      {
         this.windspeed = sp;
      }
   }

   //I replace the if statement with a switch --
   //I think the bug was happening somewhere in the OR of the if statement
   public void setWindDir(String dir)
   {
      dir = dir.toUpperCase();
      switch (dir){
         case "N":
            windDirection = "N";
            break;
         case "E":
            windDirection = "E";
            break;
         case "S":
            windDirection = "S";
            break;
         case "W":
            windDirection = "W";
            break;
         case "NE":
            windDirection = "NE";
            break;
         case "NW":
            windDirection = "NW";
            break;
         case "SE":
            windDirection = "SE";
            break;
         case "SW":
            windDirection = "SW";
            break;
         default:
            windDirection = "Unknown";
            break;
      }
   }
   @Override
   public String toString()
   {
      String result = "";
      result = "The weather is currently " + getTemp() + " with " + getHumidity()
         + "% humidity and a " + getWindSp() + " mph wind from the " + getWindDir();
      return result; 
   }
   public boolean equals(Weather other)
   {
      boolean result = false;
      if (this.getTemp() == other.getTemp()
         &&
         this.getHumidity() == other.getHumidity())
      {
         result = true;
      }
      return result;
   }
}
   