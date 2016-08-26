import java.util.Timer;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//Static class for global functions to be referenced throughout the project
public class BotUtilities {
	//Function to read a file from the working program directory, returns an ArrayList
	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> newString = new ArrayList<String>();
		int counter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + fileName)))
			{
 
				String sCurrentLine;
 
				while ((sCurrentLine = br.readLine()) != null) {
					//System.out.println(sCurrentLine);
					newString.add(counter, sCurrentLine);
					counter++;
					}
 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	
		return newString;
	} // end of read file

	//Function to write a text file of an ArrayList of a string to a file on each new line
	public static void writeFile(ArrayList<String> s, String fileName) {
	String input = "";
	for (int i=0; i < s.size(); i++) {
		input = input + s.get(i) + System.getProperty("line.separator");
		}
	
		try {
			File file = new File(System.getProperty("user.dir") + "/" + fileName);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(input);
			output.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}// end of writefile

}