package com.blate.exposeannotation;

import com.blate.exposeannotation.annotation.ExposeService;

import java.util.Objects;
import java.util.ServiceLoader;

public class ServiceExposer {

    public static <T> T getService(Class<T> klass, String name) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(klass);
        for (T service : serviceLoader) {
            if (name == null || name.isEmpty()) {
                return service;
            } else {
                ExposeService exposeService = service.getClass().getAnnotation(ExposeService.class);
                if (exposeService != null) {
                    String serviceName = exposeService.name();
                    if (Objects.equals(name, serviceName)) {
                        return service;
                    }
                }
            }
        }
        return null;
    }

}