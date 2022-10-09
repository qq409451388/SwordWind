package com.poethan.swordwindserver;

import com.poethan.gear.core.Env;
import com.poethan.swordwindserver.handler.WebSocketServerHandler;
import com.poethan.swordwindserver.schdule.SchduleFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
public class SwordWindServer {
    public static void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch)
                                throws Exception {
                            // http 的解码器
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("http-codec",
                                    new HttpServerCodec());
                            //  负责将 Http 的一些信息例如版本
                            // 和 Http 的内容继承一个 FullHttpRequesst
                            pipeline.addLast("aggregator",
                                    new HttpObjectAggregator(65536));
                            // 大文件写入的类
                            ch.pipeline().addLast("http-chunked",
                                    new ChunkedWriteHandler());
                            // websocket 处理类
                            pipeline.addLast("handler",
                                    new WebSocketServerHandler());
                        }
                    });
            // 监听端口
            Channel ch = b.bind(Env.port).sync().channel();
            log.info("start ws://127.0.0.1:"+Env.port);
            afterStart();
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static void afterStart(){
        SchduleFactory.run();
    }
}