package org.globex.retail.order.rest;

import io.vertx.core.json.JsonObject;
import org.globex.retail.order.model.dto.OrderDto;
import org.globex.retail.order.service.OrderService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response storeOrder(OrderDto order) {
        if (order == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            OrderDto stored = orderService.storeOrder(order);
            return Response.ok(new JsonObject().put("order", Long.toString(stored.getId()))).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

}
