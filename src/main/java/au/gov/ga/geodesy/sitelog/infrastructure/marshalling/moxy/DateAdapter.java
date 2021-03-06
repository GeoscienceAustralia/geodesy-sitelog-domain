package au.gov.ga.geodesy.sitelog.infrastructure.marshalling.moxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateAdapter extends XmlAdapter<String, Date> {

   private static final Logger log = LoggerFactory.getLogger(DateAdapter.class);

   // the intention is to be lenient when parsing dates, feel free to add more patterns
   private static String[] inputDatePatterns = new String[] { "yyyy-MM-dd", "yyyy" };

   private SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

   private List<SimpleDateFormat> inputDateFormats = new ArrayList<SimpleDateFormat>();

   public DateAdapter() {
      for (String pattern : inputDatePatterns) {
         SimpleDateFormat inputDateFormat = new SimpleDateFormat(pattern);
         inputDateFormats.add(inputDateFormat);
      }
   }

   @Override
   public String marshal(Date d) throws Exception {
      return outputDateFormat.format(d);
   }

   @Override
   public Date unmarshal(String s) throws Exception {
      if (s == null) {
         return null;
      }
      if (s.equals("(CCYY-MM-DD)") || s.equals("CCYY-MM-DD")) {
         return null;
      }
      for (SimpleDateFormat f : inputDateFormats) {
         try {
            Date d = f.parse(s);
            if (d != null) {
               return d;
            }
         } catch (ParseException e) {
            /* log.debug("Failed to unmarshal a date field, we will keep trying using other patterns .", e); */
         }
      }
      log.error("Failed to unmarshal date '" + s + "' using any of the following patterns: " + Arrays.toString(inputDatePatterns)
              + " (you could recompile with more patterns); returning null and carrying on");
      return null;
   }
}
