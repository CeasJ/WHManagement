
package com.QLK.view;

import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.awt.Color;

/**
 *
 * @author Manh Thanh
 */
public class TrangChuJPanel extends javax.swing.JPanel {

  
    public TrangChuJPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // </editor-fold>//GEN-END:initComponents
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        Anhnen = new JLabel();

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(new AbsoluteLayout());

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/com/QLK/icon/TextMain.png")));
        jPanel1.add(jLabel2, new AbsoluteConstraints(330, 30, -1, -1));

        Anhnen.setIcon(new ImageIcon(getClass().getResource("/com/QLK/icon/MainBG.png")));
        jPanel1.add(Anhnen, new AbsoluteConstraints(0, 170, -1, -1));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Anhnen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
