package org.tron.consensus.pbft;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.ChainBaseManager;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTMessage;
import org.tron.protos.Protocol.PBFTMessage.DataType;

@RunWith(MockitoJUnitRunner.class)
public class PbftMessageActionDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @InjectMocks private PbftMessageAction pbftMessageAction;

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>Given {@link ByteString}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ByteString}.
   *   <li>Then calls {@link PbftMessage#getPbftMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_givenByteString_whenArrayListAddByteString_thenCallsGetPbftMessage() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getPbftMessage()).thenThrow(new RuntimeException());
    when(message.getDataType()).thenReturn(DataType.SRL);

    ArrayList<ByteString> dataSignList = new ArrayList<>();
    dataSignList.add(mock(ByteString.class));

    // Act
    pbftMessageAction.action(message, dataSignList);

    // Assert
    verify(message).getDataType();
    verify(message).getPbftMessage();
  }

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>Given {@link ByteString}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ByteString}.
   *   <li>Then calls {@link PbftMessage#getPbftMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_givenByteString_whenArrayListAddByteString_thenCallsGetPbftMessage2() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getPbftMessage()).thenThrow(new RuntimeException());
    when(message.getDataType()).thenReturn(DataType.SRL);

    ArrayList<ByteString> dataSignList = new ArrayList<>();
    dataSignList.add(mock(ByteString.class));
    dataSignList.add(mock(ByteString.class));

    // Act
    pbftMessageAction.action(message, dataSignList);

    // Assert
    verify(message).getDataType();
    verify(message).getPbftMessage();
  }

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>Given {@code SRL}.
   *   <li>Then calls {@link PbftMessage#getPbftMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_givenSrl_thenCallsGetPbftMessage() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getPbftMessage()).thenThrow(new RuntimeException());
    when(message.getDataType()).thenReturn(DataType.SRL);

    // Act
    pbftMessageAction.action(message, new ArrayList<>());

    // Assert
    verify(message).getDataType();
    verify(message).getPbftMessage();
  }

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>Given {@code UNRECOGNIZED}.
   *   <li>When {@link PbftMessage} {@link PbftMessage#getDataType()} return {@code UNRECOGNIZED}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_givenUnrecognized_whenPbftMessageGetDataTypeReturnUnrecognized() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataType()).thenReturn(DataType.UNRECOGNIZED);

    // Act
    pbftMessageAction.action(message, new ArrayList<>());

    // Assert
    verify(message).getDataType();
  }

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getCommonDataBase()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_thenCallsGetCommonDataBase() {
    // Arrange
    when(chainBaseManager.getCommonDataBase()).thenThrow(new RuntimeException());

    PbftMessage message = mock(PbftMessage.class);
    when(message.getNumber()).thenReturn(1L);
    when(message.getDataType()).thenReturn(DataType.BLOCK);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> pbftMessageAction.action(message, new ArrayList<>()));
    verify(message).getDataType();
    verify(message).getNumber();
    verify(chainBaseManager).getCommonDataBase();
  }

  /**
   * Test {@link PbftMessageAction#action(PbftMessage, List)}.
   *
   * <ul>
   *   <li>When {@link PbftMessage} {@link PbftMessage#getNumber()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageAction.action(PbftMessage, List)"})
  public void testAction_whenPbftMessageGetNumberThrowRuntimeException() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getNumber()).thenThrow(new RuntimeException());
    when(message.getDataType()).thenReturn(DataType.BLOCK);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> pbftMessageAction.action(message, new ArrayList<>()));
    verify(message).getDataType();
    verify(message).getNumber();
  }
}
