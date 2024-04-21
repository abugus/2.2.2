package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImpl carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCertainNumberOfCars(Model model, @RequestParam
            (required = false, value = "count") String count) {
        if (count != null) {
            model.addAttribute("getCars",
                    carService.getCars(Integer.parseInt(count)));
        } else {
            model.addAttribute("getCars",
                    carService.getCars());
        }
        return "cars";
    }
}
