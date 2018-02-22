package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

/**
 * Clase turismo que hereda de la clase Vehículo
 * @author john
 *
 */
public class Turismo extends Vehiculo{
	
	private double precioTurismo = 0.0;
	
	/**
	 * Constructor con parámetros
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicosVehiculo
	 */
	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculos datosTecnicosVehiculo) {
		super(matricula, marca, modelo, datosTecnicosVehiculo);				
	}
	
	/**
	 * Constructor copia
	 * @param turismo
	 */
	public Turismo (Turismo turismo) {
		super(turismo);
	}
	
	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.TURISMO;
	}
	
	@Override
	public double getPrecioEspecifico() {
		precioTurismo = getDatosTecnicosVehiculo().getCilindrada()/50;
		return precioTurismo;
	}
}
