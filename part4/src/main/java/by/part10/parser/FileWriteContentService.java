package by.part10.parser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteContentService implements WriteContentService {

  private final File file;

  public FileWriteContentService(File file) {
    this.file = file;
  }

  @Override
  public void saveContent(String content) throws IOException {
    try (final BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))) {
      stream.write(content.getBytes());
    }
  }
}
