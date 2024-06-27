package chess;

import boardgame.Board;
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

    private void placeNewPiece(char column, int row , ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup(){
        placeNewPiece('b' , 6,new Rook(board,Color.WHITE));
        placeNewPiece('e', 8,new King(board,Color.BLACK));
        placeNewPiece('e', 1,new King(board,Color.WHITE));
    }
    
}
