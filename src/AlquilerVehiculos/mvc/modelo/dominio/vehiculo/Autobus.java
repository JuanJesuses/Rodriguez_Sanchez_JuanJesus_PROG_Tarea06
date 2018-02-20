package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class Autobus extends Vehiculo {
	
	private double precioAutobus = 0.0;

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculos datosTecnicosVehiculo) {
		super(matricula, marca, modelo, datosTecnicosVehiculo);
	}
	
	public Autobus (Autobus autobus) {
		super(autobus);
	}
	
	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.AUTOBUS;
	}
	
	@Override
	public double getPrecioEspecifico() {
		precioAutobus = (getDatosTecnicosVehiculo().getCilindrada()/50) + 1 * getDatosTecnicosVehiculo().getNumeroPlazas();
		return precioAutobus;
	}

}
