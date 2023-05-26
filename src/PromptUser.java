import java.util.Scanner;

public class PromptUser
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
 *         This class prompts the user for input, the desired street to search
 *         for and then refines the results for the user to select from. Once a
 *         street is selected, the selection is passed on through the program so
 *         it can find, tabulate, and present the results to the user.
 */
{

	/**
	 * @param inputPromptForUser - The string we wish to prompt the user with
	 * @return the string we wish the user to give us after we prompt them
	 */
	public static String getUserResponse(String inputPromptForUser) {
		// Prompt the user with the string they give us
		System.out.println(inputPromptForUser);

		return getUserString();

	}

	/**
	 * getUserString Purpose: Act as a method that will prompt the user and then
	 * take in a string
	 * 
	 * @return The string we wish for the user to return
	 */
	public static String getUserString() {
		// Creating our scanner object to take in our user input
		Scanner keyboard = new Scanner(System.in);
		// Saving the line of information they give us
		String returnString = keyboard.nextLine();
		// Closing the Scanner
		// keyboard.close();
		// Returning the found input
		return returnString;

	}

	// take in a int which correlates with a list of results output to the user.
	/**
	 * @return
	 */
	public static int getUserInt() {

		// Creating our scanner object to take in our user input
		Scanner keyboard = new Scanner(System.in);
		// Saving the line of information they give us
		int returnString = Integer.valueOf(keyboard.nextLine());
		// Closing the Scanner
		keyboard.close();
		// Returning the found input
		return returnString;

	}

}
