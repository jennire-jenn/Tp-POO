package tp1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		String [] opcionesprincipales = {"Gestionar equipos","Gestionar jugadores","Gestionar partidos","Salir"};
		String [] opcionesdeequipo = {"Agregar Jugador","Eliminar Jugador", "Modificar Jugador","Rellenar","Ver Jugador","Ver cantidad de Jugadores", "Ver Lista de Jugadores", "Salir"};
		String [] opcionesdegestor = {"Agregar Equipo","Rellenar Equipos","Usar Equipos Predeterminados","Eliminar Equipo", "Modificar Equipo","Ver Equipo","Ver cantidad de Equipos", "Ver Lista de Equipos","Salir"};
		String [] opcionesdepartido = {"Asignar Partido", "Jugar Partido","Ver estadisticas","Ver informacion del partido","Salir"};
		Equipo equipo;
		Partido partido;
		String opcion,opcion2;
		GestorEquipos gestor = new GestorEquipos();
		JOptionPane.showMessageDialog(null, "Para usar este programa primero debes agregar los equipos en 'Gestionar Equipos'. \nAquí tienes la opción de crearlos manualmente, usar los equipos predeterminados o rellenarlos todos. "
				+ "\nEn caso de  crearlos manualmente debes dirijirte a 'Gestionar Jugadores' para agregarle los jugadores a cada equipo por separado. \nCuando ya tienes los equipor puedes ir a 'Gestionar partidos.' \nAquí debes asignar los partidos antes de poder jugarlos. Entre cada ronda debes asignar los partidos de la siguiente.", "Torneo", JOptionPane.WARNING_MESSAGE,new ImageIcon(GestorEquipos.class.getResource("/img/copa.jpg")));
		do {
			opcion=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/copa.jpg")), opcionesprincipales, opcionesprincipales[0]);
			switch (opcion) {
			case "Gestionar jugadores":
				if (gestor.getListaEquipos().size()==0) {
					JOptionPane.showMessageDialog(null, "Todavia no hay ningun equipo creado");
					opcion2="Salir";
				} else {
					JOptionPane.showMessageDialog(null, "Elija de que equipo quiere gestionar los jugadores");
					equipo= gestor.seleccionarEquipo();
					
					
					do {
						opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/jugador.jpg")), opcionesdeequipo, opcionesdeequipo[0]);
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
					opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/equipo.png")), opcionesdegestor, opcionesdegestor[0]);
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
					case "Usar Equipos Predeterminados":
						gestor.usarEquiposPredeterminados();
						break;
					}
				} while (!opcion2.equals("Salir"));
				break;
			case "Gestionar partidos":
				
				
				do {
					opcion2=(String) JOptionPane.showInputDialog(null, "Ingrese la accion a realizar", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/partido.png")), opcionesdepartido, opcionesdepartido[0]);
					switch (opcion2) {
					case "Ver informacion del partido":
						gestor.buscarPartido();
						break;
					case "Asignar Partido":
						gestor.asignarPartido();
						break;
					case "Jugar Partido":
						if (gestor.getListaPartidos().size()==0) {
							JOptionPane.showMessageDialog(null, "Todavia no hay partidos");
						} else {
							partido=gestor.seleccionarPartido();
							gestor.jugarPartido(partido);
						}
						
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
