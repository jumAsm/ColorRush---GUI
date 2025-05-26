
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWindowArabic {
	private JFrame game;
    private ColorRushMain open;
    private int score;
    private int round;
    private JPanel panel1, panel2, panel3, panel4;
    private JLabel Label1, Label2;
    private JTextField scoreField;
    private JButton gameButton, correctButton;
    private final int w = 300, h = 200;
    
    public GameWindowArabic() {
       game = new JFrame();
       game.setSize(w, h);
       
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       panel4 = new JPanel();
       
       Label1 = new JLabel(":نقاطك ");
       scoreField = new JTextField(2);
       scoreField.setBorder(null);
       scoreField.setEditable(false);
       
       Label2 = new JLabel();
       Label2.setFont(new Font("SansSerif", Font.BOLD, 20));
       gameButton = new JButton(""); 
       correctButton = new JButton(""); 
       gameButton.setPreferredSize(new Dimension(40, 30));
       correctButton.setPreferredSize(new Dimension(40, 30));
       gameButton.addActionListener(new GameButtonListener());
       correctButton.addActionListener(new GameButtonListener());


       game.setLayout(new GridLayout(4, 1));
       panel1.add(Label1);
       panel1.add(scoreField);
       panel2.add(Label2);
       panel3.add(gameButton);
       panel3.add(correctButton);
       game.add(panel1);
       game.add(panel2);
       game.add(panel3);
       game.add(panel4);
       game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       game.setLocationRelativeTo(null);
       game.setVisible(true); 
    }

    public void setMain(ColorRushMain open) { 
        this.open = open;
    }

    public void setRound(int round) {
        this.round = round;
        game.setTitle("Color Rush-Round " + round);
        setupRound(round);
    }

    public void setScore(int score){
        this.score = score;
        scoreField.setText(Integer.toString(score));
    }

    private void setupRound(int round) {
        switch (round) {
            case 1:
                Label2.setText("أزرق");
                Label2.setForeground(Color.CYAN);
                gameButton.setBackground(Color.BLUE);
                correctButton.setBackground(Color.CYAN);
                break;
            case 2:
                Label2.setText("أحمر");
                Label2.setForeground(Color.MAGENTA);
                gameButton.setBackground(Color.RED);
                correctButton.setBackground(Color.MAGENTA);
                break;
            case 3:
                Label2.setText("وردي");
                Label2.setForeground(Color.PINK);
                gameButton.setBackground(Color.ORANGE);
                correctButton.setBackground(Color.PINK);
                break;
            case 4:
                Label2.setText("أخضر");
                Label2.setForeground(Color.CYAN);
                gameButton.setBackground(Color.GREEN);
                correctButton.setBackground(Color.CYAN);
                break;
            case 5:
                Label2.setText("برتقالي");
                Label2.setForeground(Color.YELLOW);
                gameButton.setBackground(Color.ORANGE);
                correctButton.setBackground(Color.YELLOW);
                break;
        }
        
        //randomly add buttons in different places
        panel3.removeAll();//clear previous buttons (from old round)
        Random rand = new Random();
        if (rand.nextBoolean()){
            panel3.add(correctButton);
            panel3.add(gameButton);
        } else {
            panel3.add(gameButton);
            panel3.add(correctButton);
        }
    }
    //buttons actions
    private class GameButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == correctButton) {//check if the correct button was clicked
                score++;//count score if correct
            }
            scoreField.setText(Integer.toString(score));//display score
            open.updateScore(score); //update score in ColorRushMain
            game.dispose();//close current round window
            if (round < 5){
                open.openGameWindowArabic(round + 1);//open the next round
            } else{
                open.openResultWindow(score);//show result window after round 5
            }
        }
    }
}
