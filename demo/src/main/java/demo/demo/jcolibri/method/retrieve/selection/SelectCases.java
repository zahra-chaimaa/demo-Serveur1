/**
 * SelectCases.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 24/11/2007
 */
package demo.demo.jcolibri.method.retrieve.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import 	demo.demo.jcolibri.cbrcore.CBRCase;
import 	demo.demo.jcolibri.method.retrieve.RetrievalResult;

/**
 * Class that stores the selectAll and selectTopK methods.
 * 
 * @author Juan A. Recio-Garcia
 * @author Developed at University College Cork (Ireland) in collaboration with Derek Bridge.
 * @version 1.0
 */
public class SelectCases
{    
    /**
     * Selects all cases
     * @param cases to select
     * @return all cases
     */
    public static Collection<CBRCase> selectAll(Collection<RetrievalResult> cases)
    {
	Collection<CBRCase> res = new ArrayList<CBRCase>();
	for(RetrievalResult rr: cases)
		res.add(rr.get_case());
	return res;
    }
    
    /**
     * Selects top K cases
     * @param cases to select
     * @param k is the number of csaes to select
     * @return top k cases
     */
    public static Collection<CBRCase> selectTopK(Collection<RetrievalResult> cases, int k)
    {
	ArrayList<CBRCase> res = new ArrayList<CBRCase>();
	Iterator<RetrievalResult> cIter  =cases.iterator(); 
	for(int c=0; c<k && c<cases.size(); c++)
	    res.add(cIter.next().get_case());
	return res;    
    }
    
    /**
     * Selects all cases but returns them into RetrievalResult objects
     * @param cases to select
     * @return all cases into RetrievalResult objects
     */
    public static Collection<RetrievalResult> selectAllRR(Collection<RetrievalResult> cases)
    {
	return cases;
    }
    
    /**
     * Selects top k cases but returns them into RetrievalResult objects
     * @param cases to select
     * @return top k cases into RetrievalResult objects
     */
    public static Collection<RetrievalResult> selectTopKRR(Collection<RetrievalResult> cases, int k)
    {
	ArrayList<RetrievalResult> res = new ArrayList<RetrievalResult>();
	Iterator<RetrievalResult> cIter  =cases.iterator(); 
	for(int c=0; c<k && c<cases.size(); c++)
	    res.add(cIter.next());
	return res;    
    }
}
