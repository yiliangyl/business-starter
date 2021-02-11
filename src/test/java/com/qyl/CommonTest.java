package com.qyl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiErrorCodeDictionary;
import com.power.doc.model.ApiReqHeader;
import com.qyl.enums.ResponseEnum;
import com.qyl.utils.ResponseEntity;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @Author: qyl
 * @Date: 2021/2/9 19:31
 * @Description:
 */
public class CommonTest {

//    private static final String salt = "!q@w#e$r";
//
//    @Test
//    public void generateToken() {
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.SECOND, 5 * 60);
//
//        String token = JWT.create()
//                // .withHeader() header 建议使用默认的即可
//                .withClaim("userId", "25")  // payload
//                .withClaim("username", "admin")
//                .withExpiresAt(instance.getTime())  // 指定token过期时间
//                .sign(Algorithm.HMAC256(salt));  // 签名，其中算法中的字符串为自定义的盐值（不能泄露）
//
//        System.out.println(token);
//    }
//
//    @Test
//    public void checkToken() {
//        // 创建对象
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(salt)).build();
//        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTI4NzI3MjAsInVzZXJJZCI6IjI1IiwidXNlcm5hbWUiOiJhZG1pbiJ9.qzSQU0fClxSFJ0racsfT5N67kkaQqNEIDG_99WLjkZY");
//
//        System.out.println(verify.getClaim("userId").asString());
//        System.out.println(verify.getClaim("username").asString());
//    }

    @Test
    public void buildApiDoc() {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://localhost:9090");

        // 设置为严格模式，Smart-doc将降至要求每个Controller暴露的接口写上标准文档注释
        config.setStrict(true);

        // 当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);

        // HTML5文档，建议直接放到src/main/resources/static/doc下，Smart-doc提供一个配置常量HTML_DOC_OUT_PATH
        config.setOutPath(DocGlobalConstants.HTML_DOC_OUT_PATH);

        // 设置接口包扫描路径过滤，如果不配置则Smart-doc默认扫描所有的接口类
        // 配置多个包名用英文逗号隔开
        config.setPackageFilters("com.qyl.controller");

        // 设置公共请求头.如果不需要请求头，则无需设置
        config.setRequestHeaders(
                ApiReqHeader.header().setName("token").setType("string")
                        .setDesc("Basic auth credentials").setRequired(true)
        );

        // 1.7.9 优化了错误码处理，用于下面替代遍历枚举设置错误码
        config.setErrorCodeDictionaries(
                ApiErrorCodeDictionary.dict().setEnumClass(ResponseEnum.class)
                        .setCodeField("code")  // 错误码值字段名
                        .setDescField("msg") // 错误码描述
        );

        // 生成html
        HtmlApiDocBuilder.buildApiDoc(config);
    }
}
