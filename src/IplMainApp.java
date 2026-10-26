import java.util.List;

public class IplMainApp {

	public static void main(String[] args) {
		System.out.println("Welcome to IPL.com");
		PlayerOperations playrsOps = new PlayerOperations();

		System.out.println("1. Get All Players All Teams  ");
		List<Player> allPlayersList = playrsOps.getAllPlayers();
		allPlayersList.forEach(System.out::println);

		System.out.println("\n2. Get All Players of given TeamName  ");
		List<Player> allPlayersGivenTeamName = playrsOps.getAllPlayersGivenTeamName("RCB");
		allPlayersGivenTeamName.forEach(System.out::println);

		System.out.println("\n3. Get All Batters of all Team  ");
		List<Player> allBatters = playrsOps.getAllPlayersByCategory("Batsman");
		allBatters.forEach(System.out::println);

		System.out.println("\n5. Get All Bowlers of all Team  ");
		List<Player> allBowlers = playrsOps.getAllPlayersByCategory("Bowler");
		allBowlers.forEach(System.out::println);

		System.out.println("\n5. Get All allAllRounder of all Team  ");
		List<Player> allAllRounder = playrsOps.getAllPlayersByCategory("All-Rounder");
		allAllRounder.forEach(System.out::println);

		System.out.println("\n6. Get Player By Id :   ");
		int id = 1;
		Player playerById = playrsOps.getPlayerById(id);
		System.out.println(playerById);

		System.out.println("\n7. Update Player By Id :   ");
		int updateid = 7; // Jadeja
		Player updatePlayer = playrsOps.getPlayerById(updateid);
// Now we have old player all data of given pid , Enter new updated fields
		updatePlayer.setTeam_name("RR");
		updatePlayer.setScore(updatePlayer.getScore() + 150);
		Player updatedPlayer = playrsOps.updatePlayer(updateid, updatePlayer);
		System.out.println(updatedPlayer);

		System.out.println("\n7. Delete Player By Id :   ");
		id = 1;
		Player deletePlayerById = playrsOps.deletePlayerById(id);
		System.out.println(deletePlayerById);

		System.out.println("\n7. insert new Player By Id :   ");
		Player playerNew = new Player(33, "Suryavanshi", "RR", "Batsman", 500, 0, 0);
		playerNew = playrsOps.insertPlayer(playerNew);
		System.out.println(playerNew);

		
		// 25 - 40 api/methods 
		// scanner --> 
		// teams --> 8   101 , team name  mi  pids -- 45, 31,,,,,
		// matches --> 
		// 
		
		
	}

}
