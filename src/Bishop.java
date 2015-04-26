import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Bishop extends ChessPiece {

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
		ArrayList<Map<String, Integer>> possibleMoveLocations = new ArrayList<Map<String, Integer>>();

		// Check for each of the four diagonal directions that the bishop can
		// move in
		for (int columnIncrement = -1; columnIncrement <= 1; columnIncrement += 2) {
			for (int rowIncrement = -1; rowIncrement <= 1; rowIncrement += 2) {
				// Set the diagonal iterator to one past the bishop's current
				// position
				int columnIterator = super.pieceLocation.get("Column")
						+ columnIncrement;
				int rowIterator = super.pieceLocation.get("Row") + rowIncrement;

				while (rowIterator >= 0 && columnIterator >= 0
						&& rowIterator < 8 && columnIterator < 8) {

					ChessPiece pieceAtPosition = stateOfBoard
							.getPieceAtPosition(columnIterator, rowIterator);

					// If a piece exists at the position, then check if it's one
					// of your own
					// and stop checking this diagonal.
					if (pieceAtPosition != null) {
						// If the piece is not one of your own, then can take it
						// (so add to possible move)
						if (pieceAtPosition.isWhite != super.isWhite) {
							Map<String, Integer> possibleMoveToPosition = new HashMap<String, Integer>();
							possibleMoveToPosition
									.put("Column", columnIterator);
							possibleMoveToPosition.put("Row", rowIterator);
							possibleMoveLocations.add(possibleMoveToPosition);
						}

						break;
					}

					// If no piece at the position then add the position to the
					// list and continue iterating down the diagonol
					else {
						Map<String, Integer> possibleMoveToPosition = new HashMap<String, Integer>();
						possibleMoveToPosition.put("Column", columnIterator);
						possibleMoveToPosition.put("Row", rowIterator);
						possibleMoveLocations.add(possibleMoveToPosition);
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
