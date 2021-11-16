import java.sql.*;
import java.util.ArrayList;

public class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/Sp3"; //todo:create database

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private ArrayList<Team> teamData = new ArrayList<>();
    private ArrayList<Match> matchList = new ArrayList<>();
    public void readTeamData() {

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Team";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            //Retrieve Team Data
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                teamData.add(new Team(id, name, score));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        //return teamData;
    }

    public ArrayList<Match> readMatchData() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 1: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 2: Create a statement
            stmt = conn.createStatement();

//STEP 3: Execute a query
            String sql = "SELECT * FROM Match";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Match> matchData = new ArrayList<>();

            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String team1 = rs.getString("team1");
                String team2 = rs.getString("team2");
                int score1 = rs.getInt("score1");
                int score2 = rs.getInt("score2");
                String date = rs.getString("date");


                Team team1temp = null;
                Team team2temp = null;
                for (Team team: teamData){
                    if(team.equals(team1)){
                        team1temp=team;
                    }
                    if (team.equals(team2)){
                        team2temp=team;
                    }
                }
                matchData.add(new Match(id, team1temp, team2temp,score1,score2,date));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return matchList;
    }

    public void saveGameData(ArrayList<Player> players) {
        Connection conn = null;
        String sql  = "INSERT INTO Player(id, player_name, balance, position, isNext) "
                + "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE balance=?,position = ?, isNext=?";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(int i = 0; i <  players.size(); i++){

                Player p = players.get(i);

                pstmt.setInt(1,p.getId());
                pstmt.setString(2,p.getName());
                pstmt.setInt(3,p.account.getBalance());
                pstmt.setInt(4,p.position);
                pstmt.setBoolean(5, Main.currentPlayer == p);


                pstmt.setInt(6,p.account.getBalance());
                pstmt.setInt(7,p.position);
                pstmt.setBoolean(8, Main.currentPlayer == p);

                pstmt.addBatch();

            }

            pstmt.executeBatch();


        }catch (SQLException e){

            e.printStackTrace();



        }



    }
}

