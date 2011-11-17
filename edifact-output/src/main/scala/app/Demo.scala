package app

import org.milyn.Smooks
import org.milyn.event.report.HtmlReportGenerator
import java.io.FileInputStream
import org.milyn.io.StreamUtils
import javax.xml.transform.stream.StreamSource
import models.PricatHead
import org.milyn.payload.{StringResult, JavaSource}

/**
 * @author Ludovico Fischer
 */

object Demo extends App {

  val header = new PricatHead()
  header.accountNum="22"
  header.description ="Bananas"
  val smooks = new Smooks("smooks-config.xml");
  val executionContext = smooks.createExecutionContext();
  executionContext.setEventListener(new HtmlReportGenerator("target/reports/report.html"))
  try {
       smooks.filterSource(executionContext, new JavaSource(header), new StringResult())
  } finally {
    smooks.close()
  }

}