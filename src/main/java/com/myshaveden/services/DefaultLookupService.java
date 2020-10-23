package com.myshaveden.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshaveden.domain.LookupData;
import com.myshaveden.domain.LookupType;
import com.myshaveden.repositories.LookupDataRepository;
import com.myshaveden.repositories.LookupTypeRepository;
import com.myshaveden.viewmodels.LookupDataModel;
import com.myshaveden.viewmodels.LookupTypeModel;

@Service
public class DefaultLookupService implements LookupService {
  private LookupDataRepository dataRepository;
  private LookupTypeRepository typeRepository;

  @Autowired
  public DefaultLookupService(LookupDataRepository dataRepository, LookupTypeRepository typeRepository) {
    this.dataRepository = dataRepository;
    this.typeRepository = typeRepository;
  }

  @Override
  public List<LookupDataModel> findLookupData(String typeName) {
    List<LookupDataModel> modelList = new ArrayList<>();
    List<LookupData> dataList = null;
    LookupType lookupType = typeRepository.findByTypeName(typeName);
    dataList = dataRepository.findDataByLookupType(lookupType);
    if (dataList != null) {
      for (LookupData data : dataList) {
        LookupTypeModel lookupTypeModel = new LookupTypeModel.Builder().withId(data.getLookupType().getId().toString())
            .withTypeDescription(data.getLookupType().getTypeDescription())
            .withTypeName(data.getLookupType().getTypeName()).build();
        LookupDataModel model = new LookupDataModel.Builder().withDataDescription(data.getDataDescription())
            .withDataName(data.getDataName()).withLookupTypeModel(lookupTypeModel).build();
        modelList.add(model);
      }
    }
    return modelList;
  }

}
