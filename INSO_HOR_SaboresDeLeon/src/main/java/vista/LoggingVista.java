package main.java.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import main.java.controladores.EmpleadoControlador;
import main.java.controladores.RestauranteLoggingControlador;

public class LoggingVista extends JFrame implements ActionListener {

    private JPanel mainPanel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JButton botonLogin;
    private RestauranteLoggingControlador restaurante;
    private JTextField usuario;
    private JPasswordField contrasena;

    public LoggingVista() {
        // Configuración del tema de color
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 223, 186)));
            UIManager.put("PasswordField.inactiveBackground", new ColorUIResource(new Color(255, 223, 186)));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Configuración de la ventana
        setTitle("Restaurante Sabores de León");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        // Panel principal
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel de inicio de sesión
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font labelFont2 = new Font("Arial", Font.PLAIN, 16);

        usuario = new JTextField(20);
        usuario.setFont(labelFont2);
        contrasena = new JPasswordField(20);
        contrasena.setFont(labelFont2);
        botonLogin = new JButton("Login");
        botonLogin.setFont(labelFont2);

        JLabel usuarioLabel = new JLabel("Usuario (DNI)");
        usuarioLabel.setFont(labelFont);
        JLabel contraseñaLabel = new JLabel("Contraseña");
        contraseñaLabel.setFont(labelFont);

        loginPanel.add(usuarioLabel, gbc);
        gbc.gridy++;
        loginPanel.add(usuario, gbc);
        gbc.gridy++;
        loginPanel.add(contraseñaLabel, gbc);
        gbc.gridy++;
        loginPanel.add(contrasena, gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.CENTER;
        loginPanel.add(botonLogin, gbc);

        // Configuración de colores
        mainPanel.setBackground(new Color(190, 148, 250));
        loginPanel.setBackground(new Color(190, 148, 250));

        // Agregar paneles a la ventana
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        add(mainPanel);

        // Agregar listeners
        botonLogin.addActionListener(this);

        // Inicialización del controlador
        restaurante = new RestauranteLoggingControlador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonLogin) {
            String user = usuario.getText().trim();
            String password = new String(contrasena.getPassword()).trim();

            if (user.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String tipo = restaurante.login(user, password);

                if (tipo != null) {
                    if (tipo.equals("Gerente")) {
                        JOptionPane.showMessageDialog(this, "Bienvenido, Gerente.");
                        GerenteVista gv = new GerenteVista();
                        gv.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Bienvenido, Empleado.");
                        EmpleadoVista ev = new EmpleadoVista();
                        ev.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}
