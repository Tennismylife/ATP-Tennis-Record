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

public class Bagel {
	private static String winner;
	private static String loser;
	private static String currentLoser;
	private static ArrayList<String> listLoser, listWinner;
	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static int counter = 0;
	private static String score;
	private static String currentWinner;
	private static int bagel;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		listLoser = new ArrayList<String>();
		listWinner = new ArrayList<String>();
		// loser();
		winner();

	}

	private static void loser() throws IOException, RowsExceededException, WriteException, ParseException {

		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			arrayString = iter.next().split(",");
			currentLoser = arrayString[20];
			System.out.println(iter.next());

			if (!listLoser.contains(currentLoser)) {
				listLoser.add(currentLoser);
				line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
				for (Iterator<String> iter2 = line2.iterator(); iter2.hasNext();) {
					arrayString2 = iter2.next().split(",");

					winner = arrayString2[10];
					loser = arrayString2[20];
					score = arrayString2[27];

					if ((loser.contains(currentLoser) && score.contains("6-0"))
							|| (score.contains("0-6") && winner.contains(currentLoser)))
						counter++;
				}
				w.write(currentLoser + "," + counter + "\n");
				w.flush();
				counter = 0;
			}

		}
	}

	private static void winner() throws IOException, RowsExceededException, WriteException, ParseException {
		int i = 0;

		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			arrayString = iter.next().split(",");
			currentWinner = arrayString[10];
			System.out.println(iter.next());

			if (!listWinner.contains(currentWinner)) {
				listWinner.add(currentWinner);

				for (Iterator<String> iter2 = line2.listIterator(i); iter2.hasNext();) {
					arrayString2 = iter2.next().split(",");

					winner = arrayString2[10];
					loser = arrayString2[20];
					score = arrayString2[27];

					if ((winner.contains(currentWinner) && score.contains("6-0"))) {
						bagel = countString(score, "6-0");
						counter = counter + bagel;
					}

					if (score.contains("0-6") && loser.contains(currentWinner)) {
						bagel = countString(score, "0-6");
						counter = counter + bagel;
					}
				}

				w.write(currentWinner + "," + counter + "\n");
				w.flush();
				counter = 0;
			}

			i++;
		}
	}

	public static int countString(String str, String find) {
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {

			lastIndex = str.indexOf(find, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += find.length();
			}
		}
		return count;
	}

}
