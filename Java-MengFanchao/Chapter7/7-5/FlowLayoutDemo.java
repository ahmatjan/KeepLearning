import java.awt.*;
import javax.swing.*;

public class FlowLayoutDemo
{
	private JFrame frame;
	private JButton b1, b2, b3;

	public void go()
	{
		frame = new JFrame();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());

		b1 = new JButton("First");
		b2 = new JButton("Second");
		b3 = new JButton("Third");

		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);

		frame.pack();
		frame.setVisible(true);

	}


	static public void main(String args[])
	{
		FlowLayoutDemo that = new FlowLayoutDemo();
		that.go();
	}
}
