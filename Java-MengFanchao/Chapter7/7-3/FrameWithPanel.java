import java.awt.*;
import javax.swing.*;

public class FrameWithPanel
{
	static public void main(String args[])
	{
		JFrame frame = new JFrame("Frame with Panel");
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		JButton button = new JButton("Press me.");

		contentPane.setBackground(Color.CYAN);
		panel.setBackground(Color.yellow);
		panel.add(button);
		contentPane.add(panel, BorderLayout.SOUTH);

		frame.setSize(300, 200);
		frame.setVisible(true);

	}
}
