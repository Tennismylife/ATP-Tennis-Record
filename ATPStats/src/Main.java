import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
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

public class Main {
	private static BufferedReader br;
	private static String[] row;
	private static String[] row2;
	private static WriteExcel test;
	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static String reading;
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
	private static String tour;
	private static String entryWinner;
	private static String entryLoser;
	private static String score;
	private static String surface;
	private static String natWinner;
	private static String natLoser;
	private static float floatAgeWinner;
	private static float floatAgeLoser;
	private static String matchNumber;
	private static String handWinner;
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
	private static String bestOf;
	private static String score11, score21;
	private static String score12, score22;
	private static String score13, score23;
	private static String score14, score24;
	private static String score15, score25;
	private static BufferedWriter db;
	private static Date date1;
	private static Date date2;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static float percentuage1stWon;
	private static float percentuage2ndWon;
	private static DecimalFormat decimalFormat;
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
	private static String category;
	private static String drawSize;
	private static String playedSets;

	private static int j = 0;
	private static String firstString;
	private static String tournamentRecord;
	private static String surfaceRecord;
	private static String drawSizeRecord;
	private static String categoryRecord;
	private static String dateRecord;
	private static String matchNumberRecord;
	private static String tdsWinnerRecord;
	private static String entryWinnerRecord;
	private static String winnerRecord;
	private static String handWinnerRecord;
	private static String natWinnerRecord;
	private static String ageWinnerRecord;
	private static String rankingWinnerRecord;
	private static String tdsLoserRecord;
	private static String entryLoserRecord;
	private static String loserRecord;
	private static String handLoserRecord;
	private static String natLoserRecord;
	private static String ageLoserRecord;
	private static String rankingLoserRecord;
	private static String scoreRecord;
	private static String bestOfRecord;
	private static String roundRecord;
	private static String durationRecord;
	private static String winnerAceRecord;
	private static String winnerDfRecord;
	private static String winnerSvptRecord;
	private static String winner1stInRecord;
	private static String winner1stWonRecord;
	private static String winner2ndWonRecord;
	private static String winnerSvGmsRecord;
	private static String winnerBpSavedRecord;
	private static String winnerBpFacedRecord;
	private static String loserAceRecord;
	private static String loserDfRecord;
	private static String loserSvptRecord;
	private static String loser1stInRecord;
	private static String loser1stWonRecord;
	private static String loser2ndWonRecord;
	private static String loserSvGmsRecord;
	private static String loserBpSavedRecord;
	private static String loserBpFacedRecord;
	private static String tourRecord;
	private static float floatAgeWinnerRecord;
	private static float floatAgeLoserRecord;
	private static float diffRecord;
	private static int intRankingWinnerRecord;
	private static int intRankingLoserRecord;
	private static int intWinnerAceRecord;
	private static int intLoserAceRecord;
	private static int winnerBpSavedIntRecord;
	private static int winnerBpFacedIntRecord;
	private static int loserBpSavedIntRecord;
	private static int loserBpFacedIntRecord;
	private static float winner1stWonFloatRecord;
	private static float winner2ndWonFloatRecord;
	private static float percentuage2ndWonRecord;
	private static float percentuage1stWonRecord;

	private static int intWinnerAceCounter = 0;
	private static int intWinnerAceCounterPersonal = 0;
	private static int intLoserAceCounterPersonal;
	private static int intLoserAceCounter;

	private static ArrayList<String> listWinner;
	private static float winner1stInPercentuage;
	private static float loser1stInPercentuage;
	private static int numberPlayerdSet;
	private static LinkedHashMap<String, Integer> listWins;
	private static Integer wins;
	private static LinkedHashMap<String, Integer> listTitles;
	private static Integer title;
	private static int i;
	private static int losingCounter;
	private static int y = 0;
	private static ArrayList<String> listLoser;
	private static BufferedWriter w;
	
	private static String year, mouth, day;
	private static int counter;
	private static int index;
	private static float winnerSvpInt;
	private static float loserSvpInt;
	private static float loser1stWonInt;
	private static float loser2ndWonInt;
	private static float returnWinnerWon;
	private static float returnWinnerWonPercentuage;
	private static List<String> line;
	private static int numberPlayedSet;
	private static WritableSheet sheet2;
	private static WriteExcel test2;
	private static WritableWorkbook workbook2;
	private static float totalBreakPoints;
	private static float convertedBreakPoint;
	private static float percentageConversion;
	private static float sum;
	private static int years;
	private static int totalDays;
	private static int months;
	private static int weeks;
	private static int days;
	private static int totaldays;
	private static float winnerPercentuage1stWon;
	private static float WinnerPercentuage2ndWon;
	private static float loserPercentuage1stWon;
	private static float loserPercentuage2ndWon;

	public static void main(String[] args) throws IOException, WriteException, ParseException {

		line = Files.readAllLines(Paths.get("newdb.txt"), Charset.forName("Unicode"));
		//w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "Unicode"));
		
		listWinner = new ArrayList<String>();
		listLoser = new ArrayList<String>();
		listWins = new LinkedHashMap<String, Integer>();
		listTitles = new LinkedHashMap<String, Integer>();

		// br = new BufferedReader(new InputStreamReader(new FileInputStream("Database
		// Winners.txt"), "Unicode"));

		createSheet();
		search();
		setBackGroundFirstRow();
		sheetAutoFitColumns();
		workbook.write();
		workbook.close();

	}

	private static void search() throws IOException, RowsExceededException, WriteException, ParseException {


		// readRecord();

		decimalFormat = new DecimalFormat("#.##");
		

		for (Iterator<String> iter = line.iterator(); iter.hasNext();) 
		{
			
			row = iter.next().split(",");

			tournament = row[1];

			surface = row[2];

			drawSize = row[3];

			category = row[4];

			date = row[5];
			date = processDate(date);

			matchNumber = row[6];

			tdsWinner = row[8];

			entryWinner = row[9];

			winner = row[10];

			handWinner = row[11];

			natWinner = row[13];

			ageWinner = row[14].replace(",", ".");

			rankingWinner = row[15];

			// <<<<<<<<<Loser>>>>>>>>>>>>>>>>>//
			tdsLoser = row[18];

			entryLoser = row[19];

			loser = row[20];

			handLoser = row[21];

			natLoser = row[23];

			ageLoser = row[24].replace(",", ".");

			rankingLoser = row[25];

			score = row[27];

			processScore(score);

			bestOf = row[28];

			round = row[29];
			if (row.length > 31) {
				duration = row[30];

				winnerAce = row[31];

				winnerDf = row[32];

				winnerSvpt = row[33];

				winner1stIn = row[34];

				winner1stWon = row[35];

				winner2ndWon = row[36];

				winnerSvGms = row[37];

				winnerBpSaved = row[38];

				winnerBpFaced = row[39];

				loserAce = row[40];

				loserDf = row[41];

				loserSvpt = row[42];

				loser1stIn = row[43];

				loser1stWon = row[44];

				loser2ndWon = row[45];

				loserSvGms = row[46];

				loserBpSaved = row[47];

				loserBpFaced = row[48];
			}

			if (tournament.contains("Davis Cup")) {
				tour = "Davis Cup";
			} else {
				tour = "";

			}

			/////////// Conversion/////////////
			////////// Age///////////////
			if (ageWinner.length() > 0)
				floatAgeWinner = Float.parseFloat(ageWinner.replace(",", "."));
			else
				floatAgeWinner = 0;

			if (ageLoser.length() > 0) {
				floatAgeLoser = Float.parseFloat(ageLoser.replace(",", "."));
				diff = Math.abs(floatAgeWinner - floatAgeLoser);
				sum =  floatAgeWinner + floatAgeLoser;
			} else {
				floatAgeLoser = 0;
			}

			////////// Ranking///////////////
			if (rankingWinner.length() > 0)
				intRankingWinner = Integer.parseInt(rankingWinner);
			if (rankingLoser.length() > 0)
				intRankingLoser = Integer.parseInt(rankingLoser);

			////////// Ace///////////////
			if (winnerAce.length() > 0) {
				intWinnerAce = Integer.parseInt(winnerAce);
				if (winner.equals(winnerRecord) && intWinnerAce >= intWinnerAceRecord)
					intWinnerAceCounterPersonal++;

				if (intWinnerAce >= intWinnerAceRecord)
					intWinnerAceCounter++;
			}

			if (loserAce.length() > 0) {
				intLoserAce = Integer.parseInt(loserAce);
				if (loser.equals(loserRecord) && intLoserAce >= intLoserAceRecord)
					intLoserAceCounterPersonal++;

				if (intLoserAce >= intLoserAceRecord)
					intLoserAceCounter++;
			}

			////
		if (winner1stWon.length() > 0) 
		{
				
				winnerBpSavedInt = Integer.parseInt(winnerBpSaved);
				winnerBpFacedInt = Integer.parseInt(winnerBpFaced);
				loserBpSavedInt = Integer.parseInt(loserBpSaved);
				
				if (loserBpFaced.length() > 0)
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
			    
			////Return stat  
			returnWinnerWon = loserSvpInt - loser1stWonInt - loser2ndWonInt;
			if(loserSvpInt > 0)
		    returnWinnerWonPercentuage = (float) ((loserSvpInt - loser1stWonInt - loser2ndWonInt) / loserSvpInt)*100;
			     
					
			}
		}

//			//Bagel gives
//			if ((winner.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && loser.contains("Fognini"))) 
//		    {
//			//Bagel takes
//			if ((loser.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && winner.contains("Fognini"))) 
//		    {
			

			//Miami
//			if (tournament.contains("Miami Masters") || tournament.contains("Key") || (tournament.contains("Delray Beach") && date.contains("1985")) || (tournament.contains("Boca West") && date.contains("1986")){
			
			
//			// ignores leap years
//			totaldays = (int) (floatAgeWinner *365.25);
//					
//			years = (int)totaldays/365;
//            totaldays %= 365;
//
//            // assumes all months have 30 days
//            months = (int) totaldays/30;
//            totaldays %= 30;
//            
//            days = (int) totaldays;
//
//            
//            entryWinner = years+" y "+months+" m "+days +" d";
//            tdsWinner = years+" y "+months+" m "+days +" d";
              //System.out.println(entryWinner);
            

 
           if(duration.length() > 0)
        	   if(tournament.contains("Masters") && round.equals("F") && floatAgeWinner < 22)
				writeExcel(2, test);
	
		}


		
		
		System.out.println("ACE general Winner Counter:" + intWinnerAceCounter);
		System.out.println("ACE general Winner Personal Counter:" + intWinnerAceCounterPersonal);
		System.out.println("ACE general Loser  Counter:" + intLoserAceCounter);
		System.out.println("ACE general Loser Personal Counter:" + intLoserAceCounterPersonal);
		System.out.println("STOP");
	}

	private static void readRecord() {
		row2 = firstString.split(",");

		System.out.println(firstString);
		tournamentRecord = row2[1];

		surfaceRecord = row2[2];

		drawSizeRecord = row2[3];

		categoryRecord = row2[4];

		dateRecord = row2[5];
		dateRecord = processDate(dateRecord);

		matchNumberRecord = row2[6];

		tdsWinnerRecord = row2[8];

		entryWinnerRecord = row2[9];

		winnerRecord = row2[10];

		handWinnerRecord = row2[11];

		natWinnerRecord = row2[13];

		ageWinnerRecord = row2[14].replace(",", ".");

		rankingWinnerRecord = row2[15];

		// <<<<<<<<<Loser>>>>>>>>>>>>>>>>>//
		tdsLoserRecord = row2[18];

		entryLoserRecord = row2[19];

		loserRecord = row2[20];

		handLoserRecord = row2[21];

		natLoserRecord = row2[23];

		ageLoserRecord = row2[24].replace(",", ".");

		rankingLoserRecord = row2[25];

		scoreRecord = row2[27];

		processScore(scoreRecord);

		bestOfRecord = row2[28];

		roundRecord = row2[29];
		if (row2.length > 31) {
			durationRecord = row2[30];

			winnerAceRecord = row2[31];

			winnerDfRecord = row2[32];

			winnerSvptRecord = row2[33];

			winner1stInRecord = row2[34];

			winner1stWonRecord = row2[35];

			winner2ndWonRecord = row2[36];

			winnerSvGmsRecord = row2[37];

			winnerBpSavedRecord = row2[38];

			winnerBpFacedRecord = row2[39];

			loserAceRecord = row2[40];

			loserDfRecord = row2[41];

			loserSvptRecord = row2[42];

			loser1stInRecord = row2[43];

			loser1stWonRecord = row2[44];

			loser2ndWonRecord = row2[45];

			loserSvGmsRecord = row2[46];

			loserBpSavedRecord = row2[47];

			loserBpFacedRecord = row2[48];
		}

		if (tournamentRecord.contains("Davis Cup")) {
			tourRecord = "Davis Cup";
		} else {
			tourRecord = "";

		}

		if (ageWinnerRecord.length() > 0)
			floatAgeWinnerRecord = Float.parseFloat(ageWinnerRecord.replace(",", "."));
		else
			floatAgeWinnerRecord = 0;

		if (ageLoserRecord.length() > 0) {
			floatAgeLoserRecord = Float.parseFloat(ageLoserRecord.replace(",", "."));
			diffRecord = Math.abs(floatAgeWinnerRecord - floatAgeLoserRecord);
		} else {
			floatAgeLoserRecord = 0;
		}

		if (rankingWinnerRecord.length() > 0)
			intRankingWinnerRecord = Integer.parseInt(rankingWinnerRecord);
		if (rankingLoserRecord.length() > 0)
			intRankingLoserRecord = Integer.parseInt(rankingLoserRecord);

		if (winnerAceRecord.length() > 0) {
			intWinnerAceRecord = Integer.parseInt(winnerAceRecord);
			System.out.println("Winner Ace Record: " + winnerAceRecord);
		}

		if (loserAce.length() > 0)
			intLoserAceRecord = Integer.parseInt(loserAceRecord);

		if (winner1stWonRecord.length() > 0) {
			winnerBpSavedIntRecord = Integer.parseInt(winnerBpSavedRecord);
			winnerBpFacedIntRecord = Integer.parseInt(winnerBpFacedRecord);

			loserBpSavedIntRecord = Integer.parseInt(loserBpSavedRecord);
			loserBpFacedIntRecord = Integer.parseInt(loserBpFacedRecord);
			winner1stWonFloatRecord = Float.parseFloat(winner1stWonRecord);
			winner2ndWonFloatRecord = Float.parseFloat(winner2ndWonRecord);

			if (winnerSvptRecord.length() > 0) {
				if ((Integer.parseInt(winnerSvptRecord) - Integer.parseInt(winner1stInRecord) > 0))
					percentuage2ndWonRecord = (Float.parseFloat(winner2ndWonRecord)
							/ (Float.parseFloat(winnerSvptRecord) - Float.parseFloat(winner1stInRecord))) * 100;

				percentuage1stWonRecord = (Float.parseFloat(winner1stWonRecord) / Float.parseFloat(winner1stInRecord))
						* 100;
			}
		}

	}

	private static void display() {

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

	private static String processDate(String data) {
		year = data.substring(0, 4);
		mouth = data.substring(4, 6);
		day = data.substring(6, 8);

		data = day + "/" + mouth + "/" + year;

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

			if (tdsWinner.length() > 0) {
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
