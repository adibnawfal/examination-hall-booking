package main;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;

// Login class (subclass) inherits JFrame class (superclass)
public class Login extends JFrame {

  // Create JFrame object component
  // to use for GUI process
  JLabel lblHeader, lblDesc, lblImg, lblAdminLogin, lblUsername, lblPassword;
  JTextField tfUsername;
  JPasswordField pfPassword;
  JButton btnLogin;
  JPanel pnlLogin;
  ImageIcon img;

  // No-argument constructor for Login class
  public Login() {
    // Access the JFrame (superclass) constructor
    // with the argument of the frame title
    super("Admin Login");
    // Run showGUI() method to display
    // the GUI of the Home frame
    showGUI();
    isLogin();
    setSize(1100, 380); // Resolution of the frame
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    getContentPane().setBackground(new Color(255, 255, 255));
  }

  // Create showGUI() method to display
  // the GUI of the Home frame
  public void showGUI() {
    // Create a JFrame layout component
    // to use for arranging the JFrame component
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    setLayout(layout);

    // Create and arrange the header
    // of the frame which is the title
    // and the image
    lblHeader = new JLabel("Examination Hall", JLabel.LEFT);
    gbc.gridx = 0; // Specify the row position
    gbc.gridy = 0; // Specify the column position
    gbc.gridwidth = 1; // Specify the width of the row
    gbc.gridheight = 1; // Specify the height of the column
    add(lblHeader, gbc); // Add the component to the frame

    // Define the padding of the component
    // with the following arguments rules
    // (top, left, bottom, right)
    gbc.insets = new Insets(0, 0, 50, 0);

    lblDesc = new JLabel("Booking System", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblDesc, gbc);

    img = new ImageIcon(Login.class.getResource("/images/uthm.png"));
    lblImg = new JLabel(img, JLabel.RIGHT);
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    add(lblImg, gbc);

    gbc.insets = new Insets(0, 0, 10, 0);

    // Create and arrange the
    // content of the frame body
    lblAdminLogin = new JLabel("Admin Login", JLabel.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    add(lblAdminLogin, gbc);

    gbc.insets = new Insets(5, 205, 0, 20);

    lblUsername = new JLabel("Username", JLabel.LEFT);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblUsername, gbc);

    gbc.insets = new Insets(5, 0, 0, 185);

    tfUsername = new JTextField(15);
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(tfUsername, gbc);

    gbc.insets = new Insets(5, 205, 0, 20);

    lblPassword = new JLabel("Password", JLabel.LEFT);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblPassword, gbc);

    gbc.insets = new Insets(5, 0, 0, 185);

    pfPassword = new JPasswordField(15);
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(pfPassword, gbc);

    gbc.insets = new Insets(10, 0, 55, 0);

    btnLogin = new JButton("Login");
    pnlLogin = new JPanel();
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    btnLogin.setPreferredSize(new Dimension(250, 25));
    pnlLogin.add(btnLogin);
    add(pnlLogin, gbc);

    // Styling the font-family, font-weight,
    // and font-size of the label component
    lblHeader.setFont(new Font("Open Sans", Font.BOLD, 18));
    lblDesc.setFont(new Font("Open Sans", Font.PLAIN, 14));
    lblAdminLogin.setFont(new Font("Open Sans", Font.BOLD, 14));
    lblUsername.setFont(new Font("Open Sans", Font.BOLD, 12));
    lblPassword.setFont(new Font("Open Sans", Font.BOLD, 12));

    // Styling the color of the background
    // and foreground of the component
    lblHeader.setForeground(new Color(48, 38, 130));
    tfUsername.setBackground(new Color(217, 217, 217));
    pfPassword.setBackground(new Color(217, 217, 217));
    btnLogin.setBackground(new Color(48, 38, 130));
    btnLogin.setForeground(new Color(255, 255, 255));
    pnlLogin.setBackground(new Color(255, 255, 255));
  }

  // getMd5() hash algorithm to create
  // hash of the password input
  public String getMd5(String input) {
    try {
      // Static getInstance method is called with hashing MD5
      MessageDigest md = MessageDigest.getInstance("MD5");

      // digest() method is called to calculate message digest
      // of an input digest() return array of byte
      byte[] messageDigest = md.digest(input.getBytes());

      // Convert byte array into signum representation
      BigInteger no = new BigInteger(1, messageDigest);

      // Convert message digest into hex value
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      // For specifying wrong message digest algorithms
      throw new RuntimeException(e);
    }
  }

  // Create isLogin() method to
  // handle the Login button
  public void isLogin() {
    btnLogin.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          // Get text input of the username
          // and password from the text field
          String username = tfUsername.getText();
          String password = new String(pfPassword.getPassword());

          try {
            // Validate if the username and
            // password is empty
            if (username.equals("")) {
              // Show the alert message to tell the
              // user that the username is required
              JOptionPane.showMessageDialog(
                null,
                "Username is required!",
                "Alert",
                JOptionPane.WARNING_MESSAGE
              );
            } else if (password.equals("")) {
              // Show the alert message to tell the
              // user that the password is required
              JOptionPane.showMessageDialog(
                null,
                "Password is required!",
                "Alert",
                JOptionPane.WARNING_MESSAGE
              );
            } else {
              // If the username and password is not
              // empty then validate the input. Hash
              // the password input before validate.
              if (
                username.equals("admin") &&
                getMd5(password).equals("7488e331b8b64e5794da3fa4eb10ad5d")
              ) {
                // Run the Booking() constructor from the Booking
                // class after the admin has been verified
                new Admin();
              } else {
                // Show the alert message if
                // the admin account is invalid
                JOptionPane.showMessageDialog(
                  null,
                  "Invalid admin credentials!",
                  "Alert",
                  JOptionPane.WARNING_MESSAGE
                );
              }
            }
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }
}
