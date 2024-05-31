import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel jPanel;
    private JTextField nameText;
    private JButton submitBtn;
    private JTextField emailTxt;
    private JTextArea testId;


    public Main() {
        setContentPane(jPanel);
        setTitle("Information");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testId.setText(nameText.getText());
                JOptionPane.showMessageDialog(null, nameText.getText() + "\n" + emailTxt.getText());

            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
