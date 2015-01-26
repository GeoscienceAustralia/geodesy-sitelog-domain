package au.gov.ga.geodesy.sitelog.interfaces.xml;

import au.gov.ga.geodesy.sitelog.domain.model.SiteLog;

import java.io.Writer;
import java.io.Reader;

public interface SiteLogXmlMarshaller {
   void marshal(SiteLog igsSite, Writer writer) throws MarshallingException;
   SiteLog unmarshal(Reader reader) throws MarshallingException;
}
