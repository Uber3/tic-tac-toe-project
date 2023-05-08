/*
 * Copyright 2023 Dzmitry Rusak
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package tictactoe.component;
/*
 * @author Dzmitry Rusak
 * @link
 */

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

public class WinnerVerifier {

    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }


    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, 'O');
    }

    private boolean isWinner(final GameTable gameTable, final char sign) {
        return isWinnerByRows(gameTable, sign) ||
                isWinnerByColls(gameTable, sign) ||
                isWinnerByMainDiagonal(gameTable, sign) ||
                isWinnerBySecondaryDiagonal(gameTable, sign);
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final char sign) {
        if (gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(0, 2)) &&
                gameTable.getSign(new Cell(0, 2)) == sign) {
            return true;
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final char sign) {
        if (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == sign) {
            return true;
        }
        return false;
    }

    private boolean isWinnerByColls(final GameTable gameTable, final char sign) {
        for (int j = 0; j < 3; j++) {
            if (gameTable.getSign(new Cell(0, j)) == gameTable.getSign(new Cell(1, j)) &&
                    gameTable.getSign(new Cell(1, j)) == gameTable.getSign(new Cell(2, j)) &&
                    gameTable.getSign(new Cell(2, j)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByRows(final GameTable gameTable, final char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }


}