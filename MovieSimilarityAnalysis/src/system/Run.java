package system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Driver for the parsing of the text files from GroupLens.
 * 
 * @author Stuart Maynard
 *
 */

public class Run {

	String userIN;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Data parse = new Data();
		parse.scanData();
		parse.scanItem();
		parse.scanUser();
		
		Run in = new Run();
		in.userInput();
	}
	
	public void userInput(){
		Scanner scan = new Scanner(System.in);
		userIN = scan.next();
		System.out.println(userIN);
	}
}
