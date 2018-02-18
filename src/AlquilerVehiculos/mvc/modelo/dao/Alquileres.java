package AlquilerVehiculos.mvc.modelo.dao;

import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Alquileres {

	private Alquiler[] alquileres;
	private final int MAX_ALQUILERES = 20;
	
	public Alquileres() {
		alquileres = new Alquiler[MAX_ALQUILERES];
	}
	
	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}
	
	/**
	 * Método que inicia un alquiler y pone el vehículo seleccionado
	 * por el cliente como no disponible.
	 * @param cliente El cliente que alquila.
	 * @param turismo El turismo elegido por el cliente.
	 */
	public void abrirAlquiler (Cliente cliente, Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(cliente, turismo);
		
		if (indiceNoSuperaTamano(indice)) {
			alquileres[indice] = new Alquiler (cliente, turismo);
		}else {
			throw new ExcepcionAlquilerVehiculos ("El array de alquileres está lleno.");
		}
			
	}
	
	/**
	 * Comprueba que no se supera el tamaño del array.
	 * @param indice posición dentro del array.
	 * @return true si no se ha superado el tamaño y false si lo ha hecho.
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < alquileres.length;
	}
	
	/**
	 * Método que busca la primera posición libre del array de Alquileres que
	 * no contiene ningún alquiler y lanza una excepción si el turismo ya está
	 * siendo alquilado en otro alquiler abierto.
	 * @param clientes el cliente que queremos vincular al nuevo alquiler.
	 * @param turismos el turismo elegido por el cliente.
	 * @return la posición del array de Alquileres donde poder almacenar un nuevo alquiler.
	 */
	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Cliente clientes, Turismo turismos) {
		int indice = 0;
		boolean encontrado = false;
		
		while(indiceNoSuperaTamano(indice) && !encontrado) {
			if (alquileres[indice] == null) {
				encontrado = true;
			}else if (alquileres[indice].getTurismo().getMatricula().equals(turismos.getMatricula())
					&& alquileres[indice].getTurismo().getDisponible() == false
					&& alquileres[indice].getCliente().getDni().equals(clientes.getDni())) {
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto para ese turismo.");
			}else {
				indice++;
			}
		}
		return indice;
	}
	
	/**
	 * Método que cierra un alquiler abierto y pone el vehículo disponible
	 * para un nuevo alquiler.
	 * @param cliente que tiene un alquiler abierto para cerrar dicho alquiler.
	 * @param turismo elegido por el cliente.
	 */
	public void cerrarAlquiler (Cliente cliente, Turismo turismo) {
		int indice = buscarAlquilerAbierto(cliente, turismo);
		
		if (indiceNoSuperaTamano(indice))
			alquileres[indice].close();
		else
			throw new ExcepcionAlquilerVehiculos ("No hay ningún alquiler abierto para ese vehículo.");
	}
	
	/**
	 * Método que busca un alquiler abierto
	 * @param cliente el cliente que tiene un vehículo alquilado.
	 * @param turismo el turismo que ha elegido el cliente.
	 * @return posición del array donde se encuentra el alquiler abierto.
	 */
	private int buscarAlquilerAbierto(Cliente cliente, Turismo turismo) {
		int indice = 0;
		boolean encontrado = false;
		
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if(alquileres[indice] != null && alquileres[indice].getTurismo().getMatricula().equals(turismo.getMatricula())
			   && alquileres[indice].getCliente().getDni().equals(cliente.getDni())
			   && alquileres[indice].getTurismo().getDisponible()==false) {
				encontrado = true;
			}else {
				indice++;
			}
		}
		return indice;
	}

}
