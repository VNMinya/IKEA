package com.njxzc.service.admin;

import com.njxzc.dao.AdminGoodsDao;
import com.njxzc.po.Goods;
import com.njxzc.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminGoodsService")
public class AdminGoodsServiceImp implements AdminGoodsService{
    @Autowired
    private AdminGoodsDao adminGoodsDao;

    /**
     * 添加或更新
     */

    @Override
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct){
        System.out.println(goods);
        System.out.println(goods.getLogoImage());
        //防止文件名重名
        String newFileName = "";
        String fileName = goods.getLogoImage().getOriginalFilename();
        //选择了文件
        if(fileName.length() > 0){
            String realpath = request.getServletContext().getRealPath("logos");
            //实现文件上传
            String fileType = fileName.substring(fileName.lastIndexOf('.'));
            //防止文件名重名
            newFileName = MyUtil.getStringID() + fileType;
            goods.setGpicture(newFileName);
            File targetFile = new File(realpath, newFileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            //上传
            try {
                goods.getLogoImage().transferTo(targetFile);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //修改
        if("update".equals(updateAct)){
            //修改到数据库
            if(adminGoodsDao.updateGoodsById(goods) > 0){
                return "forward:/adminGoods/selectGoods.do?act=updateSelect";
            }
            else{
                return "/adminGoods/updateAgoods.do";
            }
        }
        else{
            //保存到数据库
            if(adminGoodsDao.addGoods(goods) > 0){
                //转发到查询的controller
                return "forward:/adminGoods/selectGoods.do";
            }
            else {
                return "card/addCard";
            }
        }
    }

    /**
     * 查询商品
     */
    @Override
    public String selectGoods(Model model, Integer pageCur, String act){
        List<Goods> allGoods = adminGoodsDao.selectGoods();
        int temp = allGoods.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if(temp == 0){
            totalPage = 0;  //总页数
        }
        else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp/10);
        }
        if(pageCur == null){
            pageCur = 1;
        }
        if((pageCur-1)*10 > temp){
            pageCur = pageCur-1;
        }

        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur-1)*10);  //起始位置
        map.put("perPageSize", 10); //每页十个
        allGoods = adminGoodsDao.selectAllGoodsByPage(map);
        model.addAttribute("allGoods", allGoods);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);

        //删除查询
        if("deleteSelect".equals(act)){
            return "admin/deleteSelectGoods";
        }

        //修改查询
        else if("updateSelect".equals(act)){
            return "admin/updateSelectGoods";
        }
        else {
            return "admin/selectGoods";
        }
    }

    /**
     * 查询一个商品
     */
    @Override
    public String selectAGoods(Model model, Integer id, String act){
        Goods agoods = adminGoodsDao.selectGoodsById(id);
        model.addAttribute("goods", agoods);
        //修改页面
        if("updateAgoods".equals(act)){
            return "admin/updateAgoods";
        }

        //详情页面
        return "admin/goodsDetail";
    }

    /**
     * 删除多个商品
     */
    @Override
    public String deleteGoods(Integer[] ids, Model model) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ids.length; i++) {
            if(adminGoodsDao.selectCartGoods(ids[i]).size() > 0 ||
                    adminGoodsDao.selectFocusGoods(ids[i]).size() > 0 ||
                    adminGoodsDao.selectOrderdetailGoods(ids[i]).size() > 0) {
                model.addAttribute("msg", "商品有关联，不允许删除！");
                return "forward:/adminGoods/selectGoods.do?act=deleteSelect";
            }
            list.add(ids[i]);
        }
        adminGoodsDao.deleteGoods(list);
        model.addAttribute("msg", "成功删除商品！");
        return "forward:/adminGoods/selectGoods.do?act=deleteSelect";
    }

    /**
     * 删除一个商品
     */
    @Override
    public String deleteAGoods(Integer id, Model model) {
        if(adminGoodsDao.selectCartGoods(id).size() > 0 ||
                adminGoodsDao.selectFocusGoods(id).size() > 0 ||
                adminGoodsDao.selectOrderdetailGoods(id).size() > 0) {
            model.addAttribute("msg", "商品有关联，不允许删除！");
            return "forward:/adminGoods/selectGoods.do?act=deleteSelect";
        }
        adminGoodsDao.deleteAGoods(id);
        model.addAttribute("msg", "成功删除商品！");
        return "forward:/adminGoods/selectGoods.do?act=deleteSelect";
    }
}
