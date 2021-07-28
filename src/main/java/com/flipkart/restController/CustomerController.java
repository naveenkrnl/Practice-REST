package com.flipkart.restController;

import com.flipkart.bean.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

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
    @POST
    @Path("/post")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        // service ---- dao ----> SQL
        System.out.println("hit post service");

        System.out.println("value of title from UI " +customer.getId());
        System.out.println("value of singer form UI" +customer.getName());


        String result = "Track saved : " + customer;


        return Response.status(201).entity(result).build();

    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer updateCustomer(Customer customer){

        // rest of impl write here in code

        customer.setName(customer.getName() +"updated");
        return customer;

    }

    // delete operation


    @DELETE
    @Path("/delete/{customerId}")
    public Response deleteCustomer(@PathParam("customerId") int customerId)
            throws URIReferenceException {

        // service query to perfom the delete operation
        System.out.println("Deleted " + customerId);

        // implementation
        return Response.status(200).entity("Customer id " +customerId +
                "successfully deleted").build();


    }
}
