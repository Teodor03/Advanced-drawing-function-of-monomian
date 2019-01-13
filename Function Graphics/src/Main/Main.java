package Main;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.border.LineBorder;

import monomial.Monomial;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Main extends JFrame {

	public static JPanel contentPane;
	public static JPanel pnlfunction;
	public static Graphics2D g;
	private JTextField txtkoef;
	private JLabel lblx;
	private JTextField textdegree;
	private JButton btnAddAnotherMonomial;
	int x = 200;
	ArrayList <Monomial> Monomial_Collection = new ArrayList<Monomial>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		pnlfunction = new JPanel();
		pnlfunction.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlfunction.setBackground(Color.WHITE);
		pnlfunction.setBounds(10, 10, 601, 601);
		contentPane.add(pnlfunction);

		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g = (Graphics2D) pnlfunction.getGraphics();
				g.clearRect(0, 0, 600, 600);
				g.setColor(Color.BLACK);
				g.setStroke(new BasicStroke(3));
				g.drawLine(0, 300, 600, 300);
				g.drawLine(300, 0, 300, 600);
				g.setStroke(new BasicStroke(1));
				for (int xlines = 0; xlines < 61; xlines++) {
					g.drawLine(xlines * 10, 0, xlines * 10, 600);
				}
				for (int ylines = 0; ylines < 61; ylines++) {
					g.drawLine(0, ylines * 10, 600, ylines * 10);
				}
                System.out.println(Monomial_Collection.size());				
                for(int i=0;i<Monomial_Collection.size();i++) {
                System.out.println();
                System.out.print(Monomial_Collection.get(i).Get_txtkoef()+"*x^");
                System.out.print(Monomial_Collection.get(i).Get_txtdegree());                
                }
				
				
			}
		});
		btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDraw.setBounds(620, 11, 104, 40);
		contentPane.add(btnDraw);

		JLabel lbly = new JLabel("y =");
		lbly.setHorizontalAlignment(SwingConstants.CENTER);
		lbly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbly.setBounds(10, 640, 60, 40);
		contentPane.add(lbly);

		txtkoef = new JTextField();
		txtkoef.setBounds(70, 650, 40, 20);
		contentPane.add(txtkoef);
		txtkoef.setColumns(10);

		lblx = new JLabel("*x^");
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblx.setBounds(110, 650, 50, 25);
		contentPane.add(lblx);

		textdegree = new JTextField();
		textdegree.setColumns(10);
		textdegree.setBounds(160, 650, 40, 20);
		contentPane.add(textdegree);

		btnAddAnotherMonomial = new JButton("Add another Monomial");
		btnAddAnotherMonomial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Monomial mon = new Monomial(x);
				Monomial_Collection.add(mon);
				x += 170;
				revalidate();
				repaint();
			}
		});
		btnAddAnotherMonomial.setBounds(10, 677, 150, 23);
		contentPane.add(btnAddAnotherMonomial);
	}
}