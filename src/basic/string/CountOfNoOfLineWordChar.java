package basic.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOfNoOfLineWordChar {

	public static void main(String args[]) throws IOException {
		BufferedReader br=null;
		try {
			FileReader fr = new FileReader("");
			br = new BufferedReader(fr);
			int countLine = 0, countWord = 0, countChar = 0;
			String line;
			line = br.readLine();
			while (line != null) {
				countLine++;
				String[] words = line.split(" ");
				countWord = countWord + words.length;
				for (String word : words) {
					countChar = countChar + word.length();
				}
				line = br.readLine();
			}
			System.out.println("countLine " + countLine + " countWord " + countWord + " countChar " + countChar);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			br.close();
		}

	}
}
