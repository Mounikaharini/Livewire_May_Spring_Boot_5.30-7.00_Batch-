//package com.mounika.project1;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class foodService {
//	List<foodEntity> a = new ArrayList<foodEntity>();
//	public List<foodEntity> addData(foodEntity f){
//		a.add(f);
//		return a;
//	}
//	public List<foodEntity> showData(){
//		return a;
//	}
//}
package com.mounika.project1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class foodService {

    List<foodEntity> a = new ArrayList<>();

    // CREATE
    public List<foodEntity> addData(foodEntity f) {
        a.add(f);
        return a;
    }

    // READ ALL
    public List<foodEntity> showData() {
        return a;
    }

    // READ BY ID
    public foodEntity getById(int id) {
        for(foodEntity f : a) {
            if(f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    // UPDATE
    public String updateFood(int id, foodEntity newFood) {

        for(int i=0; i<a.size(); i++) {

            if(a.get(i).getId() == id) {

                a.set(i, new foodEntity(
                        newFood.getId(),
                        newFood.getFood(),
                        newFood.getPrice()));

                return "Food Updated Successfully";
            }
        }

        return "Food ID Not Found";
    }

    // DELETE
    public String deleteFood(int id) {

        for(foodEntity f : a) {

            if(f.getId() == id) {
                a.remove(f);
                return "Food Deleted Successfully";
            }
        }

        return "Food ID Not Found";
    }
}