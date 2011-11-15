package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StrangeFruit {
    @Id
    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}