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

import com.estg.core.EmergencyType;
import com.estg.core.Pathology;
import com.estg.core.PathologyType;
import com.estg.dailyManagement.Report;
import java.time.LocalDateTime;

/**
 * The ReportImpl class implements the Report interface and represents a report.
 * It has six private fields: date, totalDuration, numberOfServices, numberOfRoutes, numberOfClients,
 * numberOfServicesPathology, and numberOfServicesByPathology.
 */
public class ReportImpl implements Report {

    //The date of the report.
    private LocalDateTime date;

    //The total duration of the report.
    private double totalDuration;

    //The number of services in the report.
    private int numberOfServices;
    
    //The number of routes in the report.
    private int numberOfRoutes;

    //The number of clients in the report.
    private int numberOfClients;

    //The number of services by pathology in the report.
    private int numberOfServicesPathology;

    //The number of services by pathology type in the report.
    private int numberOfServicesByPathology;

    /**
     * Returns the date of the report.
     * 
     * @return the date of the report
     */
    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Returns the total duration of the report.
     * 
     * @return the total duration of the report
     */
    @Override
    public double getTotalDuration() {
        return this.totalDuration;
    }

    /**
     * Returns the number of services in the report for the given emergency type.
     * 
     * @param et the emergency type
     * @return the number of services in the report for the given emergency type
     */
    @Override
    public int getNumberOfServices(EmergencyType et) {
        return this.numberOfServices;
    }

    /**
     * Returns the number of routes in the report.
     * 
     * @return the number of routes in the report
     */
    @Override
    public int getNumberOfRoutes() {
        return this.numberOfRoutes;
    }

    /**
     * Returns the number of clients in the report.
     * 
     * @return the number of clients in the report
     */
    @Override
    public int getNumberOfClients() {
        return this.numberOfClients;
    }

    /**
     * Returns the number of services by pathology in the report for the given pathology.
     * 
     * @param pthlg the pathology
     * @return the number of services by pathology in the report for the given pathology
     */
    @Override
    public int getNumberOfServicesByPathology(Pathology pthlg) {
        return this.numberOfServicesPathology;
    }

    /**
     * Returns the number of services by pathology type in the report for the given pathology type.
     * 
     * @param pt the pathology type
     * @return the number of services by pathology type in the report for the given pathology type
     */
    @Override
    public int getNumberOfServicesByPathology(PathologyType pt) {
        return this.numberOfServicesByPathology;
    }

}
