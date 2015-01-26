package au.gov.ga.geodesy.sitelog.domain.model;

import java.util.Date;

import au.gov.ga.common.infrastructure.persistence.jpa.AbstractJpaRepository;

public class SiteLogRepositoryImpl extends AbstractJpaRepository<Integer, SiteLog> implements SiteLogRepository {

   @Override
   public void persist(SiteLog siteLog) {
      siteLog.setEntryDate(new Date());
      super.persist(siteLog);
   }

   @Override
   protected Class<SiteLog> getEntityClass() {
      return SiteLog.class;
   }

   public SiteLog findByFourCharacterId(String id) {
      return findOne("as sitelog where upper(sitelog.siteIdentification.fourCharacterId) = upper(?)", id);
   }
}
