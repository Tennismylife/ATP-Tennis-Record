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

public class GameLostToWin {

	private static BufferedWriter w;
	private static List<String> line1;
	private static List<String> line2;
	private static String[] arrayString2;
	private static String[] arrayString;
	private static Win[] wins;
	private static String year;
	private static String mouth;
	private static String day;
	private static String winner;
	private static String tournament;
	private static ArrayList<Win> listWins, listUpdated;
	private static Win currentWin;
	private static int currentNumberGamesLost;
	private static int numberGamesLost;
	private static String score;
	private static int numberPlayedSet;
	private static String round;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line1 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		line2 = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));

		wins = new Win[line1.size()];
		listWins = new ArrayList<Win>();
		listUpdated = new ArrayList<Win>();
		search();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {
		int i = 0;

		// Collects the tournaments winner
		for (Iterator<String> iter = line1.iterator(); iter.hasNext();) {
			arrayString = iter.next().split(",");
			round = arrayString[29];
			if (round.equals("F")) {
				wins[i] = new Win();
				wins[i].setWinner(arrayString[10]);
				wins[i].setTournament(arrayString[1]);
				wins[i].setYear(processDate(arrayString[5]));
				listWins.add(wins[i]);
				i++;
			}
		}

		for (Iterator<String> iter2 = line2.listIterator(); iter2.hasNext();) {
			arrayString2 = iter2.next().split(",");

			winner = arrayString2[10];
			tournament = arrayString2[1];
			year = processDate(arrayString2[5]);

			for (Iterator<Win> iter3 = listWins.listIterator(); iter3.hasNext();) {
				currentWin = iter3.next();
				if (currentWin.getWinner().equals(winner) && currentWin.getTournament().equals(tournament)
						&& currentWin.getYear().equals(year)) {

					System.out.println(currentWin);
					score = arrayString2[27];

					if (!score.contains("W/O") && score.length() > 0 && !score.contains("ABN")
							&& !score.contains("DEF")) {

						numberGamesLost = countGameLost(score);
						currentNumberGamesLost = currentWin.getGamesLost() + numberGamesLost;
						currentWin.setGamesLost(currentNumberGamesLost);
						currentWin.setPlayedMatches(currentWin.getPlayedMatches() + 1);
						if (!listUpdated.contains(currentWin))
							listUpdated.add(currentWin);
					}

				}
			}
		}

		for (Iterator<Win> iter4 = listUpdated.iterator(); iter4.hasNext();) {
			w.write(iter4.next() + "\n");
			w.flush();

		}

	}

	@Override
	public String toString() {
		return "GameLostToWin [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private static int countGameLost(String score) {
		int gamesLost = 0;
		String[] scoreSplitted;
		int gameSet11, gameSet12, gameSet21, gameSet22, gameSet31, gameSet32, gameSet41, gameSet42, gameSet51,
				gameSet52;

		// Control the retirement
		if (score.contains("RET")) {
			score = score.substring(0, score.indexOf("RET") - 1);
		}

		scoreSplitted = score.split(" ");
		numberPlayedSet = countChar(score, '-');

		// Control the tiebreak
		for (int i = 0; i < scoreSplitted.length; i++) {
			if (scoreSplitted[i].contains("("))
				scoreSplitted[i] = scoreSplitted[i].substring(0, scoreSplitted[i].indexOf("("));
		}

		// First set
		gameSet11 = Integer.parseInt(scoreSplitted[0].substring(0, scoreSplitted[0].indexOf("-")));
		gameSet12 = Integer
				.parseInt(scoreSplitted[0].substring(scoreSplitted[0].indexOf("-") + 1, scoreSplitted[0].length()));

		if (gameSet11 > gameSet12)
			gamesLost += gameSet12;
		else
			gamesLost += gameSet11;

		if (numberPlayedSet > 1) {
			// Second set
			gameSet21 = Integer.parseInt(scoreSplitted[1].substring(0, scoreSplitted[1].indexOf("-")));
			gameSet22 = Integer
					.parseInt(scoreSplitted[1].substring(scoreSplitted[1].indexOf("-") + 1, scoreSplitted[1].length()));

			if (gameSet21 > gameSet22)
				gamesLost += gameSet22;
			else
				gamesLost += gameSet21;
		}

		if (numberPlayedSet > 2) {
			// Third set
			gameSet31 = Integer.parseInt(scoreSplitted[2].substring(0, scoreSplitted[2].indexOf("-")));
			gameSet32 = Integer
					.parseInt(scoreSplitted[2].substring(scoreSplitted[2].indexOf("-") + 1, scoreSplitted[2].length()));

			if (gameSet31 > gameSet32)
				gamesLost += gameSet32;
			else
				gamesLost += gameSet31;
		}

		if (numberPlayedSet > 3) {
			// Fourth set
			gameSet41 = Integer.parseInt(scoreSplitted[3].substring(0, scoreSplitted[03].indexOf("-")));
			gameSet42 = Integer
					.parseInt(scoreSplitted[3].substring(scoreSplitted[3].indexOf("-") + 1, scoreSplitted[3].length()));

			if (gameSet41 > gameSet42)
				gamesLost += gameSet42;
			else
				gamesLost += gameSet41;
		}

		if (numberPlayedSet > 4) {
			// Fifth set
			gameSet51 = Integer.parseInt(scoreSplitted[4].substring(0, scoreSplitted[4].indexOf("-")));
			gameSet52 = Integer
					.parseInt(scoreSplitted[4].substring(scoreSplitted[4].indexOf("-") + 1, scoreSplitted[4].length()));

			if (gameSet51 > gameSet52)
				gamesLost += gameSet52;
			else
				gamesLost += gameSet51;
		}

		return gamesLost;
	}

	public static int countChar(String str, char c) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}

		return count;
	}

	private static String processDate(String data) {
		year = data.substring(0, 4);
		mouth = data.substring(4, 6);
		day = data.substring(6, 8);

		data = day + "/" + mouth + "/" + year;

		return year;
	}

}

class Win {
	String winner;
	String year;
	String tournament;
	int playedMatches;
	int gamesLost;

	public int setPlayedMatches(int playedMatches) {
		return this.playedMatches = playedMatches;
	}

	public int getPlayedMatches() {
		return playedMatches;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTournament() {
		return tournament;
	}

	public void setTournament(String tournament) {
		this.tournament = tournament;
	}

	@Override
	public String toString() {
		return winner + "," + tournament + "," + year + "," + +playedMatches + "," + gamesLost;
	}

}
