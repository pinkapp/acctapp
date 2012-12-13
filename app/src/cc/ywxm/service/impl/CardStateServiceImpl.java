package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.CardStateDao;
import cc.ywxm.model.CardState;
import cc.ywxm.service.CardStateService;

@Transactional
@Service
public class CardStateServiceImpl implements CardStateService
{
	@Resource
	private CardStateDao cardStateDao;

	public void remove(Short stateId)
	{
		if (stateId != null)
		{
			CardState cardState = cardStateDao.findById(stateId);
			cardStateDao.delete(cardState);
		}
	}

	public CardState findById(Short stateId)
	{
		return cardStateDao.findById(stateId);
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String stateName)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", cardStateDao.list(rows, page, stateName));
		map.put("total", cardStateDao.count(stateName));
		return map;
	}

	public List<CardState> list()
	{
		return cardStateDao.list();
	}

	public void add(String stateName)
	{
		CardState cardState = new CardState(stateName);
		cardStateDao.save(cardState);
	}

	public void edit(Short stateId, String stateName)
	{
		if (stateId != null)
		{
			CardState cardState = cardStateDao.findById(stateId);
			cardState.setStateName(stateName);
			cardStateDao.update(cardState);
		}
	}

}
