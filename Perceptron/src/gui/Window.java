package gui;

import neurons.Compute;
import program.Record;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Window {

    private JFrame frame;
    private JTextField sepalLengthField;
    private JTextField sepalWidthField;
    private JTextField petalLengthField;
    private JTextField petalWidthField;
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

        try {
            compute = new Compute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSepalLength = new JLabel("Sepal length");
        lblSepalLength.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblSepalLength);


        sepalLengthField = new JTextField();
        sepalLengthField.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(sepalLengthField);
        sepalLengthField.setColumns(10);


        JLabel lblSepalWidth = new JLabel("Sepal Width");
        lblSepalWidth.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(lblSepalWidth);

        sepalWidthField = new JTextField();
        sepalWidthField.setBounds(128, 65, 86, 20);
        frame.getContentPane().add(sepalWidthField);
        sepalWidthField.setColumns(10);

        JLabel lblPetalLength = new JLabel("Petal length");
        lblPetalLength.setBounds(65, 115, 46, 14);
        frame.getContentPane().add(lblPetalLength);

        petalLengthField = new JTextField();
        petalLengthField.setBounds(128, 112, 247, 17);
        frame.getContentPane().add(petalLengthField);
        petalLengthField.setColumns(10);

        JLabel lblPetalWidth = new JLabel("Petal width");
        lblPetalWidth.setBounds(65, 200, 50, 14);
        frame.getContentPane().add(lblPetalWidth);

        petalWidthField = new JTextField();
        petalWidthField.setBounds(128, 150, 247, 17);
        frame.getContentPane().add(petalWidthField);
        petalWidthField.setColumns(10);

        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double sepalLength = Double.parseDouble(sepalLengthField.getText());
                double sepalWidth = Double.parseDouble(sepalWidthField.getText());
                double petalLength = Double.parseDouble(petalLengthField.getText());
                double petalWidth = Double.parseDouble(petalWidthField.getText());
                Record testRecord = new Record(sepalLength, sepalWidth, petalLength, petalWidth);
                String result = null;

                result = compute.checkRecord(testRecord);

                JOptionPane.showMessageDialog(null, "Your Iris is: " + result);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sepalWidthField.setText(null);
                petalLengthField.setText(null);
                sepalLengthField.setText(null);
            }
        });

    }
}