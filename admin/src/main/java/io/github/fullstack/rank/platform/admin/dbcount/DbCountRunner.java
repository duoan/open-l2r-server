package io.github.fullstack.rank.platform.admin.dbcount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Summary: DbCountRunner
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午11:40
 */
@Slf4j
public class DbCountRunner implements CommandLineRunner {

    public static final String REPOSITORY_PREFIX = "io.github.fullstack.rank.platform.admin.repository";

    private Collection<CrudRepository> repositories;

    public DbCountRunner(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) throws Exception {
        repositories.forEach(crudRepository ->
                log.info(String.format("%s has %s entries",
                        getRepositoryName(crudRepository.getClass()),
                        crudRepository.count())));

    }

    public static String getRepositoryName(Class crudRepositoryClass) {
        for (Class repositoryInterface :
                crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().startsWith(REPOSITORY_PREFIX)) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }
}
