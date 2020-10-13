package com.myshaveden.controllers;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.myshaveden.services.MenuItemService;
import com.myshaveden.viewmodels.MenuItemModel;

public class MenuItemControllerTest {
  private MenuItemController controller = null;

  @BeforeEach
  public void setup() {
    MenuItemService mockService = new MenuItemService() {

      @Override
      public List<MenuItemModel> findAll() {
        List<MenuItemModel> modelList = new ArrayList<>();
        return modelList;
      }

    };
    controller = new MenuItemController(mockService);
  }

  @Test
  public void fetchAllMenuItemsTest() {
    ResponseEntity<List<MenuItemModel>> response = controller.fetchAllMenuItems();
    assertNotNull(response);
    assertNotNull(response.getBody());
  }
}
