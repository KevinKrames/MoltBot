import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;
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
public class Bot {
	//Instantiate variables
	public TwitchListener twitchListener = null;
	public PircBotX twitchBot = null;
	public ArrayList<Message> messages = new ArrayList<Message>();
	private Timer timer = new Timer(true);
	
	//Bot constructor
	public Bot() {
		BotTT timerTask = new BotTT(this);
		timer.schedule(timerTask, 0, 500);
	}


	//Main function that updates at the given timer task rate
	public void update() {
		//We have some messages to parse:
		if (messages.size() > 0) {
			for (int i = 0; i < messages.size(); i++) {
				ArrayList<String> temp = BotUtilities.readFile("files/log.txt");
				temp.add(messages.get(i).message);
				BotUtilities.writeFile(temp, "files/log.txt");
			}
			messages.clear();
		}
	}
}