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
import java.awt.Color;

public class Principal {

	private JFrame frmPrincipal;

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
		frmPrincipal.setTitle("Bienvenido  a Code Win");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLector = new JButton("Leer de Codigo");
		btnLector.setForeground(Color.BLUE);
		btnLector.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.setForeground(Color.BLUE);
		btnConfiguracion.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		
		JButton btnReporte = new JButton("Reportes");
		btnReporte.setForeground(Color.BLUE);
		btnReporte.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		
		JLabel lblNewLabel = new JLabel("Gracias por usar nuestro sistema");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frmPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnLector)
					.addGap(39)
					.addComponent(btnConfiguracion)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnReporte, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLector)
						.addComponent(btnConfiguracion)
						.addComponent(btnReporte))
					.addGap(63))
		);
		frmPrincipal.getContentPane().setLayout(groupLayout);
	}
}
