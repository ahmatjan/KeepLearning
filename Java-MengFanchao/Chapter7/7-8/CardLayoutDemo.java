import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo extends MouseAdapter
{
	JFrame frame;
	Container contentPane;
	CardLayout myCard;
	JPanel p1, p2, p3, p4;
	JLabel l1, l2, l3, l4;

	public void go()
	{
		frame = new JFrame();
		contentPane = frame.getContentPane();
		myCard = new CardLayout();
		contentPane.setLayout(myCard);

		p1 = new JPanel();
		p1.setBackground(Color.yellow);
		l1 = new JLabel("first");
		p1.add(l1);

		p2 = new JPanel();
		p2.setBackground(Color.green);
		l2 = new JLabel("second");
		p2.add(l2);

		p3 = new JPanel();
		p3.setBackground(Color.red);
		l3 = new JLabel("third");
		p3.add(l3);

		p4 = new JPanel();
		p4.setBackground(Color.white);
		l4 = new JLabel("fourth");
		p4.add(l4);

		p1.addMouseListener(this);
		p2.addMouseListener(this);
		p3.addMouseListener(this);
		p4.addMouseListener(this);

		contentPane.add(p1, "first");
		contentPane.add(p2, "second");
		contentPane.add(p3, "third");
		contentPane.add(p4, "fourth");

		myCard.show(contentPane, "first");
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	public void mouseClicked(MouseEvent e)
	{
		myCard.next(contentPane);
	}

	static public void main(String args[])
	{
		CardLayoutDemo that = new CardLayoutDemo();
		that.go();
	}
}
