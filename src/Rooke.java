import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Rooke extends ChessPiece {

	/**
	 * Create a Rooke chess piece
	 */
	public Rooke(int column, int row, boolean isWhite) 
	{
		super(column, row, isWhite);
	}

	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(
			BoardState stateOfBoard) 
	{
		// List of possible move-to-locations
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
				new ArrayList<Map<String, Integer>>();
		
		boolean inVerticalMovement = true;
		boolean inHorizontalMovement = false;
		int squareIncrement = -1;
		
		while(inVerticalMovement || inHorizontalMovement)
		{
			int columnIterator = super.pieceLocation.get("Column") + (inHorizontalMovement ? squareIncrement : 0);
			int rowIterator = super.pieceLocation.get("Row") + (inVerticalMovement ? squareIncrement : 0);
			
			while(columnIterator >= 0 && rowIterator >= 0 && columnIterator < 7 && rowIterator < 7)
			{				
				if(super.isLocationValid(columnIterator, rowIterator, stateOfBoard))
				{
					Map<String, Integer> validMoveToPosition = new HashMap<String, Integer>();
					validMoveToPosition.put("Column", columnIterator);
					validMoveToPosition.put("Row", rowIterator);
					possibleMoveLocations.add(validMoveToPosition);
					
					// If the valid square has a piece on it, then stop this direction's iteration
					if(stateOfBoard.getPieceAtPosition(columnIterator, rowIterator) != null)
					{
						break;
					}
				}
				
				else
				{
					break;
				}
				
				rowIterator += (inVerticalMovement ? squareIncrement : 0);
				columnIterator += (inHorizontalMovement ? squareIncrement : 0);
			}
			
			squareIncrement += 2;
			
			if(squareIncrement > 1)
			{
				if(inVerticalMovement)
				{
					inVerticalMovement = false;
					inHorizontalMovement = true;
					squareIncrement = -1;
				}
				else
				{
					inHorizontalMovement = false;
				}
			}
		}
		
		return possibleMoveLocations;
	}
	
}