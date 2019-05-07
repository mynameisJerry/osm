package com.pzhu.shopping.myshop.controller.goods;


import com.pzhu.shopping.myshop.pojo.goods.Goods;
import com.pzhu.shopping.myshop.pojo.goods.GoodsType;
import com.pzhu.shopping.myshop.service.goods.GoodsService;
import com.pzhu.shopping.myshop.utils.TextUtils;
import com.pzhu.shopping.myshop.vo.PageBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jackiechan on 10/16/18/7:22 PM
 *
 * @Author jackiechan
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger=Logger.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getgoodstypelist")
    @ResponseBody
    public List<GoodsType> getGoodsTypeList() {
        List<GoodsType> goodsTypelList = goodsService.getGoodsTypeList();
        logger.info("获取所有商品类型"+goodsTypelList.toString());
        logger.trace(goodsTypelList);
        return goodsTypelList;
    }

    @RequestMapping("/getgoodsbytypeid")
    public String getGoodsByTypeId(Integer typeId, Integer pageNum, Integer pageSize, Model model) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 4 : pageSize;
        PageBean pageBean = goodsService.getGoodsByTypeId(typeId, pageNum, pageSize);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("typeId", typeId);
        logger.trace("通过商品类型id查询商品"+pageBean.toString());
        return "/goodsList";
    }

    /**
     * 根据商品id查询商品信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getgoodsdetailbyid")
    public String getGoodsDetailById(Integer id, Model model) {
        Goods goods=goodsService.getGoodsDetailById(id);
        model.addAttribute("goods", goods);
        logger.info("获取商品详情"+goods.toString());
        return "/goodsDetail";
    }

    @RequestMapping("/searchgoods")
    public String searchGoods(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String goodsname = request.getParameter("goodsname");
        if(TextUtils.empty(goodsname)){
            return "/goodssearch";
        }
        List<Goods> list=goodsService.searchByName(goodsname);
        for (Goods goods : list) {
            System.out.println(goods);
        }
        model.addAttribute("list",list);
        logger.info("查询商品"+list.toString());
        return "/goodssearch";
    }


}
