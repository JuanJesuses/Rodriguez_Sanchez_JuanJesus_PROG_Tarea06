package AlquilerVehiculos.mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import AlquilerVehiculos.mvc.modelo.dominio.Cliente;
import AlquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

public class Alquiler {
	
	private Date fecha;
	private int dias;
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000*60*60*24;
	private final double PRECIO_DIA = 30.0;
	private Cliente cliente;
	private Vehiculo vehiculo;
		
	public Alquiler (Cliente cliente, Vehiculo vehiculo) {
		
		setCliente(cliente);
		setVehiculo(vehiculo);
		fecha = new Date();
		dias = 0;
		vehiculo.setDisponible(false);
		
	}
	
	public Date getFecha() {
		return fecha;
	}

	public int getDias() {
		return dias;
	}
	
	private void setCliente(Cliente cliente) {
		if (cliente != null) {
			this.cliente = cliente;
		}else {
			throw new ExcepcionAlquilerVehiculos("Para iniciar el alquiler debe agregar un cliente.");
		}
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo != null) {
			this.vehiculo = vehiculo;
		}else {
			throw new ExcepcionAlquilerVehiculos("Para iniciar el alquiler debe agregar un vehículo.");
		}
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public double getPrecio() {
		return PRECIO_DIA*getDias() + vehiculo.getCilindrada()/100;
	}
	
	public void close() {
		Date entrega = new Date(); //entrega es la fecha de devolución del vehículo
		dias = difDias(entrega, fecha); // dias son los días que el vehículo ha estado en alquiler
		vehiculo.setDisponible(true); //Establce el turismo a disponible
	}
	
	private int difDias(Date fechaRecogida, Date fechaEntrega) {
		long milisegundos = fechaRecogida.getTime() - fechaEntrega.getTime();
		long dias = milisegundos / MS_DIA;
		
		return (int) dias+1;
	}
	
	@Override
	public String toString() {
		return "--:Alquiler:-- \nfecha: " + FORMATO_FECHA.format(getFecha()) + " DÍAS: " + dias + "\nPRECIO: " + getPrecio() + "\n" + cliente + "\n" + vehiculo + "";
	}

}
