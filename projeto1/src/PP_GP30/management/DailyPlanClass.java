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

import com.estg.dailyManagement.DailyPlan;
import com.estg.dailyManagement.Route;
import java.time.LocalDateTime;

/**
 * The DailyPlanClass class implements the DailyPlan interface and represents a daily plan.
 * It has two private fields: date and routes.
 */
public class DailyPlanClass implements DailyPlan {
    /**
     * The date of the daily plan.
     */
    private LocalDateTime date;
    /**
     * An array of routes in the daily plan.
     */
    private Route routes[];

    /**
     * Returns the date of the daily plan.
     * 
     * @return the date of the daily plan
     */
    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Returns an array of routes in the daily plan.
     * 
     * @return an array of routes in the daily plan
     */
    @Override
    public Route[] getRoutes() {
        return this.routes;
    }

}
