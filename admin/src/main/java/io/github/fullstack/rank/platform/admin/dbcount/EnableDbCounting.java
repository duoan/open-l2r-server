package io.github.fullstack.rank.platform.admin.dbcount;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Summary: EnableDbCounting
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午11:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DbCountAutoConfiguration.class)
@Documented
public @interface EnableDbCounting {
}
