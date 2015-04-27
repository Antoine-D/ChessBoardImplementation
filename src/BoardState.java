import java.util.ArrayList;
import java.util.Map;

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
		this.boardPieces.add(new King(4, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Queen(3, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Bishop(2, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Bishop(5, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Knight(1, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Knight(6, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Rooke(0, (whiteStartsBottom ? 0 : 7), true));
		this.boardPieces.add(new Rooke(7, (whiteStartsBottom ? 0 : 7), true));
		
				/* Create Black's Pieces */
		// Create blacks pawns
		for(int i = 0; i < 8; i++)
		{
			Pawn pawn = new Pawn(i,(!whiteStartsBottom ? 1 : 6), false);
			this.boardPieces.add(pawn);
		}
		
		// Create rest of black's pieces
		this.boardPieces.add(new King(3, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Queen(4, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Bishop(2, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Bishop(5, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Knight(1, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Knight(6, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Rooke(0, (!whiteStartsBottom ? 0 : 7), false));
		this.boardPieces.add(new Rooke(7, (!whiteStartsBottom ? 0 : 7), false));

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
	
	public boolean inCheck(boolean checkingWhite)
	{
		ArrayList<ChessPiece> chessPieces = this.getAllPieces();
		
		ChessPiece kingOfColorToCheck = null;
		
		ArrayList<ChessPiece> enemyChessPieces = new ArrayList<ChessPiece>();
		
		// Remove all friendly pieces from the array list and get the friendly king
		for(ChessPiece piece : chessPieces)
		{
			if(piece.isWhite != checkingWhite)
			{
				enemyChessPieces.add(piece);
			}
			
			else if(piece instanceof King)
			{
				kingOfColorToCheck = piece;
			}
		}
		
		if(kingOfColorToCheck != null) 
		{
			
			// For all of the enemy pieces, check if they can move to the king's square
			for(ChessPiece enemyPiece : enemyChessPieces)
			{
				ArrayList<Map<String, Integer>> possibleMoveLocations = enemyPiece.getPossibleMoveToLocations(this);
				for(Map<String, Integer> possibleLocation : possibleMoveLocations)
				{
					if(possibleLocation.get("Column") == kingOfColorToCheck.pieceLocation.get("Column") &&
							possibleLocation.get("Row") == kingOfColorToCheck.pieceLocation.get("Row"))
					{
						return true;
					}				
				}
			}
		}
		
		return false;
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
					
					else if(thisPiece instanceof Rooke)
					{
						boardVisual += "Rook \t \t";
					}
					
					else if(thisPiece instanceof Knight)
					{
						boardVisual += "Kgnt \t \t";
					}
					
					else if(thisPiece instanceof Queen)
					{
						boardVisual += "Quen \t \t";
					}
					
					else if(thisPiece instanceof King)
					{
						boardVisual += "King \t \t";
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
