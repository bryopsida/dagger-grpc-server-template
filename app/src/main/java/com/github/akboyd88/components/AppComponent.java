package com.github.akboyd88.components;

import com.github.akboyd88.modules.ServicesModule;
import com.github.akboyd88.server.App;
import dagger.Component;

@Component(modules = ServicesModule.class)
public interface AppComponent {
    App app();
}