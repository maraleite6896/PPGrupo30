/*
* Nome: Mara Leite
* Número: 8210403
* Turma: 
*
* Nome: Sérgio Daniel Andrade Dias
* Número: 8200535
* Turma: 2
*/

package PP_GP30.project;

import com.estg.core.Ambulance;
import com.estg.core.EmergencyType;

/*
 * The AmbulanceImpl class implements the Ambulance interface and represents an ambulance vehicle.
 * It has four private fields: plate, maxPassengers, maxUrgents, and ambulanceType, which are initialized through the constructor.
 */
public class AmbulanceImpl implements Ambulance {

    //The license plate number of the ambulance.
    private String plate;
    
    //The maximum number of passengers the ambulance can carry.
    private int maxPassengers;

    //The maximum number of urgent cases the ambulance can handle.
    private int maxUrgents;

    //The type of emergency the ambulance is designed to handle.
    private EmergencyType ambulanceType;

    /**
     * Initializes an instance of the AmbulanceImpl class with the provided parameters.
     * 
     * @param plate The license plate number of the ambulance.
     * @param ambulanceType The type of emergency the ambulance is designed to handle.
     * @param maxPassengers The maximum number of passengers the ambulance can carry.
     * @param maxUrgents The maximum number of urgent cases the ambulance can handle.
     */
    public AmbulanceImpl(String plate, EmergencyType ambulanceType, int maxPassengers, int maxUrgents) {
        this.plate = plate;
        this.ambulanceType = ambulanceType;
        this.maxPassengers = maxPassengers;
        this.maxUrgents = maxUrgents;
    }

    /**
     * Returns the license plate number of the ambulance.
     * 
     * @return The license plate number of the ambulance.
     */
    @Override
    public String getPlate() {
        return this.plate;
    }

    /**
     * Returns the maximum number of passengers the ambulance can carry.
     * 
     * @return The maximum number of passengers the ambulance can carry.
     */
    @Override
    public int getMaxPassengers() {
        return this.maxPassengers;
    }

    /**
     * Returns the maximum number of urgent cases the ambulance can handle.
     * 
     * @return The maximum number of urgent cases the ambulance can handle.
     */
    @Override
    public int getMaxUrgents() {
        return this.maxUrgents;
    }

    /**
     * Returns the type of emergency the ambulance is designed to handle.
     * 
     * @return The type of emergency the ambulance is designed to handle.
     */
    @Override
    public EmergencyType getAmbulanceType() {
        return this.ambulanceType;
    }

    /**
     * Returns a string representation of the ambulance, including its plate number, maximum passengers, maximum urgent cases, and ambulance type.
     * 
     * @return A string representation of the ambulance.
     */
    @Override
    public String toString() {
        return "AmbulanceClass{" + "plate=" + plate + ", maxPassengers=" + maxPassengers + ", maxUrgents=" + maxUrgents + ", ambulanceType=" + ambulanceType + '}';
    }
}
