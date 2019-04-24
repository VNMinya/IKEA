package com.njxzc.service;

import com.njxzc.dao.AdminGoodsDao;
import com.njxzc.po.Goods;
import com.njxzc.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Service
public class AdminGoodsServiceImp implements AdminGoodsService{
    @Autowired
    private AdminGoodsDao adminGoodsDao;

    /**
     * 添加或更新
     */

    @Override
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct){
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
                return "forward:/adminGoods/selectGoods?act=updateSelect";
            }
            else{
                return "/adminGoods/updateAgoods";
            }
        }
        else{
            //保存到数据库
            if(adminGoodsDao.addGoods(goods) > 0){
                //转发到查询的controller
                return "forward:/adminGoods/selectGoods";
            }
            else {
                return "card/addCard";
            }
        }
    }
}
