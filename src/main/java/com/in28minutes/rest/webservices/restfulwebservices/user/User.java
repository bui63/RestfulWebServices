package com.in28minutes.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "all details about users.")
public class User {

    private Integer id;
@ApiModelProperty(notes = "Name should be at least 2 char.")
    @Size(min = 2, message = "Name should at least 2 char ")
    private String name;
    @ApiModelProperty(notes = "Date should be in past.")
    @Past
    private Date birtDate;

    protected User() {
    }

    public User(Integer id, String name, Date birtDate) {
        this.id = id;
        this.name = name;
        this.birtDate = birtDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(Date birtDate) {
        this.birtDate = birtDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birtDate=" + birtDate +
                '}';
    }
}
