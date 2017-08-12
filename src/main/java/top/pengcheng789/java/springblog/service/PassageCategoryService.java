package top.pengcheng789.java.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pengcheng789.java.springblog.dao.PassageCategoryRepository;
import top.pengcheng789.java.springblog.model.PassageCategory;

import java.util.List;


/**
 * 文章相关服务类
 *
 * CreateDate:2017-08-11
 *
 * @author pen
 */
@Service
public class PassageCategoryService {

    private PassageCategoryRepository repository;

    @Autowired
    public PassageCategoryService(PassageCategoryRepository repository) {
        this.repository = repository;
    }

    public List<PassageCategory> findAll() {
        return repository.findAll();
    }

    public PassageCategory findById(int id) {
        return repository.findById(id);
    }

    public PassageCategory findByName(String name) {
        return repository.findByName(name);
    }

    public void update(int id, String name) {
        repository.updateName(id, name);
    }

    public void add(String name) {
        repository.insert(name);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
