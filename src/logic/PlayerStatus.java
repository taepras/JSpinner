package logic;

import java.awt.*;

import javax.swing.*;

import ui.DrawingUtility;
import ui.IRenderable;
import lib.*;

public class PlayerStatus implements IRenderable{
	private int moved = 0;
	private Board board;
	
	public PlayerStatus(Board playing){
		this.board = playing;
	}
	
	public void move() {
		moved++;
	}
	
	public void decreaseMove() {
		moved--;
	}
	
	public int getMoved(){
		return moved;
	}
	
	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public void draw(Graphics g) {
		Font subFont = new Font("Tahoma", Font.BOLD, 25);
		Font mainFont = new Font("Tahoma", Font.BOLD, 40);
		g.setColor(Color.BLACK);
		DrawingUtility.drawStringInBox("BEST " + board.getBestScore(), subFont, 0, 0, Config.screenWidth, Config.topBarHeight, DrawingUtility.TEXT_LEFT, g);
		DrawingUtility.drawStringInBox("" + moved, mainFont, 0, 0, Config.screenWidth, Config.topBarHeight, DrawingUtility.TEXT_CENTER, g);
	}
}
