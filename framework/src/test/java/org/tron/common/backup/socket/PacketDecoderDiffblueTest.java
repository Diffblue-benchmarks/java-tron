package org.tron.common.backup.socket;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;

public class PacketDecoderDiffblueTest {
  /**
   * Test {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)} with {@code ChannelHandlerContext}, {@code DatagramPacket}, {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PacketDecoder.decode(ChannelHandlerContext, DatagramPacket, List)"})
  public void testDecodeWithChannelHandlerContextDatagramPacketList_given42_whenArrayListAdd42() throws Exception {
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
   * Test {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)} with {@code ChannelHandlerContext}, {@code DatagramPacket}, {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PacketDecoder.decode(ChannelHandlerContext, DatagramPacket, List)"})
  public void testDecodeWithChannelHandlerContextDatagramPacketList_given42_whenArrayListAdd422() throws Exception {
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
   * Test {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)} with {@code ChannelHandlerContext}, {@code DatagramPacket}, {@code List}.
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PacketDecoder#decode(ChannelHandlerContext, DatagramPacket, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PacketDecoder.decode(ChannelHandlerContext, DatagramPacket, List)"})
  public void testDecodeWithChannelHandlerContextDatagramPacketList_thenCallsChannel() throws Exception {
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
   * Test new {@link PacketDecoder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PacketDecoder}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PacketDecoder.<init>()"})
  public void testNewPacketDecoder() {
    // Arrange, Act and Assert
    assertFalse((new PacketDecoder()).isSharable());
  }
}
