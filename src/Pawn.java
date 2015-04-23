import java.util.ArrayList;
import java.util.Map;

 public class Pawn extends ChessPiece {

	public Pawn(int column, int row) {
		super(column, row);
	}
	
	/**
	 * Get the possible move to locations for the pawn
	 */
	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations() 
	{
		ArrayList<Map<String, Integer>> possibleMoveLocations = new ArrayList<Map<String, Integer>>();
		return possibleMoveLocations;
	}
	 
}
