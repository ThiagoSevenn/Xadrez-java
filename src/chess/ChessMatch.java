package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
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

    private void initialSetup(){
        board.placePiece(new Rook(board,Color.WHITE), new Position(2,1));
        board.placePiece(new King(board,Color.BLACK), new Position(0,4));
        board.placePiece(new King(board,Color.WHITE), new Position(7,4));
    }
    
}
