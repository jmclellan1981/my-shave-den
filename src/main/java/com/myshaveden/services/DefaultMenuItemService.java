package com.myshaveden.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshaveden.domain.MenuItem;
import com.myshaveden.repositories.MenuItemRepository;
import com.myshaveden.viewmodels.ImmutableMenuItemModel;
import com.myshaveden.viewmodels.MenuItemModel;

@Service
public class DefaultMenuItemService implements MenuItemService {
  private MenuItemRepository menuItemRepository;

  @Autowired
  public DefaultMenuItemService(MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  @Override
  public List<MenuItemModel> findAll() {
    List<MenuItemModel> modelList = new ArrayList<>();
    List<MenuItem> menuItems = menuItemRepository.findAll();
    for (MenuItem menuItem : menuItems) {
      MenuItemModel menuItemModel = ImmutableMenuItemModel.builder().title(menuItem.getTitle()).path(menuItem.getPath())
          .action(menuItem.getAction()).build();
      modelList.add(menuItemModel);
    }
    return modelList;
  }

}
