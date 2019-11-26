package org.usac.amsspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.usac.amsspring.model.AmsSettings;
import org.usac.amsspring.provider.AmsNativeProvider;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class Application {

    public String AMS_VERSION = "";

    Logger logger;

    @Autowired
    private AmsSettings amsSettings;

    @Autowired
    private AmsNativeProvider amsNativeProvider;



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init(){

        logger = LoggerFactory.getLogger(Application.class);

        /* Setup the native AMS provider. */
        amsNativeProvider = new AmsNativeProvider(amsSettings);
        amsNativeProvider.load();
        amsNativeProvider.setup();

        AMS_VERSION = amsNativeProvider.getApiVersion();
    }


    @PreDestroy
    public void destroy() {
        System.out.println(
                "Callback triggered - @PreDestroy.");

        logger.info("Shutting down AMS application");
        if (amsNativeProvider != null && amsNativeProvider.shutDown()) {
            logger.info("Closed the AMS instance.");
        }
    }
}