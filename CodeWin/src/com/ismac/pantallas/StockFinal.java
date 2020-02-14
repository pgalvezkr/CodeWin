package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class StockFinal {

	public JFrame frmStock;
	private JTextField txtProducto;
	private JTextField txtCantidadActual;
	private JTextField txtCantidadEntregada;
	private JLabel lblCantidadEntregada;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockFinal window = new StockFinal();
					window.frmStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStock = new JFrame();
		frmStock.setTitle("Stock");
		frmStock.setBounds(100, 100, 450, 300);
		frmStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblProducto = new JLabel("Producto");
		
		txtProducto = new JTextField();
		txtProducto.setEnabled(false);
		txtProducto.setEditable(false);
		txtProducto.setColumns(10);
		
		JLabel lblCantidadActual = new JLabel("Cantidad Actual");
		
		txtCantidadActual = new JTextField();
		txtCantidadActual.setEditable(false);
		txtCantidadActual.setEnabled(false);
		txtCantidadActual.setColumns(10);
		
		txtCantidadEntregada = new JTextField();
		txtCantidadEntregada.setColumns(10);
		
		lblCantidadEntregada = new JLabel("Cantidad Entregada");
		
		btnNewButton = new JButton("Grabar");
		
		btnNewButton_1 = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(frmStock.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProducto)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCantidadActual, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidadEntregada, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCantidadActual, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCantidadEntregada, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
					.addGap(50))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(117)
					.addComponent(btnNewButton)
					.addGap(48)
					.addComponent(btnNewButton_1)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProducto)
						.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCantidadActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidadActual))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCantidadEntregada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCantidadEntregada)))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(45))
		);
		frmStock.getContentPane().setLayout(groupLayout);
	}

}
