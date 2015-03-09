import java.awt.*;
import javax.swing.*;

public class JFrameDemo2
{
	static public void main(String args[])
	{
		JFrame frame = new JFrame("JFrameDemo2");
		JButton button = new JButton("Press me.");
		JPanel contentPane = new JPanel();

		contentPane.setLayout(new BorderLayout());
		contentPane.add(button, BorderLayout.CENTER);
	
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);

	}
}
