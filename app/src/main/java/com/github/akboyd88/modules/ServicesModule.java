package com.github.akboyd88.modules;

import com.github.akboyd88.services.EchoService;
import com.github.akboyd88.services.EchoServiceImpl;
import com.github.akboyd88.services.MultipleServiceImpl;
import com.github.akboyd88.services.MultiplyService;
import dagger.Binds;
import dagger.Module;

@Module
public interface ServicesModule {

    @Binds
    EchoService bindsEchoService(EchoServiceImpl echoService);

    @Binds
    MultiplyService bindsMultiplyService(MultipleServiceImpl multiplyService);
}
