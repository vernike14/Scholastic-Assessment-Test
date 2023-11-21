package com.precize.sat.service;

import com.precize.sat.entity.SatResults;
import com.precize.sat.mapper.SatResultMapper;
import com.precize.sat.modal.SatResultModel;
import com.precize.sat.repo.SatResultRepo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SatResultService {

    @Autowired
    private SatResultRepo satResultRepo;

    @Autowired
    private SatResultMapper satResultMapper;

    public SatResultModel getByName(String name){
        SatResults satResults = satResultRepo.getSatResultsByName(name);
        if(Objects.nonNull(satResults)){
            return satResultMapper.toSatResultModel(satResults);
        }
        return new SatResultModel();
    }

    public List<SatResultModel> getAllResults(){
        List<SatResults> satResults = satResultRepo.findAll();
        if(!satResults.isEmpty() || Objects.nonNull(satResults)){
            return satResultMapper.toSatResultModelList(satResults);
        }
        return new ArrayList<>();
    }

    public SatResultModel saveResult(SatResultModel satResultModel){
        SatResults satResults = satResultMapper.toSatResult(satResultModel);
        if(Objects.nonNull(satResults)){
            satResults = satResultRepo.save(satResults);
            return satResultMapper.toSatResultModel(satResults);
        }
        return new SatResultModel();
    }

    public SatResultModel updateScore(String name, double score){
        SatResults satResults = satResultRepo.getSatResultsByName(name);
        if(Objects.nonNull(satResults)){
            satResults.setScore(score);
            satResults = satResultRepo.save(satResults);
            return satResultMapper.toSatResultModel(satResults);
        }
        return new SatResultModel();
    }

    public boolean deleteByName(String name){
        SatResults satResults = satResultRepo.getSatResultsByName(name);
        if(Objects.nonNull(satResults)){
            satResultRepo.delete(satResults);
            return true;
        }
        return false;
    }

    public int getRank(String name){
       List<SatResults> satResults = satResultRepo.findAllByScoreDesc();
       return satResults.stream()
               .filter(data -> Objects.equals(data.getName(), name))
               .findFirst()
               .map(satResults::indexOf)
               .orElse(-1);
    }
}
