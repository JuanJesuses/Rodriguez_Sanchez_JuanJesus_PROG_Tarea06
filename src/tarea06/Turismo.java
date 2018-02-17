package tarea06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Turismo {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;
	
	public Turismo (Turismo turismo) {
		matricula = turismo.getMatricula();
		marca = turismo.getMarca();
		modelo = turismo.getModelo();
		cilindrada = turismo.getCilindrada();
		disponible = turismo.getDisponible();
		
	}
	
	public Turismo (String matricula, String marca, String modelo, int cilindrada) {
		
		if(compruebaMatricula(matricula)) {
			this.matricula = matricula;
		}else {
			throw new ExcepcionAlquilerVehiculos("La matrícula introducida no es correcta.");
		}
		
		this.marca = marca;
		this.modelo = modelo;
		
		if(cilindrada > 0) 
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionAlquilerVehiculos("La cilindrada no puede ser negativa.");
		
		disponible = true;
		
	}
	
	private boolean compruebaMatricula(String matricula) {
		Pattern patron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = patron.matcher(matricula);
		
		return emparejador.matches();
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
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
