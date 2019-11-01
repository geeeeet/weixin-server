package pers.lrf.weixinserver.weixinbean.message.normal.submessage;

/**
 * 音乐消息子节点
 * @author lirufeng
 * @date 2019/11/01 下午 11:29
 */
public class MusicMessage {

    private String Title;

    private String Description;

    /**
     * 音乐链接
     */
    private String MusicUrl;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String HQMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String ThumbMediaId;
}
