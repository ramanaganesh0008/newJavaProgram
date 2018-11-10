/*
 * purpose:To find whether the year is leap year or not
 * 
 
 *  @author  Ramana Ganesh
 *  @version 1.2
 *  @since   19-10-2018
 * ************************************************************/
package com.functionalprogram;
/* 
 * Here we use the scanner import  
 * to getting an input from the user
 */

import java.util.Scanner;

public class LeapYear {
	

	/*
	 * main function make use of to check whether given year is leap year or not
	 * 
	 */
	
public static void main(String[] args) {
	
	//getting an input from the user with the help of scanner
	Scanner s=new Scanner(System.in);
	System.out.println("enter the year");
	int year=s.nextInt();
	/*
	 * function call
	 * to check the year is leap year or not
	 * 
	 */
	Utility.isLeap(year);
	s.close();
}
}
