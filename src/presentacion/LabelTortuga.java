package presentacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelTortuga extends JLabel{

	private double angulo;

	public LabelTortuga(ImageIcon imageIcon) {
		super(imageIcon);
		this.angulo = 0;

	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		AffineTransform at = g2.getTransform();
		Shape forma = g2.getClip();
		double x = this.getWidth()/ 2.0;
		double y = this.getHeight()/ 2.0;
		at.rotate(Math.toRadians(90.0) - angulo, x, y);
		g2.setTransform(at);
		g2.setClip(forma);
		super.paintComponent(g);

	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

}
