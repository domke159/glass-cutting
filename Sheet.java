/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 */
import java.util.ArrayList;
import java.util.List;

public class Sheet {

  public static final int SHEET_HEIGHT = 250; // sheet height

  public static final int SHEET_WIDTH = 300; // sheet width

  public static final int SHAPE_LIMIT = 20; // maximum number of shapes that can be placed in each sheet (rule F)

  private List<Shelf> shelves = new ArrayList<Shelf>(); // list of shelves

  /**
  * empty constructor
  */
  public Sheet() {
  }

  /**
  * This method is used to add a shelf to a sheet
  * @param a shelf
  */
  public void addShelf(Shelf shelf) {
    shelves.add(shelf);
  }

  /**
  * @return height of all shelves in a sheet
  */
  public int allShelvesHeight() {
    int total = 0;
    for (Shelf shelf : this.shelves) {
      // has a shelf with at least 1 shape
      if (!shelf.getShapes().isEmpty()) {
        // add all shelf height to total
        total += shelf.getHeight();
      }
    }
    return total;
  }

  /**
  * @return list of all shelves in a sheet
  */
  public List<Shelf> getShelves() {
    return this.shelves;
  }
	
  public int getNumberOfShapes() {
    int shapeAmount = 0;
    for (int i = 0; i < this.shelves.size(); i++) {
      shapeAmount += this.shelves.get(i).getShapes().size();
    }
    return shapeAmount;
  }

  /**
  * @return height
  */
  public int getHeight() {
    return SHEET_HEIGHT;
  }

  /**
  * @return width
  */
  public int getWidth() {
    return SHEET_WIDTH ;
  }
	
  // method to print information about a sheet
  public void outputSheetInformation(int sheetNumber) {
    System.out.println();
    System.out.println();
    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
    System.out.format("%53s%d*\n", "*Information about sheet No. ", sheetNumber);
    System.out.format("%24s%d | %s%d | %s%d%s\n", "Height: ", SHEET_HEIGHT, "Width: ", SHEET_WIDTH, "Can store ", SHAPE_LIMIT, " shapes");
    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
    System.out.format("%43s%d%s\n", "This sheet has ", this.getShelves().size(), " shelves");
    System.out.println("======================================================================================");
    for (int i = 0; i < this.getShelves().size(); i++) {
      Shelf currentShelf = this.getShelves().get(i);
      System.out.format("%37s%d%s%d%s\n", "Shelf No. ", (i + 1), " has ", currentShelf.getShapes().size(), " shape(s)");
      System.out.format("%35s%d: %d | %s%d: %d\n", "Height of shelf No. ", (i + 1), currentShelf.getHeight(), "Width of shelf No. ",
	                (i + 1), currentShelf.getWidth());
      System.out.println("**************************************************************************************");
      // print shelf information
      for (int j = 0; j < currentShelf.getShapes().size(); j++) {
        Shape currentShape = currentShelf.getShapes().get(j);
        System.out.println("Height and Width of shape No. " + (j + 1) + " in shelf No. " + (i + 1) + ": " +
                           "Height: " + currentShape.getHeight() + " | " + "Width: " + currentShape.getWidth());
      }
      System.out.println("**************************************************************************************");
    }
  }
}