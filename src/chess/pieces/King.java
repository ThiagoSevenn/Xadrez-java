package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
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
        return matriz;
    }

    

}
