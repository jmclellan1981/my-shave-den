package com.myshaveden.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshaveden.services.LookupService;
import com.myshaveden.viewmodels.LookupDataModel;

@RestController
@RequestMapping("/lookups")
public class LookupController {

  private LookupService service;

  @Autowired
  public LookupController(LookupService service) {
    this.service = service;
  }

  @GetMapping("/data/{typeName}")
  public ResponseEntity<List<LookupDataModel>> findLookupData(@PathVariable("typeName") String typeName) {
    List<LookupDataModel> lookupData = service.findLookupData(typeName);
    return ResponseEntity.ok(lookupData);
  }
}
