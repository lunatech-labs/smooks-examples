package visitors;

import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.delivery.sax.*;
import org.milyn.delivery.sax.annotation.StreamResultWriter;
import org.milyn.delivery.sax.annotation.TextConsumer;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Ludovico Fischer
 */

@TextConsumer
@StreamResultWriter
public class EDIFragmentVisitor implements SAXVisitAfter {

    @Override
    public void visitAfter(SAXElement element, ExecutionContext executionContext) throws SmooksException, IOException {
        Writer writer = element.getWriter(this);
        writer.write("UNC:" + element.getTextContent());
    }
}
