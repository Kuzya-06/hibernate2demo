package ru.kuznetsov.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kuznetsov.MySessionFactory;
import ru.kuznetsov.dao.*;
import ru.kuznetsov.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerService {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    private final AddressDAO addressDAO;
    private final CityDAO cityDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final InventoryDAO inventoryDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StoreDAO storeDAO;

    public CustomerService() {
        addressDAO = new AddressDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    // 6. Добавить метод, который умеет создавать нового покупателя (таблица customer) со всеми зависимыми полями. Не забудь сделать чтоб метод был транзакционным (чтоб не попасть в ситуацию что адрес покупателя записали в БД, а самого покупателя – нет).
    public CustomerEntity createNewCustomer(String nameCity
            , String nameAddress
            , String numberPhone
            , String nameDistrict
            , String nameEmail
            , String firstName
            , String lastName) {


        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            StoreEntity store = storeDAO.getItems(0, 1).get(0);

            CityEntity city = cityDAO.getByName(nameCity);

            AddressEntity address = new AddressEntity();
            address.setAddress(nameAddress);
            address.setPhone(numberPhone);
            address.setCityId(city);
            address.setDistrict(nameDistrict);
            addressDAO.create(address);

            CustomerEntity customer = new CustomerEntity();
            customer.setActive(true);
            customer.setEmail(nameEmail);
            customer.setAddressId(address);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStoreId(store);
            customerDAO.create(customer);

            session.getTransaction().commit();
            return customer;
        }

    }

    // 7. Добавить транзакционный метод, который описывает событие «покупатель пошел и вернул ранее арендованный фильм». Покупателя и событие аренды выбери любое на свое усмотрение. Рейтинг фильма пересчитывать не нужно.
    public void customerReturnedPreviouslyRentedFilmToStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            RentalEntity rental = rentalDAO.getRentalWhereReturnDateIsNull();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.create(rental);

            session.getTransaction().commit();
        }
    }

    // 8. Добавить транзакционный метод, который описывает событие «покупатель сходил в магазин (store) и арендовал (rental) там инвентарь (inventory).
    // При этом он сделал оплату (payment) у продавца (staff)».
    // Фильм (через инвентарь) выбери на свое усмотрение. Единственное ограничение – фильм должен быть доступен для аренды.
    // То есть либо в rental не должно быть вообще записей по инвентарю, либо должна быть заполнена колонка return_date таблицы rental для последней аренды этого инвентаря.
    public void customerInStoreRentalInventoryAndMadeThePaymentFromStaff(CustomerEntity customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            FilmEntity filmIsAvailableForRent = filmDAO.getFilmIsAvailableForRent();

            StoreEntity store = storeDAO.getItems(0, 1).get(0);

            StaffEntity staff = store.getManagerStaffId();

            InventoryEntity inventory = new InventoryEntity();
            inventory.setFilm(filmIsAvailableForRent);
            inventory.setStory(store);
            inventoryDAO.create(inventory);

            RentalEntity rental = new RentalEntity();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDAO.create(rental);

            PaymentEntity payment = new PaymentEntity();
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(12.34));
            payment.setStaff(staff);
            paymentDAO.create(payment);

            session.getTransaction().commit();
        }

    }
}