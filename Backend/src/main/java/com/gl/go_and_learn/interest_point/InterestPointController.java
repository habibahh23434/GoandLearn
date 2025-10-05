package com.gl.go_and_learn.interest_point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/interestpoint")
public class InterestPointController {
    private final InterestPointService interestPointService;

    //controller sending business logic back to service layer
    @Autowired
    public InterestPointController(InterestPointService interestPointService) {
        this.interestPointService = interestPointService;
    }

    @GetMapping
    public List<InterestPoint> getInterestPoints(
            @RequestParam(required = false) Integer _id,
            @RequestParam(required = false) Integer neighbourhood_num,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String address) {
        if(_id != null){
            return  interestPointService.getInterestPointsByID(_id);
        }
        else if (neighbourhood_num != null) {
            return interestPointService.getInterestPointsByNeighbourhoodNum(neighbourhood_num);
        }
        else if (title != null) {
            return interestPointService.getInterestPointByTitle(title);
        }
        else if (address != null) {
            return interestPointService.getInterestPointByAddress(address);
        }
        else{
            return interestPointService.getInterestPoint();
        }
    }

    //handles HTTP post requests to add a new interest point
    @PostMapping
    public ResponseEntity<InterestPoint> addInterestPoint(@RequestBody InterestPoint interestPoint){
        InterestPoint createdInterestPoint =  interestPointService.addInterestPoint(interestPoint);
        return new ResponseEntity<>(createdInterestPoint,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<InterestPoint> updateInterestPoint(@RequestBody InterestPoint interestPoint){
        InterestPoint resultInterestPoint = interestPointService.updateInterestPoint(interestPoint);
        if(resultInterestPoint!=null){
            return new ResponseEntity<>(resultInterestPoint,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{interestPointID}")
    public ResponseEntity<String> deleteInterestPoint(@PathVariable Integer interestPointID) {
        interestPointService.deleteInterestPoint(interestPointID);
        return new ResponseEntity<>("Interest point deleted successfully", HttpStatus.OK);
    }
}
