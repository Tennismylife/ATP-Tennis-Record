import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class BeatingConsecutiveNumber1 {
	private static String winner;
	private static String loser;
	private static ArrayList<String> listPlayer;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String rankingLoser;
	private static String currentWinner;
	private static String currentLoser;
	private static String lineToWrite;
	private static String currentRankingLoser;
	
	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listPlayer = new ArrayList<String>();
		search();

	}


	private static void search() throws IOException, RowsExceededException, WriteException, ParseException 
	{
		int i = 0;
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) 
		{
			arrayString = iter.next().split(",");
			
			currentRankingLoser = arrayString[25];
			currentLoser = arrayString[20];
			currentWinner = arrayString[10];
	
			
			if(currentRankingLoser.equals("1"))
			{
				lineToWrite = Arrays.toString(arrayString);

				for (Iterator<String> iter2 = line2.listIterator(i+1); iter2.hasNext();) 
				{
					
					arrayString2 = iter2.next().split(",");
					winner = arrayString2[10];
					loser =  arrayString2[20];
					rankingLoser = arrayString2[25];
					
					if(winner.equals(currentLoser) && loser.equals(currentWinner)) 
					{
						lineToWrite = "";
					}
					else 
					{
						if(winner.equals(currentWinner) && loser.equals(currentLoser) && rankingLoser.equals("1")) 
						{
							
							lineToWrite = lineToWrite +"\n" + Arrays.toString(arrayString2);
							w.write(lineToWrite +"\n\n") ;
							w.flush();
							lineToWrite="";
						}
						
						
					}
					
				
				
			    }
			}
			
			i++;
		}
		
		
		
	}
}
