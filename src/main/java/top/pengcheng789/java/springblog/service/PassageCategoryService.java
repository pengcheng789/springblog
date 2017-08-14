package top.pengcheng789.java.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pengcheng789.java.springblog.dao.PassageCategoryRepository;
import top.pengcheng789.java.springblog.dao.PassageRepository;
import top.pengcheng789.java.springblog.model.Passage;
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

    private PassageCategoryRepository passageCategoryRepository;
    private PassageRepository passageRepository;

    @Autowired
    public PassageCategoryService(PassageCategoryRepository passageCategoryRepository) {
        this.passageCategoryRepository = passageCategoryRepository;
    }

    @Autowired
    public void setPassageRepository(PassageRepository passageRepository) {
        this.passageRepository = passageRepository;
    }

    public List<PassageCategory> findAll() {
        return passageCategoryRepository.findAll();
    }

    public PassageCategory findById(int id) {
        return passageCategoryRepository.findById(id);
    }

    public PassageCategory findByName(String name) {
        return passageCategoryRepository.findByName(name);
    }

    public void update(int id, String name) {
        passageCategoryRepository.updateName(id, name);
    }

    public void add(String name) {
        passageCategoryRepository.insert(name);
    }

    public void delete(int id) {
        List<Passage> passageList = passageRepository.findByCategoryId(id);

        for (Passage passage : passageList) {
            passageRepository.delete(passage.getId());
        }

        passageCategoryRepository.delete(id);
    }
}
