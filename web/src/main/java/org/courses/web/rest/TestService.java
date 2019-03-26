package org.courses.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbtest")
public class TestService {

    @GetMapping(value = "/{connectionstring}")
    public boolean greeting(@PathVariable("connectionstring") String connectionString) {
        return true;
    }
}
