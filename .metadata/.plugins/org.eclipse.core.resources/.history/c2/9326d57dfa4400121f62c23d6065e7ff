package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.GoodsDao;
import cc.ywxm.model.Goods;
import cc.ywxm.service.GoodsService;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService
{
	@Resource
	private GoodsDao goodsDao;

	public void add(String goodsType, String goodsProp, Double goodsPrice,
			String note, Boolean valid)
	{
		Goods goods = new Goods(goodsType, goodsProp, goodsPrice,
				valid, note);
		goodsDao.save(goods);
	}

	public void remove(Integer goodsId)
	{
		if (goodsId != null)
		{
			Goods goods = goodsDao.findById(goodsId);
			goodsDao.delete(goods);
		}
	}

	public Goods findById(Integer goodsId)
	{
		return goodsDao.findById(goodsId);
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String goodsType, String goodsProp, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", goodsDao.list(rows, page, goodsType, goodsProp, valid));
		map.put("total", goodsDao.count(goodsType, goodsProp, valid));
		return map;
	}

	public void edit(Integer goodsId, String goodsType, String goodsProp,
			Double goodsPrice, String note, Boolean valid)
	{
		if (goodsId != null)
		{
			Goods goods = goodsDao.findById(goodsId);
			goods.setGoodsType(goodsType + "");
			goods.setGoodsProp(goodsProp + "");
			goods.setGoodsPrice(goodsPrice);
			goods.setNote(note);
			goods.setValid(valid);
			goodsDao.update(goods);
		}
	}

	public List<Goods> list(String goodsType, String goodsProp, Boolean valid)
	{
		return goodsDao.list(goodsType, goodsProp, valid);
	}

}
