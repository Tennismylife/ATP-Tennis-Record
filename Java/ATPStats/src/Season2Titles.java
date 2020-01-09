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

public class Season2Titles {
	private static ArrayList<String> listWinner;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static String year;
	private static String mouth;
	private static String day;
	private static String winner;
	private static String currentWinner;
	private static String currentRound;
	private static String round;
	private static String currentYear;
	private static int counter = 0;
	private static int nextYear = 0;
	private static boolean flag = true;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listWinner = new ArrayList<String>();

		search();

	}

	private static void search() throws IOException {
		int i = 0;

		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			arrayString = iter.next().split(",");
			currentRound = arrayString[29];
			currentWinner = arrayString[10];

			System.out.println(iter.next());

			if (!listWinner.contains(currentWinner) && currentRound.equals("F")) {

				currentYear = processDate(arrayString[5]);

				for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) {
					arrayString2 = iter2.next().split(",");

					round = arrayString2[29];

					if (round.equals("F")) {
						winner = arrayString2[10];
						year = processDate(arrayString2[5]);

						if (flag)
							nextYear = Integer.parseInt(year);

						//System.out.println(winner+"," +year + "," + nextYear);

						if (currentWinner.equals(winner) && year.equals(String.valueOf(nextYear))) {
							// System.out.println(winner +", " +nextYear);
							counter++;
							nextYear = nextYear + 1;
							flag = false;
						}
					}

				}
				flag = true;
				w.write(currentWinner + "," + counter + "\n");
				w.flush();
				counter = 0;
				nextYear = 0;
				listWinner.add(currentWinner);
			}

			i++;
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
