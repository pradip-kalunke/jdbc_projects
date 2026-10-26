import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayersDao {

	public List<Player> getAllPlayers() {
		List<Player> allPlayers = new ArrayList<>();
		try {
			Connection con = MyDbCong.getMySQLDbConnection();
			Statement st = con.createStatement();
			String query = "select * from player";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Player p = new Player();
				p.setPid(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setTeam_name(rs.getString(3));
				p.setCategory(rs.getString(4));
				p.setScore(rs.getInt(5));
				p.setCatches(rs.getInt(6));
				p.setWickets(rs.getInt(7));
				allPlayers.add(p);
			}
			return allPlayers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	Player getById(int id) {
		String query = "SELECT pid, name, team_name, category, score, catches, wickets FROM player WHERE pid = ?";
		try (Connection con = MyDbCong.getMySQLDbConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return readPlayer(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	Player insertPlayer(Player p) {
		return null;
	}

	Player updatePlayer(int id, Player p) {
		String query = "UPDATE player SET name = ?, team_name = ?, category = ?, score = ?, catches = ?, wickets = ? WHERE pid = ?";
		try (Connection con = MyDbCong.getMySQLDbConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, p.getName());
			ps.setString(2, p.getTeam_name());
			ps.setString(3, p.getCategory());
			ps.setInt(4, p.getScore());
			ps.setInt(5, p.getCatches());
			ps.setInt(6, p.getWickets());
			ps.setInt(7, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return getById(id);
	}

	private Player readPlayer(ResultSet rs) throws java.sql.SQLException {
		Player p = new Player();
		p.setPid(rs.getInt("pid"));
		p.setName(rs.getString("name"));
		p.setTeam_name(rs.getString("team_name"));
		p.setCategory(rs.getString("category"));
		p.setScore(rs.getInt("score"));
		p.setCatches(rs.getInt("catches"));
		p.setWickets(rs.getInt("wickets"));
		return p;
	}

	Player deletePlayer(int id) {
		return null;
	}

	
	
	
}
