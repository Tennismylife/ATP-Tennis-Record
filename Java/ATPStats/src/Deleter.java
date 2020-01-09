import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


//Tool to manipulate a txt file dividev by rows
public class Deleter {
	
	private static List<String> line1;
	private static String[] arrayString;
	private static BufferedWriter w;
	private static String plot;

	public static void main(String[] args) throws IOException {

		line1 = Files.readAllLines(Paths.get("Input.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		
		
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			plot =iter.next();
			arrayString = plot.split(",");
			
			if(arrayString.length == 50)
				arrayString[49]="$$$";
			
			String str = Arrays.toString(arrayString);
			str = str.replace(", ", ",");
			str = str.replace(",$$$", "");
			str = str.replace("[", "");
			str = str.replace("]", "");
			
			w.write(str);
			w.newLine();
			w.flush();
			
			
			System.out.println(arrayString.length);
			
			
		}
		
	}

}
