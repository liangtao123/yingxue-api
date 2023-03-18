package com.teligen.gateway.filter.factory;

import com.teligen.constants.RedisPrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author liangtao
 * @date 2023-03-18 15:50
 * @desc: 自定义处理token身份安全认证的工厂类
 */
@Component //代表在工厂中创建对象
@Slf4j
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {
    public static final String REQUIRED_KEY = "requriedToken";
    private RedisTemplate redisTemplate;

    @Autowired
    public TokenGatewayFilterFactory(RedisTemplate redisTemplate) {
        super(Config.class);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            //Springwebflux模型
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("config requried token:{}",config.requriedToken);
                if(config.requriedToken) {

                    if(exchange.getRequest().getQueryParams().get("token")== null) {
                        throw new RuntimeException("非法令牌，没有传入令牌");
                    }

                    //1.获取token信息
                    String token = exchange.getRequest().getQueryParams().get("token").get(0);

                    //2.打印token
                    log.info("接收到token:{}", token);

                    //3.到redis来查看token是否存在
                    if (!redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token)) {
                        throw new RuntimeException("不合法的令牌,redis中不存在相关令牌");
                    }
                }
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(REQUIRED_KEY);
    }

    public static class Config {
        private boolean requriedToken=false;

        public boolean isRequriedToken() {
            return requriedToken;
        }

        public void setRequriedToken(boolean requriedToken) {
            this.requriedToken = requriedToken;
        }
    }


}
