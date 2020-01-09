
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import jxl.Cell;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main2 {
	private static String[] row;
	private static WriteExcel test;
	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static String tournament;
	private static String date;
	private static String winner;
	private static String loser;
	private static String ageWinner;
	private static String ageLoser;
	private static String round;
	private static int m = 1;
	private static String tdsWinner;
	private static String rankingWinner;
	private static String tdsLoser;
	private static String rankingLoser;
	private static String entryWinner;
	private static String entryLoser;
	private static String score;
	private static String surface;
	private static String natWinner;
	private static String natLoser;
	private static float floatAgeWinner;
	private static float floatAgeLoser;
	private static String handLoser;
	private static String duration = "";
	private static String winnerAce = "";
	private static String winnerDf;
	private static String winnerSvpt;
	private static String winner1stIn;
	private static String winner1stWon = "";
	private static String winner2ndWon;
	private static String winnerSvGms;
	private static String winnerBpSaved = "";
	private static String winnerBpFaced = "";
	private static String loserAce = "";
	private static String loserDf;
	private static String loserSvpt;
	private static String loser1stIn;
	private static String loser1stWon;
	private static String loser2ndWon;
	private static String loserSvGms;
	private static String loserBpSaved;
	private static String loserBpFaced;
	private static String bestOf="";
	private static String score11, score21;
	private static String score12, score22;
	private static String score13, score23;
	private static String score14, score24;
	private static String score15, score25;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static float diff;
	private static int winnerBpSavedInt;
	private static int winnerBpFacedInt = -1;
	private static int loserBpSavedInt;
	private static int loserBpFacedInt = -1;
	private static float winner1stWonFloat;
	private static float winner2ndWonFloat;
	private static int intRankingWinner;
	private static int intRankingLoser;
	private static int intLoserAce;
	private static int intWinnerAce;
	private static int j = 0;
	private static String winnerRecord;
	private static String loserRecord;
	private static int intWinnerAceRecord;
	private static int intLoserAceRecord;
	private static int intWinnerAceCounter = 0;
	private static int intWinnerAceCounterPersonal = 0;
	private static int intLoserAceCounterPersonal;
	private static int intLoserAceCounter;

	private static ArrayList<String> listWinner;
	private static float winner1stInPercentuage;
	private static float loser1stInPercentuage;
	private static int numberPlayerdSet;
	private static String year, mouth, day;
	private static float winnerSvpInt;
	private static float loserSvpInt;
	private static float loser1stWonInt;
	private static float loser2ndWonInt;
	private static List<String> line;
	private static int numberPlayedSet;
	private static WriteExcel test2;
	private static float winnerPercentuage1stWon;
	private static float WinnerPercentuage2ndWon;
	private static float loserPercentuage1stWon;
	private static float loserPercentuage2ndWon;
	private static String plot;
	private static BufferedWriter w;
	private static String handWinner;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		
		line = Files.readAllLines(Paths.get("dbtml.csv"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		
//		URL url = new URL("https://github.com/domanov77/RTML/blob/master/Data/dbtml.csv");
//        
//        // read text returned by server
//        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//         
//        String record;
//        while ((record = in.readLine()) != null) {
//        	line.add(record);
//        }
//        in.close();

		listWinner = new ArrayList<String>();
		createSheet();
		search();
		setBackGroundFirstRow();
		sheetAutoFitColumns();
		workbook.write();
		workbook.close();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {


		// readRecord();

		for (Iterator<String> iter = line.listIterator(1); iter.hasNext();) 
		{
			plot =iter.next();
			row = plot.split(",");
			
			System.out.println(plot);
			System.out.println(row.length);
			
			date = row[1];
			date = processDate(date);
			System.out.println("Date:" +date);
			
			tournament = row[2];

			surface = row[4];

			round = row[8];

			tdsWinner = row[10];
			
			rankingWinner = row[11];
			System.out.println("Ranking winner: " +rankingWinner);
			
			ageWinner = row[12].replace(",", ".");
            System.out.println("Age winner: " +ageWinner);
            
            natWinner = row[13];
            
            handWinner = row[14];
            
			winner = row[14];

			//natWinner = row[13];
			
			score = row[16];
			processScore(score);
			
			// <<<<<<<<<Loser>>>>>>>>>>>>>>>>>//
			tdsLoser = row[18];

			rankingLoser = row[19];

			ageLoser = row[20].replace(",", ".");
			
			natLoser = row[21];
			
			loser = row[22];
			System.out.println("Loser: " +loser);
			
			 handLoser = row[14];
			
			if(row.length > 23)
			handLoser = row[23];
		
			if (row.length > 24) {

				winnerAce = row[24];

				winnerDf = row[25];

				winnerSvpt = row[26];

				winner1stIn = row[27];

				winner1stWon = row[28];
				System.out.println("Winner1stWon: " +winner1stWon);

				winner2ndWon = row[29];

				winnerSvGms = row[30];

				winnerBpSaved = row[31];

				winnerBpFaced = row[32];

				//////////////Loser//////////////
				loserAce = row[33];

				loserDf = row[34];

				loserSvpt = row[35];

				loser1stIn = row[36];

				loser1stWon = row[37];

				loser2ndWon = row[38];

				loserSvGms = row[39];

				loserBpSaved = row[40];

				loserBpFaced = row[41];
				
				duration = row[42];
			}

			if (tournament.contains("Davis Cup")) {
			} else {

			}

			/////////// Conversion/////////////
			////////// Age///////////////
			if (ageWinner.length() > 0)
				floatAgeWinner = Float.parseFloat(ageWinner.replace(",", "."));
			else
				floatAgeWinner = 0;

			if (ageLoser.length() > 0)
			{
				floatAgeLoser = Float.parseFloat(ageLoser.replace(",", "."));
				diff = Math.abs(floatAgeWinner - floatAgeLoser);
			} else {
				floatAgeLoser = 0;
			}

			////////// Ranking///////////////
			if (rankingWinner.length() > 0)
				intRankingWinner = Integer.parseInt(rankingWinner);
			if (rankingLoser.length() > 0 && !rankingLoser.equals("R") && !rankingLoser.equals("L"))
				intRankingLoser = Integer.parseInt(rankingLoser);

			////////// Ace///////////////
			if (winnerAce.length() > 0)
			{
				intWinnerAce = Integer.parseInt(winnerAce);
				if (winner.equals(winnerRecord) && intWinnerAce >= intWinnerAceRecord)
					intWinnerAceCounterPersonal++;

				if (intWinnerAce >= intWinnerAceRecord)
					intWinnerAceCounter++;
			}

			if (loserAce.length() > 0)
			{
				intLoserAce = Integer.parseInt(loserAce);
				if (loser.equals(loserRecord) && intLoserAce >= intLoserAceRecord)
					intLoserAceCounterPersonal++;

				if (intLoserAce >= intLoserAceRecord)
					intLoserAceCounter++;
			}

			////
		if (winner1stWon.length() > 0)
		{
			   if(winnerBpSaved.length() > 0)
				winnerBpSavedInt = Integer.parseInt(winnerBpSaved);
				winnerBpFacedInt = Integer.parseInt(winnerBpFaced);
				if(loserBpSaved.length() > 0)
				loserBpSavedInt = Integer.parseInt(loserBpSaved);
				
				if (loserBpFaced.contains("\""))
					loserBpFacedInt = Integer.parseInt(loserBpFaced);
				else
					loserBpFacedInt = -1;
				
				winner1stWonFloat = Float.parseFloat(winner1stWon);
				winner2ndWonFloat = Float.parseFloat(winner2ndWon);
				
                //Percentage 1stIn
				winner1stInPercentuage = (Float.parseFloat(winner1stIn) / Float.parseFloat(winnerSvpt)) * 100;
				loser1stInPercentuage = (Float.parseFloat(loser1stIn) / Float.parseFloat(loserSvpt)) * 100;

			if (winnerSvpt.length() > 0 && loserSvpt.length() > 0) 
			{
					
					winnerSvpInt = Float.parseFloat(winnerSvpt);
					loserSvpInt = Float.parseFloat(loserSvpt);
					loser1stWonInt = Float.parseFloat(loser1stWon);
					loser2ndWonInt = Float.parseFloat(loser2ndWon);
					
					
					
				//% 1st and 2nd Winner 
			    if ((Integer.parseInt(winnerSvpt) - Integer.parseInt(winner1stIn) > 0)) 
			    {
					winnerPercentuage1stWon = (Float.parseFloat(winner1stWon) / Float.parseFloat(winner1stIn)) * 100;
					WinnerPercentuage2ndWon = (Float.parseFloat(winner2ndWon) / (Float.parseFloat(winnerSvpt) - Float.parseFloat(winner1stIn))) * 100;
				}
			     
				//% 1st and 2nd Loser 
			    if ((Integer.parseInt(loserSvpt) - Integer.parseInt(loser1stIn) > 0)) 
			    {
					loserPercentuage1stWon = (Float.parseFloat(loser1stWon) / Float.parseFloat(loser1stIn)) * 100;
					loserPercentuage2ndWon = (Float.parseFloat(loser2ndWon) / (Float.parseFloat(loserSvpt) - Float.parseFloat(loser1stIn))) * 100;
				}
			     
					
			}
		}

//			//Bagel gives
//			if ((winner.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && loser.contains("Fognini"))) 
//		    {
//			//Bagel takes
//			if ((loser.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && winner.contains("Fognini"))) 
//		    {
            

		
//		if(WinnerPercentuage2ndWon > 100)
//		{
//			w.write(plot +"\n");
//			w.flush();
//		    w.write(WinnerPercentuage2ndWon +"," +winner2ndWon );
//		    w.flush();
//		}
		
//		if(loserPercentuage1stWon > 100)
//		{
//			w.write(plot +"\n");
//		    w.flush();
//		}
		
//		if(loserPercentuage2ndWon > 100)
//		{
//			w.write(plot +"\n");
//			w.flush();
//		}
		
//		if(winner1stInPercentuage > 100)
//		{
//			w.write(plot +"\n");
//			w.flush();
//		}
		
//		if(winnerSvGms !=null) {
//		if(winnerSvGms.equals("0"))
//		{
//			w.write(plot +"\n");
//			w.flush();
//		}
//		}
		
//		if(loserSvGms !=null) {
//		if(loserSvGms.equals("0"))
//		{
//			w.write(plot +"\n");
//			w.flush();
//		}
//		}
		
		
//		if(winner1stIn !=null) {
//		if(Integer.parseInt(winner1stIn) < Integer.parseInt(winner1stWon))
//		{
//			w.write(plot +"\n");
//			w.flush();
//		}
//		}
		
		
		
		
		
		if(rankingWinner.length() == 0)  
		{
			listWinner.add(tournament + year);
			writeExcel(2, test);
		}

		
		
		
      
     }
		
		System.out.println("ACE general Winner Counter:" + intWinnerAceCounter);
		System.out.println("ACE general Winner Personal Counter:" + intWinnerAceCounterPersonal);
		System.out.println("ACE general Loser  Counter:" + intLoserAceCounter);
		System.out.println("ACE general Loser Personal Counter:" + intLoserAceCounterPersonal);
		System.out.println("STOP");
	}



	private static void processScore(String score) {
		String set1 = "", set2 = "", set3 = "", set4 = "", set5 = "";
		String[] punteggio = new String[10];
		for (int i = 0; i < score.length(); i++) {
			if (score.charAt(i) == '-') {
			}
		}

		score11 = "";
		score21 = "";
		score12 = "";
		score22 = "";
		score13 = "";
		score23 = "";
		score14 = "";
		score24 = "";
		score15 = "";
		score25 = "";
		punteggio = score.split(" ");

		numberPlayedSet = countChar(score, '-');

		if (!score.contains("W/O") && score.length() > 0 && !score.contains("DEF") && !score.contains("NA")
				&& !score.contains("RET") && !score.contains("ABN") && !score.contains("ABD")) {

			if (numberPlayerdSet > 0) {
				set1 = punteggio[0];
				score11 = set1.substring(0, set1.indexOf("-"));
				score21 = set1.substring(set1.indexOf("-") + 1, set1.length());

			}
			if (numberPlayerdSet > 1) {
				set2 = punteggio[1];
				score12 = set2.substring(0, set2.indexOf("-"));
				score22 = set2.substring(set2.indexOf("-") + 1, set2.length());
			}
			if (numberPlayerdSet > 2) {
				set3 = punteggio[2];
				score13 = set3.substring(0, set3.indexOf("-"));
				score23 = set3.substring(set3.indexOf("-") + 1, set3.length());
			}
			if (numberPlayerdSet > 3) {
				set4 = punteggio[3];
				score14 = set4.substring(0, set4.indexOf("-"));
				score24 = set4.substring(set4.indexOf("-") + 1, set4.length());
			}
			if (numberPlayerdSet > 4) {
				set5 = punteggio[4];
				score15 = set5.substring(0, set5.indexOf("-"));
				score25 = set5.substring(set5.indexOf("-") + 1, set5.length());
			}

			//////// No tiebreak////////////////
			if (score11.contains(("(")))
				score11 = score11.substring(0, score11.indexOf("("));
			if (score21.contains(("(")))
				score21 = score21.substring(0, score21.indexOf("("));

			if (score12.contains(("(")))
				score12 = score13.substring(0, score12.indexOf("("));
			if (score22.contains(("(")))
				score22 = score22.substring(0, score22.indexOf("("));

			if (score13.contains(("(")))
				score13 = score13.substring(0, score13.indexOf("("));
			if (score23.contains(("(")))
				score23 = score23.substring(0, score23.indexOf("("));

			if (score14.contains(("(")))
				score14 = score14.substring(0, score14.indexOf("("));
			if (score24.contains(("(")))
				score24 = score24.substring(0, score24.indexOf("("));

			if (score15.contains(("(")))
				score15 = score15.substring(0, score15.indexOf("("));
			if (score25.contains(("(")))
				score25 = score25.substring(0, score25.indexOf("("));

		}

	}

	public static int countChar(String str, char c) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}

		return count;
	}

	private static String processDate(String date) {
		year = date.substring(0, 4);
		mouth = date.substring(4, 6);
		day = date.substring(6, 8);

		date = day + "/" + mouth + "/" + year;

		return year;
	}

	private static void writeExcel(int settings, WriteExcel test) throws RowsExceededException, WriteException {
		// Simple
		if (settings == 1) {
			test.addCaption(sheet, 0, 0, "#");
			test.addCaption(sheet, 1, 0, "Tournament");
			test.addCaption(sheet, 2, 0, "Year");
			test.addCaption(sheet, 3, 0, "Round");
			test.addCaption(sheet, 4, 0, "Nat");
			test.addCaption(sheet, 5, 0, "Player");

			test.addNumber(sheet, 0, m, m);
			test.addCaption(sheet, 1, m, tournament);
			test.addNumber(sheet, 2, m, Integer.parseInt(date));
			test.addCaption(sheet, 3, m, round);
			if (natWinner.equals("ARG")) {
				test.addCaption(sheet, 4, m, natWinner);
				test.addCaption(sheet, 5, m, winner);
			}
			if (natLoser.equals("ARG")) {
				test.addCaption(sheet, 4, m, natLoser);
				test.addCaption(sheet, 5, m, loser);
			}

		}

		if (settings == 2) {
			j = 0;
			test.addCaption(sheet, j, 0, "#");
			test.addCaption(sheet, ++j, 0, "Tournament");
			test.addCaption(sheet, ++j, 0, "Year");
			test.addCaption(sheet, ++j, 0, "Round");
			test.addCaption(sheet, ++j, 0, "W entry");
			// test.addCaption(sheet, ++j, 0, "W hand");
			test.addCaption(sheet, ++j, 0, "W Nat");
			test.addCaption(sheet, ++j, 0, "W Ranking");
			test.addCaption(sheet, ++j, 0, "W Age");
			test.addCaption(sheet, ++j, 0, "Winner");

			test.addCaption(sheet, ++j, 0, "L entry");
			// test.addCaption(sheet, ++j, 0, "L hand");
			test.addCaption(sheet, ++j, 0, "L Naz");
			test.addCaption(sheet, ++j, 0, "L Ranking");
			test.addCaption(sheet, ++j, 0, "L Age");
			test.addCaption(sheet, ++j, 0, "Loser");

			test.addCaption(sheet, ++j, 0, "Score");
			test.addCaption(sheet, ++j, 0, "Surface");
			test.addCaption(sheet, ++j, 0, "Duration");
			test.addCaption(sheet, ++j, 0, "Best of");

			test.addCaption(sheet, ++j, 0, "score11");
			test.addCaption(sheet, ++j, 0, "score21");
			test.addCaption(sheet, ++j, 0, "score12");
			test.addCaption(sheet, ++j, 0, "score22");
			test.addCaption(sheet, ++j, 0, "score13");
			test.addCaption(sheet, ++j, 0, "score23");
			test.addCaption(sheet, ++j, 0, "score14");
			test.addCaption(sheet, ++j, 0, "score24");
			test.addCaption(sheet, ++j, 0, "score15");
			test.addCaption(sheet, ++j, 0, "score25");

			test.addCaption(sheet, ++j, 0, "winnerAce");
			test.addCaption(sheet, ++j, 0, "winnerDf");
			test.addCaption(sheet, ++j, 0, "winnerSvpt");
			test.addCaption(sheet, ++j, 0, "winner1stIn");
			test.addCaption(sheet, ++j, 0, "winner1stWon");
			test.addCaption(sheet, ++j, 0, "winner2ndWon");
			test.addCaption(sheet, ++j, 0, "winnerSvGms");

			test.addCaption(sheet, ++j, 0, "winnerBpSaved");
			test.addCaption(sheet, ++j, 0, "winnerBpFaced");

			test.addCaption(sheet, ++j, 0, "loserAce");
			test.addCaption(sheet, ++j, 0, "loserDf");
			test.addCaption(sheet, ++j, 0, "loserSvpt");
			test.addCaption(sheet, ++j, 0, "loser1stIn");
			test.addCaption(sheet, ++j, 0, "loser1stWon");
			test.addCaption(sheet, ++j, 0, "loser2ndWon");
			test.addCaption(sheet, ++j, 0, "loserSvGms");
			test.addCaption(sheet, ++j, 0, "loserBpSaved");
			test.addCaption(sheet, ++j, 0, "loserBpFaced");

			j = 0;
			if(m > 1) {
			String formula = "A" +String.valueOf(m) +"+1";
			test.addFormula(sheet, j, m, formula);
			}
			
			test.addCaption(sheet, ++j, m, tournament);
			
			if(date.length() == 4) {
			test.addNumber(sheet, ++j, m, Integer.parseInt(date));
			}else {
			test.addCaption(sheet, ++j, m, date);
			}
			
			test.addCaption(sheet, ++j, m, round);

			if (!tdsWinner.contains("\"")) {
				test.addCaption(sheet, ++j, m, tdsWinner);
			} else {
				test.addCaption(sheet, ++j, m, entryWinner);
			}

//			test.addCaption(sheet, ++j, m, handWinner);
			test.addCaption(sheet, ++j, m, natWinner);
			if (rankingWinner.length() > 0) {
				test.addNumber(sheet, ++j, m, Integer.parseInt(rankingWinner));
			} else {
				++j;
			}
			if (ageWinner.length() > 0) {
				test.addNumberDouble(sheet, ++j, m, Double.parseDouble(ageWinner.substring(0, ageWinner.length())));

			} else {
				++j;
			}
			test.addCaption(sheet, ++j, m, String.valueOf(winner));

			if (tdsLoser.length() > 0) {
				test.addCaption(sheet, ++j, m, String.valueOf(tdsLoser));
			} else {
				test.addCaption(sheet, ++j, m, String.valueOf(entryLoser));
			}

//			test.addCaption(sheet, ++j, m, handLoser);
			test.addCaption(sheet, ++j, m, natLoser);
			if (rankingLoser.length() > 0) {
				test.addNumber(sheet, ++j, m, Integer.parseInt(rankingLoser));
			} else {
				++j;
			}
			if (ageLoser.length() > 0) {
				test.addNumberDouble(sheet, ++j, m, Double.parseDouble(ageLoser.substring(0, ageLoser.length())));
			} else {
				++j;
			}
			test.addCaption(sheet, ++j, m, loser);
			test.addCaption(sheet, ++j, m, score);
			test.addCaption(sheet, ++j, m, surface);
			if (duration.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(duration));
			else
				++j;
			if(bestOf.length() > 0)
			test.addNumber(sheet, ++j, m, Integer.parseInt(bestOf));

			test.addCaption(sheet, ++j, m, score11);
			test.addCaption(sheet, ++j, m, score21);
			test.addCaption(sheet, ++j, m, score12);
			test.addCaption(sheet, ++j, m, score22);
			test.addCaption(sheet, ++j, m, score13);
			test.addCaption(sheet, ++j, m, score23);
			test.addCaption(sheet, ++j, m, score14);
			test.addCaption(sheet, ++j, m, score24);
			test.addCaption(sheet, ++j, m, score15);
			test.addCaption(sheet, ++j, m, score25);

			if (winnerAce.length() > 0) {
				test.addNumber(sheet, ++j, m, Integer.parseInt(winnerAce));
				test.addNumber(sheet, ++j, m, Integer.parseInt(winnerDf));
				test.addCaption(sheet, ++j, m, String.valueOf(winnerSvpt));
				test.addCaption(sheet, ++j, m, String.valueOf(winner1stIn));
				test.addCaption(sheet, ++j, m, String.valueOf(winner1stWon));
				test.addCaption(sheet, ++j, m, String.valueOf(winner2ndWon));
				test.addCaption(sheet, ++j, m, String.valueOf(winnerSvGms));

				test.addCaption(sheet, ++j, m, String.valueOf(winnerBpSaved));
				test.addCaption(sheet, ++j, m, String.valueOf(winnerBpFaced));

				test.addCaption(sheet, ++j, m, String.valueOf(loserAce));
				test.addCaption(sheet, ++j, m, String.valueOf(loserDf));
				test.addCaption(sheet, ++j, m, String.valueOf(loserSvpt));
				test.addCaption(sheet, ++j, m, String.valueOf(loser1stIn));
				test.addCaption(sheet, ++j, m, String.valueOf(loser1stWon));
				test.addCaption(sheet, ++j, m, String.valueOf(loser2ndWon));
				test.addCaption(sheet, ++j, m, String.valueOf(loserSvGms));
				test.addCaption(sheet, ++j, m, String.valueOf(loserBpSaved));
				test.addNumber(sheet, ++j, m, loserBpFacedInt);
			}
		}

		m++;
	}

	private static void setBackGroundFirstRow() throws WriteException {

		WritableFont cellFont = new WritableFont(WritableFont.TIMES, 10);
		cellFont.setBoldStyle(WritableFont.BOLD);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFont);

		for (int i = 0; i < 46; i++) {
			WritableCell c2 = sheet.getWritableCell(i, 0);
			c2.setCellFormat(cellFormat);

		}

		for (int i = 0; i < 46; i++) {
			WritableCell c = sheet.getWritableCell(i, 0);
			CellFormat readFormat = c.getCellFormat();
			if (readFormat != null) {
				WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
				newFormat.setBackground(Colour.LIGHT_GREEN);
				newFormat.setAlignment(Alignment.CENTRE);
				c.setCellFormat(newFormat);

			}
		}

	}

	public static void createSheet() throws IOException, WriteException {
		
		test = new WriteExcel();
		test2 = new WriteExcel();
		
		Random rand = new Random();
		// Obtain a number between [0 - 49].
		int n = rand.nextInt(5000);
		
		String inputFile = "output" +n +".xls" ;
		
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));

		workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		sheet = workbook.getSheet(0);
		test.createLabel(sheet);
	}

	private static void sheetAutoFitColumns() {
		for (int i = 0; i < sheet.getColumns(); i++) {
			Cell[] cells = sheet.getColumn(i);
			int longestStrLen = -1;

			if (cells.length == 0)
				continue;

			/* Find the widest cell in the column. */
			for (int j = 0; j < cells.length; j++) {
				if (cells[j].getContents().length() > longestStrLen) {
					String str = cells[j].getContents();
					if (str == null || str.isEmpty())
						continue;
					longestStrLen = str.trim().length();
				}
			}

			/* If not found, skip the column. */
			if (longestStrLen == -1)
				continue;

			/* If wider than the max width, crop width */
			if (longestStrLen > 255)
				longestStrLen = 255;

			CellView cv = sheet.getColumnView(i);
			cv.setSize(longestStrLen * 256 + 100); /* Every character is 256 units wide, so scale it. */
			sheet.setColumnView(i, cv);
		}
	}

}
