import java.util.ArrayList;

/**
 * Keeps track of the state of the board
 * @author antoine
 *
 */
public class BoardState 
{	
	private ArrayList<ChessPiece> boardPieces;
	
	public BoardState(boolean isPlayingWhite, boolean whiteStartsBottom)
	{	
		this.boardPieces = new ArrayList<ChessPiece>();
		
				/* Create White's Pieces */
		// Create whites pawns
		for(int i = 0; i < 8; i++)
		{
			Pawn pawn = new Pawn(i,(whiteStartsBottom ? 1 : 6), true);
			this.boardPieces.add(pawn);
		}
		
		//Create rest of white's pieces
		this.boardPieces.add(new Bishop(2, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Bishop(5, (whiteStartsBottom ? 0 : 7), true));
		
		
				/* Create Black's Pieces */
		// Create blacks pawns
		for(int i = 0; i < 8; i++)
		{
			Pawn pawn = new Pawn(i,(!whiteStartsBottom ? 1 : 6), false);
			this.boardPieces.add(pawn);
		}
		
		// Create rest of black's pieces
		this.boardPieces.add(new Bishop(2, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Bishop(5, (!whiteStartsBottom ? 0 : 7), false));
	}
	
	/**
	 * Get all of the chess pieces
	 * @return array list of all of the pieces on the board
	 */
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
	
	public String getBoardVisual()
	{
		String boardVisual = "";
		
		for(int rowIterator = 7; rowIterator >= 0; rowIterator--)
		{
			boardVisual += "\t";
			for(int columnIterator = 0; columnIterator < 8; columnIterator++)
			{
				
				ChessPiece thisPiece = getPieceAtPosition(columnIterator, rowIterator);
				if(thisPiece != null)
				{
					boardVisual += (thisPiece.isWhite) ? "W_" : "B_";
					if (thisPiece instanceof Pawn)
					{
						boardVisual += "Pawn \t \t";
					}
					
					else if(thisPiece instanceof Bishop)
					{
						boardVisual += "Bish \t \t";
					}
				}
				
				else
				{
					boardVisual += " --- \t \t";
				}
			}
			
			boardVisual += "\n";
		}
		
		return boardVisual;
	}
}
