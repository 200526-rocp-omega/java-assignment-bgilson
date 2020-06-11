package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Matt's comment to me:
 * Hmm, for formatting [B.G.:  code, in **Slack**], could you use a code block for the method?
 * You should be able to use three backtick ``` characters to create one.
 *
 * I believe the third test is expecting you to *throw* an IllegalArgumentException in that test case.
 * So instead of "return -1;" you might want "throw new IllegalArgumentException("Speed cannot be negative");"
 * 
 * // java.lang.AssertionError: Expected test to throw an instance of java.lang.IllegalArgumentException
				//throw new IllegalArgumentException("Speed cannot be negative");
 */

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */	
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			long milesPerHour = 0;

			if (kilometersPerHour < 0) {
				//milesPerHour = -1;
				//return (long) -1;
				return -1;
			}
			else {
				// 1 kilometer is equal to 0.62137119 miles
				// round(double a) : long - Math / long java.lang.Math.round(double a)
				milesPerHour = Math.round(0.62137119 * kilometersPerHour);
				return milesPerHour;
			}
			
		}
		
		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			String printString = "";
			
			if (kilometersPerHour < 0) {
				printString = "Invalid Value";
			}
			else {
				printString = kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h";
			}
			
			System.out.println(printString);
			
			
			return printString;
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes [B.G.:  kiloBytes] parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {
		String printString = "";
		
		if (kiloBytes < 0) {
			printString = "Invalid Value";
		}
		else {
			// Convert kilobytes (KB) into megabytes (MB) **and remaining kilobytes (KB)**,
			// and put each value into the String for printing
			// (NOTE:  using *integer division*, so both printed values (MB and KB) will be integers)
			printString = kiloBytes + " KB = " + kiloBytes/1024 + " MB and " + kiloBytes%1024 + " KB";
		}
		
		System.out.println(printString);
		
		
		return printString;
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking"[B.G.:  isBarking]. It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		// hourOfDay input was invalid
		if (hourOfDay < 0 || hourOfDay > 23) {
			return false;
		}
		
		// if dog is NOT barking, we don't need to wake up!
		if (!isBarking) {
			return false;
		}
		
		// dog IS barking
		// IF before 8 or after 22 hourOfDay (< 8AM or > 10PM), we need to wake up
		if (hourOfDay < 8 || hourOfDay > 22) {
			return true;
		}
		else { // in all other cases when the dog is barking (i.e., >= 8AM and <= 10PM, we DON'T need to wake up
			return false;
		}			
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		
		/* Multiply the numbers by 1000 to move the decimal point 3 places to the right;
		 * then cast the results to int's to effectively truncate them at 3 "decimal" digits
		 * (one could then cast those results back to doubles to get the original numbers
		 * truncated to 3 digits - but it's not necessary in order to do the comparison we need)
		 */
		if ( (int) (firstNum * 1000) == (int) (secondNum * 1000) ) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			return (isTeen(x) || isTeen(y) || isTeen(z));
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method	[B.G.:  this comment was in the assignment as *provided*]
		public static boolean isTeen(int number) {
			// number is in the range 13-19, inclusive
			if (number >= 13 && number <= 19) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) [WRONG*] and it needs to calculate the
	 * years and days from the minutes parameter.
	 *		* Per Matt (Slack, Sun. 06/07/20, 5:09 PM (direct message to me):
	 *			"Indeed, it is supposed to return a String."
	 *		  [re:  exercise 6, printYearsAndDays method]
	 *
	 *		ALSO per Matt (Slack, Sun. 06/07/20, 5:26 PM (direct message to me),
	 *		ignore leap years in our calculation here.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		String printString = "";
		
		if (minutes < 0) {
			printString = "Invalid Value";
		}
		else {
			// Convert minutes into years **and remaining days** (ignoring leap years),
			// and put each value into the String for printing
			//
			// NOTE:  60 minutes/hr * 24 hrs/day * 365 days/yr
			//			=> 1440 min/day * 365 days/yr
			//			=> 525,600 min/yr
			//
			//		  Thus, (1) minutes/525600 is min / (min/yr) = yrs;
			//		  		(2) remainder (minutes%525600) is in min,
			//		  			so (minutes%525600)/1440 is min / (min/day) = days
			// 
			// (NOTE:  using *integer division* (long/int -> long/long; long is a long integer),
			//  so both printed values (years and days) will be long integers)
			printString = minutes + " min = " + minutes/525600 + " y and " + (minutes%525600)/1440 + " d";
		}
		
		System.out.println(printString);
		
		
		return printString;
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		// return statement in each case serves the *dual* purpose of 
		// returning a value AND "breaking" (i.e., also replaces "break;" statements!)
		switch(number) {
			case 0:
				System.out.println("ZERO");
				return "ZERO";
			case 1:
				System.out.println("ONE");
				return "ONE";
			case 2:
				System.out.println("TWO");
				return "TWO";
			case 3:
				System.out.println("THREE");
				return "THREE";
			case 4:
				System.out.println("FOUR");
				return "FOUR";
			case 5:
				System.out.println("FIVE");
				return "FIVE";
			case 6:
				System.out.println("SIX");
				return "SIX";
			case 7:
				System.out.println("SEVEN");
				return "SEVEN";
			case 8:
				System.out.println("EIGHT");
				return "EIGHT";
			case 9:
				System.out.println("NINE");
				return "NINE";
			default:
				System.out.println("OTHER");
				return "OTHER";
		}
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12[;] 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		// invalid parameter value(s) (per assignment specs)
		if (first < 10 || second < 10) {
			return -1;
		}
		
		int gcd = 1;
		// WHY STS not prompt me to import java.lang.Math when I type "min"?
		// AND why "import java.lang.Math;" at top of file not cause min to be recognized?
		// The largest possible common divisor of two numbers is the lesser of the two numbers;
		// thus, use this value to control GCD checking in the loop below
		int maxDivisorToCheck = Math.min(first, second);
		
		for (int i = 1; i <= maxDivisorToCheck; i++) {
			// if both numbers can be divided by i evenly, set the gcd to i (gcd so far ...)
			if ((first % i == 0) && (second % i == 0)) {
				gcd = i;
			}
		}
		
		// having gone through the loop to check all possible gcd's for the 2 numbers, return the gcd
		return gcd;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number [B.G.:  num, as *given* in method header provided].
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop[,] and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		// this method only processes a non-negative number (per assignment specs)
		if (num < 0) {
			return -1;
		}

		
		// B. Gilson:  I like this way of coding this better - but the assignment specs
		// above require using a loop to find the first and last digits of the parameter
		// number, *rather* than using direct access to do so.
		
/*		// Convert num to a String for direct access to (1) number of digits (string length),
		// and (2) first and last digits (string characters; convert back to int's)
		String numAsString = Integer.toString(num);
		//int numberOfDigits = Integer.toString(num).length();
		int numberOfDigits = numAsString.length();
		
		// get the first and last characters of the *string*; convert them back to int's
		// (first have to convert to Strings using String.valueOf() to be able to use
		// Integer.parseInt(), which only accepts a String argument) so can sum them
		int firstDigit = Integer.parseInt(String.valueOf(numAsString.charAt(0)));
		int lastDigit = Integer.parseInt(String.valueOf(numAsString.charAt(numberOfDigits - 1)));
		*/
		
		
		if (num == 0) {
			return 0;	// 1st digit == last digit == 0; 0 + 0 = 0 (sum)
		}
		
		int firstDigit = 0;
		int lastDigit = -1; // set to -1 to indicate not yet assigned real last digit of parameter
		
		/* Find the first and the last digit of the parameter number passed to
		 * the method, **using a loop.**  */
		while (num > 0) {
			
			if (lastDigit == -1) { // 1st time through
				lastDigit = num % 10;   // store remainder (last digit)
				firstDigit = lastDigit; // set first digit to only digit for now
			} else { // not first time through
				firstDigit = num % 10;  //store remainder as current first digit
			}
			
			// truncate current last digit
			num = num / 10;
		}
		
		 // return the sum of the first and last digits
		return (firstDigit + lastDigit);		
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {

		//if (string == null) {
		//	return string;
		//}
		
		// test in Driver.java (!!)
		//string = null;

		// create a new String object in which to store the reversed string
		String reversed = new String();	// new "reversed" String is initially empty
				
		// store the input string's characters in reverse, 1 by 1 
		for (int i = string.length() - 1; i >=0; i--) {
			reversed = reversed + string.charAt(i);
		}
		
		return reversed;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	/*  B. Gilson:  An acronym *could* be based either on capital letters
	 *  or just the beginning of a word, whether capitalized or not!!!
	 *  The specs here are unclear in this regard -- but the 4 JUnit tests
	 *  all use *both* (capitalized word beginning / following a space),
	 *  EXCEPT the last one:  "Complementary metal-oxide semiconductor"
	 *  (-> CMOS).
	 *  SO, I initially decided to just check for and store the next letter
	 *  (non-space character) following any space(s), based on the JUnit
	 *  test input - which seemed to show that *whitespace* was the main
	 *  determining factor for next character in an acronym.  Thus, cycle
	 *  through until find a non-space character, store that, then cycle
	 *  through until find the next *space* character - and repeat,
	 *  stopping when reach the end of the input phrase (by its length())..
	 *  
	 *  I then MODIFIED THIS based on the last JUnit test phrase:
	 *  	"Complementary metal-oxide semiconductor"  (-> CMOS).
	 *
	 *  This indicates that an acronym also includes the first character
	 *  after a hyphen ... so I added a check for that in addition
	 *  to the check for a space as the dividing line between characters
	 *  to grab for an acronym.
	 */
	public String acronym(String phrase) {
		
		// create a new String object in which to store the acronym
		String acronym = new String();	// this new "acronym" String is initially empty
		
		// index to track position in the input phrase
		int index = 0;
		
		
		// find and store the first letter of each word of the input phrase, 1 by 1
			// example (first JUnit test uses this:  "Portable Network Graphics")
		while (index < phrase.length() - 1) { // had to add -1 to keep from overrunning the end of the String
		
			// move through input phrase until find the next non-space character (or reach end of phrase)
			while (phrase.charAt(index) == ' ' && index < phrase.length()) {
				index++;
				// had to add this if-block to capture the last acronym character
				// *without* overrunning the end of the String
				if (index == phrase.length() - 1 && phrase.charAt(index) != ' ') {
					break;	// go below to store the last character, a non-space following a space
				}
			}
		
			// store the non-space character found, first converting it to upper-case if lower-case
			// (for the acronym ONLY)
			if (!Character.isUpperCase(phrase.charAt(index))) {
				acronym = acronym + Character.toUpperCase(phrase.charAt(index));
			} else {
				acronym = acronym + phrase.charAt(index);
			}
		
			// NOW move through input phrase until find a *space* (or reach end of phrase)
				// had to add -1 to keep from overrunning the end of the String;
				// doesn't matter whether last character after non-space character
				// (!= '' here) is a space (or '-') or not - still not part of acronym.
			while (phrase.charAt(index) != ' ' && index < phrase.length() - 1) {
				if (phrase.charAt(index) == '-' && phrase.charAt(index+1) != ' '
						&& phrase.charAt(index+1) != '-') {
					// increment position, and then store the non-space, non-hyphen
					// character found after the hyphen -- first converting it to
					// upper-case if lower-case (for the acronym ONLY)
					index++;
					if (!Character.isUpperCase(phrase.charAt(index))) {
						acronym = acronym + Character.toUpperCase(phrase.charAt(index));
					} else {
						acronym = acronym + phrase.charAt(index);
					}
				} else {
					index++;
				}
			}
		}		
		
		
		return acronym;
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It [an isosceles triangle] is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// A equilateral triangle has all three sides the same length
				// true if all 3 sides have equal length; otherwise false
			return (getSideOne() == getSideTwo() && getSideTwo() == getSideThree());
		}

		public boolean isIsosceles() {
			// An isosceles triangle has at least two sides the same length.
			// (Per the specs (immediately preceding this Triangle class),
			//  an isosceles triangle is sometimes specified as having exactly
			//  two sides the same length, but for the purposes of this exercise
			//  we'll say it has at least two sides with the same length.)
			// true if any 2 (-> at least 2) sides have equal length; otherwise false
			return (getSideOne() == getSideTwo() || getSideTwo() == getSideThree()
						|| getSideOne() == getSideThree());
		}

		public boolean isScalene() {
			// A triangle for which all 3 sides have different lengths
			//return false;
				// If triangle is an equilateral or an isosceles triangle,
				// it has either exactly 3 or at least 2 sides of equal
				// length -- and thus is NOT a scalene triangle.
				// HERE:  true if NOT (equilateral or isosceles) -> scalene;
				//     otherwise (if equilateral and/or isosceles), false -> NOT scalene. 
			return ( !(isEquilateral() || isIsosceles()) );
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		
		// set up the data in sets
		
		Character [] arr_1pt = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
		Character [] arr_2pt = {'D', 'G'};
		Character [] arr_3pt = {'B', 'C', 'M', 'P'};
		Character [] arr_4pt = {'F', 'H', 'V', 'W', 'Y'};
		Character [] arr_5pt = {'K'};
		Character [] arr_8pt = {'J', 'X'};
		Character [] arr_10pt = {'Q', 'Z'};
		
		Set<Character> hash_Set_1pt = new HashSet<>(Arrays.asList(arr_1pt));
		Set<Character> hash_Set_2pt = new HashSet<>(Arrays.asList(arr_2pt));
		Set<Character> hash_Set_3pt = new HashSet<>(Arrays.asList(arr_3pt));
		Set<Character> hash_Set_4pt = new HashSet<>(Arrays.asList(arr_4pt));
		Set<Character> hash_Set_5pt = new HashSet<>(Arrays.asList(arr_5pt));
		Set<Character> hash_Set_8pt = new HashSet<>(Arrays.asList(arr_8pt));
		Set<Character> hash_Set_10pt = new HashSet<>(Arrays.asList(arr_10pt));
			
		
		// standardize input string to all upper case (case-insensitive scoring)
		String allUpperCase = string.toUpperCase();
		
		int wordScore = 0;
		

		for (int i = 0; i < allUpperCase.length(); i++) {
				
			if (hash_Set_1pt.contains(allUpperCase.charAt(i))) { // A, E, I, O, U, L, N, R, S, T = 1
				wordScore += 1;
			} else if (hash_Set_2pt.contains(allUpperCase.charAt(i))) { // D, G = 2
				wordScore += 2;
			} else if (hash_Set_3pt.contains(allUpperCase.charAt(i))) { // B, C, M, P = 3
				wordScore += 3;
			} else if (hash_Set_4pt.contains(allUpperCase.charAt(i))) { // F, H, V, W, Y = 4
				wordScore += 4;
			} else if (hash_Set_5pt.contains(allUpperCase.charAt(i))) { // K = 5
				wordScore += 5;
			} else if (hash_Set_8pt.contains(allUpperCase.charAt(i))) { // J, X = 8
				wordScore += 8;
			} else if (hash_Set_10pt.contains(allUpperCase.charAt(i))) { // Q, Z = 10
				wordScore += 10;
			}
		}
		
		return wordScore;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	/*  B.Gilson:  THe above specs translate into the following:
	 * 
	 *  remove/clean parentheses, hyphens, dots (.), spaces
	 *
	 *  INVALID if *other* non-numeric characters (alphabetic /
	 *  punctuation/special characters (e.g., '@', ':', '!', '+') ),
	 *  -- so throw new IllegalArgumentException with appropriate description text.
	 *
	 *
	 *  THEN (re:  cleaned (so far) number):
	 *  ------------------------------------
	 *  INVALID if > 11 digits (or < 10 digits ??!? - B.G.)*
	 *  -- so throw new IllegalArgumentException with appropriate description text.
	 *
	 *  * INVALID if < 10 digits
	 *  -- so throw new IllegalArgumentException with appropriate description text.
	 *
	 *  INVALID if exactly 11 digits *and*
	 * 		country code (first digit) != 1  (thus, non-NANP phone number).
	 *  -- so throw new IllegalArgumentException with appropriate description text.
	 *
	 *
	 *  If exactly 11 digits *and*
	 * 		country code (first digit) == 1,
	 *  number is an 11-digit NANP phone number
	 *  -- so remove the first digit (international country code '1')
	 */

	public String cleanPhoneNumber(String string) {

		// put the valid non-numeric characters in a set
		
		Character [] arr_validNonNumerics = {'(', ')', ' ', '-', '.' };
		Set<Character> hash_Set_validNonNumerics = new HashSet<>(Arrays.asList(arr_validNonNumerics));
				
		
		// new "cleanedPhNum" StringBuilder is initially empty
		StringBuilder cleanedPhNum = new StringBuilder();
		
		//	Sample test data (to consider):
		//"(223) 456-7890"
		//"223.456.7890"
		//"223 456   7890   ")
		//"321234567890"	--	invalidWhenMoreThan11Digits()
		//"123-abc-7890"	--	invalidWithNonNumeric()	 }
		//"123-@:!-7890"	--	invalidWithNonNumeric()	 }
		for (int i = 0; i < string.length(); i++) {
			
			char currentChar = string.charAt(i);
			
			// if the current character is a digit
			if (Character.isDigit(currentChar)) {
				// append it to the cleanedPhNum StringBuilder
				cleanedPhNum = cleanedPhNum.append(string.charAt(i));
			} else if (!hash_Set_validNonNumerics.contains(currentChar)) {
				// NOT a valid non-numeric - i.e., NOT in {'(', ')', ' ', '-', '.' }
				throw new IllegalArgumentException("Input phone number:  \"" + string
												+ "\" contains non-numeric character(s); 1st is:  \'"
												+ currentChar + "\'");
			}	// note that we just SKIP valid non-numerics (not IllegalArgumentException),
				// but also not put into the StringBuilder cleanedPhNum 
		}
		
		
		/* NOW check if the StringBuilder cleanedPhNum :
		 *		(a) has > 11 digits (invalidWhenMoreThan11Digits())
		 *			(International country code 1 (for NANP #) + 10-digit NANP #  =  11 digits),
		 *		(b) has < 10 digits,
		 *		(c) has exactly 11 digits and
		 *			(1) country code (first digit) != 1  (thus, non-NANP phone number).
		 *
		 * If (a) (> 11 digits), throw new IllegalArgumentException with appropriate description text.
		 * 
		 * (b) was not (specifically) mentioned in the specs - but I'm handling similarly to (a) above.
		 * 
		 * If (c)(1) (clean but non-NANP country), throw new IllegalArgumentException with appropriate description text.
		 * 
		 * If (c) but not (c)(1), 11-digit NANP phone number, so remove the first digit (international country code '1')
		 */
		
		// StringBuilder cleanedPhNum
		// (a) has > 11 digits (invalidWhenMoreThan11Digits())
		if (cleanedPhNum.length() > 11) {
			throw new IllegalArgumentException("*Cleaned* phone number:  \"" + cleanedPhNum
					+ "\" (from Input phone number:  \"" + string
					+ "\") contains > 11 digits (country code + 10-digit NANP phone number)");
		}
		
		// (b) has < 10 digits
		if (cleanedPhNum.length() < 10) {
			throw new IllegalArgumentException("*Cleaned* phone number:  \"" + cleanedPhNum
					+ "\" (from Input phone number:  \"" + string
					+ "\") contains < 10 digits (NO country code; 10-digit NANP phone number)");
		}
		
		/* (c) has exactly 11 digits and
		 *	   (1) country code (first digit) != 1  (thus, non-NANP phone number).
		 *
		 * Note:  if passed (a) and (b) above, 10 <= cleanedPhNum.length() <= 11
		 *		   -- i.e., cleanedPhNum is either 10 or 11 digits.
		 *	Thus, must now determine if 11-digit number with a non-NANP country code,
		 *	and if so, throw new IllegalArgumentException with appropriate description text.
		 *
		 *  If not, number is clean -- it's either a 10-digit phone number (with
		 *  NANP country code '1' presumed) or an 11-digit NANP phone number (with
		 *  NANP country code '1' actually present).  In the latter case, remove
		 *  the NANP country code ('1' - the first digit).
		 *  
		 *  Return the 10-digit cleaned phone number (StringBuilder cleanedPhNum)
		 *  as a String. 
		 */
		// (c) has exactly 11 digits and
		if (cleanedPhNum.length() == 11) {
			// (1) country code (first digit) != 1  (thus, non-NANP phone number).
			if (cleanedPhNum.charAt(0) != '1') {
				throw new IllegalArgumentException("*Cleaned* phone number:  \"" + cleanedPhNum
						+ "\" (from Input phone number:  \"" + string
						+ "\") has invalid country code (should be '1', with 10-digit NANP phone number)");
			} else {
				// 11-digit NANP phone number, so remove the first digit (international country code '1')
				cleanedPhNum.deleteCharAt(0);
			}	
		}


		return cleanedPhNum.toString();
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free",
	 * olly: 2 in: 1 come: 1 free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		// count words; separators:  space(s), punctuation, and/or newline(s)
		
		//	Sample test data (to consider):
		// "word"									// countOneWord() )
		// "one of each"							// countOneOfEachWord() )
		// "one fish two fish red fish blue fish"	// multipleOccurrencesOfAWord()
		// "one,two,three"							// handlesCrampedLists()
		// "one,\ntwo,\nthree"						// handlesExpandedLists()
		
		
		// create the map to use to hold the data;
		// it will be returned from this method
		Map<String, Integer> wordCountMap = new HashMap<>();
		
		// split the input string into words:
		// 		1. first replace newline characters and commas with spaces
		//		2. then replace all consecutive spaces with a single space
		//		3. lastly, split on each single space (i.e. use as the word separator)
		String[] words = string.replaceAll("\n", " ").replaceAll(",", " ").replaceAll(" +", " ").split(" ");

		
		// can't iterate over a Map directly - so iterate over
		// the String array and populate the map with this data
		for (String word : words) {
			// word and previous count already in map; increment count
			if (wordCountMap.containsKey(word)) {
				int currentCount = wordCountMap.get(word);
				wordCountMap.put(word, currentCount + 1);
			} else {
				// word and previous count NOT yet in map; add to map
				wordCountMap.put(word, 1);
			}			
		}
		
		// return the populated map
		return wordCountMap;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9
	 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 2  -- B. Gilson:  NO -- it's 1 + 0 = 1 (!!!)
	 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
	 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
	 * 
	 * Write some code to determine whether a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
				
		String inputString = Integer.toString(input);
		int numOfDigits = inputString.length();
		int sum = 0;
		
		for (int i = 0; i < numOfDigits; i++) {
			int digit = Character.getNumericValue(inputString.charAt(i));
			// Math.pow(number, exponent)
			sum += (Math.pow(digit, numOfDigits));
			//System.out.println(digit);
		}
		
		//System.out.println("input:  " + input + "; sum:  " + sum);
		
		if (input == sum) {
			// is an Armstrong number
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> primeFactorsList = new ArrayList<>();
		
		// a positive integer is always evenly divisible by 1 (one),
		// but since 1 is not a prime number,
		// check positive integers from 2 up to input value l ("ell")
		for (long i = 2; i <= l; i++) {
			
			Long rem = 0L;
			Long num = l;	// (input value "ell")
			
			rem = num % i;
			
			// no remainder (evenly divisible)
			while (rem == 0L) {
				rem = num % i;

				if (rem == 0L) {
					num /= i;
				} // otherwise leave num as is
			}
			
			// add to list of prime factors
			primeFactorsList.add((i));
			//primeFactorsList.add((num));
		}	
		
		return primeFactorsList;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		return null;
	}
	
	/**
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		return 0;
	}
}
