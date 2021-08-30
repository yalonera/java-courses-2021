package by.part8;

import by.part8.internal.example4.Logger;

public class Example4 {

  public class SmtpMailer {

    private Logger logger;

    public SmtpMailer(Logger logger) {
      this.logger = logger;
    }

    public void sendMessage(String message) {
// отсылка сообщения
      logger.log(String.format("Отправлено %s", message));
    }
  }
}
