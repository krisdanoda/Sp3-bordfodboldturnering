import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {
    private Scanner scanner;
    private File file;
    private String path = "data/data.txt";
    private ArrayList<String> data;
    private FileWriter writer;
    private Tournament tournament;

    public FileController(Tournament tournament) {
        this.tournament = tournament;
    }

    public ArrayList<String> readFile() {
        data = new ArrayList<>();
        file = new File(path);
        String nextWord;
        int i = 0;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                nextWord = scanner.nextLine();
                data.add(nextWord);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getCause());
        }
        return data;
    }

    public void saveTeam(Team team) {
        String teamAsString = "";

        teamAsString = "Team," + team.getName() + "," + team.getScore() + "\n";
        for (Player player : team.getPlayers()) {
            teamAsString += "Player," + player.getName() + "\n";
        }

        try {
            writer = new FileWriter(path);
            writer.write(teamAsString);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void readTeam() {
        ArrayList<String> data = readFile();
        Team tmpteam = new Team();
        for (int i = 0 ; i < data.size() ; i++) {
           String[] nextLine = data.get(i).split(",");
            switch (nextLine[0]) {
               case "Team":
                   tmpteam.setName(nextLine[1]);
                   tmpteam.setScore(Integer.parseInt(nextLine[2]));
                   break;
               case "Player":
                   tmpteam.addPlayer(new Player(nextLine[1]));
           }
        }
        System.out.println(tmpteam.getName());
        System.out.println(tmpteam.getScore());
        System.out.println(tmpteam.getPlayers());
    }
    public void setCloseSignUp() {
        String closeSignUpAsString ="closeSignUp,true";
        try {
            writer = new FileWriter(path);
            writer.write(closeSignUpAsString);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
