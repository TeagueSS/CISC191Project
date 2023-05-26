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
* This file is a testing file for all the initial methods where something could go wrong 
*/
class Project1Test 
{

//	@Test
//	void testToStringRelevantInfo() 
//	{
//		int numberOfLanesEx = 2;
//		double vMTEx = 5.5;
//		StreetSection street1 = new StreetSection();
//		
//		//populate any
//		street1.setName("ABC Street");
//		street1.setLanes(numberOfLanesEx);
//		street1.setVechileMilesTraveled(vMTEx);
//		
//		System.out.println(street1.toStringRelevantInfo());
//		
//		assertEquals("ABC Street", street1.getName());
//		assertEquals(2 , street1.getLanes());
//		assertEquals(5.5 , street1.getVehcileMilesTraveled());
//	}
	
//	@Test 
//	void testSearchForStreet()
//	{
//		StreetSection street1 = new StreetSection();
//		StreetSection street2 = new StreetSection();
//		StreetSection street3 = new StreetSection();
//		StreetSection street4 = new StreetSection();
//		StreetSection street5 = new StreetSection();
//		
//		// Populating our streets with names 
//		street1.setName("Camino Del Sur");
//		street2.setName("North Del Norte");
//		street3.setName("I-5");
//		street4.setName("Route 56");
//		street5.setName("15 North");
//		
//		//Putting all of these streets within an array 
//		
//		StreetSection[] testingArrayOfStreets = new StreetSection[5];
//		
//		// Adding all of our streets to this array 
//		
//		testingArrayOfStreets[0] = street1;
//		testingArrayOfStreets[1] = street2;
//		testingArrayOfStreets[2] = street3;
//		testingArrayOfStreets[3] = street4;
//		testingArrayOfStreets[4] = street5;
//		
//		TrafficYear testingYear = new TrafficYear(5);
//		
//		testingYear.setStreetAt(0, street1); 
//		testingYear.setStreetAt(1, street2); 
//		testingYear.setStreetAt(2, street3); 
//		testingYear.setStreetAt(3, street4); 
//		testingYear.setStreetAt(4, street5); 
//		
//		// Searching for our streets 
//		// Should return 2 streets 
//		assertEquals(street1 , street1);
//		
//		assertArrayEquals( new StreetSection[]{street1, street2} , testingYear.searchForStreet("Del") );
//		// Should return 1 street 
//		assertArrayEquals( new StreetSection[]{street2} , testingYear.searchForStreet("Del Norte") );
//		
//		
//	}
	
//	@Test 
//	void testFileImporting()
//	{
//		// Creating a traffic File Reader
//		ImportFile fileImporter = new ImportFile();
//		// Reading a traffic file 
//		TrafficYear trafficYearToPrint = fileImporter.getStreetYearFromFile("E:\\School\\JavaProject1_ComparingStreetTrafficData\\src\\testingImporting.csv ");
//		//printing out one of theStreets 
//		StreetSection temporaryTrafficStreet = trafficYearToPrint.getStreetAt(1);
//		// Printing out the information 
//		System.out.println(temporaryTrafficStreet.toString());
//		
//		// Checking we imported 3 streets 
//		assertEquals(3 , trafficYearToPrint.getNumberOfStreets());
//		// Checking that our street objects match 
//		
//		// Checking the amount of memory this uses:
//		//Instrumentation instrumentation = null;
//		
//		//instrumentation.getObjectSize(trafficYearToPrint);
//		
//	}
	
	
	
	/* testImportingYear 
	 * 
	 * Purpose: Checks to see that when we import a street, all of the input streets have been initalized 
	 * 
	 */
//	@Test
//	void testImportingYear()
//	{
//		// Creating a traffic File Reader
//		ImportFile fileImporter = new ImportFile();
//		// Creating a traffic year 
//		TrafficYear year2016 = fileImporter.getStreetYearFromFile(
//				"E:\\School\\JavaProject1_ComparingStreetTrafficData\\src\\ABM2Plus_2021RP_2025_Network_Volumes.csv ");
//		// Searching for the street del sur 
//		
//		
//		// Looping through and making sure none of our returned streets are null 
//		for(int counter = 0 ; counter < year2016.getNumberOfStreets() ; counter++)
//		{
//			assertTrue(year2016.getStreetAt(counter) != null);
//		}
//	}
	
	
	/* testGettingStreetNamesFromSearch
	 * Purpose: Check that all of the streets contain data and aren't initalized with 
	 * empty values  
	 * 
	 */
//	@Test
//	void testYearValuesHaveBeenInitalized()
//	{
//		// Creating a traffic File Reader
//		ImportFile fileImporter = new ImportFile();
//		// Creating a traffic year 
//		TrafficYear year2016 = fileImporter.getStreetYearFromFile(
//				"E:\\School\\JavaProject1_ComparingStreetTrafficData\\src\\ABM2Plus_2021RP_2025_Network_Volumes.csv ");
//		// Searching for the street del sur 
//		
//		// Looping through each entry within our traffic year and checking 
//		// that all of the important information doesn't come back as null 
//		
//		for(int counter = 0 ; counter < year2016.getNumberOfStreets() ; counter++)
//		{
//			// Saving a local copy of our street 
//			StreetSection temporaryStreet = year2016.getStreetAt(counter);
//			// Checking that this street has all of it's values initialized 
//			
//			// Checking that our name has been initalized 
//			assertTrue(temporaryStreet.getName() != null);
//			// If a number hasn't been initialized it would be 0, 
//			// so we can check that they are initialized by checking for 0 
//			// because they would never be 0 
//			assertTrue(temporaryStreet.getLanes() != 0);
//			assertTrue(temporaryStreet.getVehcileMilesTraveled() != 0.0);
//			assertTrue(temporaryStreet.getSpeed() != 0);
//			
//		}
//	}
	
	
	/* testImportingYearSearch
	 * 
	 * Purpose: Checking that when we search something like "DEL" we are returning an array 
	 * of initalized streets (We are checking that all streets are initalized)
	 * 
	 */
//	@Test
//	void testImportingYearSearch()
//	{
//		// Creating a traffic File Reader
//		ImportFile fileImporter = new ImportFile();
//		// Creating a traffic year 
//		TrafficYear year2016 = fileImporter.getStreetYearFromFile(
//				"E:\\School\\JavaProject1_ComparingStreetTrafficData\\src\\ABM2Plus_2021RP_2025_Network_Volumes.csv ");
//		// Searching for the street del sur 
//		
//		StreetSection[] foundStreets = year2016.searchForStreet("DEL");
//		
//		// Looping through and making sure none of our returned streets are null 
//		for(int counter = 0 ; counter < foundStreets.length ; counter++)
//		{
//			assertTrue(foundStreets[counter] != null);
//		}
//	}
	
	
	/* testGettingStreetNamesFromSearch
	 * Purpose: Check that all of the streets are are returning have names 
	 * 
	 */
//	@Test
//	void testGettingStreetNamesFromSearch()
//	{
//		// Creating a traffic File Reader
//		ImportFile fileImporter = new ImportFile();
//		// Creating a traffic year 
//		TrafficYear year2016 = fileImporter.getStreetYearFromFile(
//				"E:\\School\\JavaProject1_ComparingStreetTrafficData\\src\\ABM2Plus_2021RP_2025_Network_Volumes.csv ");
//		// Searching for the street del sur 
//		
//		StreetSection[] foundStreets = year2016.searchForStreet("DEL");
//		
//		// Looping through and making sure none of our returned streets are null 
//		for(int counter = 0 ; counter < foundStreets.length ; counter++)
//		{
//			assertTrue(foundStreets[counter].getName() != null);
//		}
//	}

}
