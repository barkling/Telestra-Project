package au.com.telstra.simcardactivator;

import org.springframework.data.repository.CrudRepository;

public interface SimCardRepo extends CrudRepository<SimCard, Long>{
    SimCard findSimCardById(long id);
    SimCard findSimCardByCustomerEmail(String customerEmail);
    SimCard findSimCardByIccid(String iccid);
}
