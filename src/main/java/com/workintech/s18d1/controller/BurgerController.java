package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> findAll() {
        return this.burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger find (@PathVariable Long id){
        return this.burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return this.burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable Long id, @RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return this.burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id) {
        return this.burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Integer price) {
        return this.burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType (@RequestBody BreadType breadType) {
        return this.burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content) {
        return this.burgerDao.findByContent(content);
    }
}
