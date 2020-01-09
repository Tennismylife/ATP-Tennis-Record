import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	private static String currentWrite="";
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
	private static Set<String> winners;
	private static String category;
	private static String currentCategory;
	private static String plot;
	private static String currentLoser;
	private static String loser;
	private static String currentWinnerId;
	private static String currentLoserId;
	private static String winnerId;
	private static String LoserId;
	private static String loserId;


	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		
		
		line1.removeIf(s -> s.contains("Davis Cup"));
		line2.removeIf(s -> s.contains("Davis Cup"));
		line1.removeIf(s -> s.contains("Fed Cup"));
		line2.removeIf(s -> s.contains("Fed Cup"));
		
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));
		
		winners = new TreeSet<String>();
        listWinner = new ArrayList<String>();
		//searchH2H();
		search2Masters();
	     //search2Wins();

	}
	
	
	//Script to search che biggest timespan between 2 wins
	private static void search2Wins() throws IOException {
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			currentRound = arrayString[29];
			category = arrayString[4];
			tournament = arrayString[1];
			if(tournament.contains("Wimbledon")) {
			currentWinner = arrayString[10];
			winners.add(currentWinner);
			}
			
		}
			
	
		for (Iterator<String> iter1 = winners.iterator(); iter1.hasNext();)
		{
			currentWinner = iter1.next();
			currentDate = arrayString[5];
			currentTournament = arrayString[1];
					
			System.out.println(currentWinner);
			
			LocalDate currentDat = LocalDate.of(Integer.parseInt(currentDate.substring(0,4)), Integer.parseInt(currentDate.substring(4,6)), Integer.parseInt(currentDate.substring(6,8)));
			
			line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
			line2.removeIf(s -> !s.contains(currentWinner));
			line2.removeIf(s -> s.contains("Davis Cup"));
			for (Iterator<String> iter2 = line2.listIterator(); iter2.hasNext();) 
			{
				arrayString2 = iter2.next().split(",");
				winner = arrayString2[10];
				round =  arrayString2[29];
				tournament = arrayString2[1];
				category = arrayString2[4];
				
				if(currentWinner.equals(winner) && round.equals("R128") && tournament.contains("Wimbledon")) 
			    {
				tournament = arrayString2[1];
				currentDate = arrayString2[5];
				date = arrayString2[5];
				LocalDate dat = LocalDate.of(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6)), Integer.parseInt(date.substring(6,8)));
				long days = ChronoUnit.DAYS.between(currentDat, dat);
				
				tournament = arrayString2[1];

				if(days > 1350) {
				currentWrite = currentWinner +", " + currentTournament +", " + processDate((currentDat.toString()).replace("-", "")) +", " +tournament +", " +processDate(date) +"," +days;
				w.write(currentWrite + "\n");
				w.flush();
				}

				currentDat = dat;
				currentTournament = tournament;
			    }
			
			}
		}
	}

	//Script to search the biggest timespan between 1st and last Round on a tournament or categories
	private static void search2Masters() throws IOException {
        int i = 0;

		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			plot = iter.next();
			
			if(plot.length() > 0)
			arrayString = plot.split(",");
			
			currentWinner = arrayString[10];
			//currentWinnerId = arrayString[7];
			
			currentLoser = arrayString[20];
		    //currentLoserId = arrayString[17];
		    
			currentTournament = arrayString[1];
			currentDate = processDate(arrayString[5]);
			currentCategory = arrayString[4];
		    currentRound = arrayString[29];
			
			//System.out.println(plot);
			
		    //if((!winners.contains(currentWinner)) && currentCategory.equals("G") && currentRound.equals("QF"))
			if((!winners.contains(currentWinner) && !winners.contains(currentLoser)) && (currentCategory.equals("F") && currentRound.equals("SF")))
			{
				
			for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) 
			{
				plot = iter2.next();
				if(plot.length() >0)
				arrayString2 = plot.split(",");
				//System.out.println(plot);
				
				winner = arrayString2[10];
				//winnerId = arrayString2[7];
				
				loser = arrayString2[20];
				//loserId = arrayString2[17];
				
				round = arrayString2[29];
				category = arrayString2[4];
				tournament = arrayString2[1];
				
				if((currentWinner.equals(winner) || currentWinner.equals(loser)) && (category.equals("F") && round.equals("SF")))
			    {
				 currentWrite = currentWinner +", " + currentTournament +", " + currentDate +", " +tournament +", " + processDate(arrayString2[5]);
				 System.out.println("Add winner: "+currentWinner +i);
				 winners.add(currentWinner);
			    }
				
				if((currentLoser.equals(winner) || currentLoser.equals(loser)) && (category.equals("F") && round.equals("SF")))
			    {
				 currentWrite = currentLoser +", " + currentTournament +", " + currentDate +", " +tournament +", " + processDate(arrayString2[5]);
				 System.out.println("Add loser: "+currentLoser +i);
				 winners.add(currentLoser);
			    }
				
					
			}
		
			System.out.println(currentWrite);
			w.write(currentWrite + "\n");
			w.flush();
			

			}
			}

			i++;
		}

	//Script to search che biggest timespan between the same H2H
	private static void searchH2H() throws IOException, RowsExceededException, WriteException, ParseException {
        int i = 0;
		
		for (Iterator<String> iter = line1.listIterator(i); iter.hasNext();) 
		{
			plot = iter.next();
			arrayString = plot.split(",");
			currentH2H = arrayString[10] +arrayString[20];
			currentH2H2 = arrayString[20] +arrayString[10];
			
			System.out.println(plot);
			
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
