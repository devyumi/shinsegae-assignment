package create_class;

public class Movie {

  private String title;
  private String genre;

  public void play() {
    System.out.println(this.title + "(" + this.genre + ") 상영중입니다.");
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}
