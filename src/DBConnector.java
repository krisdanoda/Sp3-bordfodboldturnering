import java.sql.*;
import java.util.ArrayList;

public class DBConnector implements IO{

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/sp3"; //todo:create database

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private ArrayList<Team> teamData = new ArrayList<>();
    private ArrayList<Match> matchList = new ArrayList<>();

    public ArrayList<Team> readTeamData() {

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
                int id = rs.getInt("team_id");
                String name = rs.getString("team_name");
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
        return teamData;
    }

    public Match[] readMatchData() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Match> matchData = new ArrayList<>();
        Match[] matches;
        try {
            //STEP 1: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 2: Create a statement
            stmt = conn.createStatement();

//STEP 3: Execute a query
            String sql = "SELECT * FROM TMatch";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("match_id");
                int team1 = rs.getInt("teamid1");
                int team2 = rs.getInt("teamid2");
                int score1 = rs.getInt("score1");
                int score2 = rs.getInt("score2");
                String date = rs.getString("match_date");


                Team team1temp = null;
                Team team2temp = null;
                for (Team team: teamData){
                    if(team.getTeamID()==team1){
                        team1temp=team;
                    }
                    if (team.getTeamID()==team2){
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

        matches = matchData.toArray(new Match[0]);
        return matches;
    }

    public void saveGameData(Tournament tournament) {
        Connection conn = null;

        //save Teams to database
        String sql  = "INSERT INTO Team(team_id, team_name, score) "
                + "VALUES (?,?,?) ON DUPLICATE KEY UPDATE score=?";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(int i = 0; i <  tournament.getTeams().size(); i++){


                Team p = tournament.getTeams().get(i);

                /*
                System.out.println("i = " + i + ", id = " + p.getTeamID() + ", team = " + p.getName() +
                        ", score = " + p.getScore());
                System.out.println();
*/
                pstmt.setInt(1,p.getTeamID());
                pstmt.setString(2,p.getName());
                pstmt.setInt(3,p.getScore());
                pstmt.setInt(4,p.getScore());
                pstmt.addBatch();

            }

            pstmt.executeBatch();

        }catch (SQLException e){

            e.printStackTrace();



        }
        //Save match to database
        sql = "INSERT INTO TMatch (match_id, teamid1, teamid2, score1, score2, match_date) " +
                "VALUES (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE teamid1=?,teamid2=?,score1=?,score2=?, match_date=?";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(int i = 0; i <  tournament.getMatches().length; i++){

                Match match = tournament.getMatches()[i];

                pstmt.setInt(1,match.getMatchID());
                pstmt.setInt(2,match.getTeam1().getTeamID());
                pstmt.setInt(3,match.getTeam2().getTeamID());
                pstmt.setInt(4,match.getScore1());
                pstmt.setInt(5,match.getScore2());
                pstmt.setString(6,match.getDate());
                pstmt.setInt(7,match.getTeam1().getTeamID());
                pstmt.setInt(8,match.getTeam2().getTeamID());
                pstmt.setInt(9,match.getScore1());
                pstmt.setInt(10,match.getScore2());
                pstmt.setString(11,match.getDate());
                pstmt.addBatch();

            }

            pstmt.executeBatch();

        }catch (SQLException e){

            e.printStackTrace();

        }catch (NullPointerException e) {

        }

    }
}

