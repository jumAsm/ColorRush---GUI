
import javax.swing.*;
import java.awt.*;

public class ResultWindow{
    private JFrame resultFrame;
    private JPanel panel1, panel2, panel3, panel4;
    private JLabel desLabel1, desLabel2, background;
    private int result = 0;
    private final int w = 367, h = 245;

    public ResultWindow() {
       resultFrame = new JFrame();
       resultFrame.setTitle("Color Rush");
       resultFrame.setSize(w, h);
       panel1 = new JPanel();
       panel1.setOpaque(false);
       panel2 = new JPanel();
       panel2.setOpaque(false);
       panel3 = new JPanel();
       panel3.setOpaque(false);
       panel4 = new JPanel();
       panel4.setOpaque(false);
       desLabel1 = new JLabel();
       desLabel2 = new JLabel();
       
       ImageIcon originalImageIcon = new ImageIcon("C:\\Users\\joman\\Pictures\\h.png");//image path
       Image resizedImage = originalImageIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);//resize the image
       background = new JLabel(new ImageIcon(resizedImage));//set resized image as background
       resultFrame.setContentPane(background);//set background image as the main content panel of the frame
       
       resultFrame.setLayout(new GridLayout(4, 1));
    
       resultFrame.add(panel1);
       resultFrame.add(panel2);
       resultFrame.add(panel3);
       resultFrame.add(panel4);
       resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       resultFrame.setLocationRelativeTo(null);
       resultFrame.setVisible(true);
    }
    
    //display score
    public void setScore(int score, boolean isArabic, String playerName){
        result = score;
        if (isArabic) {//Arabic messages
            if (result == 5) {//when score = 5
                desLabel1 = new JLabel("مبروك! " + playerName + " لقد أتقنت هذه اللعبة");
                desLabel1.setForeground(Color.MAGENTA); 
                } else if (result > 2) {//when score more than 2
                desLabel1 = new JLabel("عمل جيد جداً، " + playerName + "!");
                desLabel1.setForeground(Color.MAGENTA); 
            } else {
                desLabel1 = new JLabel("حاول مرة أخرى، " + playerName + "!");
                desLabel1.setForeground(Color.BLUE);
            }
            desLabel2 = new JLabel("نقاطك هي: " + result);
            desLabel1.setFont(new Font("SansSerif", Font.BOLD, 20));
        } else {//English messages
            if (result == 5) {
                desLabel1 = new JLabel("Congrats! " + playerName + " you nailed this game");
                desLabel1.setForeground(Color.MAGENTA);
            } else if (result > 2) {
                desLabel1 = new JLabel("Very good job, " + playerName + "!");
                desLabel1.setForeground(Color.MAGENTA);
            } else {
                desLabel1 = new JLabel("Try harder next time, " + playerName + "!");
                desLabel1.setForeground(Color.BLUE);
            }
            desLabel2 = new JLabel("Your score is: " + result);
            desLabel1.setFont(new Font("SansSerif", Font.BOLD, 20));
        }
        //add score messages to panels
        panel2.add(desLabel1);
        panel3.add(desLabel2);
       
    }
}
