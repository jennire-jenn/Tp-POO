package tp1;

import java.time.LocalDate;
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
 public void rellenarEquipos() {
	 
		 
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
	public LocalDate asignarFecha() {
		int dia, mes, anio;
		LocalDate fecha;
		do {
			dia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de inicio del torneo"));
			if (dia<0||dia>31) {
				JOptionPane.showMessageDialog(null, "El día no puede ser menor a 0 ni mayor a 31");
			}
		} while (dia<0||dia>31);
		do {
			mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de mes de inicio del torneo"));
			if (mes<0||mes>12) {
				JOptionPane.showMessageDialog(null, "El día no puede ser menor a 0 ni mayor a 12");
			}
		} while (mes<0||mes>12);
		
			anio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese año del torneo"));
		
			fecha=LocalDate.of(anio, mes, dia);
		
		return fecha;
		
	}
	public Equipo asignarEquipoAPartido() {
		LinkedList<Equipo> ListaEquiposParaPartidos = new LinkedList<Equipo>();
		ListaEquiposParaPartidos=ListaEquipos;
		for (Partido partido : ListaPartidos) {
		for (Equipo equipo : ListaEquiposParaPartidos) {
			if (equipo==partido.getEquipo1()||equipo==partido.getEquipo2()) {
				ListaEquiposParaPartidos.remove(equipo);
			}
		}
		}
		 String[] equipossarray = new String[ListaEquiposParaPartidos.size()];
		 Equipo seleccionado=null;
			
			for (int i = 0; i < ListaEquiposParaPartidos.size(); i++) {
				equipossarray[i] = ListaEquiposParaPartidos.get(i).getNombre();
			}
			
			String equipoSeleccionado =(String)JOptionPane.showInputDialog(null, 
					"Elija un Equipo", null, 0, 
					null, equipossarray, equipossarray[0]);
			
			JOptionPane.showMessageDialog(null, equipoSeleccionado);
			for (Equipo equipo : ListaEquiposParaPartidos) {
				if (equipo.getNombre().equals(equipoSeleccionado)) {
					seleccionado = equipo;
					break;
				}
			}
			return seleccionado;
	}
	public void  asignarPartido(){
		Equipo equipo1=null;
		Equipo equipo2=null;
		LocalDate fecha;
		String num="",fase="";
		String [] numeros = {"Primero","Segundo","Tercero","Cuarto"};
		if (ListaEquipos.size()<8) {
			JOptionPane.showMessageDialog(null, "Todavía no estan creados todos los Equipos");
		} else {
			fecha = asignarFecha();
			if (ListaPartidos.size()<4) {
				do {
					num=(String)JOptionPane.showInputDialog(null, "Elija numero de Partido", null, 0, null, numeros, numeros[0]);
					do {	
						JOptionPane.showMessageDialog(null, "Elija el primer Equipo");
						equipo1 = asignarEquipoAPartido();
						JOptionPane.showMessageDialog(null, "Elija el segundo Equipo");
						equipo2 = asignarEquipoAPartido();
						if (equipo1==equipo2) {
							JOptionPane.showMessageDialog(null, "Los equipos tienen que ser distintos");
						}
					} while (equipo1==equipo2);
						fase="Primera fase";
						ListaPartidos.add(new Partido(equipo1,equipo2,num,fase,fecha));
						
					
				} while (ListaPartidos.size()<4);
				
			} else if (ListaPartidos.size()<6) {
				for (Partido partido : ListaPartidos) {
					if (partido.getNumPartido().equals("Primero")) {
						equipo1=partido.getGanador();
					}
					if (partido.getNumPartido().equals("Segundo")) {
						equipo2=partido.getGanador();
						fecha=partido.getFecha().plusDays(1);
					}
					if (!(equipo1==null)&&!(equipo2==null)) {
						num="Quinto";
						fase="Segunda fase";
						fecha=partido.getFecha().plusDays(1);
						ListaPartidos.add(new Partido(equipo1,equipo2,num,fase,fecha));
					}
					
				}
				for (Partido partido : ListaPartidos) {
					if (partido.getNumPartido().equals("Tercero")) {
						equipo1=partido.getGanador();
					}
					if (partido.getNumPartido().equals("Cuarto")) {
						equipo2=partido.getGanador();
					}
					if (!(equipo1==null)&&!(equipo2==null)) {
						num="Sexto";
						fase="Segunda fase";
						fecha=partido.getFecha().plusDays(1);
						ListaPartidos.add(new Partido(equipo1,equipo2,num,fase,fecha));
					}
					
				}
			} else if (ListaPartidos.size()<7) {
				for (Partido partido : ListaPartidos) {
					if (partido.getNumPartido().equals("Quinto")) {
						equipo1=partido.getGanador();
					}
					if (partido.getNumPartido().equals("Sexto")) {
						equipo2=partido.getGanador();
					}
					if (!(equipo1==null)&&!(equipo2==null)) {
						num="Septimo";
						fase="Tercera fase";
						fecha=partido.getFecha().plusDays(1);
						ListaPartidos.add(new Partido(equipo1,equipo2,num,fase,fecha));
					}
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ya se asignaron todos los partidos");
			}
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
	public void buscarPartido() {
		Partido seleccionado = seleccionarPartido();
		JOptionPane.showMessageDialog(null, seleccionado);
	}
	public void  verCantEquipos(){
		JOptionPane.showMessageDialog(null, "Hay "+ListaEquipos.size()+"Equipos");
		
	}
	public void  verListaEquipos(){
		String lista="";
		for (int i = 0; i < ListaEquipos.size(); i++) {
			lista=lista+"\n"+ListaEquipos.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);
		
	}
	public void  verListaPartidos(){
		String lista="";
		for (int i = 0; i < ListaPartidos.size(); i++) {
			lista=lista+"\n"+ListaPartidos.get(i);
		}
		JOptionPane.showMessageDialog(null, lista);
		
	}
	public void jugarPartido(Partido partido) {
		int goles1=0, goles2=0, apuesta=0;
		String [] opciones= {"Sí","No"};
		String [] opcionesdeapuesta= {partido.getEquipo1().getNombre(),partido.getEquipo2().getNombre()};
		String opcion;
		String apostado = "";
		if (partido.getGanador()==null) {
			if (partido.getEquipo1().getListajugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar porque no hay jugadores suficientes");
			} else if (partido.getEquipo2().getListajugadores().size()<7) {
				JOptionPane.showMessageDialog(null, "No se puede jugar porque no hay jugadores suficientes");
			} else {
				JOptionPane.showMessageDialog(null, "Se jugara el partido de "+partido.getEquipo1().getNombre()+" y "+partido.getEquipo2().getNombre());
				opcion=(String)JOptionPane.showInputDialog(null, "¿Desea Apostar? si gana dobla su apuesta", null, 0, null, opciones, opciones[0]);
				if (opcion.equals("Sí")) {
					apuesta=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad a apostar"));
					apostado=(String)JOptionPane.showInputDialog(null, "Ingrese por que equipo quiere apostar", null, 0, null, opcionesdeapuesta, opcionesdeapuesta[0]);
				}
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
				partido.setCantgoles(goles1+goles2);
				partido.setGoles1(goles1);
				partido.setGoles2(goles2);
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
					if (opcion.equals("Sí")) {
						if (apostado.equals(partido.getGanador().getNombre())) {
							apuesta=apuesta*2;
							JOptionPane.showMessageDialog(null, "Ganó la apuesta. Gana "+apuesta+" pesos");
						} else {
							JOptionPane.showMessageDialog(null, "Perdió la apuesta");
						}
					}
					
			}
		} else {
			JOptionPane.showMessageDialog(null, "El partido ya se jugó");
		}
		
		
		
	}
	public void verEstadisticas(){
		int max=0; 
		String maxjugador="",opcion,maxgoles="", maxdif="",ganador="";
		String [] opciones= {"Jugador con más goles","Equipo que ganó el torneo","Partido con más goles","Ver partido con mayor diferencia de goles"};
		
		opcion=(String)JOptionPane.showInputDialog(null, "Ingrese lo que desea ver", null, 0, null, opciones, opciones[0]);
		switch (opcion) {
		case "Jugador con más goles":
			for (Equipo equipo : ListaEquipos) {
				for (Jugador jugador : equipo.getListajugadores()) {
					if (jugador.getCantGoles()>max) {
						max=jugador.getCantGoles();
						maxjugador=jugador.getNombre()+" del equipo"+equipo.getNombre()+" es el jugador con más goles";
					}
				}
			}
			JOptionPane.showMessageDialog(null, maxjugador);
			break;
		case "Ver partido con mayor diferencia de goles":
			max=0;
		int	dif=0;
			
				for (Partido partido : ListaPartidos) {
					if (partido.getGoles1()>partido.getGoles2()) {
						dif = partido.getGoles1() - partido.getGoles2();
					} else {
						dif = partido.getGoles2() - partido.getGoles1();
					}
					
					if (dif>max) {
						max=dif;
						maxdif="El partido con mayor diferencia fue el de "+partido.getEquipo1().getNombre()+" contra "+partido.getEquipo2().getNombre();
					}
				}
			
			JOptionPane.showMessageDialog(null, maxdif);
			break;
		case "Partido con más goles":
			for (Partido partido : ListaPartidos) {
				if (partido.getCantgoles()>max) {
					max=partido.getCantgoles();
					maxgoles="El partido entre "+partido.getEquipo1()+ "y "+partido.getEquipo2()+" es el que tuvo más goles";
				}
			}
			JOptionPane.showMessageDialog(null, maxgoles);
			break;
		case "Equipo que ganó el torneo":
			for (Equipo equipo : ListaEquipos) {
				if (equipo.getPartidosganados()>max) {
					max=equipo.getPartidosganados();
					ganador="El equipo ganador fue "+equipo;
				}
			}
			JOptionPane.showMessageDialog(null, ganador);
			break;
		}
	
		
	
		
		
		
		
		
		
		
	}
		
		
	}

