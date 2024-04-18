package main;

import data.Booked;
import data.BookedData;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

// Booking class (subclass) inherits JFrame class (superclass)
public class Booking extends JFrame {

  // Create a BookedData object
  BookedData db = new BookedData();

  // Create JFrame object component
  // to use for GUI process
  JLabel lblHeader, lblDesc, lblImg, lblBookingForm, lblFullName, lblIdNo, lblDate, lblTime, lblBooked;
  JTextField tfFullName, tfIdNo;
  JComboBox<String> cbDate, cbTime;
  JTextArea taBooked;
  JButton btnSubmit, btnListAll, btnListPending, btnListApproved, btnCancel;
  JPanel pnlSubmit, pnlButton;
  ImageIcon img;

  // Create attributes of date to use
  // in date JComboBox component
  String[] date = {
    "1/2/2023",
    "2/2/2023",
    "3/2/2023",
    "4/2/2023",
    "5/2/2023",
    "6/2/2023",
    "7/2/2023",
    "8/2/2023",
    "9/2/2023",
    "10/2/2023",
    "11/2/2023",
    "12/2/2023",
    "13/2/2023",
    "14/2/2023",
    "15/2/2023",
    "16/2/2023",
    "17/2/2023",
    "18/2/2023",
    "19/2/2023",
    "20/2/2023",
    "21/2/2023",
    "22/2/2023",
    "23/2/2023",
    "24/2/2023",
    "25/2/2023",
    "26/2/2023",
    "27/2/2023",
    "28/2/2023",
  };

  // Create attributes of time to use
  // in time JComboBox component
  String[] time = { "08:00", "10:00", "12:00", "14:00", "16:00" };

  // No-argument constructor for Booking class
  public Booking() {
    // Access the JFrame (superclass) constructor
    // with the argument of the frame title
    super("Booking");
    // Run showGUI() method to display
    // the GUI of the Home frame
    showGUI();
    // Run displayData() method to
    // display the saved booked data
    displayData("All");
    isSubmit();
    isListAll();
    isListPending();
    isListApproved();
    isCancel();
    setSize(1100, 380);
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

    gbc.insets = new Insets(0, 0, 5, 0);

    // Create and arrange the
    // content of the frame body
    lblBookingForm = new JLabel("Booking Form", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    add(lblBookingForm, gbc);

    gbc.insets = new Insets(5, 0, 0, 30);

    lblFullName = new JLabel("Full Name", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblFullName, gbc);

    tfFullName = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(tfFullName, gbc);

    lblIdNo = new JLabel("Matric/Staff No.", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblIdNo, gbc);

    tfIdNo = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(tfIdNo, gbc);

    lblDate = new JLabel("Select Date", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblDate, gbc);

    cbDate = new JComboBox<>(date);
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(cbDate, gbc);

    lblTime = new JLabel("Select Time", JLabel.LEFT);
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(lblTime, gbc);

    cbTime = new JComboBox<>(time);
    gbc.gridx = 1;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    add(cbTime, gbc);

    gbc.insets = new Insets(10, 0, 0, 30);

    btnSubmit = new JButton("Submit");
    pnlSubmit = new JPanel();
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    btnSubmit.setPreferredSize(new Dimension(250, 25));
    pnlSubmit.add(btnSubmit);
    add(pnlSubmit, gbc);

    gbc.insets = new Insets(0, 0, 50, 0);

    img = new ImageIcon(Booking.class.getResource("/images/uthm.png"));
    lblImg = new JLabel(img, JLabel.RIGHT);
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    add(lblImg, gbc);

    gbc.insets = new Insets(0, 0, 5, 0);

    lblBooked = new JLabel("Booked Date and Time", JLabel.LEFT);
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    add(lblBooked, gbc);

    gbc.insets = new Insets(5, 0, 0, 0);

    taBooked = new JTextArea(7, 60);
    taBooked.setLineWrap(true);
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    gbc.gridheight = 4;
    add(taBooked, gbc);

    gbc.insets = new Insets(10, 0, 0, 0);

    btnListAll = new JButton("List All Booked Data");
    btnListPending = new JButton("List All Pending Data");
    btnListApproved = new JButton("List All Approved Data");
    btnCancel = new JButton("Cancel Booking");
    pnlButton = new JPanel();
    gbc.gridx = 2;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    pnlButton.add(btnListAll);
    pnlButton.add(btnListPending);
    pnlButton.add(btnListApproved);
    pnlButton.add(btnCancel);
    add(pnlButton, gbc);

    // Styling the font-family, font-weight,
    // and font-size of the label component
    lblHeader.setFont(new Font("Open Sans", Font.BOLD, 18));
    lblDesc.setFont(new Font("Open Sans", Font.PLAIN, 14));
    lblBookingForm.setFont(new Font("Open Sans", Font.BOLD, 14));
    lblFullName.setFont(new Font("Open Sans", Font.BOLD, 12));
    lblIdNo.setFont(new Font("Open Sans", Font.BOLD, 12));
    lblDate.setFont(new Font("Open Sans", Font.BOLD, 12));
    lblTime.setFont(new Font("Open Sans", Font.BOLD, 12));
    lblBooked.setFont(new Font("Open Sans", Font.BOLD, 14));

    // Styling the color of the background
    // and foreground of the component
    lblHeader.setForeground(new Color(48, 38, 130));
    tfFullName.setBackground(new Color(217, 217, 217));
    tfIdNo.setBackground(new Color(217, 217, 217));
    cbDate.setBackground(new Color(217, 217, 217));
    cbTime.setBackground(new Color(217, 217, 217));
    btnSubmit.setBackground(new Color(48, 38, 130));
    btnSubmit.setForeground(new Color(255, 255, 255));
    pnlSubmit.setBackground(new Color(255, 255, 255));
    taBooked.setBackground(new Color(217, 217, 217));
    btnListAll.setBackground(new Color(48, 38, 130));
    btnListAll.setForeground(new Color(255, 255, 255));
    btnListPending.setBackground(new Color(48, 38, 130));
    btnListPending.setForeground(new Color(255, 255, 255));
    btnListApproved.setBackground(new Color(48, 38, 130));
    btnListApproved.setForeground(new Color(255, 255, 255));
    btnCancel.setBackground(new Color(48, 38, 130));
    btnCancel.setForeground(new Color(255, 255, 255));
    pnlButton.setBackground(new Color(255, 255, 255));
  }

  // Create displayDaya() method to
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
          // display in the JtextArea componen
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
    taBooked.setText(joinedString);
  }

  // Create isSubmit() method to
  // handle the Submit button
  public void isSubmit() {
    btnSubmit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try {
            // Create a temporary ArrayList data with
            // the content of the latest saved data
            ArrayList<Booked> tempData = new ArrayList<Booked>(
              db.getBookedData()
            );

            // Get booking details from the form
            int no = tempData.size() + 1;
            String fullName = tfFullName.getText();
            String idNo = tfIdNo.getText();
            String date = (String) cbDate.getSelectedItem();
            String time = (String) cbTime.getSelectedItem();
            boolean alreadyBooked = false;

            // Validate if the fullName and
            // matric/staff no. is empty
            if (fullName.equals("")) {
              // Show the alert message to tell the
              // user that the full name is required
              JOptionPane.showMessageDialog(
                null,
                "Full name is required!",
                "Alert",
                JOptionPane.WARNING_MESSAGE
              );
            } else if (idNo.equals("")) {
              // Show the alert message to tell the
              // user that the matric/staff no. is required
              JOptionPane.showMessageDialog(
                null,
                "Matric/Staff No. is required!",
                "Alert",
                JOptionPane.WARNING_MESSAGE
              );
            } else {
              // Set alreadyBooked to true if the
              // selected date and time is already booked
              for (Booked x : tempData) {
                if (x.getDate().equals(date)) {
                  if (x.getTime().equals(time)) {
                    alreadyBooked = true;
                  }
                }
              }

              // Validate if alreadyBooked is true
              if (!alreadyBooked) {
                // Set the temporary data with the
                // booking data input by the user
                tempData.add(
                  new Booked(no, fullName, idNo, date, time, "Pending")
                );
                // Set the booked data with the temporary
                // data to update the saved data
                db.setBookedData(tempData);
              } else {
                // Show the alert message to tell the
                // user that the selected date and
                // time is already booked
                JOptionPane.showMessageDialog(
                  null,
                  "The selected date and time is already booked!",
                  "Alert",
                  JOptionPane.WARNING_MESSAGE
                );
              }

              // Run the displayData() method with the
              // "All" arguments to display all of the
              // saved booked data
              displayData("All");
            }
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      }
    );
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

  // Create isCancel() method to
  // handle the Cancel Booking button
  public void isCancel() {
    btnCancel.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          // Create a temporary ArrayList data with
          // the content of the latest saved data
          ArrayList<Booked> tempData = new ArrayList<Booked>(
            db.getBookedData()
          );

          // Create a new of ArrayList data
          ArrayList<Booked> newData = new ArrayList<Booked>();

          try {
            // Show input dialog to let the user input
            // the booking no. that need to cancel
            String input = JOptionPane.showInputDialog(
              null,
              "Enter booking number you want to cancel"
            );

            // Convert the input of the dialog to the int
            // to be able to compare with the data index
            int index = Integer.parseInt(input);
            int i = 1;
            boolean remove = false;

            for (Booked x : tempData) {
              // Validate if the booking no.
              // equals with the input index
              if (x.getNo() == index) {
                // Change the remove to true to if the
                // booking no. equals with the input index
                remove = true;
              }
            }

            // Validate if the remove is true to
            // proceed with the remove process
            if (remove) {
              // Minus 1 to remove the selected index array
              tempData.remove(index - 1);

              for (Booked x : tempData) {
                // Update the index of the remaining data
                // by assign the new data with the remaining
                // temporary data
                newData.add(
                  new Booked(
                    i++, // Make the booking no. to auto increment
                    x.getFullName(),
                    x.getIdNo(),
                    x.getDate(),
                    x.getTime(),
                    x.getStatus()
                  )
                );
              }

              // Set the booked data with the new
              // data to update the saved data
              db.setBookedData(newData);
              // Show the message dialog to tell the
              // user that the booking has been cancelled
              JOptionPane.showMessageDialog(null, "Booking cancelled.");
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
}
