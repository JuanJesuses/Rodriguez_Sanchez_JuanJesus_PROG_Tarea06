package AlquilerVehiculos.mvc.modelo.dao;

import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Turismos {

	private Turismo[] turismos;
	private final int MAX_TURISMOS = 20;
	
	public Turismos () {
		turismos = new Turismo[MAX_TURISMOS];
	}
	
	public Turismo[] getTurismos() {
		return turismos.clone();
	}
	
	/**
	 * Método que añade un turismo al array de turismos.
	 * Si la posición del array está ocupada o el 
	 * array está completo, lanza la excepción.
	 * @param turismo
	 */
	public void anadirTurismo (Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
		
		if (indiceNoSuperaTamano(indice)) {
			turismos[indice] = new Turismo (turismo);
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
		return indice < turismos.length;
	}
	
	/**
	 * Comprueba la primera posición libre del array y lanza
	 * una excepción si la matrícula del turismo pasada por parámetro 
	 * ya está almacenada en el array.
	 * @param turismo para añadir en caso de que no exista.
	 * @return la primera posición libre del array.
	 */
	private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
		int indice = 0;
		boolean encontrado = false;
		
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (turismos[indice] == null) {
				encontrado = true;
			}else if (turismos[indice].getMatricula().equals(turismo.getMatricula())) {
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
	public void borrarTurismo (String matricula) {
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
		for (int i = indice; i < turismos.length-1; i++) {
			turismos[i] = turismos[i+1];
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
			if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula)) {
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
	public Turismo buscarTurismo (String matricula) {
		int indice = buscarIndiceTurismo(matricula);
			
		if (indiceNoSuperaTamano(indice)) {
			return new Turismo (turismos[indice]);
		}else {
			return null;
		}
	}
}
