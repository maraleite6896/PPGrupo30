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

import com.estg.core.Service;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;


/**
 * The RouteValidatorImpl class implements the RouteValidator interface and validates if a service can be added to a route.
 */
public class RouteValidatorImpl implements RouteValidator {

    //The flag indicating whether the service can be added to the route.
    private boolean validate;

    /**
     * Validates if a service can be added to a route based on the strategy.
     * 
     * @param route the route to be validated
     * @param srvc the service to be added
     * @param strtg the strategy to be followed
     * @return true if the service can be added, false otherwise
     */
    @Override
    public boolean validate(Route route, Service srvc, Strategy strtg) {
        Service[] s;
        s = route.getServices();

        for (int i = 0; i < route.getServices().length; i++) {
            if (s[i] == srvc) {
                validate = true;
            }
        }

        validate = false;
        return validate;
    }
}
