
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LanguageWindow {
	private JFrame lang;
    private ColorRushMain open;
    private JPanel engPanel, arbPanel, radioPanel, emptyPanel1, emptyPanel2; 
    private JLabel engLabel, arbLabel;
    private JRadioButton eng, arb;
    private final int w = 300, h = 200;
    
    public LanguageWindow() {
        lang = new JFrame();
        lang.setTitle("Color Rush");
        lang.setSize(w, h);
        engPanel = new JPanel();
        arbPanel = new JPanel();
        radioPanel = new JPanel();
        emptyPanel1 = new JPanel();
        emptyPanel2 = new JPanel();
        
        //labels settings
        engLabel = new JLabel("choose language");
        engLabel.setForeground(Color.BLUE);
        arbLabel= new JLabel("اختر لغة");
        arbLabel.setForeground(Color.BLUE);
        engLabel.setFont(new Font("SansSerif", Font.BOLD, 15));//change text size
        arbLabel.setFont(new Font("SansSerif", Font.BOLD, 15));//change text size
        //radio buttons settings
        eng = new JRadioButton("English");
        arb = new JRadioButton("العربية");
        ButtonGroup group = new ButtonGroup();
        group.add(eng);
        group.add(arb);
        //add actions  
        eng.addItemListener(new Action());
        arb.addItemListener(new Action());
            
        lang.setLayout(new GridLayout(5, 1));
        engPanel.add(engLabel);
        arbPanel.add(arbLabel);
        radioPanel.add(eng);
        radioPanel.add(arb);
        
        lang.add(emptyPanel1);
        lang.add(engPanel);
        lang.add(arbPanel);
        lang.add(radioPanel);
        lang.add(emptyPanel2);
        
        lang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        lang.setLocationRelativeTo(null);
        lang.setVisible(true);
    }

    public void setMain(ColorRushMain open) { 
        this.open = open;
    }
    //check witch language is selected
    public class Action implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (eng.isSelected()) {
                lang.dispose();//close window
                open.openStartWindow(); //open English StartWindow
            }
            if (arb.isSelected()) {
                lang.dispose();//close window
                open.openStartWindowArabic(); //open Arabic StartWindow
            }
        }
    }
}