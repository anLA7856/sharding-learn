package com.anla.dbtable.config;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * @Description: 表分片规则
 *
 * @author xub
 * @date 2019/10/10 下午4:18
 */
public final class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Long> shardingValue) {
        for (String each : tableNames) {
            if (each.endsWith(shardingValue.getValue() % 3 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}