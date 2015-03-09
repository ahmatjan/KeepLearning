import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo
{
	JFrame frame;
	Container contentPane;
	JPanel pv, ph;

	public void go()
	{
		frame = new JFrame();
		contentPane = frame.getContentPane();

		pv = new JPanel();
		pv.setLayout(new BoxLayout(pv, BoxLayout.Y_AXIS));
	//	以上两句可以改为
	//	pv = Box.createVerticalBox();
		pv.add(new JLabel("Monday."));
		pv.add(new JLabel("Tuseday."));
		pv.add(new JLabel("Wednesday."));
		pv.add(new JLabel("Thurseday."));
		pv.add(new JLabel("Friday."));
		pv.add(new JLabel("Saturday."));
		pv.add(new JLabel("Sunday."));
		contentPane.add(pv, BorderLayout.CENTER);

		ph = new JPanel();
		ph.setLayout(new BoxLayout(ph, BoxLayout.X_AXIS));
	//	以上两句可改为
	//	ph = Box.createHorizontalBox();
		ph.add(new JButton("Yes"));
		ph.add(new JButton("No"));
		ph.add(new JButton("Cancel"));
		contentPane.add(ph, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String args[])
	{
		BoxLayoutDemo that = new BoxLayoutDemo();
		that.go();
	}
}
