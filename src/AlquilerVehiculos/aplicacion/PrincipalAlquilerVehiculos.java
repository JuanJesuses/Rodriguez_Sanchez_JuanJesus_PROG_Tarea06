package AlquilerVehiculos.aplicacion;

import utilidades.Entrada;
import AlquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Turismos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;
import AlquilerVehiculos.mvc.vista.IUTextual;

public class PrincipalAlquilerVehiculos {

	public static void main(String[] args) {
		
		AlquilerVehiculos modelo = new AlquilerVehiculos();
		IUTextual vista = new IUTextual();
		ControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(modelo, vista);
		
		controlador.comenzar();
		
	}
}