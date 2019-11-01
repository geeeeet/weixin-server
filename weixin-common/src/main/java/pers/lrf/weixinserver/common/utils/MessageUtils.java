package pers.lrf.weixinserver.common.utils;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lirufeng
 * @date 2019/10/15 14:37
 **/
public class MessageUtils {

    /**
     * xml消息转换为map对象
     * @param message     消息
     * @return            返回map对象
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String message) throws Exception {
        Map<String, String> map = new HashMap<>();
        org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(message);
        Element root = doc.getRootElement();//得到根节点
        List<Element> list = root.elements();//根节点下的所有的节点
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /**
     * 实体类转为xml消息
     * @param message  实体类
     * @return         xml字符串
     */
    public static String objectToXml(Object message) {
        XStream xStream = new XStream();
        xStream.alias("xml", message.getClass());
        return xStream.toXML(message)
                .replace("&lt;","<")
                .replace("&gt;",">");
    }

    /**
     * 生成xml消息
     * @param toUserName    消息接受方
     * @param fromUserName  消息发送方
     * @param createTime    消息创建时间
     * @param msgType       消息类型
     * @param content       发送的内容
     * @param msgId         消息ID
     * @return              xml消息字符串
     */
    public static String generateXml(String toUserName, String fromUserName,
                                      String createTime, String msgType,String content,String msgId) {
        String format = "<xml>\n" + "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
                + "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
                + "<CreateTime>%3$s</CreateTime>\n" + "<MsgType><![CDATA[%4$s]]></MsgType>\n"
                + "<Content><![CDATA[%5$s]]></Content>\n"
                + "<MsgId><%6$s</MsgId>\n"
                + "</xml>";
        return String.format(format, toUserName, fromUserName, createTime, msgType,content,msgId);
    }
}
