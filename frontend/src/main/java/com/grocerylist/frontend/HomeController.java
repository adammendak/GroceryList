package com.grocerylist.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2020-01-19
 *
 * home controller to serve static html file
 *
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
