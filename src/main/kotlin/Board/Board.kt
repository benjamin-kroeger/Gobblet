package Board

class Board {

    private val boardMatrix: Array<Array<Field>> = Array(4) {
        Array(4) {
            Field()
        }
    }

    fun getBoardMatrix() : Array<Array<Field>> {
        return boardMatrix
    }

    fun checkForWinner() : Boolean{

        // check rows
        for( row in boardMatrix){
            if(row.distinctBy { it.getTopPiece().colour }.size == 1 && row.last().getTopPiece().colour != PieceColor.default){
                println("${row[0].getTopPiece().colour} has won")
                return true
            }
        }

        // Check columns
        for (col in 0..<boardMatrix[0].size) { // Assuming all rows have the same number of columns
            val column = boardMatrix.map { it[col] } // Get all pieces in the current column
            if (column.distinctBy { it.getTopPiece().colour }.size == 1 && column.last().getTopPiece().colour != PieceColor.default) {
                println("${column[0].getTopPiece().colour} has won")
                return true
            }
        }

        val mainDiagonal = (0 until boardMatrix.size).map { boardMatrix[it][it] }
        if (mainDiagonal.distinctBy { it.getTopPiece().colour }.size == 1 && mainDiagonal.last().getTopPiece().colour != PieceColor.default) {
            println("${mainDiagonal[0].getTopPiece().colour} has won")
            return true
        }

        // Check anti-diagonal (top-right to bottom-left)
        val antiDiagonal = (0 until boardMatrix.size).map { boardMatrix[it][boardMatrix.size - 1 - it] }
        if (antiDiagonal.distinctBy { it.getTopPiece().colour }.size == 1 && antiDiagonal.last().getTopPiece().colour != PieceColor.default) {
            println("${antiDiagonal[0].getTopPiece().colour} has won")
            return true
        }


        return false
    }

    fun placePiece(x: Int, y: Int, piece: Piece) {

        try {
            boardMatrix[x][y].placePiece(piece)
        } catch (e: Exception) {
            println("Fuck you")
        }
    }

    fun movePiece(x_old: Int, y_old: Int, x_new: Int, y_new: Int) {
        try {
            val piece = boardMatrix[x_old][y_old].removePiece()
            boardMatrix[x_new][y_new].placePiece(piece)
        }catch (e: Exception){
            println("Fuckyou")
        }
    }

    fun printBoard(){

        fun pieceToNum(piece: Piece):Int{
            if (piece.colour == PieceColor.black){
                return -piece.size
            }
            return piece.size
        }

        for(row in boardMatrix){
            for(field in row){
                val topPiece = field.getTopPiece()
                print("${pieceToNum(topPiece)}\t")
            }
            println()
        }
        println()
    }

}