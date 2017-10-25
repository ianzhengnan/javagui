package com.ian.network;

public class MutiThreadDown {

    public static void main(String[] args) throws Exception{

        final DownUtil downUtil = new DownUtil("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2770691011,100164542&fm=27&gp=0.jpg",
                "test.jpg", 4);

        downUtil.download();
        new Thread(() -> {
            while(downUtil.getCompleteRate() < 1){
                // 每隔0.1秒查询一次任务的进度
                // gui程序可以通过进度条实现
                System.out.println("已完成：" + downUtil.getCompleteRate());
                try{
                    Thread.sleep(1000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
