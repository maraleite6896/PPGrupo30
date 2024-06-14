/*
* Nome: Mara Beatriz da Silva Leite
* Número: 8210403
* Turma: T3
*
* Nome: Sérgio Daniel Andrade Dias
* Número: 8200535
* Turma: T2
*/
package PP_GP30.management;

import com.estg.core.Ambulance;
import com.estg.core.EmergencyType;
import com.estg.core.FireDepartment;
import com.estg.core.Pathology;
import com.estg.core.Service;
import com.estg.dailyManagement.Report;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteGenerator;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 * The RouteGeneratorImpl class implements the RouteGenerator interface and generates routes for a fire department.
 */
public class RouteGeneratorImpl implements RouteGenerator {

    //The array of generated routes.
    private Route generateRoute[];

    /**
     * Generates routes for the given fire department, strategy, route validator, and report.
     * 
     * @param fd the fire department to be analyzed
     * @param strtg the strategy to be followed
     * @param rv the route validator considering the restrictions
     * @param report the report
     * @return the list of routes
     */
    @Override
    public Route[] generateRoute(FireDepartment fd, Strategy strtg, RouteValidator rv, Report report) {
        int count = 0;
        if (fd.getAmbulances() == null || fd.getAmbulances().length == 0) {
            return null;
        }

        if (fd.getClients() == null || fd.getClients().length == 0) {
            return null;
        }

        if (generateRoute.length == count) {
            generateRoute = (Route[]) increaseArraySizeByFive(generateRoute);
        }
        
        Ambulance[] ambulance = fd.getAmbulances();
        Service[] services = fd.getServices();
        
        for (int i = 0; i < fd.getServices().length; i++) {
            Pathology[] pathology = services[i].getPathologies();
            EmergencyType[] emergencyType = new EmergencyType[0];
            EmergencyType[] nonEmergencyType = new EmergencyType[0];
            int countEmergency = 0, countNonEmergency = 0;
            for (int j = 0; j < services[i].getPathologies().length; j++) {
                if (pathology[j].getEmergenceType()== EmergencyType.EMERGENCY) {
                    if (emergencyType.length == countEmergency) {
                        emergencyType = (EmergencyType[]) increaseArraySizeByFive(emergencyType);
                    }

                    emergencyType[countEmergency] = pathology[j].getEmergenceType();
                    countEmergency++;
                } else if (pathology[j].getEmergenceType() == EmergencyType.NON_EMERGENCY) {
                    if (nonEmergencyType.length == countNonEmergency) {
                        nonEmergencyType = (EmergencyType[]) increaseArraySizeByFive(nonEmergencyType);
                    }

                    nonEmergencyType[countNonEmergency] = pathology[j].getEmergenceType();
                    countNonEmergency++;
                }
            }
            for (int k = 0; k < fd.getAmbulances().length; k++) {
                if (emergencyType.length > 0) {
                    if (ambulance[k].getAmbulanceType() == EmergencyType.EMERGENCY && ambulance[k].getMaxUrgents() >= countNonEmergency) {

                    }
                }
            }
        }
        return generateRoute;
    }

    /**
     * Increases the size of the given array by 5.
     * 
     * @param originalArray the array to be increased
     * @return the new array with 5 more free spaces
     */
    public static Object[] increaseArraySizeByFive(Object[] originalArray) {
        int newSize = originalArray.length + 5;
        Object[] newArray = new Object[newSize];
        for(int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        return newArray;
    }
}
