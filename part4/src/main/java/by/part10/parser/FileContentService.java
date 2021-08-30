package by.part10.parser;

import java.io.IOException;

public class FileContentService implements ContentService {

  private final ReadContentService readContentService;
  private final WriteContentService writeContentService;

  public FileContentService(ReadContentService readContentService, WriteContentService writeContentService) {
    this.readContentService = readContentService;
    this.writeContentService = writeContentService;
  }

  @Override
  public String getContent() throws IOException {
    return readContentService.getContent();
  }

  @Override
  public void saveContent(String content) throws IOException {
    writeContentService.saveContent(content);
  }
}