package ui.gamebutton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import lib.Config;
import logic.Board;
import logic.IUpdatable;
import logic.Tile;
import ui.Clickable;
import ui.DrawingUtility;
import ui.IRenderable;

public class ClockWiseButton extends Clickable implements IRenderable,
		IUpdatable {

	private boolean isVisible = false;
	
	public ClockWiseButton(){
		type = Clickable.CIRCLE;
		x = Config.screenWidth / 2;
		y = 100;
		width = 60;
		height = 60;
	}

	@Override
	public int getZ() {
		return 20000;
	}
	
	@Override
	public void draw(Graphics g) {
		if(isVisible){
//			g.setColor(Color.LIGHT_GRAY);
//			g.fillOval(x - 4, y - 4, width + 8, height + 8);
//			g.setColor(Color.darkGray);
//			if(isMouseOn()){
//				g.setColor(Color.GRAY);
//			}
//			g.fillOval(x, y, width, height);
//			g.setColor(Color.WHITE);
//			Font font = new Font("Tahoma", Font.BOLD, 15);
//			DrawingUtility.drawStringInBox("CW", font, x, y, width, height, DrawingUtility.TEXT_CENTER, g);
			Graphics2D g2 = (Graphics2D) g;
			if(!isMouseOn())
				g2.drawImage(DrawingUtility.getClickableImg(DrawingUtility.cwButtonImg, DrawingUtility.STATE_NORMAL), null, x, y);
			else
				g2.drawImage(DrawingUtility.getClickableImg(DrawingUtility.cwButtonImg, DrawingUtility.STATE_HOVER), null, x, y);
		}
	}
	
	@Override
	public void onClickAction() {
		if(isVisible){
			board.flip(board.getFlipX(), board.getFlipY(), board.getFlipSize(), Board.CW, true);
			board.clearSelected();
		}
	}
	
	// Getters & Setters

	public boolean isVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		if(isVisible){
			Tile flipping = board.getTileAt(board.getFlipX(), board.getFlipY());
			int size = (board.getFlipSize() + 1) * board.getTileSize() + Config.tileGutter * (board.getFlipSize());
			x = flipping.getDrawX() + size + 5;
			y = flipping.getDrawY() + size / 2 - 25;
		}
		this.isVisible = isVisible;
	}
	
}