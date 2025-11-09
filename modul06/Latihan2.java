/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul06;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 200);
        frame.setLayout(new GridLayout(4, 1, 5, 5));

        // Panel input
        JPanel panelInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        panelInput.add(labelCelcius);
        panelInput.add(inputCelcius);

        // Panel tombol
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnKonversi = new JButton("Konversi");
        panelBtn.add(btnKonversi);

        // Panel hasil
        JPanel panelHasil = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasilFahrenheit = new JLabel("–");

        hasilFahrenheit.setForeground(Color.BLUE);

        panelHasil.add(labelFahrenheit);
        panelHasil.add(hasilFahrenheit);

        // Tambahkan ke frame
        frame.add(panelInput);
        frame.add(panelBtn);
        frame.add(panelHasil);

        // Tambahkan border supaya tampilannya beda
        // ActionListener
        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String teks = inputCelcius.getText().trim();
                    double celcius = Double.parseDouble(teks);
                    double fahrenheit = (celcius * 9 / 5) + 32;

                    hasilFahrenheit.setText(String.format("%.2f °F", fahrenheit));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Input harus berupa angka.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}