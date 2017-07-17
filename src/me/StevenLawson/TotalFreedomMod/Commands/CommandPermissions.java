package me.StevenLawson.TotalFreedomMod.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandPermissions
{
    AdminLevel level();

   SupporterLevel dlevel() default SupporterLevel.NONE;
    
    SourceType source();

    boolean blockHostConsole() default false;
}
