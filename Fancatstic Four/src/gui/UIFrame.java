/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fancatstic.four.DataSet;
import fancatstic.four.NaiveBayesClassifier;
import fancatstic.four.kNN;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Venny
 */
public class UIFrame extends javax.swing.JFrame {
    private DataSet dataset;
    /**
     * Creates new form UIFrame
     */
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    
    public UIFrame() {
        initComponents();
        initMainMenu();
        this.setContentPane(MainMenu);
        this.invalidate();
        this.validate();
        dataset = new DataSet("cartest.arff");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void initMainMenu() {
        bg.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\front_page.png")
                .getImage().getScaledInstance(950, 710, Image.SCALE_SMOOTH)));
        classifierButton.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\classifier_button.png")
                .getImage().getScaledInstance(230, 81, Image.SCALE_SMOOTH)));
        modelButton.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\model_button.png")
                .getImage().getScaledInstance(230, 81, Image.SCALE_SMOOTH)));
        
        bgClassifier.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\classifier_page.png")
                .getImage().getScaledInstance(950, 710, Image.SCALE_SMOOTH)));
        backFromClassify.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\back_button.png")
                .getImage().getScaledInstance(55, 52, Image.SCALE_SMOOTH)));
        evaluateButton.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\evaluate_button.png")
                .getImage().getScaledInstance(119, 43, Image.SCALE_SMOOTH)));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenu = new javax.swing.JPanel();
        modelButton = new javax.swing.JButton();
        classifierButton = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        Classify = new javax.swing.JPanel();
        kNNButton = new javax.swing.JRadioButton();
        nbButton = new javax.swing.JRadioButton();
        kTextField = new javax.swing.JTextField();
        kLabel = new javax.swing.JLabel();
        buyingComboBox = new javax.swing.JComboBox();
        maintComboBox = new javax.swing.JComboBox();
        doorsComboBox = new javax.swing.JComboBox();
        personsComboBox = new javax.swing.JComboBox();
        lugBootComboBox = new javax.swing.JComboBox();
        safetyComboBox = new javax.swing.JComboBox();
        alertLabel = new javax.swing.JLabel();
        evaluateButton = new javax.swing.JButton();
        resultText = new javax.swing.JLabel();
        backFromClassify = new javax.swing.JButton();
        bgClassifier = new javax.swing.JLabel();
        Model = new javax.swing.JPanel();
        filePath = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        algoComboBox = new javax.swing.JComboBox<String>();
        schemaComboBox = new javax.swing.JComboBox<String>();
        createModel = new javax.swing.JButton();
        backFromModel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(945, 708));

        MainMenu.setLayout(null);

        modelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelButtonActionPerformed(evt);
            }
        });
        MainMenu.add(modelButton);
        modelButton.setBounds(500, 550, 240, 90);
        modelButton.setBorderPainted(false);
        modelButton.setContentAreaFilled(false);
        modelButton.setFocusPainted(false);
        modelButton.setOpaque(false);

        classifierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifierButtonActionPerformed(evt);
            }
        });
        MainMenu.add(classifierButton);
        classifierButton.setBounds(210, 550, 230, 90);
        classifierButton.setBorderPainted(false);
        classifierButton.setContentAreaFilled(false);
        classifierButton.setFocusPainted(false);
        classifierButton.setOpaque(false);
        MainMenu.add(bg);
        bg.setBounds(0, 0, 950, 710);

        Classify.setLayout(null);

        kNNButton.setText("kNN");
        kNNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kNNButtonActionPerformed(evt);
            }
        });
        Classify.add(kNNButton);
        kNNButton.setBounds(400, 310, 90, 23);

        nbButton.setText("Naive Bayes");
        Classify.add(nbButton);
        nbButton.setBounds(510, 310, 120, 23);
        Classify.add(kTextField);
        kTextField.setBounds(460, 350, 70, 30);

        kLabel.setText("k:");
        Classify.add(kLabel);
        kLabel.setBounds(430, 350, 20, 20);

        buyingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        buyingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingComboBoxActionPerformed(evt);
            }
        });
        Classify.add(buyingComboBox);
        buyingComboBox.setBounds(160, 420, 100, 20);

        maintComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        maintComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintComboBoxActionPerformed(evt);
            }
        });
        Classify.add(maintComboBox);
        maintComboBox.setBounds(280, 420, 100, 20);

        doorsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", ">=5" }));
        doorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doorsComboBoxActionPerformed(evt);
            }
        });
        Classify.add(doorsComboBox);
        doorsComboBox.setBounds(410, 420, 70, 20);

        personsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4", "More" }));
        personsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personsComboBoxActionPerformed(evt);
            }
        });
        Classify.add(personsComboBox);
        personsComboBox.setBounds(510, 420, 70, 20);

        lugBootComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Big" }));
        lugBootComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugBootComboBoxActionPerformed(evt);
            }
        });
        Classify.add(lugBootComboBox);
        lugBootComboBox.setBounds(600, 420, 80, 20);

        safetyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Medium", "High" }));
        safetyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safetyComboBoxActionPerformed(evt);
            }
        });
        Classify.add(safetyComboBox);
        safetyComboBox.setBounds(700, 420, 80, 20);
        Classify.add(alertLabel);
        alertLabel.setBounds(360, 460, 270, 20);

        evaluateButton.setBorderPainted(false);
        evaluateButton.setContentAreaFilled(false);
        evaluateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        Classify.add(evaluateButton);
        evaluateButton.setBounds(356, 500, 119, 43);

        resultText.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 36)); // NOI18N
        resultText.setForeground(new java.awt.Color(255, 255, 255));
        resultText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultText.setText("Result");
        Classify.add(resultText);
        resultText.setBounds(370, 570, 220, 50);

        backFromClassify.setBorderPainted(false);
        backFromClassify.setContentAreaFilled(false);
        backFromClassify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromClassifyActionPerformed(evt);
            }
        });
        Classify.add(backFromClassify);
        backFromClassify.setBounds(20, 20, 55, 55);
        Classify.add(bgClassifier);
        bgClassifier.setBounds(0, 0, 950, 710);

        Model.setLayout(null);
        Model.add(filePath);
        filePath.setBounds(200, 210, 420, 30);

        browseButton.setText("Browse");
        Model.add(browseButton);
        browseButton.setBounds(630, 210, 73, 30);

        algoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "kNN", "Naive Bayes" }));
        Model.add(algoComboBox);
        algoComboBox.setBounds(240, 280, 180, 30);

        schemaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full Training", "10-fold Cross Validation", "10-fold Cross Validation (Random)" }));
        Model.add(schemaComboBox);
        schemaComboBox.setBounds(450, 280, 230, 30);

        createModel.setText("Create Model");
        createModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createModelActionPerformed(evt);
            }
        });
        Model.add(createModel);
        createModel.setBounds(370, 380, 160, 40);

        backFromModel.setText("Back");
        backFromModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromModelActionPerformed(evt);
            }
        });
        Model.add(backFromModel);
        backFromModel.setBounds(20, 20, 55, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classifierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifierButtonActionPerformed
        // TODO add your handling code here:
        this.setContentPane(Classify);
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_classifierButtonActionPerformed

    private void kNNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kNNButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kNNButtonActionPerformed

    private void lugBootComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugBootComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugBootComboBoxActionPerformed

    private void maintComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maintComboBoxActionPerformed

    private void personsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personsComboBoxActionPerformed

    private void safetyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safetyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_safetyComboBoxActionPerformed

    private void evaluateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluateButtonMouseClicked
        java.util.List<String> data = new java.util.ArrayList<>();
        alertLabel.setText("");
        if (nbButton.isSelected()) {
            data.add((String)buyingComboBox.getSelectedItem());
            data.add((String)maintComboBox.getSelectedItem());
            data.add((String)doorsComboBox.getSelectedItem());
            data.add((String)personsComboBox.getSelectedItem());
            data.add((String)lugBootComboBox.getSelectedItem());
            data.add((String)safetyComboBox.getSelectedItem());
            String result = NaiveBayesClassifier.classify(data);
            resultText.setText(result);
        } else if (kNNButton.isSelected()) {
            try{
                String buyingPrice = ((String)buyingComboBox.getSelectedItem()).toLowerCase().replace("very ", "v").replace("ium", "");
                data.add(buyingPrice);
                String maintenancePrice = ((String)maintComboBox.getSelectedItem()).toLowerCase().replace("very ", "v").replace("ium", "");
                data.add(maintenancePrice);
                String doors = ((String)doorsComboBox.getSelectedItem()).replace(">=5", "5more");
                data.add(doors);
                String persons = ((String)personsComboBox.getSelectedItem()).toLowerCase();
                data.add(persons);
                String luggageBoot = ((String)lugBootComboBox.getSelectedItem()).toLowerCase();
                data.add(luggageBoot);
                String safety = ((String)safetyComboBox.getSelectedItem()).toLowerCase();
                data.add(safety);
                int k = Integer.valueOf(kTextField.getText());
                kNN knn = new kNN();
                String result = knn.classify(dataset.getDataset(), data, k);
                knn.printQueue();
                resultText.setText(result);
            } catch (NumberFormatException e) {
                alertLabel.setText("Please input number for k!");
            }
        }
    }//GEN-LAST:event_evaluateButtonMouseClicked

    private void evaluateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evaluateButtonActionPerformed

    private void doorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doorsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doorsComboBoxActionPerformed

    private void buyingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingComboBoxActionPerformed

    private void modelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelButtonActionPerformed
        // TODO add your handling code here:
        this.setContentPane(Model);
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_modelButtonActionPerformed

    private void createModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createModelActionPerformed

    private void backFromClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFromClassifyActionPerformed
        // TODO add your handling code here:
        this.setContentPane(MainMenu);
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_backFromClassifyActionPerformed

    private void backFromModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFromModelActionPerformed
        // TODO add your handling code here:
        this.setContentPane(MainMenu);
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_backFromModelActionPerformed

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
    private javax.swing.JPanel Classify;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel Model;
    private javax.swing.JLabel alertLabel;
    private javax.swing.JComboBox<String> algoComboBox;
    private javax.swing.JButton backFromClassify;
    private javax.swing.JButton backFromModel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgClassifier;
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox buyingComboBox;
    private javax.swing.JButton classifierButton;
    private javax.swing.JButton createModel;
    private javax.swing.JComboBox doorsComboBox;
    private javax.swing.JButton evaluateButton;
    private javax.swing.JTextField filePath;
    private javax.swing.JLabel kLabel;
    private javax.swing.JRadioButton kNNButton;
    private javax.swing.JTextField kTextField;
    private javax.swing.JComboBox lugBootComboBox;
    private javax.swing.JComboBox maintComboBox;
    private javax.swing.JButton modelButton;
    private javax.swing.JRadioButton nbButton;
    private javax.swing.JComboBox personsComboBox;
    private javax.swing.JLabel resultText;
    private javax.swing.JComboBox safetyComboBox;
    private javax.swing.JComboBox<String> schemaComboBox;
    // End of variables declaration//GEN-END:variables
}
