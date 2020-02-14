package com.ismac.pantallas.tarjetas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.ismac.controller.TarjetaController;
import com.ismac.entidades.Tarjeta;
import com.ismac.pantallas.premios.IngresoPremio;
import com.ismac.pantallas.premios.ListaPremio;
import com.ismac.pantallas.productos.IngresoProducto;
import com.ismac.pantallas.productos.ListaProducto;
import com.ismac.servicios.TarjetaService;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoTarjetaPantalla {

	public JFrame frame;
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

	private void crearTarjeta(String tipoTarjeta, String estacion, int puntos) {
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
				crearTarjeta((String) cmbTipo.getItemAt(cmbTipo.getSelectedIndex()),
						(String) cmbEstacion.getItemAt(cmbEstacion.getSelectedIndex()),
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
		cargarMenu();
	}

	private void cargarMenu() {

		JMenuBar mbConfiguracion = new JMenuBar();
		frame.setJMenuBar(mbConfiguracion);

		JMenu mTarjeta = new JMenu("Tarjeta");
		mbConfiguracion.add(mTarjeta);

		JMenuItem miNuevaTarjeta = new JMenuItem("Nuevo");
		miNuevaTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoTarjetaPantalla ingreso = new IngresoTarjetaPantalla();
				ingreso.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});

		mTarjeta.add(miNuevaTarjeta);

		JMenuItem miListarTarjeta = new JMenuItem("Listar");
		miListarTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TarjetaPantalla listar = new TarjetaPantalla();
				listar.frmListaTarjeta.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
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
				frame.setVisible(false);
				frame.dispose();
			}
		});
		mnProducto.add(miNuevoProducto);

		JMenuItem miListarProducto = new JMenuItem("Listar");
		miListarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaProducto lista = new ListaProducto();
				lista.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
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
				frame.setVisible(false);
				frame.dispose();
			}
		});
		mnPremios.add(miNuevoPremio);

		JMenuItem miListarPremios = new JMenuItem("Listar");
		miListarPremios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaPremio lista = new ListaPremio();
				lista.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		mnPremios.add(miListarPremios);
	}
}
