package com.vinsleo.stockonhand.source;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.app.sftp.source.SftpSourceConfiguration;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
@ImportAutoConfiguration(SftpSourceConfiguration.class)
public class StockOnHandSftpSource {
    private final Log log = LogFactory.getLog(getClass());


    @StreamListener(Source.OUTPUT)
    public void process(String eventLine) {
        this.log.info("Received line : " + eventLine);
    }



}