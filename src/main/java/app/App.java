package app;

import models.Fruit;
import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.List;

/**
 * @author Ludovico Fischer
 */
public class App {
      public static void main(String[] args) throws IOException, SAXException {
          System.out.println("Starting program.");
          readFixedWidthFile();
          writeOutputFile();
      }

    private static void readFixedWidthFile() throws IOException, SAXException {
        Smooks smooks = new Smooks("smooks-config.xml");
        JavaResult result = new JavaResult();
        smooks.filterSource(new StreamSource(new File("fruit.txt")), result);
        List<Fruit> fruits =(List<Fruit>) result.getBean("fruits");
        smooks.close();
        System.out.println(String.format("We have this many fruits: %s", fruits.size()));
        for (Fruit fruit: fruits) {
            System.out.println(fruit.getFruit());
        }
    }

    private static void writeOutputFile() {

    }
}
