package Benjamin

import Board.Board
import Board.Field
import Board.PieceColor

class MiniBoard() {

    val s_pieces = Array(4) { i ->
        Array(4) { j ->
            0
        }
    }

    val m_pieces = Array(4) { i ->
        Array(4) { j ->
            0 // You can replace 0 with the initial values you want
        }
    }

    val l_pieces = Array(4) { i ->
        Array(4) { j ->
            0 // You can replace 0 with the initial values you want
        }
    }

    val xl_pieces = Array(4) { i ->
        Array(4) { j ->
            0 // You can replace 0 with the initial values you want
        }
    }

    fun updateFromBoard(boardMatrix: Array<Array<Field>>) {
        for (i in boardMatrix.indices) {
            for (j in boardMatrix.indices){
                val multiplier = if (boardMatrix[i][j].getTopPiece().colour == PieceColor.white) 1 else -1

                when(boardMatrix[i][j].getTopPiece().size){
                    1 -> s_pieces[i][j] = 1*multiplier
                    2 -> m_pieces[i][j] = 1*multiplier
                    3 -> l_pieces[i][j] = 1*multiplier
                    4 -> xl_pieces[i][j] = 1*multiplier
                }
            }

        }
    }

    fun deepCopy(): MiniBoard {
        val copiedBoard = MiniBoard()

        for (i in 0 until 4) {
            for (j in 0 until 4) {
                copiedBoard.s_pieces[i][j] = this.s_pieces[i][j]
                copiedBoard.m_pieces[i][j] = this.m_pieces[i][j]
                copiedBoard.l_pieces[i][j] = this.l_pieces[i][j]
                copiedBoard.xl_pieces[i][j] = this.xl_pieces[i][j]
            }
        }

        return copiedBoard
    }


}