import java.util.Comparator;

/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2019 
 * extended by @author Dominykas Mickevicius | Student ID: 180387629
 * 
 **/

public class Shape implements Comparable<Shape> {

  private int sWidth;   // width of the shape
  private int sHeight;  // height of the shape
	
  // comparators for comparing shapes by height, width and area
  static Comparator<Shape> sortByHeight() {
    return new Comparator<Shape>() {
      @Override
      public int compare(Shape s1, Shape s2) {
        return s1.getHeight() < s2.getHeight() ? -1 : s1.getHeight() == s2.getHeight() ? 0 : 1;
      }
    };
  }
	
  static Comparator<Shape> sortByWidth() {
    return new Comparator<Shape>() {
      @Override
      public int compare(Shape s1, Shape s2) {
        return s1.getWidth() < s2.getWidth() ? -1 : s1.getWidth() == s2.getWidth() ? 0 : 1;
      }
    };
  }
	
  static Comparator<Shape> sortByArea() {
    return new Comparator<Shape>() {
      @Override
      public int compare(Shape s1, Shape s2) {
        return s1.getWidth() * s1.getHeight() < s2.getWidth() * s2.getHeight() ? -1 : 
               s1.getWidth() * s1.getHeight() == s2.getWidth() * s2.getHeight() ? 0 : 1;
      }
    };
  }

  /**
  * A Shape constructor to set the width and height of a shape. 
  * @param width of a shape
  * @param height of a shape
  **/
  public Shape(int width, int height) {
    // Shape width and height should not be greater than the sheet width and height
    if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
      throw new IllegalArgumentException("Shape width or height is not valid");
    }

    this.sWidth = width;
    this.sHeight = height;
  }

  /**
  * @return height of a shape
  **/
  public int getHeight() {
    return sHeight;
  }

  public void setHeight(int height) {
    this.sHeight = height;
  }
  /**
  * @return width of a shape
  */
  public int getWidth() {
    return sWidth;
  }
	
  public void setWidth(int width) {
    this.sWidth = width;
  }

  @Override
  public int compareTo(Shape o) {
    // You may want to implement this method
    return 0;
  }
}
