package app;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringResult;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.List;

import models.StrangeFruit;


/**
 * @author Ludovico Fischer
 */
public class App {
    public static void main(String[] args) throws IOException, SAXException {
        Smooks smooks = new Smooks("smooks-config.xml");
        try {
            ExecutionContext executionContext = smooks.createExecutionContext();
            executionContext.setEventListener(new HtmlReportGenerator("target/reports/report.html"));
            smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(StreamUtils.readStream(new FileInputStream("samples/fruit.edi")))), new StringResult());
        } finally {
            smooks.close();
        }

        StrangeFruit fruit;
        Smooks smooksSecond = new Smooks("smooks-bean-config.xml");
        try {
            JavaResult result = new JavaResult();
            smooksSecond.filterSource(new StreamSource(new ByteArrayInputStream(StreamUtils.readStream(new
                    FileInputStream("samples/fruit.edi")))), result);
            fruit = (StrangeFruit) result.getBean("strangeFruit");
            System.out.println(fruit.getCode());
        } finally {
            smooksSecond.close();
        }

        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("some.name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fruit);
        entityManager.getTransaction().commit();
        List<StrangeFruit> result = (List<StrangeFruit>) entityManager.createQuery("SELECT f FROM StrangeFruit f").getResultList();
        System.out.println(result.size());
        entityManager.close();
    }
}