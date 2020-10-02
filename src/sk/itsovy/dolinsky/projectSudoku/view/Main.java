package sk.itsovy.dolinsky.projectSudoku.view;

import sk.itsovy.dolinsky.projectSudoku.controller.SudokuSolver;
import sk.itsovy.dolinsky.projectSudoku.model.Tile;

public class Main {

	public static void main(String[] args) {
		SudokuSolver sudokuSolver = new SudokuSolver();

		sudokuSolver.start();
		printBoard(sudokuSolver.getBoard().getTiles());
		System.out.println("\n\n\n");

		while (!sudokuSolver.checkCompletion()) {
			sudokuSolver.reduceAvailableValues();
			sudokuSolver.assignValues();
		}
		printBoard(sudokuSolver.getBoard().getTiles());

	}

	public static void printBoard(Tile[][] tiles) {
		for (int i = 0; i < tiles.length; i++) {

			if (i % 3 == 0) {
				System.out.println("|-------|-------|-------|");
			}
			for (int j = 0; j < tiles.length; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(tiles[i][j].getValue() + " ");
				if (j == 8) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
		System.out.println("|-------|-------|-------|");
	}


}


