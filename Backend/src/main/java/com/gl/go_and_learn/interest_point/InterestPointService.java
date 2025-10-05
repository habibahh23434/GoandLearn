package com.gl.go_and_learn.interest_point;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//service class contains logic btween controller and repo to work w/ DB
//component means it's lifecycle is managed by Spring container after an instance of it is created
@Component
public class InterestPointService {
    private final InterestPointRepository interestPointRepository;

    @Autowired
    public InterestPointService(InterestPointRepository interestPointRepository) {
        this.interestPointRepository = interestPointRepository;
    }

    //to return list of all records in DB
    public List<InterestPoint> getInterestPoint(){
        return interestPointRepository.findAll();
    }

    public List<InterestPoint> getInterestPointsByID(Integer _id){
        return interestPointRepository.findAll().stream()
                .filter(interestPoint -> _id.equals(interestPoint.get_id()))
                .collect(Collectors.toList());
    }

    public List<InterestPoint> getInterestPointsByNeighbourhoodNum(Integer neighbourhood_num){
        return interestPointRepository.findAll().stream()
                .filter(interestPoint -> neighbourhood_num.equals(interestPoint.getNeighbourhood_num()))
                .collect(Collectors.toList());
    }

    public List<InterestPoint> getInterestPointByTitle(String searchTitle){
        return interestPointRepository.findAll().stream()
                .filter(interestPoint ->
                        interestPoint.getTitle().toLowerCase().contains(searchTitle.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<InterestPoint> getInterestPointByAddress(String searchAddress){
        return interestPointRepository.findAll().stream()
                .filter(interestPoint ->
                        interestPoint.getAddress().toLowerCase().contains(searchAddress.toLowerCase()))
                .collect(Collectors.toList());
    }

    public InterestPoint addInterestPoint(InterestPoint  interestPoint){
        interestPointRepository.save(interestPoint);
        return interestPoint;
    }

    public InterestPoint updateInterestPoint(InterestPoint updatedInterestPoint){
        Optional<InterestPoint> existingInterestPoint = interestPointRepository.findByTitle(updatedInterestPoint.getTitle());

        if(existingInterestPoint.isPresent()){
            InterestPoint interestPointToUpdate = existingInterestPoint.get();
            interestPointToUpdate.set_id(updatedInterestPoint.get_id());
            interestPointToUpdate.setNeighbourhood_num(updatedInterestPoint.getNeighbourhood_num());
            interestPointToUpdate.setTitle(updatedInterestPoint.getTitle());
            interestPointToUpdate.setAddress(updatedInterestPoint.getAddress());
            interestPointRepository.save(interestPointToUpdate);
            return interestPointToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteInterestPoint(Integer interestPointID){
        interestPointRepository.deleteBy_id(interestPointID);
    }


}
