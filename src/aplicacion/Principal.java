package aplicacion;

import utilidades.Entrada;
import AlquilerVehiculos.mvc.modelo.dao.AlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dao.Alquileres;
import AlquilerVehiculos.mvc.modelo.dao.Clientes;
import AlquilerVehiculos.mvc.modelo.dao.Turismos;
import AlquilerVehiculos.mvc.modelo.dominio.Alquiler;
import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import AlquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import AlquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Principal {

	public static void main(String[] args) {
		

		int opcionMenu; //Variable para escoger una opción del menú principal
		String nombre, dni, calle, localidad, codigoPostal;
		String matricula, marca, modelo;
		int cilindrada;
		char nuevo = 'n';
		Clientes cliente = new Clientes();
		Turismos turismo = new Turismos();
		Alquileres alquiler = new Alquileres();
		//AlquilerVehiculos miAlquiler = new AlquilerVehiculos(); //Se crea un objeto de tipo alquilerVehiculos
		
		Cliente cliente1 = new Cliente ("Bilbo Bolsón", "12345678A", new DireccionPostal("C/La Runa, 32", "Bolsón Cerrado", "01005"));
		Cliente cliente2 = new Cliente ("Meriadoc Brandigamo", "23456789B", new DireccionPostal("C/La Runa, 72", "Hobbitón", "63541"));
		Cliente cliente3 = new Cliente ("Peregrin Tuc", "34567890C", new DireccionPostal("C/La Runa, 29", "Bolsón Cerrado", "22456"));
		
		cliente.anadirCliente(cliente1);
		cliente.anadirCliente(cliente2);
		cliente.anadirCliente(cliente3);
		
		Turismo turismo1 = new Turismo ("4512BCD", "Opel", "Astra", 1100);
		Turismo turismo2 = new Turismo ("7628HKG", "Citröen", "Xsara", 1900);
		Turismo turismo3 = new Turismo ("2356CDH", "Hyunday", "Elantra", 1600);
		
		turismo.anadirTurismo(turismo1);
		turismo.anadirTurismo(turismo2);
		turismo.anadirTurismo(turismo3);
		
		do {
			
			System.out.println("");
			System.out.println("1. Añadir cliente.");
			System.out.println("2. Borrar cliente.");
			System.out.println("3. Listar clientes.");
			System.out.println("4. Añadir turismo.");
			System.out.println("5. Borrar turismo.");
			System.out.println("6. Listar turismos.");
			System.out.println("7. Iniciar alquiler.");
			System.out.println("8. Cerrar Alquiler.");
			System.out.println("9. Listar alquileres.");
			System.out.println("0. Salir de la aplicación.");
			System.out.println("");
			
			do {
				
				System.out.println("\nSeleccione una opción del menú  entre 0 y 9:");
					opcionMenu = Entrada.entero();
			}while (opcionMenu < 0 || opcionMenu > 9);
			
			switch (opcionMenu) {
			
				case 1:
					
					Cliente nuevoCliente = null;
					DireccionPostal direccionPostal;
					
					do {
						do {
							System.out.println("\n||-AÑADIR CLIENTE-||");
							System.out.println("********************");
							System.out.println("");
							System.out.println("Introduzca el nombre: ");
							nombre = Entrada.cadena();
							System.out.println("Introduzca el DNI: ");
							dni = Entrada.cadena();
							System.out.println("Introduzca la dirección del cliente: ");
							calle = Entrada.cadena();
							System.out.println("Introduzca la localidad: ");
							localidad = Entrada.cadena();
							System.out.println("Introduzca el código postal: ");
							codigoPostal = Entrada.cadena();
							
							try {
								nuevoCliente = new Cliente (nombre, dni, new DireccionPostal (calle, localidad, codigoPostal));
								System.out.println("El cliente se ha añadido de forma satisfactoria");
							}catch (ExcepcionAlquilerVehiculos e) {
								System.out.printf("ERROR: %s%n%n", e.getMessage());
								System.out.println("Vuelve a introducir los datos de forma correcta.");
							}
						}while (nuevoCliente == null);
						
						try {
							cliente.anadirCliente(nuevoCliente);
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.printf("ERROR: %s%n%n", e.getMessage());
						}
						
						System.out.println("\n¿Desea añadir otro cliente (s/n)?");
						nuevo = Entrada.caracter();
					}while (nuevo == 's');
					
					break;
					
				case 2:
				
					do {
						System.out.println("\n||-BORRAR CLIENTE-||");
						System.out.println("********************");
						System.out.println("");
						System.out.println("\nIntroduzca el DNI del cliente que quiera eliminar: ");
						dni = Entrada.cadena();
															
						try {
							cliente.borrarCliente(dni);
							System.out.println("El cliente se ha eliminado de forma correcta.");
						}catch (Exception e) {
							System.out.printf("\nDNI erróneo o el cliente no se encuentra de alta en el sistema.", e.getMessage());
						}
						
						System.out.println("\n¿Desea eliminar otro cliente (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
				
				case 3:
					
					System.out.println("\n||-LISTADO DE CLIENTES-||");
					System.out.println("*************************");
					for(Cliente clientesArray : cliente.getClientes()) {
						if(clientesArray != null)
							System.out.println(clientesArray);
					}
					
					break;
					
				case 4:
					
					Turismo nuevoTurismo = null;
					
					do {
						do {
							System.out.println("\n||-AÑADIR TURISMO-||");
							System.out.println("********************");
							System.out.println("Introduzca el número de matrícula: ");
							matricula = Entrada.cadena();
							System.out.println("Introduzca la marca del vehículo: ");
							marca = Entrada.cadena();
							System.out.println("Introduzca el modelo: ");
							modelo = Entrada.cadena();
							System.out.println("Introduzca la cilindrada: ");
							cilindrada = Entrada.entero();
							
							try {
								nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
							}catch (ExcepcionAlquilerVehiculos e) {
								System.out.printf("ERROR: %s%n%n", e.getMessage());
								System.out.println("Vuelve a introducir los datos de forma correcta.");
							}
						}while(nuevoTurismo == null);
							
							try {
								turismo.anadirTurismo(nuevoTurismo);
							}catch(ExcepcionAlquilerVehiculos e) {
								System.out.printf("\nERROR", e.getMessage());
							}
							
							
						System.out.println("\n¿Quiere añadir otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
					
				case 5:
					
					do {
						System.out.println("\n||-BORRAR TURISMO-||");
						System.out.println("********************");
						System.out.println("");
						System.out.println("Introduzca la matrícula del vehículo que quiera eliminar: ");
						matricula = Entrada.cadena();
												
						try {
							turismo.borrarTurismo(matricula);
							System.out.println("\nVehículo eliminado de forma satisfactoria.");
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.printf("\nERROR: \n-Matrícula errónea o \n-El vehículo no está dado de alta en el sistema.", e.getMessage());
						}
												
						System.out.println("\n¿Desea eliminar otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
					
				case 6:
					
					System.out.println("\n||-LISTADO DE VEHÍCULOS-||");
					System.out.println("**************************");
					System.out.println("");
					for(Turismo turismosArray : turismo.getTurismos()) {
						if(turismosArray != null)
							System.out.println(turismosArray);
					}
					
					break;
					
				case 7:
					
															
					do {
						System.out.println("\n||-CREAR NUEVO ALQUILER-||");
						System.out.println("**************************");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteAlta = Entrada.cadena();
						cliente.buscarCliente(dniClienteAlta);
						//miAlquiler.getCliente(dniClienteAlta);
						//nuevoCliente = miAlquiler.getCliente(dniClienteAlta);
						nuevoCliente = cliente.buscarCliente(dniClienteAlta);
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoAlta = Entrada.cadena();
						turismo.buscarTurismo(matriculaVehiculoAlta);
						nuevoTurismo = turismo.buscarTurismo(matriculaVehiculoAlta);
						//miAlquiler.getTurismo(matriculaVehiculoAlta);
						//nuevoTurismo = miAlquiler.getTurismo(matriculaVehiculoAlta);
						
						if(nuevoCliente == null || nuevoTurismo == null) {
							System.out.println("\nError. Los datos introducidos no se encuentran en el sistema.");
						}else {
							try {
								alquiler.abrirAlquiler(nuevoCliente, nuevoTurismo);
								//miAlquiler.openAlquiler(nuevoCliente, nuevoTurismo);
								System.out.println("\nEl alquiler se ha generado correctamente.");
							}catch(ExcepcionAlquilerVehiculos e) {
								System.out.printf("\nError, ya hay un alquiler en curso con los datos seleccionados.", e.getMessage());
							}
						}
																							
						System.out.println("\n¿Quiere dar de alta un nuevo alquiler (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
					
				case 8:
					
					do {
						System.out.println("\n||-CERRAR ALQUILER-||");
						System.out.println("*********************");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteBaja = Entrada.cadena();
						cliente.buscarCliente(dniClienteBaja);
						nuevoCliente = cliente.buscarCliente(dniClienteBaja);
						//miAlquiler.getCliente(dniClienteBaja);
						//nuevoCliente = miAlquiler.getCliente(dniClienteBaja);//Cliente para baja de nuevo alquiler
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoBaja = Entrada.cadena();
						turismo.buscarTurismo(matriculaVehiculoBaja);
						nuevoTurismo = turismo.buscarTurismo(matriculaVehiculoBaja);
						//miAlquiler.getTurismo(matriculaVehiculoBaja);
						//nuevoTurismo = miAlquiler.getTurismo(matriculaVehiculoBaja);//Turismo para baja de nuevo alquiler
						
						if(nuevoCliente == null || nuevoTurismo == null) {
							System.out.println("\nError, no existe ningún alquiler con esos datos.");
						}else {
							try {
								alquiler.cerrarAlquiler(nuevoCliente, nuevoTurismo);
								//miAlquiler.closeAlquiler(nuevoCliente, nuevoTurismo);
								System.out.println("\nAlquiler cerrado de forma satisfactoria.");
							}catch(ExcepcionAlquilerVehiculos e) {
								System.out.printf("\nImposible cerrar el alquiler: \n-El vehículo está disponible para su alquiler o \n-El cliente no ha contratado aún.", e.getMessage());
							}
						}
						
						
						System.out.println("\n¿Quiere dar de baja otro alquiler (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
					
				case 9:
					
					System.out.println("\n||-LISTADO DE ALQUILERES ACTIVOS-||");
					System.out.println("***********************************");
					System.out.println("");
					for(Alquiler alquileresArray : alquiler.getAlquiler()) {
						if(alquileresArray != null)
							System.out.println(alquileresArray);
					}
					
				break;
				
				default:
			
			}//Fin del switch
			
		}while (opcionMenu != 0);

	}//Fin del main

}//Fin de la clase
