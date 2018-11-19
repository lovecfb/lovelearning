package com.love.netty.learn;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by ls on 2018/11/12.
 */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(); // 1
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap(); // 2
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 3
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 4

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128) // 5
                    .childOption(ChannelOption.SO_KEEPALIVE, true); //6

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync();

            // wait until the server socket is closed
            // In this example,this doesn't happen,but you can do that to gracefully
            // shutdown your server
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        int port = 8088;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new DiscardServer(port).run();
    }


}
