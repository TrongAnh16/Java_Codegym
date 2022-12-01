package communityuni.com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTBac1UI {
    private JPanel pnMain;
    private JTextField txta;
    private JTextField txtb;
    private JTextField txtkq;
    private JButton btnGiai;
    private JButton btnTiep;
    private JButton btnThoat;

    public PTBac1UI() {
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyGiai();
            }
        });
        btnTiep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txta.setText("");
                txtb.setText("");
                txtkq.setText("");
                txta.requestFocus();
            }
        });
    }

    private void xuLyGiai() {
        double a=Integer.parseInt(txta.getText());
        double b=Integer.parseInt(txtb.getText());
        txtkq.setText((-b/a)+"") ;
    }

    public JPanel getPnMain() {
        return pnMain;
    }
}
