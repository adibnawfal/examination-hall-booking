package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Home class (subclass) inherits JFrame class (superclass)
public class Home extends JFrame {

  // Create JFrame object component
  // to use for GUI process
  JLabel lblHeader, lblDesc, lblImg, lblService;
  JButton btnBooking, btnAdmin;
  JPanel pnlBooking, pnlAdmin;
  ImageIcon img;

  // No-argument constructor for Home class
  public Home() {
    // Access the JFrame (superclass) constructor
    // with the argument of the frame title
    super("UTHM Examination Hall Booking System");
  }

  // Create runHome() method to be able to
  // display the Home frame from the Main class
  public void runHome() {
    // Run showGUI() method to display
    // the GUI of the Home frame
    showGUI();
    isBooking();
    isAdmin();
    setSize(1100, 380); // Resolution of the frame
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    getContentPane().setBackground(new Color(255, 255, 255));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    // Define the padding of the component
    // with the following arguments rules
    // (top, left, bottom, right)
    gbc.insets = new Insets(0, 0, 0, 640);

    // Create and arrange the header
    // of the frame which is the title
    // and the image
    lblHeader = new JLabel("Examination Hall", JLabel.LEFT);
    gbc.gridx = 0; // Specify the row position
    gbc.gridy = 0; // Specify the column position
    gbc.gridwidth = 2; // Specify the width of the row
    gbc.gridheight = 1; // Specify the height of the column
    add(lblHeader, gbc); // Add the component to the frame

    gbc.insets = new Insets(0, 0, 50, 0);

    lblDesc = new JLabel("Booking System", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    add(lblDesc, gbc);

    img = new ImageIcon(Home.class.getResource("/images/uthm.png"));
    lblImg = new JLabel(img, JLabel.RIGHT);
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    add(lblImg, gbc);

    gbc.insets = new Insets(0, 0, 5, 0);

    // Create and arrange the
    // content of the frame body
    lblService = new JLabel("Select Service", JLabel.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    add(lblService, gbc);

    gbc.insets = new Insets(5, 0, 0, 0);

    btnBooking = new JButton("Book Examination Hall");
    pnlBooking = new JPanel();
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    btnBooking.setPreferredSize(new Dimension(250, 25));
    pnlBooking.add(btnBooking);
    add(pnlBooking, gbc);

    gbc.insets = new Insets(0, 0, 80, 0);

    btnAdmin = new JButton("Admin");
    pnlAdmin = new JPanel();
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    btnAdmin.setPreferredSize(new Dimension(250, 25));
    pnlAdmin.add(btnAdmin);
    add(pnlAdmin, gbc);

    // Styling the font-family, font-weight,
    // and font-size of the label component
    lblHeader.setFont(new Font("Open Sans", Font.BOLD, 18));
    lblDesc.setFont(new Font("Open Sans", Font.PLAIN, 14));
    lblService.setFont(new Font("Open Sans", Font.BOLD, 14));

    // Styling the color of the background
    // and foreground of the component
    lblHeader.setForeground(new Color(48, 38, 130));
    btnBooking.setBackground(new Color(48, 38, 130));
    btnBooking.setForeground(new Color(255, 255, 255));
    btnAdmin.setBackground(new Color(48, 38, 130));
    btnAdmin.setForeground(new Color(255, 255, 255));
    pnlBooking.setBackground(new Color(255, 255, 255));
    pnlAdmin.setBackground(new Color(255, 255, 255));
  }

  // Create isBooking() method to handle
  // the Book Examination Hall button
  public void isBooking() {
    btnBooking.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Run the Booking() constructor from the
            // Booking class to show the Booking frame
            new Booking();
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }

  // Create isAdmin() method
  // to handle the Admin button
  public void isAdmin() {
    btnAdmin.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Run the Login() constructor from the
            // Login class to show the Login frame
            new Login();
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }
}
