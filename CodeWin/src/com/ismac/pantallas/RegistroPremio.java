//Geovanny Perugachi Inst: 
package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;


public class RegistroPremio {

	private JFrame frmRegistroDePremio;
	private JTextField txtCantidad;
	private JTextField txtNombreProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPremio window = new RegistroPremio();
					window.frmRegistroDePremio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroPremio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDePremio = new JFrame();
		frmRegistroDePremio.setResizable(false);
		frmRegistroDePremio.setBounds(100, 100, 449, 279);
		frmRegistroDePremio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblProducto = new JLabel("Producto");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnGuardar.setForeground(Color.BLUE);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLUE);
		btnCancelar.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setColumns(10);
		
		JLabel lblTitulo = new JLabel("REGISTRO DE PREMIO");
		lblTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frmRegistroDePremio.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCantidad)
						.addComponent(btnGuardar)
						.addComponent(lblProducto))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(btnCancelar)
							.addGap(78))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtNombreProducto, Alignment.LEADING)
								.addComponent(txtCantidad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
							.addGap(93))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addComponent(lblTitulo)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblProducto)
						.addComponent(txtNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnCancelar))
					.addGap(38))
		);
		frmRegistroDePremio.getContentPane().setLayout(groupLayout);
	}
}