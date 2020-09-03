/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

  public static final int MAX_SIZE_HEIGHT = 250;
  public static final int MAX_SIZE_WIDTH = 300;

  /**
   * This method will generate a list of shapes of random width and height
   * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive.
   * The random height is between 1 and MAX_SIZE_HEIGHT inclusive.
   * 
   * @param numberOfShapes: the number of shapes to generate
   * @return a list of shapes of random sizes
   */

  public List<Shape> generateShapeList(int numberOfShapes) {
    List<Shape> shapes = new ArrayList<Shape>();
    Random r = new Random();
    for (int i = 0; i < numberOfShapes; i++) {
      shapes.add(new Shape(r.nextInt(MAX_SIZE_WIDTH) + 1, r.nextInt(MAX_SIZE_HEIGHT) + 1));
    }
    return shapes;
  }
}