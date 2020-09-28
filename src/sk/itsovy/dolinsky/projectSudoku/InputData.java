package sk.itsovy.dolinsky.projectSudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Martin Dolinsky
 */
public class InputData {

	public String printFile() {
		StringBuilder stringBuilder = new StringBuilder();
		String sourceFile = "/Users/martindolinsky/Documents/Skola/ProjectSudoku/src/input.txt";
		try {
			File myFile = new File(sourceFile);
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				stringBuilder.append(data);
			}
			myReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public int[][] getDataArray() {
		String data = printFile();
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = (data.charAt(9 * i + j)) - '0';
			}
		}
		return arr;
	}

	public void printData(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("|-------|-------|-------|");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print( arr[i][j] + " ");
				if (j == 8) {
					System.out.print("|");
				}
			}
			System.out.println("");


		}
		System.out.println("|-------|-------|-------|");
	}

}
