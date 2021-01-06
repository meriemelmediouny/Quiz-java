package sadi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[4];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 4; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 20, 450, 60);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 100, 450, 40);
		radioButton[1].setBounds(50, 150, 200, 40);
		radioButton[2].setBounds(50, 200, 200, 40);
		
		btnNext.setBounds(100, 280, 100, 30);
		btnBookmark.setBounds(270, 280, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 400);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 4) {
				if(count<3) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
				 if(count<3){
						final ImageIcon icon = new ImageIcon("lose.gif");
	                 Object invisibleChar = null;
			
					JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
					
			}else if(count>3) {
				final ImageIcon icon = new ImageIcon("source.gif");
                Object invisibleChar = null;
		
				JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
			}
				}
			} 
			if (current == 9) {
				if(count<6) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
				 if(count<3){
						final ImageIcon icon = new ImageIcon("lose.gif");
	                 Object invisibleChar = null;
			
					JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
					
			}else if(count>3) {
				final ImageIcon icon = new ImageIcon("source.gif");
             Object invisibleChar = null;
		
				JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
			}
				}
			}
			
			if (current == 14) {
				
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
				 if(count<3){
						final ImageIcon icon = new ImageIcon("lose.gif");
	                 Object invisibleChar = null;
			
					JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
					
			}else if(count>3) {
				final ImageIcon icon = new ImageIcon("source.gif");
             Object invisibleChar = null;
		
				JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
			}
				}
			}
			 
			
		
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 14)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
		}
	

	// SET Questions with options
	void set() {
		radioButton[3].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  JAVA est un langage?");
			radioButton[0].setText("Compilé");
			radioButton[1].setText("Interprété");
			radioButton[2].setText("Compilé et interpreté");
			
		}
		if (current == 1) {
			label.setText("Que2:  Toutes les classes héritent de la classe?");
			radioButton[0].setText("Main");
			radioButton[1].setText("Object");
			radioButton[2].setText("AWT");
			
		}
		if (current == 2) {
			label.setText("Que3: Par convention une classe");
			radioButton[0].setText("est en minuscule");
			radioButton[1].setText("commence par une majuscule");
			radioButton[2].setText("est en majuscules");
		
		}
		if (current == 3) {
			label.setText("Que4: Est-ce que on peut avoir plusieurs constructeurs pour la même classe?");
			radioButton[0].setText("oui");
			radioButton[1].setText("non");
			radioButton[2].setText("Je sais pas");
			
		}
		if (current == 4) {
			label.setText("Que5:  Dans la ligne \"public class A implements B, B est :?");
			radioButton[0].setText(" Interfacce ");
			radioButton[1].setText("Classe parent");
			radioButton[2].setText("Package");
			
		}
		if (current == 5) {
			label.setText("<html> Que6: Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode Quelle est l’extension du programme en bytecode ?</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("JAVA");
			radioButton[2].setText("Class");
			
		}
		if (current == 6) {
			label.setText("<html> Que7:  Class Test{Public Test () {public Test (int i) {This();System.out.println(”Nous sommes en ”+i+ ” !”);};}qu’affichera l’instruction suivante?Test t1=new Test (2018);?</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("Bonjour Nous sommes en 2018 !");
			radioButton[2].setText("Nous sommes en 2018 !");
		
		}
		if (current == 7) {
			label.setText("<html>Que8:  Voici un constructeur de la classe Employee, y-at'il un problème ?Public void Employe(String n){\r\n"
					+ "Nom=n;}?</html>");
			radioButton[0].setText("vrai");
			radioButton[1].setText("faux");
			radioButton[2].setText("je ne sais pas");
		
		}
		if (current == 8) {
			label.setText("<html> Que9: Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration,on la déclare comme une constante avec le mot réservé</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("final");
			radioButton[2].setText("const");
		
		}
		if (current == 9) {
			label.setText("<html>Que10: Dans une classe, on accède à ses variables grâce au mot clé?</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("This");
			radioButton[2].setText("Super");
		
		}
		if (current == 10) {
			label.setText("<html>Que6: calculerSalaire(int)\r\n"
					+ "calculerSalaire(int, double)\r\n"
					+ "La méthode calculerSalaire est :</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("surchargée");
			radioButton[2].setText("redéfinie");
			
		}
		if (current == 11) {
			label.setText("<html>Que11:  Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite Test t1=new Test (2018);?</html>");
			radioButton[0].setText("Vrai");
			radioButton[1].setText("Faux");
			radioButton[2].setText("je ne sais pas");
		
		}
		if (current == 12) {
			label.setText("<html>Que12:  Est-ce qu’une classe peut implémenter plusieurs interfaces ?</html>");
			radioButton[0].setText("vrai");
			radioButton[1].setText("faux");
			radioButton[2].setText("je ne sais pas");
		
		}
		if (current == 13) {
			label.setText("<html>Que13: La déclaration d'une méthode suivante :public void traitement() throws IOException précise que la méthode propage une exception contrôlée</html>");
			radioButton[0].setText("Vrai");
			radioButton[1].setText("faux");
			radioButton[2].setText("je ne sais pas");
		
		}
		if (current == 14) {
			label.setText("<html>Que14: class Test{\r\n"
					+ "public static void main (String[] args) {\r\n"
					+ "try {\r\n"
					+ "int a =10;\r\n"
					+ "System.out.println (\"a = \" + a );\r\n"
					+ "int b = 0 / a;\r\n"
					+ "System.out.println (\"b = \" + b);\r\n"
					+ "}\r\n"
					+ "catch(ArithmeticException e)\r\n"
					+ "{System.out.println (\"diviser par 0!\"); }\r\n"
					+ "finally\r\n"
					+ "{System.out.println (\"je suis à l’intérieur de\r\n"
					+ "finally\");}}}</html>");
			radioButton[0].setText("aucun des choix");
			radioButton[1].setText("<html>a=10,b=0 Je suis à l’intérieur de finally</html>");
			radioButton[2].setText("<html>a=10,b=0 diviser par 0! je suis à l’intérieur de finally</html>");
		
		}
		
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		if (current == 10)
			return (radioButton[0].isSelected());
		if (current == 11)
			return (radioButton[1].isSelected());
		if (current == 12)
			return (radioButton[2].isSelected());
		if (current == 13)
			return (radioButton[0].isSelected());
		if (current == 14)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}