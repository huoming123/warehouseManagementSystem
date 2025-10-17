package com.design.warehouseManagementSystem.service.impl;

import com.design.warehouseManagementSystem.mapper.InventoryMapper;
import com.design.warehouseManagementSystem.pojo.Delivery;
import com.design.warehouseManagementSystem.mapper.DeliveryMapper;
import com.design.warehouseManagementSystem.pojo.Inventory;
import com.design.warehouseManagementSystem.pojo.Warehouse;
import com.design.warehouseManagementSystem.service.DeliveryService;
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
 * (Delivery)表服务实现类
 *
 * @author makejava
 */
@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private InventoryMapper inventoryMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Delivery> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Delivery> list= deliveryMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = deliveryMapper.getPageSearchCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        this.exportDeliveryExcel(list);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        map.put("excelUrl","http://localhost:8087/file/deliveryList.xls"); //excel下载路劲
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Delivery> queryById(Integer id) {
       Delivery delivery=this.deliveryMapper.queryById(id);
         return RestFulBean.succ(delivery);
    }

    /**
     * 新增数据
     *
     * @param delivery 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Delivery delivery) {
        if(delivery.getDeliveryNo()==null){
            return RestFulBean.error("出库单号不能为空");
        }
        Delivery deliveryed =deliveryMapper.getByDeliveryNo(delivery.getDeliveryNo());
        if(deliveryed!=null){
            return RestFulBean.error("该出库单号已经录入");
        }
        if(delivery.getProductName()==null){
            return RestFulBean.error("商品名称不能为空");
        }
        if(delivery.getTotal()==null){
            return RestFulBean.error("出库数量不能为空");
        }
        Inventory inventory =inventoryMapper.getByProductName(delivery.getProductName()); //根据名称获取数据
        if(inventory.getTotal()<delivery.getTotal()){
            return RestFulBean.error("库存小于出库数量，无法出库！");
        }
        inventory.setTotal(inventory.getTotal()-delivery.getTotal()); //原来的库存减掉出库的数量
        inventoryMapper.edit(inventory);//刷新库存
        this.deliveryMapper.increased(delivery);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param delivery 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Delivery delivery) {
        this.deliveryMapper.edit(delivery);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Delivery delivery) {
        Inventory inventory =inventoryMapper.getByProductName(delivery.getProductName()); //根据名称获取数据
        inventory.setTotal(inventory.getTotal()+delivery.getTotal()); //原来的库存加上出库的数量
        inventoryMapper.edit(inventory);//刷新库存
        this.deliveryMapper.deleteById(delivery.getId());//执行数据库的删除语句 根据id 删除
        return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getDeliveryAnalyse(Delivery delivery) {
        Map result =new HashMap();
        List typeList = new ArrayList<>();
        List<Delivery> list  =deliveryMapper.getDeliveryAnalyse(delivery); //获取统计的物品出库数量
        for(Delivery deliveryed:list){
            Map type =new HashMap();
            type.put("value",deliveryed.getCount()); //每个物品的出库数量
        type.put("name",deliveryed.getProductName()); //物品名称
        typeList.add(type);
    }
        result.put("typeList",typeList);
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<List<Delivery>> getDeliveryList(Delivery delivery) {
        List<Delivery> list =deliveryMapper.getDeliveryList(delivery); //根据物品名称获取出库记录
        return RestFulBean.succ(list);
    }
    //导出出库excel表
    public void exportDeliveryExcel(List<Delivery> list)throws WriteException, IOException {
        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\deliveryList.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("出库列表",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"出库单号","物品名称","出库数量","出库原因","录入日期","录入人"};
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
                sheet.addCell(new Label(0,i+1,list.get(i).getDeliveryNo())); //出库单号
                sheet.addCell(new Label(1,i+1,list.get(i).getProductName())); //物品名称
                sheet.addCell(new jxl.write.Number(2,i+1,list.get(i).getTotal())); //入库数量
                sheet.addCell(new Label(3,i+1,list.get(i).getReason())); //出库原因
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
