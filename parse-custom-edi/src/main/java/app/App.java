package app;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Ludovico Fischer
 */
public class App {
    public static void main(String[] args) throws IOException, SAXException {
        Smooks smooks = new Smooks("smooks-config.xml");
        try {
            ExecutionContext executionContext = smooks.createExecutionContext();
            smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(StreamUtils.readStream(new FileInputStream("fruit.edi")))));
        } finally {
            smooks.close();
        }
    }
}