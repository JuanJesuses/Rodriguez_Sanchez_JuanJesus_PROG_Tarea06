package AlquilerVehiculos.mvc.modelo.dao;

import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Vehiculos {

	private Vehiculo[] vehiculos;
	private final int MAX_TURISMOS = 20;
	
	public Vehiculos () {
		vehiculos = new Vehiculo[MAX_TURISMOS];
	}
	
	public Vehiculo[] getVehiculos() {
		return vehiculos.clone();
	}
	
	/**
	 * Método que añade un turismo al array de turismos.
	 * Si la posición del array está ocupada o el 
	 * array está completo, lanza la excepción.
	 * @param vehiculo
	 */
	public void anadirVehiculo (Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		
		if (indiceNoSuperaTamano(indice)) {
			vehiculos[indice] = new Vehiculo (vehiculo);
		}else {
			throw new ExcepcionAlquilerVehiculos ("El array de turismos está lleno.");
		}
	}
	
	/**
	 * Comprueba que no se supera el tamaño del array.
	 * @param indice posición dentro del array.
	 * @return true si no se ha superado el tamaño y false si lo ha hecho.
	 */
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}
	
	/**
	 * Comprueba la primera posición libre del array y lanza
	 * una excepción si la matrícula del turismo pasada por parámetro 
	 * ya está almacenada en el array.
	 * @param vehiculo para añadir en caso de que no exista.
	 * @return la primera posición libre del array.
	 */
	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean encontrado = false;
		
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (vehiculos[indice] == null) {
				encontrado = true;
			}else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula())) {
				throw new ExcepcionAlquilerVehiculos ("Ya existe un turismo con esa matrícula.");
			}else {
				indice++;
			}
		}
		return indice;
	}
	
	/**
	 * Método que elimina un turismo del array de Turismos.
	 * @param matricula del vehículo a borrar.
	 */
	public void borrarVehiculo (String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaLaIzquierda(indice);
		}else {
			throw new ExcepcionAlquilerVehiculos ("El turismo a eliminar no existe.");
		}	
	}
	
	/**
	 * Cambia la posición de los elementos del array desde el encontrado
	 * hacia la izquierda para no dejar huecos vacíos entre los distintos
	 * elementos del array.
	 * @param indice es la posición del array que ha quedado vacía.
	 */
	private void desplazarUnaPosicionHaciaLaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length-1; i++) {
			vehiculos[i] = vehiculos[i+1];
		}
	}
	
	/**
	 * Localiza la posición del array donde se encuentra el turismo buscado.
	 * @param matricula para buscar el turismo
	 * @return la posición del array donde se encuentra el turismo buscado.
	 */
	private int buscarIndiceTurismo(String matricula) {
		int indice = 0;
		boolean encontrado = false;
		
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula)) {
				encontrado = true;
			}else {
				indice++;
			}
		}
		return indice;
	}
	
	/**
	 * Método que obtiene un turismo del aray de turismos.
	 * @param matricula del turismo buscado
	 * @return el turismo buscado
	 */
	public Vehiculo buscarVehiculo (String matricula) {
		int indice = buscarIndiceTurismo(matricula);
			
		if (indiceNoSuperaTamano(indice)) {
			return new Vehiculo (vehiculos[indice]);
		}else {
			return null;
		}
	}
}