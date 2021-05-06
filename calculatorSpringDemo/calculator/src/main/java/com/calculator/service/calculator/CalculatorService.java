package com.calculator.service.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class CalculatorService {

    @GetMapping("/add/{x}/{y}")
    public int add(@PathVariable int x, @PathVariable int y) {
        return x+y;
    }
    @GetMapping("/addJ/{x}/{y}")
    public Response addJ(@PathVariable double x, @PathVariable double y) {
        return new Response(x,y,x+y);
    }

    @GetMapping("/mul/{x}/{y}")
    public Response mul(@PathVariable double x, @PathVariable double y) {
        return new Response(x,y,x*y);
    }
    @GetMapping("/div/{x}/{y}")
    public Response div(@PathVariable double x, @PathVariable double y) {
        return new Response(x,y,x/y);
    }
    @GetMapping("/sub/{x}/{y}")
    public Response sub(@PathVariable double x, @PathVariable double y) {
        return new Response(x,y,x-y);
    }
}
