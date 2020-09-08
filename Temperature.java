// Name : Jake Peterson
// Class : CIST1400-005   Lab Section
// Colleagues : None
// Resources : None
public class Temperature
{
   private double degrees;
   private char scale;
   public Temperature()
   {
      this.degrees = 0;
      this.scale = 'C'; 
   }
   public Temperature(double temp, char sc)
   {
      sc = Character.toUpperCase(sc);
      if (temp >= -50 && temp <= 150)
      {
         this.degrees = temp;
      }
      else
      {
         temp = this.degrees;
      }
      if (sc == 'C' || sc == 'F')
      {
         this.scale = sc;
      }
      else
      {
         sc = this.scale;
      }          
   }
   public double getTemp()
   {
      return this.degrees;
   }
   public char getScale()
   {
      return this.scale;
   }
   public void set(double temp, char sc)
   {
      sc = Character.toUpperCase(sc);
      if (temp >= -50 && temp <= 150)
      {
         this.degrees = temp;
      }
      else
      {
         temp = this.degrees;
      }
      if (sc == 'C' || sc == 'F')
      {
         this.scale = sc;
      }
      else
      {
         sc = this.scale;
      } 
   }
   public void setTemp(double temp)
   {
      if (temp >= -50 && temp <= 150)
      {
         this.degrees = temp;
      }
   }
   public void setScale(char sc)
   {
      sc = Character.toUpperCase(sc);
      if (this.scale == 'C')
      { 
         if (sc == 'F')
         {
            this.degrees = (this.degrees * 9 / 5) + 32;
            this.scale = sc;
         }
      }
      else if (this.scale == 'F')
      {
         if (sc == 'C')
         {
            this.degrees = (this.degrees - 32) * 5 / 9;
            this.scale = sc;
         }
      }   
   }
   public String toString()
   {
      String result = "";
      result = String.format(this.degrees + " degrees " + this.scale);
      return result;
   }
   public boolean equals(Temperature other)
   {
      boolean result = false;
      if (this.getTemp() == other.getTemp()
         &&
         this.getScale() == other.getScale())
      {
         result = true;
      }
      return result;
   }

















  
}