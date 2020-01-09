import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Counter {
	private static BufferedReader br;
	private static BufferedWriter w2;
	private static int counter = 0;
	private static String reading;
	private static String reading2;
	private static BufferedReader br2;
	private static String controlString="";
	private static List<String> line;
	private static String year;
	private static String plot;
	private static String[] row;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(new FileInputStream("Counter.txt"), "UTF-8"));

		w2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Counted.txt"), "UTF-8"));
		
		
		line = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("UTF-8"));
		
//		for (Iterator<String> iter = line.iterator(); iter.hasNext();) 
//		{
//		plot = iter.next();
//		row = plot.split(",");
//		year = processDate(row[5]);
//		if(Integer.parseInt(year) < 1990) plot = plot.replace(",M,", ",A,");
//		w2.write(plot +"\n");
//		w2.flush();
//			
//		}

		reading = br.readLine();

		while (reading != null) {

			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Counter.txt"), "UTF-8"));
			reading2 = br2.readLine();
			counter = 0;
			while (reading2 != null) {
				if (reading2.equals(reading)) {
					counter++;
				}

				reading2 = br2.readLine();
			}

			if (!controlString.contains(reading + "," + counter)) {
				w2.write(reading + "," + counter + "\n");
				w2.flush();
				controlString += reading + "," + counter;
			}
			
			reading = br.readLine();

		}
	}
	
	private static String processDate(String data) {
		year = data.substring(0, 4);

		return year;
	}
}
