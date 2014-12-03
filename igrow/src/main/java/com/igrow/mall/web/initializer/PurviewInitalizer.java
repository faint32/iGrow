package com.igrow.mall.web.initializer;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.service.admin.intf.PurviewService;

@Service("purviewInitalizer")
public class PurviewInitalizer implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PurviewInitalizer.class);
	private static final String[] IGNORE_PROPERTIES={"id","createDate","createOperator"};
	@Resource(name = "purviewServiceImpl")
	private PurviewService purviewService;
	
	private Integer count=0;
	
	@SuppressWarnings("unchecked")
	public void execute(){
		logger.debug("系统权限功能点初始化开始");
		 try {
			SAXReader reader = new SAXReader();
			 Document document=reader.read(PurviewInitalizer.class.getResource("/purview.xml"));
			 Element element=document.getRootElement();
			 List<Element> elements= element.elements();
			 readElement(elements, null);
		} catch (Exception e) {
			logger.error("系统权限功能点初始化异常",e);
		}
		 logger.debug("系统权限功能点初始化结束,共初始化{}条数据",count);
	}
	
	@SuppressWarnings("unchecked")
	private void readElement(List<Element> elements,PurviewInfo parent) throws Exception, NoSuchFieldException{
		if(elements != null && elements.size() > 0){
			for(Element element : elements){
				PurviewInfo entity = new PurviewInfo();
				System.out.println(element.elementText("code")+"_"+element.elementText("name"));
				entity.setId(element.elementText("id"));
				entity.setName(element.elementText("name"));
				entity.setCode(element.elementText("code"));
				entity.setLevel(Integer.valueOf(element.elementText("level")));
				entity.setLinkurl(element.elementText("linkurl"));
				entity.setIsMenu(Bool.valueOf(Integer.valueOf(element.elementText("menu_flag"))));
				entity.setSortNo(Integer.valueOf(element.elementText("sort_no")));
				entity.setStyle(element.elementText("style"));
				entity.setParent(parent);
				if(StringUtils.isBlank(entity.getLinkurl()))
					entity.setLinkurl("#");
				purviewService.save(entity.getId(),entity, IGNORE_PROPERTIES);
				count++;
				if(element.element("child_nodes")!=null){
					readElement(element.element("child_nodes").elements(),entity);
				}
			}
		}
	}
}
