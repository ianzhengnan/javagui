package com.ian.io.nio2;

import java.nio.file.*;

public class WatchServiceTest {

    public static void main(String[] args) throws Exception{

        WatchService watchService = FileSystems.getDefault().newWatchService();

        Paths.get("c:", "Users","i076453").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        while(true){
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()){
                System.out.println(event.context() + " 文件发生了 "
                    + event.kind() + " 事件");
            }

            // 重设WatchKey
            boolean valid = key.reset();
            if(!valid){
                break;
            }
        }

    }
}
