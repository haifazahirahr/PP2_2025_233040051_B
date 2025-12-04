/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2.modul08;

/**
 *
 * @author ASUS
 */

import id.ac.unpas.pp2.modul08.controller.PersegiPanjangController;
import id.ac.unpas.pp2.modul08.model.PersegiPanjangModel;
import id.ac.unpas.pp2.modul08.view.PersegiPanjangView;

public class Main {
    public static void main(String[] args) {
        // 1. instalasi model
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        // 2. instalasi view
        PersegiPanjangView view = new PersegiPanjangView();
        
        // 3. instalasi controller
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        // 4. tampilkan view
        view.setVisible(true);
    }
}
