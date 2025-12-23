/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul10.Tugas;

/**
 *
 * @author HaifaZR
 */
import id.ac.unpas.modul10.Tugas.view.MahasiswaAppView;
import id.ac.unpas.modul10.Tugas.model.MahasiswaAppModel;
import id.ac.unpas.modul10.Tugas.controller.MahasiswaAppController;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaAppView view = new MahasiswaAppView();
            MahasiswaAppModel model = new MahasiswaAppModel();
            new MahasiswaAppController(view, model);
            view.setVisible(true);
        });
    }
}
