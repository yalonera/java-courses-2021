package by.part10.parser;

import by.part10.parser.strategy.ReadStrategy;
import java.io.File;
import java.io.IOException;

public class FileReadContentService implements ReadContentService {

  private final File file;
  private final ReadStrategy readStrategy;

  public FileReadContentService(File file, ReadStrategy readStrategy) {
    this.file = file;
    this.readStrategy = readStrategy;
  }

  @Override
  public String getContent() throws IOException {
    return readStrategy.getContent(file);
  }
}
