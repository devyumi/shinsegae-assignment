package board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardEditDto {

  private int no;
  private String title;
  private String content;
  private String writer;
}
