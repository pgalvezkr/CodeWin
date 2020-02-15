package com.ismac.controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.ismac.pantallas.Lector;
import com.ismac.servicios.PremioService;


public class LectorController {

	private static void tomarFoto() throws IOException {

		// get default webcam and open it
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(640, 480));
		webcam.open();

		// get image
		BufferedImage image = webcam.getImage();

		// save image to PNG file cambiar a un path generico como Desktop
		ImageIO.write(image, "PNG", new File("test.png"));
		webcam.close();
	}

	private static String decodeQRCode(File qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}

	public static int obtenerPuntosFromCodigo() throws IOException {
		tomarFoto();
		File imagenQr = new File("test.png");
		String valor = decodeQRCode(imagenQr);
		return valor != null ? Integer.parseInt(valor) : 0;

	}

	public static String obtenerPremio(int numeroPuntos) {
		String nombreProducto = "";
		try {
			nombreProducto = PremioService.obtenerPremio(numeroPuntos);
		} catch (Exception e) {
			System.out.println("Ocurri� un error al momento de consultar el premio");
			e.printStackTrace();
		}
		return nombreProducto;
	}
	public static void resetTarjetas() {
		Lector lect = new Lector();
		JOptionPane.showMessageDialog(null, "Ingrese Nuevamente las Tarjetas"
				+ "", "Adventencia", JOptionPane.INFORMATION_MESSAGE);
		//JTextField valor = null;
		//valor.setText("0");
		System.out.println("Borrado");
		lect.setTxtPuntosObtenidosjk();
		
		//txtPuntosObtenidos.setText("0");
		lect.setTotalPuntos(0);
		//totalPuntos=0;
		lect.setNumeroTarjetas(0);
		System.out.println("Borrado1111111111");
		//numeroTarjetas=0;
		
	}
	
}