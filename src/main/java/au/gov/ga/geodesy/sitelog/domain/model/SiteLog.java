package au.gov.ga.geodesy.sitelog.domain.model;

import java.io.StringWriter;
import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import au.gov.ga.geodesy.sitelog.interfaces.xml.MarshallingException;
import au.gov.ga.geodesy.sitelog.interfaces.xml.SiteLogXmlMarshaller;

/**
 * http://sopac.ucsd.edu/ns/geodesy/doc/igsSiteLog/2004/igsSiteLog.xsd:igsSiteLogType
 */
@Configurable
public class SiteLog {

   private Integer id;
   private Date entryDate;

   @Autowired
   private SiteLogXmlMarshaller siteLogXmlMarshaller;

   @Valid
   protected FormInformation formInformation;

   @Valid
   @NotNull
   protected SiteIdentification siteIdentification;

   @Valid
   protected SiteLocation siteLocation;

   @Valid
   protected Set<GnssReceiver> gnssReceivers;

   @Valid
   protected Set<GnssAntenna> gnssAntennas;

   @Valid
   protected Set<SurveyedLocalTie> surveyedLocalTies;

   @Valid
   protected Set<FrequencyStandard> frequencyStandards;

   @Valid
   protected Set<CollocationInformation> collocationInformation;

   @Valid
   protected Set<HumiditySensor> humiditySensors;

   @Valid
   protected Set<PressureSensor> pressureSensors;

   @Valid
   protected Set<TemperatureSensor> temperatureSensors;

   @Valid
   protected Set<WaterVaporSensor> waterVaporSensors;

   @Valid
   protected Set<OtherInstrumentation> otherInstrumentation;

   @Valid
   protected Set<RadioInterference> radioInterferences;

   @Valid
   protected Set<MultipathSource> multipathSources;

   @Valid
   protected Set<SignalObstruction> signalObstructions;

   @Valid
   protected Set<LocalEpisodicEvent> localEpisodicEvents;

   @Valid
   protected Agency contactAgency;

   @Valid
   protected Agency responsibleAgency;

   @Valid
   protected MoreInformation moreInformation;

   // TODO: public surrogate key
   private Integer getId() {
      return id;
   }

   private void setId(Integer id) {
      this.id = id;
   }

   public Date getEntryDate() {
      return entryDate;
   }

   protected void setEntryDate(Date d) {
      this.entryDate = d;
   }

   public void setSiteLogXmlMarshaller(SiteLogXmlMarshaller m) {
      siteLogXmlMarshaller = m;
   }

   public String getSiteLogXml() throws MarshallingException {
      StringWriter writer = new StringWriter();
      siteLogXmlMarshaller.marshal(this, writer);
      return writer.toString();
   }

   @SuppressWarnings("unused")
   private void setSiteLogXml(String xml) {
   }

   /**
    * Return form information.
    */
   public FormInformation getFormInformation() {
      return formInformation;
   }

   /**
    * Set form information.
    */
   public void setFormInformation(FormInformation value) {
      this.formInformation = value;
   }

   /**
    * Return site identification.
    */
   public SiteIdentification getSiteIdentification() {
      return siteIdentification;
   }

   /**
    * Set site identification.
    */
   public void setSiteIdentification(SiteIdentification value) {
      this.siteIdentification = value;
   }

   /**
    * Return site location.
    */
   public SiteLocation getSiteLocation() {
      return siteLocation;
   }

   /**
    * Set site location.
    */
   public void setSiteLocation(SiteLocation value) {
      this.siteLocation = value;
   }

   /**
    * Return GNSS receivers.
    */
   public Set<GnssReceiver> getGnssReceivers() {
      return gnssReceivers;
   }

   /**
    * Set GNSS receivers.
    */
   public void setGnssReceivers(Set<GnssReceiver> rs) {
      gnssReceivers = rs;
   }

   /**
    * Return GNSS antennas.
    */
   public Set<GnssAntenna> getGnssAntennas() {
      return gnssAntennas;
   }

   /**
    * Set GNSS antennas.
    */
   public void setGnssAntennas(Set<GnssAntenna> as) {
      gnssAntennas = as;
   }

   /**
    * Return surveyed local ties.
    */
   public Set<SurveyedLocalTie> getSurveyedLocalTies() {
      return this.surveyedLocalTies;
   }

   /**
    * Set surveyed local ties.
    */
   public void setSurveyedLocalTies(Set<SurveyedLocalTie> ties) {
      surveyedLocalTies = ties;
   }

   /**
    * Return frequency standards.
    */
   public Set<FrequencyStandard> getFrequencyStandards() {
      return frequencyStandards;
   }

   /**
    * Set frequency standards.
    */
   public void setFrequencyStandards(Set<FrequencyStandard> fs) {
      frequencyStandards = fs;
   }

   /**
    * Return collocation information.
    */
   public Set<CollocationInformation> getCollocationInformation() {
      return collocationInformation;
   }

   /**
    * Set collocation information.
    */
   public void setCollocationInformation(Set<CollocationInformation> c) {
      collocationInformation = c;
   }

   /**
    * Return humidity sensor.
    */
   public Set<HumiditySensor> getHumiditySensors() {
      return this.humiditySensors;
   }

   /**
    * Set humidity sensor.
    */
   public void setHumiditySensors(Set<HumiditySensor> hs) {
      humiditySensors = hs;
   }

   /**
    * Return pressure sensors.
    */
   public Set<PressureSensor> getPressureSensors() {
      return this.pressureSensors;
   }

   /**
    * Set pressure sensors.
    */
   public void setPressureSensors(Set<PressureSensor> ps) {
      pressureSensors = ps;
   }

   /**
    * Return temperature sensors.
    */
   public Set<TemperatureSensor> getTemperatureSensors() {
      return this.temperatureSensors;
   }

   /**
    * Set temperature sensors.
    */
   public void setTemperatureSensors(Set<TemperatureSensor> ts) {
      temperatureSensors = ts;
   }

   /**
    * Return water vapor sensors.
    */
   public Set<WaterVaporSensor> getWaterVaporSensors() {
      return this.waterVaporSensors;
   }

   /**
    * Set water vapor sensors.
    */
   public void setWaterVaporSensors(Set<WaterVaporSensor> vs) {
      waterVaporSensors = vs;
   }

   /**
    * Return other instrumentation.
    */
   public Set<OtherInstrumentation> getOtherInstrumentation() {
      return this.otherInstrumentation;
   }

   /**
    * Set other instrumentation.
    */
   public void setOtherInstrumentation(Set<OtherInstrumentation> i) {
      otherInstrumentation = i;
   }

   /**
    * Return radio interferences.
    */
   public Set<RadioInterference> getRadioInterferences() {
      return this.radioInterferences;
   }

   /**
    * Set radio interferences.
    */
   public void setRadioInterferences(Set<RadioInterference> rs) {
      radioInterferences = rs;
   }

   /**
    * Return multipath sources.
    */
   public Set<MultipathSource> getMultipathSources() {
      return this.multipathSources;
   }

   /**
    * Set multipath sources.
    */
   public void setMultipathSources(Set<MultipathSource> ms) {
      multipathSources = ms;
   }

   /**
    * Return signal obstructions.
    */
   public Set<SignalObstruction> getSignalObstructions() {
      return this.signalObstructions;
   }

   /**
    * Set signal obstructions.
    */
   public void setSignalObstructions(Set<SignalObstruction> s) {
      signalObstructions = s;
   }

   /**
    * Return local episodic events.
    */
   public Set<LocalEpisodicEvent> getLocalEpisodicEvents() {
      return this.localEpisodicEvents;
   }

   /**
    * Set local episodic events.
    */
   public void setLocalEpisodicEvents(Set<LocalEpisodicEvent> es) {
      localEpisodicEvents = es;
   }

   /**
    * Return contact agency.
    */
   public Agency getContactAgency() {
      return contactAgency;
   }

   /**
    * Set contact agency.
    */
   public void setContactAgency(Agency value) {
      this.contactAgency = value;
   }

   /**
    * Return responsible agency.
    */
   public Agency getResponsibleAgency() {
      return responsibleAgency;
   }

   /**
    * Set responsible agency.
    */
   public void setResponsibleAgency(Agency value) {
      this.responsibleAgency = value;
   }

   /**
    * Return more information.
    */
   public MoreInformation getMoreInformation() {
      return moreInformation;
   }

   /**
    * Set more information.
    */
   public void setMoreInformation(MoreInformation value) {
      this.moreInformation = value;
   }
}
