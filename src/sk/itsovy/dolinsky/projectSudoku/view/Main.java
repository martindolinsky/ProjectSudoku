package sk.itsovy.dolinsky.projectSudoku.view;

import sk.itsovy.dolinsky.projectSudoku.InputData;
import sk.itsovy.dolinsky.projectSudoku.controller.SudokuSolver;
import sk.itsovy.dolinsky.projectSudoku.model.Board;
import sk.itsovy.dolinsky.projectSudoku.model.Tile;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
		new InputData().printData(new InputData().getDataArray());

		Tile test = new Tile(0);
		System.out.println(new Tile(0).getAvailable());
		new SudokuSolver().start();
    }


}
