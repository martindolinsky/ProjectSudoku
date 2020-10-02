package sk.itsovy.dolinsky.projectSudoku.controller;

import sk.itsovy.dolinsky.projectSudoku.InputData;
import sk.itsovy.dolinsky.projectSudoku.model.Board;

/**
 * @author Martin Dolinsky
 */
public class SudokuSolver {
	private int[][] arr;
	private Board board;

	public Board getBoard() {
		return board;
	}

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

	public void reduceAvailableValues() {
		reduceRow();
		reduceColumn();
		reduceSquare();
	}

	private void reduceRow() {
		int size = board.getTiles().length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.getTiles()[i][j].getAvailable() != null) {
					for (int k = 0; k < size; k++) {
						if (board.getTiles()[i][k].getValue() > 0) {
							board.getTiles()[i][j].remove(board.getTiles()[i][k].getValue());
						}
					}
				}
			}
		}
	}

	private void reduceColumn() {
		int size = board.getTiles().length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.getTiles()[i][j].getAvailable() != null) {
					for (int k = 0; k < size; k++) {
						if (board.getTiles()[k][j].getValue() > 0) {
							board.getTiles()[i][j].remove(board.getTiles()[k][j].getValue());
						}
					}
				}
			}
		}
	}

	/**
	 * Method from Miroslav Jackanin
	 */
	private void reduceSquare() {
		int size = board.getTiles().length;
		int k = 0, l = 0, m = 0, n = 0;
		for (int i = 0; i < size; i += 3) {
			for (int j = 0; j < size; j += 3) {
				for (k += i; k < i + 3; k++) {
					for (l += j; l < j + 3; l++) {
						if (board.getTiles()[k][l].getAvailable() == null) {
							for (m += i; m < i + 3; m++) {
								for (n += j; n < j + 3; n++) {
									if (board.getTiles()[m][n].getAvailable() != null) {
										board.getTiles()[m][n].remove(board.getTiles()[k][l].getValue());
									}
								}
								n = 0;
							}
							m = 0;
						}
					}
					l = 0;
				}
				k = 0;
			}
		}
	}

	public void assignValues() {
		int size = board.getTiles().length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.getTiles()[i][j].getAvailable() != null
						&& board.getTiles()[i][j].getAvailable().size() == 1) {
					board.getTiles()[i][j].setValue(board.getTiles()[i][j].getAvailable().iterator().next());
					board.getTiles()[i][j].remove(board.getTiles()[i][j].getValue());
				}
			}
		}
	}

	public boolean checkCompletion() {
		int size = board.getTiles().length;
		int emptySpace = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.getTiles()[i][j].getValue() == 0) {
					emptySpace++;
				}
			}
		}
		return emptySpace == 0;
	}
}
