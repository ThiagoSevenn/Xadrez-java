import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;


public class App {
    public static void main(String[] args) throws Exception {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try{
                Interface.clearScreen();

                Interface.printBoard(chessMatch.getPieces());
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
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            
        }
        
    }
}

