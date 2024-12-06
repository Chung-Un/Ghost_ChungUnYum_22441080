/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ghostfinal;

/**
 *
 * @author chung
 */
public class Player {
 String usuario,password;
 String[][] usuariosInfo = {{"chungun23","pollochuco24","mellzx"},
                            {"mcr4ever","pollochu","gatos001"},
                            };

 
    
    String partidas[];
    int puntos= 0;
    int partidasJugadas, partidasGanadas, partidasEmpatadas, partidasPerdidas;
    int cantFantasmas, cantFantasmasBuenos,cantFantasmasMalos,maxFantasmas, fantasmasBuenosCapturados, fantasmasMalosCapturados;
    boolean fantasmaSale;
 
    public Player (String usuario, String password){
    this.usuario = usuario;
    this.password = password;
    partidasJugadas = 0;
    partidasGanadas=0;
    partidasEmpatadas=0;
    partidasPerdidas=0;
    cantFantasmas=0;
    cantFantasmasBuenos=4;
    cantFantasmasMalos=4;
    maxFantasmas=8;
    fantasmasBuenosCapturados=0;
    fantasmasMalosCapturados=0;
    fantasmaSale=false;
    puntos=0;
    
    partidas = new String[100];
    }

    public int getMaxFantasmas() {
        return maxFantasmas;
    }

    public void setMaxFantasmas(int maxFantasmas) {
        this.maxFantasmas = maxFantasmas;
    }

    public int getCantFantasmas() {
        return cantFantasmas;
    }

    public void setCantFantasmas(int cantFantasmas) {
        this.cantFantasmas = cantFantasmas;
    }

    public int getCantFantasmasBuenos() {
        return cantFantasmasBuenos;
    }

    public void setCantFantasmasBuenos(int cantFantasmasBuenos) {
        this.cantFantasmasBuenos = cantFantasmasBuenos;
    }

    public int getCantFantasmasMalos() {
        return cantFantasmasMalos;
    }

    public void setCantFantasmasMalos(int cantFantasmasMalos) {
        this.cantFantasmasMalos = cantFantasmasMalos;
    }
    
    
   
    
    void registrarPartida (String partidaActual){
    partidas[partidasJugadas] = partidaActual;
    partidasJugadas++;
    }
    
    String mostrarPartidas(){
    String todasPartidas="";
     
    for(int i=0;i<partidasJugadas;i++){
     todasPartidas+= partidas[i] + "\n";
    }
    
    return todasPartidas;
    }
 
    public String[][] getUsuariosInfo() {
        return usuariosInfo;
    }

    public void setUsuariosInfo(String[][] usuariosInfo) {
        this.usuariosInfo = usuariosInfo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
      
}
