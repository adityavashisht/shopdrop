package com.indasil.shopdrop.domain;

/**
 * Created by vashishta on 10/5/15.
 */
public class Customer {
    private Long id;
    private String name;
    private String email;

    private Boolean active;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
