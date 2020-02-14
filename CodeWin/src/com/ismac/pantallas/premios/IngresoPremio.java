package com.ismac.pantallas.premios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ismac.controller.PremioController;
import com.ismac.controller.ProductoController;
import com.ismac.entidades.Premio;
import com.ismac.entidades.Producto;
import com.ismac.pantallas.productos.IngresoProducto;
import com.ismac.pantallas.productos.ListaProducto;
import com.ismac.pantallas.tarjetas.IngresoTarjetaPantalla;
import com.ismac.pantallas.tarjetas.TarjetaPantalla;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IngresoPremio {

	public JFrame frmCodeWin;
	private Premio premio;
	private List<Producto> productos;
	private JComboBox cmbProducto = new JComboBox();
	private JSpinner spRangoInicial = new JSpinner();
	private JSpinner spRangoFinal = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoPremio window = new IngresoPremio();
					window.frmCodeWin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IngresoPremio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCodeWin = new JFrame();
		frmCodeWin.setTitle("Code Win");
		frmCodeWin.setBounds(100, 100, 450, 300);
		frmCodeWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Producto");
		JLabel lblRangoInicial = new JLabel("Rango inicial");

		JLabel lblNewLabel_1 = new JLabel("Rango final");

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Aqui invocar al método del controlador que permite crear un premio
				PremioController.crearPremio(premio);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");

		JLabel lblRegistroPremio = new JLabel("Registro Premio");
		lblRegistroPremio.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblRegistroPremio.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmCodeWin.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup()
						.addGroup(
								groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createSequentialGroup().addContainerGap(204, Short.MAX_VALUE)
										.addComponent(btnGuardar).addGap(24)
										.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup().addGap(44)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel).addComponent(lblRangoInicial)
														.addComponent(lblNewLabel_1))
												.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(
																spRangoFinal, GroupLayout.PREFERRED_SIZE, 217,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(spRangoInicial)
																.addComponent(cmbProducto, 0, 217, Short.MAX_VALUE)
																.addComponent(lblRegistroPremio,
																		GroupLayout.PREFERRED_SIZE, 150,
																		GroupLayout.PREFERRED_SIZE)))))
						.addGap(50)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblRegistroPremio).addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						cmbProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRangoInicial)
						.addComponent(spRangoInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						spRangoFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnGuardar)
						.addComponent(btnCancelar))
				.addContainerGap(20, Short.MAX_VALUE)));
		frmCodeWin.getContentPane().setLayout(groupLayout);
		cargarMenu();
		cargarComboProducto();
	}

	private void crearPremio() {
		premio = new Premio();
		int idProductoSeleccionado = recuperarIdProducto();
		premio.setIdProducto(idProductoSeleccionado);
		int rangoInicial = (Integer) spRangoInicial.getValue();
		premio.setRangoInicial(rangoInicial);
		int rangoFinal = (Integer) spRangoFinal.getValue();
		premio.setRangoFinal(rangoFinal);
	}

	private void cargarComboProducto() {
		productos = new ArrayList<Producto>();
		productos = ProductoController.getProducto();
		for (Producto producto : productos) {
			cmbProducto.addItem(producto.getNombre());
		}
	}

	private int recuperarIdProducto() {
		int idProducto = 0;
		String nombre = (String) cmbProducto.getItemAt(cmbProducto.getSelectedIndex());
		for (Producto producto : productos) {
			if (producto.getNombre().trim().equals(nombre.trim())) {
				idProducto = producto.getIdProducto();
			}
		}
		return idProducto;
	}

	private void cargarMenu() {

		JMenuBar mbConfiguracion = new JMenuBar();
		frmCodeWin.setJMenuBar(mbConfiguracion);

		JMenu mTarjeta = new JMenu("Tarjeta");
		mbConfiguracion.add(mTarjeta);

		JMenuItem miNuevaTarjeta = new JMenuItem("Nuevo");
		miNuevaTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoTarjetaPantalla ingreso = new IngresoTarjetaPantalla();
				ingreso.frame.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});

		mTarjeta.add(miNuevaTarjeta);

		JMenuItem miListarTarjeta = new JMenuItem("Listar");
		miListarTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TarjetaPantalla listar = new TarjetaPantalla();
				listar.frmListaTarjeta.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});
		mTarjeta.add(miListarTarjeta);

		JMenu mnProducto = new JMenu("Producto");
		mbConfiguracion.add(mnProducto);

		JMenuItem miNuevoProducto = new JMenuItem("Nuevo");
		miNuevoProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoProducto nuevo = new IngresoProducto();
				nuevo.frame.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});
		mnProducto.add(miNuevoProducto);

		JMenuItem miListarProducto = new JMenuItem("Listar");
		miListarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaProducto lista = new ListaProducto();
				lista.frame.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});
		mnProducto.add(miListarProducto);

		JMenu mnPremios = new JMenu("Premios");
		mbConfiguracion.add(mnPremios);

		JMenuItem miNuevoPremio = new JMenuItem("Nuevo");
		miNuevoPremio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoPremio nuevo = new IngresoPremio();
				nuevo.frmCodeWin.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});
		mnPremios.add(miNuevoPremio);

		JMenuItem miListarPremios = new JMenuItem("Listar");
		miListarPremios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaPremio lista = new ListaPremio();
				lista.frame.setVisible(true);
				frmCodeWin.setVisible(false);
				frmCodeWin.dispose();
			}
		});
		mnPremios.add(miListarPremios);

	}
}
