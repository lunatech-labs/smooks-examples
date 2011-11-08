package app;

import org.milyn.Smooks;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.String;

/**
 * @author Ludovico Fischer
 */
public class App {
      public static void main(String[] args) throws IOException, SAXException {
          Smooks smooks = new Smooks("smooks-config.xml");

      }
}
