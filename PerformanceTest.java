import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 */

public class PerformanceTest {

  public static void main(String[] args) {

  System.out.println("***********************************************");
  System.out.println("*********** Performance analysis **************");
  System.out.println("**********************************************");
  System.out.println();
  /*
   * You must complete the Generator class in order to generate a random
   * test values. You must complete the Algorithms class in order to call
   * the two algorithms.
   * 
   * You can use any additional method you created in this class
  */
		

  /**
   * Remember: You need to calculate the time and number of sheets used
   * for each run of each algorithm.
   * 
   * You are expected to run several tests (e.g. noOfTests=5) of your
   * programs for, 10000, 20000, 30000, 40000, 50000 shapes
   * (noOfShapes=10000, increment=10000) so that one can see how the
   * algorithms perform for large datasets.
   * 
   * You are expected to run the same test a number of times to ensure
   * accurate result (noOfRep=4). In this case, you need to calculate the
   * average time and sheets needed for each run
   **/

  // total number of tests - you need to CHANGE this value
  int noOfTests = 5;

  // number of repetitions for each test - you need to CHANGE this value
  int noOfRep = 4;

  // number of shapes needed for the first run - you need to CHANGE this
  // value
  int noOfShapes = 10000;

  // the increment in the number of shapes - you need to CHANGE this value
  int increment = 10000;
		
  Generator generator = new Generator();
  // separate lists to ensure that shapes are the same for Next Fit and First algorithms as the values of width and height might be swapped in algorithms
  List<Shape> nextFitShapeList;
  List<Shape> firstFitShapeList;
  List<Sheet> usedSheets;
  Algorithms algorithms = new Algorithms();
		
  long startTime;
  long endTime;
		
  long nextFitRunningTime = 0;
  long firstFitRunningTime = 0;
  int nextFitUsedSheets = 0;
  int firstFitUsedSheets = 0;
		
  System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>"+
		     "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
  System.out.format("%90s*\n", "*Next Fit and First Fit algorithms performance test");
  System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>"+
                     "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
  System.out.println();
		
  for (int i = 0; i < noOfTests; i ++) {
			
    for (int j = 0; j < noOfRep; j++) {
      // generate a list of shapes
      nextFitShapeList = generator.generateShapeList(noOfShapes);
      firstFitShapeList = nextFitShapeList;
				
      // track run time of Next Fit algorithm
      startTime = System.nanoTime();
      usedSheets = algorithms.nextFit(nextFitShapeList);
      endTime = System.nanoTime();
      // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm
      nextFitUsedSheets += usedSheets.size();
      nextFitRunningTime += (endTime - startTime) / 1000000;
				
      // track run time of First Fit algorithm
      startTime = System.nanoTime();
      usedSheets = algorithms.firstFit(firstFitShapeList);
      endTime = System.nanoTime();
      // increase used sheets size and total running time (in milliseconds) for First Fit algorithm
      firstFitUsedSheets += usedSheets.size();
      firstFitRunningTime += (endTime - startTime) / 1000000;		
    }
			
      System.out.println("================================================================================="+ 
                         "=========================================================");
      System.out.format("%50s%d%s%d%s\n", "The algorithms were run ", noOfRep, " times using newly generated ", noOfShapes, " shapes each time");
      System.out.println("================================================================================="+
      			 "=========================================================");
      System.out.println("On average, the time it took to run Next Fit algorithm was: " + nextFitRunningTime / noOfRep  +
       			 " | On average, " + nextFitUsedSheets / noOfRep + " sheets were used to store the shapes");
      System.out.println("---------------------------------------------------------------------------------"+
      			 "---------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm was: " + firstFitRunningTime / noOfRep +
      			 " | On average, " + firstFitUsedSheets / noOfRep + " sheets were used to store the shapes");
      System.out.println("================================================================================="+
      			 "=========================================================");
      System.out.println();
			
      // reset values to 0
      nextFitUsedSheets = 0;
      nextFitRunningTime = 0;
      firstFitUsedSheets = 0;
      firstFitRunningTime = 0;
      // increment number of shapes
      noOfShapes += increment;
    }
  }
}
