package com.onetechone.access.controller;

import com.onetechone.access.entity.Name;
import com.onetechone.access.entity.NameInMemory;
import com.onetechone.access.memoryRepository.NameMemoryRepository;
import com.onetechone.access.model.SetModel;
import com.onetechone.access.repository.NameRepository;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  @Autowired
  NameRepository nameRepository;

  @Autowired
  NameMemoryRepository nameMemoryRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getHostName() throws UnknownHostException {
    return InetAddress.getLocalHost().getHostName();
  }


  @RequestMapping(value = "/db", method = RequestMethod.POST)
  public String addPostgres(@RequestBody SetModel model) {
    Name nameObj = new Name();
    nameObj.setName(model.getName());
    nameRepository.save(nameObj);
    return model.getName();
  }

  @RequestMapping(value = "/db", method = RequestMethod.GET)
  public List<Name> getPostgres() {
    return nameRepository.findAll();
  }


  @RequestMapping(value = "/redis", method = RequestMethod.POST)
  public String addRedis(@RequestBody SetModel model) {
    NameInMemory nameObj = new NameInMemory();
    nameObj.setName(model.getName());
    nameMemoryRepository.save(nameObj);
    return model.getName();
  }

  @RequestMapping(value = "/redis", method = RequestMethod.GET)
  public List<NameInMemory> getRedis() {
    return nameMemoryRepository.findAll();
  }
}
