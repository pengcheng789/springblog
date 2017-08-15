package top.pengcheng789.java.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pengcheng789.java.springblog.dao.PassageRepository;
import top.pengcheng789.java.springblog.model.Passage;

import java.util.List;

/**
 * Passage 服务类
 *
 * CreateDate:2017-08-12
 *
 * @author pen
 */
@Service
public class PassageService {

    private PassageRepository passageRepository;
    private PassageCategoryService passageCategoryService;

    @Autowired
    private void setPassageRepository(PassageRepository passageRepository) {
        this.passageRepository = passageRepository;
    }

    @Autowired
    public void setPassageCategoryService(PassageCategoryService passageCategoryService) {
        this.passageCategoryService = passageCategoryService;
    }

    public List<Passage> findAll() {
        List<Passage> passageList = passageRepository.findAll();

        for (Passage passage : passageList) {
            passage.setPassageCategory(
                    passageCategoryService.findById(passage.getCategoryId()));
        }

        return passageList;
    }

    public List<Passage> findByCategoryId(int categoryId) {
        List<Passage> passageList = passageRepository.findByCategoryId(categoryId);

        for (Passage passage : passageList) {
            passage.setPassageCategory(
                    passageCategoryService.findById(passage.getCategoryId()));
        }

        return passageList;
    }

    public Passage findById(String passageId) {

        Passage passage = passageRepository.findById(passageId);
        passage.setPassageCategory(
                passageCategoryService.findById(passage.getCategoryId()));

        return passage;
    }

    public void delete(String id) {
        passageRepository.delete(id);
    }

    public void add(Passage passage) {
        passageRepository.add(passage);
    }

    public void update(Passage passage) {
        passageRepository.update(passage);
    }
}
