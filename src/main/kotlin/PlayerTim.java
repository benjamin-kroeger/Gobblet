import Board.Board;
import Board.Field;
import Board.PieceColor;
import Board.Piece;

public class PlayerTim implements Player {
    int [][] bewertungsmatrix1;




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
        System.out.println();
    }


    @Override
    public void nextMove(Board board) {

        int[][] Brett = new int[4][4];
        board.placePiece(1,3,new Piece(PieceColor.black,2));
        board.placePiece(2,3,new Piece(PieceColor.black,2));
        board.placePiece(1,1,new Piece(PieceColor.black,3));
        board.placePiece(1,2,new Piece(PieceColor.white,2));
        boardMatrixInBrettkopieren(board.getBoardMatrix(), Brett);
        printBrett(Brett);
        printBrett(bewertungsMatrixErstellen());
        int bewertung = feldBewertung(Brett);


        System.out.println("zentrumbewertung: "+ bewertung);

    }

    public int feldBewertung(int [][] brett) {
        int bewertung=0;
        bewertung = zentrumBesetzung(brett)+size3anpassung(brett);


        return bewertung;
    }

    public boolean gewinnMöglichkeit(Board board) {


        return false;
    }
    // zentrum felder sind mehr wert als randfelder
    // werte der Zentrum felder werden mit größe multiplziert um stärker zu gewichten mit großen figuren das Zentrum zu kontrollieren
    public int zentrumBesetzung(int [][] brett) {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                score = score + brett[i][j]*bewertungsmatrix1[i][j];
            }
        }
        return score;
    }
    // steine der größe 3 sollen nicht in der mitte plaziert werden, da dann ein 4 entgültig drüber gesetzt werden kann
    public int size3anpassung(int [][] brett){
        int score =0;
        for (int i = 1; i < 3;i++) {
            for(int j=1;j<3;j++){
                if(brett[i][j] == -3){
                    score = score +6;
                }
                if(brett[i][j] == 3){
                    score = score -6;
                }

            }
        }
        return score;
    }

    public int[][] bewertungsMatrixErstellen() {
        bewertungsmatrix1 = new int[4][4];
        for (int i = 0; i < 4;i++) {
            for(int j=0;j<4;j++){
                bewertungsmatrix1[i][j] = 1;
            }
        }
        bewertungsmatrix1[1][1]=2;
        bewertungsmatrix1[1][2]=2;
        bewertungsmatrix1[2][2]=2;
        bewertungsmatrix1[2][1]=2;
        return bewertungsmatrix1;
    }
}
