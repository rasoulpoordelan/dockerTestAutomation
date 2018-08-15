package com.onetechone.access;

import com.onetechone.access.entity.Name;
import com.onetechone.access.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    NameRepository nameRepository;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(@RequestParam(value = "name") String name)
    {
        Name name1=new Name();
        name1.setName(name);
        nameRepository.save(name1);
        return name;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Name> get()
    {
        return nameRepository.findAll();
    }
}
