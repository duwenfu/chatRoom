package com.du.chat.service.impl;

import com.du.chat.chat.ChatServerInitialize;
import com.du.chat.service.ChatServerService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/11/13 11:40
 */
@Service
public class ChatServerServiceImpl implements ChatServerService {

    @Value("${netty.tcp.server.port}")
    private int port;

    @Override
    public void chatOnLineServer(){
        start();
    }

    private void start(){
        //配置服务端的NIO线程组
        //实际上EventLoopGroup就是Reactor线程组
        //两个Reactor一个用于服务端接收客户端的连接，另一个用于进行SocketChannel的网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //ServerBootstrap对象是Netty用于启动NIO服务端的辅助启动类，目的是降低服务端开发的复杂度
            ServerBootstrap bootstrap = new ServerBootstrap();
            //Set the EventLoopGroup for the parent (acceptor) and the child (client).
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    //回调请求
                    .childHandler(new ChatServerInitialize())
                    //.localAddress(new InetSocketAddress(port))
                    //配置NioServerSocketChannel的TCP参数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.SO_KEEPALIVE,true);

            //绑定监听端口，调用sync同步阻塞方法等待绑定操作完成，完成后返回ChannelFuture类似于JDK中Future
            ChannelFuture future = bootstrap.bind(port).sync();

            System.out.println("服务器启动：");
            //使用sync方法进行阻塞，等待服务端链路关闭之后Main函数才退出
            future.channel().closeFuture().sync();
            System.out.println("服务器关闭：");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //优雅退出，释放线程池资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
