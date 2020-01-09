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



public class NotDroppingSet {
	private static ArrayList<String> listTournamentWinner;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String record;
	private static int playedSets;


	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		
		listTournamentWinner = new ArrayList<String>();

		search();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			playedSets = processScore(arrayString[27]);
			if(arrayString[29].equals("F"))
			{
		    if(Integer.parseInt(arrayString[28]) == 3 && playedSets <= 2)
		    	listTournamentWinner.add(arrayString[10] +","+ arrayString[1] +"," +arrayString[5]);
		     if(Integer.parseInt(arrayString[28]) == 5 && playedSets <= 3)
				listTournamentWinner.add(arrayString[10] +","+ arrayString[1] +"," +arrayString[5]);
			}
		}
		
		for (Iterator<String> iter2 = line2.iterator(); iter2.hasNext();) 
		{
				arrayString2 = iter2.next().split(",");
				record = arrayString2[10] +"," + arrayString2[1] +"," +arrayString2[5];
				playedSets = processScore(arrayString2[27]);
				if(listTournamentWinner.contains(record)) 
				{
					System.out.println(record);
		        if((Integer.parseInt(arrayString2[28]) == 3 && playedSets > 2) || (Integer.parseInt(arrayString2[28]) == 5 && playedSets > 3))
				{
					listTournamentWinner.remove(record);
					
				}
				}
		}
		
	
		for (Iterator<String> iter3 = listTournamentWinner.iterator(); iter3.hasNext();) 
		{
            w.write(iter3.next() +"\n");
		    w.flush();
		}
		


	}
	
	private static int processScore(String score) {
		int numberPlayedSet;
		numberPlayedSet = countChar(score, '-');
		return numberPlayedSet;
	}
	
	public static int countChar(String str, char c) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}

		return count;
	}
}
