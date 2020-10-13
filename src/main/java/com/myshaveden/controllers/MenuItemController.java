package com.myshaveden.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshaveden.services.MenuItemService;
import com.myshaveden.viewmodels.MenuItemModel;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
  private MenuItemService menuItemService;

  @Autowired
  public MenuItemController(MenuItemService menuItemService) {
    this.menuItemService = menuItemService;
  }

  @GetMapping
  public ResponseEntity<List<MenuItemModel>> fetchAllMenuItems() {
    List<MenuItemModel> menuItems = menuItemService.findAll();
    return ResponseEntity.ok(menuItems);
  }
}
