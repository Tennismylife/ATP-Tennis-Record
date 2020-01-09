import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DiffCompare {

	private static BufferedReader br;
	private static String reading;
	private static BufferedReader br2;
	private static String reading2;
	private static BufferedWriter w2;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(new FileInputStream("List1.txt"), "Unicode"));
		
		w2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("List3.txt"), "Unicode"));

		reading = br.readLine();
		while (reading != null) {
			
			//System.out.println(reading);
			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("List2.txt"), "Unicode"));
			reading2 = br2.readLine();
      
			while (reading2 != null) {

				if (reading2.contains(reading))
			    {
					w2.write(reading + "\n");
					w2.flush();

				}

				reading2 = br2.readLine();
			}

			reading = br.readLine();
		}

	}

}
