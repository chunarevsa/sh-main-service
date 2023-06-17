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

    public Optional<Refer> updateRefer(Long id, ReferRequest req) {
        return referRepository.findById(id).map(refer -> {
            if (req.getName() != null) refer.setName(req.getName());
            if (req.getTitle() != null) refer.setTitle(req.getTitle());
            if (req.getLink() != null) refer.setLink(req.getLink());
            if (req.isServiceRefer() != null) refer.setIsServiceRefer(req.isServiceRefer());
            return refer;
        });
    }

    public void deleteRefer(Long id) {
        referRepository.deleteById(id);
    }

}
