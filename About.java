import javax.swing.*;
import java.awt.*;

class About1 extends JFrame
{

	About1()
	{
		setBounds(100,100,700,550);
		setTitle("About Notepad");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		ImageIcon icon = new ImageIcon(getClass().getResource("notepad1.png")); 
		setIconImage(icon.getImage());

		JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource("notepad1.png")));
		iconLabel.setBounds(120,0,280,280);
		add(iconLabel);

		JLabel textLabel = new JLabel("<html>Welcome to the Notepad 1.0<br>This Notepad is created by Yash Jagdish Pahlani<br>Please Try this Notepad<br>Thankyou</html>");
		textLabel.setBounds(120,180,600,300);
		add(textLabel);

		Font f1 = new Font("Times New Roman",Font.BOLD+Font.ITALIC,25);
		textLabel.setFont(f1);
		

		

	}

		}

public class About
{
	public static void main(String args[])
	{

		About1 A = new About1();

	}

}