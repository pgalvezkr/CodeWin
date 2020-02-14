package com.ismac.pantallas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ismac.pantallas.premios.IngresoPremio;
import com.ismac.pantallas.premios.ListaPremio;
import com.ismac.pantallas.productos.IngresoProducto;
import com.ismac.pantallas.productos.ListaProducto;
import com.ismac.pantallas.tarjetas.IngresoTarjetaPantalla;
import com.ismac.pantallas.tarjetas.TarjetaPantalla;

import javax.swing.JMenu;

public class Configuracion {

	public JFrame frmConfiguracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracion window = new Configuracion();
					window.frmConfiguracion.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Configuracion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfiguracion = new JFrame();
		frmConfiguracion.setTitle("Configuraci\u00F3n");
		frmConfiguracion.setBounds(100, 100, 450, 300);
		frmConfiguracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mbConfiguracion = new JMenuBar();
		frmConfiguracion.setJMenuBar(mbConfiguracion);

		JMenu mTarjeta = new JMenu("Tarjeta");
		mbConfiguracion.add(mTarjeta);

		JMenuItem miNuevaTarjeta = new JMenuItem("Nuevo");
		miNuevaTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IngresoTarjetaPantalla ingreso = new IngresoTarjetaPantalla();
				ingreso.frame.setVisible(true);
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
			}
		});

		mTarjeta.add(miNuevaTarjeta);

		JMenuItem miListarTarjeta = new JMenuItem("Listar");
		miListarTarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TarjetaPantalla listar = new TarjetaPantalla();
				listar.frmListaTarjeta.setVisible(true);
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
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
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
			}
		});
		mnProducto.add(miNuevoProducto);

		JMenuItem miListarProducto = new JMenuItem("Listar");
		miListarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaProducto lista = new ListaProducto();
				lista.frame.setVisible(true);
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
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
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
			}
		});
		mnPremios.add(miNuevoPremio);

		JMenuItem miListarPremios = new JMenuItem("Listar");
		miListarPremios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListaPremio lista = new ListaPremio();
				lista.frame.setVisible(true);
				frmConfiguracion.setVisible(false);
				frmConfiguracion.dispose();
			}
		});
		mnPremios.add(miListarPremios);
	}

}
