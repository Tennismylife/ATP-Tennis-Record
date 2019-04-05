import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Counter {
	private static BufferedReader br;
	private static BufferedWriter w2;
	private static int counter = 0;
	private static String reading;
	private static String reading2;
	private static BufferedReader br2;
	private static String controlString="";

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(new FileInputStream("Counter.txt"), "Unicode"));

		w2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Counted.txt"), "Unicode"));

		reading = br.readLine();

		while (reading != null) {

			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Counter.txt"), "Unicode"));
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
}
