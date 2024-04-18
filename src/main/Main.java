package main;

// Main class (subclass) inherits Home class (superclass)
public class Main extends Home {

  public static void main(String[] args) {
    // Create a Main object
    Main main = new Main();

    // Call the runHome() method from
    // the Home class on the main object
    main.runHome();
  }
}
