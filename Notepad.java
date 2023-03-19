
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.logging.*;
//import java.util.logging.Level;



class Notepad1 extends JFrame
{

	//Menu Things

	JMenuBar menu = new JMenuBar();
	JMenu jfile = new JMenu("File   ");
	JMenu jedit = new JMenu("Edit   ");
	JMenu jhelp = new JMenu("Help  ");

	JMenuItem newf = new JMenuItem("New");
	JMenuItem openf = new JMenuItem("Open");
	JMenuItem savef= new JMenuItem("Save");
	JMenuItem print= new JMenuItem("Print");
	JMenuItem exit = new JMenuItem("Exit");

	JMenuItem cut = new JMenuItem("Cut");
	JMenuItem copy = new JMenuItem("Copy");
	JMenuItem paste= new JMenuItem("Paste");
	JMenuItem selectall = new JMenuItem("Select All");

	JMenuItem about = new JMenuItem("About");

//TextArea

	JTextArea txtArea = new JTextArea();

//Constructor


	Notepad1()
	{
		Font f = new Font("Monospaced",Font.BOLD,25);
		jfile.setFont(f);
		jedit.setFont(f);
		jhelp.setFont(f);
		newf.setFont(f);
		openf.setFont(f);
		savef.setFont(f);
		print.setFont(f);
		exit.setFont(f);
		cut.setFont(f);
		copy.setFont(f);
		paste.setFont(f);
		selectall.setFont(f);
		about.setFont(f);


		setJMenuBar(menu);

	//Add	
	
		menu.add(jfile);
		menu.add(jedit);
		menu.add(jhelp);

		jfile.add(newf);
		jfile.add(openf);
		jfile.add(savef);
		jfile.add(print);
		jfile.add(exit);

		jedit.add(cut);
		jedit.add(copy);
		jedit.add(paste);
		jedit.add(selectall);
		jhelp.add(about);

		
	//text area scroll

		JScrollPane scrollpane = new JScrollPane(txtArea);
		add(scrollpane);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		//scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//font for text area

		Font f2 = new Font("Sans Serif",Font.PLAIN,25);
		txtArea.setFont(f2);


//Shortcuts
		newf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		openf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		savef.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));


		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));

		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_DOWN_MASK));



	
//Action Listeners


		ActionListener a1 = (ae)->
		{
		if(ae.getActionCommand().equalsIgnoreCase("New"))
			txtArea.setText("");
		};
		newf.addActionListener(a1);





		ActionListener a2 = (ae)->
		{
			JFileChooser filechooser = new JFileChooser("C:/Users/Yash Pahlani/Documents");
			FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textFilter);		
			int action=filechooser.showOpenDialog(null);

			if(action != JFileChooser.APPROVE_OPTION)
				return;
			else
			{
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(filechooser.getSelectedFile()));
					txtArea.read(reader,null);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}

			}

		};
		openf.addActionListener(a2);





		ActionListener a3 = (ae)->
		{
			JFileChooser filechooser = new JFileChooser("C:/Users/Yash Pahlani/Documents");
			FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			filechooser.setAcceptAllFileFilterUsed(false);
			filechooser.addChoosableFileFilter(textFilter);
			int action=filechooser.showSaveDialog(null);
			if(action != JFileChooser.APPROVE_OPTION)
				return;
			else
			{
				String filename = filechooser.getSelectedFile().getAbsolutePath().toString();
				if(!filename.contains(".txt"))
					filename=filename+".txt";

				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
					txtArea.write(writer);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			
		};
		savef.addActionListener(a3);




		ActionListener a4 = (ae)->
		{
			try
			{
				txtArea.print();
			}

			catch(Exception e)
			{
				Logger.getLogger(Notepad1.class.getName()).log(Level.SEVERE,null,e);
			}
		};
		print.addActionListener(a4);



		ActionListener a5 = (ae)->
		{
			txtArea.cut();
		};
		cut.addActionListener(a5);


		ActionListener a6 = (ae)->
		{
			txtArea.copy();

		};
		copy.addActionListener(a6);

		ActionListener a7 = (ae)->
		{
			txtArea.paste();
		};
		paste.addActionListener(a7);

		ActionListener a8 = (ae)->
		{
			txtArea.selectAll();

		};
		selectall.addActionListener(a8);


		ActionListener a9 = (ae)->
		{
			About1 A = new About1();

		};
		about.addActionListener(a9);


		ActionListener a10 = (ae)->
		{
			System.exit(0);

		};
		exit.addActionListener(a10);









		setTitle("Notepad");
		setSize(900,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		ImageIcon icon = new ImageIcon(getClass().getResource("notepad1.png")); 
		setIconImage(icon.getImage());
	




		
		
}

}
class Notepad
{
	public static void main(String args[]) throws Exception
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Notepad1 n1= new Notepad1();
		
		
		
	}


}
                                                                                                                                                                                                                                                                                                                                                   