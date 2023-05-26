
public class FormatEntries
/**
 * Lead Author(s):
 * 
 * @author Monica Lester 555006261
 * @author Teague Sangster 5550070825
 * 
 * 
 *         Other contributors: Rebekah Soliman, 5550084860
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
 *         Take in an array of streets (the same street with data pertaining to each year it was collected)
 *         and provide methods for formatting things within our class. These
 *         formatting methods include printing relevant street information for
 *         all the streets, showing the increase overtime in comparison to our initial 2016 data.
 * 
 */
{

	private Street[] arrayOfStreets;

	public FormatEntries(Street[] arrayOfStreetOverTime) {
		this.arrayOfStreets = arrayOfStreetOverTime;
	}

	// We also need another method to loop through an array of streets and print
	// their name
	public void printRelevantStreetInfo() {
		// Cycle through each row in the array to access each street
		for (int counter = 0; counter > 4; counter++) {
			System.out.println(arrayOfStreets[counter].prettyPrintToString());
		}
	}

	/*
	 * 
	 * Take the street's year (Which we can assume is in order from
	 * 2016,2025,2035,2050 and print the streets year (what year it is) and its
	 * increase respective to the previous year (We get the increase from
	 * findStreetTrafficIncrease), and finally with findStreetTrafficRateOfChange we
	 * can calculate the change overtime
	 * 
	 */
	public void printStreetTrafficIncrease() {

		// Calling our findStreetTrafficRateOfChange method to format our data

		double[] trafficIncrease = findStreetTrafficRateOfChange();

		// Printing our information for our street
		System.out.println("For the street with the name: " + arrayOfStreets[0].getName());
		System.out.println("Here is the increase in Traffic Volumes  : ");
		System.out.println();

		System.out.println("Volume of the year 2016: " + arrayOfStreets[0].getVolumes());
		System.out.println("This increases to 2025 year over year by a rate of: " + trafficIncrease[0] + "%");
		System.out.println("To give us a predicted Volume in 2025 of: " + arrayOfStreets[1].getVolumes());
		System.out.println();
		System.out.println("This increases to 2035 year over year by a rate of: " + trafficIncrease[1] + "%");
		System.out.println("To give us a predicted Volume in 2035 of: " + arrayOfStreets[2].getVolumes());
		System.out.println();
		System.out.println("This increases to 2050 year over year by a rate of: " + trafficIncrease[2] + "%");
		System.out.println("To give us a predicted Volume in 2050 of: " + arrayOfStreets[3].getVolumes());

	}

	/*
	 * Purpose: A method to loop through the VMT traffic of each street within the
	 * array, hold that in an array of Doubles, and then compute the average rate of
	 * change from one data set to the next which will also be in the form of an
	 * array which we can return for the user
	 * 
	 */
	public double[] findStreetTrafficRateOfChange() {

		double[] volumeData = new double[arrayOfStreets.length];
		// create array to hold computed values, length of previous array - 1 as we will
		// have one year with no year to compare to
		double[] volumeIncreasePercentage = new double[volumeData.length - 1];

		// Input the VMT data of requested street from each year and inputting into
		// VMTData Array for manipulation
		for (int index = 0; index < arrayOfStreets.length; index++) {
			volumeData[index] = this.arrayOfStreets[index].getVolumes();
		}

		// calculating average from 2016 to 2025 and populating percentage array for
		// easy printing to user
		volumeIncreasePercentage[0] = (((volumeData[1] / volumeData[0])) / (2025 - 2016)) * 100;

		// calculating average from 2025 to 2035 and populating percentage array for
		// easy printing to user
		volumeIncreasePercentage[1] = (((volumeData[2] / volumeData[1])) / (2035 - 2025)) * 100;

		// calculating average from 2035 to 2050 and populating percentage array for
		// easy printing to user
		volumeIncreasePercentage[2] = (((volumeData[3] / volumeData[2])) / (2050 - 2035)) * 100;

		return volumeIncreasePercentage;

	}

	// Method to return calculated and formtted street info as a string
	public String toStringStreetTrafficIncrease() {
		double[] trafficIncrease = findStreetTrafficRateOfChange();
		return "\r\n\r\n For the street with the name: " + arrayOfStreets[0].getName()
				+ "Here is the increase in Traffic Volumes  :\r\n" + "Volume of the year 2016: "
				+ arrayOfStreets[0].getVolumes() + "\r\n" + "This increases to 2025 year over year by a rate of: "
				+ trafficIncrease[0] + "%\r\n" + "To give us a predicted Volume in 2025 of: "
				+ arrayOfStreets[1].getVolumes() + "\r\n\r\n" + "This increases to 2035 year over year by a rate of: "
				+ trafficIncrease[1] + "% \r\n" + "To give us a predicted Volume in 2035 of: "
				+ arrayOfStreets[2].getVolumes() + "\r\n\r\n" + "This increases to 2050 year over year by a rate of: "
				+ trafficIncrease[2] + "%\r\n" + "To give us a predicted Volume in 2050 of: "
				+ arrayOfStreets[3].getVolumes() + "\r\n\r\n\r\n"
				+ "Thanks for searching! \n Enter or select a new street name to view it's data.";
	}
}
