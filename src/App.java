import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;


public class App {
    public static void main(String[] args) throws Exception {

        List<ChessPiece> captured = new ArrayList<>();
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        
        while (!chessMatch.getCheckMate()) {
            try{
                Interface.clearScreen();

                Interface.printMatch(chessMatch,captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = Interface.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                Interface.clearScreen();
                Interface.printBoard(chessMatch.getPieces(), possibleMoves);
                


                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = Interface.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        Interface.clearScreen();
        Interface.printMatch(chessMatch, captured);
    }
}

