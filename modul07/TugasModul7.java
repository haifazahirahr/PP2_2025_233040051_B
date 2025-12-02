/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class TugasModul7 extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private final JTabbedPane tabbedPane;

    public TugasModul7() {
        
        // 1. konfigurasi frame utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 2. inisialisasi tabbed pane
        tabbedPane = new JTabbedPane();

        // 3. membuat panel untuk tab 1 
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);
        
        // 4. membuat panel untuk tab 2 
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);
        add(tabbedPane);
    }

    // Tab Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // komponen nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // komponen mata pelajaran
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = { "Matematika Dasar", "Bahasa Indonesia",
                "Algoritma dan Pemrograman I", "Praktikum Pemrograman II" };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // komponen nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // tombol reset untuk menghapus isi form
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);
        
        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        // tombol reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
            }
        });

        // Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel;
    }

    // method membuat tab tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = { "Nama Siswa", "Mata Pelajaran", "Nilai", "Grade" };
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // tambah tombol hapus
        JPanel panelHapus = new JPanel(new GridLayout(1, 1));
        JButton btnHapus = new JButton("Hapus Data");
        panelHapus.add(btnHapus);
        panel.add(panelHapus, BorderLayout.PAGE_END);

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow();
                if (selectedRow > -1) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus.");
                }
            }
        });

        return panel;
    }

    private void prosesSimpan() {

        // 1. ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2. validasi input
      
        // validasi cek apakah nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; 
            
            // validasi nama minimal 3 karakter
        } else if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, 
                    "Nama minimal 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        // validasi untuk cek apakah nilai berupa angka
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. logika bisnis
        String grade;
        int Nilai = nilai / 10;

        switch (Nilai) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }

        // 4. masukkan ke Tabel
        Object[] dataBaris = { nama, matkul, nilai, grade };
        tableModel.addRow(dataBaris);

        // 5. reset form dan pindah tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TugasModul7 app = new TugasModul7();
            app.setVisible(true);
        });
    }

}