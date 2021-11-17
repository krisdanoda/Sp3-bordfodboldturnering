import java.util.ArrayList;

public interface IO {
    ArrayList<Team> readTeamData();
    public Match[] readMatchData();
    public void saveGameData(Tournament tournament);

    }
