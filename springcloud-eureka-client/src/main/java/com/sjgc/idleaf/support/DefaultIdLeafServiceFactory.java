/**
 *
 */
package com.sjgc.idleaf.support;

import com.sjgc.idleaf.IdLeafService;
import com.sjgc.idleaf.IdLeafServiceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/**
 * @author sunff
 */
public class DefaultIdLeafServiceFactory implements IdLeafServiceFactory {

    private static ConcurrentHashMap<String, IdLeafService> bizTagIdLeaf = new ConcurrentHashMap<>();

    private ExecutorService taskExecutor;

    private JdbcTemplate jdbcTemplate;

    public void setTaskExecutor(ExecutorService taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    //双重判定锁
    @Override
    public Long getIdByBizTag(String bizTag) {
        IdLeafService issdervice = null;
        if (bizTagIdLeaf.get(bizTag) == null) {
            synchronized (bizTagIdLeaf) {
                if (bizTagIdLeaf.get(bizTag) == null) {
                    MysqlIdLeafServiceImpl idleafService = new MysqlIdLeafServiceImpl();
                    idleafService.setBizTag(bizTag);
                    idleafService.setAsynLoadingSegment(true);
                    idleafService.setTaskExecutor(taskExecutor);
                    idleafService.setJdbcTemplate(jdbcTemplate);
                    idleafService.init();
                    bizTagIdLeaf.putIfAbsent(bizTag, idleafService);

                }
            }
        }

        issdervice = bizTagIdLeaf.get(bizTag);
        return issdervice.getId();
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
