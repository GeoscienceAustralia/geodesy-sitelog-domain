package au.gov.ga.geodesy.sitelog.infrastructure.marshalling.moxy;

import au.gov.ga.geodesy.sitelog.domain.model.DifferentialFromMarker;

public class DifferentialFromMarkerAdapter extends MandatoryCompositeAdapter<DifferentialFromMarker> {

   @Override
   protected Class<DifferentialFromMarker> getDomainClass() {
      return DifferentialFromMarker.class;
   }
}
