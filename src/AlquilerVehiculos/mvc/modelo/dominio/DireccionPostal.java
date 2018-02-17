package AlquilerVehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DireccionPostal {
	
	private String calle;
	private String localidad;
	private String codigoPostal;

	public DireccionPostal(String calle, String localidad, String codigoPostal) {
		setCalle(calle);
		setLocalidad(localidad);
		setCodigoPostal(codigoPostal);
	}
	
	public DireccionPostal (DireccionPostal direccionPostal) {
		calle = direccionPostal.getCalle();
		localidad = direccionPostal.getLocalidad();
		codigoPostal = direccionPostal.getCodigoPostal();
	}
	
	private void setCalle(String calle) {
		if(calle != null && !calle.equals("")) {
			this.calle = calle;
		}else {
			throw new ExcepcionAlquilerVehiculos("El campo calle no puede estar vacío.");
		}
	}
	
	public String getCalle() {
		return calle;
	}
	
	private void setLocalidad(String localidad) {
		if (localidad != null && !localidad.equals("")) {
			this.localidad = localidad;
		}else {
			throw new ExcepcionAlquilerVehiculos("El campo localidad no puede estar vacío.");
		}
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	private void setCodigoPostal (String codigoPostal) {
		if (compruebaCodigoPostal(codigoPostal)) {
			this.codigoPostal = codigoPostal;
		}else {
			throw new ExcepcionAlquilerVehiculos("Error al introducir el código Postal.");
		}
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	private boolean compruebaCodigoPostal(String codigoPostal) {
		Pattern patron = Pattern.compile("[0-9]{5}");
		Matcher emparejador = patron.matcher(codigoPostal);
		
		return emparejador.matches();
	}
	
	public String toString() {
		return String.format("Direccion: %s Localidad: %s Código Postal: %s", calle, localidad, codigoPostal);
	}
}