package com.myshaveden.services;

import java.util.List;

import com.myshaveden.viewmodels.LookupDataModel;

public interface LookupService {

  List<LookupDataModel> findLookupData(String typeName);

}
