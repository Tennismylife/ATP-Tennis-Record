import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Converter {
	private static String[] row;
	private static String tournament;
	private static String date;
	private static String winner;
	private static String loser;
	private static String ageWinner;
	private static String ageLoser;
	private static String round;
	private static String tdsWinner;
	private static String rankingWinner;
	private static String tdsLoser;
	private static String rankingLoser;
	private static String score;
	private static String surface;
	private static String natWinner;
	private static String natLoser;
	private static String duration = "";
	private static String winnerAce = "";
	private static String winnerDf = "";
	private static String winnerSvpt = "";
	private static String winner1stIn = "";
	private static String winner1stWon = "";
	private static String winner2ndWon = "";
	private static String winnerSvGms = "";
	private static String winnerBpFaced = "";
	private static String loserAce = "";
	private static String loserDf = "";
	private static String loserSvpt = "";
	private static String loser1stIn = "";
	private static String loser1stWon = "";
	private static String loser2ndWon = "";
	private static String loserSvGms = "";
	private static String loserBpSaved = "";
	private static String loserBpFaced = "";
	private static List<String> line;
	private static String plot;
	private static BufferedWriter w;
	private static String draw;
	private static String tourneyId;
	private static String winnerId;
	private static String loserId;
	private static String year;
	private static String indoor;
	private static String commitment;
	private static String winnerHand;
	private static String loserHand="";
	
	public static void main(String[] args) throws IOException {
		
		line = Files.readAllLines(Paths.get("Input.txt"), Charset.forName("UTF-8"));
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		
		for (Iterator<String> iter = line.listIterator(0); iter.hasNext();) 
		{
			plot =iter.next();
			row = plot.split(",");
			
			System.out.println(plot);
			System.out.println(row.length);
			
			
			year = row[0]; 
			
			date = row[1];
			System.out.println("Date:" +date);
			
			tournament = row[2];
			
			tourneyId = row[3];
			tourneyId = tourneyId.replace("_", "-");
			

			surface = row[4];
			
			indoor = row[5];
			
			commitment = row[6];

			draw = row[7];
			
			round = row[8];
			System.out.println("Round:" +round);
			
			winnerId = row[9];

			tdsWinner = row[10];
			
			rankingWinner = row[11];
			System.out.println("Ranking winner: " +rankingWinner);
			
			ageWinner = row[12].replace(",", ".");
            System.out.println("Age winner: " +ageWinner);
            
            natWinner = row[13];
            
			winner = row[14];
			
			winnerHand = row[15];
			
			score = row[16];
			System.out.println("Score:" +score);
			
			// <<<<<<<<<Loser>>>>>>>>>>>>>>>>>//
			
			loserId = row[17];
			
			tdsLoser = row[18];

			rankingLoser = row[19];

			ageLoser = row[20].replace(",", ".");
			
			natLoser = row[21];
			
			loser = row[22];
			System.out.println("Loser: " +loser);
			
			if(row.length > 23) {
				loserHand = row[23];
				
			}
		
		
			if (row.length > 24) {

				winnerAce = row[24];

				winnerDf = row[25];

				winnerSvpt = row[26];

				winner1stIn = row[27];

				winner1stWon = row[28];
				System.out.println("Winner1stWon: " +winner1stWon);

				winner2ndWon = row[29];

				winnerSvGms = row[30];

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
			
		//Writer
	    w.write(tourneyId +","
	    		+tournament +","
				+surface +","
				+draw +","
				+"A" +","
				+date +","
				+"" +","
				+winnerId +","
				+tdsWinner +","
				+"" +","
				+winner+","
				+winnerHand +","
				+"" +","
				+natWinner +","
				+ageWinner +","
				+rankingWinner +","	
				+"" +"," //winner_rank_points
				+loserId +","
				+tdsLoser +","
				+"" +","  // loser_entry
				+loser +","
				+loserHand +","
				+"" +","
				+natLoser +","
				+ageLoser +","
				+rankingLoser +","
				+"" +"," //loser_rank_points
				+score +","
				+"3" +","
				+round +","
				+duration +","
				+winnerAce +","
				+winnerDf +","
				+winnerSvpt +","
				+winner1stIn +","
				+winner1stWon +","
				+winner2ndWon +","
				+winnerSvGms +","
				+winnerBpFaced +","
				+winnerBpFaced +","
				+loserAce +","
				+loserDf +","
				+loserSvpt +","
				+loser1stIn +","
				+loser1stWon +","
				+loser2ndWon +","
				+loserSvGms +","
				+loserBpSaved +","
				+loserBpFaced
				);
	    w.newLine();
	    w.flush();
	     }

	}
	
	
}
