package Board

data class Piece (
    val colour: PieceColor,
    val size : Int
)

enum class PieceColor {
    black,
    white,
    default
}