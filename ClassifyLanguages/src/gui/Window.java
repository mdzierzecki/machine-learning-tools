package gui;

import Program.Compute;
import models.Vector;

import java.awt.*;
import javax.swing.*;

public class Window {

    private JFrame frame;
    private JTextField textField;
    private Compute compute;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Window window = new Window();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public Window() {
        initialize();

        compute = new Compute();
        compute.train();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSepalLength = new JLabel("Text");
        lblSepalLength.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblSepalLength);


        textField = new JTextField();
        textField.setBounds(128, 28, 200, 100);
        frame.getContentPane().add(textField);
        textField.setColumns(100);




        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);

        btnSubmit.addActionListener(arg0 -> {
            String text = textField.getText();

            Vector vc = new Vector(text, true);
            String result;

            result = compute.checkRecord(vc);

            JOptionPane.showMessageDialog(null, "Language: " + result);
        });

        btnClear.addActionListener(e -> textField.setText(null));

    }
}