package top.cynara.ctyping.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import top.cynara.ctyping.entitiy.ExamRecode;
import top.cynara.ctyping.service.ExamRecodeService;

/**
 * @ClassName RecodeController
 * @Description 测试记录控制器
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月23日 下午5:08:48
 * @version V1.0
 */
@Controller
public class RecodeController {
	private Logger log = Logger.getLogger(RecodeController.class);
	@Autowired
	private ExamRecodeService recodeService;

	@ResponseBody
	@RequestMapping(value="/realRecode",produces="application/json; charset=utf-8")
	public void realRecode(HttpServletResponse response) throws IOException {
		List<ExamRecode> erList = recodeService.findAll();
		JSONArray ja = JSONArray.fromObject(erList);
		//设置相应头
		response.setCharacterEncoding("UTF-8");
		//设置无缓存
		response.setHeader( "Pragma", "no-cache" );
		response.addHeader( "Cache-Control", "must-revalidate" );
		response.addHeader( "Cache-Control", "no-cache" );
		response.addHeader( "Cache-Control", "no-store" );
		response.setDateHeader("Expires", 0);
		OutputStream out = response.getOutputStream();
		out.write(ja.toString().getBytes());
		out.flush();
	}
	@RequestMapping("/recode")
	public String recode(){
		return "recode";
	}

	@RequestMapping(value = "/recode/{id}", method = RequestMethod.DELETE)
	public String delte(@PathVariable("id") Integer id) {
		recodeService.delete(id);
		return "redirect:/recodeList";

	}

	@RequestMapping("/recodeList")
	public String recodeList(Map<String, Object> map) {
		List<ExamRecode> erList = recodeService.findAll();
		map.put("erList", erList);
		return "recodelist";

	}
}
