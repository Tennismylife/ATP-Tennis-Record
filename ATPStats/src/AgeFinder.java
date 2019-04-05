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

public class AgeFinder {
	private static ArrayList<String> listPlayer;
	private static BufferedWriter w;
	private static List<String> line1;
	private static String[] arrayString;
	private static String year;
	private static String mouth;
	private static String day;
	private static String winner;
	private static String tournament;
	private static String date;
	private static String ageWinner;
	private static String ageLoser;
	private static String loser;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listPlayer = new ArrayList<String>();

		search();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			arrayString = iter.next().split(",");
			tournament = arrayString[1];
			date = arrayString[5];

			if (tournament.contains("Carlo")) 
			{
				
				winner = arrayString[10];
				ageWinner = arrayString[14];
				if(ageWinner.length() > 4)
			    ageWinner = ageWinner.substring(0,5).replace(".", ",");
				
				loser = arrayString[20];
				ageLoser = arrayString[24];
				if(ageLoser.length() > 4)
			    ageLoser = ageLoser.substring(0,5).replace(".", ",");
				
				year = "$" +processDate(date);
				if (!listPlayer.contains(winner + year +"$" +ageWinner))
					listPlayer.add(winner + year +"$" +ageWinner);
				if (!listPlayer.contains(loser + year +"$" +ageLoser))
					listPlayer.add(loser + year +"$" +ageLoser);
			}

			}
		
		
		for (Iterator<String> iter = listPlayer.iterator(); iter.hasNext();) {
			w.write(iter.next() +"\n");
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