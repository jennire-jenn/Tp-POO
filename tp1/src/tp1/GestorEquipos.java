package tp1;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	private LinkedList<Equipo> ListaEquipos = new LinkedList<Equipo>();
	private LinkedList<Partido> ListaPartidos = new LinkedList<Partido>();

	



	public LinkedList<Equipo> getListaEquipos() {
		return ListaEquipos;
	}




	public void setListaEquipos(LinkedList<Equipo> listaEquipos) {
		ListaEquipos = listaEquipos;
	}




	public LinkedList<Partido> getListaPartidos() {
		return ListaPartidos;
	}




	public void setListaPartidos(LinkedList<Partido> listaPartidos) {
		ListaPartidos = listaPartidos;
	}




	@Override
	public String toString() {
		return "GestorEquipos [ListaEquipos=" +  ListaEquipos  +  ", ListaPartidos=" +  ListaPartidos +  "]";
	}

	public Equipo seleccionarEquipo() {
		 String[] equipossarray = new String[ListaEquipos.size()];
		 Equipo seleccionado=null;
			
			for (int i = 0; i < ListaEquipos.size(); i++) {
				equipossarray[i] = ListaEquipos.get(i).getNombre();
			}
			
			String equipoSeleccionado =(String)JOptionPane.showInputDialog(null, 
					"Elija un Equipo", null, 0, 
					null, equipossarray, equipossarray[0]);
			
			JOptionPane.showMessageDialog(null, equipoSeleccionado);
			for (Equipo equipo : ListaEquipos) {
				if (equipo.getNombre().equals(equipoSeleccionado)) {
					seleccionado = equipo;
					break;
				}
			}
			return seleccionado;
	 }
	public Partido seleccionarPartido() {
		 String [] partidosarray = new String[ListaPartidos.size()];
		 Partido seleccionado=null;
			
			for (int i = 0; i < ListaPartidos.size(); i++) {
				partidosarray[i] = ListaPartidos.get(i).getNumPartido();
			}
			
			String partidoSeleccionado = (String)JOptionPane.showInputDialog(null, "Elija el numero de Partido",null, 0, null, partidosarray, partidosarray[0]); 
			
			JOptionPane.showMessageDialog(null, partidoSeleccionado);
			for (Partido partido : ListaPartidos) {
				if (partido.getNumPartido()==partidoSeleccionado) {
					seleccionado = partido;
					break;
				}
			}
			return seleccionado;
	 }
	public void agregarEquipo() {
	 String ciudad, colores, nombre;
	 if (ListaEquipos.size()>=8) {
		JOptionPane.showMessageDialog(null, "Ya hay 8 equipos");
	} else {
		 do {
				nombre=JOptionPane.showInputDialog("Ingrese nombre del equipo");
				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
				}
			} while (nombre.isEmpty());
			 do {
					ciudad=JOptionPane.showInputDialog("Ingrese ciudad del equipo");
					if (ciudad.isEmpty()) {
						JOptionPane.showMessageDialog(null, "La ciudad no puede estar vacio");
					}
				} while (ciudad.isEmpty());
			 do {
					colores=JOptionPane.showInputDialog("Ingrese colores del equipo");
					if (colores.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Los colores no pueden estar vacios");
					}
				} while (colores.isEmpty());
			 ListaEquipos.add(new Equipo(nombre,colores,ciudad));
			 
	}
	
	}
	public void  eliminarEquipo() {
		
		Equipo seleccionado = seleccionarEquipo();
		for (Equipo equipo : ListaEquipos) {
			if (equipo==seleccionado) {
				ListaEquipos.remove(equipo);
				break;
			}
			
		}
		
	}
	public void  modificarEquipo() {
		String ciudad, colores, nombre;
		Equipo seleccionado = seleccionarEquipo();
		String [] opciones = {"Nombre","Ciudad","Colores","Salir"};
		String opcion;
		do {
			opcion=(String)JOptionPane.showInputDialog(null, "Ingrese lo que desea modificar", null, 0, null, opciones, opciones[0]);
			
			switch (opcion) {
			case "Ciudad":
				 do {
						ciudad=JOptionPane.showInputDialog("Ingrese ciudad del equipo");
						if (ciudad.isEmpty()) {
							JOptionPane.showMessageDialog(null, "La ciudad no puede estar vacio");
						}
					} while (ciudad.isEmpty());
				 seleccionado.setCiudad(ciudad);
				break;

			case "Nombre":
				do {
					nombre=JOptionPane.showInputDialog("Ingrese nombre del equipo");
					if (nombre.isEmpty()) {
						JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
					}
				} while (nombre.isEmpty());
				seleccionado.setNombre(nombre);
				break;
			case "Colores":
				 do {
						colores=JOptionPane.showInputDialog("Ingrese colores del equipo");
						if (colores.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Los colores no pueden estar vacios");
						}
					} while (colores.isEmpty());
				 seleccionado.setColores(colores);
				break;
			}
			
			
		} while (!opcion.equals("Salir"));
		
		
	}
	public void  asignarPartido(){
		Equipo equipo1;
		Equipo equipo2;
		String num,fase;
		String [] numeros = {"Primero","Segundo","Tercero","Cuarto"};
		if (ListaPartidos.size()<4) {
			do {
				JOptionPane.showMessageDialog(null, "Elija el primer Equipo");
				equipo1 = seleccionarEquipo();
				JOptionPane.showMessageDialog(null, "Elija el segundo Equipo");
				equipo2 = seleccionarEquipo();
				if (equipo1==equipo2) {
					JOptionPane.showMessageDialog(null, "Los equipos tienen que ser distintos");
				}
			} while (equipo1==equipo2);
			num=(String)JOptionPane.showInputDialog(null, "Elija numero de Partido", null, 0, null, numeros, numeros[0]);
			fase="Primera fase";
			ListaPartidos.add(new Partido(equipo1,equipo2,num,fase));
		} else {
			JOptionPane.showMessageDialog(null, "Ya se asignaron los partidos de la primera fase");
		}
		
		
	}
	public void  buscarEquipo(){
		Equipo seleccionado = seleccionarEquipo();
		for (Equipo equipo : ListaEquipos) {
			if (equipo==seleccionado) {
				JOptionPane.showMessageDialog(null, equipo);
			}
		}
		
		
	}
	public void  verCantEquipos(){
		JOptionPane.showMessageDialog(null, ListaEquipos.size());
		
	}
	public void  verListaEquipos(){
		String lista="";
		for (int i = 0; i < ListaEquipos.size(); i++) {
			lista=lista+"\n"+ListaEquipos.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);
		
	}
	public void jugarPartido(Partido partido) {
		int goles1=0, goles2=0;
		if (partido.getGanador()==null) {
			if (partido.getEquipo1().getListajugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar porque no hay jugadores suficientes");
			} else if (partido.getEquipo2().getListajugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar porque no hay jugadores suficientes");
			} else {
				JOptionPane.showMessageDialog(null, "Se jugara el partido de "+partido.getEquipo1().getNombre()+" y "+partido.getEquipo2().getNombre());
				do {
					for (Jugador jugador : partido.getEquipo1().getListajugadores()) {
						if (!jugador.getPosicion().equals("Arquero")) {
							if ((int)(Math.random()*5)==0) {
								jugador.setCantGoles(jugador.getCantGoles()+1);
								JOptionPane.showMessageDialog(null, jugador.getNombre()+" hizo gol");
								goles1++;
							}
						}
						} 
							
						
						
					
					 for (Jugador jugador : partido.getEquipo2().getListajugadores()) {
							if (!jugador.getPosicion().equals("Arquero")) {
								if ((int)(Math.random()*5)==0) {
									jugador.setCantGoles(jugador.getCantGoles()+1);
									JOptionPane.showMessageDialog(null, jugador.getNombre()+" hizo gol");
									goles2++;
								}
							}
								
							
							
							
						}
					} while (goles1==goles2);
				partido.getEquipo1().setPartidosjugados(partido.getEquipo1().getPartidosjugados()+1);
				partido.getEquipo2().setPartidosjugados(partido.getEquipo2().getPartidosjugados()+1);
					JOptionPane.showMessageDialog(null, "El resultado del partido fue "+goles1+"-"+goles2);
					if (goles1<goles2) {
						partido.setGanador(partido.getEquipo2());
						partido.setPerdedor(partido.getEquipo1());

						partido.getEquipo2().setPartidosganados(partido.getEquipo2().getPartidosganados()+1);
						JOptionPane.showMessageDialog(null, "El quipo ganador fue: "+partido.getEquipo2().getNombre());
					} else {
						partido.setGanador(partido.getEquipo1());
						partido.setPerdedor(partido.getEquipo2());
						partido.getEquipo1().setPartidosganados(partido.getEquipo1().getPartidosganados()+1);
						JOptionPane.showMessageDialog(null, "El quipo ganador fue: "+partido.getEquipo1().getNombre());
					}
					
			}
		} else {
			JOptionPane.showMessageDialog(null, "El partido ya se jugó");
		}
		
		
		
	}
		
		
	}

