package com.murphy.dandrick;

import java.util.ArrayList;
import java.util.Arrays;

public class MineField {

	// set mine char as constant to make changes easy
	private static char mine = '*';

	/**********************************************************************
	 * this method takes a multidimensional char array as the parameter and
	 * returns a hint-field of identical dimensions where each square is a * for
	 * a mine or the number of adjacent mine-squares if the square does not
	 * contain a mine
	 **********************************************************************/
	public static char[][] getHint(char[][] field) {
		
		// checks for empty or null fields
		if(field == null || field.length == 0) {
			char[][] array = field == null ? null : new char[0][0];
			return array;
		}

		// assuming the field has the same size arrays, creates a temporary
		// field of default null characters '\u0000'
		char[][] tempField = new char[field.length][field[0].length];

		// fills temporary field with '0' characters
		tempField = clearField(tempField);

		// get mines
		ArrayList<int[]> mineList = getMines(field);

		// sets the mines in the temporary field
		tempField = setMines(tempField, mineList);

		// increments adjacent squares
		for (int[] coor : mineList) {
			tempField = incrementAdjacent(tempField, coor);
		}

		return tempField;
	} // end getHint method

	/*****************************************************************
	 * this method takes a multidimensional char array as the parameter and sets
	 * all values equal to zero
	 ****************************************************************/
	private static char[][] clearField(char[][] field) {
		for (char[] array : field) {
			for (int i = 0; i < array.length; i++) {
				array[i] = '0';
			}
		}
		return field;
	} // end clearField method

	/*******************************************************************
	 * this method takes a multidimensional char array as the parameter and
	 * returns the coordinates in the instance of the '*' char
	 ******************************************************************/
	private static ArrayList<int[]> getMines(char[][] field) {
		int row = field.length;
		int col = field[0].length;
		ArrayList<int[]> mineList = new ArrayList<int[]>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (field[i][j] == mine) {
					int[] coor = { i, j };
					mineList.add(coor);
				}
			}
		}

		return mineList;
	} // end getMines method

	/*******************************************************************
	 * this method takes a field (for our purposes, the blank tempField) and a
	 * list of mine coordinates then returns a field with the mines ('*') from
	 * the original mine field that were recorded from the getMine list
	 ******************************************************************/
	private static char[][] setMines(char[][] field, ArrayList<int[]> list) {
		for (int[] coor : list) {
			field[coor[0]][coor[1]] = mine;
		}
		return field;
	} // end setMines

	/********************************************************************
	 * this method takes a field and coordinate of a mine as parameters and
	 * increments all adjacent squares with respect to boundaries of the field
	 ********************************************************************/
	private static char[][] incrementAdjacent(char[][] field, int[] coor) {
		int row = field.length;
		int col = field[0].length;
		int x = coor[0];
		int y = coor[1];

		// improved means of incrementing adjacent squares with out all of the
		// if statements while still checking boundaries
		for (int xDir = (x > 0 ? -1 : 0); xDir <= (x < row - 1 ? 1 : 0); ++xDir) {
			for (int yDir = (y > 0 ? -1 : 0); yDir <= (y < col - 1 ? 1 : 0); ++yDir) {
				if ((xDir != 0 || yDir != 0) && field[x + xDir][y + yDir] != mine) {
					field[x + xDir][y + yDir]++;
				}
			}
		}

		return field;
	} // end incrementAdjacent method

	public static void main(String[] args) {
		char[][] testField = { { '*', '.', '.', '.' }, { '.', '.', '*', '.' }, { '.', '.', '.', '.' } };
		System.out.println(Arrays.deepToString(testField));

		char[][] temp = getHint(testField);
		System.out.println(Arrays.deepToString(temp));
	}

} // end main
