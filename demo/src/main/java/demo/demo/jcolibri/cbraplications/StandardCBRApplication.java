/**
 * StandardCBRApplication.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 03-mar-2006
 */
package demo.demo.jcolibri.cbraplications;


import demo.demo.jcolibri.cbrcore.CBRCaseBase;
import demo.demo.jcolibri.cbrcore.CBRQuery;
import demo.demo.jcolibri.exception.ExecutionException;


/**
 * Defines the method of an standard CBR application.
 * It is composed by:
 * <ul>
 * <li>A configuration method to set up the application.
 * <li>A preCycle that loads cases and prepares the application to run.
 * <li>The cycle method that runs a CBR step using the given query.
 * <li>A postCycle in charge of finishing the application.
 * </ul>
 * 
 * @author Juan A. Recio-Garc�a
 *
 */
public interface StandardCBRApplication
{
	/**
	 * Configures the application: case base, connectors, etc.
	 * @throws ExecutionException
	 */
    public void configure() throws ExecutionException, demo.demo.jcolibri.exception.ExecutionException;

    /**
     * Runs the precyle where typically cases are read and organized into a case base. 
     * @return The created case base with the cases in the storage.
     * @throws ExecutionException
     */
    public CBRCaseBase preCycle() throws ExecutionException, demo.demo.jcolibri.exception.ExecutionException;

    /**
     * Executes a CBR cycle with the given query.
     * @throws ExecutionException
     */
    public void cycle(CBRQuery query,int k) throws ExecutionException;

    /**
     * Runs the code to shutdown the application. Typically it closes the connector.
     * @throws ExecutionException
     */
    public void postCycle() throws ExecutionException;
}
