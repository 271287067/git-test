package com.fish.demo.respository;

import org.springframework.data.repository.CrudRepository;

import com.fish.demo.bean.Cat;

/**
 * 接口
 * @author Administrator
 *
 */
public interface CatRepository extends CrudRepository<Cat, Integer>{

}
