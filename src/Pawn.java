import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

 public class Pawn extends ChessPiece 
 {
	
	// pawn's start row
	private int startRow;
	
	private int moveDirection; 

	public Pawn(int column, int row, boolean isWhite) 
	{
		super(column, row, isWhite);
		startRow = row;
		
		// If started on pawns row for down-board player, 
		// then moves up and vice versa.
		moveDirection = (startRow == 1) ? 1 : -1;
	}
	
	/**
	 * Get the possible move to locations for the pawn
	 */
	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(BoardState stateOfBoard) 
	{
		// List of possible move-to-locations
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
				new ArrayList<Map<String, Integer>>();
		
		int myColumn = super.pieceLocation.get("Column");
		int myRow = super.pieceLocation.get("Row");
		
		// Check if can move forward 1 square
		if(stateOfBoard.getPieceAtPosition(myColumn, myRow + this.moveDirection) == null)
		{
			Map<String, Integer> forwardOnePosition = new HashMap<String, Integer>();
			forwardOnePosition.put("Column", myColumn);
			forwardOnePosition.put("Row", myRow + 1);
			possibleMoveLocations.add(forwardOnePosition);
			
			// Check if can move forward 2 squares
			if((stateOfBoard.getPieceAtPosition(myColumn, myRow + 2) == null) && (myRow == this.startRow))
			{
				Map<String, Integer> forwardTwoPosition = new HashMap<String, Integer>();
				forwardTwoPosition.put("Column", myColumn);
				forwardTwoPosition.put("Row", myRow + 2*this.moveDirection);
				possibleMoveLocations.add(forwardTwoPosition);
			}
		}
		
		// Check if there is an enemy piece forward-left (or forward-right if started on top)
		if(stateOfBoard.getPieceAtPosition(myColumn + 1, myRow + this.moveDirection) != null
				&& stateOfBoard.getPieceAtPosition(myColumn + 1, myRow + this.moveDirection).isWhite != super.isWhite)
		{
			Map<String, Integer> diagonalSideAPosition = new HashMap<String, Integer>();
			diagonalSideAPosition.put("Column", myColumn + 1);
			diagonalSideAPosition.put("Row", myRow + this.moveDirection);
			possibleMoveLocations.add(diagonalSideAPosition);
		}
		
		// Check if there is an enemy piece forward-left (or forward-right if started on top)
		if((stateOfBoard.getPieceAtPosition(myColumn - 1, myRow + this.moveDirection) != null)
				&& (stateOfBoard.getPieceAtPosition(myColumn - 1, myRow + this.moveDirection).isWhite != super.isWhite))
		{
			Map<String, Integer> diagonalSideAPosition = new HashMap<String, Integer>();
			diagonalSideAPosition.put("Column", myColumn - 1);
			diagonalSideAPosition.put("Row", myRow + this.moveDirection);
			possibleMoveLocations.add(diagonalSideAPosition);
		}
		
		return possibleMoveLocations;
	}
}
