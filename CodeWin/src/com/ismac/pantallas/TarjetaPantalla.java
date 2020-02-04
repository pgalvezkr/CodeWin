package com.ismac.pantallas;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TarjetaPantalla {

	private JFrame frame;
	private JTable table;
	private List<Tarjeta> tarjetas;
	private JLabel lblMduloTarjetas;

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
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoTarjetaPantalla ingreso = new IngresoTarjetaPantalla();
				ingreso.frame.setVisible(true);
			}
		});
		JPanel panel = new JPanel();
		
		lblMduloTarjetas = new JLabel("M\u00F3dulo Tarjetas");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(lblMduloTarjetas))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNuevo))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMduloTarjetas)
					.addGap(4)
					.addComponent(btnNuevo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.add(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
