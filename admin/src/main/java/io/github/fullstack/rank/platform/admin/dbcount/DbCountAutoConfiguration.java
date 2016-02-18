package io.github.fullstack.rank.platform.admin.dbcount;

import io.github.fullstack.rank.platform.admin.metrics.DbCountMetrics;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Summary: DbCountAutoConfiguration
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午11:25
 */
@Configuration
public class DbCountAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public PublicMetrics dbCountMetrics(Collection<CrudRepository> repositories) {
        return new DbCountMetrics(repositories);
    }

}
