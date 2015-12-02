/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fancatstic.four.DataSet;
import fancatstic.four.NaiveBayesClassifier;
import fancatstic.four.kNN;
import fancatstic.four.kNNSolver;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Venny
 */
public class UIFrame extends javax.swing.JFrame {
    private DataSet dataset;
    private String result = "hai";
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
        bgModel.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\model_page.png")
                .getImage().getScaledInstance(950, 710, Image.SCALE_SMOOTH)));
        backFromClassify.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\back_button.png")
                .getImage().getScaledInstance(55, 52, Image.SCALE_SMOOTH)));
        backFromModel.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\back_button_model.png")
                .getImage().getScaledInstance(55, 52, Image.SCALE_SMOOTH)));
        backFromModelResult.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\back_button_result.png")
                .getImage().getScaledInstance(55, 52, Image.SCALE_SMOOTH)));
        evaluateButton.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\evaluate_button.png")
                .getImage().getScaledInstance(119, 43, Image.SCALE_SMOOTH)));
        
        browseButton.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\browse_button.png")
                .getImage().getScaledInstance(141, 50, Image.SCALE_SMOOTH)));
        
        createModel.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\create_model_button.png")
                .getImage().getScaledInstance(208, 56, Image.SCALE_SMOOTH)));
        bgResult.setIcon(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\gui\\images\\model_result_page.png")
                .getImage().getScaledInstance(950, 710, Image.SCALE_SMOOTH)));
        
        NaiveBayesClassifier.buildModelFromFile("carmodel.txt");
        resultstring.put("unacc","Unacceptable");
        resultstring.put("acc","Acceptable");
        resultstring.put("good","Good");
        resultstring.put("vgood","Very Good");
        
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
        buyLabel = new javax.swing.JLabel();
        maintLabel = new javax.swing.JLabel();
        doorLabel = new javax.swing.JLabel();
        personLabel = new javax.swing.JLabel();
        lugLabel = new javax.swing.JLabel();
        safetyLabel = new javax.swing.JLabel();
        bgClassifier = new javax.swing.JLabel();
        Model = new javax.swing.JPanel();
        filePath = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        algoComboBox = new javax.swing.JComboBox<>();
        schemaComboBox = new javax.swing.JComboBox<>();
        createModel = new javax.swing.JButton();
        backFromModel = new javax.swing.JButton();
        bgModel = new javax.swing.JLabel();
        ModelResult = new javax.swing.JPanel();
        resultBox = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        backFromModelResult = new javax.swing.JButton();
        bgResult = new javax.swing.JLabel();

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

        kNNButton.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 24)); // NOI18N
        kNNButton.setForeground(new java.awt.Color(255, 255, 255));
        kNNButton.setText("kNN");
        kNNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kNNButtonActionPerformed(evt);
            }
        });
        Classify.add(kNNButton);
        kNNButton.setBounds(370, 360, 90, 31);

        nbButton.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 24)); // NOI18N
        nbButton.setForeground(new java.awt.Color(255, 255, 255));
        nbButton.setText("Naive Bayes");
        nbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbButtonActionPerformed(evt);
            }
        });
        Classify.add(nbButton);
        nbButton.setBounds(475, 355, 180, 41);
        Classify.add(kTextField);
        kTextField.setBounds(460, 400, 70, 30);

        kLabel.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 24)); // NOI18N
        kLabel.setForeground(new java.awt.Color(255, 255, 255));
        kLabel.setText("k:");
        Classify.add(kLabel);
        kLabel.setBounds(430, 405, 20, 20);

        buyingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        buyingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingComboBoxActionPerformed(evt);
            }
        });
        Classify.add(buyingComboBox);
        buyingComboBox.setBounds(160, 470, 100, 30);

        maintComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Very High", "High", "Medium", "Low" }));
        maintComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintComboBoxActionPerformed(evt);
            }
        });
        Classify.add(maintComboBox);
        maintComboBox.setBounds(280, 470, 100, 30);

        doorsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", ">=5" }));
        doorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doorsComboBoxActionPerformed(evt);
            }
        });
        Classify.add(doorsComboBox);
        doorsComboBox.setBounds(410, 470, 70, 30);

        personsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4", "More" }));
        personsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personsComboBoxActionPerformed(evt);
            }
        });
        Classify.add(personsComboBox);
        personsComboBox.setBounds(500, 470, 70, 30);

        lugBootComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Big" }));
        lugBootComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugBootComboBoxActionPerformed(evt);
            }
        });
        Classify.add(lugBootComboBox);
        lugBootComboBox.setBounds(600, 470, 80, 30);

        safetyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Medium", "High" }));
        safetyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safetyComboBoxActionPerformed(evt);
            }
        });
        Classify.add(safetyComboBox);
        safetyComboBox.setBounds(700, 470, 80, 30);

        alertLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        alertLabel.setForeground(new java.awt.Color(255, 255, 255));
        Classify.add(alertLabel);
        alertLabel.setBounds(540, 405, 270, 20);

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
        evaluateButton.setBounds(430, 530, 119, 43);

        resultText.setFont(new java.awt.Font("GrilledCheese BTN Toasted", 0, 36)); // NOI18N
        resultText.setForeground(new java.awt.Color(255, 255, 255));
        resultText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultText.setText("Result");
        Classify.add(resultText);
        resultText.setBounds(380, 590, 220, 50);

        backFromClassify.setBorderPainted(false);
        backFromClassify.setContentAreaFilled(false);
        backFromClassify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromClassifyActionPerformed(evt);
            }
        });
        Classify.add(backFromClassify);
        backFromClassify.setBounds(20, 20, 55, 55);

        buyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buyLabel.setForeground(new java.awt.Color(255, 255, 255));
        buyLabel.setText("Buying Price");
        Classify.add(buyLabel);
        buyLabel.setBounds(165, 450, 90, 15);

        maintLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        maintLabel.setForeground(new java.awt.Color(255, 255, 255));
        maintLabel.setText("Maintenance Cost");
        Classify.add(maintLabel);
        maintLabel.setBounds(275, 450, 120, 15);

        doorLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        doorLabel.setForeground(new java.awt.Color(255, 255, 255));
        doorLabel.setText("Doors");
        Classify.add(doorLabel);
        doorLabel.setBounds(415, 450, 50, 15);

        personLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        personLabel.setForeground(new java.awt.Color(255, 255, 255));
        personLabel.setText("Persons");
        Classify.add(personLabel);
        personLabel.setBounds(505, 450, 60, 15);

        lugLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lugLabel.setForeground(new java.awt.Color(255, 255, 255));
        lugLabel.setText("Luggage");
        Classify.add(lugLabel);
        lugLabel.setBounds(605, 450, 60, 15);

        safetyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        safetyLabel.setForeground(new java.awt.Color(255, 255, 255));
        safetyLabel.setText("Safety");
        Classify.add(safetyLabel);
        safetyLabel.setBounds(705, 450, 50, 15);
        Classify.add(bgClassifier);
        bgClassifier.setBounds(0, 0, 950, 710);

        Model.setPreferredSize(new java.awt.Dimension(950, 710));
        Model.setLayout(null);

        filePath.setEditable(false);
        filePath.setBackground(new java.awt.Color(224, 255, 228));
        filePath.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filePath.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        filePath.setMargin(new java.awt.Insets(10, 10, 10, 10));
        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });
        Model.add(filePath);
        filePath.setBounds(80, 410, 620, 50);

        browseButton.setBorderPainted(false);
        browseButton.setContentAreaFilled(false);
        browseButton.setFocusPainted(false);
        browseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseButtonMouseClicked(evt);
            }
        });
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        Model.add(browseButton);
        browseButton.setBounds(720, 400, 150, 60);

        algoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kNN", "Naive Bayes" }));
        Model.add(algoComboBox);
        algoComboBox.setBounds(290, 480, 180, 30);

        schemaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Training", "10-fold Cross Validation", "10-fold Cross Validation (Random)" }));
        Model.add(schemaComboBox);
        schemaComboBox.setBounds(500, 480, 230, 30);

        createModel.setBorderPainted(false);
        createModel.setContentAreaFilled(false);
        createModel.setFocusCycleRoot(true);
        createModel.setFocusPainted(false);
        createModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createModelActionPerformed(evt);
            }
        });
        Model.add(createModel);
        createModel.setBounds(380, 540, 220, 70);

        backFromModel.setBorderPainted(false);
        backFromModel.setContentAreaFilled(false);
        backFromModel.setFocusPainted(false);
        backFromModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromModelActionPerformed(evt);
            }
        });
        Model.add(backFromModel);
        backFromModel.setBounds(20, 20, 55, 55);
        Model.add(bgModel);
        bgModel.setBounds(0, 0, 950, 710);

        ModelResult.setPreferredSize(new java.awt.Dimension(950, 710));
        ModelResult.setLayout(null);

        resultBox.setBorder(null);
        resultBox.setHorizontalScrollBar(null);
        resultBox.setMaximumSize(new java.awt.Dimension(600, 400));
        resultBox.setMinimumSize(new java.awt.Dimension(600, 400));
        resultBox.setOpaque(false);
        resultBox.setPreferredSize(new java.awt.Dimension(600, 400));

        resultArea.setBackground(new java.awt.Color(255, 255, 219));
        resultArea.setColumns(20);
        resultArea.setRows(5);
        resultArea.setText(result);
        resultArea.setWrapStyleWord(true);
        resultArea.setAutoscrolls(false);
        resultArea.setBorder(null);
        resultArea.setMaximumSize(new java.awt.Dimension(600, 400));
        resultArea.setMinimumSize(new java.awt.Dimension(600, 400));
        resultArea.setOpaque(false);
        resultArea.setPreferredSize(new java.awt.Dimension(600, 400));
        resultArea.setRequestFocusEnabled(false);
        resultBox.setViewportView(resultArea);

        ModelResult.add(resultBox);
        resultBox.setBounds(150, 250, 600, 400);

        backFromModelResult.setBorderPainted(false);
        backFromModelResult.setContentAreaFilled(false);
        backFromModelResult.setFocusPainted(false);
        backFromModelResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromModelResultActionPerformed(evt);
            }
        });
        ModelResult.add(backFromModelResult);
        backFromModelResult.setBounds(20, 20, 55, 55);
        ModelResult.add(bgResult);
        bgResult.setBounds(0, 0, 950, 710);

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ModelResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ModelResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (nbButton.isSelected()){
            nbButton.setSelected(false);
        }
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
        if (nbButton.isSelected()) {
            String result = resultstring.get(NaiveBayesClassifier.classify(data));
            resultText.setText(result);
        } else if (kNNButton.isSelected()) {
            try{
                int k = Integer.valueOf(kTextField.getText());
                kNN knn = new kNN();
                String result = resultstring.get(knn.classify(dataset.getDataset(), data, k));
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
        dataset = new DataSet(filePath.getText());
        int schema;
        
        if (schemaComboBox.getSelectedItem().equals("Full Training")){
            schema = 1;
        }
        else if (schemaComboBox.getSelectedItem().equals("10-fold Cross Validation")){
            schema = 2;
        }
        else {
            schema = 3;
        }
        
        
        if (algoComboBox.getSelectedItem().equals("kNN")){
            result = generateResultkNN(1, schema);
            
        }
        else { //Naive Bayes
            result = "naive bayes";
        }
        
        resultArea.setText(result);
        ModelResult.repaint();
        this.setContentPane(ModelResult);
        this.revalidate();
        this.repaint();
        
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

    private void nbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbButtonActionPerformed
        // TODO add your handling code here:
        if (kNNButton.isSelected()){
            kNNButton.setSelected(false);
        }
    }//GEN-LAST:event_nbButtonActionPerformed

    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browseButtonActionPerformed

    private void browseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseClicked

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "ARFF", "arff");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(Model);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           filePath.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonMouseClicked

    private void backFromModelResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backFromModelResultActionPerformed
        this.setContentPane(Model);
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_backFromModelResultActionPerformed
    
    
    private String generateResultkNN(int k, int schema){
        kNNSolver knn = new kNNSolver(dataset, k, schema);
        String result = "=== Result ===" + "\n" +
                        "Correctly Classified Intances" + "\t" + knn.countCorrect() + "\t" + knn.countAccuracy()*100 + "%" +"\n" +
                        "Incorrectly Classified Intances" + "\t" + knn.countIncorrect() + "\t" + (1-knn.countAccuracy())*100 + "%" +"\n" +
                        "\n" +
                        "=== Confusion Matrix ===" + "\n";
        int[][] matrix = knn.confusionMatrix();
        for (int i=0; i < knn.countClass(); i++){
            result = result.concat("\t" + i); 
        }
        result = result.concat("\t<-- classified as \n");
        
        for (int i=0; i < knn.countClass(); i++){
            for (int j=0; j < knn.countClass(); j++){
              /*if (matrix[i][j] < 10){
                result = result.concat("   ");
              }
              else if (matrix[i][j] < 100){
                result = result.concat("  ");
              }
              else if (matrix[i][j] < 1000){
                result = result.concat(" ");
              }*/
              result = result.concat("\t" + matrix[i][j] + " "); 
            }
            result = result.concat("\t|  "+ i +" = " + dataset.getClassValues().get(i) + "\n");
        }
       
        return result;
    }
    
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
    

    private java.util.Map<String,String> resultstring = new java.util.HashMap<>();
    private JFileChooser chooser = new JFileChooser();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Classify;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel Model;
    private javax.swing.JPanel ModelResult;
    private javax.swing.JLabel alertLabel;
    private javax.swing.JComboBox<String> algoComboBox;
    private javax.swing.JButton backFromClassify;
    private javax.swing.JButton backFromModel;
    private javax.swing.JButton backFromModelResult;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgClassifier;
    private javax.swing.JLabel bgModel;
    private javax.swing.JLabel bgResult;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel buyLabel;
    private javax.swing.JComboBox buyingComboBox;
    private javax.swing.JButton classifierButton;
    private javax.swing.JButton createModel;
    private javax.swing.JLabel doorLabel;
    private javax.swing.JComboBox doorsComboBox;
    private javax.swing.JButton evaluateButton;
    private javax.swing.JTextField filePath;
    private javax.swing.JLabel kLabel;
    private javax.swing.JRadioButton kNNButton;
    private javax.swing.JTextField kTextField;
    private javax.swing.JComboBox lugBootComboBox;
    private javax.swing.JLabel lugLabel;
    private javax.swing.JComboBox maintComboBox;
    private javax.swing.JLabel maintLabel;
    private javax.swing.JButton modelButton;
    private javax.swing.JRadioButton nbButton;
    private javax.swing.JLabel personLabel;
    private javax.swing.JComboBox personsComboBox;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JScrollPane resultBox;
    private javax.swing.JLabel resultText;
    private javax.swing.JComboBox safetyComboBox;
    private javax.swing.JLabel safetyLabel;
    private javax.swing.JComboBox<String> schemaComboBox;
    // End of variables declaration//GEN-END:variables
}
