package xyz.likersai.awi.demo.dto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import xyz.likersai.awi.demo.dto.Person;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @program: awi
 * @description: JpaRepository
 * @author: MSI PC
 * @create: 2019-05-20 13:58
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {

    /**
     * 通过名字相等查询
     * 相当于JPQL: select p from person p where p.name = ?1
     * @param name Person.name
     * @return 结果
     */
    List<Person> findByName(String name);

    /**
     * 通过名字like查询
     * 相当于JPQL: select p from Person p where p.name like ?1
     * @param name Person.name
     * @return 结果
     */
    List<Person> findByNameLike(String name);

    /**
     * 通过名字和地址查询
     * 相当于JPQL: select p from person p where p.name = ?1 and p.address = ?2
     * @param name Person.name
     * @param address Person.address
     * @return 结果
     */
    List<Person> findByNameAndAddress(String name,String address);

    /**
     * 获得符合查询条件的前10条数据
     * @param name Person.name
     * @return 结果
     * @date 2019/5/20
     */
    List<Person> findFirst10ByName(String name);

    /**
     * 获得符合查询条件的前30条数据
     * @param address Person.address
     * @return 结果
     * @date 2019/5/20
     */
    List<Person> findTop30ByAddress(String address);

    /**
     * 使用@NamedQuery自定义的查询
     * @param name Person.name
     * @return 结果
     */
    List<Person> findByNameSelf(String name);

    /**
     * 使用@query自定义的查询
     * @param name Person.name
     * @return 结果
     * @date 2019/5/20
     */
    @Query("select p from Person p where p.name = ?1")
    List<Person> myFindByNameQuery(String name);


    /**
     * 使用@query自定义的查询,在语句里用名称匹配参数
     * @param address Person.address
     * @return 结果
     * @date 2019/5/20
     */
    @Query("select p from Person p where p.address = :address")
    List<Person> findByAddressQuery(@Param("address") String address);

    /**
     * 使用 @Modifying和 @Query注解组合更新查询
     * @param address Person.address
     * @param name Person.name
     * @return 结果
     * @date 2019/5/21
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("update Person p set p.address = ?1 where p.name = ?2")
    int setName(String address,String name);

    /**
     * 使用排序
     *  List<Person> people = personRepository.findByName("xx",new Sort(Direction.ASC,"age"));
     * @param  name Person.name
     * @param  sort 排序配置
     * @return 排序后的结果
     * @date 2019/5/21
     */
    List<Person> findByName(String name , Sort sort);
    /**
     * 使用分页
     *   Page<Person> people = personRepository.findByName("xx",new PageRequest(0,10));
     * @param
     * @return
     * @date 2019/5/21
     */
    Page<Person> findByName(String name , Pageable pageable);
}