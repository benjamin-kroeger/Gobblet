package Board

class Board {

    private val board: Array<Array<Field>> = Array(4) {
        Array(4) {
            Field()
        }
    }

    fun checkForWinner() : Boolean{

        // check rows
        for( row in board){
            if(row.distinctBy { it.getTopPiece().colour }.size == 1){
                println("${row[0].getTopPiece().colour} has won")
            }
        }

        // Check columns
        for (col in 0..<board[0].size) { // Assuming all rows have the same number of columns
            val column = board.map { it[col] } // Get all pieces in the current column
            if (column.distinctBy { it.getTopPiece().colour }.size == 1) {
                println("${column[0].getTopPiece().colour} has won")
            }
        }


    }

    fun placePiece(x: Int, y: Int, piece: Piece) {

        try {
            board[x][y].placePiece(piece)
        } catch (e: Exception) {
            println("Fuck you")
        }
    }

    fun movePiece(x_old: Int, y_old: Int, x_new: Int, y_new: Int) {
        try {
            val piece = board[x_old][y_old].removePiece()
            board[x_new][y_new].placePiece(piece)
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

        for(row in board){
            for(field in row){
                val topPiece = field.getTopPiece()
                print("${pieceToNum(topPiece)}\t")
            }
            println()
        }
        println()
    }

}