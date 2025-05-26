

	import java.io.*;

	public class ColorRushMain {
	    //object for each class
	    private LanguageWindow languageWindow;
	    private StartWindow startWindow;
	    private StartWindowArabic startWindowArabic;
	    private GameWindow gameWindow;
	    private GameWindowArabic gameWindowArabic;
	    private ResultWindow resultWindow;
	    private int score = 0;
	    private boolean isArabic;
	    private String playerName;
	    private final String highScoreFile = "highscore.txt"; // File name for high score

	    public ColorRushMain() {
	        createHighScoreFile(); //ensure high score file exists
	        openLanguageWindow(); //display the first window
	    }

	    public void openLanguageWindow() {
	        languageWindow = new LanguageWindow();
	        languageWindow.setMain(this); //pass a reference of the main to the class
	    }

	    public void openStartWindow() {
	        startWindow = new StartWindow();
	        isArabic = false; //game language is English
	        startWindow.setMain(this); //pass a reference of the main to the class
	        startWindow.setHighScore(readHighScore()); //pass the high score to StartWindow
	    }

	    public void openStartWindowArabic() {
	        startWindowArabic = new StartWindowArabic();
	        isArabic = true; //game language is Arabic
	        startWindowArabic.setMain(this);
	        startWindowArabic.setHighScore(readHighScore());
	    }

	    public void openGameWindow(int round) {
	        gameWindow = new GameWindow();
	        gameWindow.setRound(round); //set current round number for game window
	        gameWindow.setScore(score); //set current score for game window
	        gameWindow.setMain(this); //pass a reference of the main to the class
	    }

	    public void openGameWindowArabic(int round) {
	        gameWindowArabic = new GameWindowArabic();
	        gameWindowArabic.setRound(round);
	        gameWindowArabic.setScore(score);
	        gameWindowArabic.setMain(this);
	    }

	    public void openResultWindow(int finalScore) {
	        resultWindow = new ResultWindow();
	        resultWindow.setScore(finalScore, isArabic, playerName); //pass score, language and name
	        updateHighScore(finalScore); //check and update high score if needed
	    }

	    public void updateScore(int newScore) {
	        this.score = newScore;
	    }

	    public void setPlayerName(String name) {
	        this.playerName = name;
	    }

	    public static void main(String[] args) {
	        new ColorRushMain();
	    }

	    //file methods
	    private void createHighScoreFile() {
	        try {
	            File file = new File(highScoreFile);
	            if (!file.exists()) {
	              PrintWriter writer = new PrintWriter(file);
	                writer.println(0); //default high score is 0
	                writer.close();
	            }
	        } catch (IOException e) {
	            System.err.println("Error creating high score file: " + e.getMessage());
	        }
	    }

	    private int readHighScore() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(highScoreFile))) {
	            return Integer.parseInt(reader.readLine());
	        } catch (IOException | NumberFormatException e) {
	            System.err.println("Error reading high score: " + e.getMessage());
	            return 0;
	        }
	    }

	    private void updateHighScore(int newScore) {
	        int currentHighScore = readHighScore();
	        if (newScore > currentHighScore) {
	            try (PrintWriter writer = new PrintWriter(new FileWriter(highScoreFile))) {
	                writer.println(newScore);
	            } catch (IOException e) {
	                System.err.println("Error updating high score: " + e.getMessage());
	            }
	        }
	    }
	}


