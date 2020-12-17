

public class SchoolFootballClub extends FootballClub {
    private String schoolName;

    public SchoolFootballClub(String clubName, String clubLocation, String schoolName) {
        super(clubName, clubLocation);
        this.schoolName = schoolName;

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}