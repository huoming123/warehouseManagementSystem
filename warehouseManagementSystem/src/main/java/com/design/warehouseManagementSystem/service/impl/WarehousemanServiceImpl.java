package com.design.warehouseManagementSystem.service.impl;

import com.design.warehouseManagementSystem.pojo.Warehouseman;
import com.design.warehouseManagementSystem.mapper.WarehousemanMapper;
import com.design.warehouseManagementSystem.service.WarehousemanService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.warehouseManagementSystem.util.PageUtil;
import com.design.warehouseManagementSystem.dto.Page;
/**
 * (Warehouseman)表服务实现类
 *
 * @author makejava
 */
@Service("warehousemanService")
public class WarehousemanServiceImpl implements WarehousemanService {
    @Autowired
    private WarehousemanMapper warehousemanMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Warehouseman> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Warehouseman> list= warehousemanMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = warehousemanMapper.getPageSearchCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Warehouseman> queryById(Integer id) {
       Warehouseman warehouseman=this.warehousemanMapper.queryById(id);
         return RestFulBean.succ(warehouseman);
    }

    /**
     * 新增数据
     *
     * @param warehouseman 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Warehouseman warehouseman) {
        if(warehouseman.getEmail()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("邮箱不能为空");
        }
        if(!warehouseman.getEmail().contains("@")){
            return RestFulBean.error("邮箱不合法");
        }
        if(warehouseman.getUserNo()==null){
            return RestFulBean.error("员工编号不能为空");
        }
        if(warehouseman.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(warehouseman.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(warehouseman.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(warehouseman.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        Warehouseman warehousemaned =warehousemanMapper.getByUserNo(warehouseman.getUserNo());//根据员工编号是否注册
        if(warehousemaned!=null){
            return RestFulBean.error("该员工编号已注册，请不要重复注册");
        }
        this.warehousemanMapper.increased(warehouseman);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param warehouseman 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Warehouseman warehouseman) {
        this.warehousemanMapper.edit(warehouseman);//执行数据库的修改语句 根据id 修改
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
        this.warehousemanMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
