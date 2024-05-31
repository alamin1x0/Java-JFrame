package ui.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton submitButton;
    private JButton resetButton;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JTextArea displayArea;
    private JPanel mainPanel;

    public Info() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        phoneLabel = new JLabel("Phone:");
        nameField = new JTextField(15);
        emailField = new JTextField(15);
        phoneField = new JTextField(15);
        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false);
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(submitButton, gbc);
        gbc.gridx = 1;
        mainPanel.add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(new JScrollPane(displayArea), gbc);

        setContentPane(mainPanel);
        setTitle("Information");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String info = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;
                    displayArea.setText(info);
                    JOptionPane.showMessageDialog(null, info);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                displayArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Info();
            }
        });
    }
}
