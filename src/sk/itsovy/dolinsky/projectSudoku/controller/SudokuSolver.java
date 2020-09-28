package sk.itsovy.dolinsky.projectSudoku.controller;

import sk.itsovy.dolinsky.projectSudoku.InputData;
import sk.itsovy.dolinsky.projectSudoku.model.Board;

/**
 * @author Martin Dolinsky
 */
public class SudokuSolver {
	private int[][] arr;
	private Board board;

	public void start() {
		if (!readData()) {
			System.out.println("Data source failed");
		}
		board = new Board(arr);
		reduceAvailableValues();

	}

	private boolean readData() {
		arr = new InputData().getDataArray();
		return true;
	}

	private void reduceAvailableValues() {
		reduceRow();
		reduceColumn();

		reduceSquare();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!   " + board.getTiles()[1][0].getAvailable());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!   " + board.getTiles()[2][0].getAvailable());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!   " + board.getTiles()[4][0].getAvailable());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!   " + board.getTiles()[6][0].getAvailable());


	}

	private void reduceRow() {
		for (int i = 0; i < board.getTiles().length; i++) {
			for (int j = 0; j < board.getTiles().length; j++) {
				if (board.getTiles()[i][j].getAvailable() == null) {
					for (int k = 0; k < board.getTiles().length; k++) {
						if (board.getTiles()[k][j].getAvailable() != null) {
							board.getTiles()[k][j].remove(board.getTiles()[i][j].getValue());
							System.out.println("Som na pozicii " + i + " " + j);
							System.out.println("Vymazavam " + board.getTiles()[i][j].getValue());
							System.out.println("Ostalo " + board.getTiles()[k][j].getAvailable());
						}
					}
				}
			}
		}
	}

	private void reduceColumn() {
		for (int i = 0; i < board.getTiles().length; i++) {
			for (int j = 0; j < board.getTiles().length; j++) {
				if (board.getTiles()[j][i].getAvailable() == null) {
					for (int k = 0; k < board.getTiles().length; k++) {
						if (board.getTiles()[j][k].getAvailable() != null) {
							board.getTiles()[j][k].remove(board.getTiles()[j][i].getValue());
							System.out.println("Som na pozicii " + j + " " + i);
							System.out.println("Vymazavam " + board.getTiles()[j][i].getValue());
							System.out.println("Ostalo " + board.getTiles()[j][k].getAvailable());
						}
					}
				}
			}
		}
	}

	private void reduceSquare() {
		// 00-02 03-05 06-08
		// 22	  25	28

		for (int i = 0; i < board.getTiles().length; i += 3) {
			for (int j = 0; j < board.getTiles().length; j += 3) {
				if (board.getTiles()[i][j].getAvailable() == null) {
					
				}
			}
		}
	}

}
