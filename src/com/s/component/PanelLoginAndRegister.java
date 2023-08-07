package com.s.component;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import com.s.main.HomeScreen;
import com.s.main.Main;
import com.s.swing.Button;
import com.s.swing.MyPasswordField;
import com.s.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        initSignup();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initSignup() {

    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/s/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/s/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/s/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
                String Name, Email, Pass, query;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/passgen", "root", "Divya2206@$");
                    java.sql.Statement st = con.createStatement();
                    if ("".equals(txtUser.getText()) || "".equals(txtEmail.getText()) || "".equals(txtPass.getPassword().toString())) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Name = txtUser.getText();
                        Email = txtEmail.getText();
                        Pass = txtPass.getPassword().toString();
                        System.out.println(Pass);
                        query = "INSERT INTO user(userName,userEmail,userPass)" + "VALUES('" + Name + "','" + Email + "','" + Pass + "')";
                        st.execute(query);
                        txtUser.setText("");
                        txtEmail.setText("");
                        txtPass.setText("");
                        JOptionPane.showMessageDialog(null, "Welcome User :" + Name);
                        HomeScreen hs = new HomeScreen();
                        hs.setVisible(true);
                        // Close the Main frame when the HomeScreen opens up.
                        Main m = new Main();m.dispose();
                        
                    }

                } catch (HeadlessException | ClassNotFoundException | SQLException ae) {
                    System.out.println("Error !" + ae.getMessage());
                }
            }
        });
        register.add(cmd, "w 40%, h 40");

    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/s/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/s/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
                String Email, Pass, query, PassDB = null;
                int notFound = 0;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/passgen", "root", "Divya2206@$");
                    java.sql.Statement st = con.createStatement();
                    if ("".equals(txtEmail.getText()) || "".equals(txtPass.getPassword().toString())) {
                        JOptionPane.showMessageDialog(new JFrame(), "Full Name required", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Email = txtEmail.getText();
                        Pass = txtPass.getPassword().toString();
                        query = "SELECT * FROM user WHERE userEmail=" + Email + "AND userPass =" + Pass + "";
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                            PassDB = rs.getString("Pass");//Can Be problem
                            notFound = 1;
                        }
                        if (notFound == 1 && Pass.equals(PassDB)) {
                            System.out.println("Okay");
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Incorrect mail or Password", JOptionPane.ERROR_MESSAGE);

                        }
                        st.execute(query);
                        txtEmail.setText("");
                        txtPass.setText("");
                        JOptionPane.showMessageDialog(null, "Welcome");

                    }

                } catch (Exception ae) {
                    System.out.println("Error !" + ae.getMessage());
                }
            }
        });
        login.add(cmd, "w 40%, h 40");
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
