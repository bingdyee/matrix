package org.warless.incubator.simplefeign.framework;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import org.springframework.web.client.RestTemplate;
import org.warless.incubator.simplefeign.annotations.FeignBody;
import org.warless.incubator.simplefeign.annotations.FeignClient;
import org.warless.incubator.simplefeign.annotations.FeignRequest;
import org.warless.incubator.simplefeign.utils.CommonUtils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yubb
 * @date : 2019-08-17
 */
public class FeignClientInvoker implements InvocationHandler {

    private static final int MIN_LEN = 2;

    private RestTemplate restTemplate;

    public FeignClientInvoker() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = method.getDeclaringClass();
        FeignClient feignClient = (FeignClient)clazz.getAnnotation(FeignClient.class);
        if (method.isAnnotationPresent(FeignRequest.class)) {
            FeignRequest feignRequest = method.getAnnotation(FeignRequest.class);
            String url = feignClient.value() + feignRequest.value();
            JSONObject param = parseParams(method, args);
            JSONObject response;
            switch (feignRequest.method()) {
                case GET:
                    response = restTemplate.getForEntity(url, JSONObject.class, param.getInnerMap()).getBody();
                    break;
                case POST:
                    response = restTemplate.postForEntity(url, param, JSONObject.class).getBody();
                    break;
                case PUT:
                    response = null;
                    break;
                case DELETE:
                    response = null;
                    break;
                default:
                    throw new RuntimeException("");
            }
            return response != null ? parseResponse(response, method) : null;
        }
        return null;
    }

    private JSONObject parseParams(Method method, Object[] args) {
        JSONObject params = new JSONObject();
        if (CommonUtils.isNotEmpty(args)) {
            Parameter[] parameters = method.getParameters();
            if (parameters[0].isAnnotationPresent(FeignBody.class)) {
                params = (JSONObject) JSONObject.toJSON(args[0]);
            } else {
                for (int i = 0; i < args.length; ++i) {
                    if (args[i] != null) {
                        params.put(parameters[i].getName(), args[i]);
                    }
                }
            }
        }
        return params;
    }

    private Object parseResponse(JSONObject response, Method method) {
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            Type returnGenericType = getReturnType(getTypes(returnType, new ArrayList<>()));
            if (method.getReturnType().equals(List.class)) {
                return response.getObject("data", returnGenericType);
            }
            return JSON.parseObject(JSONObject.toJSONString(response), returnGenericType);
        }
        return response.getObject("data", returnType);
    }

    private List<Type> getTypes(Type type, List<Type> types) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            types.add(rawType);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type t : actualTypeArguments) {
                getTypes(t, types);
            }
        } else {
            types.add(type);
        }
        return types;
    }

    private Type getReturnType(List<Type> types) {
        Type result = types.get(types.size() - 1);
        for (int i = types.size() - MIN_LEN; i >= 0; --i) {
            result = new ParameterizedTypeImpl(new Type[]{result}, null, types.get(i));
        }
        return result;
    }
}
