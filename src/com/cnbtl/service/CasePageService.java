package com.cnbtl.service;

import com.cnbtl.entity.Case;
import com.cnbtl.util.Page;


public interface CasePageService {

	/**
	 * ���ݴ���ĵ�ǰҳ��ҳ��,��ȡ��page���󲢷���.
	 * page�е���Ҫ����Ϊ��ǰҳ��ļ�¼�б�
	 * ������ϢΪ��ǰҳ,��һҳ,��ҳ,ʲôʲô��.
	 * @param currentPage
	 * @return
	 */
	Page<Case> getPage(Integer currentPage);
}
