import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Form {

	private static String[] row;
	private static String plot;

	private static WriteExcel test;
	private static WriteExcel test2;
	private static WritableWorkbook workbook;
	private static WritableSheet sheet;

	private static String tournament, date, winner, loser, ageWinner, ageLoser, round, tdsWinner, rankingWinner,
			natWinner, natLoser, tdsLoser, rankingLoser, entryWinner, entryLoser;
	private static String score, surface;

	private static String duration = "", winnerAce = "";
	private static String winnerDf="", winnerSvpt, winner1stIn, winner1stWon = "", winner2ndWon, winnerSvGms,
			winnerBpSaved = "", winnerBpFaced = "";
	private static String loserAce = "";
	private static String loserDf="", loserSvpt, loser1stIn, loser1stWon, loserBpSaved, loser2ndWon, loserSvGms;
	private static String loserBpFaced;
	private static String bestOf;
	private static String score11 = "", score21 = "";
	private static String score12 = "", score22 = "";
	private static String score13 = "", score23 = "";
	private static String score14 = "", score24 = "";
	private static String score15 = "", score25 = "";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static int intRankingWinner, intRankingLoser, intLoserAce, intWinnerAce, winnerBpSavedInt, winnerBpFacedInt,
			loserBpSavedInt, loserBpFacedInt;
	private static float diff, winner1stWonFloat, winner2ndWonFloat, floatAgeWinner, floatAgeLoser,
			winner1stInPercentuage, loser1stInPercentuage, winnerSvpInt, loserSvpInt, loser1stWonInt, loser2ndWonInt,
			winnerPercentuage1stWon, WinnerPercentuage2ndWon, loserPercentuage1stWon, loserPercentuage2ndWon;
	private static float SimpsonWinner, SimpsonLoser;
	private static String year, mouth, day;

	private static int numberPlayedSet;

	private static BufferedWriter w;
	private static ArrayList<String> ListPlayer, listTournament;
	private static List<String> line;
	private static HashMap<String, Integer> countWins = new HashMap<String, Integer>();

	private static int j = 0;
	private static int m = 1;

	private JFrame frame;
	private static JCheckBox checkBoxNumber;
	private static JCheckBox chckbxTournament;
	private static JCheckBox chckbxRound;
	private static JCheckBox chckbxWNat;
	private static JCheckBox chckbxWRanking;
	private static JCheckBox chckbxWAge;
	private static JCheckBox chckbxWinner;
	private static JCheckBox chckbxLEntry;
	private static JCheckBox chckbxLNat;
	private static JCheckBox chckbxLRanking;
	private static JCheckBox chckbxLAge;
	private static JCheckBox chckbxLoser;
	private static JCheckBox chckbxScore;
	private static JCheckBox chckbxSurface;
	private static JCheckBox chckbxDuration;
	private static JCheckBox chckbxWEntry;
	private static JCheckBox chckbxDate;
	private static JTextField textFieldtournament;
	private static JLabel lblTournament;
	private JLabel lblYear;
	private JTextField textFieldYear;
	private String tournamentToSearch;
	private String yearToSearch;
	private JTable table;
	private String category;
	private int intWinnerDf;
	private int intLoserDf;
	private String handWinner;
	private String handLoser;
	private int i = 0;
	private int breakMadeWinner;
	private int intduration;
	private String winnerId;
	private String loserId;
	private String id;
	private String name;
	private static String tournamentId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 * @throws WriteException
	 */
	public Form() throws WriteException, IOException, ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws WriteException
	 * @throws ParseException
	 */
	private void initialize() throws WriteException, IOException, ParseException {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btnStart.isEnabled()) {
					System.out.println("Add Button is pressed");

					try {
						//Read the Database
						line = Files.readAllLines(Paths.get("newdb3.csv"), Charset.forName("UTF-8"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ListPlayer = new ArrayList<String>();
					listTournament = new ArrayList<String>();
					try {
						createSheet();
						search();
						setBackGroundFirstRow();
						sheetAutoFitColumns();
						workbook.write();
						workbook.close();
					} catch (WriteException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				if (!btnStart.isEnabled()) {
					System.out.println("Add Button is not pressed");
				}

			}
		});

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(Color.BLACK);
		table.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "#", "Tournament", "Year", "Round", "New column", "New column", "New column" }));
		table.setBounds(10, 304, 310, -108);
		frame.getContentPane().add(table);
		btnStart.setBounds(257, 151, 89, 23);
		frame.getContentPane().add(btnStart);

		checkBoxNumber = new JCheckBox("#");
		checkBoxNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		checkBoxNumber.setSelected(true);
		checkBoxNumber.setBounds(6, 7, 33, 23);
		frame.getContentPane().add(checkBoxNumber);

		chckbxTournament = new JCheckBox("Tournament");
		chckbxTournament.setSelected(true);
		chckbxTournament.setBounds(97, 7, 123, 23);
		frame.getContentPane().add(chckbxTournament);

		chckbxRound = new JCheckBox("Round");
		chckbxRound.setSelected(true);
		chckbxRound.setBounds(339, 7, 83, 23);
		frame.getContentPane().add(chckbxRound);

		chckbxWEntry = new JCheckBox("W entry");
		chckbxWEntry.setBounds(6, 33, 97, 23);
		frame.getContentPane().add(chckbxWEntry);

		chckbxWNat = new JCheckBox("W Nat");
		chckbxWNat.setSelected(true);
		chckbxWNat.setBounds(125, 33, 73, 23);
		frame.getContentPane().add(chckbxWNat);

		chckbxWRanking = new JCheckBox("W ranking");
		chckbxWRanking.setSelected(true);
		chckbxWRanking.setBounds(219, 33, 101, 23);
		frame.getContentPane().add(chckbxWRanking);

		chckbxWAge = new JCheckBox("W Age");
		chckbxWAge.setSelected(true);
		chckbxWAge.setBounds(349, 33, 89, 23);
		frame.getContentPane().add(chckbxWAge);

		chckbxWinner = new JCheckBox("Winner");
		chckbxWinner.setSelected(true);
		chckbxWinner.setBounds(463, 33, 113, 23);
		frame.getContentPane().add(chckbxWinner);

		chckbxLEntry = new JCheckBox("L Entry");
		chckbxLEntry.setBounds(6, 59, 97, 23);
		frame.getContentPane().add(chckbxLEntry);

		chckbxLNat = new JCheckBox("L Nat");
		chckbxLNat.setSelected(true);
		chckbxLNat.setBounds(125, 59, 73, 23);
		frame.getContentPane().add(chckbxLNat);

		chckbxLRanking = new JCheckBox("L Ranking");
		chckbxLRanking.setSelected(true);
		chckbxLRanking.setBounds(219, 59, 101, 23);
		frame.getContentPane().add(chckbxLRanking);

		chckbxLAge = new JCheckBox("L Age");
		chckbxLAge.setSelected(true);
		chckbxLAge.setBounds(349, 59, 89, 23);
		frame.getContentPane().add(chckbxLAge);

		chckbxLoser = new JCheckBox("Loser");
		chckbxLoser.setSelected(true);
		chckbxLoser.setBounds(463, 59, 123, 23);
		frame.getContentPane().add(chckbxLoser);

		chckbxScore = new JCheckBox("Score");
		chckbxScore.setSelected(true);
		chckbxScore.setBounds(6, 85, 97, 23);
		frame.getContentPane().add(chckbxScore);

		chckbxSurface = new JCheckBox("Surface");
		chckbxSurface.setSelected(true);
		chckbxSurface.setBounds(153, 85, 89, 23);
		frame.getContentPane().add(chckbxSurface);

		chckbxDuration = new JCheckBox("Duration");
		chckbxDuration.setSelected(true);
		chckbxDuration.setBounds(309, 85, 113, 23);
		frame.getContentPane().add(chckbxDuration);

		chckbxDate = new JCheckBox("Date");
		chckbxDate.setSelected(true);
		chckbxDate.setBounds(243, 10, 57, 17);
		frame.getContentPane().add(chckbxDate);

		lblTournament = new JLabel("Tournament");
		lblTournament.setBounds(57, 127, 70, 14);
		frame.getContentPane().add(lblTournament);

		textFieldtournament = new JTextField();
		textFieldtournament.setBounds(41, 152, 86, 20);
		frame.getContentPane().add(textFieldtournament);
		textFieldtournament.setColumns(10);

		lblYear = new JLabel("Year");
		lblYear.setBounds(174, 127, 46, 14);
		frame.getContentPane().add(lblYear);

		textFieldYear = new JTextField();
		textFieldYear.setBounds(156, 152, 86, 20);
		frame.getContentPane().add(textFieldYear);
		textFieldYear.setColumns(10);

	}

	public void createSheet() throws IOException, WriteException {

		test = new WriteExcel();
		Random rand = new Random();
		// Obtain a number between [0 - 49].
		int n = rand.nextInt(5000);

		String inputFile = "output" + n + ".xls";

		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));

		workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		sheet = workbook.getSheet(0);
		test.createLabel(sheet);
	}

	private void search() throws IOException, RowsExceededException, WriteException, ParseException {

//		for (Iterator<String> iter = line.listIterator(1); iter.hasNext();) {
//			plot = iter.next();
//			row = plot.split(",");
//
//			//System.out.println(plot);
//			tournament = row[1];
//			date = row[5];
//			date = processDate(date);
//			winner = row[10];
//			loser = row[20];
//			round = row[29];
//            category = row[4];
//			score = row[27];
//			
//			//processScore(score);
//			if(round.equals("QF") && !ListPlayer.contains(winner)) 
//			{
//				ListPlayer.add(winner);
//				System.out.println("Add: " +winner);
//		    }
//		}
//		
//		for (Iterator<String> iter2 = line.listIterator(1); iter2.hasNext();) {
//			plot = iter2.next();
//			row = plot.split(",");
//
//			tournament = row[1];
//			date = row[5];
//			date = processDate(date);
//			winner = row[10];
//			round = row[29];
//            category = row[4];
//            
//            //score = row[27];
//			//processScore(score);
//            if(row.length > 37)
//			winnerBpSaved = row[38];
//            if(row.length > 38)
//			winnerBpFaced = row[39];
//			
//            if((round.equals("SF") || round.equals("F")) && ListPlayer.contains(winner)) 
//            {
//            System.out.println("Remove:" +winner);
//            ListPlayer.remove(winner);
//            System.out.println(ListPlayer.size());
//            }
//		}

//	for (Iterator<String> iter = line.listIterator(1); iter.hasNext();) {
//		plot = iter.next();
//		row = plot.split(",");
//		
//		//System.out.println(plot);
//		tournament = row[1];
//		winner = row[10];
//        round = row[29];
//        year = processDate(row[5]);
//        category =row[4];
//        rankingLoser = row[25];
//        if (row.length > 31)
//        winnerBpFaced = row[39];
//        
//        if(round.equals("F") && winnerBpFaced.equals("0")) 
//        {
//         System.out.println(tournament + year + winner);
//         listTournament.add(tournament + year + winner);
//        }
//	}

//	for (Iterator<String> iter = line.listIterator(1); iter.hasNext();) {
//		plot = iter.next();
//		row = plot.split(",");
//		
//		//System.out.println(plot);
//		tournament = row[1];
//		winner = row[10];
//        round = row[29];
//        year = processDate(row[5]);
//        category =row[4];
//        entryLoser =  row[19];
//        if (row.length > 31)
//        winnerBpFaced = row[39];
//       
//        if(!winnerBpFaced.equals("0")) 
//        {
//         	System.out.println("Remove: " +tournament + year + winner);
//         	listTournament.remove(tournament + year + winner);
//        }
//	}

		for (Iterator<String> iter2 = line.listIterator(1); iter2.hasNext();) {

			plot = iter2.next();
			
			if (plot.length() > 0)
				row = plot.split(",");
			
			//System.out.println(plot);
			
			tournamentId = row[0];
			
			tournament = row[1];

			surface = row[2];

			category = row[4];

			date = row[5];
			date = processDate(date);
			
			winnerId = row[7];

			// <<<<<<<<<Winner>>>>>>>>>>>>>>>>>//
			tdsWinner = row[8];

			entryWinner = row[9];

			winner = row[10];

			//System.out.println("winner:" +winner);
			
			handWinner = row[11];
			
			//System.out.println("handwinner:" +handWinner);

			natWinner = row[13];
			
			//System.out.println("natWinner:" +natWinner);

			ageWinner = row[14].replace(",", ".");
			
			//System.out.println("ageWinner: " +ageWinner);

			rankingWinner = row[15];

			// <<<<<<<<<Loser>>>>>>>>>>>>>>>>>//
			
			loserId = row[17];
			
			tdsLoser = row[18];

			entryLoser = row[19];

			loser = row[20];
			//System.out.println("Loser:" +loser);
			
			handLoser = row[21];

			natLoser = row[23];

			ageLoser = row[24].replace(",", ".");
			//System.out.println("ageLoser: " +ageLoser);

			rankingLoser = row[25];

			score = row[27];
			processScore(score);

			
			bestOf = row[28];
			//System.out.println("bestOf:" +bestOf);
			
			round = row[29];
			//System.out.println("round:" +round);
			
		
			
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

				if (row.length > 47) {
					loserSvGms = row[46];

					loserBpSaved = row[47];

					loserBpFaced = row[48];
				}
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
			}

			if (loserAce.length() > 0) {
				intLoserAce = Integer.parseInt(loserAce);
			}

			////////// Double Fault///////////////
			if (winnerDf.length() > 0) {
				intWinnerDf = Integer.parseInt(winnerDf);
			}

			if (loserDf.length() > 0) {
				intLoserDf = Integer.parseInt(loserDf);
			}

			////
			if (winner1stWon.length() > 0 && winnerBpSaved.length() > 0) {

				winnerBpSavedInt = Integer.parseInt(winnerBpSaved);
				winnerBpFacedInt = Integer.parseInt(winnerBpFaced);
				loserBpSavedInt = Integer.parseInt(loserBpSaved);

				if (loserBpFaced.length() > 0)
					loserBpFacedInt = Integer.parseInt(loserBpFaced);
				else
					loserBpFacedInt = -1;
                breakMadeWinner = loserBpFacedInt - loserBpSavedInt;
				winner1stWonFloat = Float.parseFloat(winner1stWon);
				winner2ndWonFloat = Float.parseFloat(winner2ndWon);

				// Percentage 1stIn
				if (winner1stIn.length() > 0 && loser1stIn.length() > 0 && winnerSvpt.length() > 0
						&& loserSvpt.length() > 0) {
					winner1stInPercentuage = (Float.parseFloat(winner1stIn) / Float.parseFloat(winnerSvpt)) * 100;
					loser1stInPercentuage = (Float.parseFloat(loser1stIn) / Float.parseFloat(loserSvpt)) * 100;
				}

				if (winnerSvpt.length() > 0 && loserSvpt.length() > 0) {

					winnerSvpInt = Float.parseFloat(winnerSvpt);
					loserSvpInt = Float.parseFloat(loserSvpt);
					loser1stWonInt = Float.parseFloat(loser1stWon);
					loser2ndWonInt = Float.parseFloat(loser2ndWon);

					// % 1st and 2nd Winner
					if ((Integer.parseInt(winnerSvpt) - Integer.parseInt(winner1stIn) > 0)) {
						winnerPercentuage1stWon = (Float.parseFloat(winner1stWon) / Float.parseFloat(winner1stIn))
								* 100;
						WinnerPercentuage2ndWon = (Float.parseFloat(winner2ndWon)
								/ (Float.parseFloat(winnerSvpt) - Float.parseFloat(winner1stIn))) * 100;
					}

					// % 1st and 2nd Loser
					if ((Integer.parseInt(loserSvpt) - Integer.parseInt(loser1stIn) > 0)) {
						loserPercentuage1stWon = (Float.parseFloat(loser1stWon) / Float.parseFloat(loser1stIn)) * 100;
						loserPercentuage2ndWon = (Float.parseFloat(loser2ndWon)
								/ (Float.parseFloat(loserSvpt) - Float.parseFloat(loser1stIn))) * 100;
					}

					if (loserSvpInt > 0) {
					}

				}
				if (loserSvpt.length() > 0)

					SimpsonWinner = winner1stWonFloat + winner2ndWonFloat + Integer.parseInt(loserSvpt)
							- (Float.parseFloat(loser1stWon) + Float.parseFloat(loser2ndWon));
				SimpsonLoser = Float.parseFloat(loser1stWon) + Float.parseFloat(loser2ndWon)
						+ Integer.parseInt(winnerSvpt) - (winner1stWonFloat + winner2ndWonFloat);
			}
			if (duration.length() > 0)
				intduration = Integer.parseInt(duration);

//			//Bagel gives
//			if ((winner.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && loser.contains("Fognini"))) 
//		    {
//			//Bagel takes
//			if ((loser.contains("Fognini") && score.contains("6-0")) || (score.contains("0-6") && winner.contains("Fognini"))) 
//		    {

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
			// System.out.println(entryWinner);
			// System.out.println(tournament + year + winner);
			// System.out.println(duration);
//			//Bagel gives

//			if(!countWins.containsKey(winner))
//			countWins.put(winner, 0);
//			if(!countWins.containsKey(loser))
//			countWins.put(loser, 0);
//			
//			if(countWins.containsKey(winner)) {
//				
//				
//				if(category.equals("F")) {
//					
//					if(!ListPlayer.contains(winner)) {
//			        w.write(winner +","+ countWins.get(winner));
//			        w.newLine();
//			        w.flush();
//					}
//					ListPlayer.add(winner);
//				    }
//				countWins.put(winner, countWins.get(winner) +1);
//				}
//			
//			if(countWins.containsKey(loser)) {
//				
//				
//				if(category.equals("F")) {
//					
//					if(!ListPlayer.contains(loser)) {
//			        w.write(loser +","+ countWins.get(loser));
//			        w.newLine();
//			        w.flush();
//					}
//					ListPlayer.add(loser);
//				    }
//				countWins.put(loser, countWins.get(loser) +1);
//				}


//			if(category.equals("M") && round.equals("QF") && !score.contains("W/O")){
//			if(!countWins.containsKey(winner))
//			{
//			countWins.put(winner, 1);
//		    }else {
//		    	int wins = countWins.get(winner);
//		    	wins = wins +1;
//		    	System.out.println(winner +"," + wins);
//		    	if(wins == 4)
//				{
//					writeExcel(2, test);
//				}
//		    	
//		    	countWins.put(winner, wins);
//		    }
//			}
			
			//Script for entries
			//System.out.println(plot);
//			if(((winner.contains("Seppi") || loser.contains("Seppi")) && !listTournament.contains(tournament + year)) && !tournament.contains("Davis Cup")) 
//			{  
			//System.out.println(plot);

//			if(!countWins.containsKey(winner +"," +year))
//			countWins.put(winner +"," +year, 0);
//			
//			if(!countWins.containsKey(winner +"," + year))
//			{
//			countWins.put(winner +"," + year, 0);
//		    }else {
//		    	int wins = countWins.get(winner  +"," +year);
//		    	wins = wins +1;
//		    	countWins.put(winner +"," +year, wins);
//		    }
			
//			if(date.contains("1971") && !listTournament.contains(tournament + year) && !tournament.contains("Davis"))  			
//			{
//				listTournament.add(tournament + year);
//				writeExcel(2, test);
//			}
			

			
//			id = "MF36";
//		    name = "Miloslav Mecir Sr.";
//			if( (loserId.equals(id) && loser.contains(name)) || winnerId.equals(id) && winner.contains(name))
//			{
//				writeExcel(2, test);
//			}
			
//			if( (winner.equals("John Isner") || loser.equals("John Isner")) && year.equals("2017") && ! score.contains("W/O"))
//			{
//				writeExcel(2, test);
//			}
			
//			if( rankingWinner.length() == 0 && Integer.parseInt(year) > 1973 && !tournament.contains("Davis"))
//			{
//				writeExcel(2, test);
//			}			
			
//			if( round.equals("F") && (winner.equals("Brian Teacher") || loser.equals("Brian Teacher")))
//			{
//				writeExcel(2, test);
//			}	

//			if( (rankingWinner.length() == 0  || rankingLoser.length() == 0) && Integer.parseInt(year) > 1973 && !tournament.contains("Davis"))
//			{
//				writeExcel(2, test);
//			}
			
//			if( category.equals("G") && (winner.contains("John McEnroe") || loser.contains("John McEnroe")) && !score.contains("W/O"))
//			{
//				listTournament.add(tournamentId);
//				writeExcel(2, test);
//			}
			
//			//Bagel gives
			if ((winner.contains("Verdasco") && score.contains("6-0")) || (score.contains("0-6") && loser.contains("Verdasco"))) 
		    {

				writeExcel(2, test);
			}
			
			//entry("Wimbledon");
			//toWinAMatch("US Open");

		}
		
//	    Iterator it = countWins.entrySet().iterator();
//	    while (it.hasNext()) {
//	        Map.Entry countWins = (Map.Entry)it.next();
//	        System.out.println(countWins.getKey() + " = " + countWins.getValue());
//	        w.write(countWins.getKey() + "," + countWins.getValue());
//	        w.newLine();
//	        w.flush();
//	        it.remove(); // avoids a ConcurrentModificationException
//	    }

		System.out.println("STOP");

	}

	private void toWinAMatch(String tournamentToSearch) throws RowsExceededException, WriteException {
		if(!ListPlayer.contains(tournament + year + winner) && tournament.contains(tournamentToSearch)) {
			ListPlayer.add(tournament + year + winner);
			writeExcel(2, test);
		}
	}
		
		


	private void entry(String tournamentToSearch) throws RowsExceededException, WriteException {
		if (category.equals("G") && !listTournament.contains(tournament + year + winner)) {
			System.out.println("Add:" + tournament + year + winner);
			System.out.println(m);
			listTournament.add(tournament + year + winner);
			listTournament.add(tournament + year + loser);

			test.addCaption(sheet, 0, 0, "Tournament");
			test.addCaption(sheet, 1, 0, "Year");
			test.addCaption(sheet, 2, 0, "Nat");
			test.addCaption(sheet, 3, 0, "Player");
			test.addCaption(sheet, 4, 0, "Age");

			test.addCaption(sheet, 0, m, tournament);

			if (date.length() == 4) {
				test.addNumber(sheet, 1, m, Integer.parseInt(date));
			} else {
				test.addCaption(sheet, 1, m, date);
			}

			test.addCaption(sheet, 2, m, natWinner);
			test.addCaption(sheet, 3, m, String.valueOf(winner));

			if (ageWinner.length() > 0) {
				test.addNumberDouble(sheet, 4, m, Double.parseDouble(ageWinner.substring(0, ageWinner.length())));
			}

			m++;

			test.addCaption(sheet, 0, m, tournament);

			if (date.length() == 4) {
				test.addNumber(sheet, 1, m, Integer.parseInt(date));
			} else {
				test.addCaption(sheet, 1, m, date);
			}

			test.addCaption(sheet, 2, m, natLoser);
			test.addCaption(sheet, 3, m, String.valueOf(loser));

			if (ageLoser.length() > 0) {
				test.addNumberDouble(sheet, 4, m, Double.parseDouble(ageLoser.substring(0, ageLoser.length())));
			}

			m++;

		}

	}

	private static void processScore(String score) {
		String set1 = "", set2 = "", set3 = "", set4 = "", set5 = "";
		String[] punteggio = new String[10];

		score = score.replace("[", "");
		score = score.replace("]", "");
		punteggio = score.split(" ");
		score11 = "";
		score12 = "";
		score21 = "";
		score22 = "";
		score13 = "";
		score23 = "";
		score14 = "";
		score24 = "";
		score15 = "";
		score25 = "";
		numberPlayedSet = countChar(score, '-');

		if (!score.contains("W/O") && score.length() > 0 && !score.contains("DEF") && !score.contains("NA")
				&& !score.contains("RET") && !score.contains("ABN") && !score.contains("ABD")) {
			if (numberPlayedSet > 0) {
				set1 = punteggio[0];
				score11 = punteggio[0].substring(0, punteggio[0].indexOf("-"));
				score21 = punteggio[0].substring(set1.indexOf("-") + 1, punteggio[0].length());

			}
			if (numberPlayedSet > 1) {
				set2 = punteggio[1];
				score12 = set2.substring(0, set2.indexOf("-"));
				score22 = set2.substring(set2.indexOf("-") + 1, set2.length());
			}
			if (numberPlayedSet > 2) {
				set3 = punteggio[2];
				score13 = set3.substring(0, set3.indexOf("-"));
				score23 = set3.substring(set3.indexOf("-") + 1, set3.length());
			}
			if (numberPlayedSet > 3) {
				set4 = punteggio[3];
				score14 = set4.substring(0, set4.indexOf("-"));
				score24 = set4.substring(set4.indexOf("-") + 1, set4.length());
			}
			if (numberPlayedSet > 4) {
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

	private void setBackGroundFirstRow() throws WriteException {

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

	public static boolean isNumeric(String str) {
		System.out.println(str);
		try {
			Double.parseDouble(str);

			return true;
		} catch (NumberFormatException e) {
			return false;
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

//		year = date.substring(0, 4);
//		mouth = date.substring(4, 6);
//		day = date.substring(6, 8);
//
//		date = day + "/" + mouth + "/" + year;
//		

		if(tournamentId.length() > 0)
		year = tournamentId.substring(0, 4);
		
		return year;
	}

	private static void writeExcel(int settings, WriteExcel test) throws RowsExceededException, WriteException {

		if (settings == 2) {
			j = 0;
			if (checkBoxNumber.isSelected())
				test.addCaption(sheet, j, 0, "#");

			if (chckbxTournament.isSelected())
				test.addCaption(sheet, ++j, 0, "Tournament");

			if (chckbxDate.isSelected())
				test.addCaption(sheet, ++j, 0, "Year");

			if (chckbxRound.isSelected())
				test.addCaption(sheet, ++j, 0, "Round");

			if (chckbxWEntry.isSelected())
				test.addCaption(sheet, ++j, 0, "W entry");

			if (chckbxWNat.isSelected())
				test.addCaption(sheet, ++j, 0, "W Nat");

			if (chckbxWRanking.isSelected())
				test.addCaption(sheet, ++j, 0, "W Ranking");

			if (chckbxWAge.isSelected())
				test.addCaption(sheet, ++j, 0, "W Age");

			if (chckbxWinner.isSelected())
				test.addCaption(sheet, ++j, 0, "Winner");

			if (chckbxLEntry.isSelected())
				test.addCaption(sheet, ++j, 0, "L entry");

			if (chckbxLNat.isSelected())
				test.addCaption(sheet, ++j, 0, "L Naz");

			if (chckbxLRanking.isSelected())
				test.addCaption(sheet, ++j, 0, "L Ranking");

			if (chckbxLAge.isSelected())
				test.addCaption(sheet, ++j, 0, "L Age");

			if (chckbxLoser.isSelected())
				test.addCaption(sheet, ++j, 0, "Loser");

			if (chckbxScore.isSelected())
				test.addCaption(sheet, ++j, 0, "Score");

			if (chckbxSurface.isSelected())
				test.addCaption(sheet, ++j, 0, "Surface");

			if (chckbxDuration.isSelected())
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
			if (m > 1) {
				String formula = "A" + String.valueOf(m) + "+1";
				test.addFormula(sheet, j, m, formula);
			}

			if (chckbxTournament.isSelected()) {
				test.addCaption(sheet, ++j, m, tournament);

				if (chckbxDate.isSelected()) {
					if (date.length() == 4) {
						test.addNumber(sheet, ++j, m, Integer.parseInt(date));
					} else {
						test.addCaption(sheet, ++j, m, date);
					}
				}

				if (chckbxRound.isSelected())
					test.addCaption(sheet, ++j, m, round);

				if (chckbxWEntry.isSelected()) {
					if (tdsWinner.length() > 0) {
						test.addCaption(sheet, ++j, m, tdsWinner);
					} else {
						test.addCaption(sheet, ++j, m, entryWinner);
					}

				}
				if (chckbxWNat.isSelected())
					test.addCaption(sheet, ++j, m, natWinner);

				if (chckbxWRanking.isSelected()) {
					if (rankingWinner.length() > 0) {
						test.addNumber(sheet, ++j, m, Integer.parseInt(rankingWinner));
					} else {
						++j;
					}
				}

				if (chckbxWAge.isSelected()) {
					if (ageWinner.length() > 0) {
						test.addNumberDouble(sheet, ++j, m,
								Double.parseDouble(ageWinner.substring(0, ageWinner.length())));

					} else {
						++j;
					}

				}

				if (chckbxWinner.isSelected())
					test.addCaption(sheet, ++j, m, String.valueOf(winner));

				if (chckbxWEntry.isSelected())
					if (tdsLoser.length() > 0) {
						test.addCaption(sheet, ++j, m, String.valueOf(tdsLoser));
					} else {
						test.addCaption(sheet, ++j, m, String.valueOf(entryLoser));
					}
			}

			if (chckbxLNat.isSelected())
				test.addCaption(sheet, ++j, m, natLoser);

			if (chckbxLRanking.isSelected()) {
				if (rankingLoser.length() > 0) {
					test.addNumber(sheet, ++j, m, Integer.parseInt(rankingLoser));
				} else {
					++j;
				}
			}

			if (chckbxLAge.isSelected()) {
				if (ageLoser.length() > 0) {
					test.addNumberDouble(sheet, ++j, m, Double.parseDouble(ageLoser.substring(0, ageLoser.length())));
				} else {
					++j;
				}
			}

			if (chckbxLoser.isSelected())
				test.addCaption(sheet, ++j, m, loser);

			if (chckbxScore.isSelected())
				test.addCaption(sheet, ++j, m, score);

			if (chckbxSurface.isSelected())
				test.addCaption(sheet, ++j, m, surface);

			if (chckbxDuration.isSelected()) {
				if (duration.length() > 0)
					test.addNumber(sheet, ++j, m, Integer.parseInt(duration));
				else
					++j;
			}

			test.addCaption(sheet, ++j, m, bestOf);
			if (score11.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score11));
			else
				j++;
			if (score21.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score21));
			else
				j++;

			if (score12.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score12));
			else
				j++;
			if (score22.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score22));
			else
				j++;
			if (score13.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score13));
			else
				j++;
			if (score23.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score23));
			else
				j++;
			if (score14.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score14));
			else
				j++;

			if (score24.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score24));
			else
				j++;
			if (score15.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score15));
			else
				j++;
			if (score25.length() > 0)
				test.addNumber(sheet, ++j, m, Integer.parseInt(score25));
			else
				j++;

			if (winnerAce.length() > 0) {
				test.addNumber(sheet, ++j, m, Integer.parseInt(winnerAce));
				if (winnerDf.length() > 0)
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
}
