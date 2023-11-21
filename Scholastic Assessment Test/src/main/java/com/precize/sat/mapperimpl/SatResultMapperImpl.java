package com.precize.sat.mapperimpl;

import com.precize.sat.entity.SatResults;
import com.precize.sat.mapper.SatResultMapper;
import com.precize.sat.modal.SatResultModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SatResultMapperImpl implements SatResultMapper {
    @Override
    public List<SatResultModel> toSatResultModelList(List<SatResults> satResults) {
        List<SatResultModel> data = new ArrayList<>();
        for(SatResults results : satResults){
            SatResultModel satResultModel = new SatResultModel();
            satResultModel.setId(results.getId());
            satResultModel.setName(results.getName());
            satResultModel.setAddress(results.getAddress());
            satResultModel.setCountry(results.getCountry());
            satResultModel.setCity(results.getCity());
            satResultModel.setPincode(results.getPincode());
            satResultModel.setScore(results.getScore());
            String res = results.getScore() > 30.0 ? "PASS" : "FAIL";
            satResultModel.setResult(res);
            data.add(satResultModel);
        }
        return data;
    }

    @Override
    public SatResultModel toSatResultModel(SatResults satResult) {
        SatResultModel data = new SatResultModel();
        data.setId(satResult.getId());
        data.setName(satResult.getName());
        data.setAddress(satResult.getAddress());
        data.setCountry(satResult.getCountry());
        data.setCity(satResult.getCity());
        data.setPincode(satResult.getPincode());
        data.setScore(satResult.getScore());
        String res = satResult.getScore() > 30.0 ? "PASS" : "FAIL";
        data.setResult(res);
        return data;
    }

    @Override
    public SatResults toSatResult(SatResultModel satResultModel) {
        SatResults data = new SatResults();
        data.setName(satResultModel.getName());
        data.setAddress(satResultModel.getAddress());
        data.setCity(satResultModel.getCity());
        data.setCountry(satResultModel.getCountry());
        data.setPincode(satResultModel.getPincode());
        data.setScore(satResultModel.getScore());
        return data;
    }
}
