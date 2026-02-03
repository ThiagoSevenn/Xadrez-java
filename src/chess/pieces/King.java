package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import chess.ChessMatch;

public class King extends ChessPiece{

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //Casas disponíveis para cima//
        p.setValue(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para esquerda//
        p.setValue(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para direita//
        p.setValue(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para baixo//
        p.setValue(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para cima-esquerda//
        p.setValue(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para cima-direita//
        p.setValue(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para baixo-esquerda//
        p.setValue(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        //Casas disponíveis para baixo-direita//
        p.setValue(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matriz[p.getRow()][p.getColumn()] = true;
        }

        // Castling : Movimento Especial
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            // Castling do Lado do Rei
            Position position1 = new Position(position.getRow(),position.getColumn() + 3);
            if (testRookCastling(position1)){
                Position p1 = new Position(position.getRow(),position.getColumn() +1);
                Position p2 = new Position(position.getRow(),position.getColumn() +2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    matriz[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // Castling do Lado da Rainha
            Position position2 = new Position(position.getRow(),position.getColumn() - 4);
            if (testRookCastling(position2)){
                Position p1 = new Position(position.getRow(),position.getColumn() - 1);
                Position p2 = new Position(position.getRow(),position.getColumn() - 2);
                Position p3 = new Position(position.getRow(),position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    matriz[position.getRow()][position.getColumn() - 2] = true;
                }
            }

        }
        return matriz;
    }

    

}
