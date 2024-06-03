package tp1;

public class Partido {
	private String numPartido;
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo ganador;
	private Equipo perdedor;
	public Partido(Equipo equipo1, Equipo equipo2, String numPartido) {
		super();
		this.numPartido=numPartido;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.ganador = null;
		this.perdedor = null;
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
	@Override
	public String toString() {
		return "Partido [numPartido=" + numPartido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", ganador="
				+ ganador + ", perdedor=" + perdedor + "]";
	}
	
	
	
}
