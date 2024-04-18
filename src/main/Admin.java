package main;

import data.Booked;
import data.BookedData;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

// Admin class (subclass) inherits JFrame class (superclass)
public class Admin extends JFrame {

  // Create a BookedData object
  BookedData db = new BookedData();

  // Create JFrame object component
  // to use for GUI process
  JLabel lblHeader, lblDesc, lblImg, lblBookingLog;
  JTextArea taBookingLog;
  JButton btnListAll, btnListPending, btnListApproved, btnApproved;
  JPanel pnlButton;
  ImageIcon img;

  // No-argument constructor for Admin class
  public Admin() {
    // Access the JFrame (superclass) constructor
    // with the argument of the frame title
    super("Admin");
    // Run showGUI() method to display
    // the GUI of the Home frame
    showGUI();
    // Run displayData() method to
    // display the saved booked data
    displayData("All");
    isListAll();
    isListPending();
    isListApproved();
    isApproved();
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
    gbc.gridwidth = 2; // Specify the width of the row
    gbc.gridheight = 1; // Specify the height of the column
    add(lblHeader, gbc); // Add the component to the frame

    // Define the padding of the component
    // with the following arguments rules
    // (top, left, bottom, right)
    gbc.insets = new Insets(0, 0, 50, 0);

    lblDesc = new JLabel("Booking System", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    add(lblDesc, gbc);

    gbc.insets = new Insets(0, 140, 50, 0);

    img = new ImageIcon(Admin.class.getResource("/images/uthm.png"));
    lblImg = new JLabel(img, JLabel.RIGHT);
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    add(lblImg, gbc);

    gbc.insets = new Insets(0, 0, 5, 0);

    // Create and arrange the
    // content of the frame body
    lblBookingLog = new JLabel("Booking Log", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 4;
    gbc.gridheight = 1;
    add(lblBookingLog, gbc);

    gbc.insets = new Insets(5, 0, 0, 0);

    taBookingLog = new JTextArea(7, 60);
    taBookingLog.setLineWrap(true);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 4;
    gbc.gridheight = 4;
    add(taBookingLog, gbc);

    gbc.insets = new Insets(10, 0, 0, 30);

    btnListAll = new JButton("List All Booked Data");
    btnListPending = new JButton("List All Pending Data");
    btnListApproved = new JButton("List All Approved Data");
    btnApproved = new JButton("Approve Booking");
    pnlButton = new JPanel();
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    pnlButton.add(btnListAll);
    pnlButton.add(btnListPending);
    pnlButton.add(btnListApproved);
    pnlButton.add(btnApproved);
    add(pnlButton, gbc);

    // Styling the font-family, font-weight,
    // and font-size of the label component
    lblHeader.setFont(new Font("Open Sans", Font.BOLD, 18));
    lblDesc.setFont(new Font("Open Sans", Font.PLAIN, 14));
    lblBookingLog.setFont(new Font("Open Sans", Font.BOLD, 14));

    // Styling the color of the background
    // and foreground of the component
    lblHeader.setForeground(new Color(48, 38, 130));
    taBookingLog.setBackground(new Color(217, 217, 217));
    btnListAll.setBackground(new Color(48, 38, 130));
    btnListAll.setForeground(new Color(255, 255, 255));
    btnListPending.setBackground(new Color(48, 38, 130));
    btnListPending.setForeground(new Color(255, 255, 255));
    btnListApproved.setBackground(new Color(48, 38, 130));
    btnListApproved.setForeground(new Color(255, 255, 255));
    btnApproved.setBackground(new Color(48, 38, 130));
    btnApproved.setForeground(new Color(255, 255, 255));
    pnlButton.setBackground(new Color(255, 255, 255));
  }

  // Create displayData() method to
  // display the saved booked data
  public void displayData(String condition) {
    // Create a temporary ArrayList data with
    // the content of the latest saved data
    ArrayList<Booked> tempData = new ArrayList<Booked>(db.getBookedData());

    // Create a header string
    // as a title of the each data
    String rowHeader =
      "No.\tFull Name\t\tMatric\\Staff No.\tDate\tTime\tStatus\n";
    String arrayString = "", joinedString = "";

    // Display the booked data based on
    // which button has been clicked
    switch (condition) {
      // Display the pending staus
      // of the booked data
      case "Pending":
        for (Booked x : tempData) {
          if (x.getStatus().equals("Pending")) {
            // Create table of data as a string to
            // display in the JtextArea component
            arrayString +=
              x.getNo() +
              "\t" +
              x.getFullName() +
              "\t" +
              x.getIdNo() +
              "\t" +
              x.getDate() +
              "\t" +
              x.getTime() +
              "\t" +
              x.getStatus() +
              "\n";
          }
        }
        break;
      // Display the approved staus
      // of the booked data
      case "Approved":
        for (Booked x : tempData) {
          if (x.getStatus().equals("Approved")) {
            // Create table of data as a string to
            // display in the JtextArea component
            arrayString +=
              x.getNo() +
              "\t" +
              x.getFullName() +
              "\t" +
              x.getIdNo() +
              "\t" +
              x.getDate() +
              "\t" +
              x.getTime() +
              "\t" +
              x.getStatus() +
              "\n";
          }
        }
        break;
      // Display all of the saved booked data
      default:
        for (Booked x : tempData) {
          // Create table of data as a string to
          // display in the JtextArea component
          arrayString +=
            x.getNo() +
            "\t" +
            x.getFullName() +
            "\t" +
            x.getIdNo() +
            "\t" +
            x.getDate() +
            "\t" +
            x.getTime() +
            "\t" +
            x.getStatus() +
            "\n";
        }
    }

    // Concat the header and table of data
    // to display in the JTextArea component
    joinedString = rowHeader + arrayString;
    taBookingLog.setText(joinedString);
  }

  // Create isListAll() method to handle
  // the List All Booked Data button
  public void isListAll() {
    btnListAll.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Run the displayData() method with the
            // "All" arguments to dispay all of the
            // saved booked data
            displayData("All");
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }

  // Create isListPending() method to handle
  // the List All Pending Data button
  public void isListPending() {
    btnListPending.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Run the displayData() method with the
            // "Pending" arguments to dispay all of the
            // pending booked data
            displayData("Pending");
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }

  // Create isListApproved() method to handle
  // the List All Approved Data button
  public void isListApproved() {
    btnListApproved.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Run the displayData() method with the
            // "Approved" arguments to dispay all of the
            // approved booked data
            displayData("Approved");
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }

  // Create isApproved() method to
  // handle the Approve Booking button
  public void isApproved() {
    btnApproved.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          // Create a temporary ArrayList data with
          // the content of the latest saved data
          ArrayList<Booked> tempData = new ArrayList<Booked>(
            db.getBookedData()
          );

          try {
            // Show input dialog to let the admin input
            // the booking no. that need to approved
            String input = JOptionPane.showInputDialog(
              null,
              "Enter booking number you want to approved"
            );

            // Convert the input of the dialog to the int
            // to be able to compare with the data index
            int index = Integer.parseInt(input);
            boolean approved = false;

            for (Booked x : tempData) {
              // If the booking no. equals with the
              // input index, then validate the data status
              if (x.getNo() == index) {
                // If the data status equals with the "Pending"
                // status, then change the data status
                if (x.getStatus().equals("Pending")) {
                  tempData.set(
                    index - 1, // Minus 1 to get the array index
                    new Booked(
                      x.getNo(),
                      x.getFullName(),
                      x.getIdNo(),
                      x.getDate(),
                      x.getTime(),
                      "Approved" // Change the status of the selected index
                    )
                  );

                  // Change the approved to true to be able
                  // to validate if the status is changed
                  approved = true;
                }
              }
            }

            // Validate if the approved process has been run
            if (approved) {
              // Set the booked data with the temporary
              // data to update the saved data
              db.setBookedData(tempData);
              // Show the message dialog to tell the
              // user that the booking status has been changed
              JOptionPane.showMessageDialog(null, "Booking approved.");
            } else {
              // Show the alert message to tell the
              // user that the index input is invalid
              JOptionPane.showMessageDialog(
                null,
                "Invalid input!",
                "Alert",
                JOptionPane.WARNING_MESSAGE
              );
            }

            // Run the displayData() method with the
            // "All" arguments to display all of the
            // saved booked data
            displayData("All");
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
  }
}
