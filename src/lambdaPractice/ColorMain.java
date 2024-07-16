package lambdaPractice;

import java.util.function.BiFunction;
import java.util.function.Function;

class Color {

  private int red;
  private int green;
  private int blue;

  public Color(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }
}

public class ColorMain {

  public static void main(String[] args) {
    BiFunction<Integer, Integer, Function<Integer, Color>> colorConstructor = (red, green) -> blue -> new Color(
        red, green, blue);

    Color color = colorConstructor.apply(255, 255).apply(55);
    System.out.println("red: " + color.getRed());
    System.out.println("green: " + color.getGreen());
    System.out.println("blue: " + color.getBlue());
  }
}

/**
 * BiFunction Ex.
 */
