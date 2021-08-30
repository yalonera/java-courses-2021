package by.part10.parser.strategy;

import java.io.File;
import java.io.IOException;

public interface ReadStrategy {

  String getContent(File file) throws IOException;
}
