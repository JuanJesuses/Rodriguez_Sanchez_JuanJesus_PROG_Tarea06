package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public enum TipoVehiculo {
	
	TURISMO("TURISMO"){
		//public Vehiculo getInstancia(Vehiculo turismo) {
				//	return new Vehiculo(turismo);
				//}
	},
	
	DE_CARGA("DE CARGA"){
		
	},
	
	AUTOBUS("AUTOBÚS"){
		
	};
	
	private String tipoVehiculo;
	
	private TipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public String toString() {
		return tipoVehiculo;
	}
	
	public TipoVehiculo getTipoVehiculoSegunordinal(int ordinal) {
		if(esOrdinalValido(ordinal)) {
			return values()[ordinal];
		}else {
			throw new ExcepcionAlquilerVehiculos ("Ordinal del tipo de vehículo no válido.");
		}
	}
	
	public boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length -1);
	}
	
	
}
