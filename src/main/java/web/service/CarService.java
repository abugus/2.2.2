package web.service;

import web.models.Car;

import java.util.List;

interface CarService {
    List<Car> getCars(int count);

    List<Car> getCars();

}
