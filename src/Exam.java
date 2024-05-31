import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exam extends  JFrame {
    private JPanel mainJPanle;
    private JTextField nameTxt;
    private JTextField idTxt;
    private JTextArea showTxt;
    private JButton submitBtn;

    public Exam() {
        setContentPane(mainJPanle);
        setTitle("Exam");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTxt.setText(nameTxt.getText());
                JOptionPane.showMessageDialog(null, nameTxt.getText());
            }
        });
    }

    public static void main(String[] args) {
        new Exam();
    }
}
