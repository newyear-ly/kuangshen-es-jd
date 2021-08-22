package pub.newyear.kuangshenesjd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pub.newyear.kuangshenesjd.service.ContentService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ContentController {

    @Resource
    private ContentService contentService;

    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws Exception{
        return contentService.parseContentIntoEs(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> pageSearch(@PathVariable("keyword") String keyword,
                                               @PathVariable("pageNo") int pageNo,
                                               @PathVariable("pageSize") int pageSize) throws Exception{
        return contentService.pageSearch(keyword,pageNo,pageSize);
    }
}
