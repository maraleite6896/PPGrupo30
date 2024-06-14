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
import com.estg.core.Pathology;
import com.estg.core.PathologyType;

/**
 * The PathologyImpl class implements the Pathology interface and represents a pathology.
 * It has two private fields: pathologyType and emergencyType.
 */
public class PathologyImpl implements Pathology {

    //The type of pathology.
    private PathologyType pathologyType;

    //The type of emergency.
    private EmergencyType emergencyType;

    /**
     * Constructs a PathologyImpl object with the given pathology type and emergency type.
     * 
     * @param pathologyType the type of pathology
     * @param emergencyType the type of emergency
     */
    public PathologyImpl(PathologyType pathologyType, EmergencyType emergencyType) {
        this.pathologyType = pathologyType;
        this.emergencyType = emergencyType;
    }

    /**
     * Returns the type of pathology.
     * 
     * @return the type of pathology
     */
    @Override
    public PathologyType getPathologyType() {
        return this.pathologyType;
    }

    /**
     * Returns the type of emergency.
     * 
     * @return the type of emergency
     */
    @Override
    public EmergencyType getEmergencyType() {
        return this.emergencyType;
    }

}
