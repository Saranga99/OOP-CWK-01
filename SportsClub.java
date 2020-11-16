public class SportsClub{
    //abstract class
    
    private String clubName;
    private String clubLocation;
    private String statistics;
    
    public SportsClub() {

    }
    public String getClubName() {
        return clubName;
    }
    public String getClubLocation() {
        return clubLocation;
    }
    public String getStatistics() {
        return statistics;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    public void setClubLocation(String clubLocation) {
        this.clubLocation=clubLocation;
    }
    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }
}