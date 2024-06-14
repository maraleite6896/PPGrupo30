/*
* Nome: Mara Beatriz da Silva Leite
* Número: 8210403
* Turma: T3
*
* Nome: Sérgio Daniel Andrade Dias
* Número: 8200535
* Turma: T2
*/
package PP_GP30.project;
import com.estg.core.EmergencyType;


public class Projeto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AmbulanceImpl ambulance = new AmbulanceImpl("23-23-aa",EmergencyType.EMERGENCY,2,3);
        System.out.print(ambulance.toString());
    }
    
}
