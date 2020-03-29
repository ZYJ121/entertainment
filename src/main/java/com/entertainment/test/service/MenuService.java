package com.entertainment.test.service;

import com.entertainment.test.controller.menu.MenuCell;
import com.entertainment.test.entity.MenuEntity;
import com.entertainment.test.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 zhouyanjie
 * @创建时间 2020/1/23 15:02
 * @描述
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepo menuRepo;

    public List<MenuCell> getAll(){
        List<MenuEntity> menuEntities=menuRepo.findAll();
//        父级菜单
        List<MenuEntity> parentList=new ArrayList<>();
        for(MenuEntity menu:menuEntities){
            if(menu.getParentId()!=null&&!"".equals(menu.getParentId())&&menu.getParentId()<=0&&menu.getState()!=0){
                parentList.add(menu);
            }
        }
//        最终版本菜单
        List<MenuCell> finalMenu=new ArrayList<>();
        for (MenuEntity m:parentList){
            MenuCell menuCell =new MenuCell();
            menuCell.setName(m.getName());
            menuCell.setUrl(m.getUrl());
            menuCell.setIcon(m.getIcon());
//            子级菜单
            List<MenuEntity> childList=new ArrayList<>();
            for(MenuEntity menu:menuEntities){
                if(menu.getParentId()!=null&&!"".equals(menu.getParentId())&&menu.getParentId()==m.getId()&&menu.getState()!=0){
                    childList.add(menu);
                }
            }
            menuCell.setChild(childList);
            finalMenu.add(menuCell);
        }
        return finalMenu;
    }
}
