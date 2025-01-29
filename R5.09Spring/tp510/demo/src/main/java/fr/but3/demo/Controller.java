package fr.but3.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    Map<String, List<String>> flights = Map.of(
            "AF123", List.of("Alice", "Bob"),
            "AF456", List.of("Charlie", "David")
    );

    @GetMapping("/me")
    public Principal me(Principal principal) {
        return principal;
    }

    @PostMapping("/board/{flightId}")
    public Flight board(@PathParam("flightId") String flightId , Principal principal) {
        if (!flights.containsKey(flightId)) {
            this.flights.put(flightId, List.of(principal.getName()));
        }else {
            this.flights.get(flightId).add(principal.getName());
        }
        return new Flight(flightId, principal.getName(), flights.get(flightId));
    }
}
