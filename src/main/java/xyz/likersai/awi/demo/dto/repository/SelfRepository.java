package xyz.likersai.awi.demo.dto.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * 自定义的Repository
 * 使用@NoRepositoryBean指明当前接口不是领域类的接口
 * 继承PagingAndSortingRepository实现排序和分页
 * @author SunYe
 */
@NoRepositoryBean
public interface SelfRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID> {
    /**
     * 自定义的方法
     * @param id id
     * @date 2019/5/21
     */
    void doSomething(ID id);
}
