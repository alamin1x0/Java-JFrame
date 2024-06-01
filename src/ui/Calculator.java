package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[14];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JButton sinButton, cosButton, tanButton;
    private JPanel panel;

    private Font myFont = new Font("SansSerif", Font.BOLD, 18);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        textField = new JTextField();
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addButton = createButton("+");
        subButton = createButton("-");
        mulButton = createButton("*");
        divButton = createButton("/");
        decButton = createButton(".");
        equButton = createButton("=");
        delButton = createButton("Del");
        clrButton = createButton("Clr");
        sinButton = createButton("sin");
        cosButton = createButton("cos");
        tanButton = createButton("tan");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sinButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = tanButton;

        for (int i = 0; i < 11; i++) {
            functionButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Row 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.2;
        panel.add(textField, gbc);

        gbc.gridwidth = 1;
        gbc.weighty = 0.2;

        // Add buttons to panel with GridBagConstraints
        addButtonToPanel(panel, gbc, 1, 1, numberButtons[1]);
        addButtonToPanel(panel, gbc, 1, 2, numberButtons[2]);
        addButtonToPanel(panel, gbc, 1, 3, numberButtons[3]);
        addButtonToPanel(panel, gbc, 1, 4, addButton);

        addButtonToPanel(panel, gbc, 2, 1, numberButtons[4]);
        addButtonToPanel(panel, gbc, 2, 2, numberButtons[5]);
        addButtonToPanel(panel, gbc, 2, 3, numberButtons[6]);
        addButtonToPanel(panel, gbc, 2, 4, subButton);

        addButtonToPanel(panel, gbc, 3, 1, numberButtons[7]);
        addButtonToPanel(panel, gbc, 3, 2, numberButtons[8]);
        addButtonToPanel(panel, gbc, 3, 3, numberButtons[9]);
        addButtonToPanel(panel, gbc, 3, 4, mulButton);

        addButtonToPanel(panel, gbc, 4, 1, decButton);
        addButtonToPanel(panel, gbc, 4, 2, numberButtons[0]);
        addButtonToPanel(panel, gbc, 4, 3, equButton);
        addButtonToPanel(panel, gbc, 4, 4, divButton);

        addButtonToPanel(panel, gbc, 5, 1, sinButton);
        addButtonToPanel(panel, gbc, 5, 2, cosButton);
        addButtonToPanel(panel, gbc, 5, 3, tanButton);
        addButtonToPanel(panel, gbc, 5, 4, clrButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        panel.add(delButton, gbc);

        add(panel);

        delButton.addActionListener(this);
        clrButton.addActionListener(this);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(myFont);
        button.setFocusPainted(false);
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setForeground(Color.BLACK);
        return button;
    }

    private void addButtonToPanel(JPanel panel, GridBagConstraints gbc, int row, int col, JButton button) {
        gbc.gridx = col - 1;
        gbc.gridy = row;
        panel.add(button, gbc);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
        }
    }
}
