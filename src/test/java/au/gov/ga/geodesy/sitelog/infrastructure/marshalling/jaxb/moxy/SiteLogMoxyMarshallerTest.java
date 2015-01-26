package au.gov.ga.geodesy.sitelog.infrastructure.marshalling.jaxb.moxy;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import org.junit.Test;

import au.gov.ga.geodesy.sitelog.domain.model.SiteLog;
import au.gov.ga.geodesy.sitelog.infrastructure.marshalling.moxy.SiteLogMoxyMarshaller;

public class SiteLogMoxyMarshallerTest {

   private static final String sampleSiteLogsDir = "src/test/resources/sitelog";
   private SiteLogMoxyMarshaller marshaller;

   public SiteLogMoxyMarshallerTest() throws Exception {
      marshaller = new SiteLogMoxyMarshaller();
   }

   @Test
   public void testMarshallingAndUnmarshalling() throws Exception {
      for (File siteLogFile : getSiteLogFiles()) {
         try {
            SiteLog siteLog = marshaller.unmarshal(new InputStreamReader(new FileInputStream(siteLogFile)));
            marshaller.marshal(siteLog, new PrintWriter(new OutputStream() {
               public void write(int x) {}
            }));
            System.out.println("Successfully (un)marshalled " + siteLogFile.getAbsolutePath());
         } catch (Exception e) {
            throw new Exception("Failed to test (un)marshalling of " + siteLogFile.getAbsolutePath(), e);
         }
      }
   }

   private File[] getSiteLogFiles() throws Exception {
      return new File(sampleSiteLogsDir).listFiles(new FileFilter() {
         public boolean accept(File f) {
            return f.getName().endsWith(".xml");
         }
      });
   }
}
