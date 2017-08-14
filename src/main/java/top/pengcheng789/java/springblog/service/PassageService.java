package top.pengcheng789.java.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pengcheng789.java.springblog.dao.PassageRepository;
import top.pengcheng789.java.springblog.model.Passage;

import java.util.List;
import java.util.UUID;

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

    @Autowired
    private void setPassageRepository(PassageRepository passageRepository) {
        this.passageRepository = passageRepository;
    }

    public List<Passage> findAll() {
        return passageRepository.findAll();
    }

    public List<Passage> findByCategoryId(int categoryId) {
        return passageRepository.findByCategoryId(categoryId);
    }

    public Passage findById(String passageId) {
        return passageRepository.findById(passageId);
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
