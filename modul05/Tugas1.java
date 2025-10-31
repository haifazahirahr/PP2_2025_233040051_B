/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul05;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new BorderLayout());
                
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                
                JButton button = new JButton("Tombol ada di Bawah (SOUTH)");
                JButton buttonNorth = new JButton("NORTH");
                JButton buttonEast = new JButton("EAST");
                JButton buttonWest = new JButton("WEST");
                JButton buttonCenter = new JButton("CENTER");
                
                button.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                buttonNorth.addActionListener(e -> {
                    label.setText("Tombol di NORTH diklik!");
                });
                buttonEast.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });
                buttonWest.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });
                buttonCenter.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });
                
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);
                
                frame.setVisible(true);
            }
            
        });
        
     }
     
}
