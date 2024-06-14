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

import com.estg.core.FireDepartment;
import com.estg.core.Service;
import com.estg.dailyManagement.DailyPlan;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 * The StrategyImpl class implements the Strategy interface and generates routes
 * for a fire department based on a validation strategy.
 */
public class StrategyImpl implements Strategy {

    @Override
    //Terminar este método
    public Route[] generate(FireDepartment fd, RouteValidator rv) {
        DailyPlan[] daily = fd.getDailyPlans();
        Route[] routes = new Route[0];
        int i, j, k, count = 0;
        for (i = 0; i < fd.getDailyPlans().length; i++) {
            Route[] temp = daily[i].getRoutes();
            for (j = 0; j < daily[i].getRoutes().length; j++) {
                Service[] service = fd.getServices();
                for (k = 0; k < fd.getServices().length; k++) {
                    if (rv.validate(temp[j], service[k], this)) {
                        if (routes.length == count) {
                            routes = (Route[]) increaseArraySizeByFive(routes);
                        }
                        routes[count] = temp[j];
                        count++;
                    }
                }
            }
        }
        return routes;
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
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        return newArray;
    }
}
