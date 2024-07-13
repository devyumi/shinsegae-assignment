package board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardSaveDto {

  private String title;
  private String content;
  private String writer;
}
