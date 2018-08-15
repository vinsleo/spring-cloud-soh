package com.vinsleo.stockonhand.source;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.app.sftp.source.SftpSourceConfiguration;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StockOnHandSftpSource.CustomSource.class)
public class StockOnHandSftpSource {
    private final Log log = LogFactory.getLog(getClass());


    @StreamListener(CustomSource.STOCK_ON_HAND_RAW)
    public void process(String eventLine) {
        this.log.info("Received line : " + eventLine);
    }


    public interface CustomSource {
        String STOCK_ON_HAND_RAW = "stock-on-hand-raw";

        @Input(STOCK_ON_HAND_RAW)
        MessageChannel stockOnHandRaw();
    }
}