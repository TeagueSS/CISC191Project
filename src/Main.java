import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main
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
 *         Version/date: 4/27/23
 * 
 *         Responsibilities of class:
 * 
 *         Act as an executable that can be ran to start the program.
 * 
 */
{

	/*
	 * This program compares San Diego traffic data from 2016 to 2050. The data is
	 * imported from CSV files using the ImportFile class. The program prompts the
	 * user to enter a street name through the prompt user class, it then takes this
	 * response and searches for that street section name in the data sets, once it
	 * finds a match it prints out matches for the user to select from through the
	 * prompt user class we get their choice and then pull that same street sections
	 * from all of the years we imported (2016,2025,2035,2050) now that we have all
	 * of the matching street sections we aggregate the matching street sections
	 * into a Street (a street is made of many street sections) once we have our
	 * Street (Our aggregated street sections) we call our formatEntries method to
	 * print out the information about the 4 streets we created (1 for each year)
	 * Once the information and changes year from year have been printed the program
	 * terminates
	 * 
	 */
	public static void main(String[] args) {

		// Putting everything in a try catch block so that it doesn't crash
		try {
			// Creating a file import object

			// ImportFile fileImporter = new ImportFile();

			// Creating 4 file importers and passing them the location of each file so that
			// they can import each concurrently
			ImportFile fileImporter2016 = new ImportFile("ABM2Plus_2021RP_2016_Network_Volumes.csv");
			ImportFile fileImporter2025 = new ImportFile("ABM2Plus_2021RP_2025_Network_Volumes.csv");
			ImportFile fileImporter2035 = new ImportFile("ABM2Plus_2021RP_2035_Network_Volumes.csv");
			ImportFile fileImporter2050 = new ImportFile("ABM2Plus_2021RP_2050_Network_Volumes.csv");

			// Creating our traffic years 
			TrafficYear year2016;
			TrafficYear year2025;
			TrafficYear year2035;
			TrafficYear year2050;
			
			
			// tell them to start and then join a thread
			fileImporter2016.start();
			fileImporter2025.start();
			fileImporter2035.start();
			fileImporter2050.start();

			fileImporter2016.join();
			fileImporter2025.join();
			fileImporter2035.join();
			fileImporter2050.join();

			// saving the traffic years we imported from this:
			 year2016 = fileImporter2016.getTrafficYear();
			 year2025 = fileImporter2025.getTrafficYear();
			 year2035 = fileImporter2035.getTrafficYear();
			 year2050 = fileImporter2050.getTrafficYear();
			
			
			
			// *********** HERE IS A NON- MULTITHREADED IMPORTATION ***************
			// saving their traffic year
			// Importing all of our data sets and saving them as traffic years
			/*
			 * TrafficYear year2016 =
			 * fileImporter.getStreetYearFromFile("ABM2Plus_2021RP_2016_Network_Volumes.csv"
			 * ); //
			 * "E:\School\JavaProject1_ComparingStreetTrafficData\src\ABM2Plus_2021RP_2016_Network_Volumes.csv"
			 * TrafficYear year2025 =
			 * fileImporter.getStreetYearFromFile("ABM2Plus_2021RP_2025_Network_Volumes.csv"
			 * );
			 * 
			 * TrafficYear year2035 =
			 * fileImporter.getStreetYearFromFile("ABM2Plus_2021RP_2035_Network_Volumes.csv"
			 * );
			 * 
			 * TrafficYear year2050 =
			 * fileImporter.getStreetYearFromFile("ABM2Plus_2021RP_2050_Network_Volumes.csv"
			 * );
			 */

			// once we have the correct street grabbing it from the other data sets
			// we will hold all of this information in a double array
			// as we will have an array of arrays of street sections (The matching street
			// sections we find)
			Street[][] requestedStreetAllData = new Street[4][2];

			// Creating a new yearsOfStreets to hold all of our averaged data
			Street[] yearsOfStreet = new Street[4];

			yearsOfStreet[0] = requestedStreetAllData[0][0];
			yearsOfStreet[1] = requestedStreetAllData[1][0];
			yearsOfStreet[2] = requestedStreetAllData[2][0];
			yearsOfStreet[3] = requestedStreetAllData[3][0];

			// Implementation of GUI
			// Creating a JFrame

			JFrame jFrame = new JFrame();

			// Setting a title layout
			jFrame.setLayout(new BorderLayout());

			// adding a title
			JLabel titleLabel = new JLabel("Search For Traffic Street Increase!");

			// Creating a panel to hold our title as well as our search bar
			JPanel northPanel = new JPanel();
			// Setting it's layout to be a grid
			// 2 high 1 wide
			northPanel.setLayout(new GridLayout(2, 1));

			// Creating our search box

			//

			JTextField searchBox = new JTextField(24);
			// Creating our search Button
			JButton searchButton = new JButton();
			// Setting our button text field
			searchButton.setText("Search");
			// setting our button's color to green
			searchButton.setBackground(Color.GREEN);

			// combining our JButton and JTextField into one jointed object
			// Creating a panel to hold our title as well as our search bar
			JPanel searchButtonPanel = new JPanel();
			// Setting it's layout to be a grid
			// 2 wide 1 high
			searchButtonPanel.setLayout(new GridLayout(1, 2));
			// adding our jTextField and our JButton
			searchButtonPanel.add(searchBox);
			searchButtonPanel.add(searchButton);

			// Adding our title to our upper Panel
			northPanel.add(titleLabel);
			northPanel.add(searchButtonPanel);

			// Creating a center panel
			JPanel centerPanel = new JPanel();
			// giving it a grid layout
			centerPanel.setLayout(new GridLayout(1, 2));

			// creating a innerPanel for selecitng
			JPanel selectingPanel = new JPanel();
			// Setting it's layout
			selectingPanel.setLayout(new GridLayout(2, 1));

			String aboutAuthors = " \r\n This program was created as a final project for the authors 'Intermediate Java' course, "
					+ " \r\n and is intented to showcase all the skills learned and honed throughout said course. \r\n \r\n"
					+ " Contributors: \r\n \r\n"
					+ " \r\n Teague Sangster is a Computer Science major at SDCCD working towards transferring to \r\n The Cal State System and aims to get a job with time spent solving problems"
					+ " \r\n Monica Lester is a Computer Science major as well, intending to transfer and continue \r\n collecting the knowledge and diverse skill set(s) needed to excell in the industry. "
					+ " \r\n \r\n Special Thanks to Rebeckah Soliman for providing much needed assitance throughout our project.";
			// JTextArea

			// creating a text box to display the instructions and introduce the program
			JTextArea howToUseTheProgram = new JTextArea(
					"Enter a San Diego street name into the search bar and press the green 'search' button. "
							+ "\r\n The data for your street will populate here."
							+ "\r\n If we cannot locate your street, select one from the drop-down menu that appears. \r\n \r\n"
							+ aboutAuthors);

			// Making this information un-editable
			howToUseTheProgram.setEditable(false);

			// Creating a main text box which is what
			// will take up the majority of our screen
			JTextArea mainTextBox = new JTextArea(
					"Welcome to traffic street view, search for a street to get started \n "
							+ "Please make sure your search is in all upper case letters.");

			// Creating our search function allowing users to search for street data by
			// typing in a street name or selecting one from the drop down menu
			JPanel streetSearchPanel = new JPanel();
			// setting our searchPanel to look better
			streetSearchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder(),
					"Input Search Criteria"));
			// Creating a JComboBox
			JComboBox<String> streetSearchDropDown = new JComboBox<>();
			// allowing user to type in a street name to the search bar
			streetSearchDropDown.setEditable(true);

			// adding an action listener
			streetSearchDropDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Here we have our code in a try catch in case the user tries to search
					// for a street which doesn't exist
					try {
						// Creating our array of matching streets
						Street[] arrayOfMatchingStreets;

						// Getting the text the user passed to us
						String searchedText = searchBox.getText();
						// saving our found streets to an array
						arrayOfMatchingStreets = year2016.searchForStreet(searchedText);

						// taking the street they selected by index, and then finding that
						// street within the array
						Street selectedStreet = arrayOfMatchingStreets[streetSearchDropDown.getSelectedIndex()];
						// taking the street and getting it's information

						// setting our requested Street all data with all the streets we get from
						// a given year
						requestedStreetAllData[0] = year2016.searchForStreet(selectedStreet.getName());
						requestedStreetAllData[1] = year2025.searchForStreet(selectedStreet.getName());
						requestedStreetAllData[2] = year2035.searchForStreet(selectedStreet.getName());
						requestedStreetAllData[3] = year2050.searchForStreet(selectedStreet.getName());

						// Creating a new yearsOfStreets to hold all of our averaged data
						Street[] yearsOfStreet = new Street[4];

						// Taking the first entry from all of our found streets & storing it:

						yearsOfStreet[0] = requestedStreetAllData[0][0];
						yearsOfStreet[1] = requestedStreetAllData[1][0];
						yearsOfStreet[2] = requestedStreetAllData[2][0];
						yearsOfStreet[3] = requestedStreetAllData[3][0];

						// Create a FormatEntries object and feed it all the collected, sorted, and
						// averaged data
						// stored within our yearsOfStreet array to be formatted and outputted to the
						// user
						FormatEntries entryFormatter = new FormatEntries(yearsOfStreet);

						// saying how many matching streets we found
						mainTextBox.setText(entryFormatter.toStringStreetTrafficIncrease());
						// restricting the user from altering the text
						mainTextBox.setEditable(false);

					} catch (Exception exception) {
						// notifying the user their search did not match anything and prompting new
						// input
						mainTextBox.setText("No matching streets found. Please enter a new search term.");
						mainTextBox.setEditable(false);
					}

				}
			});

			// Adding a button listener to initiate our search
			searchButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// Here we have our code in a try catch in case the user tries to search
					// for a street which doesn't exist
					try {

						// Creating our array of matching streets
						Street[] arrayOfMatchingStreets;

						// clearing our current streetSearchDropDown
						streetSearchDropDown.removeAllItems();

						// Getting the text the user passed to us
						String searchedText = searchBox.getText();
						// saving our found streets to an array
						arrayOfMatchingStreets = year2016.searchForStreet(searchedText);
						// saying how many matching streets we found
						mainTextBox.setText("Found: " + arrayOfMatchingStreets.length + " Matching Streets");

						// looping through and copying all of our names
						for (int counter = 0; counter < arrayOfMatchingStreets.length; counter++) {
							// taking our name at a given counter and
							// adding that name to our drop down
							streetSearchDropDown.addItem(arrayOfMatchingStreets[counter].getName());
						}

						// enabling our drop down
						streetSearchDropDown.setEnabled(true);

					} catch (Exception exception) {
						// notifying the user their search did not match anything and prompting new
						// input
						mainTextBox.setText("No matching streets found. Please enter a new search term.");
						mainTextBox.setEditable(false);
					}
				}
			});

			JTextArea projectCredits = new JTextArea();
			projectCredits.setText("This program was created by Teague Sangster and Monica Lester.");

			// adding to our panels
			selectingPanel.add(streetSearchDropDown);
			selectingPanel.add(howToUseTheProgram);

			// adding to our center panel
			centerPanel.add(mainTextBox);
			centerPanel.add(selectingPanel);

			// Adding our north panel to our JFrame
			jFrame.add(northPanel, BorderLayout.NORTH);

			// Adding our center label to our program
			jFrame.add(centerPanel, BorderLayout.CENTER);

			jFrame.add(projectCredits, BorderLayout.SOUTH);
			// Adding our drop down
			// jFrame.add(streetSearchDropDown, BorderLayout.WEST);

			// standard practice panel settings (format, set visible to user, close
			// operation)
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.pack();
			jFrame.setVisible(true);

		} catch (Exception exception) {
			// Printing out any errors that we get
			exception.printStackTrace(System.out);
		}
	}

}
