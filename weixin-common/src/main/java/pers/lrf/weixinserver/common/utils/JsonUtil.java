package pers.lrf.weixinserver.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("rawtypes")
public class JsonUtil {

    private final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static String beanToJson(Object bean) throws JsonProcessingException {
        return mapper.writeValueAsString(bean);
    }

    public static String beanToJsonPretty(Object bean) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
    }

    public static <T> T jsonToBean(String json, Class<T> type) throws IOException, JsonParseException, JsonMappingException {
        return mapper.readValue(json, type);
    }

    public static <T> T jsonToBean(String json, Class<T> type, String path) throws IOException, JsonParseException, JsonMappingException {
        JsonNode node = mapper.readTree(json);
        String pathText = node.findValue(path).toString();
        return mapper.readValue(pathText, type);
    }


    public static <T> T jsonToBean(String json, TypeReference type, String path) throws IOException, JsonParseException, JsonMappingException {
        JsonNode node = mapper.readTree(json);
        String pathText = node.findValue(path).toString();
        return mapper.readValue(pathText, type);
    }

    public static <T> T jsonToBean(String json, TypeReference type) throws IOException, JsonParseException, JsonMappingException {
        return mapper.readValue(json, type);
    }

    public static <T> List<T> jsonToBeans(String json, Class<T> type, String path) throws IOException, JsonParseException, JsonMappingException {
        JavaType javaType = getCollectionType(List.class, type);
        JsonNode node = mapper.readTree(json);
        if (path != null) {
            json = node.findValue(path).toString();
        }
        return mapper.readValue(json, javaType);
    }

    /**
     * 集合类型
     *
     * @param collectionClass
     * @param elementClasses
     * @return
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
