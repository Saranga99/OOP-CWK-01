public class UniversityFootballClub extends FootballClub {
    private String universityName;

    public UniversityFootballClub(String clubName, String clubLocation, String universityName) {
        super(clubName, clubLocation);
        this.universityName = universityName;

    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {

        this.universityName = universityName;

    }
}