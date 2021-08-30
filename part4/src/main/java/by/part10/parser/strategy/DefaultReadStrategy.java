package by.part10.parser.strategy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DefaultReadStrategy implements ReadStrategy {

  @Override
  public String getContent(File file) throws IOException {
    try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
      StringBuilder output = new StringBuilder();
      byte[] buffer = new byte[1024];
      while (i.read(buffer) > 0) {
        output.append(new String(buffer));
      }
      return output.toString();
    }
  }
}
