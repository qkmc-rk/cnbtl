package com.cnbtl.util;

import java.util.List;

/**
 * �������ڷ��ؼ�¼��ǰ��ҳ��
 * ���ڷ�ҳ��ʾʹ��
 * @author Mrruan
 *
 * @param <T> TΪ���ݿ��¼����.
 * 
 * ����:
 * 1.�ܼ�¼����,�������ݿ�
 * 2.ÿҳ�ļ�¼��,����ΪĬ��.
 * 3.ҳ�� = totalRowNum/pageRowNum (+1)
 * 4.�����ݿ��ó��ļ�¼����
 * 5.��ǰҳ��
 * ����������
 * 1.�Ƿ�����һҳ������һҳ(����)
 * 2.��ȡ��ǰҳ
 * 3.��ȡ��¼��
 * 4.��ȡ��ҳ��
 */
public class Page<T> {

	//�ܼ�¼����
	private Integer totalRowNum;
	//ÿҳ��¼��
	private Integer pageRowNum;
	//�ܹ���ҳ��
	private Integer totalPageNum;
	
	private List<T> list;
	//��ǰҳ��
	private Integer currentPageNum;
	
	
	
	
}
