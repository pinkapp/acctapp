package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.GoodsPropDao;
import cc.ywxm.model.GoodsProp;
import cc.ywxm.service.GoodsPropService;

@Transactional
@Service
public class GoodsPropServiceImpl implements GoodsPropService
{
	@Resource
	private GoodsPropDao goodsPropDao;

	public void add(String typeName, String note, Boolean valid)
	{
		GoodsProp goodsProp = new GoodsProp(typeName, valid, note);
		goodsPropDao.save(goodsProp);
	}

	public void remove(Short typeId)
	{
		if (typeId != null)
		{
			GoodsProp goodsProp = goodsPropDao.findById(typeId);
			goodsPropDao.delete(goodsProp);
		}
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String typeName, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", goodsPropDao.list(rows, page, typeName, valid));
		map.put("total", goodsPropDao.count(typeName, valid));
		return map;
	}

	public void edit(Short typeId, String typeName, String note, Boolean valid)
	{
		if (typeId != null)
		{
			GoodsProp goodsProp = goodsPropDao.findById(typeId);
			goodsProp.setTypeName(typeName);
			goodsProp.setNote(note);
			goodsProp.setValid(valid);
			goodsPropDao.update(goodsProp);
		}
	}

	public GoodsProp findById(Short typeId)
	{
		return goodsPropDao.findById(typeId);
	}

	public List<GoodsProp> list()
	{
		return goodsPropDao.list();
	}

}
