/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.EmergencyType;
import com.estg.core.Pathology;
import com.estg.core.PathologyType;

/**
 *
 * @author maraleite
 */
public class PathologyImpl implements Pathology {

    private PathologyType pathologyType;
    private EmergencyType emergenceType;

    public PathologyImpl(PathologyType pathologyType, EmergencyType emergenceType) {
        this.pathologyType = pathologyType;
        this.emergenceType = emergenceType;
    }

    @Override
    public PathologyType getPathologyType() {
        return pathologyType;
    }

    @Override
    public EmergencyType getEmergenceType() {
        return emergenceType;
    }

}
