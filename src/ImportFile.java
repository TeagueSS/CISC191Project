import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class ImportFile extends Thread

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
 *         Responsibilities of class: Import our CSV file (which holds all of
 *         our streets as individual lines) and convert them into street
 *         sections to be held within a traffic year.
 */
{

	/**
	 * getStreetYearFromFile
	 * 
	 * Purpose: reads in a CSV file containing data on street sections and returns a
	 * TrafficYear object with this data.
	 * 
	 * 
	 * @param inputFileLocation is the location of the file the user wishes to get
	 *                          data from
	 * @return StreetYear is the year worth of streets we get from the data set the
	 *         user passes
	 * 
	 *         Logic:
	 * 
	 *         It first reads in the CSV file using the scanner, and creates a stack
	 *         to hold temporary StreetSection objects. it then creates a counter to
	 *         keep track of how many of these streets we will find next it loops
	 *         through each line of the file (skipping the first line which contains
	 *         labels) and creates a StreetSection object for each line ( which is
	 *         added to the stack.) we use a stack because we don't know how many of
	 *         these objects we have depending on the length of the file)
	 * 
	 *         Once all lines have been read, the method creates an array of
	 *         StreetSections (Which we now know the length of because of our
	 *         counter we created earlier) and fill by popping the StreetSection
	 *         objects from the stack.
	 * 
	 *         Lastly we create a TrafficYear object using this array and returns
	 *         it. If there is an exception during the file reading process, an
	 *         empty TrafficYear object is returned.
	 */
	String fileLocation; // ImportFile has-a file location

	TrafficYear trafficYear; // ImportFile has-a TrafficYear

	/**
	 * constructor
	 * 
	 * this is an overloaded constructor for if they want to pass us the file
	 * location at the time they create the file importer
	 */
	public ImportFile(String fileLocation) {
		// saving our local file location
		this.fileLocation = fileLocation;
	}

	/*
	 * run - our multi-threaded start function
	 * 
	 */
	public void run() {

		trafficYear = getStreetYearFromFile(fileLocation);

	}

	/*
	 * getTrafficYear - a getter for our traffic year
	 * 
	 */
	public TrafficYear getTrafficYear() {
		return trafficYear;
	}

	public TrafficYear getStreetYearFromFile(String inputFileLocation) {
		// Creating a counter to keep track of how many of
		// these street objects we are creating
		int counter = 0;

		Scanner fileReader = null;
		// try to import our file with a try catch block,
		// if it fails then we can throw an exception
		try {
			// Creating our stack to hold all of our Street Objects
			Stack<StreetSection> stackOfStreetSections = new Stack<>();

			// Creating our scanner and giving it our file which we wish to it to read
			fileReader = new Scanner(new File(inputFileLocation));

			// Denoting what we wish to have separate each line within our file
			fileReader.useDelimiter(",");

			// Here we are throwing away our first line because it is the labeling of our
			// file
			@SuppressWarnings("unused")
			String throwArrayValue = fileReader.nextLine();

			// creating a current line variable to hold our input data
			String currentLine = "";
			// Creating an array to hold all of the values once we split them
			String[] arrayOfSplitValues;

			// Looping through each entry within this file through the has next method
			// which will return a boolean if the file has a next line to import

			while (fileReader.hasNextLine()) {
				// Increasing our counter
				counter++;

				// Saving our current line locally
				currentLine = fileReader.nextLine();
				// Splitting this line by the commas, and turning it into an array
				arrayOfSplitValues = currentLine.split(",");

				// Creating a temporary street object
				StreetSection temporaryStreetSection;

				// We don't want to import our first line so we will skip number 1
				// This is because our first line is just the labeling of the file

				// Adding all of our information
				temporaryStreetSection = new StreetSection(arrayOfSplitValues[0], arrayOfSplitValues[1],
						Double.parseDouble(arrayOfSplitValues[2]), arrayOfSplitValues[3], arrayOfSplitValues[4],
						Integer.parseInt(arrayOfSplitValues[5]), Integer.parseInt(arrayOfSplitValues[6]),
						Double.parseDouble(arrayOfSplitValues[7]), Double.parseDouble(arrayOfSplitValues[8]),
						Integer.parseInt(arrayOfSplitValues[9]), arrayOfSplitValues[10],
						Double.parseDouble(arrayOfSplitValues[11]));

				// Pushing our temporary street object to the stack
				// so that we can hold it in memory until we need it
				stackOfStreetSections.push(temporaryStreetSection);

			}

			// Now that all of our streets are in the stack and we know the length of the
			// needed array
			// we can loop while our stack has a next entry and add them into our array

			// Creating our array, we want to remove 1 from the length
			// because our first line is just the labeling of the
			// data entries
			StreetSection[] arrayOfStreetSections = new StreetSection[counter];

			int secondaryCounter = 0;
			// Here we wish to loop until our stack is empty
			while (!stackOfStreetSections.empty()) {
				// Now that we know our array isn't empty we will Pop an item from the
				// stack and then add it to our array in reverse order
				// we can do this by taking our counter from earlier (which found the number of
				// streets)
				// and then decreasing the count within this counter
				arrayOfStreetSections[counter - (secondaryCounter + 1)] = stackOfStreetSections.pop();
				// Decreasing our counter

				secondaryCounter++;
			}

			// Now that we have our array of streetsSections we can format all of these
			// into street objects by calling our formatStreetSections method

			Street[] returnStreets = formatStreetSections(arrayOfStreetSections);

			// Creating a year of Streets object and passing it the array of streets we made
			TrafficYear returnTrafficYear = new TrafficYear(returnStreets);

			// Returning our array of streets
			return returnTrafficYear;

		} catch (Exception e) // A place to catch our exceptions
		{
			// Telling them we were unable to import the file
			System.out.println("Unable to import File");
			System.out.println("File Name: " + inputFileLocation + "Line: " + counter);
			e.printStackTrace(); // prints the stack trace

		} finally {
			// Now we can see if our file reader exists
			// and if it does close it
			if (fileReader != null) {
				fileReader.close();
			}

		}

		// If it fails we will return our empty traffic Year
		TrafficYear notFilledTrafficYear = new TrafficYear(1);
		return notFilledTrafficYear;

	}

	/**
	 * 
	 * Purpose: take in a year of street sections and whenever a street section's
	 * name matches another street section add that to the array which will become
	 * the sections within a street
	 * 
	 * @return our formatted array of street sections
	 */
	public Street[] formatStreetSections(StreetSection[] inputStreetSectionArray) {
		// TODO:
		/*
		 * Implementation:
		 * 
		 * We will use a hash table to bind street names to a stack with all streets
		 * with the same name
		 * 
		 * Create the hash table with the stack
		 * 
		 * -> loop through all of our street sections
		 * 
		 * if a name equals a previously found name, then add it to that List
		 * 
		 * if else: the name hasn't been found yet we will add it to our street names
		 * Hash table and then add this entry to that corresponding stack
		 * 
		 * once we have looped through all entries: convert all stacks into streets and
		 * the name of a street will be the string name of the road that it is binded to
		 * 
		 */

		// Creating our hash table to hold all of our street section names
		// and their corresponding sections

		Hashtable<String, ArrayList<StreetSection>> hashTable = new Hashtable<>();

		// Also creating an array list to hold all of the names we find
		// so that we can pull from them later
		ArrayList<String> listOfStreetNames = new ArrayList<String>();

		// Looping through all of the street sections within our import array

		for (int counter = 0; counter < inputStreetSectionArray.length; counter++) {
			// Checking if our hash table already has an entry with the same matching
			// name as our current street section

			if (hashTable.containsKey(inputStreetSectionArray[counter].getName())) {
				// If it does then we will add it to our arrayList by calling the hash table
				// entry with the same '
				// name and then adding it to that corresponding (By Street Name) array list
				hashTable.get(inputStreetSectionArray[counter].getName()).add(inputStreetSectionArray[counter]);
			} else {
				// If it doesn't exist then we will create a new entry within our hashTable

				// Here if it doesn't exist we will create a binding in our Hash table
				// and add our new link to it
				// in order to do this we will first create a local list to add
				// our entry to
				ArrayList<StreetSection> localList = new ArrayList<StreetSection>();
				// now we add our entry
				localList.add(inputStreetSectionArray[counter]);
				// here we also add the name we give it so we can keep track
				listOfStreetNames.add(inputStreetSectionArray[counter].getName());
				// Now that we have created our local list and added our current
				// street section we can add it to our hash table with it's binding
				hashTable.put(inputStreetSectionArray[counter].getName(), localList);
			}
		}

		// Now that all of our streetsSections have been organized and put with their
		// other matching street sections
		// we can turn each one of those street section lists into a Street

		// First we need to create an arrayList of Streets to add each street we
		// create to
		ArrayList<Street> listOfStreets = new ArrayList<Street>();

		for (int counter = 0; counter < listOfStreetNames.size(); counter++) {
			// Here for each entry within our binding (Whose names we have from our array
			// list)
			// we will take their array list, and give it to our Street object as it's
			// internal arrayList of streets
			ArrayList<StreetSection> localList = hashTable.get(listOfStreetNames.get(counter));
			// Converting our entry to an array
			// StreetSection[] temporaryArray = (StreetSection[]) localList.toArray();

			StreetSection[] temporaryArray = localList.toArray(new StreetSection[localList.size()]);// <-----

			// saving our entry as a street
			Street localStreet = new Street(temporaryArray);
			// adding our street to our stack of streets
			listOfStreets.add(localStreet);

		}

		// Now that all of our streets have been added to our street section array
		// we can create a traffic year out of them

		// converting our arrayList to an array of Streets and returning it
		return listOfStreets.toArray(new Street[listOfStreets.size()]);

	}

}