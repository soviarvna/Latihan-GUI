import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TOP-LEVEL CONTAINER: JFrame
public class DataBuku extends JFrame implements ActionListener {

    // ATOMIC COMPONENTS
    private JTextField judulField, penulisField;
    private JButton simpanButton, resetButton;
    private JLabel judulLabel, penulisLabel, headerLabel;

    public DataBuku() {
        setTitle("Aplikasi Data Buku");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // LAYOUT 1: BorderLayout (untuk frame utama)
        setLayout(new BorderLayout(10, 10));

        // Header
        headerLabel = new JLabel("Input Data Buku", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel, BorderLayout.NORTH);

        // INTERMEDIATE CONTAINER 1: JPanel form
        // LAYOUT 2: GridLayout
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        judulLabel = new JLabel("Judul Buku:");
        penulisLabel = new JLabel("Nama Penulis:");
        judulField = new JTextField();
        penulisField = new JTextField();

        formPanel.add(judulLabel);
        formPanel.add(judulField);
        formPanel.add(penulisLabel);
        formPanel.add(penulisField);

        add(formPanel, BorderLayout.CENTER);

        // INTERMEDIATE CONTAINER 2: JPanel tombol
        // LAYOUT 3: FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        simpanButton = new JButton("Simpan");
        resetButton = new JButton("Reset");

        buttonPanel.add(simpanButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

        //  EVENT LISTENER
        simpanButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    // EVENT LISTENER: method override dari ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == simpanButton) {
            String judul = judulField.getText();
            String penulis = penulisField.getText();

            if (!judul.isEmpty() && !penulis.isEmpty()) {
                System.out.println("Judul Buku  : " + judul);
                System.out.println("Nama Penulis: " + penulis);

                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                judulField.setText("");
                penulisField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi!");
            }
        } else if (e.getSource() == resetButton) {
            judulField.setText("");
            penulisField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataBuku().setVisible(true));
    }
}