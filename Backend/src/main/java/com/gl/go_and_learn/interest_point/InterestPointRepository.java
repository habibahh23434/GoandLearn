package com.gl.go_and_learn.interest_point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//extending for CRUD operations of InterestPoint Entity
@Repository
public interface InterestPointRepository extends JpaRepository<InterestPoint, Integer> {
    //deletes an interest point by it's id
    void deleteBy_id(Integer _id);

    Optional<InterestPoint> findBy_id(Integer _id);

    Optional<InterestPoint> findByTitle(String title);

}
