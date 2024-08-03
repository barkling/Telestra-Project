package com.example.jpadatabase;

import org.springframework.data.repository.CrudRepository;

public interface simCardRepo extends CrudRepository<SimCard, Long>{
    SimCard findSimCardById(long id);
    SimCard findSimCardByCustomerEmail(String customerEmail);
    SimCard findSimCardByIccid(String iccid);
}
