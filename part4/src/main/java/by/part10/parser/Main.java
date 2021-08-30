package by.part10.parser;

import by.part10.parser.strategy.DefaultReadStrategy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class Main {

  public static void main(String[] args) throws IOException {
    final File from = Files.createTempFile("my", "").toFile();
    final ReadContentService readContentService = new FileReadContentService(from, new DefaultReadStrategy());
    final WriteContentService writeContentService = new FtpWriteContentService();

    final ContentService service = new FileContentService(readContentService, writeContentService);

    final String content = service.getContent();
    service.saveContent(new Date() + "\n" + content);

    System.out.println(service.getContent());
  }
}