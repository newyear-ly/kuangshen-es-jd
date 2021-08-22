package pub.newyear.kuangshenesjd.service;

import java.util.List;
import java.util.Map;

public interface ContentService {

    Boolean parseContentIntoEs(String keyword) throws Exception;

    List<Map<String,Object>> pageSearch(String keyword, int pageNo, int pageSize) throws Exception;

}
