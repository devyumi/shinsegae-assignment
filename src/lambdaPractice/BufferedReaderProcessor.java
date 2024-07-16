package lambdaPractice;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

  String process(BufferedReader br) throws IOException;
}

/**
 * FuctionalInterface BufferedReader Ex.
 */