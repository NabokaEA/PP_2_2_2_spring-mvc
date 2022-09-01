package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.persist.CarRepository;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping()
    public String ListPage(@RequestParam( defaultValue = "5") long count, Model model) {
        model.addAttribute("cars", carRepository.nCars(count) );
        return "cars";
    }

}
