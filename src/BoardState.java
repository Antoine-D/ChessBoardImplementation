import java.util.ArrayList;

/**
 * Keeps track of the state of the board
 * @author antoine
 *
 */
public class BoardState 
{	
	private ArrayList<ChessPiece> boardPieces;
	
	public BoardState(boolean isPlayingWhite, boolean whiteStartBottom)
	{		
		this.boardPieces = new ArrayList<ChessPiece>();
		
				/* Create White's Pieces */
		// Create whites pawns
		for(int i = 0; i < 8; i++)
		{
			Pawn pawn = new Pawn(i,(whiteStartBottom ? 1 : 6), true);
			this.boardPieces.add(pawn);
		}
		
		//Create rest of white's pieces
		this.boardPieces.add(new Bishop(2, (whiteStartBottom ? 0 : 7), true));
		this.boardPieces.add(new Bishop(5, (whiteStartBottom ? 0 : 7), true));
		
		
				/* Create Black's Pieces */
		// Create blacks pawns
		for(int i = 0; i < 8; i++)
		{
			Pawn pawn = new Pawn(i,(!whiteStartBottom ? 1 : 6), false);
			this.boardPieces.add(pawn);
		}
		
		// Create rest of black's pieces
		this.boardPieces.add(new Bishop(2, (whiteStartBottom ? 0 : 7), false));
		this.boardPieces.add(new Bishop(5, (whiteStartBottom ? 0 : 7), false));
	}
	
	public ArrayList<ChessPiece> getAllPieces()
	{
		return boardPieces;
	}
	
	public ChessPiece getPieceAtPosition(int col, int row)
	{
		for(ChessPiece piece : boardPieces)
		{
			if(piece.getLocation().get("Column") == col 
					&& piece.getLocation().get("Row") == row)
			{
				return piece;
			}
		}
		
		// no piece found at the location, so return null
		return null;
	}
}
