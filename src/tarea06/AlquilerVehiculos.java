package tarea06;

import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;

public class AlquilerVehiculos {
	
	private Turismo[] turismos;
	private Cliente[] clientes;
	private Alquiler[] alquileres;
	
	private final int MAX_TURISMOS = 20;
	private final int MAX_CLIENTES = 20;
	private final int MAX_ALQUILERES = 20;
	
	public AlquilerVehiculos() {
		
		turismos = new Turismo[MAX_TURISMOS];
		clientes = new Cliente[MAX_CLIENTES];
		alquileres = new Alquiler[MAX_ALQUILERES];
		
	}
	
	public Turismo[] getTurismos() {
		return turismos;
	}
	
	public Cliente[] getCliente() {
		return clientes;
	}
	
	public Alquiler[] getAlquileres() {
		return alquileres;
	}
	
	/**
	 * Método para buscar y obtener un cliente del array de clientes
	 * @param dni del cliente
	 * @return el cliente buscado por el dni o null si no se encuentra
	 */
	public Cliente getCliente (String dni) {
		int posicion = 0;
		boolean encontrado = false;
		
		while(posicion < clientes.length && !encontrado && clientes[posicion] != null) {
			if(clientes[posicion].getDni().equals(dni))
				encontrado = true;
			else
				posicion++;
		}
		
		if (encontrado)
			return clientes[posicion];
		else
			return null;
	}
	
	/**
	 * Método que añade un cliente al array de clientes.
	 * Si la posición del array está ocupada, lanza la excepción.
	 * @param cliente
	 */
	public void addCliente (Cliente cliente) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < clientes.length && !encontrado) {
			if (clientes[posicion] == null)
				encontrado = true;
			else if (clientes[posicion].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI.");
			else
				posicion++;
		}
		
		if (encontrado)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos ("El array de clientes está lleno.");
	}
	
	/**
	 * Método que elimina un cliente del array de clientes.
	 * @param dni
	 */
	public void delCliente (String dni) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < clientes.length && !encontrado && clientes[posicion] != null) {
			if (clientes[posicion].getDni().equals(dni))
				encontrado = true;
			else
				posicion++;
		}
		
		if (encontrado) {
			for (int i = posicion; i < clientes.length-1; i++) {
				clientes[i] = clientes [i+1];
			}
			
			clientes[clientes.length-1] = null;
		}else {
			throw new ExcepcionAlquilerVehiculos ("El cliente a borrar no existe.");
		}
	}
	
	public Turismo getTurismo (String matricula) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < turismos.length && !encontrado && turismos[posicion] != null) {
			if (turismos[posicion].getMatricula().equals(matricula))
				encontrado = true;
			else
				posicion++;
		}
		
		if (encontrado)
			return turismos[posicion];
		else
			return null;
	}
	
	public void addTurismo (Turismo turismo) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < turismos.length && !encontrado) {
			if (turismos[posicion] == null)
				encontrado = true;
			else if (turismos[posicion].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos ("Ya existe un turismo con esa matrícula.");
			else
				posicion++;
		}
			if (encontrado)
				turismos[posicion] = turismo;
			else
				throw new ExcepcionAlquilerVehiculos ("El array de turismos está lleno.");
	}
	
	public void delTurismo (String matricula) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < turismos.length && !encontrado && turismos[posicion] != null) {
			if (turismos[posicion].getMatricula().equals(matricula))
				encontrado = true;
			else
				posicion++;
		}
		
		if (encontrado) {
			for (int i = posicion; i < turismos.length-1; i++) {
				turismos[i] = turismos[i+1];
			}
			turismos[turismos.length - 1] = null;
		}else {
			throw new ExcepcionAlquilerVehiculos ("El turismo a eliminar no existe.");
		}	
	}
	
	public void openAlquiler (Cliente clientes, Turismo turismos) {
		int posicion = 0;
		boolean encontrado = false;
		
		while(posicion < alquileres.length && !encontrado) {
			if (alquileres[posicion] == null)
				encontrado = true;
			else if (alquileres[posicion].getTurismo().getMatricula().equals(turismos.getMatricula())
					&& alquileres[posicion].getTurismo().getDisponible() == false
					&& alquileres[posicion].getCliente().getDni().equals(clientes.getDni())
					/*&& alquileres[posicion].getDias() == 0*/)
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para ese turismo.");
			else
				posicion++;
		}
		
		if (encontrado)
			alquileres[posicion] = new Alquiler (clientes, turismos);
		else
			throw new ExcepcionAlquilerVehiculos ("El array de alquileres está lleno.");
	}
	
	public void closeAlquiler (Cliente clientes, Turismo turismos) {
		int posicion = 0;
		boolean encontrado = false;
		
		while (posicion < alquileres.length && !encontrado && alquileres[posicion] != null) {
			if(alquileres[posicion].getTurismo().getMatricula().equals(turismos.getMatricula())
			   && alquileres[posicion].getCliente().getDni().equals(clientes.getDni())
			   && alquileres[posicion].getTurismo().getDisponible()==false 
			   /*&& alquileres[posicion].getDias()==0*/)
					encontrado = true;
			else
				posicion++;
		}
		
		if (encontrado)
			alquileres[posicion].close();
		else
			throw new ExcepcionAlquilerVehiculos ("No hay ningún alquiler abierto para ese vehículo.");
	}
}
