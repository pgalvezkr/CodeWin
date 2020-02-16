package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ismac.controller.ProductoController;
import com.ismac.controller.StockController;
import com.ismac.servicios.StockService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockFinal {

	public JFrame frmStock;
	private JTextField txtProducto;
	private JTextField txtCantidadActual;
	private JTextField txtCantidadEntregada;
	private JLabel lblCantidadEntregada;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private String nombreProducto;
	public int idprod;
	
	
	
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

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
	 * Create the applicaaddFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		frmStock.tion.
	 */
	public StockFinal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStock = new JFrame();
		frmStock.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtProducto.setText(nombreProducto);
			}
		});
		frmStock.getContentPane().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtProducto.setText(nombreProducto);
			}
		});
		
		
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
		//Aqu� consultar la cantidad actual del producto y poner ese valor en el texto de cantidad actual
		// Aqu� poner el nombre del producto en el texto del producto
		
	
		// Aqu� consultar el id del producto por el nombre invocando al metodo
		//int idProducto = ProductoController.getIdProductoByNombre(nombreProducto);
		//int cantidad = Integer.getInteger(txtCantidadEntregada.getText());
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(txtCantidadEntregada.getText());
				int idProducto = ProductoController.getIdProductoByNombre(nombreProducto);
				
				StockController.descontarProductos(idProducto, cantidad);
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmStock.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblProducto)
								.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
								.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCantidadActual, GroupLayout.PREFERRED_SIZE, 88,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCantidadEntregada, GroupLayout.DEFAULT_SIZE, 100,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtCantidadActual, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCantidadEntregada, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
				.addGap(50))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(117).addComponent(btnGrabar)
						.addGap(48).addComponent(btnCancelar).addContainerGap(129, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(36)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblProducto).addComponent(
						txtProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCantidadActual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidadActual))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCantidadEntregada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblCantidadEntregada)))
				.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE).addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(btnGrabar).addComponent(btnCancelar))
				.addGap(45)));
		frmStock.getContentPane().setLayout(groupLayout);
	}

}
