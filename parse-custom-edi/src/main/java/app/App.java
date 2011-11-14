package app;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.StringResult;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * @author Ludovico Fischer
 */
public class App {
    public static void main(String[] args) throws IOException, SAXException {
        Smooks smooks = new Smooks("smooks-config.xml");
        try {
            Writer writer = new StringWriter();
            ExecutionContext executionContext = smooks.createExecutionContext();
            executionContext.setEventListener(new HtmlReportGenerator("target/reports/report.html"));
            smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(StreamUtils.readStream(new FileInputStream("fruit.edi")))), new StringResult());
        } finally {
            smooks.close();
        }
    }
}