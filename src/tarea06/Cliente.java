package tarea06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String nombre;
	private String dni;
	private String direccion;
	private String localidad;
	private String codigoPostal;
	private int identificador;
	private static int numClientes;
	
	public Cliente(Cliente cliente) {
		
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		direccion = cliente.getDireccion();
		localidad = cliente.getLocalidad();
		codigoPostal = cliente.getCodigoPostal();
		
	}
	
	public Cliente (String nombre, String dni, String direccion, String localidad, String codigoPostal) {
		
		this.nombre = nombre;
		
		if(compruebaDni(dni)) {
			this.dni = dni;
		}else {
			throw new ExcepcionAlquilerVehiculos("El DNI introducido no es válido.");
		}
		
		this.direccion = direccion;
		this.localidad = localidad;
		
		if(compruebaCodigoPostal(codigoPostal)) {
			this.codigoPostal = codigoPostal;
		}else {
			throw new ExcepcionAlquilerVehiculos("El código postal introducido no es válido.");
		}
		
		numClientes++;
		identificador = numClientes;
	}
	
	private boolean compruebaDni(String dni) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador = patron.matcher(dni);
		
		return emparejador.matches();
	}
	
	private boolean compruebaCodigoPostal(String codigoPostal) {
		Pattern patron = Pattern.compile("[0-9]{5}");
		Matcher emparejador = patron.matcher(codigoPostal);
		
		return emparejador.matches();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public int getIdentificador() {
		return identificador;
	}
	
	@Override
	public String toString() {
		return "CLIENTE: \nNOMBRE: " + nombre + " DNI: " + dni + " DIRECCIÓN: " + direccion + " LOCALIDAD: " + localidad
				+ " CÓDIGO POSTAL: " + codigoPostal + " IDENTIFICADOR: " + identificador + "";
	}
}
