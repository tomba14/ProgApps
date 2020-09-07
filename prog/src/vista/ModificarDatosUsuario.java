package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarDatosUsuario() {
		setResizable(true);
		setTitle("Modificar datos de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 442, 226);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("carlos1234");
		comboBox.addItem("cajjdfkkaka");
		comboBox.addItem("cardfadgsdgadg");
		comboBox.addItem("mariadfasdasdgad");
		comboBox.addItem("martinaghdjjadf");
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 400));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNickname);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblApellido);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFechaDeNacimiento);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns();
		
		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(5);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(5);

	}

}
