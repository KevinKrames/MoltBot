ECHO ON
dir %~dp0
javac -classpath jars/*;. *.java
java -Xms64m -Xmx512m -classpath jars/*;. BotMain
cmd /K