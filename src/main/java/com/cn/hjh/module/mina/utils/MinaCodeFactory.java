package com.cn.hjh.module.mina.utils;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

/**
 * 解码和编码的类
 * Created by yourdady on 2016/5/11.
 */
public class MinaCodeFactory implements ProtocolCodecFactory {
	TextLineCodecFactory lineCodec;
	
	public MinaCodeFactory(){
		 lineCodec = new TextLineCodecFactory(Charset
	              .forName("UTF-8"));
	}

    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return lineCodec.getEncoder(ioSession);
    }

    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return lineCodec.getDecoder(ioSession);

    }
}
