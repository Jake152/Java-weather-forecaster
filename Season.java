// Name : Jake Peterson
// Class : CIST1400-005   Lab Section
// Colleagues : None
// Resources : None
public class Season
{
   private String season;
   public Season()
   {
      setSeason("winter");
   }
   public String getSeason()
   {
      return this.season;
   }
   public void setSeason(String newSeason)
   {
      newSeason = newSeason.toLowerCase();
      if (newSeason.equals("summer") || newSeason.equals("spring") || newSeason.equals("fall")
         || newSeason.equals("winter") || newSeason.equals("autumn"))
      {
         this.season = newSeason;
      }
   }
   public String toString()
   {
      return this.season;
   }
   public boolean equals(Season other)
   {
      boolean result = false;
      if (this.getSeason() == other.getSeason())
      {
         result = true;
      }
      if (this.getSeason().equals("fall") && other.getSeason().equals("autumn"))
      {
         result = true;
      }
      if (this.getSeason().equals("autumn") && other.getSeason().equals("fall"))
      {
         result = true;
      }
      return result;
   }
   
      
  
}

