package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.ismac.controller.TarjetaController;
import com.ismac.entidades.Tarjeta;
import com.ismac.servicios.TarjetaService;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoTarjetaPantalla {

	private JFrame frame;
	private JTextField txtPuntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoTarjetaPantalla window = new IngresoTarjetaPantalla();
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
	public IngresoTarjetaPantalla() {
		initialize();
	}

	private void crearTarjeta(int tipoTarjeta, int estacion, int puntos) {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setTipoDeTarjeta(tipoTarjeta);
		tarjeta.setEstacion(estacion);
		tarjeta.setValorDeTarjeta(puntos);
		TarjetaController.crearTarjeta(tarjeta);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblTipo = new JLabel("Tipo:");

		JLabel lblTitulo = new JLabel("REGISTRO DE UNA TARJETA");

		JComboBox cmbTipo = new JComboBox();
		cmbTipo.addItem("Golden");
		cmbTipo.addItem("Platinium");
		cmbTipo.addItem("White");
		JLabel lblEstacion = new JLabel("Estaci\u00F3n:");
		JComboBox cmbEstacion = new JComboBox();
		cmbEstacion.addItem("Juego binarios");
		cmbEstacion.addItem("Juego tripas");
		cmbEstacion.addItem("Juego prueba");
		JLabel lblPuntos = new JLabel("Puntos:");
		txtPuntos = new JTextField();
		txtPuntos.setColumns(10);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LLAMAR AL METODO QUE CREA LA TARJETA
				crearTarjeta(cmbTipo.getSelectedIndex(), cmbEstacion.getSelectedIndex(),
						Integer.parseInt(txtPuntos.getText()));
				frame.setVisible(false);
				frame.dispose();
			}
		});
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(145).addComponent(lblTitulo))
						.addGroup(groupLayout.createSequentialGroup().addGap(62).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblTipo).addComponent(lblEstacion,
														GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(cmbEstacion, GroupLayout.PREFERRED_SIZE, 206,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(cmbTipo, GroupLayout.PREFERRED_SIZE, 206,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnGuardar).addGap(18)
										.addComponent(btnCancelar))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPuntos, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txtPuntos)))))
				.addContainerGap(100, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblTitulo).addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEstacion).addComponent(
						cmbEstacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPuntos).addComponent(
						txtPuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(43).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnGuardar)
						.addComponent(btnCancelar))
				.addContainerGap(52, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
