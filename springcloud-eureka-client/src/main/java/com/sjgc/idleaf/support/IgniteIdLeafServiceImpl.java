/**
 *
 */
package com.sjgc.idleaf.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sjgc.idleaf.IdLeafService;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicSequence;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.zk.TcpDiscoveryZookeeperIpFinder;

/**
 * 参考：https://my.oschina.net/liyuj/blog/617472
 *      基于Ignite   分布式ID生成器
 * @author sunff
 */

public class IgniteIdLeafServiceImpl implements IdLeafService {
    private static final String datePattern = "yyyyMMddHHmmss";

    @Override
    public Long getId() {
        return seq.getAndIncrement();
    }

    private IgniteAtomicSequence seq;
    private String zkAddress;
    private String bizTag;

    public void setBizTag(String bizTag) {
        this.bizTag = bizTag;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public void init() {
        SimpleDateFormat s = new SimpleDateFormat(datePattern);
        Long initValue = Long.valueOf(s.format(new Date())) * 100000;
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryZookeeperIpFinder ipFinder = new TcpDiscoveryZookeeperIpFinder();
        // 指定ZooKeeper连接字符串
        ipFinder.setZkConnectionString(this.zkAddress);
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        // 重写默认的发现SPI。
        cfg.setDiscoverySpi(spi);
        // 开始点燃节点
        Ignite ignite = Ignition.start(cfg);
        // Ignite ignite = Ignition.start();
        seq = ignite.atomicSequence(bizTag, // 序列名
                initValue, // 初始值
                true// 如果序列不存在则创建
        );
    }


}
