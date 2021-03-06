package app

import org.milyn.Smooks
import org.milyn.event.report.HtmlReportGenerator
import models.PricatHead
import org.milyn.payload.{StringResult, JavaSource}
import java.sql.Timestamp

/**
 * @author Ludovico Fischer
 */

object Demo extends App {

  val header = new PricatHead()
  header.accountNum="22"
  header.description ="Bananas"
  header.messageDate = new Timestamp(234)
  val smooks = new Smooks("smooks-config.xml");
  val executionContext = smooks.createExecutionContext();
  executionContext.setEventListener(new HtmlReportGenerator("target/reports/report.html"))
  try {
       smooks.filterSource(executionContext, new JavaSource(header), new StringResult())
  } finally {
    smooks.close()
  }

}