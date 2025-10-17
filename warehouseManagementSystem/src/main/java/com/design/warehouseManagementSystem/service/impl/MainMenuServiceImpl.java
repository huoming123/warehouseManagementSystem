package com.design.warehouseManagementSystem.service.impl;

import com.design.warehouseManagementSystem.mapper.ManagerMapper;
import com.design.warehouseManagementSystem.mapper.SubmenuMapper;
import com.design.warehouseManagementSystem.pojo.MainMenu;
import com.design.warehouseManagementSystem.mapper.MainMenuMapper;
import com.design.warehouseManagementSystem.pojo.Submenu;
import com.design.warehouseManagementSystem.pojo.Users;
import com.design.warehouseManagementSystem.service.MainMenuService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MainMenu)表服务实现类
 *
 * @author makejava
 * @since @since
 */
@Service("mainMenuService")
public class MainMenuServiceImpl implements MainMenuService {
    @Autowired
    private MainMenuMapper mainMenuMapper;

    @Autowired
    private SubmenuMapper submenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<MainMenu> queryById(Integer id) {
       MainMenu mainMenu=this.mainMenuMapper.queryById(id);
         return RestFulBean.succ(mainMenu);
    }

    /**
     * 新增数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(MainMenu mainMenu) {
        this.mainMenuMapper.insert(mainMenu);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(MainMenu mainMenu) {
        this.mainMenuMapper.update(mainMenu);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.mainMenuMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
    /**
     * 获取菜单权限
     *
     * @param user
     * @return Map<Object, Object>
     */
    @Override
    public RestFulBean<List<MainMenu>> getMenuTree(Users user) throws Exception {
        //try catch 如果请求异常 则return 请求异常
        try {
            String type =user.getRole();//拿到用户属于哪个角色
            List<MainMenu> mainMenu=mainMenuMapper.getMenuTree(type);
            return RestFulBean.succ(mainMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return RestFulBean.error("请求异常");
        }
    }
    //新增子菜单
    @Override
    public RestFulBean<String> addMenu(Submenu submenu) throws Exception {
        //判空
        if(submenu.getMainId()==null)
        {
            return RestFulBean.error("请选择主菜单");
        }
        if(submenu.getMenuName()==null)
        {
            return RestFulBean.error("菜单名字不能为空");
        }
        if(submenu.getSeq()==null)
        {
            return RestFulBean.error("序号不能为空");
        }
            submenu.setCreatedBy("developer");
            submenu.setUpdatedBy("developer");
            submenuMapper.addMenu(submenu);
           return RestFulBean.succ("新增成功");
    }
    //新增主菜单
    @Override
    public RestFulBean<String> addMainMenu(MainMenu mainMenu) {
        //判空
        if(mainMenu.getMainName()==null)
        {
            return RestFulBean.error("菜单名字不能为空");
        }
        if(mainMenu.getSeq()==null)
        {
            return RestFulBean.error("序号不能为空");
        }
        //创建人跟修改写死开发者 这个功能只有开发者用
        mainMenu.setCreatedBy("developer");
        mainMenu.setUpdatedBy("developer");
        mainMenuMapper.addMenu(mainMenu);
        return RestFulBean.succ("新增成功");
    }
    //修改主菜单
    @Override
    public RestFulBean<String> updateMainMenu(MainMenu mainMenu) {
        mainMenuMapper.updateMainMenu(mainMenu);
        return RestFulBean.succ("修改成功");
    }
    //修改子菜单
    @Override
    public RestFulBean<String> updateMenu(Submenu submenu) {
        submenuMapper.updateMenu(submenu);
        return RestFulBean.succ("修改成功");
    }
   //删除子菜单
    @Override
    public RestFulBean<String> delMenu(Submenu submenu) {
        submenuMapper.deleteById(submenu.getId());
        return RestFulBean.succ("删除成功");
    }
    //用@Transactional事务注解回滚 多表删除 如果报错则撤回原来删除的数据
    @Transactional
    @Override
    public RestFulBean<String> delMainMenu(MainMenu mainMenu) {
        //删除主菜单 必须要主表细表的数据都删除掉 就是 main_menu submenu 相关联的数据都删掉
        Integer id =mainMenu.getId();//main_menu的id
        List<Submenu>list=submenuMapper.getByMainId(id);
        if(list.size()>0)
        {
            for(Submenu submenu:list){
                submenuMapper.deleteById(submenu.getId());//把submenu表中main_id所有等于main_menu  id 的值全部删除
            }
        }
        mainMenuMapper.deleteById(id);//根据id删掉main_menu中的表
        return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<MainMenu>> getRoleMenu() {
        List<MainMenu> list =mainMenuMapper.getRoleMenu();
        return RestFulBean.succ(list);
    }
}
