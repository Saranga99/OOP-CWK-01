import java.io.Serializable;
import java.util.Date;

public class FootballMatch implements Serializable {
    private FootballClub teamA;
    private FootballClub teamB;
    private int teamAScore;
    private int teamBScore;
    private Date date;

    public FootballMatch() {
    }

    public FootballClub getTeamA() {
        return teamA;
    }

    public void setTeamA(FootballClub teamA) {
        this.teamA = teamA;
    }

    public FootballClub getTeamB() {
        return teamB;
    }

    public void setTeamB(FootballClub teamB) {
        this.teamB = teamB;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "team A        : " + teamA +
                "\nteam B        : " + teamB +
                "\nteam-A Score  : " + teamAScore +
                "\nteam-B Score  : " + teamBScore +
                "\ndate          : " + date;
    }
}
