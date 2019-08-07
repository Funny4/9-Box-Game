import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



class Play implements ActionListener
{
	JFrame frame;
	JFrame game,I,A;
	JPanel gpanel;
	JPanel nameP,moveP, newP,Mm;
	JLabel nameL,moveL,Ins,Ins2,Ins3,Ins4,Au1,Au2,Au3,Au4,Au5,Au6;
	String name;
	JButton gButton[][]=new JButton[3][3],RNew,Exit,Exit2,MainMenu;
	JButton NewGame,Instructions,AboutUs;
	Game g;
	int moves=1;
	Play() 
	{
		g=new Game();
		frame =new JFrame("9-Box Puzzle");
		frame.setSize(2000, 2000);
		gpanel=new JPanel();
		nameP=new JPanel();
		moveP=new JPanel();
		newP=new JPanel();
		Mm=new JPanel();
	
		Au1=new JLabel();
		Au2=new JLabel();
		Au3=new JLabel();
		Au4=new JLabel();
		Au5=new JLabel();
		Au6=new JLabel();
		frame.setBackground(new Color(255,100,100));
		frame.setLayout(null);
	
		game =new JFrame("9-Box Puzzle");
		game.setSize(2000, 2000);
		game.setBackground(Color.black);
		game.setLayout(null);
		nameL=new JLabel("Player's Name : ");
		moveL=new JLabel("Moves : ");
		I=new JFrame("Instructions");
		A= new JFrame("About Us");
		I.setSize(2000, 2000);
		A.setSize(2000, 2000);
		I.setBackground(Color.black);
		A.setBackground(Color.black);
		Exit=new JButton("Exit");
		Exit2=new JButton("Exit");
		MainMenu=new JButton("Main Menu");
		Ins=new JLabel();
		Ins2=new JLabel();
		Ins3=new JLabel();
		Ins4=new JLabel();


		I.setLayout(null);
		A.setLayout(null);
		
		String inst=" Welcome to 9-Box Puzzle Game. It is a sliding puzzle which consists of 3x3 grid of numbered squares with one square missing. The squares are jumbled when the puzzle start and the goal of this game is ";
		String inst2=" to unjumble the squares by only sliding a square into the empty space.";
		String inst3="RULES To move:  If there is an empty adjacent square next to a tile, a tile may be slid into the empty location.";
		String inst4="To win:  The tiles must be moved back into their original positions, numbered 1 through 8.";
		Ins.setBounds(40, 10, 1200, 200);
		Ins.setText(inst);
		Ins2.setBounds(40, 30, 1200, 200);
		Ins2.setText(inst2);
		Ins3.setBounds(40, 110, 1200, 200);
		Ins3.setText(inst3);
		Ins4.setBounds(40, 180, 1200, 200);
		Ins4.setText(inst4);
		
		String a="Developed by : ",b="(i) Neeraj Mishra",c="(ii) Rahul Chanderiya";
		String d="(iii) Anupam Prakash",e="(iv) Ankit Gupta",f="(v) Abhishek";
		
		Au1.setBounds(50, 10, 1000, 200);
		Au2.setBounds(40, 110, 1000, 200);
		Au3.setBounds(40, 130, 1000, 200);
		Au4.setBounds(40, 150, 1000, 200);
		Au5.setBounds(40, 170, 1000, 200);
		Au6.setBounds(40, 190, 1000, 200);
		
		Au1.setText(a);
		Au2.setText(b);
		Au3.setText(c);
		Au4.setText(d);
		Au5.setText(e);
		Au6.setText(f);
		
		
	
		NewGame= new JButton("New Game");
		NewGame.setBounds(550, 100, 100, 50);
		NewGame.setBackground(Color.darkGray);
		NewGame.setForeground(Color.WHITE);
	
		Instructions=new JButton("Instructions");
		Instructions.setBounds(530, 200, 150, 50);
		Instructions.setBackground(Color.darkGray);
		Instructions.setForeground(Color.WHITE);
	
		AboutUs=new JButton("About Us");
		AboutUs.setBounds(550, 300, 100, 50);
		AboutUs.setBackground(Color.darkGray);
		AboutUs.setForeground(Color.WHITE);
		NewGame.addActionListener(this);
		
		RNew= new JButton("Retry");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gButton[i][j] = new JButton("  ");
				Font f2 = new Font("Diag", Font.BOLD, 40);
				gButton[i][j].setFont(f2);
				gButton[i][j].setForeground(Color.DARK_GRAY);
			}
		}
		g.rand();
		gpanel.setLayout(new GridLayout(3,3,4,4));
		gpanel.setBounds(390, 100, 500, 500);
		nameP.setBounds(40,150,200,20);
		moveP.setBounds(40,250,200,200);
		newP.setBounds(990, 150, 200, 50);
		Mm.setBounds(990,250,200,50);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
			gpanel.add(gButton[i][j]);
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gButton[i][j].addActionListener(this);
			}
		}
		
		Exit.setBounds(550, 500, 150, 60);
		Exit.setBackground(Color.black);
		Exit.setForeground(Color.white);
		Exit2.setBounds(550, 500, 150, 60);
		Exit2.setBackground(Color.black);
		Exit2.setForeground(Color.white);
		
		
		RNew.addActionListener(this);
		MainMenu.addActionListener(this);
		Instructions.addActionListener(this);
		AboutUs.addActionListener(this);
		Exit.addActionListener(this);
		Exit2.addActionListener(this);
		nameP.add(nameL);
		moveP.add(moveL);
		newP.add(RNew);
		Mm.add(MainMenu);
		I.add(Ins);
		I.add(Ins2);
		I.add(Ins3);
		I.add(Ins4);
		
		A.add(Au1);
		A.add(Au2);
		A.add(Au3);
		A.add(Au4);
		A.add(Au5);
		A.add(Au6);

		game.add(gpanel);
		game.add(nameP);
		game.add(moveP);
		game.add(newP);
		game.add(Mm);
		frame.add(NewGame);
		frame.add(Instructions);
		frame.add(AboutUs);
		I.add(Exit);
		A.add(Exit2);

		frame.setVisible(true);
		frame.addWindowListener(new myWindowAdapter());
		game.addWindowListener(new myWindowAdapter());
		I.addWindowListener(new myWindowAdapter());
		A.addWindowListener(new myWindowAdapter());
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		game.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		I.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		A.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent ae) {
	String c=ae.getActionCommand();
	if(c.equals("New Game")==true)
	{
		
		
		name = JOptionPane.showInputDialog(new JFrame(), "Enter your name: ", "9 Box-Puzzle", JOptionPane.QUESTION_MESSAGE);
		
		
		if(name==null)
		{
			
			return;
		}
		if(name.equals("")==true)
			name="Anonymous";
		String s=nameL.getText();
		s=s+" "+name;
		nameL.setText(s);
		frame.setVisible(false);
		game.setVisible(true);
	}
	
	if(ae.getSource()==Instructions)
	{
		frame.setVisible(false);
		I.setVisible(true);
	}
	if(ae.getSource()==Exit)
	{
		frame.setVisible(true);
		I.setVisible(false);
	}
	if(ae.getSource()==AboutUs)
	{
		frame.setVisible(false);
		A.setVisible(true);
	}
	if(ae.getSource()==Exit2)
	{
		frame.setVisible(true);
		A.setVisible(false);
	}
	
	if(ae.getSource()==MainMenu)
	{
		
		nameL.setText("Name : ");
		game.setVisible(false);
		frame.setVisible(true);
	}
	
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (ae.getSource() == gButton[i][j]) {
				String str2 = new String("Moves: ");

				if (moves > 0) {
					str2 = str2 + moves;
					moveL.setText(str2);

				}
				
				g.find(i, j);
				g.setcol();
				
			}
		}
		
		
		if(ae.getSource()==RNew)
		{
			g.replay();
		}
	}
	g.checkwin();
	}

	class myWindowAdapter extends WindowAdapter {
		
		public void windowClosing(WindowEvent e) {
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "9 Box-Puzzle", JOptionPane.YES_NO_OPTION);


			
			if (confirmed==0) {
				System.exit(0);
			}
			
		}

	}
	class Game
	{
		private int box[][];
		Game()
		{
			box=new int[3][3];
			int k=1;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					box[i][j]=k;
					k++;
				}
			}
				
		
		}
		void replay() {
			moves = 1;
			rand();
			setcol();
			box[2][2] = 9;
			gButton[2][2].setText(" ");
			moveL.setText("Moves:     ");
		}
		
		int checkwin() {
			int i, j, k = 1;
			int chk = 0;
			for (i = 0; i <= 2; i++) {
				for (j = 0; j <= 2; j++) {
					if (k == box[i][j]) {
						chk++;
					}
					k++;
				}
			}
			if (chk == 9) {
				JOptionPane.showMessageDialog( frame,"You Win !!!!!!!!!  Moves : "+moves,"9 Box-Puzzle", JOptionPane.PLAIN_MESSAGE);
				frame.setVisible(true);
				game.setVisible(false);

			}
			return 0;
		}


		int find(int i, int j) {
			int p, q, temp;
			String st1 = new String(" ");
			p = i;
			q = j;
			int st=0;
			if (p - 1 >= 0) {
				p--;
				if (box[p][q] == 9) {
					st1 = st1 + box[i][j];
					gButton[p][q].setText(st1);
					gButton[i][j].setText(" ");
					box[p][q] = box[i][j];
					box[i][j] = 9;
					moves++;
					st=1;
					return 0;
				}
			}
			p = i;
			q = j;
			if (p + 1 <= 2) {
				p++;
				if (box[p][q] == 9) {
					st1 = st1 + box[i][j];
					gButton[p][q].setText(st1);
					gButton[i][j].setText(" ");
					box[p][q] = box[i][j];
					box[i][j] = 9;
					moves++;
					st=1;
					return 0;
				}
			}
			p = i;
			q = j;
			if (q - 1 >= 0) {
				q--;
				if (box[p][q] == 9) {
					st1 = st1 + box[i][j];
					gButton[p][q].setText(st1);
					gButton[i][j].setText(" ");
					moves++;
					box[p][q] = box[i][j];
					box[i][j] = 9;
					st=1;
					return 0;
				}
			}
			p = i;
			q = j;
			if (q + 1 <= 2) {
				q++;
				if (box[p][q] == 9) {
					st1 = st1 + box[i][j];
					gButton[p][q].setText(st1);
					gButton[i][j].setText(" ");
					moves++;
					box[p][q] = box[i][j];
					box[i][j] = 9;
					st=1;
					return 0;
				}
			}
			if(st==0)
			{
				JOptionPane.showMessageDialog( frame,"Invalid Move","9 Box-Puzzle", JOptionPane.PLAIN_MESSAGE);
				
				setcol();
			}
			return 0;
		}
		void setcol() {
			for (int ii = 0; ii < 3; ii++) {
				for (int jj = 0; jj < 3; jj++) {
					Color randomColor = new Color(0, 153, 153);
					//    Color randomColor = new Color(65,105,225);
					gButton[ii][jj].setBackground(randomColor);
					if(box[ii][jj]==9)
					{
						gButton[ii][jj].setBackground(new Color(173, 216, 230));
					}

				}
			}
		}
		void rand() {
			int arr[] = new int[8];
			int k = 0, flag = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					flag = 0;
					int x = (int)(Math.random() * 8);
					x = x + 1;
					if (k == 0) {
						String str = new String(" ");
						str = str + x;
						gButton[i][j].setText(str);
						box[0][0] = x;
						arr[k] = x;
						k++;
					} else if (k <= 7) {

						while (flag == 0) {
							int chk = 0;
							for (int a = 0; a < k; a++) {
								if (arr[a] != x) {
									chk++;
								} else a = 10;
							}
							if (k == chk) {
								String str = new String(" ");
								str = str + x;
								gButton[i][j].setText(str);
								arr[k] = x;
								box[i][j] = x;
								k++;
								flag = 1;
							} else {
								x = (int)(Math.random() * 8);
								x = x + 1;
							}
						}
					}
					box[2][2] = 9;
				}
			}
			setcol();
		
/*			 
			 //***  WIN IN ONE MOVE !!!! UNCOMMENT THIS ! (BY ANUPAM PRAKASH)***
			 
			  int kk=1;
			 
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					box[i][j]=kk;
					
					String str = new String(" ");
					str = str + kk;
					gButton[i][j].setText(str);
					kk++;
				}
			}
			box[2][1]=9;
			box[2][2]=8;
			gButton[2][1].setText(" ");
			gButton[2][2].setText("8");
			
			setcol();
*/
		}
	}
		
	
	

	
		public static void main(String args[]) {
			// Create the frame on the event dispatching thread.
			
		Play p=new Play();
			
	}
}
