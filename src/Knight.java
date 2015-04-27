import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Knight extends ChessPiece 
{

	public Knight(int column, int row, boolean isWhite) {
		super(column, row, isWhite);
	}

	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(
			BoardState stateOfBoard) 
	{
		// List of possible move-to-locations
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
						new ArrayList<Map<String, Integer>>();
		
		int knightsColumn = super.pieceLocation.get("Column");
		int knightsRow = super.pieceLocation.get("Row");
		
		int[][] possibleMovements = new int[][]{
				{1, 2}, {-1,2},
				{1, -2}, {-1, -2},
				{2, 1}, {2, -1},
				{-2, 1}, {-2, -1}
		};
		
		// Make sure each of the movements result in locations that are valid
		for (int[] movement : possibleMovements)
		{
			if(super.isLocationValid(knightsColumn + movement[0], 
					knightsRow + movement[1], stateOfBoard))
			{
				HashMap<String, Integer> moveLocation = new HashMap<String, Integer>();
				moveLocation.put("Column", knightsColumn + movement[0]);
				moveLocation.put("Row", knightsRow + movement[1]);
				
				possibleMoveLocations.add(moveLocation);
			}
		}
			
		return possibleMoveLocations;
	}
	
}
