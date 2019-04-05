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


//Script to find tiebreak won to reach x Round
public class TiebreakFinder {

	
	private static String winner;
	private static ArrayList<Record> listTournament;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String score;
	private static String tournament;
	private static String date;
	private static int currentTiebreakWon;
	private static Record[] data = new Record[10000000];
	private static Record currentData;
	private static int numberTiebreak;
	private static ArrayList<Record> listUpdated;
	private static String year;
	private static String mouth;
	private static String day;
	private static String loser;
	
	
	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listTournament = new ArrayList<Record>();
		listUpdated = new ArrayList<Record>();
		
		search();

	}
	
	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
		int i = 0;
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			
			arrayString = iter.next().split(",");
			//if(round.equals("F")) 
			//{
				data[i] = new Record();
				data[i].setWinner(arrayString[10]);
				data[i].setTournament(arrayString[1]);
				data[i].setDate(processDate(arrayString[5]));
				data[i].setCurrentTiebreak(0);
				listTournament.add(data[i]);
				i++;
			//}
			
			//if(round.equals("F")) 
			//{
				data[i] = new Record();
				data[i].setWinner(arrayString[20]);
				data[i].setTournament(arrayString[1]);
				data[i].setDate(processDate(arrayString[5]));
				data[i].setCurrentTiebreak(0);
				listTournament.add(data[i]);
				i++;
			//}
			
			
		}
		
	   for (Iterator<String> iter2 = line2.iterator(); iter2.hasNext();) 
	   {
		 int j = 0;
		 arrayString2 = iter2.next().split(",");
		 
		 winner = arrayString2[10];
		 loser = arrayString2[20];
		 tournament = arrayString2[1];
		 date = processDate(arrayString2[5]);
		 score = arrayString2[27];
		 
		 System.out.println(tournament +"," +date);
		 
		 for (Iterator<Record> iter4 = listTournament.listIterator(j); iter4.hasNext();) 
			{
				currentData = iter4.next();
				
				if(currentData.getWinner().equals(winner) && currentData.getTournament().equals(tournament) && currentData.getDate().equals(date))
				{
					numberTiebreak = countString(score, "7-6");
					currentTiebreakWon = currentData.getCurrentTiebreak() + numberTiebreak;
					currentData.setCurrentTiebreak(currentTiebreakWon);
					if(!listUpdated.contains(currentData)) listUpdated.add(currentData);
				}
				if(currentData.getWinner().equals(loser) && currentData.getTournament().equals(tournament) && currentData.getDate().equals(date)) 
				{
					numberTiebreak = countString(score, "6-7");
					currentTiebreakWon = currentData.getCurrentTiebreak() + numberTiebreak;
					currentData.setCurrentTiebreak(currentTiebreakWon);
					if(!listUpdated.contains(currentData)) listUpdated.add(currentData);
					
				}
				
				
			}
		 
		 j++;

	    }
	   
		for (Iterator<Record> iter4 = listUpdated.iterator(); iter4.hasNext();) 
		{
			w.write(iter4.next() +"\n");
			w.flush();
			
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
		mouth = data.substring(4, 6);
		day = data.substring(6, 8);

		data = day + "/" + mouth + "/" + year;

		return year;
	}
}



class Record{
	String winner;
	String tournament;
	String date;
	int currentTiebreak;
	
	
	public Record(String winner, String tournament, String date, int currentTiebreak) {
		this.winner = winner;
		this.tournament = tournament;
		this.date = date;
		this.currentTiebreak= currentTiebreak;
	}
	
	
	public Record() {
		// TODO Auto-generated constructor stub
	}
	
	public String getWinner() {
		return winner;
	}


	public void setWinner(String winner) {
		this.winner = winner;
	}


	public String getTournament() {
		return tournament;
	}


	public void setTournament(String tournament) {
		this.tournament = tournament;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getCurrentTiebreak() {
		return currentTiebreak;
	}


	public void setCurrentTiebreak(int currentTiebreak) {
		this.currentTiebreak = currentTiebreak;
	}

	@Override
	public String toString() {
		return winner +","  +tournament + "," +date + "," +currentTiebreak;
	}
}

