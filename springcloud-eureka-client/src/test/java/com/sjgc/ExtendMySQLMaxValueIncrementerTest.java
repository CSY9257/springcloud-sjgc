/**
 *
 */
package com.sjgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunff
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:idLeaf/extendmysqlapplicationContext.xml"})
public class ExtendMySQLMaxValueIncrementerTest {

    @Autowired
    @Qualifier("order")
    private DataFieldMaxValueIncrementer incrementer;

    @Test
    public void test() {
        int i = 0;
        while (i < 10) {
            System.out.println("long id=" + incrementer.nextLongValue());
            System.out.println("int id=" + incrementer.nextIntValue());
            System.out.println("string id=" + incrementer.nextStringValue());
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
