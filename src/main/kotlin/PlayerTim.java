import Board.Board;
import Board.Field;
import Board.PieceColor;
import Board.Piece;

public class PlayerTim implements Player {


    PlayerTim() {

    }

    public void boardMatrixInBrettkopieren(Field[][] boardMatrix, int[][] Brett) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int vorzeichen = 1;
                if (boardMatrix[i][j].getTopPiece().getColour() == PieceColor.black) {
                    vorzeichen = -1;
                }
                Brett[i][j] = boardMatrix[i][j].getTopPiece().getSize() * vorzeichen;
            }
        }
    }

    public void printBrett(int[][] brett) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(brett[i][j]+"\t");
            }
            System.out.println();
        }
    }


    @Override
    public void nextMove(Board board) {

        int[][] Brett = new int[4][4];
        board.placePiece(1,3,new Piece(PieceColor.black,2));
        board.placePiece(2,3,new Piece(PieceColor.black,2));
        board.placePiece(1,1,new Piece(PieceColor.white,2));
        board.placePiece(1,2,new Piece(PieceColor.white,2));
        boardMatrixInBrettkopieren(board.getBoardMatrix(), Brett);
        printBrett(Brett);

    }

    public int feldBewertung() {


        return 0;
    }

    public boolean gewinnMöglichkeit(Board board) {


        return false;
    }

    public int zentrumBesetzung(Board board) {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {


            }
        }


        return score;
    }
}
