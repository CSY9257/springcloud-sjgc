/**
 *
 */
package com.sjgc.idleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
public interface WithGeneIdLeafService {
    public Long getId(Long userId);
}
