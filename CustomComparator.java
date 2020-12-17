import java.util.Comparator;

public class CustomComparator {

    Comparator<FootballClub> sortByScoredGoalsCount = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub fC1, FootballClub fC2) {
            if (fC1.getScoredGoalsCount() > fC2.getScoredGoalsCount()) {
                return -1;
            } else if (fC1.getScoredGoalsCount() < fC2.getScoredGoalsCount()) {
                return 1;
            }
            return 0;

        }
    };
    Comparator<FootballClub> sortByWinCount = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub fC1, FootballClub fC2) {
            if (fC1.getWinCount() > fC2.getWinCount()) {
                return -1;
            } else if (fC1.getWinCount() < fC2.getWinCount()) {
                return 1;
            }
            return 0;

        }
    };
    
}



