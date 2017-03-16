#include <iostream>
#include <fstream>
#include <cstdlib>

/************************************************************/
/* Student.h                                                */
/*  This file contains the StudData class properties and    */
/*  method declarations.                                    */
/************************************************************/

using namespace std;

/************************************************************/
/* class StudData                                           */
/*  This class holds the information of a student as well   */
/*  there grades for Eng101, and Hist201.                   */
/************************************************************/
class StudData {
public:
	void setID(int);
	void setName(string);
	void setEng101(float);
	void setHist201(float);
	int  getID() const;
	string getName() const;
	float getEng101() const;
	float getHist201() const;
	float showGPA() const;
private:
	int _id;                     // student number
	string _name;                // student name;
	float _eng101;               // English score
	float _hist201;              // History score
};
