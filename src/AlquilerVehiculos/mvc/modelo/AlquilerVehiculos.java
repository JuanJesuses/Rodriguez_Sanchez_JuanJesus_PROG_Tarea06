package AlquilerVehiculos.mvc.modelo;

import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Turismos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;

public class AlquilerVehiculos {
	
	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	public AlquilerVehiculos() {
		
		clientes = new Clientes();
		turismos = new Turismos();
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
	
	public void anadirTurismo (Turismo turismo) {
		turismos.anadirTurismo(turismo);
	}
	
	public void borrarTurismo(String matricula) {
		turismos.borrarTurismo(matricula);
	}
	
	public Turismo buscarTurismo (String matricula) {
		return turismos.buscarTurismo(matricula);
	}
	
	public Turismo[] obtenerTurismos() {
		return turismos.getTurismos();
	}
	
	public void abrirAlquiler (Cliente cliente, Turismo turismo) {
		alquileres.abrirAlquiler(cliente, turismo);
	}
	
	public void cerrarAlquiler (Cliente cliente, Turismo turismo) {
		alquileres.cerrarAlquiler(cliente, turismo);
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
		
		Turismo turismo1 = new Turismo ("4512BCD", "Opel", "Astra", 1100);
		Turismo turismo2 = new Turismo ("7628HKG", "Citröen", "Xsara", 1900);
		Turismo turismo3 = new Turismo ("2356CDH", "Hyunday", "Elantra", 1600);
		
		anadirTurismo(turismo1);
		anadirTurismo(turismo2);
		anadirTurismo(turismo3);
		
		abrirAlquiler(cliente1, turismo1);
		abrirAlquiler(cliente2, turismo2);
		abrirAlquiler(cliente3, turismo3);
		
	}

}
