//Pantalla generada por David
package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JEditorPane;

public class Lector {

	private JFrame frmLector;
	private JTextField textField;
	private JTextField txtGanas;
	private JLabel lblTotalDePuntos;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lector window = new Lector();
					window.frmLector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lector() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLector = new JFrame();
		frmLector.setResizable(false);
		frmLector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLector.setTitle("Lector");
		frmLector.setBounds(100, 100, 567, 339);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		txtGanas = new JTextField();
		txtGanas.setEditable(false);
		txtGanas.setBackground(new Color(255, 245, 238));
		txtGanas.setForeground(Color.BLACK);
		txtGanas.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		txtGanas.setHorizontalAlignment(SwingConstants.CENTER);
		txtGanas.setText("GANASTE:");
		txtGanas.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		
		JLabel lblTotalPuntos = new JLabel("Total Puntos");
		lblTotalPuntos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lblTotalDePuntos = new JLabel("TOTAL DE PUNTOS OBTENIDOS");
		lblTotalDePuntos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("Premio");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmLector.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(108)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtGanas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(118))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(23)
											.addComponent(lblTotalPuntos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addGap(37)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
									.addGap(83))))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addComponent(lblTotalDePuntos, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTotalDePuntos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalPuntos)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtGanas, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		frmLector.getContentPane().setLayout(groupLayout);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}