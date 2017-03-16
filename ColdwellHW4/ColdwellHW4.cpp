#include <ostream>
#include <stdio.h>
#include <cstring>
#include <string>
#include <istream>
#include <fstream>
#include "Student.h"
// Program 4: Student grade program
// Course: Advanced Java Programming
// Instructor: Il-Hyung Cho
// Student: Alex Coldwell
// Email: ajcoldwe@svsu.edu
// Program Description:
//	This program reads in info from a text file and stores it
//  in an array of StudData objects. This program then prints
//  the grades of each students assignments then prints the 
//  class average score for each assignment.

/************************************************************/
/* ColdwellHW4.cpp                                          */
/*  This file is the main driver of the program. It runs    */
/*  the program operations.                                 */
/************************************************************/
using namespace std;

const int NUM_STDS = 10;

void initialize_std_list(StudData[], int&);
void print_std_list(const StudData[], int);
void print_avg(const StudData[], int);
char get_grade(double grade);

/************************************************************/
/* int main()                                               */
/*  This function is the main function of the program. This */
/*  function runs the program calling the functions to read */
/*  in the file, print the student grade info, and then     */
/*  print the average score of each assignment.             */
/************************************************************/
int main()
{
	StudData stdList[NUM_STDS];
	int num;                              // number of input

	initialize_std_list(stdList, num);    // initializes the item table
	print_std_list(stdList, num);         // print the read data
	print_avg(stdList, num);

	system("pause");
	return 0;
}

/************************************************************/
/* void initialize_std_list(StudData students[], int& num)  */
/*  This function loads the student info from the text file */
/*  into the students array.                                */
/************************************************************/
/* parameters:                                              */
/* -students[]: array of student objects to read to         */
/* -num: int of the number of elements in students[]. Sent  */
/*       BYRef.                                             */
/************************************************************/
void initialize_std_list(StudData students[], int& num)
{
	ifstream infile;
	int id;
	string name;
	float grade;

	// read items data from an input file
	infile.open("grades.txt");
	if (!infile) {
		cout << "Cannot open the input file!" << endl;
		system("pause");
		exit(1);
	}

	num = 0;
	infile >> id;                         // priming read

										  // reads name, and grades of each student in the file and stores in array
	while (infile) {
		students[num].setID(id);
		infile >> name;
		students[num].setName(name);
		infile >> grade;
		students[num].setEng101(grade);
		infile >> grade;
		students[num].setHist201(grade);

		num++;
		infile >> id;
	}

	infile.close();
}

/************************************************************/
/* void print_std_list(const StudData students[], int num)  */
/*  This function prints the student grade info from the    */
/*  students[] array.                                       */
/************************************************************/
/* parameters:                                              */
/* -students[]: array of student objects to read from       */
/* -num: int of the number of elements in students[]. Sent  */
/*       ByVal.                                             */
/************************************************************/
void print_std_list(const StudData students[], int num)
{
	string hold;
	cout << "Student Name Student Id  Eng101  Hist201 \n";
	cout << "------------ ----------  ------  ------- \n";
	for (int i = 0; i < num; i++) {
		hold = students[i].getName();
		printf("%12s %10d %4.0f(%c) %5.0f(%c)\n", hold.c_str(), students[i].getID(), students[i].getEng101(),
			get_grade(students[i].getEng101()), students[i].getHist201(), get_grade(students[i].getHist201()));
	}
}

/************************************************************/
/* void print_avg(const StudData students[], int num)       */
/*  This function finds the average grade for each          */
/*  assignment and then prints them out.                    */
/************************************************************/
/* parameters:                                              */
/* -students[]: array of student objects to read from       */
/* -num: int of the number of elements in students[]. Sent  */
/*       ByVal.                                             */
/************************************************************/
void print_avg(const StudData students[], int num)
{
	double dblAvgEng101 = 0;
	double dblAvgHist201 = 0;
	for (int i = 0; i < num; i++) {
		dblAvgEng101 += students[i].getEng101();
	}
	dblAvgEng101 /= num;

	for (int i = 0; i < num; i++) {
		dblAvgHist201 += students[i].getHist201();
	}
	dblAvgHist201 /= num;


	cout << endl << "          Class Average:";
	printf("%4.0f(%c) % 5.0f(%c) \n", dblAvgEng101,get_grade(dblAvgEng101), dblAvgHist201, get_grade(dblAvgHist201));
}

/************************************************************/
/* char get_grade(double grade)                             */
/*  This takes a double grade and returns a char letter     */
/*  grade.                                                  */
/* Returns: char grade                                      */
/************************************************************/
/* parameters:                                              */
/* -grade: double to pass the grade. Used to find the       */
/*         letter grade.                                    */
/************************************************************/
char get_grade(double grade)
{
	if (grade >= 90)
		return 'A';
	else if (grade < 90 && grade >= 80)
		return 'B';
	else if (grade < 80 && grade >= 70)
		return 'C';
	else if (grade < 70 && grade >= 60)
		return 'D';
	else
		return 'F';
	
}
