
/**
 * Lead Author(s):
 * 
 * @author Monica Lester 555006261
 * @author Teague Sangster 5550070825
 * 
 * 
 *         Other contributors: Rebekah Soliman, 5550084860
 * 
 * 
 *         References: Morelli, R., & Walde, R. (2016). Java, Java, Java:
 *         Object-Oriented Problem Solving. Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 3/9/23
 * 
 *         Responsibilities of class:
 * 
 *         Acts as a amalgamation of street section which we homogenize into one
 *         street object. This class is used to hold all of the information from
 *         street sections.
 * 
 */
public class Street implements Printable {
	// A street has many street sections
	private StreetSection[] sections;

	// A street has a name
	private String name;
	// A road has a length
	private double length;
	// A road has a IFC -
	private String internationalFireCode;
	// A street has an IFC description
	private String iFCDescription;
	// A road has a posted speed
	private int speed;
	// A road has an iway
	private int iWay;
	// A road has a VMT
	private double vMT;
	// A Road has a volume
	private double volumes;
	// A road has a number of lanes
	private int lanes;
	// a road has a Median type
	private String median;
	// a road has a shapeLength
	private double shapeLength;

	/*
	 * This is a constructor method for the class "Street". It takes an array of
	 * "StreetSection" objects as an argument and initializes various properties of
	 * the street object. It sets the name of the street, calculates the length by
	 * summing up the length of all street sections, sets the IFC, IFC description,
	 * speed, number of lanes, median type, shape length, average IWay, VMT and
	 * volume based on the values of the first street section object in the array
	 * and the averages of these values over all street sections in the array.
	 */
	public Street(StreetSection[] streetSections) {

		// Our name for all streets is the same so we can
		name = streetSections[0].getName();
		// The length of our street is cumulative so we will loop through and add the
		// length
		// as a sum
		for (int counter = 0; counter < streetSections.length; counter++) {
			// Increasing our current length
			length += streetSections[counter].getLength();
		}
		// Our iFC should match for all streets
		internationalFireCode = streetSections[0].getInternationalFireCode();
		// our IFC description should match for all streets
		iFCDescription = streetSections[0].getiFCDescription();
		// The speed for the highway should match the first one
		speed = streetSections[0].getSpeed();
		// A street has an average IWay
		// Looping through and combining
		for (int counter = 0; counter < streetSections.length; counter++) {
			// Increasing our current Iway
			iWay += streetSections[counter].getiWay();
		}
		// Taking the average
		iWay = iWay / streetSections.length;

		// a Street has an average VMT

		// Looping through to increase our VMT
		for (int counter = 0; counter < streetSections.length; counter++) {
			vMT += streetSections[counter].getVehcileMilesTraveled();
		}
		// Averaging the VMT
		vMT = vMT / streetSections.length;

		// a Street has an average Volume
		for (int counter = 0; counter < streetSections.length; counter++) {
			volumes += streetSections[counter].getVehcileMilesTraveled();
		}
		// Averaging the VMT
		volumes = volumes / streetSections.length;

		// A Street has a number of lanes
		lanes = streetSections[0].getLanes();
		// a road has a Median type
		median = streetSections[0].getMedian();
		// a road has a shapeLength
		shapeLength = streetSections[0].getShapeLength();

	}

	/**
	 * prettyPrintToString
	 * 
	 * Purpose: A toString method that prints all info line-by-line so the
	 * information is legible
	 *
	 * @return doesn't return anything just prints all the information
	 * 
	 */
	@Override
	public String prettyPrintToString() {
		// Creating our information string
		String returnString = "";
		// Adding all of the needed information:
		// adding our street name
		returnString += "Name: " + name + "\n";
		// adding our Number of sections
		returnString += " This street is comprised of: " + sections.length + "\n";
		// Adding the length
		returnString += " The length of this street is: " + length + "miles \n";
		// adding the traffic volume
		returnString += " The averaged Traffic volume is: " + volumes + "\n";
		// adding the IFC
		returnString += "This street's IFC (Industry Foundation Classes) is " + internationalFireCode + ", and is classified as: "
				+ iFCDescription + "\n";
		// adding speed
		returnString += "This street's posted speed is: " + speed + " MPH" + "\n";
		// adding in lanes
		returnString += "This street has " + lanes + " number of lanes \n";
		// adding in median. As this variable is a little more complex with wording,
		// adding in an if-else to detect whether there is a median or not to adjust
		// word choice
		if (median.contains("No Median")) {
			returnString += "This road has " + median + "\n";
		} else {
			returnString += "This road has a " + median + "\n";
		}
		// adding in iWay
		returnString += "This is a " + iWay + "-way street \n";
		return returnString;
	}

	@Override
	/**
	 * prettyPrintRelevantInformation
	 * 
	 * Purpose: a method to print out all of the information about the class object
	 * that a user might want to know
	 *
	 * @return doesn't return anything just prints all the information
	 * 
	 */
	public void prettyPrintRelevantInformation() {
		System.out.println("Name: " + name);
		System.out.println(" This street is comprised of: " + sections.length);
		System.out.println(" The length of this Street is: " + length);
		System.out.println(" The averaged Traffic volume is: " + volumes);
	}

	/*
	 * formatVMTAndVolumes
	 * 
	 * Purpose: a method to print The calculated Estimated traffic of passing cars
	 * and their miles traveled per capita
	 * 
	 * Properly format the VMT & Volume for output to user
	 */
	@Override
	public String formatVMTAndVolumes() {

		return "The calculated Estimated traffic of passing cars and their miles traveled per capita: "
				+ (vMT * volumes);
	}

	// Accessor & Mutator Methods:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternationalFireCode() {
		return internationalFireCode;
	}

	public void setInternationalFireCode(String iFC) {
		this.internationalFireCode = iFC;
	}

	public String getiFCDescription() {
		return iFCDescription;
	}

	public void setiFCDescription(String iFCDescription) {
		this.iFCDescription = iFCDescription;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getiWay() {
		return iWay;
	}

	public void setiWay(int iWay) {
		this.iWay = iWay;
	}

	public double getVMT() {
		return vMT;
	}

	public void setVMT(double vMT) {
		this.vMT = vMT;
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

}
