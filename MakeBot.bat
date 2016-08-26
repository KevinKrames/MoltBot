ECHO ON
dir c:\Users\Kevin\Desktop\MoltBot\Sneewo
javac -classpath jars/*;. *.java
java -Xms64m -Xmx512m -classpath jars/*;. BotMain
cmd /K