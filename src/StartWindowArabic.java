

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindowArabic {
    private JFrame start;
    private ColorRushMain open;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    private JLabel Label1, Label2, Label3, Label4, pnameLabel, highScoreLabel, background;
    private JTextField playerName;
    private JButton startButton;
    private final int w = 345, h = 250;

    public StartWindowArabic() {
        start = new JFrame();
        start.setTitle("Color Rush");
        start.setSize(w, h);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLocationRelativeTo(null);

        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\joman\\Pictures\\start.jpg");//image path
        Image resizedImage = ImageIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        background = new JLabel(new ImageIcon(resizedImage));
        start.setContentPane(background);

        
        Label1 = new JLabel("أهلاً وسهلاً");
        Label1.setForeground(Color.BLUE);
        Label1.setFont(new Font("SansSerif", Font.BOLD, 20));
        Label2 = new JLabel("اختر اللون");
        Label3 = new JLabel("وليس");
        Label3.setForeground(Color.RED);
        Label4 = new JLabel("الكلمة");

        pnameLabel = new JLabel(":اسم اللاعب");
        playerName = new JTextField(10);

        // إعداد حقل عرض أعلى النتيجة
        highScoreLabel = new JLabel();
        highScoreLabel.setForeground(Color.MAGENTA);
        highScoreLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        startButton = new JButton("ابدأ");
        startButton.setBackground(Color.GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(new Action());

        start.setLayout(new GridLayout(7, 1));

        panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.add(Label1);

        panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.add(Label4);
        panel3.add(Label3);
        panel3.add(Label2);

        panel4 = new JPanel();
        panel4.setOpaque(false);
        panel4.add(pnameLabel);
        panel4.add(playerName);

        panel5 = new JPanel();
        panel5.setOpaque(false);
        panel5.add(startButton);

        panel6 = new JPanel();
        panel6.setOpaque(false);
        panel6.add(highScoreLabel);
        
        panel1 = new JPanel();
        panel1.setOpaque(false);
        panel7 = new JPanel();
        panel7.setOpaque(false);

        background.setLayout(new GridLayout(7, 1));
        background.add(panel1); 
        background.add(panel2);
        background.add(panel3);
        background.add(panel4);
        background.add(panel5);
        background.add(panel6);
        background.add(panel7);
        
        start.setVisible(true);
    }

    public void setMain(ColorRushMain open) {
        this.open = open;
    }

    public void setHighScore(int highScore) {
        highScoreLabel.setText("أعلى النقاط: " + highScore);
    }

    public class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (playerName.getText().equals("")) {
                    throw new IllegalArgumentException("لم يتم إدخال اسم");
                }
                open.setPlayerName(playerName.getText());
                start.dispose();
                open.openGameWindowArabic(1);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "يرجى إدخال اسم اللاعب.");
            }
        }
    }
}
