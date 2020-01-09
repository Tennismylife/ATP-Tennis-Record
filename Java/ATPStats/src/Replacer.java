import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Replacer {
	private static List<String> lines;
	private static List<String> lines2;

	private static BufferedWriter w;
	private static BufferedWriter w2;

	private static String plot2 = "";
	private static String plot = "";
	private static String[] row;
	private static String[] row2;
	private static String winnerid = "";
	private static String loserid = "";
	private static String winnerName = "";
	private static String loserName = "";
	private static String tourneyName = "";
	private static String tourneyDate = "";
	private static String round = "";
	private static String winnerSeed = "";
	private static String winnerEntry = "";
	private static String winnerHand = "";
	private static String winnerHT = "";
	private static String winnerIOC = "";
	private static String winnerAge = "";
	private static String winnerRank = "";
	private static String winnerRankPoints = "";
	private static String loserSeed = "";
	private static String loserEntry = "";
	private static String loserHand = "";
	private static String loserHT = "";
	private static String loserIOC = "";
	private static String loserAge = "";
	private static String loserRank = "";
	private static String loserRankPoints = "";
	private static String tourneyID = "";
	private static String surface = "";
	private static String drawSize = "";
	private static String tourneyLevel = "";
	private static String matchNumber = "";
	private static String score = "";
	private static String best_of = "";
	private static String minutes = "";
	private static String w_ace = "";
	private static String w_df = "";
	private static String w_svpt = "";
	private static String w_1stIn = "";
	private static String w_1stWon = "";
	private static String w_2ndWon = "";
	private static String w_SvGms = "";
	private static String w_bpSaved = "";
	private static String w_bpFaced = "";
	private static String l_ace = "";
	private static String l_df = "";
	private static String l_svpt = "";
	private static String l_1stIn = "";
	private static String l_1stWon = "";
	private static String l_2ndWon = "";
	private static String l_SvGms = "";
	private static String l_bpSaved = "";
	private static String l_bpFaced = "";
	private static String current_tourney_id = "";
	private static String current_round = "";
	private static String current_winner_id = "";
	private static String current_winner_name = "";
	private static String current_loser_id = "";
	private static String current_loser_name = "";

	private static int i = 1;
	private static int j = 1;
	private static boolean flag = true;
	private static String support;
	private static String current_winner_seed;
	private static String current_winner_rank;
	private static String current_winner_hand;
	private static String current_winner_age;
	private static String current_winner_ioc;
	private static String current_loser_seed;
	private static String current_loser_rank;
	private static String current_loser_age;
	private static String current_loser_ioc;
	private static String current_loser_hand;
	private static int current_year;
	private static int year;
	private static String current_winner_rank_points;
	private static String current_loser_rank_points;
	private static String current_tournament_name;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		w2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Review.txt"), "UTF-8"));

		lines = Files.readAllLines(Paths.get("newdb3.csv"), Charset.forName("UTF-8"));
		lines2 = Files.readAllLines(Paths.get("Sackmann.csv"), Charset.forName("UTF-8"));
		
//		System.out.println(lines2.size());
//		for (Iterator<String> iter2 = lines2.listIterator(1); iter2.hasNext();) {
//			plot2 = iter2.next();
//			row2 = plot2.split(",");
//			current_winner_rank = row2[15];
//			if(current_winner_rank.length() == 0) iter2.remove();
//		}
//		System.out.println(lines2.size());
		
		
		for (Iterator<String> iter = lines.listIterator(1); iter.hasNext();) {
			plot = iter.next();
			//System.out.println(plot);
			row = plot.split(",");

			tourneyID = row[0];
			tourneyName = row[1];
			surface = row[2];
			drawSize = row[3];
			tourneyLevel = row[4];

			tourneyDate = row[5];

			matchNumber = row[6];

			winnerid = row[7];
			winnerSeed = row[8];
			winnerEntry = row[9];
			winnerName = row[10];
			winnerHand = row[11];
			winnerHT = row[12];
			winnerIOC = row[13];
			winnerAge = row[14];
			winnerRank = row[15];
			winnerRankPoints = row[16];

			loserid = row[17];
			loserSeed = row[18];
			loserEntry = row[19];
			loserName = row[20];
			loserHand = row[21];
			loserHT = row[22];
			loserIOC = row[23];
			loserAge = row[24];
			loserRank = row[25];
			loserRankPoints = row[26];

			score = row[27];
			best_of = row[28];
			round = row[29];

			if (row.length > 30) {
				minutes = row[30];
				w_ace = row[31];
				w_df = row[32];
				w_svpt = row[33];
				w_1stIn = row[34];
				w_1stWon = row[35];
				w_2ndWon = row[36];
				w_SvGms = row[37];
				w_bpSaved = row[38];
				w_bpFaced = row[39];

				l_ace = row[40];
				l_df = row[41];
				l_svpt = row[42];
				l_1stIn = row[43];
				l_1stWon = row[44];
				l_2ndWon = row[45];
				l_SvGms = row[46];
				l_bpSaved = row[47];
				l_bpFaced = row[48];
			}

			year = Integer.parseInt(tourneyID.substring(0, 4));

			//replaceDomanov();
			replaceSackmann();
			
			
			
			////////////////////////// WRITING ////////////////////////////////////
			w.write(tourneyID + "," +tourneyName + "," +surface + "," +drawSize + "," +tourneyLevel + ","
					+tourneyDate + "," +matchNumber + "," +winnerid + "," +winnerSeed + "," +winnerEntry + ","
					+winnerName + "," +winnerHand + "," +winnerHT + "," +winnerIOC + "," +winnerAge + ","
					+winnerRank + "," +winnerRankPoints + "," +loserid + "," +loserSeed + "," +loserEntry + ","
					+loserName + "," +loserHand + "," +loserHT + "," +loserIOC + "," +loserAge + "," +loserRank + ","
					+loserRankPoints + "," +score + "," +best_of + "," +round + "," +minutes + "," +w_ace + ","
					+w_df + "," +w_svpt + "," +w_1stIn + "," +w_1stWon + "," +w_2ndWon + "," +w_SvGms + ","
					+w_bpSaved + "," +w_bpFaced + "," +l_ace + "," +l_df + "," +l_svpt + "," +l_1stIn + ","
					+l_1stWon + "," +l_2ndWon + "," +l_SvGms + "," +l_bpSaved + "," +l_bpFaced +"\n");
			w.flush();
		}
	}

	private static void replaceSackmann() {
		if((winnerRank.length() == 0 || loserRank.length() == 0) && year > 1972 && !tourneyName.contains("Davis")) {
			// System.out.println(j);
			for (Iterator<String> iter2 = lines2.listIterator(j); iter2.hasNext();) {
				plot2 = iter2.next();
				row2 = plot2.split(",");
				

				current_tourney_id = row2[0];
				current_tournament_name = row2[1];
				current_year = Integer.parseInt(current_tourney_id.substring(0, 4));

				if (current_year > year)
					break;

					current_round = row2[8];

					current_winner_name = row2[10];
					current_winner_rank = row2[15];
					current_winner_rank_points = row2[16];
					
		
					current_loser_name = row2[20];
					current_loser_rank = row2[25];
					current_loser_rank_points = row2[26];
					current_round = row2[29];
					
					//System.out.println(current_tourney_id +"," +current_winner_name +"," +current_loser_name +"," +current_round);

///////////////////////////////////////////// RANKING /////////////////////////////////////////////////////////////////////////
					if (tourneyName.equals(current_tournament_name) && 
							winnerName.equals(current_winner_name) && 
							loserName.equals(current_loser_name) && 
							round.equals(current_round)) 
						{
						//System.out.println(plot2);
						//System.out.println(current_winner_rank);
						//System.out.println(current_loser_rank);
						
						if (winnerRank.length() == 0 && current_winner_rank.length() > 0) {
							winnerRank= current_winner_rank;
							System.out.println("Replace");
							System.out.println(plot);
						}

						if (loserRank.length() == 0 && current_loser_rank.length() > 0) 
						{
								loserRank = current_loser_rank;
								System.out.println("Replace");
								System.out.println(plot);

						}
							lines2.remove(plot2);
							flag = false;
							break;
							
						}				
					
					
					if (current_tourney_id.equals(tourneyID))
						flag = false;

					// System.out.println(j);
					if (flag == true)
						j++;

				
			}
			}
		
	}

	private static void replaceDomanov() {
		if(winnerRank.length() == 0 && year > 1972 && !tourneyName.contains("Davis")) {
			// System.out.println(j);
			for (Iterator<String> iter2 = lines2.listIterator(j); iter2.hasNext();) {
				plot2 = iter2.next();
				row2 = plot2.split(",");


				current_tourney_id = row2[3];
				current_tourney_id = current_tourney_id.replace("_", "-");
				current_year = Integer.parseInt(current_tourney_id.substring(0, 4));

				if (current_year > year && year < 1974)
					break;

				if (current_tourney_id.equals(tourneyID)) {
					current_round = row2[8];

					current_winner_id = row2[9];
					current_winner_seed = row2[10];
					current_winner_rank = row2[11];
					current_winner_age = row2[12];
					current_winner_ioc = row2[13];
					current_winner_name = row2[14];
					current_winner_hand = row2[15];

					current_loser_id = row2[17];
					current_loser_seed = row2[18];
					current_loser_rank = row2[19];
					current_loser_age = row2[20];
					current_loser_ioc = row2[21];
					current_loser_name = row2[22];
					// System.out.println(current_loser_name);
					if (row2.length > 23)
						current_loser_hand = row2[23];

////////////////////////////////////// SAME NAMES ////////////////////////////////////////////////////////////////////////////////				
//				if (tourneyID.equals(current_tourney_id) && 
//					winnerName.equals(current_winner_name)&& 
//					loserName.equals(current_loser_name) && 
//					round.equals(current_round)) 
//				{
//
//					if (!winnerid.equals(current_winner_id)) {
//						winnerid = current_winner_id;
//						System.out.println(winnerName);
//						System.out.println("Replace Winner Id");
//						System.out.println(plot2);
//					}
//
//					if (!loserid.equals(current_loser_id)) {
//						loserid= current_loser_id;
//						System.out.println(loserName);
//						System.out.println("Replace Loser Id");
//						System.out.println(plot2);
//					}
//					
//					lines2.remove(plot2);
//					flag = false;
//					//j = j + 1;
//					break;
//					
//				}

///////////////////////////////////////////// SWAPPING /////////////////////////////////////////////////////////////////////////				
//					if (tourneyID.equals(current_tourney_id) && winnerName.equals(current_loser_name)
//							&& loserName.equals(current_winner_name) && round.equals(current_round)) {
//						support = winnerid;
//						loserid = winnerid;
//						winnerid = support;
//
//						support = winnerSeed;
//						loserSeed = winnerSeed;
//						winnerSeed = support;
//
//						support = winnerEntry;
//						loserEntry = winnerEntry;
//						winnerEntry = support;
//
//						support = winnerName;
//						loserName = winnerName;
//						winnerName = support;
//
//						support = winnerHand;
//						loserHand = winnerHand;
//						winnerHand = support;
//
//						support = winnerHT;
//						loserHT = winnerHT;
//						winnerHT = support;
//
//						support = winnerIOC;
//						loserIOC = winnerIOC;
//						winnerIOC = support;
//
//						support = winnerAge;
//						loserAge = winnerAge;
//						winnerAge = support;
//
//						support = winnerRank;
//						loserRank = winnerRank;
//						winnerRank = support;
//
//						support = winnerRankPoints;
//						loserRankPoints = winnerRankPoints;
//						winnerRankPoints = support;
//
//						///////// SWITCH//////////////////////
//						winnerid = current_winner_id;
//						winnerSeed = current_winner_seed;
//
//						winnerName = current_winner_name;
//
//						winnerHand = current_winner_hand;
//						winnerIOC = current_winner_ioc;
//						winnerAge = current_winner_age;
//						winnerRank = current_winner_rank;
//
//						loserid = current_loser_id;
//						loserSeed = current_loser_seed;
//
//						loserName = current_loser_name;
//
//						loserHand = current_loser_hand;
//						loserIOC = current_loser_ioc;
//						loserAge = current_loser_age;
//						loserRank = current_loser_rank;
//						flag = false;
//
//						System.out.println(plot2);
//
//						w2.write(plot + "\n");
//						w2.flush();
//
//						w2.write(plot2 + "\n");
//						w2.flush();
//
//						w2.newLine();
//
//						// lines2.remove(plot2);
//						// j = j + 1;
//						break;
//
//					}

					
///////////////////////////////////////////// RANKING /////////////////////////////////////////////////////////////////////////
					if (tourneyID.equals(current_tourney_id) && 
							winnerName.equals(current_winner_name) && 
							loserName.equals(current_loser_name) && 
							round.equals(current_round)) 
						{
						
						if (winnerRank.length() == 0 && current_winner_rank.length() > 0) {
							winnerRank= current_winner_rank;
							System.out.println("Replace");
							System.out.println(plot);
						}

						if (loserRank.length() == 0 && current_loser_rank.length() > 0) 
						{
								loserRank = current_loser_rank;

						}


							
							lines2.remove(plot2);
							flag = false;
							break;
							
						}				
					
					
					if (current_tourney_id.equals(tourneyID))
						flag = false;

					// System.out.println(j);
					if (flag == true)
						j++;

				}
			}
			}
		
	}

}