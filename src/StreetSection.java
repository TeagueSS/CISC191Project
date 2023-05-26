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
 * 
 * This class is meant to hold all of the information that a street section could have.
 * This class is created as an instance of a street section which is combined with other
 * street sections to create a street object. These street sections are also used in the
 * Traffic Year Class which is meant to hold all of the street sections found within a given year:
 */
public class StreetSection implements Printable 
{
	// A Street has an ID 
	private String objectID;
	// A street has a name 
	private String name;
	//A road has a length 
	private double length;
	//A road has a IFC -
	private String internationalFireCode;
	// A street has an IFC description 
	private String iFCDescription;
	// A road has a posted speed 
	private int speed;
	// A road has an iway 
	private int iWay;
	// A road has a VMT
	private double vehicleMilesTraveled;
	// A Road has a volume 
	private double volumes;
	//A road has a number of lanes 
	private int lanes;
	// a road has a Median type 
	private String median;
	// a road has a shapeLength
	private double shapeLength;
	
	
	
	
	// To String method 
	/*
	 * @Return String - all of the relevant information 
	 * about our street object 
	 * 
	 * 
	 */
	public String toString()
	{
		String returnString = "";
		// Adding all of our information
		returnString += " Object ID: " + objectID;
		returnString += " Street Name: " + name;
		returnString += " Street Length " + length;
		returnString += " Street IFC " + internationalFireCode;
		returnString += " Street Speed " + speed;
		returnString += " Steet VMT " + vehicleMilesTraveled;
		returnString += " Street Volumes " + volumes;
		returnString += " Street Lanes " + lanes;
		returnString += " Street Median " + median;
		returnString += " Street Shape " + shapeLength;
		
		return returnString;
	}
	
	
	/**	toStringRelevantInfo() 
	 * Purpose: Return all of the actually relevant information within our class
	 * (The things that the user might actually want to see)
	 * @return String:
	 */
	public String toStringRelevantInfo()
	{
    	String returnString = "";
    	//Adding relevant info
    	returnString += " Street Name: " + name;
    	returnString += " Number of Lanes: " + lanes;
    	returnString += " VMT: "+ vehicleMilesTraveled;
    	return returnString;
  	}
	
	
	// Creating constructors 
	// Here is our no Arg Constructor 
	public StreetSection()
	{
     
  	}
	
	
	// Here is our constructor that takes in all of our information 
	public StreetSection(String objectID, String name, double length , String iFC , String iFCDescription , int speed
			,int iWay, double vMT , double volumes , int lanes , String median , double shapeLength)
	{
		// Saving all of our information: 
		this.objectID = objectID;
		this.name = name;
		this.length = length;
		this.internationalFireCode = iFC;
		this.iFCDescription = iFCDescription;
		this.speed =speed;
		this.iWay = iWay;
		this.vehicleMilesTraveled = vMT;
		this.volumes = volumes;
		this.lanes = lanes;
		this.median = median;
		this.shapeLength = shapeLength;
	}
	
	
	//Street section constructor
	public StreetSection(StreetSection inputStreet) 
	{
		// Copying all of this information 
		this.objectID = inputStreet.getObjectID();
		this.name = inputStreet.getName();
		this.length = inputStreet.getLength();
		this.internationalFireCode = inputStreet.getInternationalFireCode();
		this.iFCDescription = inputStreet.getiFCDescription();
		this.speed =inputStreet.getSpeed();
		this.iWay = inputStreet.getiWay();
		this.vehicleMilesTraveled = inputStreet.getVehcileMilesTraveled();
		this.volumes = inputStreet.getVolumes();
		this.lanes = inputStreet.getLanes();
		this.median = inputStreet.getMedian();
		this.shapeLength = inputStreet.getShapeLength();
	}

	
	/**
	 * Purpose: Take in StreetSection and checks if it is equal to the current object.
	 * 
	 * @param inputStreet
	 * @return Boolean - weather the class matches or not 
	 * 
	 * 
	 *  The method returns true if all the fields of the input object are equal 
	 *  to the fields of the current object, and false otherwise.
	 */
	public boolean equals(StreetSection inputStreet)
	{
		// Checking each one of our values and returnig false if they don't match 
		if(! (inputStreet.getObjectID().equals(inputStreet.getObjectID())))
		{
			return false;
		}
		if(! (inputStreet.getName().equals(inputStreet.getName())))
		{
			return false;
		}
		if(! (inputStreet.getLength() == inputStreet.getLength() ))
		{
			return false;
		}
		if(! (inputStreet.getiFCDescription().equals(inputStreet.getiFCDescription())))
		{
			return false;
		}
		if(! (inputStreet.getInternationalFireCode().equals(inputStreet.getInternationalFireCode())))
		{
			return false;
		}
		if(! (inputStreet.getSpeed() == (inputStreet.getSpeed())))
		{
			return false;
		}
		if(! (inputStreet.getiWay() ==(inputStreet.getiWay())))
		{
			return false;
		}
		if(! (inputStreet.getVehcileMilesTraveled() ==(inputStreet.getVehcileMilesTraveled())))
		{
			return false;
		}
		if(! (inputStreet.getVolumes() ==(inputStreet.getVolumes())))
		{
			return false;
		}
		if(! (inputStreet.getMedian().equals(inputStreet.getMedian())))
		{
			return false;
		}
		if(! (inputStreet.getShapeLength() == (inputStreet.getShapeLength())))
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	// All of our getters and setters 
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public String getInternationalFireCode() {
		return internationalFireCode;
	}
	public void setIternationalFireCode(String ifc) {
		this.internationalFireCode = ifc;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getVehcileMilesTraveled() {
		return vehicleMilesTraveled;
	}
	public void setVechileMilesTraveled(double vMT) {
		this.vehicleMilesTraveled = vMT;
	}
	public double getVolumes() {
		return volumes;
	}
	public void setVolumes(double volumes) {
		this.volumes = volumes;
	}
	public int getLanes() {
		return lanes;
	}
	public void setLanes(int lanes) {
		this.lanes = lanes;
	}
	public String getMedian() {
		return median;
	}
	public void setMedian(String median) {
		this.median = median;
	}
	public double getShapeLength() {
		return shapeLength;
	}
	public void setShapeLength(double shapeLength) {
		this.shapeLength = shapeLength;
	}
	public String getiFCDescription() {
		return iFCDescription;
	}
	public void setiFCDescription(String iFCDescription) {
		this.iFCDescription = iFCDescription;
	}
	public int getiWay() {
		return iWay;
	}
	public void setiWay(int iWay) {
		this.iWay = iWay;
	}



	//Interface methods
	@Override
	/** prettyPrintRelevantInformation 
	 * 
	 *Purpose: a method to print out all of the information about the class 
	 *that a user might want to know 
	 *
	 *@return doesn't return anything just prints all the information 
	 * 
	 */
	public String prettyPrintToString() 
	{
		// Creating our information string 
		String returnString = "";
		// Adding all of the needed information:
		// adding our street name 
		returnString += "Name: " + name + "\n";
		// Adding the length 
		returnString += " The length of this street is: " + length + "miles \n";
		//adding the traffic volume 
		returnString += " The averaged Traffic volume is: " + volumes + "\n";
		//adding the IFC
		returnString += "This street's IFC (Industry Foundation Classes) is " + internationalFireCode  + ", and is classified as: " + iFCDescription + "\n";
		//adding speed
		returnString += "This street's posted speed is: " + speed + " MPH" + "\n";
		//adding in lanes
		returnString += "This street has " + lanes + " number of lanes \n";
		//adding in median. As this variable is a little more complex with wording,
		//adding in an if-else to detect whether there is a median or not to adjust word choice
		if (median.contains("No Median"))
		{
			returnString += "This road has " + median + "\n";
		}
		else
		{
			returnString += "This road has a " + median + "\n";
		}
		//adding in iWay
		returnString += "This is a " + iWay + "-way street \n";
		return returnString ;
	}

	@Override
	/** prettyPrintRelevantInformation 
	 * 
	 *Purpose: a method to print out all of the information about the class 
	 *that a user might want to know 
	 *
	 *@return doesn't return anything just prints all the information 
	 * 
	 */
	public void prettyPrintRelevantInformation() 
	{
		System.out.println("Name: " + name);
		System.out.println(" The length of this Street is: " + length);
		System.out.println(" The averaged Traffic volume is: " + volumes);
	}

	/* formatVMTAndVolumes 
	 * 
	 * Purpose: a method to print The calculated Estimated traffic of passing cars and their miles traveled per capita
	 * 
		Properly format the VMT & Volume for output to user
	*/
	@Override
	public String formatVMTAndVolumes()
	{
		
		return "The calculated Estimated traffic of passing cars and their miles traveled per capita: " + (vehicleMilesTraveled * volumes);
	}
	
}
