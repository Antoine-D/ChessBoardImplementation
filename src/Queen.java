import java.util.ArrayList;
import java.util.Map;


public class Queen extends ChessPiece
{

	public Queen(int column, int row, boolean isWhite) {
		super(column, row, isWhite);
	}

	@Override
	public ArrayList<Map<String, Integer>> getPossibleMoveToLocations(
			BoardState stateOfBoard) {
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
				new ArrayList<Map<String, Integer>>();
		
		Bishop bishop = new Bishop(super.pieceLocation.get("Column"), 
				super.pieceLocation.get("Row"), super.isWhite);
		
		possibleMoveLocations.addAll(
				new Bishop(super.pieceLocation.get("Column"), super.pieceLocation.get("Row"), 
						super.isWhite).getPossibleMoveToLocations(stateOfBoard));
		possibleMoveLocations.addAll(
				new Rooke(super.pieceLocation.get("Column"), super.pieceLocation.get("Row"), 
						super.isWhite).getPossibleMoveToLocations(stateOfBoard));
		
		return possibleMoveLocations;
	}

}
