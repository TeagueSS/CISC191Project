
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
 * 
 *         A traffic year is all of the data SanDag collects and predicts for a
 *         year held as an object. Each one of it’s subsections are represented
 *         as Street Sections which are held within an internal array. Traffic
 *         Year also has methods for searching for street sections and creating
 *         a street (An aggregate of street sections). Traffic Years are used to
 *         hold and search but aren’t used to compare against one another,
 *         rather it is the Streets they provide which we compare.
 */
public class TrafficYear implements Printable {

	private Street[] arrayOfStreets;

	// Constructors

	/**
	 * Constructor
	 * 
	 * @param numberOfStreets
	 */
	public TrafficYear(int numberOfStreets) {
		arrayOfStreets = new Street[numberOfStreets];
	}

	/**
	 * Constructor
	 * 
	 * @param arrayOfStreets
	 */
	public TrafficYear(Street[] arrayOfStreets) {
		// taking the input array of Streets and saving it as our local array
		// of streets

		this.arrayOfStreets = arrayOfStreets;
	}

	/**
	 * createStreet
	 * 
	 * Purpose: Take in an array of streets and creates a street object out of it
	 * which it then returns for the user
	 * 
	 * 
	 * 
	 * @param inputStreetSectionArray - the
	 * @return Street
	 * 
	 *         Logic Summary:
	 * 
	 *         The createStreet method takes an array of StreetSection objects as
	 *         input and returns a Street object that contains all StreetSection
	 *         objects with the same name as the first StreetSection object in the
	 *         input array. It does so by first creating a new array to store all
	 *         matching StreetSection objects, then looping through the input array
	 *         to find all StreetSection objects with the same name as the first
	 *         one, and finally creating a new Street object using the array of
	 *         matching StreetSection objects and returning it.
	 * 
	 */
	/*
	 * public static Street createStreet(StreetSection[] inputStreetSectionArray) {
	 * // create a street object and copy everything from the first entry within our
	 * street array
	 * 
	 * StreetSection[] matchingStreetSections = new
	 * StreetSection[inputStreetSectionArray.length];
	 * 
	 * // loop through the array and if the name matches the first entry // we will
	 * add it to our array of streets
	 * 
	 * double runningVolume = 0; int numberOfFoundEntries = 0;
	 * 
	 * for(int counter = 0 ; counter < inputStreetSectionArray.length ; counter++) {
	 * if(inputStreetSectionArray[counter].getName().equals(inputStreetSectionArray[
	 * 0].getName())) { matchingStreetSections[numberOfFoundEntries++] =
	 * inputStreetSectionArray[counter]; } }
	 * 
	 * // Now looping through our array of matching streets (The ones that share the
	 * same name // and copying them to our returnStreetArray
	 * 
	 * StreetSection[] returnStreetArray = new StreetSection[numberOfFoundEntries];
	 * // Here we can loop for the numer we found or our numberOfFoundEntries
	 * for(int counter = 0 ; counter < numberOfFoundEntries ; counter++) { // adding
	 * them to our return array at their matching position
	 * returnStreetArray[counter] = matchingStreetSections[counter]; } // Finally
	 * creating a street out of this object Street returnStreet = new
	 * Street(returnStreetArray); // and returning it for the user return
	 * returnStreet; }
	 * 
	 */

	/*
	 * SearchForStreet Purpose: Take in a string and return any streets with
	 * matching names
	 * 
	 * 
	 * @param inputStreetName - the street name we are searching for
	 * 
	 * @return matchingStreetSections - the array of matching street sections that
	 * we found
	 * 
	 * Logic summary: The searchForStreet method takes a string as input and returns
	 * an array of all StreetSection objects with names that contain the input
	 * string. It does so by first looping through the local array of streets to
	 * find the number of StreetSection objects with names that contain the input
	 * string, then creating a new array of StreetSection objects with that size,
	 * and finally looping through the local array of streets again to find all
	 * StreetSection objects with names that contain the input string and adding
	 * them to the new array.
	 * 
	 */
	public Street[] searchForStreet(String inputStreetName) {
		// finding how many streets match
		int numberOfMatchingStreets = 0;
		// Looping through our entire array of streets and finding how many streets
		// match
		for (int counter = 0; counter < arrayOfStreets.length; counter++) {
			// Here we can use the indexOf() method
			// to find a streets who's name contains the input String

			// Creating a temporary name to hold our street name
			String searchingString = arrayOfStreets[counter].getName();
			// Searching for our street name
			// if our index of returns greater than -1 then we know to add
			// it to our array of street sections

			if (searchingString.contains(inputStreetName)) {
				numberOfMatchingStreets++;
				// System.out.println(arrayOfStreets[counter]);
			}
		}
		// Printing out so we know how many were found while searching
		// System.out.println("Found " + numberOfMatchingStreets + " Streets");

		// Now that we know how many there are we can make an array
		// of that length
		Street[] matchingStreets = new Street[numberOfMatchingStreets];

		int numberOfFoundStreets = 0;
		// Looping through and adding all of our relevant streets
		for (int counter = 0; counter < arrayOfStreets.length; counter++) {
			// Here we can use the indexOf() method again
			// to find a streets who's name contains the input String

			// Creating a temporary spot to hold our street name
			String searchingString = arrayOfStreets[counter].getName();
			// Searching for our street name
			// if our index of returns a number greater than -1 then we know to add
			// it to our array of Streets
			if (searchingString.contains(inputStreetName)) {

				// Now we want to add this street to our return array of street objects
				// In order to find the next non-empty slot we will loop through and check
				// each position if it is full we will continue to loop through
				// until we find an open entry

				// adding our street
				matchingStreets[numberOfFoundStreets++] = arrayOfStreets[counter];

			}
		}
		// Returning our array of matching street sections
		return matchingStreets;
	}

	/**
	 * @param inputStreetName
	 * @return StreetSection - the
	 */
	public Street searchForSpecificStreet(String inputStreetName) {
		boolean streetFound = false;
		int index = 0;
		// Looping through as many elements of the array needed to find the correct one
		do {
			// checking to see if the name of the street at index element contains the
			// input.
			// We use indexOf because we want to make sure the program catches results that
			// contain the entire input and nothing else.
			if (arrayOfStreets[index].getName().indexOf(inputStreetName) > 0)
				streetFound = true;

			index++;
		} while (index > arrayOfStreets.length || !streetFound);
		// once specific street has been found, the loop will be exited, and then we
		// will return
		// the Street at the index we left off on
		return arrayOfStreets[index];

	}

	// setters & getters

	public Street[] getArrayOfStreets() {
		return arrayOfStreets;
	}

	public void setArrayOfStreets(Street[] arrayOfStreets) {
		this.arrayOfStreets = arrayOfStreets;
	}

	public Street getStreetAt(int streetLocation) {
		return arrayOfStreets[streetLocation];
	}

	public void setStreetAt(int arrayLocation, Street inputStreet) {
		// adding to our input array at this position

		arrayOfStreets[arrayLocation] = inputStreet;
	}

	public Integer getNumberOfStreets() {
		// Returning our number of streets our our internal array length
		return arrayOfStreets.length;
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
		// Use a for loop to access each elements data
		for (int index = 0; index > arrayOfStreets.length; index++) {
			// Adding all of the needed information:
			// adding our street name
			returnString += "Name: " + arrayOfStreets[index].getName() + "\n";
			// adding our Number of sections
			returnString += " This street is comprised of: " + arrayOfStreets + "\n";
			// Adding the length
			returnString += " The length of this street is: " + arrayOfStreets[index].getLength() + "miles \n";
			// adding the traffic volume
			returnString += " The averaged Traffic volume is: " + arrayOfStreets[index].getVolumes() + "\n";
			// adding the IFC
			returnString += "This street's IFC (Industry Foundation Classes) is " + arrayOfStreets[index].getInternationalFireCode()
					+ ", and is classified as: " + arrayOfStreets[index].getiFCDescription() + "\n";
			// adding speed
			returnString += "This street's posted speed is: " + arrayOfStreets[index].getSpeed() + " MPH" + "\n";
			// adding in lanes
			returnString += "This street has " + arrayOfStreets[index].getLanes() + " number of lanes \n";
			// adding in median. As this variable is a little more complex with wording,
			// adding in an if-else to detect whether there is a median or not to adjust
			// word choice
			if (arrayOfStreets[index].getMedian().contains("No Median")) {
				returnString += "This road has " + arrayOfStreets[index].getMedian() + "\n";
			} else {
				returnString += "This road has a " + arrayOfStreets[index].getMedian() + "\n";
			}
			// adding in iWay
			returnString += "This is a " + arrayOfStreets[index].getiWay() + "-way street \n";
		}
		return returnString;
	}

	/**
	 * prettyPrintRelevantInformation
	 * 
	 * Purpose: a method to print out the all the information about the TrafficYear
	 * object that that a user might want to know
	 *
	 * @return doesn't return anything just prints all the information
	 * 
	 */
	@Override
	public void prettyPrintRelevantInformation() {
		// Telling the user the traffic year sections and information
		System.out.println("This traffic year has " + arrayOfStreets.length + " Street Sections");
		System.out.println("The total estimated Vehicle Miles Traveled per capita within this year is:");

		// Finding the total number of VMT by looping through and calculating

		// Creating a tab of the VMT
		double totalVehicleMilesTraveled = 0;
		for (int counter = 0; counter < arrayOfStreets.length; counter++) {

			totalVehicleMilesTraveled += arrayOfStreets[counter].getVMT();
		}
		System.out.println(totalVehicleMilesTraveled);
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
		String returnString = "The calculated Estimated traffic of passing cars and their miles traveled per capita: ";
		// initializing our total variable with 0, then use a for loop to cycle through
		// each year of data
		// adding it to our total
		double totalVehicleMilesTraveled = 0;
		for (int counter = 0; counter < arrayOfStreets.length; counter++) {
			totalVehicleMilesTraveled += arrayOfStreets[counter].getVMT();
		}

		// repeat the process above, but for our Volume data
		double totalVolumeTraveled = 0;
		for (int counter = 0; counter < arrayOfStreets.length; counter++) {
			totalVolumeTraveled += arrayOfStreets[counter].getVolumes();
		}

		// now tabulate the total estimate with both of our now totalled variables
		// and add to the string to be returned
		returnString += totalVolumeTraveled * totalVehicleMilesTraveled;

		return returnString;
	}
}
