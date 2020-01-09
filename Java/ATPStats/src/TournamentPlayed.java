import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TournamentPlayed {
	private static ArrayList<String> listTournament;
	private static ArrayList<String> listPlayer, listYear;
	private static ArrayList<Played> listPlayed;
	private static Played[] played;
	private static BufferedWriter w;
	private static List<String> line1;
	private static String[] arrayString;
	private static Played currentPlayer;
	private static String categoryToSearch = "M"; // G = Grand Slam, M = Masters, A = ATP
	private static String year;
	private static String mouth;
	private static String day;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		//Load all Database into List
		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));

		long startTime = System.currentTimeMillis();
		listPlayer = new ArrayList<String>();
		listPlayed = new ArrayList<Played>();
		listYear = new ArrayList<String>();
		played = new Played[line1.size()];
		search();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println(elapsedTime);

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {

		int i = 0;

		//Remove all the Davis Cup matches
		line1.removeIf(s -> s.contains("Davis Cup"));
		
		// Collect all the players
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			String record =iter.next();
			arrayString = record.split(",");
			String winner = arrayString[10];
			String category = arrayString[4];
			String round = arrayString[29];
			String surface = arrayString[2];
			
			if (!listPlayer.contains(winner) && category.equals("M") && round.contains("SF"))
			{
				played[i] = new Played();
				played[i].setPlayer(winner);
				listPlayed.add(played[i]);
				listPlayer.add(winner);
			}
			i++;
//			String loser = arrayString[20];
//			if (!listPlayer.contains(loser)) {
//				played[i] = new Played();
//				played[i].setPlayer(loser);
//				listPlayed.add(played[i]);
//				listPlayer.add(loser);
//			}
		}
		
		
		i = 0;
		for (Iterator<Played> iter2 = listPlayed.listIterator(); iter2.hasNext();)
		{
			System.out.println(listPlayed.size() - i);
			currentPlayer = iter2.next();
			listTournament = new ArrayList<String>();
			listYear = new ArrayList<String>();
			//System.out.println(currentPlayer);
			
			line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
			line1.removeIf(s -> !s.contains(currentPlayer.getPlayer()));
			line1.removeIf(s -> s.contains("Davis Cup"));
			
			for (Iterator<String> iter3 = line1.listIterator(); iter3.hasNext();) 
			{
				arrayString = iter3.next().split(",");
				
				String currentTournament = arrayString[1] + arrayString[5];

					String winner = arrayString[10];
					String loser = arrayString[20];
					String category = arrayString[4];
					String currentYear = processDate(arrayString[5]);
                    String surface = arrayString[2];
                    String round = arrayString[29];
                    String ageWinner = arrayString[14];
                    String score = arrayString[27];
                    
                    if (!listTournament.contains(currentTournament) && !listYear.contains(currentYear) && category.equals("M") && round.equals("F"))
                    	{
						if (currentPlayer.getPlayer().equals(winner) || currentPlayer.getPlayer().equals(loser)) 
						{
							currentPlayer.setPlayedTournaments(currentPlayer.getPlayedTournaments() + 1);
							listTournament.add(currentTournament);
							listYear.add(currentYear);
						}
					
					}
                    
			}
			i++;
		}

		for (Iterator<Played> iter4 = listPlayed.iterator(); iter4.hasNext();) {
			w.write(iter4.next() + "\n");
			w.flush();

		}

	}
	
	private static String processDate(String data) {
		year = data.substring(0, 4);
		mouth = data.substring(4, 6);
		day = data.substring(6, 8);

		data = day + "/" + mouth + "/" + year;

		return year;
	}

}

class Played {

	String player;
	int playedTournaments;
	
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPlayedTournaments() {
		return playedTournaments;
	}

	public void setPlayedTournaments(int playedTournaments) {
		this.playedTournaments = playedTournaments;
	}

	@Override
	public String toString() {
		return player + "," + playedTournaments;
	}

}
