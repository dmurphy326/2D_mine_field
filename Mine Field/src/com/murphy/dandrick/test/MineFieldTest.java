package com.murphy.dandrick.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import com.murphy.dandrick.MineField;

public class MineFieldTest {

	public void printTest(String name, char[][] actual, char[][] expected) {
		System.out.println("Test: " + name);
		System.out.println("Test Case:\t\t" + Arrays.deepToString(actual));
		System.out.println("Test Results:\t\t" + Arrays.deepToString(MineField.getHint(actual)));
		System.out.println("Test Expected Results:\t" + Arrays.deepToString(expected) + "\n");
	}
	
	@Test
	public void givenTest() {
		char[][] givenCase = { { '*', '.', '.', '.' }, { '.', '.', '*', '.' }, { '.', '.', '.', '.' } };
		char[][] expected = { { '*', '2', '1', '1' }, { '1', '2', '*', '1' }, { '0', '1', '1', '1' } };

		printTest("Given Case", givenCase, expected);

		assertArrayEquals(expected, MineField.getHint(givenCase));

	}

	@Test
	public void singleArray() {
		char[][] singleArrayCase = { { '.', '.', '.', '*', '.' } };
		char[][] expected = { { '0', '0', '1', '*', '1' } };

		printTest("Single Array", singleArrayCase, expected);

		assertArrayEquals(expected, MineField.getHint(singleArrayCase));
	}

	@Test
	public void allMines() {
		char[][] allMinesCase = { { '*', '*', '*' }, { '*', '*', '*' }, { '*', '*', '*' } };
		char[][] expected = { { '*', '*', '*' }, { '*', '*', '*' }, { '*', '*', '*' } };

		printTest("Field That's All Mines", allMinesCase, expected);

		assertArrayEquals(expected, MineField.getHint(allMinesCase));
	}

	@Test
	public void noMines() {
		char[][] noMinesCase = { { '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.' } };
		char[][] expected = { { '0', '0', '0', '0', '0' }, { '0', '0', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		printTest("Field That Has No Mines", noMinesCase, expected);

		assertArrayEquals(expected, MineField.getHint(noMinesCase));
	}

	@Test
	public void allMineBorder() {
		char[][] allMineBorderCase = { { '*', '*', '*', '*', '*' }, { '*', '.', '.', '.', '*' },
				{ '*', '.', '.', '.', '*' }, { '*', '.', '.', '.', '*' }, { '*', '*', '*', '*', '*' } };
		char[][] expected = { { '*', '*', '*', '*', '*' }, { '*', '5', '3', '5', '*' },
				{ '*', '3', '0', '3', '*' }, { '*', '5', '3', '5', '*' }, { '*', '*', '*', '*', '*' } };

		printTest("Field That's Borders Are Mines", allMineBorderCase, expected);

		assertArrayEquals(expected, MineField.getHint(allMineBorderCase));
	}

	@Test
	public void emptyArray() {
		char[][] emptyArrayCase = {};
		char[][] expected = {};

		printTest("Empty Field", emptyArrayCase, expected);

		assertArrayEquals(expected, MineField.getHint(emptyArrayCase));
	}

	@Test
	public void nullArray() {
		char[][] nullArrayCase = null;
		char[][] expected = null;

		printTest("Null Field", nullArrayCase, expected);

		assertArrayEquals(expected, MineField.getHint(nullArrayCase));
	}

}
