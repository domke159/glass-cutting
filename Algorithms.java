/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

  /**
  * This method is used to implement the next fit algorithm
  * 
  * @param shapes:a list of shapes representing customer requests(shapes to be
  * cut/placed)
  * @return a list of the sheets used to fulfil all customer requests (i.e.
  * place all the shapes). e.g. if you pass a "shapes" list that has
  * two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
  * of sheets should show us all the information needed (e.g. that
  * one sheet is used, this sheet has one shelf and this shelf has
  * two shapes in it). In the test program, you can use the returned
  * list to retrieve the total number of sheets used.
  **/

  public List<Sheet> nextFit(List<Shape> shapes) {

    /*
    * Start with an empty list of sheets (remember each sheet has a width
    * of 300 and a height of 250 as specified in the Sheet class)
    */
    List<Sheet> usedSheets = new ArrayList<Sheet>();
    // initialise new sheet and shelf objects to keep track of the sheet and shelf that is currently used
    Sheet newSheet = new Sheet();
    Shelf newShelf = new Shelf();
    newSheet.addShelf(newShelf);
    usedSheets.add(newSheet);
		
    int i = 0;
    while (i < shapes.size()) {
      /* if the shelf is empty and sheet's height is greater than or equal to the sum of shape's height and all shelves' height 
      * place the shape on the shelf. 
      */
      if (newShelf.getShapes().isEmpty() && newSheet.getHeight() >= shapes.get(i).getHeight() + newSheet.allShelvesHeight()) {
        newShelf.place(shapes.get(i));
        i++;
      }
      /* if the shelf is empty and sheet's height is lower than the sum of shape's height and all shelves' height then check if 
      * the shape can be rotated by checking if the sheet's height is greater than or equal to the sum of shape's width and 
      * all shelves' height so the shape. If so, then place the shape. 
      */
      else if (newShelf.getShapes().isEmpty() && newSheet.getHeight() < shapes.get(i).getHeight() + newSheet.allShelvesHeight() &&
               newSheet.getHeight() >= shapes.get(i).getWidth() + newSheet.allShelvesHeight()) {
        int height = shapes.get(i).getHeight();
        // swap shape's height and width
        shapes.get(i).setHeight(shapes.get(i).getWidth());
        shapes.get(i).setWidth(height);
        newShelf.place(shapes.get(i));
        i++;
      }
      /* if shelf is empty and sheet's height is lower than the sum of shape's height and all shelves' height and also if sheet's height is lower than
      * the sum of shape's width and shelves' height, remove the last shelf, take a new sheet and add a new shelf to it.s
      */
      else if (newShelf.getShapes().isEmpty() && newSheet.getHeight() < shapes.get(i).getHeight() + newSheet.allShelvesHeight() &&
               newSheet.getHeight() < shapes.get(i).getWidth() + newSheet.allShelvesHeight()) {
        newSheet.getShelves().remove(newSheet.getShelves().size() - 1);
        newSheet = new Sheet();
        newShelf = new Shelf();
        newSheet.addShelf(newShelf);
        usedSheets.add(newSheet);
      }
      /* if the shelf is not empty compare the height and width of the shape with the height and width of the shelf. If they are not greater
      * than the dimensions of the shelf, place the shape.
      */
      else if (shapes.get(i).getHeight() <= newShelf.getHeight() && newShelf.getWidth() + shapes.get(i).getWidth() <= newSheet.getWidth()) {
        newShelf.place(shapes.get(i));
        i++;
      }
      /* if the shelf is not empty and the height of the shape is greater than shelf's height, check if the shape can be rotated by comparing the
      * sum of shelf's width and shape's height with sheet's width and also shape's width with the shelf's height. If all comparisons are true,
      * rotate the shape and place it on the shelf.
      */
      else if (shapes.get(i).getHeight() > newShelf.getHeight() && newShelf.getWidth() + shapes.get(i).getHeight() <= newSheet.getWidth() &&
               shapes.get(i).getWidth() <= newShelf.getHeight()) {
        int height = shapes.get(i).getHeight();
        // swap shape's height and width
        shapes.get(i).setHeight(shapes.get(i).getWidth());
        shapes.get(i).setWidth(height);
        newShelf.place(shapes.get(i));
        i++;
      }
      /* if the shelf is not empty and the sum of the shelf's width and shape's width is greater than sheet's width, check if the shape can be rotated 
      * by comparing the shape's width with shelf's height and also the sum of shape's height and shelf's width with the sheet's width. If all 
      * comparisons are true, rotate the shape and place it on the shelf.
      */
      else if (newShelf.getWidth() + shapes.get(i).getWidth() > newSheet.getWidth() && shapes.get(i).getWidth() <= newShelf.getHeight() &&
               shapes.get(i).getHeight() + newShelf.getWidth() <= newSheet.getWidth()) {
        int width = shapes.get(i).getWidth();
        // swap shape's height and width
        shapes.get(i).setWidth(shapes.get(i).getHeight());
        shapes.get(i).setHeight(width);
        newShelf.place(shapes.get(i));
        i++;
      }
      // if the shape cannot be placed in current shelf, take a new shelf and add the shape
      else {				
        newShelf = new Shelf();
        newSheet.getShelves().add(newShelf);
      }
    }
    return usedSheets;
  }

  /**
  * This method is used to implement the first fit algorithm
  * 
  * @param shapes:a list of shapes representing customer requests (shapes to be
  *            cut/placed)
  * @return a list of the sheets used to fulfil all customer requests (i.e. place
  * all the shapes). e.g. if you pass a "shapes" list that has two
  * shapes {(w=200,h=200),(w=50,h=100)}, then the returned list of
  * sheets should show us all the information needed (e.g. that one
  * sheet is used, this sheet has one shelf and this shelf has two
  * shapes in it). In the test program, you can use the returned list
  * to retrieve the total number of sheets used
  **/
  public List<Sheet> firstFit(List<Shape> shapes) {

    /*
    * Start with an empty list of sheets (remember each sheet has a width
    * of 300 and a height of 250 as specified in the Sheet class)
    */
    List<Sheet> usedSheets = new ArrayList<Sheet>();
    // initialise new sheet and shelf objects to keep track of the sheet and shelf that is currently used
    Sheet newSheet = new Sheet();
    Shelf newShelf = new Shelf();
    newSheet.addShelf(newShelf);
    usedSheets.add(newSheet);
		
    // track the numbers of current shelf and sheet
    int shelfNO = 0;
    int sheetNO = 0;
    int i = 0;
    while (i < shapes.size()) {
      /* if the shelf is empty and sheet's height is greater than or equal to the sum of shape's height and all shelves' height 
      * place the shape on the shelf and set current sheet and shelf to the first sheet and shelf.
      */
      if (newShelf.getShapes().isEmpty() && newSheet.getHeight() >= shapes.get(i).getHeight() + newSheet.allShelvesHeight()) {
        newShelf.place(shapes.get(i));
        newSheet = usedSheets.get(0);
        newShelf = usedSheets.get(0).getShelves().get(0);
        i++;
        shelfNO = 0;
        sheetNO = 0;
      }
      /* if the shelf is empty and sheet's height is lower than the sum of shape's height and all shelves' height then check if 
      * the shape can be rotated by checking if the sheet's height is greater than or equal to the sum of shape's width and 
      * all shelves' height so the shape. If so, then place the shape and set current sheet and shelf to the first sheet and shelf. 
      */
      else if (newShelf.getShapes().isEmpty() && newSheet.getHeight() < shapes.get(i).getHeight() + newSheet.allShelvesHeight() &&
               newSheet.getHeight() >= shapes.get(i).getWidth() + newSheet.allShelvesHeight()) {
        int height = shapes.get(i).getHeight();
        // swap shape's height and width
        shapes.get(i).setHeight(shapes.get(i).getWidth());
        shapes.get(i).setWidth(height);
        newShelf.place(shapes.get(i));
        newSheet = usedSheets.get(0);
        newShelf = usedSheets.get(0).getShelves().get(0);
        i++;
        shelfNO = 0;
        sheetNO = 0;
      }
      /* if shelf is empty and sheet's height is lower than the sum of shape's height and all shelves' height and also if sheet's height is lower than
      * the sum of shape's width and shelves' height, remove the last shelf, take a new sheet and add a new shelf to it.
      */
      else if (newShelf.getShapes().isEmpty() && newSheet.getHeight() < shapes.get(i).getHeight() + newSheet.allShelvesHeight() &&
        newSheet.getHeight() < shapes.get(i).getWidth() + newSheet.allShelvesHeight()) {
        newSheet.getShelves().remove(newSheet.getShelves().size() - 1);
        newSheet = new Sheet();
        newShelf = new Shelf();
        newSheet.addShelf(newShelf);
        usedSheets.add(newSheet);
      }
      /* if the shelf is not empty compare the height and width of the shape with the height and width of the shelf. If they are not greater
      * than the dimensions of the shelf, place the shape and set current sheet and shelf to the first sheet and shelf.
      */
      else if (shapes.get(i).getHeight() <= newShelf.getHeight() && newShelf.getWidth() + shapes.get(i).getWidth() <= newSheet.getWidth()) {
        newShelf.place(shapes.get(i));
        newSheet = usedSheets.get(0);
        newShelf = usedSheets.get(0).getShelves().get(0);
        i++;
        shelfNO = 0;
        sheetNO = 0;
      }
      /* if the shelf is not empty and the height of the shape is greater than shelf's height, check if the shape can be rotated by comparing the
      * sum of shelf's width and shape's height with sheet's width and also shape's width with the shelf's height. If all comparisons are true,
      * rotate the shape, place it on the shelf and set current sheet and shelf to the first sheet and shelf.
      */
      else if (shapes.get(i).getHeight() > newShelf.getHeight() && newShelf.getWidth() + shapes.get(i).getHeight() <= newSheet.getWidth() &&
               shapes.get(i).getWidth() <= newShelf.getHeight()) {
        int height = shapes.get(i).getHeight();
        // swap shape's height and width
        shapes.get(i).setHeight(shapes.get(i).getWidth());
        shapes.get(i).setWidth(height);
        newShelf.place(shapes.get(i));
        newSheet = usedSheets.get(0);
        newShelf = usedSheets.get(0).getShelves().get(0);
        i++;
        shelfNO = 0;
        sheetNO = 0;
      }
      /* if the shelf is not empty and the sum of the shelf's width and shape's width is greater than sheet's width, check if the shape can be rotated 
      * by comparing the shape's width with shelf's height and also the sum of shape's height and shelf's width with the sheet's width. If all 
      * comparisons are true, rotate the shape, place it on the shelf and set current sheet and shelf to the first sheet and shelf.
      */
      else if (newShelf.getWidth() + shapes.get(i).getWidth() > newSheet.getWidth() && shapes.get(i).getWidth() <= newShelf.getHeight() &&
               shapes.get(i).getHeight() + newShelf.getWidth() <= newSheet.getWidth()) {
        int width = shapes.get(i).getWidth();
        // swap shape's height and width
        shapes.get(i).setWidth(shapes.get(i).getHeight());
        shapes.get(i).setHeight(width);
        newShelf.place(shapes.get(i));
        newSheet = usedSheets.get(0);
        newShelf = usedSheets.get(0).getShelves().get(0);
        i++;
        shelfNO = 0;
        sheetNO = 0;
      }
      /* if there are more than 1 sheets and next sheet's shelves are not empty check if the sum of shape's height and current sheet's shelves' height is 
      * greater than current sheet's height, also check if the sum of shape's width and current shelve's height is greater than current sheet's height.
      * If all comparisons are true move to the next sheet and set the current shelf to the first shelf of that next sheet.
      */
      else if (usedSheets.size() > sheetNO + 1 && !usedSheets.get(sheetNO + 1).getShelves().isEmpty() &&
               shapes.get(i).getHeight() + newSheet.allShelvesHeight() > newSheet.getHeight() &&
               shapes.get(i).getWidth() + newSheet.allShelvesHeight() > newSheet.getHeight()) {
        sheetNO++;
        newSheet = usedSheets.get(sheetNO);
        newShelf = usedSheets.get(sheetNO).getShelves().get(0);
      }
      /* if current sheet's size is greater than the current shelf's index and the next shelf is not empty, move to the next shelf.*/
      else if (newSheet.getShelves().size() > shelfNO + 1 && !newSheet.getShelves().get(shelfNO + 1).getShapes().isEmpty()) {
        shelfNO++;
        newShelf = newSheet.getShelves().get(shelfNO);
      }
      // if the shape cannot be placed in current shelf, take a new shelf and add the shape
      else {
        newShelf = new Shelf();
        newSheet.getShelves().add(newShelf);
      }
    }
    return usedSheets;
  }
}
