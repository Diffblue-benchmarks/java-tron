package org.tron.common.backup.socket;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.socket.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PacketDecoderDiffblueTest {
  /**
   * Method under test:
   * {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  public void testDecode() throws Exception {
    // Arrange
    PacketDecoder packetDecoder = new PacketDecoder();
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    DuplicatedByteBuf data = new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    DatagramPacket packet = new DatagramPacket(data, InetSocketAddress.createUnresolved("foo", 1));

    // Act
    packetDecoder.decode(ctx, packet, new ArrayList<>());

    // Assert
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  public void testDecode2() throws Exception {
    // Arrange
    PacketDecoder packetDecoder = new PacketDecoder();
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    DuplicatedByteBuf data = new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    DatagramPacket packet = new DatagramPacket(data, InetSocketAddress.createUnresolved("foo", 1));

    ArrayList<Object> out = new ArrayList<>();
    out.add("42");

    // Act
    packetDecoder.decode(ctx, packet, out);

    // Assert
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  public void testDecode3() throws Exception {
    // Arrange
    PacketDecoder packetDecoder = new PacketDecoder();
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    DuplicatedByteBuf data = new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    DatagramPacket packet = new DatagramPacket(data, InetSocketAddress.createUnresolved("foo", 1));

    ArrayList<Object> out = new ArrayList<>();
    out.add("42");
    out.add("42");

    // Act
    packetDecoder.decode(ctx, packet, out);

    // Assert
    verify(ctx).channel();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PacketDecoder}
   */
  @Test
  public void testNewPacketDecoder() {
    // Arrange, Act and Assert
    assertFalse((new PacketDecoder()).isSharable());
  }
}
