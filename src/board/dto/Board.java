package board.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {

  private int bNo;
  private String bTitle;
  private String bContent;
  private String bWriter;
  private Date bDate;
}
