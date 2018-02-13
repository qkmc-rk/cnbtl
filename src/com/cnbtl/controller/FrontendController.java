package com.cnbtl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnbtl.entity.Case;
import com.cnbtl.service.CaseService;

/**
 * ����ǰ��ҳ���һЩ�����ת��
 * ��Ϊ��Ҫ��һЩmodel�İ�,�����Ҫʹ��controller������.
 * @author Mrruan
 *
 */

@Controller
public class FrontendController {

	@Autowired
	CaseService caseService;
	
	/**
	 * ������ҳ
	 * ��ҳ��Ҫ����������
	 * model 6������
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(Integer start, Integer end) {
		ModelAndView mdv = new ModelAndView();
		//1.��ȡ6������
		if(start == null || end == null) {
			start = 0;
			end = 7;
		}
		List<Case> cases;
		try {
			cases = caseService.getAllCase();
			if(cases != null) {
				cases = cases.subList(0, 6);
				mdv.addObject("cases", cases);
				mdv.setViewName("/frontend/index");
			}else {
				mdv.addObject("message","��ҳ��ȡ����ʱ������������!����Ϊ" + start + "-" + end);
				mdv.setViewName("/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mdv.addObject("message","��ҳ��ȡ����ʱ������������!����Ϊ" + start + "-" + end);
			mdv.setViewName("/error");
		}
		//2.������ҳ
		return mdv;
	}
	
	/**
	 * ���ط���ҳ��,��̬ҳ��
	 * @return ��̬������ͼ��·��������
	 */
	@RequestMapping("/service")
	public String service() {
		return "/frontend/service";
	}
	
	/**
	 * ���ذ���ҳ��,��ҳ������ܶస��,��Ҫ
	 * ���page��ҳʳ��
	 * @return ����ҳ��
	 */
	@RequestMapping("/article")
	public String article() {
		//��ȡ��ҳ��Page
		//��pageװ��model,����
		return null;
	}
	
	@RequestMapping("/article_show")
	public ModelAndView article_show(@RequestParam("id") Integer id) {
		ModelAndView mdv = new ModelAndView();
		//1.ͨ��id��ѯ������
		List<Case> cases = caseService.getAllCase();
		Case case0,case1 = null,case2;
		//��list�л�ȡָ��id�ļ�¼.
		for (Case cs : cases) {
			if(cs.getId() == id) {
				case1 = cs;
				break;
			}
		}
		//��list�л�ȡָ��id��object��ǰһ��.��Ҫ�ж��Ƿ��ǵ�һ��
		if(cases.indexOf(case1)-1 >= 0 && null != cases.get(cases.indexOf(case1) - 1) ) {
			case0 = cases.get(cases.indexOf(case1)-1);
		}else {
			case0 = null;
		}
		//��list�л�ȡָ��id��object�ĺ�һ��,��Ҫ�ж��Ƿ������һ��
		if(cases.indexOf(case1)+1 < cases.size() && null != cases.get(cases.indexOf(case1) + 1) ) {
			case2 = cases.get(cases.indexOf(case1)+1);
		}else {
			case2 = null;
		}
		System.out.println(case0);
		System.out.println(case1);
		System.out.println(case2);
		//������ͼ
		if(case1 != null) {
			mdv.addObject("case0", case0);
			mdv.addObject("case1", case1);
			mdv.addObject("case2", case2);
			mdv.setViewName("/frontend/article_show");
		}else {
			mdv.addObject("message", "��ȡָ��Id=" + id +"�İ���ʱ���ִ���!");
			mdv.setViewName("/error");
		}
		//2.������ͼ
		return mdv;
	}
	
	/**
	 * ������ϵҳ��
	 * @return ��ϵ��ͼ��·��������
	 */
	@RequestMapping("/contact")
	public String contact() {
		return "/frontend/contact";
	}
	/**
	 * ���ع���ҳ��
	 * @return ������ͼ��·��������
	 */
	@RequestMapping("/about")
	public String about() {
		return "/frontend/about";
	}
	
}
