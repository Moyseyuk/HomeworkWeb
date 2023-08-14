package com.tms.Lesson27.servlet;

import com.tms.Lesson27.CarsDBStore;
import com.tms.Lesson27.dto.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/init", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        CarsDBStore dbStore = CarsDBStore.getInstance();

        dbStore.add(new Car("Mercedes-Benz", Car.Transmission.AUTOMATIC, 1998));
        dbStore.add(new Car("BMW", Car.Transmission.MANUAL, 2003));
        dbStore.add(new Car("Volkswagen", Car.Transmission.AUTOMATIC, 2000));
        dbStore.add(new Car("Citroen", Car.Transmission.MANUAL, 2010));
        dbStore.add(new Car("Audi", Car.Transmission.MANUAL, 1995));
        dbStore.add(new Car("Mazda", Car.Transmission.MANUAL, 2012));
    }
}
