package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class DeCarga extends Vehiculo {
	
	private double precioDeCarga = 0.0;

	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculos datosTecnicosVehiculo) {
		super(matricula, marca, modelo, datosTecnicosVehiculo);
	}
	
	public DeCarga (DeCarga deCarga) {
		super (deCarga);
	}
	
	@Override
	public TipoVehiculo getTipoVehiculo() {
		return TipoVehiculo.DE_CARGA;
	}
	
	@Override
	public double getPrecioEspecifico() {
		precioDeCarga = (getDatosTecnicosVehiculo().getPma()/20) + 1 * getDatosTecnicosVehiculo().getNumeroPlazas();
		return precioDeCarga;
	}
}
