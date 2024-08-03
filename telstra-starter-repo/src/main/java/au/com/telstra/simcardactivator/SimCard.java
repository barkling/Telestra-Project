package au.com.telstra.simcardactivator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String iccid;
    private String customerEmail;
    private boolean active;

    protected SimCard() {}

    public SimCard(String iccid, String customerEmail, boolean actuated) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = actuated;
    }

    @Override
    public String toString() {
        return String.format("iccid: %s, customerEmail: %s, active: %s", iccid, customerEmail, active);
    }

    public long getId() {
        return id;
    }

    public String getIccid(){
        return iccid;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public boolean isActive() {
        return active;
    }
}
