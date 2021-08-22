package pub.newyear.kuangshenesjd.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pub.newyear.kuangshenesjd.pojo.Content;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlParseUtil {

    public static void main(String[] args) throws Exception {
        parseJD("码出高效");
    }

    private static String headerString = ":authority: search.jd.com\n" +
            ":method: GET\n" +
            ":path: /search?keyword=java\n" +
            ":scheme: https\n" +
            "accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\n" +
            "accept-encoding: gzip, deflate, br\n" +
            "accept-language: zh-CN,zh;q=0.9\n" +
            "cache-control: max-age=0\n" +
            "cookie: __jdu=1911670057; areaId=19; ipLoc-djd=19-1607-40152-0; PCSYCityID=CN_440000_440300_440307; shshshfpa=4d804879-f6de-e1dc-5615-df2cb6fc849c-1629518056; user-key=fd13d0f5-178c-47d4-b247-9a7343fd59ad; unpl=V2_ZzNtbRcDFxQmCkUAcktUVmILG18SVRQUJ1oWAHkaXg0yARZeclRCFnUUR11nGlwUZwMZWUdcQB1FCEdkeB5fA2AFEFlBZxBFLV0CFi9JH1c%2bbRZfQFJGEXcMQFZ%2fKWwGZzMSXHJXSxV1D0BVeh1aNVcEIm1yUEUcfQF2VUsYbEczXxddRFVCFTgITlR7HloEZgcUbUNnQA%3d%3d; shshshfpb=lkxU3VL70Cmf3710A1%20f%2FcQ%3D%3D; __jdv=76161171|baidu|-|organic|not set|1629518081689; __jdc=122270672; __jda=122270672.1911670057.1629518053.1629518082.1629539991.4; wlfstk_smdl=wvo69sm867kmoxgv4n18c1w4zurs0ifw; shshshfp=2c86c5710ad3c4dc96b58eee7dd218b6; rkv=1.0; qrsc=2; __jdb=122270672.5.1911670057|4.1629539991; shshshsID=329d96f37e136acbd9afa18c28e68a1a_3_1629541416844; 3AB9D23F7A4B3C9B=BUHKW6PD7JB6E4PVPR55OJWP67AKLSFIFQ7RGJYSX2GQGIGL53ZOX4KLNPP2BNWURXM5ECIHO7765OPA3DZ6IVT2I4\n" +
            "sec-ch-ua: \"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"\n" +
            "sec-ch-ua-mobile: ?0\n" +
            "sec-fetch-dest: document\n" +
            "sec-fetch-mode: navigate\n" +
            "sec-fetch-site: none\n" +
            "sec-fetch-user: ?1\n" +
            "upgrade-insecure-requests: 1\n" +
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36";

    public static List<Content> parseJD(String keyword) throws IOException {
        String url = "https://search.jd.com/search?keyword="+keyword;
        Connection connect = Jsoup.connect(url);
        //设置多个请求头，头信息保存到Map集合中
        Map<String, String> header = new HashMap<String, String>();
        header = InputHandlerUtil.resolve(headerString);
        putHeaderMap(connect,header);
        //解析网页
        Document document = connect.get();
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        List<Content> goodList = new ArrayList<>();
        for (Element el:elements) {
            String  img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String  price = el.getElementsByClass("p-price").eq(0).text();
            String  title = el.getElementsByClass("p-name").eq(0).text();
//            System.out.println("===============================================");
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(title);
            goodList.add(new Content(img,price,title));
        }
        return goodList;
    }


    public static void putHeaderMap(Connection connection,Map<String,String> map){
        map.forEach((k,v) ->{
            connection.header(k,v);
        });
    }
}
