import java.util.ArrayList;
import java.util.List;

public class Knockout extends Tournament{
    private ArrayList<Match[]> rounds;

    public Knockout() {
        rounds = new ArrayList<>();
        createRound();
    }

    private void createRound() {
        teams.add(new Team("test"));
        teams.add(new Team("1test"));
        teams.add(new Team("2test"));
        teams.add(new Team("3test"));
        teams.add(new Team("3test"));
        if (teams.size() % 2 ==1 ) {
            //hvis der er ulige antalt hold
            Match[] matches = new Match[ (int)(teams.size()/2) + 1 ];
            int counter = 0;
            Team reserve;
            for (int i = 0 ; i < matches.length ; i+=2 ) {
                if (counter == matches.length) {
                    reserve = teams.get(i);
                    break;
                }
                matches[counter] = new Match(teams.get(i), teams.get(i+1));
                counter++;
                }

        } else {
            //hvis der er lige antalt
            Match[] matches = new Match[ (int)(teams.size()/2)];
            System.out.println(matches.length);
        }

    }


}


