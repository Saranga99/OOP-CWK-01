public class FootballClub extends SportsClub {

    private int winCount;
    private int drawCount;
    private int defeatCount;
    private int scoredGoalsCount;
    private int receivedGoalsCount;
    private int goalDifferenceCount;
    private int points;
    private int matchesPlayed;

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
        return getScoredGoalsCount()-getReceivedGoalsCount();
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
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

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public String toString() {
        String details = super.toString();
        return details +
                "winCount=" + winCount +
                ", drawCount=" + drawCount +
                ", defeatCount=" + defeatCount +
                ", scoredGoalsCount=" + scoredGoalsCount +
                ", receivedGoalsCount=" + receivedGoalsCount +
                ", points=" + points +
                ", matchesPlayed=" + matchesPlayed;
    }

    @Override
    public String getUniversityName() {
        return null;
    }

    @Override
    public String getSchoolName() {
        return null;
    }
}