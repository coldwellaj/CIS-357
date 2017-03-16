#include <iostream>
#include <fstream>
#include <cstdlib>
#include "Student.h"

/************************************************************/
/* Student.cpp                                              */
/*  This file contains the StudData class methods.          */
/************************************************************/

using namespace std;

void StudData::setID(int id) {
	_id = id;
}
void StudData::setName(string name) {
	_name = name;
}
void StudData::setEng101(float score) {
	if (score > 100 || score < 0)
	{
		cout << "Eng101 Cannot be higher then 100 or lower then 0";
		_eng101 = 0;
	}
	else
		_eng101 = score;
}
void StudData::setHist201(float score) {
	if (score > 100 || score < 0)
	{
		cout << "Hist201 Cannot be higher then 100 or lower then 0";
		_hist201 = 0;
	}
	else
		_hist201 = score;
}
int StudData::getID() const {
	return _id;
}
string StudData::getName() const {
	return _name;
}
float StudData::getEng101() const {
	return _eng101;
}
float StudData::getHist201() const {
	return _hist201;
}

float StudData::showGPA() const{
	double dblTotal = 0;
	dblTotal = (_eng101 + _hist201) / 2;

	if (dblTotal >= 90)
		return 4.0;
	else if (dblTotal < 90 && dblTotal >= 80)
		return 3.0;
	else if (dblTotal < 80 && dblTotal >= 70)
		return 2.0;
	else if (dblTotal < 70 && dblTotal >= 60)
		return 1.0;
	else
		return 0.0;
}