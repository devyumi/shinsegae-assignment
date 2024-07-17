package ioPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyImageEx {

  public static void main(String[] args) throws IOException {
    String originalFileName = "C:/Temp/test.jpg";
    String targetFileName = "C:/Temp/test_copy1.jpg";

    InputStream is = new FileInputStream(originalFileName);
    OutputStream os = new FileOutputStream(targetFileName);

    /*byte[] buffer = new byte[1024];
    while (true){
      int data = is.read(buffer);
      if(data == -1) break;
      os.write(buffer,0,data);
      }*/
    is.transferTo(os);   //java 9 부터 지원 입력스트림에서 출력스트림으로 바이트 복사 기능
    os.flush();
    os.close();
    is.close();
    System.out.println("copy complete!");
  }
}

/**
 * Image Copy
 */
