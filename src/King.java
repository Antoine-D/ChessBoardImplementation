import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class King extends ChessPiece
{
	private boolean inCheck;
	
	public King(int column, int row, boolean isWhite) {
		super(column, row, isWhite);
		inCheck = false;
	}

	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(
			BoardState stateOfBoard) 
	{
		ArrayList<Map<String, Integer>> possibleMoveLocations = new ArrayList<Map<String, Integer>>();
		
		int kingsColumn = super.pieceLocation.get("Column");
		int kingsRow = super.pieceLocation.get("Row");
		
		for(int colIncrement = -1; colIncrement <= 1; colIncrement++)
		{
			for(int rowIncrement = -1; rowIncrement <= 1; rowIncrement++)
			{
				if(!(colIncrement == 0 && rowIncrement == 0) && 
						super.isLocationValid(kingsColumn + colIncrement, kingsRow + rowIncrement, stateOfBoard))
				{
					Map<String, Integer> moveLocation = new HashMap<String, Integer>();
					moveLocation.put("Column", kingsColumn + colIncrement);
					moveLocation.put("Row", kingsRow + rowIncrement);
					
					possibleMoveLocations.add(moveLocation);					
				}
			}
		}
		
		return possibleMoveLocations;
	}
}
