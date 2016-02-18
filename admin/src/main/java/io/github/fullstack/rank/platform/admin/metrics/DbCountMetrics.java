package io.github.fullstack.rank.platform.admin.metrics;

import io.github.fullstack.rank.platform.admin.dbcount.DbCountRunner;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Summary: DbCountMetrics
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午11:11
 */
public class DbCountMetrics implements PublicMetrics {

    private Collection<CrudRepository> repositories;

    public DbCountMetrics(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrics = new LinkedList<>();
        for (CrudRepository repository: repositories) {
            String name = DbCountRunner.getRepositoryName(repository.getClass());
            String metricName = "counter.datasource." + name;
            metrics.add(new Metric(metricName, repository.count()));
        }
        return metrics;
    }

}
