import java.util.ArrayList;

public class GameState {
    public static Tray p1, p2;
    public static Board board;
    public static boolean turn, isFirstTurn, isSaved;
    public static int score1, score2, tilesPlaced;
    public static ArrayList<TrayTile> currentTiles, tilesPlayed;
    public static TrayTile activeTile;
    public static Bag bag;

    public GameState(Tray _p1, Board _board) {
	p1 = _p1;
	
	board = _board;
    }

    @SuppressWarnings("unchecked")
    public void setAll(Tray _p1, Board _board, boolean _turn,
	    boolean _isFirstTurn, boolean _isSaved, int _score1, int _score2,
	    ArrayList<TrayTile> _currentTiles,
	    ArrayList<TrayTile> _tilesPlayed, TrayTile _activeTile, Bag _bag) {
	//p1 = _p1;
	
	p1 = _p1; // new Tray((ArrayList<TrayTile>)_p1.getTiles().clone(), true);
	
	board = _board;
	turn = _turn;
	isFirstTurn = _isFirstTurn;
	isSaved = _isSaved;
	score1 = _score1;
	currentTiles = _currentTiles;
	tilesPlayed = _tilesPlayed;
	activeTile = _activeTile;
	bag = _bag;
    }

    
    public String toString() {
	return "GameState[p1="+p1+", score1="+score1+"]";
    }
}