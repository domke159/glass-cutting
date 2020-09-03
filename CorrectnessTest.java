import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author Dominykas Mickevicius | Student ID: 180387629
 */

public class CorrectnessTest {
  public static void main(String[] args) {
    System.out.println("*********************************************");
    System.out.println("*********** Correctness testing *************");
    System.out.println("*********************************************");
    System.out.println();

    /*
    * Here you will need to validate that your algorithms (nextFit() and
    * firstFit()) behave as expected on small data sets. 
    * Think about normal cases and border cases. 
    * You can use any additional method you created in this class
    */
		
    // create a list with shapes (tested by drawing on paper)
    List<Shape> shapeList1 = new ArrayList<>();
    Shape shape1 = new Shape(254, 91);
    shapeList1.add(shape1);
    Shape shape2 = new Shape(96, 222);
    shapeList1.add(shape2);
    Shape shape3 = new Shape(115, 72);
    shapeList1.add(shape3);
    Shape shape4 = new Shape(45, 167);
    shapeList1.add(shape4);
    Shape shape5 = new Shape(146, 216);
    shapeList1.add(shape5);
    Shape shape6 = new Shape(12, 248);
    shapeList1.add(shape6);
    Shape shape7 = new Shape(59, 222);
    shapeList1.add(shape7);
    Shape shape8 = new Shape(272, 24);
    shapeList1.add(shape8);
    Shape shape9 = new Shape(280, 73);
    shapeList1.add(shape9);
    Shape shape10 = new Shape(262, 153);
    shapeList1.add(shape10);
		
    // create a list with shapes (tested by drawing on paper)
    List<Shape> shapeList2 = new ArrayList<>();
    shape1 = new Shape(150, 150);
    shapeList2.add(shape1);
    shape2 = new Shape(15, 101);
    shapeList2.add(shape2);
    shape3 = new Shape(290, 50);
    shapeList2.add(shape3);
    shape4 = new Shape(10, 10);
    shapeList2.add(shape4);
    shape5 = new Shape(190, 30);
    shapeList2.add(shape5);
    shape6 = new Shape(145, 90);
    shapeList2.add(shape6);
    shape7 = new Shape(70, 20);
    shapeList2.add(shape7);
    shape8 = new Shape(35, 40);
    shapeList2.add(shape8);
    shape9 = new Shape(110, 13);
    shapeList2.add(shape9);
    shape10 = new Shape(210, 100);
    shapeList2.add(shape10);
		
    // create a list with shapes that have dimensions 1x1 to see if all of them are placed on the first shelf
    List<Shape> shapeList3 = new ArrayList<>();
    shape1 = new Shape(1, 1);
    shapeList3.add(shape1);
    shape2 = new Shape(1, 1);
    shapeList3.add(shape2);
    shape3 = new Shape(1, 1);
    shapeList3.add(shape3);
    shape4 = new Shape(1, 1);
    shapeList3.add(shape4);
    shape5 = new Shape(1, 1);
    shapeList3.add(shape5);
    shape6 = new Shape(1, 1);
    shapeList3.add(shape6);
    shape7 = new Shape(1, 1);
    shapeList3.add(shape7);
    shape8 = new Shape(1, 1);
    shapeList3.add(shape8);
    shape9 = new Shape(1, 1);
    shapeList3.add(shape9);
    shape10 = new Shape(1, 1);
    shapeList3.add(shape10);
		
    // create a list with shapes that have dimensions 1x1 to see if all of them are placed in a new sheet
    List<Shape> shapeList4 = new ArrayList<>();
    shape1 = new Shape(300, 250);
    shapeList4.add(shape1);
    shape2 = new Shape(300, 250);
    shapeList4.add(shape2);
    shape3 = new Shape(300, 250);
    shapeList4.add(shape3);
    shape4 = new Shape(300, 250);
    shapeList4.add(shape4);
    shape5 = new Shape(300, 250);
    shapeList4.add(shape5);
    shape6 = new Shape(300, 250);
    shapeList4.add(shape6);
    shape7 = new Shape(300, 250);
    shapeList4.add(shape7);
    shape8 = new Shape(300, 250);
    shapeList4.add(shape8);
    shape9 = new Shape(300, 250);
    shapeList4.add(shape9);
    shape10 = new Shape(300, 250);
    hapeList4.add(shape10);
		
    // create a list with shapes that have dimensions 1x1 to see if all of them are placed in a new sheet
    List<Shape> shapeList5 = new ArrayList<>();
    shape1 = new Shape(150, 100);
    shapeList5.add(shape1);
    shape2 = new Shape(151, 101);
    shapeList5.add(shape2);
    shape3 = new Shape(152, 102);
    shapeList5.add(shape3);
    shape4 = new Shape(153, 103);
    shapeList5.add(shape4);
    shape5 = new Shape(154, 104);
    shapeList5.add(shape5);
    shape6 = new Shape(155, 105);
    shapeList5.add(shape6);
    shape7 = new Shape(156, 106);
    shapeList5.add(shape7);
    shape8 = new Shape(157, 107);
    shapeList5.add(shape8);
    shape9 = new Shape(158, 108);
    shapeList5.add(shape9);
    shape10 = new Shape(159, 109);
    shapeList5.add(shape10);
		
    // create a new shape list and change it to the list that needs to be tested
    List<Shape> shapeList = new ArrayList<>();
    // change the number of the list to test different list
    shapeList = shapeList1;
		
    // print information about shapes
    System.out.format("%22s", "Shapes dimensions\n");
    System.out.println("=========================");
    for (int i = 0; i < shapeList.size(); i++) {
      System.out.println("Width: " +  shapeList.get(i).getWidth() + " | " + "Height: " + shapeList.get(i).getHeight());
    }
    System.out.println("=========================");
    System.out.println();
    System.out.println();
		
    // print Next Fit algorithm results
    Algorithms a = new Algorithms();
    List<Sheet> usedSheets = new ArrayList<>();
    System.out.format("%53s", "Next Fit algorithm results\n");
    usedSheets = a.nextFit(shapeList);
    for (int i = 0; i < usedSheets.size(); i++) {
      usedSheets.get(i).outputSheetInformation(i+1);
    }
    System.out.println();
    System.out.println();
		
    // print First Fit algorithm results
    System.out.format("%53s", "First Fit algorithm results\n");
    usedSheets = a.firstFit(shapeList);
    for (int i = 0; i < usedSheets.size(); i++) {
      usedSheets.get(i).outputSheetInformation(i+1);
    }
  }
}
