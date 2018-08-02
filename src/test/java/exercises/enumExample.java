package exercises;

public class enumExample {
    public enum BootCampDays{
        DAYONE,
        DAYTWO,
        DAYTREE,
        DAYFOUR,
        DAYFIVE;
    }
    public static String checkBootCampDaysInfo(BootCampDays bootCampDays){
        switch(bootCampDays){
            case DAYONE:
                return "Zin in!";
            case DAYTWO:
                return "df";
            default:
                return "crusus is maar 5 dagen";
        }
    }
}
