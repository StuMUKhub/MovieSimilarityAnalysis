package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import attributes_OMDB.Metric;
import system.Discover_Metrics;
import system.ParseJSON;
import system.URL_Call;

public class Main_Search implements WindowListener, ActionListener {

	private JFrame frame;
	private JComboBox<String> metricBox;
	private JComboBox<String> outputBox;
	private JTextField addMetricsTF;
	private JTextArea displayMericsTA;

	private int counter = 0;
	private ArrayList<String> selectedMetric_Disc= new ArrayList<String>();
	private ArrayList<String> userIN_Metric_Disc= new ArrayList<String>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main_Search window = new Main_Search();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/* The Main Frame */
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/* The Title */ 
		JLabel title = new JLabel("Movie Similarity Analysis");
		title.setFont(new Font("Calibri", Font.PLAIN, 20));
		title.setBounds(400, 15, 500, 20);
		frame.getContentPane().add(title, BorderLayout.CENTER);

		/* Metric Label */
		JLabel metricLabel = new JLabel("Metric -");
		metricLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		metricLabel.setBounds(145, 100, 100, 20);
		frame.getContentPane().add(metricLabel, BorderLayout.CENTER);

		/* Search Terms Label */
		JLabel searchTermsLabel = new JLabel("Search Terms -");
		searchTermsLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		searchTermsLabel.setBounds(100, 185, 100, 20);
		frame.getContentPane().add(searchTermsLabel, BorderLayout.CENTER);
		
		/* Output Label */
		JLabel outputLabel = new JLabel("Suggested -");
		outputLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		outputLabel.setBounds(120, 305, 100, 20);
		frame.getContentPane().add(outputLabel, BorderLayout.CENTER);
		
		/* Metrics ComboBox */
		metricBox = new JComboBox<String>();
		metricBox.setFont(new Font("Calibri", Font.PLAIN, 14));
		metricBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Actor/Actress", "Budget",  "Genre", 
				"Production Company", "Production Country", "Release Date", "Release Status", "Revenue", "Runtime (Mins)", 
				"Spoken Languages", "Title", "Vote Average", "Vote Count" }));
		metricBox.setBounds(200, 100, 160, 20);
		metricBox.setToolTipText("Choose a Metric to add to the search...");
		frame.getContentPane().add(metricBox);
		
		/* Output ComboBox */
		outputBox = new JComboBox<String>();
		outputBox.setFont(new Font("Calibri", Font.PLAIN, 14));
		outputBox.setModel(new DefaultComboBoxModel<String>());
		outputBox.setBounds(200, 300, 300, 30);
		frame.getContentPane().add(outputBox);
		
		/* Add Metric TextField */
		addMetricsTF = new JTextField();
		addMetricsTF.setFont(new Font("Calibri", Font.PLAIN, 14));
		addMetricsTF.setBounds(400, 100, 500, 20);
		frame.getContentPane().add(addMetricsTF);

		/* Display Chosen Metrics Text Area */ 
		displayMericsTA = new JTextArea();
		displayMericsTA.setEditable(false);
		displayMericsTA.setBounds(200, 150, 500, 100);
		frame.getContentPane().add(displayMericsTA);
				
		/* Search / Cancel Buttons */
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 200, 100);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(100, 100, 100, 50);
		Button search = new Button("Search");
		Button cancel = new Button("Cancel");
		search.setFont(new Font("Calibri", Font.PLAIN, 14));
		cancel.setFont(new Font("Calibri", Font.PLAIN, 14));
		buttonPanel.add(search);
		buttonPanel.add(cancel);
		panel.add(buttonPanel, BorderLayout.CENTER);
		panel.setLocation(400, 40);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		/* Search Button Action Listener */
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//https://api.themoviedb.org/3/discover/movie?api_key=64c44e78b515a793ad651ddfdf7ab4af&with_cast=3894
				Discover_Metrics dm = new Discover_Metrics();
				String urlReceived = dm.discoverString(selectedMetric_Disc, userIN_Metric_Disc);
				ParseJSON pj = new ParseJSON();
				URL_Call callURL = new URL_Call();
				String stringReveived = callURL.requestURL(urlReceived);
				pj.parseDiscoverList(stringReveived, urlReceived);
			}
		});	
		
		/* Cancel Button Action Listener */
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayMericsTA.setText("");
				selectedMetric_Disc.clear();
				userIN_Metric_Disc.clear();
			}
		});	
		
		/* Add Metric Button */
		Button addMetric = new Button("Add");
		addMetric.setFont(new Font("Calibri", Font.PLAIN, 14));
		addMetric.setBounds(30, 15, 40, 20);
		addMetric.setLocation(905, 100);
		frame.getContentPane().add(addMetric, BorderLayout.CENTER);

		/* Add Metric Button Action Listener */
		addMetric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedMetric = (String) metricBox.getSelectedItem();
				String userText = addMetricsTF.getText();
				displayMericsTA.append(selectedMetric + ": " + userText + "\n");
				
				selectedMetric_Disc.add(selectedMetric);
				userIN_Metric_Disc.add(userText);
				
//				System.out.println(selectedMetric_Disc.get(counter));
//				System.out.println(userIN_Metric_Disc.get(counter));
//				counter++;
			}
		});	
		
		/* More Info Button */
		Button seeMore = new Button("More Info");
		seeMore.setFont(new Font("Calibri", Font.PLAIN, 14));
		seeMore.setBounds(506, 310, 70, 20);
		seeMore.setLocation(510, 305);
		frame.getContentPane().add(seeMore, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void windowActivated(WindowEvent arg0) {

	}

	public void windowClosed(WindowEvent arg0) {

	}

	public void windowClosing(WindowEvent arg0) {

	}

	public void windowDeactivated(WindowEvent arg0) {

	}

	public void windowDeiconified(WindowEvent arg0) {

	}

	public void windowIconified(WindowEvent arg0) {

	}

	public void windowOpened(WindowEvent arg0) {

	}

}
