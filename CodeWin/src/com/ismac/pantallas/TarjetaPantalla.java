package com.ismac.pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.ismac.controller.TarjetaController;
import com.ismac.entidades.Tarjeta;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;

public class TarjetaPantalla {

	private JFrame frame;
	private JTable table;
	private List<Tarjeta> tarjetas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarjetaPantalla window = new TarjetaPantalla();
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
	public TarjetaPantalla() {
		initialize();
	}

	private void cargarTarjetas() {
		this.tarjetas = new ArrayList<>();
		this.tarjetas = TarjetaController.getTarjetas();
	}

	private void cargarTabla() {
		// Inicializo la lista de tarjetas
		cargarTarjetas();
		String[] cabecera = { "No.", "Tipo Tarjeta", "Estación", "Valor Tarjeta" };
		// Inicializo la lista de tarjetas
		table = new JTable(new DefaultTableModel());
		// AGREGAR ELEMENTOS A LA TABLA
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(cabecera);
		for (Tarjeta tarjeta : tarjetas) {
			model.addRow(new Object[] { tarjeta.getIdTarjeta(), tarjeta.getTipoDeTarjeta(), tarjeta.getEstacion(),
					tarjeta.getValorDeTarjeta() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// CARGAR TABLA
		cargarTabla();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNuevo = new JButton("Nuevo");
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnNuevo)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(btnNuevo).addGap(15)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.add(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
