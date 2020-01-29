package com.grocerylist.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-06
 * spring boot context test
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class CoreApplicationTests {

    @Test
    public void contextLoads() {
    }

}
