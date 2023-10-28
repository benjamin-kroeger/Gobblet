import Board.Board;
import Board.Piece;
import Board.PieceColor;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class IntetactivePlayer implements Player{

    private final Scanner scanner;
    private PieceColor color;

    public IntetactivePlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void nextMove(@NotNull Board board) {

        System.out.println("nächster zug?");
        System.out.println("x koordinate?");
        int int1 = scanner.nextInt();
        System.out.println("y koordiante?");
        int int2 = scanner.nextInt();
        System.out.println("size? ");
        int size = scanner.nextInt();

        Piece test = new Piece(this.color, size);
        board.placePiece(int1, int2, test);









    }

    @Override
    public void setColor(@NotNull PieceColor color) {
        this.color = color;
    }
}
