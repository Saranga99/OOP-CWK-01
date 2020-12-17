public class FootballClub extends SportsClub implements Comparable<FootballClub> {

    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int scoredGoalsCount;
    private int receivedGoalsCount;
    private int goalDifferenceCount;
    private int points;
    private int matchesPlayed;
    private double winingPercentage;


    public FootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public int getScoredGoalsCount() {
        return scoredGoalsCount;
    }

    public int getReceivedGoalsCount() {
        return receivedGoalsCount;
    }

    public int getGoalDifferenceCount() {
        goalDifferenceCount = getScoredGoalsCount() - getReceivedGoalsCount();
        return goalDifferenceCount;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getWiningPercentage() {
        return winingPercentage;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

    public void setScoredGoalsCount(int scoredGoalsCount) {
        this.scoredGoalsCount = scoredGoalsCount;
    }

    public void setReceivedGoalsCount(int receivedGoalsCount) {
        this.receivedGoalsCount = receivedGoalsCount;
    }

    public void setGoalDifferenceCount(int goalDifferenceCount) {
        this.goalDifferenceCount = goalDifferenceCount;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setWiningPercentage(double winingPercentage) {
        try {
            if (winingPercentage > -1 && winingPercentage < 101) {
                this.winingPercentage = winingPercentage;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public String toString() {
        String details = super.toString();
        return details;

    }

    @Override
    public String getUniversityName() {
        return null;
    }

    @Override
    public String getSchoolName() {
        return null;
    }

    @Override
    public int compareTo(FootballClub fC) {

        if (this.getPoints() < fC.getPoints()) {
            return 1;
        }
        if (this.getPoints() > fC.getPoints()) {
            return -1;
        } else {
            if (this.getGoalDifferenceCount() > fC.getGoalDifferenceCount()) {
                return -1;
            } else {
                return 1;
            }
        }


    }
}