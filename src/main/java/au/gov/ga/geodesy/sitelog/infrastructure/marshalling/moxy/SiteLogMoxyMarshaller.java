package au.gov.ga.geodesy.sitelog.infrastructure.marshalling.moxy;

import au.gov.ga.geodesy.sitelog.domain.model.SiteLog;
import au.gov.ga.geodesy.sitelog.interfaces.xml.SiteLogXmlMarshaller;
import au.gov.ga.geodesy.sitelog.interfaces.xml.MarshallingException;

import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.sessions.SessionEventListener;

/**
 * EclipseLink Moxy implementation using external mapping files.
 */
public class SiteLogMoxyMarshaller implements SiteLogXmlMarshaller {

   private JAXBContext jaxbContext;

   public SiteLogMoxyMarshaller() throws MarshallingException {
      try {
         Map<String, Source> metadata = new HashMap<String, Source>();
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         String mappingFilename = "au/gov/ga/geodesy/sitelog/infrastructure/marshalling/moxy/sitelog.xml";
         Source mapping = new StreamSource(classLoader.getResourceAsStream(mappingFilename));
         metadata.put("au.gov.ga.geodesy.sitelog.domain.model", mapping);

         // implementation-specific helper classes are packeged under infrastructure and mapped seperately
         String infraMappingFilename = "au/gov/ga/geodesy/sitelog/infrastructure/marshalling/moxy/sitelog-infra.xml";
         Source infraMapping = new StreamSource(classLoader.getResourceAsStream(infraMappingFilename));
         metadata.put("au.gov.ga.geodesy.sitelog.infrastructure.marshalling.moxy", infraMapping);

         Map<String, Object> props = new HashMap<String, Object>();
         props.put(JAXBContextProperties.OXM_METADATA_SOURCE, metadata);

         SessionEventListener sessionEventListener = new NullPolicySessionEventListener();
         props.put(JAXBContextProperties.SESSION_EVENT_LISTENER, sessionEventListener);

         jaxbContext = JAXBContextFactory.createContext(new Class[] { SiteLog.class, AdaptedApproximatePosition.class }, props);
      } catch (JAXBException e) {
         throw new MarshallingException("Failed to initialise JAXBContext", e);
      }
   }

   private Marshaller createMarshaller() throws MarshallingException {
      try {
         Marshaller marshaller = jaxbContext.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
               "http://sopac.ucsd.edu/ns/geodesy/doc/igsSiteLog/2004 http://sopac.ucsd.edu/ns/geodesy/doc/igsSiteLog/2004/igsSiteLog.xsd");
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
         return marshaller;
      } catch (JAXBException e) {
         throw new MarshallingException("Failed to create marshaller", e);
      }
   }

   private Unmarshaller createUnmarshaller() throws MarshallingException {
      try {
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         return unmarshaller;
      } catch (JAXBException e) {
         throw new MarshallingException("Failed to create unmarshaller", e);
      }
   }

   public void marshal(SiteLog site, Writer writer) throws MarshallingException {
      try {
         createMarshaller().marshal(site, writer);
      } catch (JAXBException e) {
         throw new MarshallingException("Failed to marshal a site log", e);
      }
   }

   public SiteLog unmarshal(Reader reader) throws MarshallingException {
      try {
         return (SiteLog) createUnmarshaller().unmarshal(reader);
      } catch (JAXBException e) {
         throw new MarshallingException("Failed to unmarshal a site log", e);
      }
   }
}
