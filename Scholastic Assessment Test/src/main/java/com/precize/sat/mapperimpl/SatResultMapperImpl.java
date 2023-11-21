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
            SatResultModel satResultModel = new SatResultModel(results.getId(), results.getName(), results.getAddress(),
                    results.getName(), results.getCountry(), results.getPincode(), results.getScore());
            data.add(satResultModel);
        }
        return data;
    }

    @Override
    public SatResultModel toSatResultModel(SatResults satResult) {
        SatResultModel data = new SatResultModel(satResult.getId(), satResult.getName(), satResult.getAddress(),
                satResult.getCity(), satResult.getCountry(), satResult.getPincode(), satResult.getScore());
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
