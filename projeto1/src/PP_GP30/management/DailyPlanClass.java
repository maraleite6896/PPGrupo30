/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.dailyManagement.DailyPlan;
import com.estg.dailyManagement.Route;
import java.time.LocalDateTime;

/**
 *
 * @author maraleite
 */
public class DailyPlanClass implements DailyPlan {

    private LocalDateTime date;
    private Route routes[];

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public Route[] getRoutes() {
        return routes;
    }

}
