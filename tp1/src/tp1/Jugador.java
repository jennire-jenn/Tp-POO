package tp1;

public class Jugador {
	private String nombre;
	private String posicion;
	private String nroCamiseta;
	private int edad;
	private int cantGoles;
	private int tarjetasA;
	public Jugador(String nombre, String posicion, String nroCamiseta,int edad) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.nroCamiseta = nroCamiseta;
		this.edad = edad;
		this.cantGoles = 0;
		this.tarjetasA = 0;
	}
	public Jugador(String nombre, String posicion, String nroCamiseta, int edad, int cantGoles, int tarjetasA) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.nroCamiseta = nroCamiseta;
		this.edad = edad;
		this.cantGoles = cantGoles;
		this.tarjetasA = tarjetasA;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNroCamiseta() {
		return nroCamiseta;
	}
	public void setNroCamiseta(String nroCamiseta) {
		this.nroCamiseta = nroCamiseta;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCantGoles() {
		return cantGoles;
	}
	public void setCantGoles(int cantGoles) {
		this.cantGoles = cantGoles;
	}
	public int getTarjetasA() {
		return tarjetasA;
	}
	public void setTarjetasA(int tarjetasA) {
		this.tarjetasA = tarjetasA;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posicion=" + posicion + ", nroCamiseta=" + nroCamiseta + ", edad="
				+ edad + ", cantGoles=" + cantGoles + ", tarjetasA=" + tarjetasA + "]";
	}
	

	
}
