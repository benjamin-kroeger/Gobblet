package Board

import java.lang.Exception
import java.util.ArrayDeque

class Field {

    private val stack = ArrayDeque<Piece>()

    fun placePiece(newPiece: Piece) {

        if (stack.size == 0) {
            stack.push(newPiece)
            return
        }
        if (stack.last.size >= newPiece.size) {
            throw Exception("The new piece does not fit over the old one")
        }
        stack.push(newPiece)
    }

    fun removePiece(): Piece {
        if (stack.size == 0) {
            throw Exception("You are trying to get a piece from an empty field")
        }
        return stack.pop()
    }

    fun getTopPiece():Piece{
        if (stack.size == 0){
            return Piece(colour = PieceColor.default, size = 0)
        }
        return stack.first
    }
}