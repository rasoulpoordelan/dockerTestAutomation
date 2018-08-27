package com.onetechone.access.memoryRepository;


import com.onetechone.access.entity.NameInMemory;
import java.util.List;

public interface NameMemoryRepository {

  void save(NameInMemory obj);

  List<NameInMemory> findAll();

}
