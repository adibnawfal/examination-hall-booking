package data;

import data.Booked;
import java.io.*;
import java.util.ArrayList;

// Suppress warning created by the in.readObject()
// since I didn't find any solution to avoid it.
// So far this is the temporary solution found in the forum
@SuppressWarnings("unchecked")
// Booking class (subclass) inherits JFrame class (superclass)
public class BookedData {

  // Create a ArrayList attribute to use
  // in the BookedData class
  ArrayList<Booked> bookedData = new ArrayList<Booked>();

  // Find the classpath of the class file
  // to create a path to booked.ser file
  final File classPath = new File(
    BookedData.class.getProtectionDomain()
      .getCodeSource()
      .getLocation()
      .getPath()
  );

  // Create a path for booked.ser file
  final String filePath = classPath + "\\tmp\\booked.ser";

  // Create getBookedData() method to get
  // the booked data from the booked.ser file
  public ArrayList<Booked> getBookedData() {
    // Create a temporary ArrayList data
    ArrayList<Booked> tempData = new ArrayList<Booked>();
    File f = new File(filePath);

    try {
      // Create the booked.ser file in the filePath
      // directory if the file is not found
      if (!f.isFile()) {
        f.createNewFile();
      }

      // Reading the booked data from the booked.ser file
      FileInputStream file = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(file);

      // Method to deserialize the booked data
      tempData = (ArrayList<Booked>) in.readObject();
      in.close();
      file.close();

      // Update the booked data with
      // the temporary data
      bookedData = tempData;
    } catch (IOException i) {
      System.out.println("Data is empty!");
    } catch (ClassNotFoundException c) {
      System.out.println("Booked class not found!");
    }

    return tempData;
  }

  // Create setBookedData() method to update
  // the booked data into  the booked.ser file
  public void setBookedData(ArrayList<Booked> bookedData) {
    try {
      // Saving the serialized booked data into the booked.ser
      FileOutputStream file = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(file);

      // Method to serialize the booked data
      out.writeObject(bookedData);
      out.close();
      file.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }
}
