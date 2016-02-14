package system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * This class allows for the parsing of the text files from GroupLens splitting each one 
 * into useful array lists each containing different information regarding data, items and
 * users. Once split up the data can be compared to other pieces of data acquired from
 * other text files, or pulled from The Online Movie Database. 
 * 
 * @author Stuart Maynard
 *
 */

public class Data {
	
	File u_data = new File("C:/Users/Stuart Maynard/University/4th Year/CS408 - Individual Project/Datasets/ml-100k/u.data");
	File u_item = new File("C:/Users/Stuart Maynard/University/4th Year/CS408 - Individual Project/Datasets/ml-100k/u.item");
	File u_user = new File("C:/Users/Stuart Maynard/University/4th Year/CS408 - Individual Project/Datasets/ml-100k/u.user");
	
	ArrayList<ArrayList<String>> movie_data = new ArrayList<>();
	ArrayList<ArrayList<String>> movie_genre = new ArrayList<>();
	ArrayList<ArrayList<String>> users = new ArrayList<>();
	
	public void scanData() throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(u_data))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] chop = new String[4];
				ArrayList<String> data_element = new ArrayList<>();
				chop = line.split("[\\t]");
				for(String val : chop) {
					data_element.add(val);
				}
				movie_data.add(data_element);
			}
		}
	}
	
	public void scanItem() throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(u_item))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] chop = new String[24];
				ArrayList<String> movie_element = new ArrayList<>();
				chop = line.split("[\\|]");
				for(String val : chop) {
					movie_element.add(val);
				}
				movie_genre.add(movie_element);
			}
		}
	}
	
	public void scanUser() throws FileNotFoundException, IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(u_user))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] chop = new String[5];
				ArrayList<String> user_element = new ArrayList<>();
				chop = line.split("[\\|]");
				for(String val : chop) {
					user_element.add(val);
				}
				users.add(user_element);
			}
		}
	}
}
