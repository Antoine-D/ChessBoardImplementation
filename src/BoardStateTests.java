import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BoardStateTests 
{
	
	@Test
	public void ensureAllPiecesPresent()
	{
		BoardState testBoardState = new BoardState(true, true);	
		assertEquals(32, testBoardState.getAllPieces().size());
	}

	@Test
	public void testPawns() 
	{
		BoardState testBoardState = new BoardState(true, true);
				
		// Check both players rows of pawns and ensure they can't move diagonally from the get-go
		for(int row = 1; row <= 6; row+=5)
		{
			// Check bottom row
			for(int i = 0; i < 8; i++)
			{
				ChessPiece thisPiece = testBoardState.getPieceAtPosition(i,row);

				ArrayList<Map<String, Integer>> possibleMoves = 
						thisPiece.getPossibleMoveToLocations(testBoardState);
				
				for(Map<String, Integer> move: possibleMoves)
				{
					assertEquals(thisPiece.pieceLocation.get("Column"), move.get("Column"));
				}
			}
		}
	}
	
	@Test
	public void testBishops() 
	{
		BoardState testBoardState = new BoardState(true, true);
		
		testBoardState.getPieceAtPosition(2, 0);
				
		testBoardState.getPieceAtPosition(1, 1).moveTo(1,2);
		
		ArrayList<Map<String, Integer>> possibleMoveLocations = 
				testBoardState.getPieceAtPosition(2, 0).getPossibleMoveToLocations(testBoardState);
		
		assertEquals(2, possibleMoveLocations.size());
		
		
		assert((possibleMoveLocations.get(0).get("Column") == 1 && possibleMoveLocations.get(0).get("Row") == 1) || 
				(possibleMoveLocations.get(1).get("Column") == 1 && possibleMoveLocations.get(1).get("Row") == 1));
		
		assert((possibleMoveLocations.get(0).get("Column") == 0 && possibleMoveLocations.get(0).get("Row") == 2) || 
				(possibleMoveLocations.get(1).get("Column") == 0 && possibleMoveLocations.get(1).get("Row") == 2));
		
		//System.out.println(testBoardState.getPieceAtPosition(1,1).getPossibleMoveToLocations(testBoardState));
		//System.out.println(testBoardState.getPieceAtPosition(0,2).isWhite);
	}
	
	@Test
	public void testRookes() 
	{
		BoardState testBoardState = new BoardState(true, true);
						
		testBoardState.getPieceAtPosition(0, 1).moveTo(0,3);
			
		assertEquals(2, testBoardState.getPieceAtPosition(0,0)
				.getPossibleMoveToLocations(testBoardState).size());
	}
	
	@Test
	public void testKnights()
	{
		BoardState testBoardState = new BoardState(true, true);
		
		ArrayList<Map<String, Integer>> possibleMoveLocations = testBoardState.getPieceAtPosition(1, 0).getPossibleMoveToLocations(testBoardState);

		assertEquals(2, possibleMoveLocations.size());
		assert((possibleMoveLocations.get(0).get("Column") == 0 && possibleMoveLocations.get(0).get("Row") == 2) || 
				(possibleMoveLocations.get(1).get("Column") == 0 && possibleMoveLocations.get(1).get("Row") == 2));
		assert((possibleMoveLocations.get(0).get("Column") == 2 && possibleMoveLocations.get(0).get("Row") == 2) || 
				(possibleMoveLocations.get(1).get("Column") == 2 && possibleMoveLocations.get(1).get("Row") == 2));
	
		assertEquals(2, testBoardState.getPieceAtPosition(6, 0).getPossibleMoveToLocations(testBoardState).size());
		assertEquals(2, testBoardState.getPieceAtPosition(1, 6).getPossibleMoveToLocations(testBoardState).size());
		assertEquals(2, testBoardState.getPieceAtPosition(6, 6).getPossibleMoveToLocations(testBoardState).size());
	}
	
	@Test
	public void testQueen()
	{
		BoardState testBoardState = new BoardState(true, true);
		
		ArrayList<Map<String, Integer>> possibleMoveLocations = testBoardState.getPieceAtPosition(4, 0).getPossibleMoveToLocations(testBoardState);

		assertEquals(0, possibleMoveLocations.size());
	}
	
	@Test
	public void testKing()
	{
		BoardState testBoardState = new BoardState(true, true);
		
		ArrayList<Map<String, Integer>> possibleMoveLocations = testBoardState.getPieceAtPosition(5, 0).getPossibleMoveToLocations(testBoardState);

		assertEquals(0, possibleMoveLocations.size());
	}
	
	@Test
	public void testCheck()
	{
		BoardState testBoardState = new BoardState(true, true);
				
		testBoardState.getPieceAtPosition(5, 1).moveTo(0, 2);
		testBoardState.getPieceAtPosition(4, 1).moveTo(5, 1);
		assertFalse(testBoardState.inCheck(true));
		
		testBoardState.getPieceAtPosition(4, 7).moveTo(4, 1);
		
		assertTrue(testBoardState.inCheck(true));
	}
	
	
}
