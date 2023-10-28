package com.shreyash.demo.Features.Swiggy.Service;

import com.shreyash.demo.Features.Swiggy.Models.Restaurants;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RestaurantCrudRepository extends JpaRepository<Restaurants, Integer> {
    // place we can write our own queries

    @Query(
            value = "select r from Restaurants r"
    )
    List<Restaurants> getAllRestaurants();

    @Query(
            value = "select r from Restaurants r "
    )
    List<Restaurants> getAllRestaurantsInSortedOrder(Sort sort);

    @Query(
            value = "select r from Restaurants r "
    )
    Slice<Restaurants> getAllRestaurantsPaginated(Pageable pageable);

    @Query(
            value = "select r from Restaurants r Where r.name = :name"
    )
    List<Restaurants> getAllRestaurantsWhereNameIs(@Param("name") String name);

    @Query(
            value = "select * from restuarant r Where r.name IN :names",
            nativeQuery = true
    )
    List<Restaurants> getAllRestaurantsWhereNamesAre(@Param("names") List<String> names);

    // Derived Queries
    List<Restaurants> findFirstByName(String name);





    // page -> size

}
