package com.blate.modulea;

import com.blate.exposeannotation.annotation.ExposeService;
import com.blate.sayhello.Sayhello;

/**
 * <p>
 *
 * @author Blate
 * Create on 2022/3/30
 */
@ExposeService(value = Sayhello.class)
public class SayhelloImplA implements Sayhello {

    @Override
    public String sayhello() {
        return String.format("Hello, I'm %s, from Module A", getClass().getSimpleName());
    }

}
