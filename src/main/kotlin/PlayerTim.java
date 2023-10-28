import Board.Board;
import Board.Field;
import Board.PieceColor;
import Board.Piece;
import org.jetbrains.annotations.NotNull;

public class PlayerTim implements Player {
    int[][] bewertungsmatrix1;


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
                System.out.print(brett[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    @Override
    public void nextMove(Board board) {
        int[][] Brett = new int[4][4];
        boardMatrixInBrettkopieren(board.getBoardMatrix(), Brett);
        //printBrett(Brett);
        //printBrett(bewertungsMatrixErstellen());
        bewertungsMatrixErstellen();
        //int bewertung = feldBewertung(Brett);

        int xPosition = bestmove(Brett)[0];
        int yPosiiton = bestmove(Brett)[1];
        int pieceSize = bestmove(Brett)[2];


        Piece newPiece = new Piece(PieceColor.black, pieceSize);
        board.placePiece(xPosition, yPosiiton, newPiece);


        //System.out.println("zentrumbewertung: "+ bewertung);
    }

    public int minimax(int[][] brett) {
        return 0;

    }


    public int[] bestmove(int[][] brett) {
        // initialisieren mit -infinity
        int bestScore = Integer.MIN_VALUE;
        // feld um xPosition[0], yPosition[1] und size[2] des besten Zugs zu speichern
        int[] bestmoveFeld = new int[3];
        // für jeden möglichen zug soll der score berechnet werden
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // betrag der iim brett gespeicherten size
                int pieceSize = Math.abs(brett[i][j]);
                for (int r = pieceSize + 1; r < 5; r++) {
                    // score berechnen für möglichen Zug
                    brett[i][j] = r;
                    int score = feldBewertung(brett);
                    //= minimax(brett);
                    // wieder rückgängig machen und unsprungsbrett wiederherstellen
                    brett[i][j] = pieceSize;
                    if (score > bestScore) {
                        bestScore = score;
                        bestmoveFeld[0] = i;
                        bestmoveFeld[1] = j;
                        bestmoveFeld[2] = r;
                    }
                }
            }
        }

        return bestmoveFeld;
    }

    public int feldBewertung(int[][] brett) {
        int bewertung = 0;
        bewertung = zentrumBesetzung(brett);
        bewertung = bewertung + size3anpassung(brett);
        bewertung = bewertung + dreiInEinerReiheOderSpalteBewertung(brett);
        return bewertung;
    }

    public boolean gewinnMoeglichkeit() {

        return false;
    }

    public int gewinnBewertung(Board board) {
        return 0;
    }

    public int dreiInEinerReiheOderSpalteBewertung(int[][] brett) {
        // für jede Zeile
        int score = 0;

        for (int i = 0; i < 4; i++) {
            int positiveCount = 0;
            int negativeCount = 0;

            for (int j = 0; j < 4; j++) {
                if (brett[i][j] == 0) {
                    continue;
                } else if (brett[i][j] < 0) {
                    negativeCount++;
                } else if (brett[i][j] > 0) {
                    positiveCount++;
                }
            }
            // für jede reihe in der spieler1 mehr steine halt als spieler2 gibt es punkte
            if (positiveCount == 3) {
                score = score + 8;
            }
            if (negativeCount == 3) {
                score = score - 8;
            }
        }
        return score;
    }

    // zentrum felder sind mehr wert als randfelder
    // werte der Zentrum felder werden mit größe multiplziert um stärker zu gewichten mit großen figuren das Zentrum zu kontrollieren
    public int zentrumBesetzung(int[][] brett) {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                score = score + (brett[i][j] * bewertungsmatrix1[i][j] + 2) / 2;
            }
        }
        return score;
    }

    // steine der größe 3 sollen nicht in der mitte platziert werden, da dann ein 4 entgültig drüber gesetzt werden kann
    public int size3anpassung(int[][] brett) {
        int score = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (brett[i][j] == -3) {
                    score = score + 6;
                }
                if (brett[i][j] == 3) {
                    score = score - 6;
                }

            }
        }
        return score;
    }

    public int[][] bewertungsMatrixErstellen() {
        bewertungsmatrix1 = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                bewertungsmatrix1[i][j] = 1;
            }
        }
        //zentrumsfelder
        bewertungsmatrix1[1][1] = 3;
        bewertungsmatrix1[1][2] = 3;
        bewertungsmatrix1[2][2] = 3;
        bewertungsmatrix1[2][1] = 3;
        //ecken
        bewertungsmatrix1[0][0] = 2;
        bewertungsmatrix1[3][3] = 2;
        bewertungsmatrix1[0][3] = 2;
        bewertungsmatrix1[3][0] = 2;
        return bewertungsmatrix1;
    }

    @Override
    public void setColor(@NotNull PieceColor color) {
        System.out.println("hui");
    }
}
