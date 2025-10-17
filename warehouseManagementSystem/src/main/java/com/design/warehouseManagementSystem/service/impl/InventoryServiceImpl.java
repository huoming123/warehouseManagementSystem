package com.design.warehouseManagementSystem.service.impl;

import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.pojo.Inventory;
import com.design.warehouseManagementSystem.mapper.InventoryMapper;
import com.design.warehouseManagementSystem.service.InventoryService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.warehouseManagementSystem.pojo.res.RestFulBean;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.warehouseManagementSystem.util.PageUtil;
import com.design.warehouseManagementSystem.dto.Page;
/**
 * (Inventory)表服务实现类
 *
 * @author makejava
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Inventory> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Inventory> list= inventoryMapper.getPageSearchByCondition(page);
        this.exportInventoryExcel(list);
        //根据条件查询数据的条数
        Integer count = inventoryMapper.getPageSearchCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        map.put("excelUrl","http://localhost:8087/file/inventoryList.xls"); //excel下载路劲
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Inventory> queryById(Integer id) {
       Inventory inventory=this.inventoryMapper.queryById(id);
         return RestFulBean.succ(inventory);
    }

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Inventory inventory) {
        if(inventory.getProductName()==null){
            return RestFulBean.error("物品名称不能为空");
        }
        if(inventory.getProductNo()==null){
            return RestFulBean.error("物品编号不能为空");
        }
        Inventory inventoryed =inventoryMapper.getByProductNo(inventory.getProductNo());
        if(inventoryed!=null){
            return RestFulBean.error("该物品编号已经添加，请不要重复添加");
        }
        Inventory inventoryed1 =inventoryMapper.getByProductName(inventory.getProductName());
        if(inventoryed1 !=null){
            return RestFulBean.error("该物品已经添加，请不要重复添加");
        }
        this.inventoryMapper.increased(inventory);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Inventory inventory) {
        this.inventoryMapper.edit(inventory);//执行数据库的修改语句 根据id 修改
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
        this.inventoryMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Inventory>> getProductList(Inventory inventory) {
        List<Inventory> list =inventoryMapper.getProductList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Inventory> getByName(Inventory inventory) {
        Inventory inventoryed =inventoryMapper.getByProductName(inventory.getProductName());
        return RestFulBean.succ(inventoryed);
    }

    @Override
    public RestFulBean<Map> getInventoryAnalyse(Inventory inventory) {
        Map result =new HashMap();
        List<String> equList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Inventory> list  =inventoryMapper.getInventoryAnalyse(inventory); //统计库存数量
        for(Inventory inventoryed:list){
            equList.add(inventoryed.getProductName()); //物品名称
            countList.add(inventoryed.getNum()); //库存数量
        }
        result.put("equList",equList);
        result.put("countList",countList);
        return RestFulBean.succ(result);
    }



    //导出库存excel表
    public void exportInventoryExcel(List<Inventory> list)throws WriteException, IOException {
        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\inventoryList.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("库存列表",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"物品编号","物品名称","库存数量","存放位置","录入日期","录入人"};
        //单元格
        Label label=null;
        //第一行设置列名
        for(int i=0;i<titles.length;i++){

            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }

        try {

            for(int i = 0; i<list.size(); i++){
                // 创建一个SimpleDateFormat对象，定义日期和时间格式
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                // 将Date对象转换为字符串
                String dateString = formatter.format(list.get(i).getCreatedAt());
                sheet.addCell(new Label(0,i+1,list.get(i).getProductNo())); //物品单号
                sheet.addCell(new Label(1,i+1,list.get(i).getProductName())); //物品名称
                sheet.addCell(new jxl.write.Number(2,i+1,list.get(i).getTotal())); //库存数量
                sheet.addCell(new Label(3,i+1,list.get(i).getStorageRoom())); //存放位置
                sheet.addCell(new Label(4,i+1,dateString)); //录入日期
                sheet.addCell(new Label(5,i+1,list.get(i).getCreatedBy())); //录入人
            }
            wwb.write();

        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            wwb.close();
        }
    }
}
