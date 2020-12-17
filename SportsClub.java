

import java.io.Serializable;

public abstract class SportsClub implements Serializable {

    //abstract class
    private String clubName;
    private String clubLocation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return getClubName().equals(that.getClubName());
    }

    public SportsClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;

    }


    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }


    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }


    @Override
    public String toString() {
        return  clubName;
    }

    public abstract String getUniversityName();

    public abstract String getSchoolName();
}