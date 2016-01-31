package system;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Data parse = new Data();
		parse.scanData();
		parse.scanItem();
		parse.scanUser();
	}
}
