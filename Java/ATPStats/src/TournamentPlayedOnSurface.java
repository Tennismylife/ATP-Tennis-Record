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

public class TournamentPlayedOnSurface {
	private static String winner;
	private static String loser;
	private static ArrayList<String> listTournament, listPlayer;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static int counter = 0;
	private static String surface;
	private static String currentTournament;
	private static String currentPlayer;
	private static String currentSurface;
	private static String surfaceToSearch;
	private static String nameTournament;
	private static String currentWinner;
	private static String currentLoser;
	private static String playedTournaments;
	private static String year;
	private static String ageWinner;
	private static String onlyNameTournament;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listPlayer = new ArrayList<String>();
		surfaceToSearch = "Hard";
		search();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
		int i = 0;

		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			nameTournament = arrayString[1];
			currentSurface = arrayString[2];
			
			
			if(!nameTournament.contains("Davis Cup") && currentSurface.equals("Clay"))
			{
		
		    //Get the players list
			currentPlayer = arrayString[10];
	
			System.out.println(iter.next());
				if (!listPlayer.contains(currentPlayer)) 
				{
					listTournament = new ArrayList<String>();
					for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) 
					{
						arrayString2 = iter2.next().split(",");

						currentTournament = arrayString2[1] +"," +processDate(arrayString2[5]);
						onlyNameTournament = arrayString2[1];
				        surface = arrayString2[2];
						winner = arrayString2[10];
						ageWinner = arrayString2[14];
						//loser = arrayString2[20];

						if (!listTournament.contains(onlyNameTournament) && surface.equals("Clay") && !currentTournament.contains("Davis Cup")) 
						{
							if (currentPlayer.equals(winner)) {
								listTournament.add(onlyNameTournament);
								w.write(currentPlayer +"," +currentTournament +"," +ageWinner+"\n");
								w.flush();
								
								//counter++;
							}
						}
					}

					
					counter = 0;
					listPlayer.add(currentPlayer);

				}
				i++;
			}
		}

	}

	public static int countString(String str, String find) {
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {

			lastIndex = str.indexOf(find, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += find.length();
			}
		}
		return count;
	}
	
	private static String processDate(String data) {
		year = data.substring(0, 4);

		return year;
	}

}
