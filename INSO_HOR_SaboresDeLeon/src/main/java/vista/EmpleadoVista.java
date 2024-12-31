package main.java.vista;

import main.java.controladores.EmpleadoControlador;
import main.java.modelo.vo.EmpleadoVO;
import main.java.modelo.vo.MenuVO;
import main.java.modelo.vo.ReservaVO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class EmpleadoVista extends JFrame implements ActionListener{

    private EmpleadoControlador empleadoControlador;
    
	private DefaultTableModel tableModel;
    private JTabbedPane pestanasPrincipales;
    private JPanel panelReservas, panelMenus, panelCerrarSesion;
    private JTabbedPane pestanasReservas;
    JButton aniadir, actualizar, eliminar, botonSeleccion, botonSeleccionEliminar;
	JTextField nombre, apellido, dni, numTelefono, correoElectronico, comensales, fechaHora;
	JTextField nombreEd, apellidoEd, dniEd, numTelefonoEd, correoElectronicoEd, comensalesEd, fechaHoraEd;
	ReservaVO r;
	MenuVO m;
	EmpleadoVO em;
	JTable catalogTable, catalogueTable;
    private JButton btnCerrarSesion;

    public EmpleadoVista() {
        this.empleadoControlador = new EmpleadoControlador();

        setTitle("Empleado - Sistema de Reservas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el TabbedPane principal
        pestanasPrincipales = new JTabbedPane();

        // Panel de Reservas
        panelReservas = new JPanel();
        panelReservas.setBackground(new Color(190, 148, 250));
        pestanasReservas = new JTabbedPane();
        crearSubPestañasReservas();
        pestanasReservas.setTabPlacement(JTabbedPane.NORTH);
        panelReservas.add(pestanasReservas);

        // Panel de Menús
        panelMenus = new JPanel();
        panelMenus.setBackground(new Color(190, 148, 250));
        panelMenus = crearPanelMostrarMenu();


        // Panel de Cerrar Sesión
        panelCerrarSesion = new JPanel();
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.addActionListener(this);
        panelCerrarSesion.add(btnCerrarSesion);

        // Añadir las pestañas principales
        pestanasPrincipales.addTab("Reservas", panelReservas);
        pestanasPrincipales.addTab("Menús", panelMenus);
        pestanasPrincipales.addTab("Cerrar sesión", panelCerrarSesion);

        // Agregar el TabbedPane al JFrame
        add(pestanasPrincipales);

        setVisible(true);
    }

	private void crearSubPestañasReservas() {
		JPanel panelMostrar = crearPanelMostrarReserva();
		JPanel panelAniadir = crearPanelAñadirReserva();
	    JPanel panelModificar = crearPanelModificarReserva();
	    JPanel panelEliminar = crearPanelEliminarReserva();
	    
	    pestanasReservas.addTab("Mostrar", panelMostrar);
	    pestanasReservas.addTab("Añadir", panelAniadir);
	    pestanasReservas.addTab("Modificar", panelModificar);
	    pestanasReservas.addTab("Eliminar", panelEliminar);
	}
	
	private JPanel crearPanelMostrarReserva() {
		JPanel panelMostrarReserva = new JPanel(new BorderLayout());
		panelMostrarReserva.setPreferredSize(new Dimension(700, 100));
	    actualizarListaReserva(panelMostrarReserva);
	    return panelMostrarReserva;
		
	}
	
    private void actualizarListaReserva(JPanel panelActualizado) {
		ArrayList<ReservaVO> reservas = empleadoControlador.getReservas();

	    tableModel = new DefaultTableModel();
	    tableModel.addColumn("ID");
	    tableModel.addColumn("Nombre");
	    tableModel.addColumn("Apellido");
	    tableModel.addColumn("DNI");
	    tableModel.addColumn("Teléfono");
	    tableModel.addColumn("Correo");
	    tableModel.addColumn("Comensales");
	    tableModel.addColumn("Fecha y hora");

	    for (ReservaVO reserva : reservas) {
	        tableModel.addRow(new Object[] {
        		reserva.getIdReserva(),
        		reserva.getNombre(),
        		reserva.getApellido(),
        		reserva.getDni(),
        		reserva.getTelefono(),
        		reserva.getCorreo(),
        		reserva.getComensales(),
        		reserva.getFechaHora(),
	        });
	    }

	    if (catalogTable != null) {
	        // Si la tabla ya existe, la eliminamos para agregar la nueva
	        panelActualizado.remove(new JScrollPane(catalogTable));
	    }

	    catalogTable = new JTable(tableModel);
	    JScrollPane scrollPane = new JScrollPane(catalogTable);
	    panelActualizado.add(scrollPane);
	    
	    if (pestanasReservas.getTabCount() > 0) {
	    	pestanasReservas.setComponentAt(0, panelActualizado);
	    } else {
	    	pestanasReservas.addTab("Lista Reservas", panelActualizado);
	    }

	    this.panelReservas.setVisible(true);
		
	}

	private JPanel crearPanelAñadirReserva() {
    	JPanel panelAniadirReservas = new JPanel(new BorderLayout());

		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel comensalesLabel = new JLabel("Número de comensales");
		JLabel fechaHoraLabel = new JLabel("Fecha y Hora");
		
		aniadir = new JButton("Añadir");
		
		panelAniadirReservas.setLayout(new GridLayout(8, 2, 10, 10));
		
		panelAniadirReservas.add(nombreLabel);
		nombre = new JTextField(20);
		panelAniadirReservas.add(nombre);

		panelAniadirReservas.add(apellidoLabel);
		apellido = new JTextField(20);
		panelAniadirReservas.add(apellido);
		
		panelAniadirReservas.add(dniLabel);
		dni = new JTextField(20);
		panelAniadirReservas.add(dni);

		panelAniadirReservas.add(numTelefonoLabel);
		numTelefono = new JTextField(20);
		panelAniadirReservas.add(numTelefono);
		
		panelAniadirReservas.add(correoElectronicoLabel);
		correoElectronico = new JTextField(20);
		panelAniadirReservas.add(correoElectronico);
		
		panelAniadirReservas.add(comensalesLabel);
		comensales = new JTextField(20);
		panelAniadirReservas.add(comensales);
			
		panelAniadirReservas.add(fechaHoraLabel);
		fechaHora = new JTextField(20);
		panelAniadirReservas.add(fechaHora);
			
		panelAniadirReservas.add(aniadir);

		aniadir.addActionListener(this);

		return panelAniadirReservas;
	}
    

	private JPanel crearPanelModificarReserva() {
		JPanel panelReservas = new JPanel(new BorderLayout());
		
		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel comensalesLabel = new JLabel("Número de comensales");
		JLabel fechaHoraLabel = new JLabel("Fecha y Hora");;
		
		actualizar = new JButton("Actualizar Datos");
			
		botonSeleccion = new JButton("Seleccionar Reserva");
		botonSeleccion.addActionListener(this);
		panelReservas.setLayout(new GridLayout(8, 2, 10, 10));
			
		panelReservas.add(nombreLabel);
		nombreEd = new JTextField(20);
		panelReservas.add(nombreEd);
		nombreEd.setEditable(false);

		panelReservas.add(apellidoLabel);
		apellidoEd = new JTextField(20);
		panelReservas.add(apellidoEd);
		apellidoEd.setEditable(false);
		
		panelReservas.add(dniLabel);
		dniEd = new JTextField(20);
		panelReservas.add(dniEd);
		dniEd.setEditable(false);
		
		panelReservas.add(numTelefonoLabel);
		numTelefonoEd = new JTextField(20);
		panelReservas.add(numTelefonoEd);
		numTelefonoEd.setEditable(false);
		
		panelReservas.add(correoElectronicoLabel);
		correoElectronicoEd = new JTextField(20);
		panelReservas.add(correoElectronicoEd);
		correoElectronicoEd.setEditable(false);
		
		panelReservas.add(comensalesLabel);
		comensalesEd = new JTextField(20);
		panelReservas.add(comensalesEd);
		comensalesEd.setEditable(false);
		
		panelReservas.add(fechaHoraLabel);
		fechaHoraEd = new JTextField(20);
		panelReservas.add(fechaHoraEd);
		fechaHoraEd.setEditable(false);
			
		panelReservas.add(botonSeleccion);
			
		panelReservas.add(actualizar);

		actualizar.addActionListener(this);

		return panelReservas;
	}

	
	private JPanel crearPanelEliminarReserva() {
		JPanel panelReservas = new JPanel(new BorderLayout());
		
		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel comensalesLabel = new JLabel("Número de comensales");
		JLabel fechaHoraLabel = new JLabel("Fecha y Hora");;
		
		eliminar = new JButton("Eliminar Reserva");
			
		botonSeleccionEliminar = new JButton("Seleccionar Reserva");
		botonSeleccionEliminar.addActionListener(this);
		panelReservas.setLayout(new GridLayout(8, 2, 10, 10));
			
		panelReservas.add(nombreLabel);
		nombreEd = new JTextField(20);
		panelReservas.add(nombreEd);
		nombreEd.setEditable(false);

		panelReservas.add(apellidoLabel);
		apellidoEd = new JTextField(20);
		panelReservas.add(apellidoEd);
		apellidoEd.setEditable(false);
		
		panelReservas.add(dniLabel);
		dniEd = new JTextField(20);
		panelReservas.add(dniEd);
		dniEd.setEditable(false);
		
		panelReservas.add(numTelefonoLabel);
		numTelefonoEd = new JTextField(20);
		panelReservas.add(numTelefonoEd);
		numTelefonoEd.setEditable(false);
		
		panelReservas.add(correoElectronicoLabel);
		correoElectronicoEd = new JTextField(20);
		panelReservas.add(correoElectronicoEd);
		correoElectronicoEd.setEditable(false);
		
		panelReservas.add(comensalesLabel);
		comensalesEd = new JTextField(20);
		panelReservas.add(comensalesEd);
		comensalesEd.setEditable(false);
		
		panelReservas.add(fechaHoraLabel);
		fechaHoraEd = new JTextField(20);
		panelReservas.add(fechaHoraEd);
		fechaHoraEd.setEditable(false);
			
		panelReservas.add(botonSeleccionEliminar);
			
		panelReservas.add(eliminar);

		eliminar.addActionListener(this);

		return panelReservas;
	}
	
	
	private JPanel crearPanelMostrarMenu() {
		// TODO Auto-generated method stub
		JPanel panelMostrarMenu = new JPanel(new BorderLayout());
	    panelMostrarMenu.setPreferredSize(new Dimension(700, 100));
	    actualizarListaMenu(panelMostrarMenu);
	    return panelMostrarMenu;
	}

	
	private void actualizarListaMenu(JPanel panelActualizado) {
		ArrayList<MenuVO> menus = empleadoControlador.getMenus();

	    tableModel = new DefaultTableModel();
	    tableModel.addColumn("ID");
	    tableModel.addColumn("PrimerPlato");
	    tableModel.addColumn("SegundoPlato");
	    tableModel.addColumn("Postre");
	    tableModel.addColumn("Bebida");
	    tableModel.addColumn("Precio");

	    for (MenuVO menu : menus) {
	        tableModel.addRow(new Object[] {
        		menu.getIdMenu(),
        		menu.getPrimerPlato(),
        		menu.getSegundoPlato(),
        		menu.getPostre(),
        		menu.getBebida(),
        		menu.getPrecio(),
	        });
	    }

	    if (catalogTable != null) {
	        // Si la tabla ya existe, la eliminamos para agregar la nueva
	        panelActualizado.remove(new JScrollPane(catalogTable));
	    }

	    catalogTable = new JTable(tableModel);
	    JScrollPane scrollPane = new JScrollPane(catalogTable);
	    panelActualizado.add(scrollPane);
	    
	    panelMenus.add(panelActualizado);

	    this.panelMenus.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== this.btnCerrarSesion) {
    		int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar sesión?", 
                    "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0); // Cerrar la aplicación
            }
            
    	} else if (e.getSource() == this.aniadir) {
			String name = nombre.getText();
			String ape = apellido.getText();
			String dn = dni.getText();
			int num = Integer.parseInt(numTelefono.getText());
			String cor = correoElectronico.getText();
			int com = Integer.parseInt(comensales.getText());
			String feho = fechaHora.getText();

			ReservaVO r = new ReservaVO(0, name, ape, dn, num, cor, com, feho);
			empleadoControlador.addReserva(r);
			crearPanelMostrarReserva();
			
			nombre.setText("");
			apellido.setText("");
			dni.setText("");
			numTelefono.setText("");
			correoElectronico.setText("");
			comensales.setText("");
			fechaHora.setText("");
			
		} else  if (e.getSource() == this.botonSeleccion) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id de la reserva a modificar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ninguna reserva");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			r = empleadoControlador.getReserva(id);
			
			if (r == null) {
				JOptionPane.showMessageDialog(this, "No existe la reserva");
				return;
			}
			
			nombreEd.setText(r.getNombre());
			nombreEd.setEditable(true);
			apellidoEd.setText(r.getApellido() + "");
			apellidoEd.setEditable(true);
			dniEd.setText(r.getDni() + "");
			dniEd.setEditable(true);
			numTelefonoEd.setText(r.getTelefono() + "");
			numTelefonoEd.setEditable(true);
			correoElectronicoEd.setText(r.getCorreo() + "");
			correoElectronicoEd.setEditable(true);
			comensalesEd.setText(r.getComensales() + "");
			comensalesEd.setEditable(true);
			fechaHoraEd.setText(r.getFechaHora() + "");
			fechaHoraEd.setEditable(true);

		} else if (e.getSource() == this.actualizar) {
			String name = nombreEd.getText();
			String ape = apellidoEd.getText();
			String dn = dniEd.getText();
			int num = Integer.parseInt(numTelefonoEd.getText());
			String cor = correoElectronicoEd.getText();
			int com = Integer.parseInt(comensalesEd.getText());
			String feho = fechaHoraEd.getText();
			
			r.setNombre(name);
			r.setApellido(ape);
			r.setDni(dn);
			r.setTelefono(num);
			r.setCorreo(cor);
			r.setComensales(com);
			r.setFechaHora(feho);

			empleadoControlador.updateReserva(r);
			
			nombreEd.setEditable(false);
			nombreEd.setText(r.getNombre());
			apellidoEd.setEditable(false);
			apellidoEd.setText(r.getApellido() + "");
			dniEd.setEditable(false);
			dniEd.setText(r.getDni() + "");
			numTelefonoEd.setEditable(false);
			numTelefonoEd.setText(r.getTelefono() + "");
			correoElectronicoEd.setEditable(false);
			correoElectronicoEd.setText(r.getCorreo() + "");
			comensalesEd.setEditable(false);
			comensalesEd.setText(r.getComensales() + "");
			fechaHoraEd.setEditable(false);
			fechaHoraEd.setText(r.getFechaHora() + "");
			
			crearPanelMostrarReserva();
			
		} else if (e.getSource() == this.botonSeleccionEliminar) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id de la reserva a eliminar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ninguna reserva");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			r = empleadoControlador.getReserva(id);
			
			if (r == null) {
				JOptionPane.showMessageDialog(this, "No existe la reserva");
				return;
			}
			
			nombreEd.setText(r.getNombre());
			nombreEd.setEditable(false);
			apellidoEd.setText(r.getApellido() + "");
			apellidoEd.setEditable(false);
			dniEd.setText(r.getDni() + "");
			dniEd.setEditable(false);
			numTelefonoEd.setText(r.getTelefono() + "");
			numTelefonoEd.setEditable(false);
			correoElectronicoEd.setText(r.getCorreo() + "");
			correoElectronicoEd.setEditable(false);
			comensalesEd.setText(r.getComensales() + "");
			comensalesEd.setEditable(false);
			fechaHoraEd.setText(r.getFechaHora() + "");
			fechaHoraEd.setEditable(false);

		} else if (e.getSource() == this.eliminar) {
			
			
			
			
		} else {
			
		}
    }

	
}
