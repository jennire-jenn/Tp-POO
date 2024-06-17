package tp1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
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
			
			for (Partido partido : ListaPartidos) {
				if (partido.getNumPartido()==partidoSeleccionado) {
					seleccionado = partido;
					JOptionPane.showMessageDialog(null, partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre());
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
	 int cant;
	 cant=8-ListaEquipos.size();
	 for (int i = 0; i < cant; i++) {
		 int num= i+1;
		 ListaEquipos.add(new Equipo("Equipo"+num,"colores","ciudad"));
	}
	 JOptionPane.showMessageDialog(null, "Se crearon "+cant+" equipos");
	 for (Equipo equipo : ListaEquipos) {
		equipo.agregarJugadoresFalso(11);
		equipo.setCantjug(equipo.getCantjug()+11);
	}
	 JOptionPane.showMessageDialog(null, "Se agregaron 11 jugadores a todos los equipos");
		 
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
	public void  asignarPartido(){
		Equipo equipo1=null;
		Equipo equipo2=null;
		Equipo equipo3=null;
		Equipo equipo4=null;
		LocalDate fecha;
		String num="",fase="";
		if (ListaEquipos.size()<8) {
			JOptionPane.showMessageDialog(null, "Todavía no estan creados todos los Equipos");
		} else {
			
			if (ListaPartidos.size()<4) {
				fecha = asignarFecha();
				generarPartidoAleatorio(fecha);
				
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
						JOptionPane.showMessageDialog(null, "Se agrego el quinto partido");
						break;
					}
					
				}
				for (Partido partido : ListaPartidos) {
					if (partido.getNumPartido().equals("Tercero")) {
						equipo3=partido.getGanador();
					}
					if (partido.getNumPartido().equals("Cuarto")) {
						equipo4=partido.getGanador();
					}
					if (!(equipo3==null)&&!(equipo4==null)) {
						num="Sexto";
						fase="Segunda fase";
						fecha=partido.getFecha().plusDays(1);
						ListaPartidos.add(new Partido(equipo3,equipo4,num,fase,fecha));
						JOptionPane.showMessageDialog(null, "Se agrego el sexto partido");
						break;
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
						JOptionPane.showMessageDialog(null, "Se agrego el septimo partido");
						break;
					}
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ya se asignaron todos los partidos");
			}
		}
		
		
	}
	public void  buscarEquipo(){
		if (ListaEquipos.size()==0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay equipos");
		} else {

		}
		Equipo seleccionado = seleccionarEquipo();
		for (Equipo equipo : ListaEquipos) {
			if (equipo==seleccionado) {
				JOptionPane.showMessageDialog(null, equipo);
			}
		}
		
		
	}
	public void buscarPartido() {
		if (ListaPartidos.size()==0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay partidos");
		} else {
			Partido seleccionado = seleccionarPartido();
			JOptionPane.showMessageDialog(null, seleccionado);
		}
		
	}
	public void  verCantEquipos(){
		JOptionPane.showMessageDialog(null, "Hay "+ListaEquipos.size()+" Equipos");
		
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
		String descripcion="";
		String apostado = "";
		if (partido.getEstado().equals("Pendiente")) {
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
								descripcion=descripcion+"\n"+jugador.getNombre()+" de "+partido.getEquipo1().getNombre()+" hizo gol.";
								goles1++;
							}
						}
						} 
							
						
						
					
					 for (Jugador jugador : partido.getEquipo2().getListajugadores()) {
							if (!jugador.getPosicion().equals("Arquero")) {
								if ((int)(Math.random()*5)==0) {
									jugador.setCantGoles(jugador.getCantGoles()+1);
									descripcion=descripcion+"\n"+jugador.getNombre()+" de "+partido.getEquipo2().getNombre()+" hizo gol.";
									goles2++;
								}
							}
								
							
							
							
						}
					} while (goles1==goles2);
				partido.setCantgoles(goles1+goles2);
				partido.setGoles1(goles1);
				partido.setGoles2(goles2);
				partido.setEstado("Finalizado");
				partido.getEquipo1().setPartidosjugados(partido.getEquipo1().getPartidosjugados()+1);
				partido.getEquipo2().setPartidosjugados(partido.getEquipo2().getPartidosjugados()+1);
				descripcion=descripcion+"\nEl resultado del partido fue "+goles1+"-"+goles2;
					if (goles1<goles2) {
						partido.setGanador(partido.getEquipo2());
						partido.setPerdedor(partido.getEquipo1());

						partido.getEquipo2().setPartidosganados(partido.getEquipo2().getPartidosganados()+1);
						descripcion=descripcion+"\nEl equipo ganador fue: "+partido.getEquipo2().getNombre();
					} else {
						partido.setGanador(partido.getEquipo1());
						partido.setPerdedor(partido.getEquipo2());
						partido.getEquipo1().setPartidosganados(partido.getEquipo1().getPartidosganados()+1);
						descripcion=descripcion+"\nEl equipo ganador fue: "+partido.getEquipo1().getNombre();
					}
					JOptionPane.showMessageDialog(null, descripcion, partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre(), JOptionPane.WARNING_MESSAGE,new ImageIcon(GestorEquipos.class.getResource("/img/gol.jpg")));
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
		String maxjugador="",opcion,maxgoles="", maxdif="",ganador="",fase;
		String [] opciones= {"Jugador con más goles","Equipo que más ganó","Partido con más goles","Ver partido con mayor diferencia de goles","Salir"};
		if (ListaPartidos.size()==0) {
			JOptionPane.showMessageDialog(null, "Todavia no hay partidos");
		} else {
			if (ListaPartidos.size()==4) {
				fase="primera fase";
			} else if (ListaPartidos.size()==6) {
				fase="segunda fase";
			} else {
				fase="tercera fase";
			}
			
			do {
				opcion=(String)JOptionPane.showInputDialog(null, "Actualmente en "+fase, null, 0, null, opciones, opciones[0]);
				switch (opcion) {
				case "Jugador con más goles":
					for (Equipo equipo : ListaEquipos) {
						for (Jugador jugador : equipo.getListajugadores()) {
							if (jugador.getCantGoles()>max) {
								max=jugador.getCantGoles();
								maxjugador=jugador.getNombre()+" del equipo "+equipo.getNombre()+" es el jugador con más goles";
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
							maxgoles="El partido entre "+partido.getEquipo1().getNombre()+ " y "+partido.getEquipo2().getNombre()+" es el que tuvo más goles";
						}
					}
					JOptionPane.showMessageDialog(null, maxgoles);
					break;
				case "Equipo que más ganó":
					for (Equipo equipo : ListaEquipos) {
						if (equipo.getPartidosganados()>max) {
							max=equipo.getPartidosganados();
							ganador="El equipo ganador fue "+equipo.getNombre();
						}
					}
					JOptionPane.showMessageDialog(null, ganador);
					break;
				}
			
			} while (!opcion.equals("Salir"));
			
		}
	
		
	
		
		
		
		
		
		
		
	}
	
	public void generarPartidoAleatorio(LocalDate fecha) {
		int[]aleatorio=new int[8];
		String num;
		String [] numeros = {"Primero","Segundo","Tercero","Cuarto"};
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			int numero;
			boolean flag;
			do {
				
			
			flag=true;
			
			numero = random.nextInt(8);
			
			for (int j = 0; j < i; j++) {
				if (numero == aleatorio[j]) {
					flag = false;
					break;
				}
			}
			} while (!flag);
			aleatorio[i] = numero;
		}
		

		for (int i = 0; i < aleatorio.length; i+=2) {
			do {
				num=null;
				num=(String)JOptionPane.showInputDialog(null, "Elija numero de Partido", null, 0, null, numeros, numeros[0]);
				if (ListaPartidos.size()>0) {
					for (Partido partido : ListaPartidos) {
						if (num.equals(partido.getNumPartido())) {
							num=null;
							JOptionPane.showMessageDialog(null, "Ya se asigno ese partido");
							break;
						}
					}
				}
			} while (num==null);
			ListaPartidos.add(new Partido(ListaEquipos.get(aleatorio[i]),ListaEquipos.get(aleatorio[i+1]),num,"Primera fase",fecha));
			JOptionPane.showMessageDialog(null, "Se creo el partido numero "+num+" sera entre "+ListaEquipos.get(aleatorio[i]).getNombre()+" y "+ListaEquipos.get(aleatorio[i+1]).getNombre());
		}
	}
		
		
	}

