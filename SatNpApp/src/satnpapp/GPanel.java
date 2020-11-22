/*
 *  (C) 2002 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package satnpapp;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 * A utility JPanel with a GridBagLayout and a convenience addc method.
 *
 * @author Rickb
 */
public class GPanel extends JPanel {
    /**
     * Initialize this panel with a GridBagLayout.
     */
    public GPanel() {
	setLayout(new GridBagLayout());
    }

    /**
     * Add components to this panel using the given constraints.
     * For example, <BR>
     * addc(this, JComponent, 0,0, 1,1, 1.0,1.0,<BR>
     * &nbsp;&nbsp; GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
     * &nbsp;&nbsp; 5,5,5,5);
     * @param panel the Panel with a GridBagLayout owning the child component
     * @param c the child component 
     * @param gridX the row in which the child component is anchored
     * @param gridY the column in which the child component is anchored
     * @param gridWidth the rows spanned by the child component in the bag
     * @param gridHeight the cols spanned by the child component in the bag
     * @param weightx the amount of width scaling during panel expansion
     * @param weighty the amount of height scaling during panel expansion
     * @param anchor a GridBagConstraints anchor, e.g. NORTHWEST
     * @param fill a GridBagConstraints fill, e.g. HORIZONTAL
     * @param top padding added to the inset for the child
     * @param left padding added to the inset for the child
     * @param bottom padding added to the inset for the child
     * @param right padding added to the inset for the child
     */
    public void addc(Component c,
		     int gridX, int gridY,
		     int gridWidth, int gridHeight,
		     double weightx, double weighty,
		     int anchor, int fill,
		     int top, int left, int bottom, int right) {

	Insets insets = new Insets(top, left, bottom, right);

	GridBagConstraints cnstr = new GridBagConstraints(gridX,
							  gridY,
							  gridWidth,
							  gridHeight,
							  weightx,
							  weighty,
							  anchor,
							  fill,
							  insets,
							  0,
							  0);

	GridBagLayout l = (GridBagLayout) getLayout();
	l.setConstraints(c, cnstr);

	add(c);
    }
}
