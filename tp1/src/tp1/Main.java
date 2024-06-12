package tp1;

import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		String [] opcionesprincipales = {"Gestionar jugadores","Gestionar equipos", "Gestionar partidos","Salir"};
		String [] opcionesdeequipo = {"Agregar Jugador","Eliminar Jugador", "Modificar Jugador","Rellenar","Ver Jugador","Ver cantidad de Jugadores", "Ver Lista de Jugadores", "Salir"};
		String [] opcionesdegestor = {"Agregar Equipo","Rellenar Equipos","Eliminar Equipo", "Modificar Equipo","Ver Equipo","Ver cantidad de Equipos", "Ver Lista de Equipos","Salir"};
		String [] opcionesdepartido = {"Asignar Partido", "Jugar Partido","Ver estadisticas","Salir"};
		Equipo equipo;
		Partido partido;
		String opcion,opcion2;
		GestorEquipos gestor = new GestorEquipos();
		
		do {
			opcion=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, 0, null, opcionesprincipales, opcionesprincipales[0]);
			switch (opcion) {
			case "Gestionar jugadores":
				if (gestor.getListaEquipos().size()==0) {
					JOptionPane.showMessageDialog(null, "Todavia no hay ningun equipo creado");
					opcion2="Salir";
				} else {
					JOptionPane.showMessageDialog(null, "Elija de que equipo quiere gestionar los jugadores");
					equipo= gestor.seleccionarEquipo();
					
					
					do {
						opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, 0, null, opcionesdeequipo, opcionesdeequipo[0]);
						switch (opcion2) {
						case "Agregar Jugador":
							equipo.agregarJugador();
							break;
						case "Rellenar":
							int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de jugadores"));
							equipo.agregarJugadoresFalso(cant);
							break;
						case "Eliminar Jugador":
							equipo.eliminarJugador();
							break;
						case "Modificar Jugador":
							equipo.modificarJugador();
							break;
						case "Ver Jugador":
							equipo.buscarJugador();
							break;
						case "Ver cantidad de Jugadores":
							equipo.verCantJugadores();
							break;
						case "Ver Lista de Jugadores":
							equipo.verListaJugadores();
							break;
						}
					} while (!opcion2.equals("Salir"));
				}
				
				break;
			
			case "Gestionar equipos":
				
				
				do {
					opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, 0, null, opcionesdegestor, opcionesdegestor[0]);
					switch (opcion2) {
					case "Agregar Equipo":
						gestor.agregarEquipo();
						break;
					case "Eliminar Equipo":
						gestor.eliminarEquipo();
						break;
					case "Modificar Equipo":
						gestor.modificarEquipo();
						break;
					case "Ver Equipo":
						gestor.buscarEquipo();
						break;
					case "Ver cantidad de Equipos":
						gestor.verCantEquipos();
						break;
					case "Ver Lista de Equipos":
						gestor.verListaEquipos();
						break;
					case "Rellenar Equipos":
						gestor.rellenarEquipos();
						break;
					}
				} while (!opcion2.equals("Salir"));
				break;
			case "Gestionar partidos":
				
				
				do {
					opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, 0, null, opcionesdepartido, opcionesdepartido[0]);
					switch (opcion2) {
					case "Asignar Partido":
						gestor.asignarPartido();
						break;
					case "Jugar Partido":
						partido=gestor.seleccionarPartido();
						gestor.jugarPartido(partido);
					break;
					case "Ver estadisticas":
						gestor.verEstadisticas();
					}
				} while (!opcion2.equals("Salir"));
				break;
			}
		} while (!opcion.equals("Salir"));
		
		
	}
	

}
