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

}
