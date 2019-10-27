package pers.lrf.weixinserver.common.exception;

import pers.lrf.weixinserver.common.constant.WxConstant;

import java.lang.reflect.Field;

/**
 * 微信全局返回码所对应的解释
 * 是指由于请求导致的异常（造成的原因）
 *
 * @author lirufeng
 * @date 2019/10/17 14:48
 **/
public class CodeMeans {

    /**
     * 这里是-1，符号"-"没法用在变量中，用下划线"_"代替
     */
    public static final String code__1 = "系统繁忙，此时请开发者稍候再试!";
    public static final String code_0 = "请求成功!";
    public static final String code_40001 = "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口!";
    public static final String code_40002 = "不合法的凭证类型!";
    public static final String code_40003 = "不合法的 OpenID ，请确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID!";
    public static final String code_40004 = "不合法的媒体文件类型!";
    public static final String code_40005 = "不合法的文件类型!";
    public static final String code_40006 = "不合法的文件大小!";
    public static final String code_40007 = "不合法的媒体文件 id!";
    public static final String code_40008 = "不合法的消息类型!";
    public static final String code_40009 = "不合法的图片文件大小!";
    public static final String code_40010 = "不合法的语音文件大小!";
    public static final String code_40011 = "不合法的视频文件大小!";
    public static final String code_40012 = "不合法的缩略图文件大小!";
    public static final String code_40013 = "不合法的 AppID ，请检查 AppID 的正确性，避免异常字符，注意大小写!";
    public static final String code_40014 = "不合法的 access_token ，请认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口!";
    public static final String code_40015 = "不合法的菜单类型!";
    public static final String code_40016 = "不合法的按钮个数!";
    public static final String code_40017 = "不合法的按钮个数!";
    public static final String code_40018 = "不合法的按钮名字长度!";
    public static final String code_40019 = "不合法的按钮 KEY 长度!";
    public static final String code_40020 = "不合法的按钮 URL 长度!";
    public static final String code_40021 = "不合法的菜单版本号!";
    public static final String code_40022 = "不合法的子菜单级数!";
    public static final String code_40023 = "不合法的子菜单按钮个数!";
    public static final String code_40024 = "不合法的子菜单按钮类型!";
    public static final String code_40025 = "不合法的子菜单按钮名字长度!";
    public static final String code_40026 = "不合法的子菜单按钮 KEY 长度!";
    public static final String code_40027 = "不合法的子菜单按钮 URL 长度!";
    public static final String code_40028 = "不合法的自定义菜单使用用户!";
    public static final String code_40029 = "无效的 oauth_code!";
    public static final String code_40030 = "不合法的 refresh_token!";
    public static final String code_40031 = "不合法的 openid 列表!";
    public static final String code_40032 = "不合法的 openid 列表长度!";
    public static final String code_40033 = "不合法的请求字符，不能包含 \\uxxxx 格式的字符!";
    public static final String code_40035 = "不合法的参数!";
    public static final String code_40038 = "不合法的请求格式!";
    public static final String code_40039 = "不合法的 URL 长度!";

    public static final String code_40048 = "无效的url!";
    public static final String code_40050 = "不合法的分组 id!";
    public static final String code_40051 = "分组名字不合法!";
    public static final String code_40060 = "删除单篇图文时，指定的 article_idx 不合法!";
    public static final String code_40117 = "分组名字不合法!";
    public static final String code_40118 = "media_id 大小不合法!";
    public static final String code_40119 = "button 类型错误!";
    public static final String code_40120 = "button 类型错误!";
    public static final String code_40121 = "不合法的 media_id 类型!";
    public static final String code_40125 = "无效的appsecret!";
    public static final String code_40132 = "微信号不合法!";
    public static final String code_40137 = "不支持的图片格式!";
    public static final String code_40155 = "请勿添加其他公众号的主页链接!";
    public static final String code_40163 = "oauth_code已使用!";
    public static final String code_41001 = "缺少 access_token 参数!";
    public static final String code_41002 = "缺少 appid 参数!";
    public static final String code_41003 = "缺少 refresh_token 参数!";
    public static final String code_41004 = "缺少 secret 参数!";
    public static final String code_41005 = "缺少多媒体文件数据!";
    public static final String code_41006 = "缺少 media_id 参数!";
    public static final String code_41007 = "缺少子菜单数据!";
    public static final String code_41008 = "缺少 oauth code!";
    public static final String code_41009 = "缺少 openid!";
    public static final String code_42001 = "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明!";
    public static final String code_42002 = "refresh_token 超时!";
    public static final String code_42003 = "oauth_code 超时!";
    public static final String code_42007 = "用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权!";
    public static final String code_43001 = "需要 GET 请求!";
    public static final String code_43002 = "需要 POST 请求!";
    public static final String code_43003 = "需要 HTTPS 请求!";
    public static final String code_43004 = "需要接收者关注!";
    public static final String code_43005 = "需要好友关系!";
    public static final String code_43019 ="需要将接收者从黑名单中移除";
    public static final String code_44001 ="多媒体文件为空";
    public static final String code_44002 ="POST的数据包为空";
    public static final String code_44003 ="图文消息内容为空";
    public static final String code_44004 ="文本消息内容为空";
    public static final String code_45001 ="多媒体文件大小超过限制";
    public static final String code_45002 ="消息内容超过限制";
    public static final String code_45003 ="标题字段超过限制";
    public static final String code_45004 ="描述字段超过限制";
    public static final String code_45005 ="链接字段超过限制";
    public static final String code_45006 ="图片链接字段超过限制";
    public static final String code_45007 ="语音播放时间超过限制";
    public static final String code_45008 ="图文消息超过限制";
    public static final String code_45009 ="接口调用超过限制";
    public static final String code_45010 ="创建菜单个数超过限制";
    public static final String code_45011 ="API调用太频繁，请稍候再试";
    public static final String code_45015 ="回复时间超过限制";
    public static final String code_45016 ="系统分组，不允许修改!";
    public static final String code_45017 ="分组名字过长!";
    public static final String code_45018 ="分组数量超过上限!";
    public static final String code_45047 ="客服接口下行条数超过上限!";
    public static final String code_45064 ="创建菜单包含未关联的小程序!";
    public static final String code_45065 ="相同clientmsgid已存在群发记录，返回数据中带有已存在的群发任务的msgid!";
    public static final String code_45066 ="相同clientmsgid重试速度过快，请间隔1分钟重试!";
    public static final String code_45067 ="clientmsgid长度超过限制!";
    public static final String code_46001 ="不存在媒体数据!";
    public static final String code_46002 ="不存在的菜单版本!";
    public static final String code_46003 ="不存在的菜单数据!";
    public static final String code_46004 ="不存在的用户!";
    public static final String code_47001 ="解析JSON/XML内容错误!";
    public static final String code_48001 ="api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限!";
    public static final String code_48002 ="粉丝拒收消息（粉丝在公众号选项中，关闭了“接收消息”）!";
    public static final String code_48004 ="api接口被封禁，请登录mp.weixin.qq.com查看详情!";
    public static final String code_48005 ="api禁止删除被自动回复和自定义菜单引用的素材!";
    public static final String code_48006 ="api禁止清零调用次数，因为清零次数达到上限!";
    public static final String code_48008 ="没有该类型消息的发送权限!";
    public static final String code_50001 ="用户未授权该api!";
    public static final String code_50002 ="用户受限，可能是违规后接口被封禁!";
    public static final String code_50005 ="用户未关注公众号!";
    public static final String code_61451 ="参数错误(invalidparameter)!";
    public static final String code_61452 ="无效客服账号(invalidkf_account)!";
    public static final String code_61453 ="客服帐号已存在(kf_accountexsited)!";
    public static final String code_61454 ="客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalidkf_acountlength)!";
    public static final String code_61455 ="客服帐号名包含非法字符(仅允许英文+数字)(illegalcharacterinkf_account)!";
    public static final String code_61456 ="客服帐号个数超过限制(10个客服账号)(kf_accountcountexceeded!";
    public static final String code_61457 ="无效头像文件类型(invalidfiletype)!";
    public static final String code_61450 ="系统错误(systemerror)!";
    public static final String code_61500 ="日期格式错误!";
    public static final String code_63001 ="部分参数为空!";
    public static final String code_63002 ="无效的签名!";
    public static final String code_65301 ="不存在此menuid对应的个性化菜单!";
    public static final String code_65302 ="没有相应的用户!";
    public static final String code_65303 ="没有默认菜单，不能创建个性化菜单!";
    public static final String code_65304 ="MatchRule信息为空!";
    public static final String code_65305 ="个性化菜单数量受限!";
    public static final String code_65306 ="不支持个性化菜单的帐号!";
    public static final String code_65307 ="个性化菜单信息为空!";
    public static final String code_65308 ="包含没有响应类型的button!";
    public static final String code_65309 ="个性化菜单开关处于关闭状态!";
    public static final String code_65310 ="填写了省份或城市信息，国家信息不能为空!";
    public static final String code_65311 ="填写了城市信息，省份信息不能为空!";
    public static final String code_65312 ="不合法的国家信息!";
    public static final String code_65313 ="不合法的省份信息!";
    public static final String code_65314 ="不合法的城市信息!";
    public static final String code_65316 ="该公众号的菜单设置了过多的域名外跳（最多跳转到3个域名的链接）!";
    public static final String code_65317 ="不合法的URL!";
    public static final String code_87009 ="无效的签名!";
    public static final String code_9001001	="POST数据参数不合法!";
    public static final String code_9001002	="远端服务不可用!";
    public static final String code_9001003	="Ticket不合法!";
    public static final String code_9001004	="获取摇周边用户信息失败!";
    public static final String code_9001005	="获取商户信息失败!";
    public static final String code_9001006	="获取OpenID失败!";
    public static final String code_9001007	="上传文件缺失!";
    public static final String code_9001008	="上传素材的文件类型不合法!";
    public static final String code_9001009	="上传素材的文件尺寸不合法!";
    public static final String code_9001010	="上传失败!";
    public static final String code_9001020	="帐号不合法!";
    public static final String code_9001021	="已有设备激活率低于50%，不能新增设备!";
    public static final String code_9001022	="设备申请数不合法，必须为大于0的数字!";
    public static final String code_9001023	="已存在审核中的设备ID申请!";
    public static final String code_9001024	="一次查询设备ID数量不能超过50!";
    public static final String code_9001025	="设备ID不合法!";
    public static final String code_9001026	="页面ID不合法!";
    public static final String code_9001027	="页面参数不合法!";
    public static final String code_9001028	="一次删除页面ID数量不能超过10!";
    public static final String code_9001029	="页面已应用在设备中，请先解除应用关系再删除!";
    public static final String code_9001030	="一次查询页面ID数量不能超过50!";
    public static final String code_9001031	="时间区间不合法!";
    public static final String code_9001032	="保存设备与页面的绑定关系参数错误!";
    public static final String code_9001033	="门店ID不合法!";
    public static final String code_9001034	="设备备注信息过长!";
    public static final String code_9001035	="设备申请参数不合法!";
    public static final String code_9001036	="查询起始值begin不合法!";

    /**
     * 通过返回码直接转换成对应的异常解释
     * @param code 异常码
     * @return     异常解释字符串
     */
    public static String getExceptionOfCode(String code) {
        String s = null;
        try {
            String code1 = WxConstant.code_+code;
            CodeMeans codeMeans = CodeMeans.class.newInstance();
            Class codeClass = codeMeans.getClass();
            Field field = codeClass.getDeclaredField(code1);
            field.setAccessible(true);
            s = (String) field.get(codeMeans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
