package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.GoodsTypeDao;
import cc.ywxm.model.GoodsType;
import cc.ywxm.service.GoodsTypeService;

@Transactional
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService
{
	@Resource
	private GoodsTypeDao goodsTypeDao;

	public void add(String typeName, String note, Boolean valid)
	{
		GoodsType goodsType = new GoodsType(typeName, valid, note);
		goodsTypeDao.save(goodsType);
	}

	public void remove(Short typeId)
	{
		if (typeId != null)
		{
			GoodsType goodsType = goodsTypeDao.findById(typeId);
			goodsTypeDao.delete(goodsType);
		}
	}

	public GoodsType findById(Short typeId)
	{
		return goodsTypeDao.findById(typeId);
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String typeName, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", goodsTypeDao.list(rows, page, typeName, valid));
		map.put("total", goodsTypeDao.count(typeName, valid));
		return map;
	}

	public void edit(Short typeId, String typeName, String note, Boolean valid)
	{
		if (typeId != null)
		{
			GoodsType goodsType = goodsTypeDao.findById(typeId);
			goodsType.setTypeName(typeName);
			goodsType.setNote(note);
			goodsType.setValid(valid);
			goodsTypeDao.update(goodsType);
		}
	}

	public List<GoodsType> list()
	{
		return goodsTypeDao.list();
	}

}
