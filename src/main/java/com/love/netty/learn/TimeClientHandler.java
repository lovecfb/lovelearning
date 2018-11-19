package com.love.netty.learn;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by ls on 2018/11/12.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf buf;

    // 1 A ChannelHandler has two life cycle listener methods: handlerAdded() and handlerRemoved().
    // You can perform an arbitrary (de)initialization task as long as it does not block for a long time.


    // 3 And then, the handler must check if buf has enough data, 4 bytes in this example,
    // and proceed to the actual business logic. Otherwise, Netty will call the channelRead() method again when more data arrives,
    // and eventually all 4 bytes will be cumulated.


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        buf = ctx.alloc().buffer(4); // 1
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release(); // 1
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg; // 2  First, all received data should be cumulated into buf.
        buf.writeBytes(m);
        m.release();

        if (buf.readableBytes() >= 4) { // 3
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        } finally {
//            m.release();
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
