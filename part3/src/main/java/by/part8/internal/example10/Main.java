package by.part8.internal.example10;

import java.util.List;

public class Main {

  public static class Reporter {

    private final ReportBuilder reportBuilder;
    private final ReportSender reportSender;

    public Reporter(ReportBuilder reportBuilder, ReportSender reportSender) {
      this.reportBuilder = reportBuilder;
      this.reportSender = reportSender;
    }

    public void sendReports() throws NoReportsException {
      List<Report> reports = reportBuilder.createReports();

      if (reports.size() == 0) {
        throw new NoReportsException();
      }

      for (Report report : reports) {
        reportSender.send(report);
      }
    }
  }

  public static void main(String[] args) throws NoReportsException {
    ReportBuilderImpl builder = new ReportBuilderImpl();
    EmailReportSenderImpl sender = new EmailReportSenderImpl();
    Reporter reporter = new Reporter(builder, sender);
    reporter.sendReports();
  }
}
