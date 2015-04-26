import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for a chess piece
 * @author antoine
 *
 */
public abstract class ChessPiece 
{
	protected Map<String, Integer> pieceLocation;
	protected boolean isWhite;
	
	/**
	 * Create a new chess piece
	 * @param column integer the column of the new piece
	 * @param row integer the row of the piece's number equivalent (a=0, b=1, c=2, etc.)
	 */
	public ChessPiece(int column, int row, boolean isWhite)
	{
		this.isWhite = isWhite;
		this.pieceLocation = new HashMap<String, Integer>();
		pieceLocation.put("Column", column);
		pieceLocation.put("Row", row);
	}
	
	/**
	 * Get the location of the piece
	 * @return Map<String, Integer> the location with "Column" and "Row" keys
	 */
	public Map<String, Integer> getLocation()
	{	
		return this.pieceLocation;
	}
	
	/**
	 * Get's the possible locations that the piece can move to
	 */
	public abstract ArrayList<Map<String, Integer>> getPossibleMoveToLocations(BoardState stateOfBoard);
}
