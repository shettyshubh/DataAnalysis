import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class WordCounter {

	public static void main(String[] args) {

		if (args[0]==null){
			System.out.println("Enter the Parent Path where tweet_input directory is present");
			System.exit(0);
		}
		
		// Global TreeMap for wordcount and on the fly sorting
		TreeMap<String, Integer> globalMap = new TreeMap<String, Integer>();

	
		// Reading tweets from the file
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]+
				"/tweet_input/tweets.txt"))) {
			String sCurrentLine;

			//Writing the output to file
			PrintWriter writer = new PrintWriter(args[0]+"/tweet_output/ft1.txt", "UTF-8");

			while ((sCurrentLine = br.readLine()) != null) {
				String[] clSplit = sCurrentLine.split("\\s+");

				// Constructing wordMap
				for (int i = 0; i < clSplit.length; i++) {
					String word = clSplit[i];
					if (globalMap.get(word) != null)
						globalMap.put(word, (globalMap.get(word) + 1));
					else
						globalMap.put(word, 1);
				}
			}

			// Writing the WordMap
			for (String s : globalMap.keySet()) {
				writer.println(s + "\t\t\t" + globalMap.get(s));
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
