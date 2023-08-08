package com.s.main;

import com.s.swing.ComponentResizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HomeScreen extends javax.swing.JFrame {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String NUMBERS = "0123456789";
    private static final String EMAIL_REGEX = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/";

    public HomeScreen() {
        initComponents();
        init();
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void validateAndProcessEmail() {
        String userEmail = txtEmail.getText().trim(); // Assuming txtEmail is the JTextField for email input

        if (validateEmail(userEmail)) {
            // Email is valid, you can perform further actions here
            System.out.println("Email is valid: " + userEmail);
        } else {
            // Email is not valid
            JOptionPane.showMessageDialog(new JFrame(), "Please provide valid email");
        }
    }

    private String generateRandomPhrase(int length) {
        StringBuilder phraseBuilder = new StringBuilder();

        String allCharacters = ALPHABET + SYMBOLS + NUMBERS;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            phraseBuilder.append(randomChar);
        }

        return phraseBuilder.toString();
    }

    private void init() {
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMinimumSize(new Dimension(1000, 500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10, 10));
        setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new com.s.swing.FullPanel();
        topBar1 = new com.s.component.TopBar();
        cmdMinimize = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdMaximize = new javax.swing.JButton();
        behind = new com.s.swing.Panel();
        background1 = new com.s.swing.Background();
        panel = new javax.swing.JPanel();
        txtEmail = new com.s.swing.blur.TextField();
        button1 = new com.s.swing.blur.Button();
        txtAns = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        topBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topBar1MouseDragged(evt);
            }
        });
        topBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topBar1MousePressed(evt);
            }
        });

        cmdMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/minimize.png"))); // NOI18N
        cmdMinimize.setBorderPainted(false);
        cmdMinimize.setContentAreaFilled(false);
        cmdMinimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/close_minimize.png"))); // NOI18N
        cmdMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinimizeActionPerformed(evt);
            }
        });

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/close.png"))); // NOI18N
        cmdClose.setBorderPainted(false);
        cmdClose.setContentAreaFilled(false);
        cmdClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/close_cross.png"))); // NOI18N
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/maximize.png"))); // NOI18N
        cmdMaximize.setBorderPainted(false);
        cmdMaximize.setContentAreaFilled(false);
        cmdMaximize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/s/icon/maximize_enlarge.png"))); // NOI18N
        cmdMaximize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMaximizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBar1Layout = new javax.swing.GroupLayout(topBar1);
        topBar1.setLayout(topBar1Layout);
        topBar1Layout.setHorizontalGroup(
            topBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmdMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmdMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBar1Layout.setVerticalGroup(
            topBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdMaximize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        behind.setBackground(new java.awt.Color(251, 249, 250));

        background1.setBlur(panel);

        panel.setOpaque(false);

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setHint("Enter Your Email Here");
        txtEmail.setInheritsPopupMenu(true);

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Generate");
        button1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        txtAns.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAns.setForeground(new java.awt.Color(255, 255, 255));
        txtAns.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAns.setText("Your Answer");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout behindLayout = new javax.swing.GroupLayout(behind);
        behind.setLayout(behindLayout);
        behindLayout.setHorizontalGroup(
            behindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        behindLayout.setVerticalGroup(
            behindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(behind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(topBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(behind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void topBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBar1MousePressed
        pX = evt.getX();
        pY = evt.getY();
    }//GEN-LAST:event_topBar1MousePressed

    private void topBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBar1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_topBar1MouseDragged

    private void cmdMaximizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMaximizeActionPerformed
        int currentState = getExtendedState();
        if (currentState == JFrame.NORMAL) {
            // Maximize the JFrame
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            // Set the JFrame back to default size
            setExtendedState(JFrame.NORMAL);
        }
    }//GEN-LAST:event_cmdMaximizeActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        if (isEnabled()) {
            // Show a confirmation dialog to the user.
            int response = JOptionPane.showConfirmDialog(this, "Are You Sure ?", "Caution", JOptionPane.YES_NO_OPTION);

            // Check the user's response to the dialog.
            if (response == JOptionPane.YES_OPTION) {
                // If the user clicks "Yes", close the frame.
                this.dispose(); // This will close the current frame/dialog.
                Main m = new Main();
                m.setVisible(true);
                int DISPOSE_ON_CLOSE1 = HomeScreen.DISPOSE_ON_CLOSE;
            }
            // If the user clicks "No" or closes the dialog, the method will simply return, and the frame remains open.
        }
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinimizeActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_cmdMinimizeActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        String email = txtEmail.getText();
        validateAndProcessEmail();
            int phraseLength = 10; // You can change the desired length here
            String randomPhrase = generateRandomPhrase(phraseLength);
            txtAns.setText("Suggested Password: " + randomPhrase);
        
    }//GEN-LAST:event_button1ActionPerformed

    private int pX;
    private int pY;

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
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.s.swing.Background background1;
    private com.s.swing.Panel behind;
    private com.s.swing.FullPanel bg;
    private com.s.swing.blur.Button button1;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdMaximize;
    private javax.swing.JButton cmdMinimize;
    private javax.swing.JPanel panel;
    private com.s.component.TopBar topBar1;
    private javax.swing.JLabel txtAns;
    private com.s.swing.blur.TextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
