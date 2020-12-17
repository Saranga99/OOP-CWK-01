
import java.io.Serializable;

public class FootballMatch implements Serializable {
    private FootballClub homeTeam;
    private FootballClub awayTeam;
    private int homeGoals;
    private int awayGoals;
    private Date date;


    public FootballMatch() {
    }

    public FootballClub getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballClub homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballClub getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballClub awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "team A        : " + homeTeam.getClubName() +
                "\nteam B        : " + awayTeam.getClubName() +
                "\nteam-A Score  : " + homeGoals +
                "\nteam-B Score  : " + awayGoals +
                "\ndate          : " + date;
    }
}
