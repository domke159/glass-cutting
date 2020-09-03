import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 */

public class SortedTest {
	
  public static void main(String[] args) {
    System.out.println("*********************************************");
    System.out.println("**************** Sorted Test ****************");
    System.out.println("*********************************************");
    System.out.println();

    /*
    * Generate a random shape list and then check the number of sheets used
    * when
    ** this shape list is passed un-sorted
    ** the list is sorted based on different criteria as set in the speciication document.
    * 
    * run several tests for different sizes of the "list of shapes" 
    */

    /*
    * HINT: you might want to implements the comparTo method in the Shape
    * class or implement the Comparator Interface to do the sorting
    */
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
    /* separate lists to ensure that shapes are the same for Next Fit and First algorithms in different sorting as the values
    * of width and height might be swapped in algorithms
    */
    List<Shape> nextFitUnsortedShapeList;
    List<Shape> firstFitUnsortedShapeList;
    List<Shape> nextFitIncrSortedHeightShapeList;
    List<Shape> firstFitIncrSortedHeightShapeList;
    List<Shape> nextFitDecrSortedHeightShapeList;
    List<Shape> firstFitDecrSortedHeightShapeList;
    List<Shape> nextFitIncrSortedWidthShapeList;
    List<Shape> firstFitIncrSortedWidthShapeList;
    List<Shape> nextFitDecrSortedWidthShapeList;
    List<Shape> firstFitDecrSortedWidthShapeList;
    List<Shape> nextFitIncrSortedAreaShapeList;
    List<Shape> firstFitIncrSortedAreaShapeList;
    List<Shape> nextFitDecrSortedAreaShapeList;
    List<Shape> firstFitDecrSortedAreaShapeList;
    List<Sheet> usedSheets;
		
    Algorithms algorithms = new Algorithms();
		
    long startTime;
    long endTime;
		
    long nextFitUnsortedRunningTime = 0;
    long firstFitUnsortedRunningTime = 0;
		
    long nextFitIncrSortedHeightRunningTime = 0;
    long firstFitIncrSortedHeightRunningTime = 0;
		
    long nextFitDecrSortedHeightRunningTime = 0;
    long firstFitDecrSortedHeightRunningTime = 0;
		
    long nextFitIncrSortedWidthRunningTime = 0;
    long firstFitIncrSortedWidthRunningTime = 0;
		
    long nextFitDecrSortedWidthRunningTime = 0;
    long firstFitDecrSortedWidthRunningTime = 0;
		
    long nextFitIncrSortedAreaRunningTime = 0;
    long firstFitIncrSortedAreaRunningTime = 0;
		
    long nextFitDecrSortedAreaRunningTime = 0;
    long firstFitDecrSortedAreaRunningTime = 0;
		
    int nextFitUnsortedUsedSheets = 0;
    int firstFitUnsortedUsedSheets = 0;
		
    int nextFitIncrSortedHeightUsedSheets = 0;
    int firstFitIncrSortedHeightUsedSheets = 0;
		
    int nextFitDecrSortedHeightUsedSheets = 0;
    int firstFitDecrSortedHeightUsedSheets = 0;
		
    int nextFitIncrSortedWidthUsedSheets = 0;
    int firstFitIncrSortedWidthUsedSheets = 0;
		
    int nextFitDecrSortedWidthUsedSheets = 0;
    int firstFitDecrSortedWidthUsedSheets = 0;
		
    int nextFitIncrSortedAreaUsedSheets = 0;
    int firstFitIncrSortedAreaUsedSheets = 0;
		
    int nextFitDecrSortedAreaUsedSheets = 0;
    int firstFitDecrSortedAreaUsedSheets = 0;
		
    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>"+ 
    		       "<><><><><><><><><><><><><><><><><><><><><><><><><><>");
    System.out.format("%130s*\n", "*Next Fit and First Fit algorithms performance tests comparisons with sorted and unsorted shape lists");
    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>"+ 
                       "<><><><><><><><><><><><><><><><><><><><><><><><><><>");
    System.out.println();
		
    for (int i = 0; i < noOfTests; i ++) {
      for (int j = 0; j < noOfRep; j++) {
        // generate a list of shapes
        nextFitUnsortedShapeList = generator.generateShapeList(noOfShapes);
        firstFitUnsortedShapeList = nextFitUnsortedShapeList;
        nextFitIncrSortedHeightShapeList = nextFitUnsortedShapeList;
        firstFitIncrSortedHeightShapeList = nextFitUnsortedShapeList;
        nextFitDecrSortedHeightShapeList = nextFitUnsortedShapeList;
        firstFitDecrSortedHeightShapeList = nextFitUnsortedShapeList;
        nextFitIncrSortedWidthShapeList = nextFitUnsortedShapeList;
        firstFitIncrSortedWidthShapeList = nextFitUnsortedShapeList;
        nextFitDecrSortedWidthShapeList = nextFitUnsortedShapeList;
        firstFitDecrSortedWidthShapeList = nextFitUnsortedShapeList;
        nextFitIncrSortedAreaShapeList = nextFitUnsortedShapeList;
        firstFitIncrSortedAreaShapeList = nextFitUnsortedShapeList;
        nextFitDecrSortedAreaShapeList = nextFitUnsortedShapeList;
        firstFitDecrSortedAreaShapeList = nextFitUnsortedShapeList;
				
        // *performance for unsorted list of shapes*
        // track run time of Next Fit algorithm for unsorted list of shapes
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitUnsortedShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using unsorted list of shapes
        nextFitUnsortedUsedSheets += usedSheets.size();
        nextFitUnsortedRunningTime += (endTime - startTime) / 1000000;

        // track run time of First Fit algorithm for unsorted list of shapes
        startTime = System.nanoTime();
        usedSheets = algorithms.firstFit(firstFitUnsortedShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using unsorted list of shapes
        firstFitUnsortedUsedSheets += usedSheets.size();
        firstFitUnsortedRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by height list of shapes in increasing order*
        Collections.sort(nextFitIncrSortedHeightShapeList, Shape.sortByHeight());
        // track run time of Next Fit algorithm for sorted by height list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitIncrSortedHeightShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by height list of shapes in increasing order
        nextFitIncrSortedHeightUsedSheets += usedSheets.size();
        nextFitIncrSortedHeightRunningTime += (endTime - startTime) / 1000000;
				
         Collections.sort(firstFitIncrSortedHeightShapeList, Shape.sortByHeight());
        // track run time of First Fit algorithm for sorted by height list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.firstFit(firstFitIncrSortedHeightShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by height list of shapes in increasing order
        firstFitIncrSortedHeightUsedSheets += usedSheets.size();
        firstFitIncrSortedHeightRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by height list of shapes in decreasing order*
        Collections.sort(nextFitDecrSortedHeightShapeList, Collections.reverseOrder(Shape.sortByHeight()));
        // track run time of Next Fit algorithm for sorted by height list of shapes in decreasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitDecrSortedHeightShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by height list of shapes in decreasing order
        nextFitDecrSortedHeightUsedSheets += usedSheets.size();
        nextFitDecrSortedHeightRunningTime += (endTime - startTime) / 1000000;
				
        Collections.sort(firstFitDecrSortedHeightShapeList, Collections.reverseOrder(Shape.sortByHeight()));
        // track run time of First Fit algorithm for sorted by height list of shapes in decreasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.firstFit(firstFitDecrSortedHeightShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by height list of shapes in decreasing order
        firstFitDecrSortedHeightUsedSheets += usedSheets.size();
        firstFitDecrSortedHeightRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by width list of shapes in increasing order*
        Collections.sort(nextFitIncrSortedWidthShapeList, Shape.sortByWidth());
        // track run time of Next Fit algorithm for sorted by width list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitIncrSortedWidthShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by width list of shapes in increasing order
        nextFitIncrSortedWidthUsedSheets += usedSheets.size();
        nextFitIncrSortedWidthRunningTime += (endTime - startTime) / 1000000;
				
        Collections.sort(firstFitIncrSortedWidthShapeList, Shape.sortByWidth());
        // track run time of First Fit algorithm for sorted by width list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.firstFit(firstFitIncrSortedWidthShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by width list of shapes in increasing order
        firstFitIncrSortedWidthUsedSheets += usedSheets.size();
        firstFitIncrSortedWidthRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by width list of shapes in decreasing order*
        Collections.sort(nextFitDecrSortedWidthShapeList, Collections.reverseOrder(Shape.sortByWidth()));
        // track run time of Next Fit algorithm for sorted by width list of shapes in decreasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitDecrSortedWidthShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by width list of shapes in decreasing order
        nextFitDecrSortedWidthUsedSheets += usedSheets.size();
        nextFitDecrSortedWidthRunningTime += (endTime - startTime) / 1000000;
				
        Collections.sort(firstFitDecrSortedWidthShapeList, Collections.reverseOrder(Shape.sortByWidth()));
        startTime = System.nanoTime();
        // track run time of First Fit algorithm for sorted by width list of shapes in decreasing order
        usedSheets = algorithms.firstFit(firstFitDecrSortedWidthShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by width list of shapes in decreasing order
        firstFitDecrSortedWidthUsedSheets += usedSheets.size();
        firstFitDecrSortedWidthRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by area list of shapes in increasing order*
        Collections.sort(nextFitIncrSortedAreaShapeList, Shape.sortByArea());
        // track run time of Next Fit algorithm for sorted by area list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitIncrSortedAreaShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by area list of shapes in increasing order
        nextFitIncrSortedAreaUsedSheets += usedSheets.size();
        nextFitIncrSortedAreaRunningTime += (endTime - startTime) / 1000000;
				
        Collections.sort(firstFitIncrSortedAreaShapeList, Shape.sortByArea());
        // track run time of First Fit algorithm for sorted by area list of shapes in increasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.firstFit(firstFitIncrSortedAreaShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by area list of shapes in increasing order
        firstFitIncrSortedAreaUsedSheets += usedSheets.size();
        firstFitIncrSortedAreaRunningTime += (endTime - startTime) / 1000000;
				
        // *performance for sorted by area list of shapes in decreasing order*
        Collections.sort(nextFitDecrSortedAreaShapeList, Collections.reverseOrder(Shape.sortByArea()));
        // track run time of Next Fit algorithm for sorted by area list of shapes in decreasing order
        startTime = System.nanoTime();
        usedSheets = algorithms.nextFit(nextFitDecrSortedAreaShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for Next Fit algorithm using sorted by area list of shapes in decreasing order
        nextFitDecrSortedAreaUsedSheets += usedSheets.size();
        nextFitDecrSortedAreaRunningTime += (endTime - startTime) / 1000000;
				
        Collections.sort(firstFitDecrSortedAreaShapeList, Collections.reverseOrder(Shape.sortByArea()));
        startTime = System.nanoTime();
        // track run time of First Fit algorithm for sorted by area list of shapes in decreasing order
        usedSheets = algorithms.firstFit(firstFitDecrSortedAreaShapeList);
        endTime = System.nanoTime();
        // increase used sheets size and total running time (in milliseconds) for First Fit algorithm using sorted by area list of shapes in decreasing order
        firstFitDecrSortedAreaUsedSheets += usedSheets.size();
        firstFitDecrSortedAreaRunningTime += (endTime - startTime) / 1000000;
      }
			
      System.out.println("=========================================================================================================="+ 
                         "==================================================================");
      System.out.format("%65s%d%s%d%s\n", "The algorithms were run ", noOfRep, " times using newly generated ", noOfShapes, " shapes each time");
      System.out.println("=========================================================================================================="+ 
      			 "==================================================================");
			
      System.out.println("On average, the time it took to run Next Fit algorithm with unsorted shapes was: " + nextFitUnsortedRunningTime / noOfRep  +
      			 " | On average, " + nextFitUnsortedUsedSheets / noOfRep + " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with unsorted shapes was: " + firstFitUnsortedRunningTime / noOfRep +
      			 " | On average, " + firstFitUnsortedUsedSheets / noOfRep + " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by height in increasing order was: " +
      			  nextFitIncrSortedHeightRunningTime / noOfRep + " | On average, " + nextFitIncrSortedHeightUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by height in increasing order was: " +
      			  firstFitIncrSortedHeightRunningTime / noOfRep + " | On average, " + firstFitIncrSortedHeightUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by height in decreasing order was: " +
      			  nextFitDecrSortedHeightRunningTime / noOfRep + " | On average, " + nextFitDecrSortedHeightUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by height in decreasing order was: " +
			  firstFitDecrSortedHeightRunningTime / noOfRep + " | On average, " + firstFitDecrSortedHeightUsedSheets / noOfRep + 
             		 " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by width in increasing order was: " +
      			  nextFitIncrSortedWidthRunningTime / noOfRep + " | On average, " + nextFitIncrSortedWidthUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by width in increasing order was: " +
      			  firstFitIncrSortedWidthRunningTime / noOfRep + " | On average, " + firstFitIncrSortedWidthUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by width in decreasing order was: " +
      			  nextFitDecrSortedWidthRunningTime / noOfRep + " | On average, " + nextFitDecrSortedWidthUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by width in decreasing order was: " +
      			  firstFitDecrSortedWidthRunningTime / noOfRep + " | On average, " + firstFitDecrSortedWidthUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by area in increasing order was: " +
      			  nextFitIncrSortedAreaRunningTime / noOfRep + " | On average, " + nextFitIncrSortedAreaUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by area in increasing order was: " +
      			  firstFitIncrSortedAreaRunningTime / noOfRep + " | On average, " + firstFitIncrSortedAreaUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
			
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run Next Fit algorithm with shapes sorted by area in decreasing order was: " +
      			  nextFitDecrSortedAreaRunningTime / noOfRep + " | On average, " + nextFitDecrSortedAreaUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
      System.out.println("----------------------------------------------------------------------------------------------------------"+
      			 "------------------------------------------------------------------");
      System.out.println("On average, the time it took to run First Fit algorithm with shapes sorted by area in decreasing order was: " +
      			  firstFitDecrSortedAreaRunningTime / noOfRep + " | On average, " + firstFitDecrSortedAreaUsedSheets / noOfRep + 
      			 " sheets were used to store the shapes");
			
      System.out.println("=========================================================================================================="+ 
      			 "==================================================================");
      System.out.println();
			
      // reset values to 0
      nextFitUnsortedRunningTime = 0;
      firstFitUnsortedRunningTime = 0;		
      nextFitIncrSortedHeightRunningTime = 0;
      firstFitIncrSortedHeightRunningTime = 0;		
      nextFitDecrSortedHeightRunningTime = 0;
      firstFitDecrSortedHeightRunningTime = 0;		
      nextFitIncrSortedWidthRunningTime = 0;
      firstFitIncrSortedWidthRunningTime = 0;		
      nextFitDecrSortedWidthRunningTime = 0;
      firstFitDecrSortedWidthRunningTime = 0;		
      nextFitIncrSortedAreaRunningTime = 0;
      firstFitIncrSortedAreaRunningTime = 0;		
      nextFitDecrSortedAreaRunningTime = 0;
      firstFitDecrSortedAreaRunningTime = 0;		
      nextFitUnsortedUsedSheets = 0;
      firstFitUnsortedUsedSheets = 0;		
      nextFitIncrSortedHeightUsedSheets = 0;
      firstFitIncrSortedHeightUsedSheets = 0;	
      nextFitDecrSortedHeightUsedSheets = 0;
      firstFitDecrSortedHeightUsedSheets = 0;	
      nextFitIncrSortedWidthUsedSheets = 0;
      firstFitIncrSortedWidthUsedSheets = 0;	
      nextFitDecrSortedWidthUsedSheets = 0;
      firstFitDecrSortedWidthUsedSheets = 0;	
      nextFitIncrSortedAreaUsedSheets = 0;
      firstFitIncrSortedAreaUsedSheets = 0;	
      nextFitDecrSortedAreaUsedSheets = 0;
      firstFitDecrSortedAreaUsedSheets = 0;
			
      // increment number of shapes
      noOfShapes += increment;
    }
  }
}