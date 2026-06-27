//package com.mounika.project1;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class foodController {
//	@Autowired
//	foodService fs;
//	
//	@PostMapping("/postData")
//	public String addFood(@RequestBody foodEntity fe) {
//		return "Food Added"+fs.addData(fe);
//	}
//	
//	@GetMapping("/getData")
//	public List<foodEntity> showFood(){
//		return fs.showData();
//	}
//}
package com.mounika.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class foodController {

    @Autowired
    foodService fs;

    // CREATE
    @PostMapping("/postData")
    public String addFood(@RequestBody foodEntity fe) {
        fs.addData(fe);
        return "Food Added Successfully";
    }

    // READ ALL
    @GetMapping("/getData")
    public List<foodEntity> showFood() {
        return fs.showData();
    }

    // READ BY ID
    @GetMapping("/getData/{id}")
    public foodEntity getFoodById(@PathVariable int id) {
        return fs.getById(id);
    }

    // UPDATE
    @PutMapping("/updateData/{id}")
    public String updateFood(
            @PathVariable int id,
            @RequestBody foodEntity fe) {

        return fs.updateFood(id, fe);
    }

    // DELETE
    @DeleteMapping("/deleteData/{id}")
    public String deleteFood(@PathVariable int id) {

        return fs.deleteFood(id);
    }
}