/**
 * CompromiseDrivenSelection.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 21/11/2007
 */
package demo.demo.jcolibri.method.retrieve.selection.compromiseDriven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import 	demo.demo.jcolibri.cbrcore.Attribute;
import 	demo.demo.jcolibri.cbrcore.CBRCase;
import 	demo.demo.jcolibri.cbrcore.CBRQuery;
import 	demo.demo.jcolibri.exception.NoApplicableFilterPredicateException;
import 	demo.demo.jcolibri.method.retrieve.RetrievalResult;
import 	demo.demo.jcolibri.method.retrieve.FilterBasedRetrieval.FilterConfig;
import 	demo.demo.jcolibri.method.retrieve.FilterBasedRetrieval.predicates.FilterPredicate;
import 	demo.demo.jcolibri.method.retrieve.selection.SelectCases;
import 	demo.demo.jcolibri.method.retrieve.selection.compromiseDriven.CDRSet;
import 	demo.demo.jcolibri.util.AttributeUtils;

/**
 * Cases selection approach that chooses cases according to their compromises with the user's query.
 * The compromises are those attributes that do not satisfy the user's requirement.
 * That way cases are selected according to the number of compromises and their similarity.
 * 
 * See: 
 * D. McSherry. Similarity and compromise. In Case-Based Reasoning Research
 * and Development, 5th International Conference on Case-Based Reasoning,
 * ICCBR, pages 291-305, 2003.
 * 
 * @author Juan A. Recio-Garcia
 * @author Developed at University College Cork (Ireland) in collaboration with Derek Bridge.
 * @version 1.0
 */
public class CompromiseDrivenSelection
{
    /**
     * Returns a list of cases according with their compromises and similarity
     * @param query to compare with
     * @param cases to compare
     * @param preferences define the predicates that evaluate the user preferences
     * @return a CDRSet object that stores the list of selected cases, the "like" sets and the "covered" sets (see paper for details).
     */
    public static 	demo.demo.jcolibri.method.retrieve.selection.compromiseDriven.CDRSet CDR(CBRQuery query, Collection<RetrievalResult> cases, FilterConfig preferences)
    {
		demo.demo.jcolibri.method.retrieve.selection.compromiseDriven.CDRSet rs = new CDRSet();
	
	ArrayList<CBRCase> candidates = new ArrayList<CBRCase>(SelectCases.selectAll(cases));
	while(!candidates.isEmpty())
	{
	    CBRCase c1 = candidates.get(0);
	    rs.add(c1);
	    rs.addToLikeSet(c1, c1);
	    rs.addToCoveredSet(c1, c1);
	    candidates.remove(0);
	    for(CBRCase c2 : candidates)
	    {
		Set<Attribute> compromises1 = getCompromises(c1,query,preferences);
		Set<Attribute> compromises2 = getCompromises(c2,query,preferences);
		if( compromises1.equals(compromises2))
		    rs.addToLikeSet(c1, c2);
		if( compromises2.containsAll(compromises1) )
		    rs.addToCoveredSet(c1, c2);
	    }
	    candidates.removeAll(rs.getCoveredSet(c1));
	}
	return rs;
    }
    
    /**
     * Returns the compromises of a case
     * @param _case to find the compromises
     * @param query to compare
     * @param preferences define the predicates that evaluate the user preferences
     * @return a set of attributes
     */
    public static Set<Attribute> getCompromises(CBRCase _case, CBRQuery query, FilterConfig preferences)
    {
	Set<Attribute> compromises = new HashSet<Attribute>();
	
	for(Attribute at : preferences.getDefinedAttributes())
	{
	    try
	    {
		FilterPredicate predicate = preferences.getPredicate(at);
		Object caseObject = AttributeUtils.findValue(at, _case.getDescription());
		Object queryObject = AttributeUtils.findValue(at, query.getDescription());
		if(!predicate.compute(caseObject, queryObject))
		compromises.add(at);
	    } catch (NoApplicableFilterPredicateException e)
	    {
		org.apache.commons.logging.LogFactory.getLog(CompromiseDrivenSelection.class).error(e);
	    }
	}
	
	return compromises;
    }
}
