package com.precize.sat.mapper;

import com.precize.sat.entity.SatResults;
import com.precize.sat.modal.SatResultModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatResultMapper {

    List<SatResultModel> toSatResultModelList(List<SatResults> satResults);
    SatResultModel toSatResultModel(SatResults satResult);
    SatResults toSatResult(SatResultModel satResultModel);
}
