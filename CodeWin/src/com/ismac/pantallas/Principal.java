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
		frmPrincipal.getContentPane().setForeground(Color.WHITE);
		frmPrincipal.getContentPane().setFont(new Font("Segoe Print", Font.BOLD, 11));
		frmPrincipal.setTitle("Bienvenido  a Code Win");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLectorCodigo = new JButton("Leer de Codigo");
		btnLectorCodigo.setForeground(Color.BLUE);
		btnLectorCodigo.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfiguracion.setForeground(Color.BLUE);
		btnConfiguracion.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnReporte = new JButton("Reportes");
		btnReporte.setForeground(Color.BLUE);
		btnReporte.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblTextoEntrada = new JLabel("Gracias por usar nuestro sistema");
		lblTextoEntrada.setFont(new Font("Vivaldi", Font.BOLD, 18));
		lblTextoEntrada.setForeground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frmPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnLectorCodigo)
					.addGap(18)
					.addComponent(btnConfiguracion)
					.addGap(18)
					.addComponent(btnReporte, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(lblTextoEntrada, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblTextoEntrada, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfiguracion)
						.addComponent(btnReporte)
						.addComponent(btnLectorCodigo))
					.addGap(63))
		);
		frmPrincipal.getContentPane().setLayout(groupLayout);
	}
}
