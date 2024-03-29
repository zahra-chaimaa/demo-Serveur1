/**
 * Connector.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 05/01/2007
 */
package demo.demo.jcolibri.cbrcore;

import java.util.Collection;

import demo.demo.jcolibri.cbrcore.CBRCase;
import demo.demo. jcolibri.cbrcore.CaseBaseFilter;
import demo.demo.jcolibri.exception.InitializingException;

/**
 * Connector interface declares the methods required to access the cases stored in a persistence media.
 * jCOLIBRI splits the managing of cases into persistence media and in-memory organization. 
 * This interface defines the access to de persistence and
 * the CBRCaseBase interface defines the in-memory organization.
 *  Both interfaces are related as the CBRCaseBase manages the Connector.
 * 
 * Implementations should read/write cases from Data Bases, Plain Text files, Ontologies, XML files, etc.
 * 
 * @author Juan A. Recio-Garc�a
 * @see demo.demo.jcolibri.cbrcore.CBRCaseBase
 */
public interface Connector {

	
	/**
	 * Initialices the connector with the given XML file
	 * 
	 * @param file XMl file with the settings
	 * @throws InitializingException
	 *             Raised if the connector can not be initialezed.
	 */
	public void initFromXMLfile(java.net.URL file) throws InitializingException;

	/**
	 * Cleanup any resource that the connector might be using, and suspends the
	 * service
	 * 
	 */
	public void close();

	/**
	 * Stores given classes on the storage media
	 * 
	 * @param cases
	 *            List of cases
	 */
	public void storeCases(Collection<demo.demo.jcolibri.cbrcore.CBRCase> cases);

	/**
	 * Deletes given cases for the storage media
	 * 
	 * @param cases
	 *            List of cases
	 */
	public void deleteCases(Collection<demo.demo.jcolibri.cbrcore.CBRCase> cases);

	/**
	 * Returns max cases without any special consideration
	 * 
	 * @return The list of retrieved cases
	 */
	public Collection<demo.demo.jcolibri.cbrcore.CBRCase> retrieveAllCases();

	/**
	 * Retrieves some cases depending on the filter. TODO.
	 */
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter);

}
