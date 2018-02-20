package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Turismo extends Vehiculo{
	
	private double precioTurismo = 0.0;

	public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculos datosTecnicosVehiculo) {
		super(matricula, marca, modelo, datosTecnicosVehiculo);				
	}
	
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
