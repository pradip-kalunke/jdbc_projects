
import java.util.ArrayList;
import java.util.List;

public class PlayerOperations {

	List<Player> playersList = new ArrayList<>();
	PlayersDao playersDao = new PlayersDao();

	public List<Player> getAllPlayers() {
		playersList = playersDao.getAllPlayers();
		return playersList;
	}

	public List<Player> getAllPlayersGivenTeamName(String teamName) {
		playersList = playersDao.getAllPlayers();
		List<Player> playersGivenTeamName = new ArrayList<>();
		for (Player p : playersList) {
			if (teamName.equals(p.getTeam_name())) {
				playersGivenTeamName.add(p);
			}
		}
		return playersGivenTeamName;
	}

	public List<Player> getAllPlayersByCategory(String category) {
		playersList = playersDao.getAllPlayers();

		List<Player> allBatters = new ArrayList<>();
		for (Player p : playersList) {
			if (category.equalsIgnoreCase(p.getCategory())) {
				allBatters.add(p);
			}
		}
		return allBatters;
	}

	public Player getPlayerById(int id) {
		return playersDao.getById(id);
	}

	public Player updatePlayer(int updateid, Player updatePlayer) {
		if (updatePlayer == null) {
			throw new IllegalArgumentException("Player to update cannot be null");
		}
		updatePlayer.setPid(updateid);
		return playersDao.updatePlayer(updateid, updatePlayer);
	}

	public Player deletePlayerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Player insertPlayer(Player playerNew) {
		// TODO Auto-generated method stub
		return null;
	}

}
