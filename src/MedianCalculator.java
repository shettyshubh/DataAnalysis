import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MedianCalculator {

	public static void main(String[] args) {

		if (args[0]==null){
		System.out.println("Enter the Parent Path where tweet_input directory is present");
		System.exit(0);
	}
		int gCounter = 0;

		// Counter for all the unique words in each tweet
		ArrayList<Integer> uniqueCount = new ArrayList<Integer>();

		// Reading tweets from file
		try (BufferedReader br = new BufferedReader(new FileReader(
				args[0]+"/tweet_input/tweets.txt"))) {
			String sCurrentLine;
			PrintWriter writer = new PrintWriter(args[0]+"/tweet_output/ft2.txt", "UTF-8");

			while ((sCurrentLine = br.readLine()) != null) {
				int ucount = 0;

				// Splitting line by space
				String[] clSplit = sCurrentLine.split("\\s+");
				HashMap<String, Integer> innerMap = new HashMap<String, Integer>();

				// Constructing a wordMap
				for (int i = 0; i < clSplit.length; i++) {
					String word = clSplit[i];
					if (innerMap.get(word) != null)
						innerMap.put(word, (innerMap.get(word) + 1));
					else
						innerMap.put(word, 1);
				}

				// Counting unique words in a tweet
				for (String s : innerMap.keySet()) {
					if (innerMap.get(s) == 1)
						ucount++;
				}
				uniqueCount.add(ucount);
				gCounter++;

				// Sorting the list for median calculation
				Collections.sort(uniqueCount);

				// Printing the median values
				

				if (gCounter % 2 != 0) {
					writer.println(uniqueCount.get(gCounter / 2));
				} else {
					writer.println((uniqueCount.get(gCounter / 2) + uniqueCount
									.get((gCounter / 2) - 1)) / 2.0);
				}

			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
