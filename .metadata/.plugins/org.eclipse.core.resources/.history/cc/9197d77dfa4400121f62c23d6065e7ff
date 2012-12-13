package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.CardTypeDao;
import cc.ywxm.model.CardType;
import cc.ywxm.service.CardTypeService;

@Transactional
@Service
public class CardTypeServiceImpl implements CardTypeService
{
	@Resource
	private CardTypeDao cardTypeDao;

	public void remove(Short typeId)
	{
		if (typeId != null)
		{
			CardType cardType = cardTypeDao.findById(typeId);
			cardTypeDao.delete(cardType);
		}
	}

	public CardType findById(Short typeId)
	{
		return cardTypeDao.findById(typeId);
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String typeName,String goodsType, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", cardTypeDao.list(rows, page, typeName,goodsType, valid));
		map.put("total", cardTypeDao.count(typeName,goodsType, valid));
		return map;
	}

	public List<CardType> list()
	{
		return cardTypeDao.list();
	}

	public void add(String typeName, String goodsType, Integer faceValue,
			Double price, String note, Boolean valid)
	{
		CardType cardType = new CardType(typeName, goodsType + "", faceValue,
				price, valid, note);
		cardTypeDao.save(cardType);
	}

	public void edit(Short typeId, String typeName, String goodsType,
			Integer faceValue, Double price, String note, Boolean valid)
	{
		if (typeId != null)
		{
			CardType cardType = cardTypeDao.findById(typeId);
			cardType.setTypeName(typeName);
			cardType.setGoodsType(goodsType + "");
			cardType.setFaceValue(faceValue);
			cardType.setPrice(price);
			cardType.setNote(note);
			cardType.setValid(valid);
			cardTypeDao.update(cardType);
		}
	}

}
