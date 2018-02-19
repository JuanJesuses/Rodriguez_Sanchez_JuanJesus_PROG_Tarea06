package AlquilerVehiculos.mvc.vista;

import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public enum Opcion {
	
	SALIR("Salir"){
		public void ejecutar() {
			vista.salir();
		}
	},
	
	ANADIR_CLIENTE("Añadir Cliente"){
		public void ejecutar() {
			vista.anadirCliente();
		}
	},
	
	BORRAR_CLIENTE("Borrar Cliente"){
		public void ejecutar() {
			vista.borrarCliente();
		}
	},
	
	BUSCAR_CLIENTE("Buscar Cliente"){
		public void ejecutar() {
			vista.buscarCliente();
		}
	},
	
	LISTAR_CLIENTE("Listar Clientes"){
		public void ejecutar() {
			vista.listarClientes();
		}
	},
	
	ANADIR_TURISMO("Añadir Turismo"){
		public void ejecutar() {
			vista.anadirTurismo();
		}
	},
	
	BORRAR_TURISMO("Borrar Turismo"){
		public void ejecutar() {
			vista.borrarTurismo();
		}
	},
	
	BUSCAR_TURISMO("Buscar Turismo"){
		public void ejecutar() {
			vista.buscarTurismo();
		}
	},
	
	LISTAR_TURISMO("Listar Turismos"){
		public void ejecutar() {
			vista.listarTurismos();
		}
	},
	
	ABRIR_ALQUILER("Abrir Alquiler"){
		public void ejecutar() {
			vista.abrirAlquiler();
		}
	},
	
	CERRAR_ALQUILER("Cerrar Alquiler"){
		public void ejecutar() {
			vista.cerrarAlquiler();
		}
	},
	
	LISTAR_ALQUILERES("Listar Alquileres"){
		public void ejecutar(){
			vista.listarAlquileres();
		}
	};
	
	private String mensaje;
	private static IUTextual vista;
	
	private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public abstract void ejecutar();
	
	public String getMensaje() {
		return mensaje;
	}
	
	public static void setVista(IUTextual vista) {
		Opcion.vista = vista;
	}
	
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}
	
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if(esOrdinalValido(ordinal)) {
			return values()[ordinal];
		}else {
			throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
		}
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false; 
	}
	
}
