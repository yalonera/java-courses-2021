package by.part8;

import by.part8.internal.example10.EmailReportSenderImpl;
import by.part8.internal.example10.NoReportsException;
import by.part8.internal.example10.Report;
import by.part8.internal.example10.ReportBuilderImpl;
import java.util.List;

public class Example10 {

  public static class Reporter {

    public void sendReports() throws NoReportsException {
      ReportBuilderImpl reportBuilder = new ReportBuilderImpl();
      List<Report> reports = reportBuilder.createReports();

      if (reports.size() == 0) {
        throw new NoReportsException();
      }

      EmailReportSenderImpl reportSender = new EmailReportSenderImpl();
      for (Report report : reports) {
        reportSender.send(report);
      }
    }
  }

  public static void main(String[] args) throws NoReportsException {
    Reporter reporter = new Reporter();
    reporter.sendReports();
  }
}
