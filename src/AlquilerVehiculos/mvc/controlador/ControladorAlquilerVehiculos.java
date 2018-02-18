package AlquilerVehiculos.mvc.controlador;

import AlquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Turismos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;
import AlquilerVehiculos.mvc.vista.IUTextual;

public class ControladorAlquilerVehiculos {
	
	AlquilerVehiculos modelo;
	IUTextual vista;
	
	public ControladorAlquilerVehiculos(AlquilerVehiculos modelo, IUTextual vista) {
		this.vista = vista;
		this.modelo =modelo;
		vista.setControlador(this);
	}
	
	public void comenzar() {
		modelo.anadirDatosPrueba();
		vista.comenzar();
	}
	
	public void anadirTurismo(Turismo turismo) {
		modelo.anadirTurismo(turismo);
	}
	
	public void borrarTurismo(String matricula) {
		modelo.borrarTurismo(matricula);
	}
	
	public Turismo buscarTurismo(String matricula) {
		return modelo.buscarTurismo(matricula);
	}
	
	public Turismo[] obtenerTurismos() {
		return modelo.obtenerTurismos();
	}
	
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}
	
	public void borrarCliente (String dni) {
		modelo.borrarCliente(dni);
	}
	
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}
	
	public Cliente[] obtenerClientes() {
		return modelo.obtenerClientes();
	}
	
	public void abrirAlquiler(Cliente cliente, Turismo turismo) {
		modelo.abrirAlquiler(cliente, turismo);
	}
	
	public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
		modelo.cerrarAlquiler(cliente, turismo);
	}
	
	public Alquiler[] obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}
	
	public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
	}
	
}
