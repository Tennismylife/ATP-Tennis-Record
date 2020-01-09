import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Repair {

	private static List<String> lines;
	private static String plot;
	private static String[] row;
	private static String loserAge;
	private static String loserRanking;
	private static BufferedWriter w;
	private static String score;
	private static String record;
	private static int replace;

	public static void main(String[] args) throws IOException {

		lines = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));

		for (Iterator<String> iter = lines.listIterator(1); iter.hasNext();) 
		{
			plot = iter.next();
			// System.out.println(plot);
			row = plot.split(",");

			record = "1980-401,Philadelphia WCT,Carpet,64,A,19800121,,T052";
			
			//if(plot.contains(record)) {
			replace = plot.length() - plot.replace(",", "").length();
			//System.out.println(replace);
			
			
			

			if (replace == 49) 
			{
				loserAge = row[24];
				loserRanking = row[25];
				score = row[27];
//				System.out.println("Loser age:" +loserAge);
//				System.out.println("Loser ranking:" +loserRanking);
//				System.out.println("Score:" +score);

				System.out.println(plot);
				plot = plot.replace("," + loserAge + "," + loserRanking + "," + score, "," + loserAge + "," + loserRanking + ",," + score);
				plot = plot.replace(",,,,,,,,,,,,,,,,,,,", ",,,,,,,,,,,,,,,,,,");
				System.out.println(plot);
			
			}
			w.write(plot + "\n");
			w.flush();
			
		  } // For cycle

	
		}

	

}
