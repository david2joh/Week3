package assignment;

import java.util.Arrays;

public class codingAssignment_W3 {

	public static void main(String[] args) {
		/*Coding Steps:
		    1. Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
		        a. Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] in your code). Print the result to the console.
		        b. Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths).
		        c. Use a loop to iterate through the array and calculate the average age. Print the result to the console.
		    2. Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		        a. Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
		        b. Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		    3. How do you access the last element of any array?
		    4. How do you access the first element of any array?
		    5. Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		    6. Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
		    7. Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. (i.e. if I pass in “Hello” and 3, I would expect the method to return “HelloHelloHello”).
		    8. Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name as a String separated by a space).
		    9. Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
		    10. Write a method that takes an array of double and returns the average of all the elements in the array.
		    11. Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array.
		    12. Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
		    13. Create a method of your own that solves a problem. In comments, write what the method does and why you created it.
		    */
	
		int[] arr = {3, 9, 23, 64, 2, 8, 28, 93 };
		stepOne(arr);
		String[] names = { "Sam", "Tommy", "Tim", "Sally", "Buck", "Bob" };
		stepTwo(names);
		//	    3. How do you access the last element of any array?
		//        arrayName[arrayName.length-1]
	    //		4. How do you access the first element of any array?
		//        arrayName[0];
		int[] nameLengths = new int[names.length];

		stepFive(names,nameLengths);
		stepSix(nameLengths);
		System.out.println(stepSeven("Fizz",4));
		System.out.println(stepEight("John" , "Doe"));
		System.out.println(stepNine(arr));
		double[] arrD = { 1.14 , 23.3 , 14, 25.13 };
		System.out.println(stepTen(arrD));
		double[] arrD2 = {19, 3.24 , 5.4 , 47 };
		System.out.println(stepEleven(arrD,arrD2));
		boolean isHotOutside = true;
		double moneyinPocket = 1.55;
		System.out.println(willBuyDrink(isHotOutside,moneyinPocket));
		String s = "Tedious";
		stepThirteen(s);
	}

	private static void stepOne(int[] arr) {
//		1. Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
//        a. Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] in your code). Print the result to the console.
//        b. Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths).
//        c. Use a loop to iterate through the array and calculate the average age. Print the result to the console.
		stepOneHelper(arr); //Perform step a subtraction
		arr = Arrays.copyOf(arr, arr.length+1); //extend the array by 1
		arr[arr.length-1] = 18; // add a new age into the array at the end
		stepOneHelper(arr); //Perform step b subtraction
		int accum = 0;
		for (int i = 0 ; i < arr.length ; i++) accum += arr[i];
		System.out.println("Average of values in our array is = "+ (((double)accum)/arr.length));
		System.out.print("Print array values for verification :");
		for (int i : arr) System.out.print(i + " "); //sanity check for debugging
		System.out.println("");
	}

	private static void stepOneHelper(int[] arr) {
		//subtract the value of the first element of the array from the last , print the result to the console
		int endIdx = arr.length - 1;
		arr[endIdx] -= arr[0];
		System.out.println("last element of Array arr["+endIdx+"] = "+ arr[endIdx]);
	}
	
	private static void stepTwo(String[] names) {
//	    2. Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
//        a. Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
//        b. Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		int accum = 0;
		for (String ns : names) { accum += ns.length(); }
		System.out.println("Average number of letters per name in our array is = "+ (((double)accum)/names.length));
		String Result = "";
		for (int i =0; i < names.length; i++) {
			Result += names[i];
			Result += (i < names.length-1 ? " " : "");
		}
		System.out.println("Concat of names = "+Result);
	}

	private static void stepFive(String[] names , int[] nameLengths) {
//	    5. Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		for (int i = 0; i < names.length ; i++) nameLengths[i] = names[i].length();
		//Debugging check for classwork
		System.out.print("Length of each name in Names array is =");
		for (int i : nameLengths) System.out.print(" " +i);
		System.out.println();
		//End debugging
	}
	
	private static void stepSix(int[] nameLengths) {
//	    6. Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
	    int accum = 0;
	    for (int i : nameLengths) accum += i;
	    System.out.println("Total Length of all names is = "+ accum);
	}

	private static String stepSeven(String string, int i) {
//	    7. Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. (i.e. if I pass in “Hello” and 3, I would expect the method to return “HelloHelloHello”).
		String result ="";  //return empty string if i <= 0
		if (i > 0) {for (int j = 0 ; j < i; j++) result += string;}
		return(result);
	}
	
	private static String stepEight(String string1, String string2) {
//	    8. Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name as a String separated by a space).
		return (string1+" "+string2);
	}

	private static boolean stepNine(int[] arr) {
//	    9. Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
		int accum = 0;
		for (int i = 0 ; i < arr.length ; i++) accum += arr[i];
        if (accum > 100) return(true);
        return(false);
	}

	private static double stepTen(double[] arrD) {
//	    10. Write a method that takes an array of double and returns the average of all the elements in the array.
		double accum = 0;
		for (double i  : arrD) accum += i;
		return(accum/arrD.length);
	}

	private static boolean stepEleven(double[] arrD, double[] arrD2) {
//	    11. Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array.
		double accum1 = 0 , accum2 =0;
		for (double i  : arrD) accum1 += i;
		for (double i  : arrD2) accum2 += i;
		if (accum1 > accum2) return (true);
		return(false);
	}

	private static boolean willBuyDrink(boolean isHotOutside, double moneyinPocket) {
//	    12. Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
		if ( isHotOutside && (moneyinPocket > 10.50)) return(true);
		return(false);
	}



	private static void stepThirteen(String s) {
//    13. Create a method to solve a problem
		// a rather tedious interview question is "Write a method to reverse a string"
		// fortunately Java provides a built in reverse function in the string builder class
		
		//Print the original string
		System.out.println(s);
		// convert String to StringBuffer to the console
        StringBuffer sb = new StringBuffer(s);
        // Reverse
        sb.reverse();
        //Print the reversed string to the console
        System.out.println(sb);
	}



	
}
	
	
