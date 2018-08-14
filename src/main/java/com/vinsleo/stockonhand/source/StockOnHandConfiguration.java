package com.vinsleo.stockonhand.source;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.MessageChannel;

@Configuration
public class StockOnHandConfiguration {
    @Bean
    @GlobalChannelInterceptor(patterns = Source.OUTPUT)
    public WireTap sftpSourceWireTap() {
        return new WireTap(sftpDataChannel());
    }

    @Bean
    public MessageChannel sftpDataChannel() {
        return new DirectChannel();
    }
}
