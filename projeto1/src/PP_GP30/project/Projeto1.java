/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PP_GP30.project;
import com.estg.core.EmergencyType;


/**
 *
 * @author maraleite
 */
public class Projeto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AmbulanceClass ambulancia = new AmbulanceClass("23-23-aa",EmergencyType.EMERGENCY,2,3);
        System.out.print(ambulancia.toString());
    }
    
}
