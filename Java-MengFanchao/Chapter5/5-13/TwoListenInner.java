import java.awt.*; 
import java.awt.event.*;

public class TwoListenInner
{
	private Frame f;
	private TextField tf;

	static public void main(String args[])
	{
		TwoListenInner that = new TwoListenInner();

		that.go();
	}

	public void go()
	{
		f = new Frame("Two listeners example");
		f.add("North", new Label("click and drag the mouse"));
		tf = new TextField(30);
		f.add("South", tf);
		f.addMouseMotionListener(new MouseMotionHandler());
		f.addMouseListener(new MouseHandler());
		f.setSize(300, 200);
		f.setVisible(true);
	}		

	//MouseMotionHandler为一个内部类
	public class MouseMotionHandler extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			String s = "X = " + e.getX() + "Y = " + e.getY();
			tf.setText(s);
		}
	}

	//MouseHandler为另一个内部类
	public class MouseHandler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			String s = "The mouse entered";
			tf.setText(s);
		}

		public void mouseExited(MouseEvent e)
		{
			String s = "The mouse Exited";
			tf.setText(s);
		}
	}
}
