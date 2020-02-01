package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Principal {

	private JFrame frmPrincipal;
	/**
	 * @wbp.nonvisual location=218,99
	 */
	private final Canvas canvas = new Canvas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.getContentPane().setFont(new Font("Segoe Print", Font.BOLD, 11));
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLector = new JButton("Leer de Codigo");
		btnLector.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		
		JButton btnReporte = new JButton("Reportes");
		btnReporte.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		GroupLayout groupLayout = new GroupLayout(frmPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnLector)
					.addGap(39)
					.addComponent(btnConfiguracion)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnReporte, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLector)
						.addComponent(btnConfiguracion)
						.addComponent(btnReporte))
					.addGap(63))
		);
		frmPrincipal.getContentPane().setLayout(groupLayout);
	}

}
