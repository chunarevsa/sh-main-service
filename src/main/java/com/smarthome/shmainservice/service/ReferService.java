package com.smarthome.shmainservice.service;

import com.smarthome.shmainservice.dto.ReferRequest;
import com.smarthome.shmainservice.entity.Refer;
import com.smarthome.shmainservice.repo.ReferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferService {

    private final ReferRepository referRepository;

    public ReferService(ReferRepository referRepository) {
        this.referRepository = referRepository;
    }

    public List<Refer> getActualRefers() {
        return referRepository.findAll();
    }

    public Optional<Refer> getRefer(Long id) {
        return referRepository.findById(id);
    }

    public Refer addRefer(ReferRequest req) {
        return referRepository.save(new Refer(req.getName(), req.getTitle(), req.getLink(), req.isServiceRefer()));
    }

    public Refer updateRefer(Long id, ReferRequest req) throws Exception {
        Optional<Refer> refer = referRepository.findById(id).map(it -> {
            if (req.getName() != null) it.setName(req.getName());
            if (req.getTitle() != null) it.setTitle(req.getTitle());
            if (req.getLink() != null) it.setLink(req.getLink());
            if (req.isServiceRefer() != null) it.setIsServiceRefer(req.isServiceRefer());
            return it;
        });
        return refer.map(referRepository::save).orElseThrow(() -> new Exception("Not found"));
    }

    public void deleteRefer(Long id) {
        referRepository.deleteById(id);
    }

}
