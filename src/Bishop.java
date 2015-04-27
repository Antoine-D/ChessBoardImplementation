import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Bishop extends ChessPiece 
{

	public Bishop(int column, int row, boolean isWhite) 
	{
		super(column, row, isWhite);
	}

	/**
	 * Get the bishop's possible move locations
	 */
	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(
			BoardState stateOfBoard) 
	{
		// List of possible move-to-locations
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
				new ArrayList<Map<String, Integer>>();

		// Check for each of the four diagonal directions that the bishop can
		// move in
		for (int columnIncrement = -1; columnIncrement <= 1; columnIncrement += 2) 
		{
			for (int rowIncrement = -1; rowIncrement <= 1; rowIncrement += 2) 
			{
				// Set the diagonal iterator to one past the bishop's current
				// position
				int columnIterator = super.pieceLocation.get("Column")
						+ columnIncrement;
				int rowIterator = super.pieceLocation.get("Row") + rowIncrement;

				while (rowIterator >= 0 && columnIterator >= 0 && rowIterator < 8 && columnIterator < 8) 
				{
					// Check that the location is valid
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

					// Go onto the next space in the diagonal path
					columnIterator += columnIncrement;
					rowIterator += rowIncrement;
				}
			}
		}

		return possibleMoveLocations;
	}
}
