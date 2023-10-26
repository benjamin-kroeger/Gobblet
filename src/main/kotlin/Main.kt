import Board.Piece
import Board.PieceColor

fun main(args: Array<String>) {
    val testPiece = Piece(colour = PieceColor.white, size = 1)
    val testPiece2 = Piece(colour = PieceColor.black, size = 2)
    val testPiece3 = Piece(colour = PieceColor.white, size = 3)
    val test = Board.Board()
    test.printBoard()
    test.placePiece(0,0,testPiece)
    test.printBoard()
    test.placePiece(0,0,testPiece2)
    test.printBoard()
    test.placePiece(0,0,testPiece3)
    test.printBoard()
    test.checkForWinner()
    test.placePiece(1,0,testPiece)
    test.placePiece(1,1,testPiece)
    test.placePiece(1,2,testPiece)
    test.placePiece(1,3,testPiece)
    test.printBoard()
    test.checkForWinner()
    test.placePiece(0,3,testPiece2)
    test.placePiece(1,3,testPiece2)
    test.placePiece(2,3,testPiece2)
    test.placePiece(3,3,testPiece2)
    test.printBoard()
    test.checkForWinner()
}