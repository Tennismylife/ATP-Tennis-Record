import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class ATPGrab {
	
	private static List<String> tournaments, scores, stats;
	private static String[] row;
	private static BufferedWriter w;
	
	
	private static String tourneyName="11111111";
	private static String tourneyLocation="";
	private static String tourneyDates="";
	private static String tourneySinglesDraw="";
	private static String tourneyConditions="";
	private static String tourneySurface="";
	private static String tourneyFinCommit="";
	private static String tourneyUrlSuffix="";
	private static String tourneyId="";
	private static String currentTourneyUrlSuffix="";
	private static String tourneyRound="";
	private static String roundOrder="";
	private static String matchOrder="";
	private static String winnerName="";
	private static String winnerPlayerId="";
	private static String loserName="";
	private static String loserPlayerId="";
	private static String winnerSeed="";
	private static String loserSeed="";
	private static String matchScoreTiebreaks="";
	private static String matchStatsUrlSuffix="";
	private static String currentStatsUrlSuffix="";
	private static String matchDuration="";
	private static String winnerAces="";
	private static String winnerDoubleFaults="";
	private static String winner1stIn="";
	private static String winner1stServes="";
	private static String winner1stServePointsWon="";
	private static String winner1stServePointTotal="";
	private static String winner2ndServePointsWon="";
	private static String winner2ndservePointsTotal="";
	private static String winnerBreakPointsSaved="";
	private static String winnerBreakPointsServe="";
	private static String winnerServicePointsWon="";
	private static String winnerServicePointsTotal="";
	private static String winnerServiceGamesPlayed="";
	private static String winnerTotalPointsWon="";
	private static String loserAces="";
	private static String loserDoubleFaults="";
	private static String loser1stIn="";
	private static String loser1stServes="";
	private static String loser1stServePointsWon="";
	private static String loser1stServePointTotal="";
	private static String loser2ndServeOointsWon="";
	private static String loser2ndservePointsTotal="";
	private static String loserBreakPointsSaved="";
	private static String loserBreakPointsServe="";
	private static String loserServicePointsWon="";
	private static String loserServicePointsTotal="";
	private static String loserServiceGamesPlayed="";
	private static String loserTotalPointsWon="";
	private static String loser2ndServePointsTotal="";
	private static String loser2ndServePointsWon="";
	private static String plot="";
	private static String tourneyCity;
	private static String tourneyNation;

	public static void main(String[] args) throws IOException {
		
		
		row = new String[200];
		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt"), "UTF-8"));
		
		
		tournaments = Files.readAllLines(Paths.get("tournaments_1968-2019.csv"), Charset.forName("UTF-8"));
		System.out.println(tournaments.size());
		tournaments.removeIf(s -> s.length() == 0);
		System.out.println(tournaments.size());
		
		for (Iterator<String> iter = tournaments.iterator(); iter.hasNext();) 
		{
	    plot = iter.next();
		row = plot.split(",");
		System.out.println(plot);
	    //tourney_year 0
	    //tourney_order 1
	    tourneyName = row[2];
	    //tourney_id 3
	    //tourney_slug 4
	    tourneyCity = row[5];
	    tourneyNation = row[6];
	    tourneyDates = row[8];
	    //tourney_month 8
	    //tourney_day 9
	    tourneySinglesDraw = row[10];
	    //tourney_doubles_draw 11
	    tourneyConditions = row[12];
	    tourneySurface = row[13];
	    tourneyFinCommit = row[14];
	    
	    //////Link Field/////
	    tourneyUrlSuffix = row[15];
	    ////////////////////
	    
	    //singles_winner_name 16
	    //singles_winner_url 17
	    //singles_winner_player_slug 18
	    //singles_winner_player_id 19
	    //doubles_winner_1_name 20
	    //doubles_winner_1_url 21
	    //doubles_winner_1_player_slug 22
	    //doubles_winner_1_player_id 23
	    //doubles_winner_2_name 24
	    //doubles_winner_2_url 24
	    //doubles_winner_2_player_slug 26
	    //doubles_winner_2_player_id 27
	    tourneyId = row[28];
	    
	    
	    scores = Files.readAllLines(Paths.get("match_scores_1968-2019.csv"), Charset.forName("UTF-8"));
	    scores.removeIf(s -> s.length() == 0);
	    
	    for (Iterator<String> iter2 = scores.iterator(); iter2.hasNext();) 
	     {
	    	plot = iter2.next();
			row = plot.split(",");
			
			//tourney_year_id 0
			//tourney_order 1
			//tourney_slug 2
			currentTourneyUrlSuffix = row[3];
			
		//System.out.println(tourneyUrlSuffix   +"£");
		//System.out.println(currentTourneyUrlSuffix +"$");
		
	     if(currentTourneyUrlSuffix.equals(tourneyUrlSuffix))
	     {
	    	//System.out.println("Here we are");
			tourneyRound = row[4];
			roundOrder = row[5];
			matchOrder = row[6];
			winnerName = row[7];
			winnerPlayerId = row[8];
			//winner_slug 9
			loserName = row[10];
			loserPlayerId = row[11];
			//loser_slug 12
			winnerSeed = row[13];
			loserSeed = row[14];
			matchScoreTiebreaks = row[15];
			//winner_sets_won 16
			//loser_sets_won 17
			//winner_games_won 18
			//loser_games_won 19
			//winner_tiebreaks_won 20
			//loser_tiebreaks_won 21
              
	        ////////Link string//////////
			matchStatsUrlSuffix = row[22];
            ///////////////////////////
			
		    stats = Files.readAllLines(Paths.get("match_stats_1968-2019.csv"), Charset.forName("UTF-8"));
		    stats.removeIf(s -> s.length() == 0);
		    
		    for (Iterator<String> iter3 = stats.iterator(); iter3.hasNext();) 
		    {
		    	plot =iter3.next();
		    	row = plot.split(",");
		    	//tourney_order 0
		    	currentStatsUrlSuffix = row[1];
		    	
		     if(matchStatsUrlSuffix.equals(currentStatsUrlSuffix))
		     {
		    	//match_stats_url_suffix 2
		    	//matchTime 3
		    	matchDuration = row[4];
		    	
		    	//////Winner Stats/////
		    	winnerAces = row[5]; 
		    	winnerDoubleFaults = row[6];
		    	winner1stIn = row[7];
		    	winner1stServes = row[8];
		    	winner1stServePointsWon = row[9];
		    	winner1stServePointTotal = row[10];
		    	winner2ndServePointsWon = row[11];
		    	winner2ndservePointsTotal = row[12];
		    	winnerBreakPointsSaved = row[13];
		    	winnerBreakPointsServe = row[14];
		    	winnerServicePointsWon = row[15];
		    	winnerServicePointsTotal = row[16];
		    	//winner_first_serve_return_won 17
		    	//winner_first_serve_return_total 18
		    	//winner_second_serve_return_won 19
		    	//winner_second_serve_return_total 20
		    	//winner_break_points_converted 21
		    	//winner_break_points_return_total 22
		    	winnerServiceGamesPlayed = row[23];
		    	//winner_return_games_played 24
		    	//winner_return_points_won 25
		    	//winner_return_points_total 26
		    	winnerTotalPointsWon = row[27];
		    	//winner_total_points_total 28
		    	
		    	//////loser Stats/////
		    	loserAces = row[29]; 
		    	loserDoubleFaults = row[30];
		    	loser1stIn = row[31];
		    	loser1stServes = row[32];
		    	loser1stServePointsWon = row[33];
		    	loser1stServePointTotal = row[34];
		    	loser2ndServePointsWon = row[35];
		    	loser2ndServePointsTotal = row[36];
		    	loserBreakPointsSaved = row[37];
		    	loserBreakPointsServe = row[38];
		    	loserServicePointsWon = row[39];
		    	loserServicePointsTotal = row[40];
		    	//loser_first_serve_return_won 41
		    	//loser_first_serve_return_total 42
		    	//loser_second_serve_return_won 43
		    	//loser_second_serve_return_total 44
		    	//loser_break_points_converted 45
		    	//loser_break_points_return_total 46
		    	loserServiceGamesPlayed = row[47];
		    	//loser_return_games_played 48
		    	//loser_return_points_won 49
		    	//loser_return_points_total 50
		    	loserTotalPointsWon = row[51];
		    	//loser_total_points_total
		       }    	
	         }
		    
	    	w.write(
	    	    	tourneyId +","
	    	      + tourneyName +","
	    	      + tourneySurface +","
	    	      + tourneySinglesDraw +","
	    	      + " " +"," //tournament level
	    	      + tourneyDates +","
	    	      + "" +"," // matchNumber
	    	      + winnerPlayerId  +","
	    	      + winnerSeed  +","
	    	      + winnerSeed  +","
	    	      + winnerName  +","
	    	      +"" +"," //winner hand
	    	      +"" +"," //winner ht
	    	      +"" +"," // winner nat
	    	      +"" +"," // winner ranking
	    	      +"" +"," // winner ranking points
	    	      
	    	     
	    	      + loserPlayerId  +","
	    	      + loserSeed  +","
	    	      + loserSeed  +","
	    	      + loserName  +","
	    	      +"" +"," //loser hand
	    	      +"" +"," //loser ht
	    	      +"" +"," // loser nat
	    	      +"" +"," // loser ranking
	    	      +"" +"," // loser ranking points
	    	      
	    	      +matchScoreTiebreaks +","
	    	      +"" +"," //bestOf
	    	      +tourneyRound +"," 
	    	      +matchDuration +","
	    	      
	    	      
	    	      +winnerAces +","
	    	      +winnerDoubleFaults +","
	    	      +winnerServicePointsTotal +","
	    	      +winner1stIn +","
	    	      +winner1stServePointsWon +","
	    	      +winner2ndServePointsWon +","
	    	      +winnerServiceGamesPlayed +","
	    	      +winnerBreakPointsSaved +","
	    	      +winnerBreakPointsServe +","
	    	      
	    	      
	    	      +loserAces +","
	    	      +loserDoubleFaults +","
	    	      +loserServicePointsTotal +","
	    	      +loser1stIn +","
	    	      +loser1stServePointsWon +","
	    	      +loser2ndServePointsWon +","
	    	      +loserServiceGamesPlayed +","
	    	      +loserBreakPointsSaved +","
	    	      +loserBreakPointsServe +","
	    	      +"\n"
	    	    	);    
	    	w.flush();
		     }
	     
	       }
		
        }
     }
	
}
