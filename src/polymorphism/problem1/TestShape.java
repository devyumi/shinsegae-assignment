package polymorphism.problem1;

public class TestShape {
  public static void main(String[] args) {
    Shape [] shape = new Shape[3];
    shape[0] = new Circle("원", 1.0);
    shape[1] = new Rectangular("직사각형", 10.0, 20.0);

    shape[0].calculationArea();
    shape[1].calculationArea();

    shape[0].print();
    shape[1].print();
  }
}
