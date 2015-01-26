package au.gov.ga.geodesy.sitelog.domain.model;

import au.gov.ga.common.domain.model.JpaRepository;

public interface SiteLogRepository extends JpaRepository<Integer, SiteLog> {

   /**
    * Find a site log by its unique four character id. Return null if not found.
    */
   SiteLog findByFourCharacterId(String id);
}
