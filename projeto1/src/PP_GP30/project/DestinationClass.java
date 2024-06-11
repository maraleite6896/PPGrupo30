/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.Destination;
import com.estg.core.DestinationType;

/**
 *
 * @author maraleite
 */
public class DestinationClass implements Destination {
    
    private String code;
    private DestinationType destinationType;
    private String name;
    private DurationToOtherDestinationsClass durationTableToOtherDestinations[];
    private int durationToDestination;
    private double latitude;
    private double longitude;
    
    public DestinationClass(String code, DestinationType destinationType, String name, DurationToOtherDestinationsClass[] durationTableToOtherDestinations, int durationToDestination, double latitude, double longitude) {
        this.code = code;
        this.destinationType = destinationType;
        this.name = name;
        this.durationTableToOtherDestinations = durationTableToOtherDestinations;
        this.durationToDestination = durationToDestination;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public DestinationType getDestinationType() {
        return destinationType;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public DurationToOtherDestinationsClass[] getDurationTableToOtherDestinations() {
        return durationTableToOtherDestinations;
    }
    @Override
    public int getDurationToDestination(Destination dstntn) {
       return durationToDestination;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
       return longitude;
    }
    
}
