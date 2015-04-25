import java.util.ArrayList;
import java.util.Map;

 public class Pawn extends ChessPiece {

	public Pawn(int column, int row, boolean isWhite) {
		super(column, row, isWhite);
	}
	
	/**
	 * Get the possible move to locations for the pawn
	 */
	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(BoardState stateOfBoard) 
	{
		ArrayList<Map<String, Integer>> possibleMoveLocations = new ArrayList<Map<String, Integer>>();
		
		int myColumn = super.getLocation().get("Column");
		int myRow = super.getLocation().get("Row");
		
		//Check all 4 possible move cases for the pawn
		
		return possibleMoveLocations;
	}
	 
}
