package AlquilerVehiculos.mvc.controlador;

import AlquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Vehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
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
	
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		modelo.anadirVehiculo(vehiculo, tipoVehiculo);
	}
	
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}
	
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}
	
	public Vehiculo[] obtenerVehiculos() {
		return modelo.obtenerVehiculos();
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
	
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
	}
	
	public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.cerrarAlquiler(cliente, vehiculo);
	}
	
	public Alquiler[] obtenerAlquileres() {
		return modelo.obtenerAlquileres();
	}
	
	public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
	}
	
}
