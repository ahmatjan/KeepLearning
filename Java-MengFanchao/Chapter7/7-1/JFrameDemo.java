import java.awt.*;
import javax.swing.*;

public class JFrameDemo
{
	static public void main(String args[])
	{
		JFrame frame = new JFrame("JFrameDemo");
		JButton button = new JButton("Press me.");

		Container contentPane = frame.getContentPane();
		contentPane.add(button, BorderLayout.CENTER);
		//以上两句可替换为
	//	frame.getContentPane().add(button, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
}
