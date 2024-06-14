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

import com.estg.core.Destination;
import com.estg.core.DestinationType;

/**
 * The DestinationImpl class implements the Destination interface and represents a destination.
 * It has seven private fields: code, destinationType, name, durationTableToOtherDestinations, durationToDestination, latitude, and longitude, 
 * which are initialized through the constructor.
 */
public class DestinationImpl implements Destination {

    //The unique code of the destination.
    private String code;

    //The type of the destination (e.g. hospital, clinic, etc.).
    private DestinationType destinationType;

    //The name of the destination.
    private String name;

    //A table of durations to other destinations.
    private DurationToOtherDestinationsImpl durationTableToOtherDestinations[];

    //The duration to this destination.
    private int durationToDestination;

    //The latitude of the destination.
    private double latitude;

    //The longitude of the destination.
    private double longitude;

    /**
     * Initializes an instance of the DestinationImpl class with the provided parameters.
     * 
     * @param code The unique code of the destination.
     * @param destinationType The type of the destination (e.g. hospital, clinic, etc.).
     * @param name The name of the destination.
     * @param durationTableToOtherDestinations A table of durations to other destinations.
     * @param durationToDestination The duration to this destination.
     * @param latitude The latitude of the destination.
     * @param longitude The longitude of the destination.
     */
    public DestinationImpl(String code, DestinationType destinationType, String name, DurationToOtherDestinationsImpl[] durationTableToOtherDestinations, int durationToDestination, double latitude, double longitude) {
        this.code = code;
        this.destinationType = destinationType;
        this.name = name;
        this.durationTableToOtherDestinations = durationTableToOtherDestinations;
        this.durationToDestination = durationToDestination;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the unique code of the destination.
     * 
     * @return The unique code of the destination.
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Returns the type of the destination (e.g. hospital, clinic, etc.).
     * 
     * @return The type of the destination.
     */
    @Override
    public DestinationType getDestinationType() {
        return this.destinationType;
    }

    /**
     * Returns the name of the destination.
     * 
     * @return The name of the destination.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns a table of durations to other destinations.
     * 
     * @return A table of durations to other destinations.
     */
    @Override
    public DurationToOtherDestinationsImpl[] getDurationTableToOtherDestinations() {
        return this.durationTableToOtherDestinations;
    }

    /**
     * Returns the duration to this destination.
     * 
     * @param dstntn The destination to which the duration is requested.
     * @return The duration to this destination.
     */
    @Override
    public int getDurationToDestination(Destination dstntn) {
        return this.durationToDestination;
    }

    /**
     * Returns the latitude of the destination.
     * 
     * @return The latitude of the destination.
     */
    @Override
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Returns the longitude of the destination.
     * 
     * @return The longitude of the destination.
     */
    @Override
    public double getLongitude() {
        return this.longitude;
    }

}
