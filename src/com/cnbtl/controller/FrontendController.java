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
			cases = caseService.selectSomeCase(start,end);
			if(cases != null) {
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
		Case case1 = caseService.selectOneCaseById(id);
		//2.����model��������ͼ
		if(case1 != null) {
			mdv.addObject("case1", case1);
			mdv.setViewName("/frontend/article_show");
		}else {
			mdv.addObject("message", "��ȡָ��Id=" + id +"�İ���ʱ���ִ���!");
			mdv.setViewName("/error");
		}
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
