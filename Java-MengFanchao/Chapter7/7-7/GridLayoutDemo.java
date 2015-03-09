import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo
{
	JFrame frame;
	Container contentPane;
	JButton b1, b2, b3, b4, b5, b6;

	public void go()
	{
		frame = new JFrame();
		contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(3, 2));

		b1 = new JButton("grid_1");
		b2 = new JButton("grid_2");
		b3 = new JButton("grid_3");
		b4 = new JButton("grid_4");
		b5 = new JButton("grid_5");
		b6 = new JButton("grid_6");

		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(b5);
		contentPane.add(b6);

		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String args[])
	{
		GridLayoutDemo that = new GridLayoutDemo();
		that.go();
	}
}
