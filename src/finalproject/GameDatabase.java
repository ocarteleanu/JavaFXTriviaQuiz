package finalproject;
import java.sql.*;
import java.util.ArrayList;

public class GameDatabase {
	static Player player;
	static ArrayList<Player> listOfPeople;
	public static void createNewDatabaseAndTable(String fileName) throws SQLException{
		String url = "jdbc:sqlite:C:/Users/octavian/javadatabase_programs/sqlite/db/" + fileName;
		try(Connection conn = DriverManager.getConnection(url)){
			if (conn != null){
				DatabaseMetaData meta = conn.getMetaData();			
				Statement statement1 = conn.createStatement();
				String createTable = "CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY,"
						+ " name TEXT NOT NULL, points INTEGER NOT NULL);";
				statement1.execute(createTable);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertPlayer(String name, int points) throws SQLException{
		String url = "jdbc:sqlite:C:/Users/octavian/javadatabase_programs/sqlite/db/gamedatabase.db";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			String insertString = "INSERT INTO players(name, points) VALUES(?,?);";
			PreparedStatement insertStatement = conn.prepareStatement(insertString);
			insertStatement.setString(1, name);
			insertStatement.setInt(2, points);			
			insertStatement.executeUpdate();
			insertStatement.close();
			conn.commit();
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}finally {
			try{
				if(conn != null){
					conn.close();
				}
			}catch (SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	public static ArrayList<Player> findAllPeople() throws SQLException{
		String url = "jdbc:sqlite:C:/Users/octavian/javadatabase_programs/sqlite/db/gamedatabase.db";
		Connection conn = null;
		listOfPeople = new ArrayList<>();
			
		try{
			conn = DriverManager.getConnection(url);
			String selectAll = "SELECT * FROM players;";
			Statement newStatement = conn.createStatement();
			ResultSet rs = newStatement.executeQuery(selectAll);
			
			while(rs.next()){
				player = new Player(rs.getString(2),rs.getInt(3));
				listOfPeople.add(player);
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return listOfPeople;
	}

}
