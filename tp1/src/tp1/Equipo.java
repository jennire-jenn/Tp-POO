package tp1;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private int cantjug;
	private String colores;
	private String ciudad;
	private LinkedList<Jugador> ListaJugadores;
	private int partidosjugados;
	private int partidosganados;
	private int partidosperdidos;
	public Equipo(String nombre, String colores, String ciudad
			) {
		super();
		this.nombre = nombre;
		this.cantjug = 0;
		this.colores = colores;
		this.ciudad = ciudad;
		ListaJugadores = new LinkedList<Jugador>();
		this.partidosjugados = 0;
		this.partidosganados = 0;
		this.partidosperdidos = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantjug() {
		return cantjug;
	}
	public void setCantjug(int cantjug) {
		this.cantjug = cantjug;
	}
	public String getColores() {
		return colores;
	}
	public void setColores(String colores) {
		this.colores = colores;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LinkedList<Jugador> getListajugadores() {
		return ListaJugadores;
	}
	public void setListajugadores(LinkedList<Jugador> listajugadores) {
		ListaJugadores = listajugadores;
	}
	public int getPartidosjugados() {
		return partidosjugados;
	}
	public void setPartidosjugados(int partidosjugados) {
		this.partidosjugados = partidosjugados;
	}
	public int getPartidosganados() {
		return partidosganados;
	}
	public void setPartidosganados(int partidosganados) {
		this.partidosganados = partidosganados;
	}
	public int getPartidosperdidos() {
		return partidosperdidos;
	}
	public void setPartidosperdidos(int partidosperdidos) {
		this.partidosperdidos = partidosperdidos;
	}
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", cantjug=" + cantjug + ", colores=" + colores + ", ciudad=" + ciudad
				+ ", Listajugadores=" + ListaJugadores + ", partidosjugados=" + partidosjugados + ", partidosganados="
				+ partidosganados + ", partidosperdidos=" + partidosperdidos + "]";
	}
	
	 public Jugador seleccionarJugador() {
		 String[] jugadorsarray = new String[ListaJugadores.size()];
		 Jugador seleccionado=null;
			
			for (int i = 0; i < ListaJugadores.size(); i++) {
				jugadorsarray[i] = ListaJugadores.get(i).getNombre();
			}
			
			String jugadorSeleccionado =(String)JOptionPane.showInputDialog(null, 
					"Elija un jugador", null, 0, 
					null, jugadorsarray, jugadorsarray[0]);
			
			JOptionPane.showMessageDialog(null, jugadorSeleccionado);
			for (Jugador jugador : ListaJugadores) {
				if (jugador.getNombre().equals(jugadorSeleccionado)) {
					seleccionado = jugador;
					break;
				}
			}
			return seleccionado;
	 }
	public void agregarJugador() {
		String nombre,posicion,nroCamiseta;
		String [] posiciones = {"Delantero","Lateral Derecho","Lateral izquierdo", "Centro","Defensa","Arquero"};
		int edad;
		boolean flag = false;
	
		do {
			nombre=JOptionPane.showInputDialog("Ingresar nombre del jugador");
			if (nombre.isBlank()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
			}
		} while (nombre.isBlank());
		
			posicion=(String)JOptionPane.showInputDialog(null, "Ingrese posición", null, 0, null, posiciones, posiciones[0]);
			
		do {
			
			do {
				flag=false;
				nroCamiseta=JOptionPane.showInputDialog("Ingresar número de camiseta del jugador");
				if (nroCamiseta.isBlank()) {
					JOptionPane.showMessageDialog(null, "El número de camiseta no puede estar vacio");
				}			
			} while (nroCamiseta.isBlank());
			if (ListaJugadores.size()>0) {
				for (Jugador jugador : ListaJugadores) {
					if (jugador.getNroCamiseta().equals(nroCamiseta)) {
						JOptionPane.showMessageDialog(null, "El número de camiseta no puede ser igual al de otro jugador");
						flag=true;
					}
					break;
				}
			}	
		} while (flag);
		 do {
			 edad=Integer.parseInt(JOptionPane.showInputDialog("Ingresar edad del jugador"));
			 if (edad<18) {
				JOptionPane.showMessageDialog(null, "El jugador no puede ser menor de 18");
			}
		} while (edad<18);
			
				
		ListaJugadores.add(new Jugador(nombre,posicion,nroCamiseta,edad));
		cantjug++;
		
	}
	public void eliminarJugador() {
		Jugador seleccionado = seleccionarJugador();
		for (Jugador jugador : ListaJugadores) {
			if (jugador==seleccionado) {
				ListaJugadores.remove(jugador);
				break;
			}
			
		}
		
	}
	public void agregarJugadoresFalso(int cant) {
		
		for (int i = 0; i < cant; i++) {
			boolean flag = true;
			do {
					int camisa = (int)(Math.random()*99+1);
					String camiseta = ""+camisa;
					
				for (Jugador jugador: this.getListajugadores()) {
					if (jugador.getNroCamiseta().equals(camiseta)) {
						flag=false;
					} 
					
				}
				this.getListajugadores().add(new Jugador("nombre","pocision",camiseta,22));
				break;
			} while (flag==false);
		
		}
		
	}
	public void modificarJugador() {
		Jugador seleccionado = seleccionarJugador();
		boolean flag = false;
		String [] posiciones = {"Delantero","Lateral Derecho","Lateral izquierdo", "Centro","Defensa","Arquero","Salir"};
		String nombre,posicion,nroCamiseta;
		int edad;
		String [] opciones = {"Nombre","Posición","Número de Camiseta","edad"};
		String opcion;
		do {
			opcion=(String)JOptionPane.showInputDialog(null, "Ingrese lo que desea modificar", null, 0, null, opciones, opciones[0]);
			switch (opcion) {
			case "Nombre":
				do {
					nombre=JOptionPane.showInputDialog("Ingresar nombre del jugador");
					if (nombre.isBlank()) {
						JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
					}
				} while (nombre.isBlank());
				seleccionado.setNombre(nombre);
				break;
			case "Posición":
				posicion=(String)JOptionPane.showInputDialog(null, "Ingrese posición", null, 0, null, posiciones, posiciones[0]);
				
				seleccionado.setPosicion(posicion);
						
						break;
			case "Número de Camiseta":
				do {
					do {
						nroCamiseta=JOptionPane.showInputDialog("Ingresar número de camiseta del jugador");
						if (nroCamiseta.isBlank()) {
							JOptionPane.showMessageDialog(null, "El número de camiseta no puede estar vacio");
						}			
					} while (nroCamiseta.isBlank());
					if (ListaJugadores.size()>0) {
						for (Jugador jugador : ListaJugadores) {
							if (jugador.getNroCamiseta().equals(nroCamiseta)) {
								JOptionPane.showMessageDialog(null, "El número de camiseta no puede ser igual al de otro jugador");
								flag=true;
							}
							break;
						}
					}	
				} while (flag);
				seleccionado.setNroCamiseta(nroCamiseta);
				break;
			case "edad":
				do {
					 edad=Integer.parseInt(JOptionPane.showInputDialog("Ingresar edad del jugador"));
					 if (edad<18) {
						JOptionPane.showMessageDialog(null, "El jugador no puede ser menor de 18");
					}
				} while (edad<18);
				seleccionado.setEdad(edad);
				break;

			}
		} while (!opcion.equals("Salir"));
		
	}
	public void buscarJugador() {
		Jugador seleccionado = seleccionarJugador();
		for (Jugador jugador : ListaJugadores) {
			if (jugador==seleccionado) {
				JOptionPane.showMessageDialog(null, jugador);
			}
		}
		
	}
	public void verCantJugadores() {
		JOptionPane.showMessageDialog(null, cantjug);
		
	}
	public void verListaJugadores() {
		String lista="";
		for (int i = 0; i < ListaJugadores.size(); i++) {
			lista=lista+"\n"+ListaJugadores.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);
		
	}
}
