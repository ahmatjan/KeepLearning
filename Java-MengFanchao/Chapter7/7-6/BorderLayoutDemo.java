import java.awt.*;
import javax.swing.*;

public class BorderLayoutDemo
{
	private JFrame frame;
	private JButton bn, bs, bw, be, bc;

	public void go()
	{
		frame = new JFrame("BorderLayoutDemo");
		Container contentPane = frame.getContentPane();
		
		bn = new JButton("North");
		bs = new JButton("South");
		bw = new JButton("West");
		be = new JButton("East");
		bc = new JButton("Center");

		contentPane.add(bn, BorderLayout.NORTH);
		contentPane.add(bs, BorderLayout.SOUTH);
		contentPane.add(bw, BorderLayout.WEST);
		contentPane.add(be, BorderLayout.EAST);
		contentPane.add(bc, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String args[])
	{
		BorderLayoutDemo that = new BorderLayoutDemo();
		that.go();
	}
}
