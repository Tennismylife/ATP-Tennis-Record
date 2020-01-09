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



//Script to search the first and last title of a tennis player with its relative date
public class FirstLastWin {
	private static ArrayList<String> listLoser;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String year;
	private static String mouth;
	private static String day;
	private static String round;
	private static String winner;
	private static String tournament;
	private static String currentWinner;
	private static String dateLast;
	private static String record;
	private static String currentTournament;
	private static String currentRound;
	private static String dateFirst;


	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));
		
		listLoser = new ArrayList<String>();

		search();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
        int i = 0;
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			round = arrayString[29];
			winner = arrayString[10];
			 
			if(!listLoser.contains(winner))
			{
			if(round.equals("F"))
			{
			tournament = arrayString[1];
			dateFirst = processDate(arrayString[5]);
			
			for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) 
			{
				arrayString2 = iter2.next().split(",");
				
				currentRound = arrayString2[29];
				currentWinner =  arrayString2[10];
				
				if(currentRound.equals("F") && currentWinner.equals(winner))
				{
				dateLast = processDate(arrayString2[5]);
				currentTournament = arrayString2[1];
			    System.out.println(record);
				}
				
			}
			
			record = winner +","  +tournament +"," +dateFirst +"," +currentTournament +"," +dateLast; 
			w.write(record +"\n");
			w.flush();
			listLoser.add(winner);
			}
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
