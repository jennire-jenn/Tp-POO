package tp1;

import java.time.LocalDate;

public class Partido {
	private String numPartido;
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo ganador;
	private Equipo perdedor;
	private String fase;
	private int cantgoles;
	private int goles1;
	private int goles2;
	private LocalDate fecha;
	public Partido(Equipo equipo1, Equipo equipo2, String numPartido, String fase, LocalDate fecha) {
		super();
		this.numPartido=numPartido;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.ganador = null;
		this.perdedor = null;
		this.fase = fase;
		this.cantgoles = 0;
		this.goles1 = 0;
		this.goles2 = 0;
		this.fecha = fecha;
	}
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public Equipo getGanador() {
		return ganador;
	}
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	public Equipo getPerdedor() {
		return perdedor;
	}
	public void setPerdedor(Equipo perdedor) {
		this.perdedor = perdedor;
	}
	public String getNumPartido() {
		return numPartido;
	}
	public void setNumPartido(String numPartido) {
		this.numPartido = numPartido;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public int getCantgoles() {
		return cantgoles;
	}
	public void setCantgoles(int cantgoles) {
		this.cantgoles = cantgoles;
	}
	public int getGoles1() {
		return goles1;
	}
	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}
	public int getGoles2() {
		return goles2;
	}
	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Partido [numPartido=" + numPartido + ", equipo1=" + equipo1.getNombre() + ", equipo2=" + equipo2.getNombre() + ", ganador="
				+ ganador + ", perdedor=" + perdedor + ", fase=" + fase + ", cantgoles=" + cantgoles + ", goles1="
				+ goles1 + ", goles2=" + goles2 + "]";
	}
	
	

	
	
	
}
