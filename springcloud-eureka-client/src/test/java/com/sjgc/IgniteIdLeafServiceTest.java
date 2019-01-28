/**
 *
 */
package com.sjgc;

import com.sjgc.idleaf.support.IgniteIdLeafServiceImpl;
import org.junit.Test;

/**
 * @author sunff
 */
public class IgniteIdLeafServiceTest {

    @Test
    public void getId() {
        IgniteIdLeafServiceImpl idLeaf = new IgniteIdLeafServiceImpl();
        idLeaf.setBizTag("order");
        idLeaf.setZkAddress("localhost:2181");
        idLeaf.init();

        while (true) {
            System.out.println(idLeaf.getId());
        }
    }
}
