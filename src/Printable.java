
public interface Printable 
/**
 * Lead Author(s):
* @author Monica Lester 555006261
* @author Teague Sangster 5550070825
* 
*  
* Other contributors:
* Rebekah Soliman, 5550084860
* 
* 
* References:
* Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
* Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
* 
* <<add more references here>>
*  
* Version/date: 3/9/23
* 
* Responsibilities of class: 
* 
* Creates interfaces that classes to need implement when they handle the information from the database 
* 
* 
*/
{
	/**prettyPrintToString
	 * Purpose: format all of the needed surface level information within a class 
	 * 
	 * 
	 * @return
	 */
	public String prettyPrintToString();
	
	/** prettyPrintRelevantInformation
	 * Purpose: Print out any relevant information 
	 * within this class formatted for readability 
	 * 
	 */
	public void prettyPrintRelevantInformation();
	
	
	/** formatVMTAndVolumes
	 * 
	 * For any object that has a relevant VMT, volume ,and length 
	 * show the calculated estimated traffic on that road  
	 * 
	 * @return
	 */
	public String formatVMTAndVolumes();
	
}
