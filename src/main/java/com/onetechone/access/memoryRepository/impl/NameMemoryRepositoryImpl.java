package com.onetechone.access.memoryRepository.impl;

import com.onetechone.access.entity.NameInMemory;
import com.onetechone.access.memoryRepository.NameMemoryRepository;
import com.onetechone.access.util.ObjTools;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Repository
public class NameMemoryRepositoryImpl implements NameMemoryRepository {

  @Autowired
  private JedisPool JedisPool;

  private final String KEY = "NAME";

  @Override
  public void save(NameInMemory data) {

    Jedis jedis = JedisPool.getResource();
    jedis.lpush(KEY, ObjTools.toJson(data));
    jedis.close();
  }

  @Override
  public List<NameInMemory> findAll() {
    Jedis jedis = JedisPool.getResource();

    List<String> fromRedis = jedis.lrange(KEY, 0L, -1L);

    jedis.close();

    List<NameInMemory> result = new ArrayList<>();

    for (String data : fromRedis) {
      result.add(ObjTools.toObj(data, NameInMemory.class));
    }

    return result;
  }


}
