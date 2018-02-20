package AlquilerVehiculos.mvc.modelo;

import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Vehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class AlquilerVehiculos {
	
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;
	
	public AlquilerVehiculos() {
		
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
		
	}
	
	public void anadirCliente (Cliente cliente) {
		clientes.anadirCliente(cliente);
	}
	
	public void borrarCliente (String dni) {
		clientes.borrarCliente(dni);
	}
	
	public Cliente buscarCliente (String dni) {
		return clientes.buscarCliente(dni);
	}
	
	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}
	
	public void anadirVehiculo (Vehiculo vehiculo) {
		vehiculos.anadirVehiculo(vehiculo);
	}
	
	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}
	
	public Vehiculo buscarVehiculo (String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}
	
	public Vehiculo[] obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}
	
	public void abrirAlquiler (Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}
	
	public void cerrarAlquiler (Cliente cliente, Vehiculo vehiculo) {
		alquileres.cerrarAlquiler(cliente, vehiculo);
	}
	
	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}
	
	public void anadirDatosPrueba() {
		
		Cliente cliente1 = new Cliente ("Bilbo Bolsón", "12345678A", new DireccionPostal("C/La Runa, 32", "Bolsón Cerrado", "01005"));
		Cliente cliente2 = new Cliente ("Meriadoc Brandigamo", "23456789B", new DireccionPostal("C/La Runa, 72", "Hobbitón", "63541"));
		Cliente cliente3 = new Cliente ("Peregrin Tuc", "34567890C", new DireccionPostal("C/La Runa, 29", "Bolsón Cerrado", "22456"));
		
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		anadirCliente(cliente3);
		
		Vehiculo vehiculo1 = new Vehiculo ("4512BCD", "Opel", "Astra", new DatosTecnicosVehiculos (1100, 5, 3500));
		Vehiculo vehiculo2 = new Vehiculo ("7628HKG", "Citröen", "Xsara", new DatosTecnicosVehiculos (1900, 7, 3500));
		Vehiculo vehiculo3 = new Vehiculo ("2356CDH", "Hyunday", "Elantra", new DatosTecnicosVehiculos (1600, 5, 3500));
		
		anadirVehiculo(vehiculo1);
		anadirVehiculo(vehiculo2);
		anadirVehiculo(vehiculo3);
		
		abrirAlquiler(cliente1, vehiculo1);
		abrirAlquiler(cliente2, vehiculo2);
		abrirAlquiler(cliente3, vehiculo3);
		
	}

}
