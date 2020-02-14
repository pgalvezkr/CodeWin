package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
//import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public JFrame frmPrincipal;
	
	private Lector lectorPantalla;

	private Configuracion configuracion;
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
		frmPrincipal.getContentPane().setForeground(Color.WHITE);
		frmPrincipal.getContentPane().setFont(new Font("Segoe Print", Font.BOLD, 11));
		frmPrincipal.setTitle("Code Win");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLectorCodigo = new JButton("Leer de Codigo");
		btnLectorCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrincipal.setVisible(false);
				lectorPantalla = new Lector();
				lectorPantalla.frmLector.setVisible(true);
			}
		});
		btnLectorCodigo.setForeground(Color.BLUE);
		btnLectorCodigo.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configuracion = new Configuracion();
				configuracion.frmConfiguracion.setVisible(true);
			}
		});
		btnConfiguracion.setForeground(Color.BLUE);
		btnConfiguracion.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblTextoEntrada = new JLabel("Gracias por usar nuestro sistema");
		lblTextoEntrada.setFont(new Font("Vivaldi", Font.BOLD, 18));
		lblTextoEntrada.setForeground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frmPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(btnLectorCodigo)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(btnConfiguracion)
					.addGap(62))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(lblTextoEntrada, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblTextoEntrada, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLectorCodigo)
						.addComponent(btnConfiguracion))
					.addGap(63))
		);
		frmPrincipal.getContentPane().setLayout(groupLayout);
	}
}
