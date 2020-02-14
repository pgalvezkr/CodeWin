package com.ismac.pantallas.tarjetas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.ismac.controller.TarjetaController;
import com.ismac.entidades.Tarjeta;
import com.ismac.pantallas.premios.IngresoPremio;
import com.ismac.pantallas.premios.ListaPremio;
import com.ismac.pantallas.productos.IngresoProducto;
import com.ismac.pantallas.productos.ListaProducto;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TarjetaPantalla {

	public JFrame frmListaTarjeta;
	private JTable table;
	private List<Tarjeta> tarjetas;
	private JLabel lblMduloTarjetas;
	private JMenuBar menuBar;
	private JMenu mTarjeta;
	private JMenu mProducto;
	private JMenu mPremios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarjetaPantalla window = new TarjetaPantalla();
					window.frmListaTarjeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TarjetaPantalla() {
		initialize();
	}

	private void cargarTarjetas() {
		this.tarjetas = new ArrayList<>();
		this.tarjetas = TarjetaController.getTarjetas();
	}

	private void cargarTabla() {
		// Inicializo la lista de tarjetas
		// cargarTarjetas();
		String[] cabecera = { "No.", "Tipo Tarjeta", "Estación", "Valor Tarjeta" };
		// Inicializo la lista de tarjetas
		table = new JTable(new DefaultTableModel());
		// AGREGAR ELEMENTOS A LA TABLA
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(cabecera);
		// for (Tarjeta tarjeta : tarjetas) {
		// model.addRow(new Object[] { tarjeta.getIdTarjeta(),
		// tarjeta.getTipoDeTarjeta(), tarjeta.getEstacion(),
		// tarjeta.getValorDeTarjeta() });
		// }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// CARGAR TABLA
		cargarTabla();

		frmListaTarjeta = new JFrame();
		frmListaTarjeta.setTitle("Configuraci\u00F3n");
		frmListaTarjeta.setBounds(100, 100, 450, 300);
		frmListaTarjeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		lblMduloTarjetas = new JLabel("Lista de Tarjetas");
		lblMduloTarjetas.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frmListaTarjeta.getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup().addGap(147).addComponent(lblMduloTarjetas)
										.addContainerGap(165, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(39).addComponent(lblMduloTarjetas)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE).addGap(26)));
		panel.add(table);
		frmListaTarjeta.getContentPane().setLayout(groupLayout);
		cargarMenu();
	}

	private void cargarMenu() {

		JMenuBar mbConfiguracion = new JMenuBar();
		frmListaTarjeta.setJMenuBar(mbConfiguracion);

		JMenu mTarjeta = new JMenu("Tarjeta");
		mbConfiguracion.add(mTarjeta);

		JMenuItem miNuevaTarjeta = new JMenuItem("Nuevo");
		miNuevaTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoTarjetaPantalla ingreso = new IngresoTarjetaPantalla();
				ingreso.frame.setVisible(true);
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
			}
		});

		mTarjeta.add(miNuevaTarjeta);

		JMenuItem miListarTarjeta = new JMenuItem("Listar");
		miListarTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TarjetaPantalla listar = new TarjetaPantalla();
				listar.frmListaTarjeta.setVisible(true);
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
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
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
			}
		});
		mnProducto.add(miNuevoProducto);

		JMenuItem miListarProducto = new JMenuItem("Listar");
		miListarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaProducto lista = new ListaProducto();
				lista.frame.setVisible(true);
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
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
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
			}
		});
		mnPremios.add(miNuevoPremio);

		JMenuItem miListarPremios = new JMenuItem("Listar");
		miListarPremios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaPremio lista = new ListaPremio();
				lista.frame.setVisible(true);
				frmListaTarjeta.setVisible(false);
				frmListaTarjeta.dispose();
			}
		});
		mnPremios.add(miListarPremios);
	}
}
