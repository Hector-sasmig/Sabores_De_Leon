package main.java.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.java.controladores.GerenteControlador;
import main.java.modelo.vo.EmpleadoVO;
import main.java.modelo.vo.MenuVO;



public class GerenteVista extends JFrame implements ActionListener {

    private GerenteControlador gerenteControlador;
	
    private DefaultTableModel tableModel;
    private JTabbedPane pestanasPrincipales;
    private JPanel panelMenus, panelEmpleados, panelCerrarSesion;
    private JTabbedPane pestanasMenus, pestanasEmpleados;
    
    JButton aniadirMenu, actualizarMenu, eliminarMenu, botonSeleccionMenu, botonSeleccionEliminarMenu;
    MenuVO m;
    JTextField primerPlato, segundoPlato, postre, bebida, precio;
	JTextField primerPlatoEd, segundoPlatoEd, postreEd, bebidaEd, precioEd;
	JTextField primerPlatoEdEl, segundoPlatoEdEl, postreEdEl, bebidaEdEl, precioEdEl;
	
    JButton aniadirEmpl, actualizarEmpl, eliminarEmpl, botonSeleccionEmpl, botonSeleccionEliminarEmpl;
	EmpleadoVO em;
	JTextField nombre, apellido, dni, numTelefono, correoElectronico, tipo, contrasenia;
	JTextField nombreEd, apellidoEd, dniEd, numTelefonoEd, correoElectronicoEd, tipoEd, contraseniaEd;
	JTextField nombreEdEl, apellidoEdEl, dniEdEl, numTelefonoEdEl, correoElectronicoEdEl, tipoEdEl, contraseniaEdEl;
	
	JTable catalogTable;
	JButton btnCerrarSesion;
	
	public GerenteVista() {
        this.gerenteControlador = new GerenteControlador();

        setTitle("Sistema de Gerente");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el TabbedPane principal
        pestanasPrincipales = new JTabbedPane();

        // Panel de Menus
        panelMenus = new JPanel();
        panelMenus.setBackground(new Color(190, 148, 250));
        pestanasMenus = new JTabbedPane();
        crearSubPestañasMenus();
        pestanasMenus.setTabPlacement(JTabbedPane.NORTH);
        panelMenus.add(pestanasMenus);

        // Panel de Empleados
        panelEmpleados = new JPanel();
        panelEmpleados.setBackground(new Color(190, 148, 250));
        pestanasEmpleados = new JTabbedPane();
        crearSubPestañasEmpleados();
        pestanasEmpleados.setTabPlacement(JTabbedPane.NORTH);
        panelEmpleados.add(pestanasEmpleados);

        // Panel de Cerrar Sesión
        panelCerrarSesion = new JPanel();
        panelCerrarSesion.setBackground(new Color(190, 148, 250));
        panelCerrarSesion.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setPreferredSize(new Dimension(200, 50));
        btnCerrarSesion.addActionListener(this);
        panelCerrarSesion.add(btnCerrarSesion);

        // Añadir las pestañas principales
        pestanasPrincipales.addTab("Menús", panelMenus);
        pestanasPrincipales.addTab("Empleados", panelEmpleados);
        pestanasPrincipales.addTab("Cerrar sesión", panelCerrarSesion);

        // Agregar el TabbedPane al JFrame
        add(pestanasPrincipales);

        setVisible(true);
	}
	
	/*******************************************************************************************/
	
	private void crearSubPestañasMenus() {
		JPanel panelAniadir = crearPanelAñadirMenu();
	    JPanel panelModificar = crearPanelModificarMenu();
	    JPanel panelEliminar = crearPanelEliminarMenu();
	    
	    pestanasMenus.addTab("Añadir", panelAniadir);
	    pestanasMenus.addTab("Modificar", panelModificar);
	    pestanasMenus.addTab("Eliminar", panelEliminar);
	}

	private JPanel crearPanelAñadirMenu() {
    	JPanel panelMenus = new JPanel(new BorderLayout());

		JLabel primerPlatoLabel = new JLabel("Primer plato");
		JLabel segundoPlatoLabel = new JLabel("Segundo plato");
		JLabel postreLabel = new JLabel("Postre");
		JLabel bebidaLabel = new JLabel("Bebida");
		JLabel precioLabel = new JLabel("Precio");
		
		aniadirMenu = new JButton("Añadir");
		
		panelMenus.setLayout(new GridLayout(6, 2, 10, 10));
		
		panelMenus.add(primerPlatoLabel);
		primerPlato = new JTextField(20);
		panelMenus.add(primerPlato);

		panelMenus.add(segundoPlatoLabel);
		segundoPlato = new JTextField(20);
		panelMenus.add(segundoPlato);
		
		panelMenus.add(postreLabel);
		postre = new JTextField(20);
		panelMenus.add(postre);

		panelMenus.add(bebidaLabel);
		bebida = new JTextField(20);
		panelMenus.add(bebida);
		
		panelMenus.add(precioLabel);
		precio = new JTextField(20);
		panelMenus.add(precio);
			
		panelMenus.add(aniadirMenu);

		aniadirMenu.addActionListener(this);

		return panelMenus;
	}
    

	private JPanel crearPanelModificarMenu() {
		JPanel panelMenus = new JPanel(new BorderLayout());
		
		JLabel primerPlatoLabel = new JLabel("Primer plato");
		JLabel segundoPlatoLabel = new JLabel("Segundo plato");
		JLabel postreLabel = new JLabel("Postre");
		JLabel bebidaLabel = new JLabel("Bebida");
		JLabel precioLabel = new JLabel("Precio");
		
		actualizarMenu = new JButton("Actualizar Datos");
			
		botonSeleccionMenu = new JButton("Seleccionar Menu");
		botonSeleccionMenu.addActionListener(this);
		panelMenus.setLayout(new GridLayout(6, 2, 10, 10));
			
		panelMenus.add(primerPlatoLabel);
		primerPlatoEd = new JTextField(20);
		panelMenus.add(primerPlatoEd);
		primerPlatoEd.setEditable(false);
		
		panelMenus.add(segundoPlatoLabel);
		segundoPlatoEd = new JTextField(20);
		panelMenus.add(segundoPlatoEd);
		segundoPlatoEd.setEditable(false);
		
		panelMenus.add(postreLabel);
		postreEd = new JTextField(20);
		panelMenus.add(postreEd);
		postreEd.setEditable(false);

		panelMenus.add(bebidaLabel);
		bebidaEd = new JTextField(20);
		panelMenus.add(bebidaEd);
		bebidaEd.setEditable(false);
		
		panelMenus.add(precioLabel);
		precioEd = new JTextField(20);
		panelMenus.add(precioEd);
		precioEd.setEditable(false);
			
		panelMenus.add(botonSeleccionMenu);
			
		panelMenus.add(actualizarMenu);

		actualizarMenu.addActionListener(this);

		return panelMenus;
	}

	
	private JPanel crearPanelEliminarMenu() {
		JPanel panelMenus = new JPanel(new BorderLayout());
		
		JLabel primerPlatoLabel = new JLabel("Primer plato");
		JLabel segundoPlatoLabel = new JLabel("Segundo plato");
		JLabel postreLabel = new JLabel("Postre");
		JLabel bebidaLabel = new JLabel("Bebida");
		JLabel precioLabel = new JLabel("Precio");
		
		eliminarMenu = new JButton("Eliminar Menu");
			
		botonSeleccionEliminarMenu = new JButton("Seleccionar Menu");
		botonSeleccionEliminarMenu.addActionListener(this);
		panelMenus.setLayout(new GridLayout(6, 2, 10, 10));
			
		panelMenus.add(primerPlatoLabel);
		primerPlatoEdEl = new JTextField(20);
		panelMenus.add(primerPlatoEdEl);
		primerPlatoEdEl.setEditable(false);
		
		panelMenus.add(segundoPlatoLabel);
		segundoPlatoEdEl = new JTextField(20);
		panelMenus.add(segundoPlatoEdEl);
		segundoPlatoEdEl.setEditable(false);
		
		panelMenus.add(postreLabel);
		postreEdEl = new JTextField(20);
		panelMenus.add(postreEdEl);
		postreEdEl.setEditable(false);

		panelMenus.add(bebidaLabel);
		bebidaEdEl = new JTextField(20);
		panelMenus.add(bebidaEdEl);
		bebidaEdEl.setEditable(false);
		
		panelMenus.add(precioLabel);
		precioEdEl = new JTextField(20);
		panelMenus.add(precioEdEl);
		precioEdEl.setEditable(false);
			
		panelMenus.add(botonSeleccionEliminarMenu);
			
		panelMenus.add(eliminarMenu);

		eliminarMenu.addActionListener(this);

		return panelMenus;
	}

	/*******************************************************************************************/
	
	private void crearSubPestañasEmpleados() {
		JPanel panelMostrar = crearPanelMostrarEmpleado();
		JPanel panelAniadir = crearPanelAñadirEmpleado();
	    JPanel panelModificar = crearPanelModificarEmpleado();
	    JPanel panelEliminar = crearPanelEliminarEmpleado();
	    
	    pestanasEmpleados.addTab("Mostrar", panelMostrar);
	    pestanasEmpleados.addTab("Añadir", panelAniadir);
	    pestanasEmpleados.addTab("Modificar", panelModificar);
	    pestanasEmpleados.addTab("Eliminar", panelEliminar);
	}

	private JPanel crearPanelMostrarEmpleado() {
		JPanel panelMostrarEmpleado = new JPanel(new BorderLayout());
		panelMostrarEmpleado.setPreferredSize(new Dimension(700, 200));
	    actualizarListaEmpleado(panelMostrarEmpleado);
	    return panelMostrarEmpleado;
		
	}
	
    private void actualizarListaEmpleado(JPanel panelActualizado) {
		ArrayList<EmpleadoVO> empleados = gerenteControlador.getEmpleados();

	    tableModel = new DefaultTableModel();
	    tableModel.addColumn("ID");
	    tableModel.addColumn("Nombre");
	    tableModel.addColumn("Apellido");
	    tableModel.addColumn("DNI");
	    tableModel.addColumn("Teléfono");
	    tableModel.addColumn("Correo");
	    tableModel.addColumn("Tipo");
	    tableModel.addColumn("Contraseña");

	    for (EmpleadoVO empleado : empleados) {
	        tableModel.addRow(new Object[] {
        		empleado.getIdEmpleado(),
        		empleado.getNombre(),
        		empleado.getApellido(),
        		empleado.getDni(),
        		empleado.getTelefono(),
        		empleado.getCorreo(),
        		empleado.getTipo(),
        		empleado.getContrasena(),
	        });
	    }

	    if (catalogTable != null) {
	        // Si la tabla ya existe, la eliminamos para agregar la nueva
	        panelActualizado.remove(new JScrollPane(catalogTable));
	    }

	    catalogTable = new JTable(tableModel);
	    JScrollPane scrollPane = new JScrollPane(catalogTable);
	    panelActualizado.add(scrollPane);
	    
	    if (pestanasEmpleados.getTabCount() > 0) {
	    	pestanasEmpleados.setComponentAt(0, panelActualizado);
	    	
	    } else {
	    	pestanasEmpleados.addTab("Lista Empleados", panelActualizado);
	    }

	    this.pestanasEmpleados.setVisible(true);
		
	}
    
	private JPanel crearPanelAñadirEmpleado() {
		JPanel panelEmpleados = new JPanel(new BorderLayout());

		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel tipoLabel = new JLabel("Tipo");
		JLabel contraLabel = new JLabel("Contraseña");
		
		aniadirEmpl = new JButton("Añadir");
		
		panelEmpleados.setLayout(new GridLayout(8, 2, 10, 10));
		
		panelEmpleados.add(nombreLabel);
		nombre = new JTextField(20);
		panelEmpleados.add(nombre);

		panelEmpleados.add(apellidoLabel);
		apellido = new JTextField(20);
		panelEmpleados.add(apellido);
		
		panelEmpleados.add(dniLabel);
		dni = new JTextField(20);
		panelEmpleados.add(dni);

		panelEmpleados.add(numTelefonoLabel);
		numTelefono = new JTextField(20);
		panelEmpleados.add(numTelefono);
		
		panelEmpleados.add(correoElectronicoLabel);
		correoElectronico = new JTextField(20);
		panelEmpleados.add(correoElectronico);
		
		panelEmpleados.add(tipoLabel);
		tipo = new JTextField(20);
		panelEmpleados.add(tipo);
		
		panelEmpleados.add(contraLabel);
		contrasenia = new JTextField(20);
		panelEmpleados.add(contrasenia);
			
		panelEmpleados.add(aniadirEmpl);

		aniadirEmpl.addActionListener(this);

		return panelEmpleados;
	}


	private JPanel crearPanelModificarEmpleado() {
		JPanel panelEmpleados = new JPanel(new BorderLayout());
		
		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel tipoLabel = new JLabel("Tipo");
		JLabel contraLabel = new JLabel("Contraseña");
		
		actualizarEmpl = new JButton("Actualizar Datos");
			
		botonSeleccionEmpl = new JButton("Seleccionar Empleado");
		botonSeleccionEmpl.addActionListener(this);
		panelEmpleados.setLayout(new GridLayout(8, 2, 10, 10));
			
		panelEmpleados.add(nombreLabel);
		nombreEd = new JTextField(20);
		panelEmpleados.add(nombreEd);
		nombreEd.setEditable(false);

		panelEmpleados.add(apellidoLabel);
		apellidoEd = new JTextField(20);
		panelEmpleados.add(apellidoEd);
		apellidoEd.setEditable(false);
		
		panelEmpleados.add(dniLabel);
		dniEd = new JTextField(20);
		panelEmpleados.add(dniEd);
		dniEd.setEditable(false);

		panelEmpleados.add(numTelefonoLabel);
		numTelefonoEd = new JTextField(20);
		panelEmpleados.add(numTelefonoEd);
		numTelefonoEd.setEditable(false);
		
		panelEmpleados.add(correoElectronicoLabel);
		correoElectronicoEd = new JTextField(20);
		panelEmpleados.add(correoElectronicoEd);
		correoElectronicoEd.setEditable(false);
		
		panelEmpleados.add(tipoLabel);
		tipoEd = new JTextField(20);
		panelEmpleados.add(tipoEd);
		tipoEd.setEditable(false);
		
		panelEmpleados.add(contraLabel);
		contraseniaEd = new JTextField(20);
		panelEmpleados.add(contraseniaEd);
		contraseniaEd.setEditable(false);
		
		panelEmpleados.add(botonSeleccionEmpl);
			
		panelEmpleados.add(actualizarEmpl);

		actualizarEmpl.addActionListener(this);

		return panelEmpleados;
	}


	private JPanel crearPanelEliminarEmpleado() {
		JPanel panelEmpleados = new JPanel(new BorderLayout());
		
		JLabel nombreLabel = new JLabel("Nombre");
		JLabel apellidoLabel = new JLabel("Apellido");
		JLabel dniLabel = new JLabel("DNI");
		JLabel numTelefonoLabel = new JLabel("Numero de telefono");
		JLabel correoElectronicoLabel = new JLabel("Correo Electronico");
		JLabel tipoLabel = new JLabel("Tipo");
		JLabel contraLabel = new JLabel("Contraseña");
		
		eliminarEmpl = new JButton("Eliminar Empleado");
			
		botonSeleccionEliminarEmpl = new JButton("Seleccionar Empleado");
		botonSeleccionEliminarEmpl.addActionListener(this);
		panelEmpleados.setLayout(new GridLayout(8, 2, 10, 10));
			
		panelEmpleados.add(nombreLabel);
		nombreEdEl = new JTextField(20);
		panelEmpleados.add(nombreEdEl);
		nombreEdEl.setEditable(false);

		panelEmpleados.add(apellidoLabel);
		apellidoEdEl = new JTextField(20);
		panelEmpleados.add(apellidoEdEl);
		apellidoEdEl.setEditable(false);
		
		panelEmpleados.add(dniLabel);
		dniEdEl = new JTextField(20);
		panelEmpleados.add(dniEdEl);
		dniEdEl.setEditable(false);

		panelEmpleados.add(numTelefonoLabel);
		numTelefonoEdEl = new JTextField(20);
		panelEmpleados.add(numTelefonoEdEl);
		numTelefonoEdEl.setEditable(false);
		
		panelEmpleados.add(correoElectronicoLabel);
		correoElectronicoEdEl = new JTextField(20);
		panelEmpleados.add(correoElectronicoEdEl);
		correoElectronicoEdEl.setEditable(false);
		
		panelEmpleados.add(tipoLabel);
		tipoEdEl = new JTextField(20);
		panelEmpleados.add(tipoEdEl);
		tipoEdEl.setEditable(false);
		
		panelEmpleados.add(contraLabel);
		contraseniaEdEl = new JTextField(20);
		panelEmpleados.add(contraseniaEdEl);
		contraseniaEdEl.setEditable(false);
		
		panelEmpleados.add(botonSeleccionEliminarEmpl);
			
		panelEmpleados.add(eliminarEmpl);

		eliminarEmpl.addActionListener(this);

		return panelEmpleados;
	}
	
	/*******************************************************************************************/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btnCerrarSesion) {
    		int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres cerrar sesión?", 
                    "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0); // Cerrar la aplicación
            }
            
    	} else if (e.getSource() == this.aniadirMenu) {
			String pp = primerPlato.getText();
			String sp = segundoPlato.getText();
			String pos = postre.getText();
			String beb = bebida.getText();
			int pre = Integer.parseInt(precio.getText());
			
			MenuVO m = new MenuVO(0, pp, sp, pos, beb, pre);
			gerenteControlador.aniadirMenu(m);
			
			primerPlato.setText("");
			segundoPlato.setText("");
			postre.setText("");
			bebida.setText("");
			precio.setText("");
			
		} else  if (e.getSource() == this.botonSeleccionMenu) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id del menú a modificar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ningún menú");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			m = gerenteControlador.getMenu(id);
			
			if (m == null) {
				JOptionPane.showMessageDialog(this, "No existe el menú");
				return;
			}
			
			primerPlatoEd.setText(m.getPrimerPlato() + "");
			primerPlatoEd.setEditable(true);
			segundoPlatoEd.setText(m.getSegundoPlato() + "");
			segundoPlatoEd.setEditable(true);
			postreEd.setText(m.getPostre() + "");
			postreEd.setEditable(true);
			bebidaEd.setText(m.getBebida() + "");
			bebidaEd.setEditable(true);
			precioEd.setText(m.getPrecio() + "");
			precioEd.setEditable(true);

		} else if (e.getSource() == this.actualizarMenu) {
			String pp = primerPlatoEd.getText();
			String sp = segundoPlatoEd.getText();
			String pos = postreEd.getText();
			String beb = bebidaEd.getText();
			float pre = Float.parseFloat(precioEd.getText());
			System.out.println(pre);
			
			m.setPrimerPlato(pp);
			m.setSegundoPlato(sp);
			m.setPostre(pos);
			m.setBebida(beb);
			m.setPrecio(pre);

			gerenteControlador.actualizarMenu(m);
			
			primerPlatoEd.setEditable(false);
			primerPlatoEd.setText(m.getPrimerPlato() + "");
			segundoPlatoEd.setEditable(false);
			segundoPlatoEd.setText(m.getSegundoPlato() + "");
			postreEd.setEditable(false);
			postreEd.setText(m.getPostre() + "");
			bebidaEd.setEditable(false);
			bebidaEd.setText(m.getBebida() + "");
			precioEd.setEditable(false);
			precioEd.setText(m.getPrecio() + "");
			
			
		} else if (e.getSource() == this.botonSeleccionEliminarMenu) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id del menú a eliminar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ningún menú");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			m = gerenteControlador.getMenu(id);
			
			if (m == null) {
				JOptionPane.showMessageDialog(this, "No existe el menú");
				return;
			}
			
			primerPlatoEdEl.setText(m.getPrimerPlato() + "");
			primerPlatoEdEl.setEditable(false);
			segundoPlatoEdEl.setText(m.getSegundoPlato() + "");
			segundoPlatoEdEl.setEditable(false);
			postreEdEl.setText(m.getPostre() + "");
			postreEdEl.setEditable(false);
			bebidaEdEl.setText(m.getBebida() + "");
			bebidaEdEl.setEditable(false);
			precioEdEl.setText(m.getPrecio() + "");
			precioEdEl.setEditable(false);
			

		} else if (e.getSource() == this.eliminarMenu) {
			
			
			
			
		} else if (e.getSource() == this.aniadirEmpl) {
			String name = nombre.getText();
			String ape = apellido.getText();
			String dn = dni.getText();
			int num = Integer.parseInt(numTelefono.getText());
			String cor = correoElectronico.getText();
			String tip = tipo.getText();
			String ctr = contrasenia.getText();
			
			EmpleadoVO em = new EmpleadoVO(0, name, ape, dn, num, cor, tip, ctr);
			gerenteControlador.aniadirEmpleado(em);
			crearPanelMostrarEmpleado();

			nombre.setText("");
			apellido.setText("");
			dni.setText("");
			numTelefono.setText("");
			correoElectronico.setText("");
			tipo.setText("");
			contrasenia.setText("");
			
		} else  if (e.getSource() == this.botonSeleccionEmpl) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id del empleado a modificar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ningún empleado");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			em = gerenteControlador.getEmpleado(id);
			
			if (em == null) {
				JOptionPane.showMessageDialog(this, "No existe el empleado");
				return;
			}
			
			nombreEd.setText(em.getNombre() + "");
			nombreEd.setEditable(true);
			apellidoEd.setText(em.getApellido() + "");
			apellidoEd.setEditable(true);
			dniEd.setText(em.getDni() + "");
			dniEd.setEditable(true);
			numTelefonoEd.setText(em.getTelefono() + "");
			numTelefonoEd.setEditable(true);
			correoElectronicoEd.setText(em.getCorreo() + "");
			correoElectronicoEd.setEditable(true);
			tipoEd.setText(em.getTipo() + "");
			tipoEd.setEditable(true);
			contraseniaEd.setText(em.getContrasena() + "");
			contraseniaEd.setEditable(true);

		} else if (e.getSource() == this.actualizarEmpl) {
			String name = nombreEd.getText();
			String ape = apellidoEd.getText();
			String dn = dniEd.getText();
			int num = Integer.parseInt(numTelefonoEd.getText());
			String cor = correoElectronicoEd.getText();
			String tip = tipoEd.getText();
			String ctr = contraseniaEd.getText();
			
			em.setNombre(name);
			em.setApellido(ape);
			em.setDni(dn);
			em.setTelefono(num);
			em.setCorreo(cor);
			em.setTipo(tip);
			em.setContrasena(ctr);

			gerenteControlador.actualizarEmpleado(em);
			
			nombreEd.setEditable(false);
			nombreEd.setText(em.getNombre() + "");
			apellidoEd.setEditable(false);
			apellidoEd.setText(em.getApellido() + "");
			dniEd.setEditable(false);
			dniEd.setText(em.getDni() + "");
			numTelefonoEd.setEditable(false);
			numTelefonoEd.setText(em.getTelefono() + "");
			correoElectronicoEd.setEditable(false);
			correoElectronicoEd.setText(em.getCorreo() + "");
			tipoEd.setEditable(false);
			tipoEd.setText(em.getTipo() + "");
			contraseniaEd.setEditable(false);
			contraseniaEd.setText(em.getContrasena() + "");
			
			crearPanelMostrarEmpleado();
			
		} else if (e.getSource() == this.botonSeleccionEliminarEmpl) {
			String idtxt = JOptionPane.showInputDialog("Introduce el id del empleado a eliminar");
			if (idtxt.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No seleccionaste ningún empleado");
				return;
			}
			
			int id = Integer.parseInt(idtxt);
			em = gerenteControlador.getEmpleado(id);
			
			if (em == null) {
				JOptionPane.showMessageDialog(this, "No existe el empleado");
				return;
			}
			
			nombreEdEl.setText(em.getNombre() + "");
			nombreEdEl.setEditable(false);
			apellidoEdEl.setText(em.getApellido() + "");
			apellidoEdEl.setEditable(false);
			dniEdEl.setText(em.getDni() + "");
			dniEdEl.setEditable(false);
			numTelefonoEdEl.setText(em.getTelefono() + "");
			numTelefonoEdEl.setEditable(false);
			correoElectronicoEdEl.setText(em.getCorreo() + "");
			correoElectronicoEdEl.setEditable(false);
			tipoEdEl.setText(em.getTipo() + "");
			tipoEdEl.setEditable(false);
			contraseniaEdEl.setText(em.getContrasena() + "");
			contraseniaEdEl.setEditable(false);
			

		} else if (e.getSource() == this.eliminarEmpl) {
			
			
			
			
		} 
    }


	
}

	
