package com.my;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface RentalDao {
    List<Rental> getRentals();
    int addRental(Rental rental);
    int addRentals(List<Rental> rentals);
}
