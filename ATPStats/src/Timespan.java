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



//Script to search first and last H2H between 2 tennis player
public class Timespan {
	private static ArrayList<String> listWinner;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String currentH2H;
	private static String H2H;
	private static String currentWrite;
	private static String currentH2H2;
	private static String H2H2;
	private static String year;
	private static String mouth;
	private static String day;
	private static String winner;
	private static String tournament;
	private static String date;
	private static String currentWinner;
	private static String currentTournament;
	private static String currentDate;
	private static String currentRound;
	private static String round;


	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));
		
		listWinner = new ArrayList<String>();

		//searchH2H();
		search2Masters();

	}

	//Script to search che biggest timespan between 1st and last Masters 1000 title
	private static void search2Masters() throws IOException {
        int i = 0;
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			currentWinner = arrayString[10];
			currentTournament = arrayString[1];
			currentDate = processDate(arrayString[5]);
			currentRound =  arrayString[29];
			
			System.out.println(iter.next());
			
			//if is a Masters Series / Masters 1000 tournament
			if(currentTournament.contains("Masters") && currentTournament.length() > 9 && currentRound.equals("F")) {
			if(!listWinner.contains(currentWinner))
			{
				
			for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) 
			{
				arrayString2 = iter2.next().split(",");
				winner = arrayString2[10];
				tournament = arrayString2[1];
				date = arrayString2[5];
				round = arrayString2[29];
				
				if(currentWinner.equals(winner) && tournament.contains("Masters") && currentTournament.equals(tournament) && tournament.length() > 9 && round.equals("F")) 
			    {
					currentWrite = currentWinner +", " + currentTournament +", " + currentDate +", " +tournament +", " + processDate(arrayString2[5]);
				}
			
					
			}
			w.write(currentWrite + "\n");
			w.flush();
			listWinner.add(currentWinner);
			
			}
			
			
			}

			i++;
		}
	}

	//Script to search che biggest timespan between the same H2H
	private static void searchH2H() throws IOException, RowsExceededException, WriteException, ParseException {
        int i = 0;
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			currentH2H = arrayString[10] +arrayString[20];
			currentH2H2 = arrayString[20] +arrayString[10];
			
			//System.out.println(iter.next());
			
			if(!listWinner.contains(currentH2H) && !listWinner.contains(currentH2H2))
			{
				
			for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) 
			{
				arrayString2 = iter2.next().split(",");
				
				H2H = arrayString2[10] +arrayString2[20];
				H2H2 = arrayString2[20] +arrayString2[10];
				
				if (currentH2H.equals(H2H) || currentH2H2.equals(H2H2) || currentH2H.equals(H2H2) || currentH2H2.equals(H2H)) {
					currentWrite = processDate(arrayString2[5]);
				}
					
				
			}
			currentH2H = arrayString[10] +"," +arrayString[20] +"," +processDate(arrayString[5]) +",";
			
			w.write(currentH2H + currentWrite + "\n");
			w.flush();
			listWinner.add(currentH2H);
			listWinner.add(currentH2H2);
			}

			i++;
		}


	}
	
	private static String processDate(String data) {
		year = data.substring(0, 4);
		mouth = data.substring(4, 6);
		day = data.substring(6, 8);

		data = day + "/" + mouth + "/" + year;

		return data;
	}
}
