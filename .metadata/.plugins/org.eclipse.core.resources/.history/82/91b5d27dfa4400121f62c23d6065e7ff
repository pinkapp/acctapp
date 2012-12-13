package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.CardsDao;
import cc.ywxm.model.Cards;
import cc.ywxm.service.CardsService;

@Transactional
@Service
public class CardsServiceImpl implements CardsService
{
	@Resource
	private CardsDao cardDao;

	public void add(String cardType, String note, Boolean valid)
	{
		String sn = UUID.randomUUID().toString();
		System.out.println(sn);
		System.out.println(sn.length());
		Cards card = new Cards(cardType, valid, note, "1", sn);
		cardDao.save(card);
	}

	public void remove(Integer cardId)
	{
		if (cardId != null)
		{
			Cards card = cardDao.findById(cardId);
			cardDao.delete(card);
		}
	}

	public Cards findById(Integer cardId)
	{
		return cardDao.findById(cardId);
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String cardType, String sn, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", cardDao.list(rows, page, cardType, sn, valid));
		map.put("total", cardDao.count(cardType, sn, valid));
		return map;
	}

	public void edit(Integer cardId, String cardType, String cardState,
			String note, Boolean valid)
	{
		if (cardId != null)
		{
			Cards card = cardDao.findById(cardId);
			card.setCardType(cardType);
			card.setCardState(cardState);
			card.setNote(note);
			card.setValid(valid);
			cardDao.update(card);
		}
	}

}
