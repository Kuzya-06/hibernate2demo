package ru.kuznetsov;

import ru.kuznetsov.entity.*;
import ru.kuznetsov.service.CustomerService;
import ru.kuznetsov.service.FilmService;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        FilmService filmService = new FilmService();

//         6.
        CustomerEntity customer = customerService.createNewCustomer(
                "Rockford"
                , "1717 Okayama Street"
                , "169352919999"
                , "So Paulo"
                , "testNaomi@test.ru"
                , "Naomi"
                , "Kasumi");
        System.out.println("-*-".repeat(10));
//         7.
        customerService.customerReturnedPreviouslyRentedFilmToStore();
        System.out.println("-*-".repeat(10));
//         8.
        customerService.customerInStoreRentalInventoryAndMadeThePaymentFromStaff(customer);
        System.out.println("-*-".repeat(10));
//         9.
        filmService.newFilmShotAndAvailableForRent();
        System.out.println("-*-".repeat(10));

    }
}
