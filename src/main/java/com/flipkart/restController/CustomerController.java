package com.flipkart.restController;

import com.flipkart.bean.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerController {

    @GET
    @Path("/customerDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerDetails() {

        //  client --- service ---- dao ----> SQL

        Customer customer=new Customer();
        customer.setId(101);
        customer.setName("Flipcard");
        customer.setAddress("mumbai");

        return customer;

    }
}
