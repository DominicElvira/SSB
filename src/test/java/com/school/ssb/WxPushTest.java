package com.school.ssb;

import com.school.ssb.controller.WxPushController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxPushTest {

    @Autowired
    WxPushController pushController;

    @Test
    public void push() {
        pushController.push();
    }
}
