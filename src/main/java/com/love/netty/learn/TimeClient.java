package com.love.netty.learn;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by ls on 2018/11/12.
 */
public class TimeClient {

    public static void main(String[] args) throws Exception {

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // 1
            b.group(workerGroup); // 2
            b.channel(NioSocketChannel.class); // 3
            b.option(ChannelOption.SO_KEEPALIVE, true); // 4
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            // start the client
            ChannelFuture f = b.connect(host, port).sync();

            // wait until the connection is closed
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
        }


    }


}
