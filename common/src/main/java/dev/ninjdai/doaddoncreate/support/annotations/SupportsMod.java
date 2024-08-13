package dev.ninjdai.doaddoncreate.support.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SupportsMod {
    String value();
}
