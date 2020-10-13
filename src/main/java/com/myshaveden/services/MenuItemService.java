package com.myshaveden.services;

import java.util.List;

import com.myshaveden.viewmodels.MenuItemModel;

public interface MenuItemService {
  public List<MenuItemModel> findAll();
}
