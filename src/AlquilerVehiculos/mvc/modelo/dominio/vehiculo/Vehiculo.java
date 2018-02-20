package AlquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class Vehiculo {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;
	
	public Vehiculo (Vehiculo vehiculo) {
		
		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		cilindrada = vehiculo.getCilindrada();
		this.disponible = vehiculo.disponible;
		
	}
	
	public Vehiculo (String matricula, String marca, String modelo, int cilindrada) {
		
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setDisponible(true);
		
	}
	
	private boolean compruebaMatricula(String matricula) {
		Pattern patron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = patron.matcher(matricula);
		
		return emparejador.matches();
	}
	
	private void setMatricula(String matricula) {
		if(compruebaMatricula(matricula)) {
			this.matricula = matricula;
		}else {
			throw new ExcepcionAlquilerVehiculos("El campo matrícula está vacío o la matrícula introducida no es correcta.");
		}
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	private void setMarca(String marca) {
		if(marca != null && !marca.equals("")) {
			this.marca = marca;
		}else {
			throw new ExcepcionAlquilerVehiculos("El campo marca no puede estar vacío.");
		}
	}
	
	public String getMarca() {
		return marca;
	}
	
	private void setModelo(String modelo) {
		if(modelo != null && !modelo.equals("")) {
			this.modelo = modelo;
		}else {
			throw new ExcepcionAlquilerVehiculos("El campo modelo no puede estar vacío.");
		}
	}
	
	public String getModelo() {
		return modelo;
	}
	
	private void setCilindrada(int cilindrada) {
		if(cilindrada > 0) {
			this.cilindrada = cilindrada;
		}else {
			throw new ExcepcionAlquilerVehiculos("La cilindrada no puede ser inferior a cero.");
		}
	}
	
	public int getCilindrada() {
		return cilindrada;
	}

	public boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
		
	}
	
	@Override
	public String toString() {
		return "TURISMO: \nMATRÍCULA: " + matricula + " MARCA: " + marca + " MODELO: " + modelo + " CILINDRADA: "
				+ cilindrada + " DISPONIBLE: " + getDisponible() + "";
	}

}
