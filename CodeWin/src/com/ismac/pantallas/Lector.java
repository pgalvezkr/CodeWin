//Pantalla generada por David
//Editada por JK
package com.ismac.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.ismac.controller.LectorController;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.DropMode;

public class Lector {
	Principal principal;
	private int numeroTarjetas;
	private int totalPuntos = 0;
	public JFrame frmLector;
	private JTextField txtPuntos;
	private JLabel lblTotalDePuntos;
	private JTextField txtPuntosObtenidos;
	private JTextField txtPremio;
	private JButton btnPremio;
	private JButton btnStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lector window = new Lector();
					window.frmLector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lector() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLector = new JFrame();
		frmLector.setResizable(false);
		frmLector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLector.setTitle("Code Win");
		frmLector.setBounds(100, 100, 567, 339);

		txtPuntos = new JTextField();
		txtPuntos.setEditable(false);
		txtPuntos.setBackground(new Color(255, 245, 238));
		txtPuntos.setForeground(Color.BLACK);
		txtPuntos.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntos.setText("PUNTOS:");
		txtPuntos.setColumns(10);

		lblTotalDePuntos = new JLabel("TOTAL DE PUNTOS OBTENIDOS");
		lblTotalDePuntos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 15));

		JButton btnLeerTarjeta = new JButton("Leer Tarjeta");
		btnLeerTarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeroTarjetas++;
				System.out.println(numeroTarjetas);
				if (numeroTarjetas <= 3) {
					try {
						int puntos = LectorController.obtenerPuntosFromCodigo();
						if (puntos == 0) {
							JOptionPane.showMessageDialog(null,
									"No se pudo leer el codigo por favor intente Nuevamente", "Adventencia",
									JOptionPane.INFORMATION_MESSAGE);
							numeroTarjetas--;
							return;
						}
						totalPuntos = puntos + totalPuntos;

						txtPuntosObtenidos.setText(Integer.toString(totalPuntos));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usted Ingreso las 3 tarjetas", "Adventencia",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLeerTarjeta.setForeground(Color.BLUE);
		btnLeerTarjeta.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnLeerTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		txtPuntosObtenidos = new JTextField();
		txtPuntosObtenidos.setForeground(Color.RED);
		txtPuntosObtenidos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosObtenidos.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		txtPuntosObtenidos.setText("0");
		txtPuntosObtenidos.setEditable(false);
		txtPuntosObtenidos.setColumns(10);

		txtPremio = new JTextField();
		txtPremio.setForeground(Color.BLACK);
		txtPremio.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		txtPremio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPremio.setText("APLAUSOS");
		txtPremio.setEditable(false);
		txtPremio.setColumns(10);

		JButton btnReinciar = new JButton("Reiniciar");
		btnReinciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Ingrese Nuevamente las Tarjetas" + "", "Adventencia",
						JOptionPane.INFORMATION_MESSAGE);
				txtPuntosObtenidos.setText("0");
				totalPuntos = 0;
				numeroTarjetas = 0;
			}

		});
		btnReinciar.setForeground(Color.BLUE);
		btnReinciar.setFont(new Font("Book Antiqua", Font.BOLD, 13));

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal = new Principal();
				principal.frmPrincipal.setVisible(true);
				frmLector.setVisible(false);
			}
		});
		btnRegresar.setForeground(Color.BLUE);
		btnRegresar.setFont(new Font("Book Antiqua", Font.BOLD, 13));

		btnPremio = new JButton("Ver Premio");
		btnPremio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		btnPremio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LectorController premio = new LectorController();
				// 1. AQUI ACTUALIZAR EL LABEL CON EL NOMBRE DEL PREMIO
				txtPremio.setText(premio.obtenerPremio(Integer.parseInt(txtPuntosObtenidos.getText())));
			}
		});
		btnPremio.setBackground(new Color(255, 245, 238));
		btnPremio.setFont(new Font("Book Antiqua", Font.BOLD, 17));

		btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockFinal stockFinal = new StockFinal();
				stockFinal.nombreProducto = txtPremio.getText();
				stockFinal.frmStock.setVisible(true);
			}
		});
		btnStock.setForeground(Color.BLUE);
		btnStock.setFont(new Font("Book Antiqua", Font.BOLD, 13));

		GroupLayout groupLayout = new GroupLayout(frmLector.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(btnLeerTarjeta).addGap(33)
						.addComponent(btnReinciar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnStock, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGap(29))
				.addGroup(groupLayout.createSequentialGroup().addGap(48)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPuntosObtenidos, 0, 0, Short.MAX_VALUE).addComponent(txtPuntos,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnPremio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtPremio, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGap(71))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(172, Short.MAX_VALUE)
						.addComponent(lblTotalDePuntos, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addGap(83)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblTotalDePuntos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPremio, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(txtPuntos, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtPuntosObtenidos, GroupLayout.PREFERRED_SIZE, 126,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPremio, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnLeerTarjeta)
										.addComponent(btnReinciar, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnStock, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		frmLector.getContentPane().setLayout(groupLayout);
	}

}