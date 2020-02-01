package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Reporte {

	private JFrame frmReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte window = new Reporte();
					window.frmReportes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reporte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReportes = new JFrame();
		frmReportes.setTitle("Reportes");
		frmReportes.setBounds(100, 100, 450, 300);
		frmReportes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
