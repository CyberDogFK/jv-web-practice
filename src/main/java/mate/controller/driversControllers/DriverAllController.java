package mate.controller.driversControllers;

import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/drivers")
public class DriverAllController extends HttpServlet {
    static final Injector injector = Injector.getInstance("mate");
    DriverService driverService;

    public DriverAllController() {
        driverService = (DriverService)
                injector.getInstance(DriverService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Driver> allDrivers = driverService.getAll();
        req.setAttribute("drivers", allDrivers);
        req.getRequestDispatcher("/WEB-INF/views/drivers/operations/all.jsp")
                .forward(req, resp);
    }
}