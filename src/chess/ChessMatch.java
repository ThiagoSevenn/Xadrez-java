package chess;

import boardgame.Board;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {//por ser matriz quadrada, é possível colocar matriz.length nas duas.
                matriz[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return matriz;
    }
    
}
