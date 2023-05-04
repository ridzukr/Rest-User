package org.example.app.controllers;

import com.google.gson.Gson;
import org.example.app.domain.User;
import org.example.app.services.UserService;
import org.example.app.services.UserServiceImpl;
import org.example.app.utils.Response;
import org.example.app.utils.Status;

import static spark.Spark.*;


public class RestController {

    public void runApp() {

        final UserService service = new UserServiceImpl();

        port(8000);
        post("/users", (request, response) -> {
            response.type("application/json");

            User user = new Gson().fromJson(request.body(), User.class);
            service.addUser(user);

            return new Gson().toJson(new Response(Status.SUCCESS));
        });

        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new Response(Status.SUCCESS,
                    new Gson().toJsonTree(service.getUser())));
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new Response(Status.SUCCESS,
                    new Gson().toJsonTree(service.getUser(
                            Long.valueOf(request.params(":id"))))));
        });

        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User emp = new Gson().fromJson(request.body(), User.class);
            User empEdit = service.editUser(emp);

            if (empEdit != null) {
                return new Gson()
                        .toJson(new Response(Status.SUCCESS,
                                new Gson().toJsonTree(empEdit)));
            } else {
                return new Gson().toJson(new Response(Status.ERROR,
                        new Gson().toJson("Employee not found or editing error.")));
            }
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            service.deleteUser(Long.valueOf(request.params(":id")));
            return new Gson().toJson(new Response(Status.SUCCESS, "Deleted successfully."));
        });

    }
}
