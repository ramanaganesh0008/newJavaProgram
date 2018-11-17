
/*
 * purpose:Array 2-D
 * 
 
 *  @author  Ramana Ganesh
 *  @version 1.2
 *  @since   19-10-2018
 ************************************************************/

package com.functionalprogram;
import com.utility.*;
/* 
 * Here we use the scanner import  
 * to getting an input from the user
 */

import java.util.Scanner;

public class Array2D {
	/*
	 * This is main function
	 * To print the 2d array
	 * 
	 */
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	/*
	 * 
	 * row variable for 1-D value
	 * col variable for 2-D value
	 * 
	 */
	System.out.println("enter the row and column ");
	int row=scanner.nextInt(),column=scanner.nextInt();
	/*
	 * function call
	 * to print the array in 2D
	 *  
	 */
	Utility.array2D(row, column);
	scanner.close();
}
}
