package com.myshaveden.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.myshaveden.domain.MenuItem;
import com.myshaveden.repositories.MenuItemRepository;
import com.myshaveden.viewmodels.MenuItemModel;

public class DefaultMenuItemServiceTest {

  private DefaultMenuItemService service;

  @BeforeEach
  public void setup() {
    service = new DefaultMenuItemService(getMockMenuItemRepository());
  }

  @Test
  public void testFindAll() {
    List<MenuItemModel> result = service.findAll();
    assertNotNull(result);
  }

  private MenuItemRepository getMockMenuItemRepository() {
    MenuItemRepository mockRepository = Mockito.mock(MenuItemRepository.class);
    List<MenuItem> menuList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      MenuItem item = Mockito.mock(MenuItem.class);
      Mockito.when(item.getAction()).thenReturn("ACTION");
      Mockito.when(item.getPath()).thenReturn("PATH");
      Mockito.when(item.getTitle()).thenReturn("TITLE");
      menuList.add(item);
    }
    Mockito.when(mockRepository.findAll()).thenReturn(menuList);
    return mockRepository;
  }
}
