import java.awt.*;
import javax.swing.*;

public class ExGui
{
	private JFrame frame;
	private JButton b1, b2;

	public void go()
	{
		Container contentPane;

		frame = new JFrame("ExGui");
		contentPane = frame.getContentPane();
		b1 = new JButton("Press me.");
		b2 = new JButton("Don't press me.");

		contentPane.setLayout(new FlowLayout());
		contentPane.add(b1);
		contentPane.add(b2);

		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String args[])
	{
		ExGui that = new ExGui();
		that.go();
	}
}
