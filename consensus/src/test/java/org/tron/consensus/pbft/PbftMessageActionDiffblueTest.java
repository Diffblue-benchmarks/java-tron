package org.tron.consensus.pbft;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.protos.Protocol;

public class PbftMessageActionDiffblueTest {
  /**
   * Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  public void testAction() {
    // Arrange
    PbftMessageAction pbftMessageAction = new PbftMessageAction();
    PbftMessage message = mock(PbftMessage.class);
    when(message.getPbftMessage()).thenReturn(Protocol.PBFTMessage.getDefaultInstance());
    when(message.getDataType()).thenReturn(Protocol.PBFTMessage.DataType.SRL);

    // Act
    pbftMessageAction.action(message, new ArrayList<>());

    // Assert that nothing has changed
    verify(message).getDataType();
    verify(message).getPbftMessage();
  }

  /**
   * Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  public void testAction2() {
    // Arrange
    PbftMessageAction pbftMessageAction = new PbftMessageAction();
    PbftMessage message = mock(PbftMessage.class);
    when(message.getPbftMessage()).thenReturn(null);
    when(message.getDataType()).thenReturn(Protocol.PBFTMessage.DataType.SRL);

    // Act
    pbftMessageAction.action(message, new ArrayList<>());

    // Assert that nothing has changed
    verify(message).getDataType();
    verify(message).getPbftMessage();
  }

  /**
   * Method under test: {@link PbftMessageAction#action(PbftMessage, List)}
   */
  @Test
  public void testAction3() {
    // Arrange
    PbftMessageAction pbftMessageAction = new PbftMessageAction();
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataType()).thenReturn(Protocol.PBFTMessage.DataType.UNRECOGNIZED);

    // Act
    pbftMessageAction.action(message, new ArrayList<>());

    // Assert that nothing has changed
    verify(message).getDataType();
  }
}
