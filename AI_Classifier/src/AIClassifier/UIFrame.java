/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AIClassifier;

/**
 *
 * @author ASUS X202E
 */
public class UIFrame extends javax.swing.JFrame {

    /**
     * Creates new form UIFrame
     */
    public UIFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algorithmChooser = new javax.swing.ButtonGroup();
        naiveBayesButton = new javax.swing.JRadioButton();
        kNNButton = new javax.swing.JRadioButton();
        algorithmText = new javax.swing.JLabel();
        buyingText = new javax.swing.JLabel();
        maintText = new javax.swing.JLabel();
        buyingComboBox = new javax.swing.JComboBox();
        doorsText = new javax.swing.JLabel();
        personsText = new javax.swing.JLabel();
        maintComboBox = new javax.swing.JComboBox();
        doorsComboBox = new javax.swing.JComboBox();
        personsComboBox = new javax.swing.JComboBox();
        lugBootText = new javax.swing.JLabel();
        safetyText = new javax.swing.JLabel();
        lugBootComboBox = new javax.swing.JComboBox();
        safetyComboBox = new javax.swing.JComboBox();
        resultText = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        evaluateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        algorithmChooser.add(naiveBayesButton);
        naiveBayesButton.setText("Naive-Bayes");
        naiveBayesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naiveBayesButtonActionPerformed(evt);
            }
        });

        algorithmChooser.add(kNNButton);
        kNNButton.setText("kNN");
        kNNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kNNButtonActionPerformed(evt);
            }
        });

        algorithmText.setText("Algorithm:");

        buyingText.setText("Buying Price");

        maintText.setText("Maintenance Price");

        buyingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        buyingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingComboBoxActionPerformed(evt);
            }
        });

        doorsText.setText("Doors");

        personsText.setText("Persons");

        maintComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        maintComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintComboBoxActionPerformed(evt);
            }
        });

        doorsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", ">=5" }));
        doorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doorsComboBoxActionPerformed(evt);
            }
        });

        personsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4", "More" }));
        personsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personsComboBoxActionPerformed(evt);
            }
        });

        lugBootText.setText("Luggage Boot Size");

        safetyText.setText("Safety");

        lugBootComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Big" }));
        lugBootComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugBootComboBoxActionPerformed(evt);
            }
        });

        safetyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Medium", "High" }));
        safetyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safetyComboBoxActionPerformed(evt);
            }
        });

        resultText.setText("Result");

        titleText.setText("Judul");

        evaluateButton.setText("Evaluate Class");
        evaluateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evaluateButtonMouseClicked(evt);
            }
        });
        evaluateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(algorithmText)
                        .addGap(18, 18, 18)
                        .addComponent(naiveBayesButton)
                        .addGap(18, 18, 18)
                        .addComponent(kNNButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyingText)
                            .addComponent(buyingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maintText)
                            .addComponent(maintComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doorsText)
                            .addComponent(doorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personsText)
                            .addComponent(personsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lugBootText)
                            .addComponent(lugBootComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(safetyText)
                            .addComponent(safetyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(titleText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(evaluateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(resultText)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titleText)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmText)
                    .addComponent(naiveBayesButton)
                    .addComponent(kNNButton))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyingText)
                    .addComponent(maintText)
                    .addComponent(doorsText)
                    .addComponent(personsText)
                    .addComponent(lugBootText)
                    .addComponent(safetyText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maintComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lugBootComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(safetyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(evaluateButton)
                .addGap(37, 37, 37)
                .addComponent(resultText)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naiveBayesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naiveBayesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_naiveBayesButtonActionPerformed

    private void kNNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kNNButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kNNButtonActionPerformed

    private void buyingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingComboBoxActionPerformed

    private void maintComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maintComboBoxActionPerformed

    private void doorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doorsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doorsComboBoxActionPerformed

    private void personsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personsComboBoxActionPerformed

    private void lugBootComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugBootComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugBootComboBoxActionPerformed

    private void safetyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safetyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_safetyComboBoxActionPerformed

    private void evaluateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evaluateButtonActionPerformed

    private void evaluateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluateButtonMouseClicked
        java.util.List<String> data = new java.util.ArrayList<>();
        data.add((String)buyingComboBox.getSelectedItem());
        data.add((String)maintComboBox.getSelectedItem());
        data.add((String)doorsComboBox.getSelectedItem());
        data.add((String)personsComboBox.getSelectedItem());
        data.add((String)lugBootComboBox.getSelectedItem());
        data.add((String)safetyComboBox.getSelectedItem());
        if (naiveBayesButton.isSelected()) {
            String result = naiveBayesClassifier.classify(data);
            resultText.setText(result);
        } else {
            //isi yang kNN di sini
        }
    }//GEN-LAST:event_evaluateButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup algorithmChooser;
    private javax.swing.JLabel algorithmText;
    private javax.swing.JComboBox buyingComboBox;
    private javax.swing.JLabel buyingText;
    private javax.swing.JComboBox doorsComboBox;
    private javax.swing.JLabel doorsText;
    private javax.swing.JButton evaluateButton;
    private javax.swing.JRadioButton kNNButton;
    private javax.swing.JComboBox lugBootComboBox;
    private javax.swing.JLabel lugBootText;
    private javax.swing.JComboBox maintComboBox;
    private javax.swing.JLabel maintText;
    private javax.swing.JRadioButton naiveBayesButton;
    private javax.swing.JComboBox personsComboBox;
    private javax.swing.JLabel personsText;
    private javax.swing.JLabel resultText;
    private javax.swing.JComboBox safetyComboBox;
    private javax.swing.JLabel safetyText;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
