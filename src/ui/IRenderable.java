/**
 * JSpinner: 2110215 PROG METH PROJECT
 * @author Thanawit Prasongpongchai 5631045321
 * @author Phatrasek Jirabovonvisut 5630469621
 */

package ui;

import java.awt.Graphics;

public interface IRenderable {
	int getZ();
	void draw(Graphics g);
}
