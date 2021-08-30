package by.part10.parser.strategy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WithoutUnicodeReadStrategy implements ReadStrategy {

  @Override
  public String getContent(File file) throws IOException {
    try (InputStream i = new BufferedInputStream(new FileInputStream(file))) {
      StringBuilder output = new StringBuilder();
      int data;
      while ((data = i.read()) > 0) {
        if (data < 0x80) {
          output.append((char) data);
        }
      }
      return output.toString();
    }
  }
}
