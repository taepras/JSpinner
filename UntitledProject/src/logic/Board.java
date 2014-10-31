/**
 * @author Thanawit Prasongpongchai (5631045321)
 * @author Phatrasek Jirabovonvisut (5630xxxx21)
 */

package logic;

import lib.Utility;

public class Board {
	private Tile[][] board;
	public static final int DEFAULT_SHUFFLE = 1000;
	
	public Board(int width, int height){
		board = new Tile[width][height];
		initiateBoard();
	}
	
//	public Board(File f){
		// File format:
		// w h
		// x x x x x
		// x x x x x
		// (board of width w and height h)
		// where x can be ... "-" means no tile, "S(number)" means SimpleTile etc.
//		Scanner in = new Scanner(f);
//		String board = in.next();
//	}
	
	public void initiateBoard(){
		int k = 1;
		for(int j = 0; j < board[0].length; j++){
			for(int i = 0; i < board.length; i++){
				board[i][j] = new SimpleTile(k);
				k++;
			}
		}
	}
	
	public void flip(int x1, int y1, int x2, int y2){
		if(x1 == x2){
			if(y2 < y1){
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			for(int i = y1; i < (y1 + y2) / 2; i++){
				Tile tmp =  board[x1][i] ;
				board[x1][i] = board[x1][y2 - (i - y1)];
				board[x1][y2 - (i - y1)] = tmp;
			}
		}
		else if(y1 == y2){
			if(x2 < x1){
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			for(int i = y1; i < (y1 + y2) / 2; i++){
				Tile tmp = null;
				tmp = board[i][y1] ;
				board[i][y1] = board[x2 - (i - x1)][y1];
				board[x2 - (i - x1)][y1] = tmp;
			}
		}
	}
	
	public void shuffle(int times){
		// still not available with non-rectangle boards;
		// and also non-linear flips. 
		for(int i = 0; i < times; i++){
			int direction = Utility.random(0, 2);
			if(direction == 0){
				//horizontal
				int x = Utility.random(0, board.length);
				int ya = Utility.random(0, board[x].length);
				int yb = Utility.random(0, board[x].length);
				flip(x, ya, x, yb);
			}
			if(direction == 0){
				//vertical
				int y = Utility.random(0, board[0].length);
				int xa = Utility.random(0, board.length);
				int xb = Utility.random(0, board.length);
				flip(xa, y, xb, y);
			}
		}
	}
	
	public String toString(){
		String out = "";
		for(int j = 0; j < board[0].length; j++){
			for(int i = 0; i < board.length; i++){
				out += board[i][j] + ", ";
			}
			out += "\n";
		}
		return out;
	}
	
	public static void main(String[] args) {
		Board a = new Board(8, 8);
		System.out.println(a);
		a.shuffle(Board.DEFAULT_SHUFFLE);
		System.out.println(a);
	}
}
