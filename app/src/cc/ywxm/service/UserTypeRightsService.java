package cc.ywxm.service;

import java.util.List;

import cc.ywxm.model.UserTypeRights;

public interface UserTypeRightsService
{
	List<Integer> listRights(Short userType);
	
	UserTypeRights findbyId(Short userType);

	void editRights(Short typeId, String rights);

	void edit(Short userType, String rights,
			String goodsIds);
	
	void rights_set(Short userType,String rights);
	void goodsId_set(Short userType,String goodsIds);
}
