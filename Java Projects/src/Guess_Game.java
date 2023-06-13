import java.awt.Component;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Guess_Game {
	private static final Component frame = null;
	private static Scanner scan;
	public static void main(String []args) {
		scan = new Scanner(System.in);
		
//		Object to generate random numbers for computer
		Random rand = new Random();
//		Initial scores for each wins and loses of each players
		int tSl = 0;
		int tSw = 0;
		int oSl = 0;
		int oSw = 0;
		int tSSw = 0;
		int tSSl = 0;
		
//		Welcome Dialog Message
		String gg = "Welcome to Guess Game (:";
		Object [] wlc = {"Start"};
		JOptionPane.showOptionDialog(frame, ""+gg, "Guess Game Result Page", JOptionPane.YES_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, wlc, wlc[0]);
		String stp = "You will be asked to guess a number "
				+ "that this computer is presently thinking about which ranges "
				+ "from 1-10. \nAlso, you are allowed to play "
				+ "this game alone or with an opponent where you can take a custom number of turns.";
		JOptionPane.showMessageDialog(null ,"" +stp, "Guess Game" ,JOptionPane.PLAIN_MESSAGE);
		
//		Yes/No option to select the play mode(Team/Single player mode)
		String playmode = "Select gameplay mode";
		Object [] options = {"Custom players" ,"2 Players", "1 player"};
		int playoption = JOptionPane.showOptionDialog(frame, playmode, "Guess Game", JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		
//		Two player mode
		if (playoption == JOptionPane.NO_OPTION ) {
			
//			Collect input for the number of turns for two player mode
			String turnss = JOptionPane.showInputDialog("Input the number of rounds for each player");
			int one = Integer.parseInt(turnss);
			int playturns = one * 2;
			JOptionPane.showMessageDialog(null,"You have total of "+ playturns+" rounds to play.");
			JOptionPane.showMessageDialog(null,"Game setup has been successfully initialized.\n"
					+"Click ok to continue.");
			
//			Collect input of player's names
			String pOne = JOptionPane.showInputDialog("Type your name below.\nPlayer one");
			String pTwo = JOptionPane.showInputDialog("Type your name below.\nPlayer two");
			JOptionPane.showMessageDialog(null,"Names have been successfully saved.\nYou can now proceed to start game.");
			
//			Game Launches from here
			for (int loop = 1; loop<= playturns; loop++) {
				String gn = loop % 2 != 1 ? ""+pTwo : ""+pOne;
				String guessNum = JOptionPane.showInputDialog(frame, "Round " +loop + "\n"
						+ "" +gn+ ", guess a number between 1-10.", "Input number" ,JOptionPane.QUESTION_MESSAGE);
				int guessNums = Integer.parseInt(guessNum);
				
//				Computer random number generator
				int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
				int arr = rand.nextInt(10);
				int builtNum = array[arr];
				
//				Guess Game control flow for two players
				if (guessNums == builtNum ) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "You correctly guessed the number so you won this round.");
					int n = loop % 2 != 1 ? oSw++ : tSw++;
					}
				else if(guessNums > builtNum) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "Your guess number("+guessNum+") is greater than the computer number.\n"
							+ "You lost this round, try again!");
					int n = loop % 2 != 1 ? oSl++ : tSl++;
					}
				else if(guessNums < builtNum) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "Your guess number("+guessNum+") is less than the computer number.\n"
							+ "You lost this round, try again!");
					int n = loop % 2 != 1 ? oSl++ : tSl++;
					}
				else {
					System.out.println("You inputted an invalid code, input a number between 1-10.");
					}
				}
				Object [] optionss = {"Show result"};
				JOptionPane.showOptionDialog(frame,"You have completed the whole "+playturns+" rounds!","Game Over", 
						JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null ,optionss, optionss[0]);
				String twoplyrs_res = ""+pOne+" has "+tSw+" wins and "+tSl+" loses.\n"
						+""+pTwo+" has "+oSw+" wins and "+oSl+" loses.";
				Object [] opts = {"End game"};
				JOptionPane.showOptionDialog(frame, ""+twoplyrs_res, "Guess Game Result Page", JOptionPane.YES_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
				
			}
		else if(playoption == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null,"Welcome to custom play mode");
		}
		
//		One Player mode
		else {
			
//			Collect input for the number of rounds for single player mode
			String turnssing = JOptionPane.showInputDialog("Input the numbers of rounds you want to play");
			int onesing = Integer.parseInt(turnssing);
			JOptionPane.showMessageDialog(null,"You have total of "+ onesing +" rounds to play.");
			JOptionPane.showMessageDialog(null,"Game setup has been successfully initialized.\n"
					+"Click ok to continue.");
			
//			Collect input of player's names
			String sOne = JOptionPane.showInputDialog("Type your name below.\nPlayer one");
			JOptionPane.showMessageDialog(null,"Name have been successfully saved.\nYou can now proceed to start game.");
			
//			Game Launches from here
			for (int loop = 1; loop <= onesing; loop++) {
				String guessNumsin = JOptionPane.showInputDialog(frame, "Round " +loop + "\n"
						+ "" +sOne+ ", guess a number between 1-10.", "Input number" ,JOptionPane.QUESTION_MESSAGE);
				int singNums = Integer.parseInt(guessNumsin);
				
//				Computer random number generator
				int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
				int arr = rand.nextInt(10);
				int builtNum = array[arr];
				
//				Guess Game control flow for one one player
				if (singNums == builtNum ) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "You correctly guessed the number so you won this round.");
					int n = tSSw++;
					}
				else if(singNums > builtNum) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "Your guess number("+singNums+") is greater than the computer number.\n"
							+ "You lost this round, try again!");
					int n = tSSl++;
					}
				else if(singNums < builtNum) {
					JOptionPane.showMessageDialog(null, "Computer number: "+ builtNum+"\n"
							+ "Your guess number("+singNums+") is less than the computer number.\n"
							+ "You lost this round, try again!");
					int n = tSSl++;
					}
				else {
					System.out.println("You inputted an invalid code, input a number between 1-10.");
					}
				}
				Object [] optionss = {"Show result"};
				JOptionPane.showOptionDialog(frame,"You have completed the whole "+onesing+" rounds!","Game Over", 
						JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null ,optionss, optionss[0]);
				String oneplyrs_res = ""+sOne+" has "+tSSw+" wins and "+tSSl+" loses" ;
				Object [] opts = {"End game"};
				JOptionPane.showOptionDialog(frame, ""+oneplyrs_res, "Guess Game Result Page", JOptionPane.YES_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, opts, opts[0] );
				
			}
			
		}
}
