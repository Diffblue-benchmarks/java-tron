package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class VoteWitnessParamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VoteWitnessParam}
   *   <li>{@link VoteWitnessParam#setVoterAddress(byte[])}
   *   <li>{@link VoteWitnessParam#getVoterAddress()}
   *   <li>{@link VoteWitnessParam#getVotes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    VoteWitnessParam actualVoteWitnessParam = new VoteWitnessParam();
    byte[] voterAddress = "AXAXAXAX".getBytes("UTF-8");
    actualVoteWitnessParam.setVoterAddress(voterAddress);
    byte[] actualVoterAddress = actualVoteWitnessParam.getVoterAddress();

    // Assert that nothing has changed
    assertTrue(actualVoteWitnessParam.getVotes().isEmpty());
    assertSame(voterAddress, actualVoterAddress);
  }

  /**
   * Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  public void testToJsonStr() {
    // Arrange, Act and Assert
    assertEquals("{\"votes\":[]}", (new VoteWitnessParam()).toJsonStr());
  }

  /**
   * Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  public void testToJsonStr2() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1L);

    // Act and Assert
    assertEquals("{\"votes\":[{\"vote_address\":\"2E9cagwdNSMutUg26\",\"vote_count\":1}]}",
        voteWitnessParam.toJsonStr());
  }

  /**
   * Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  public void testToJsonStr3() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[]{0, 1, 'A', 1, 'A', 1, 'A', 1}, 1L);

    // Act and Assert
    assertEquals("{\"votes\":[{\"vote_address\":\"1K31XJSKv6Zgi64\",\"vote_count\":1}]}", voteWitnessParam.toJsonStr());
  }

  /**
   * Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  public void testToJsonStr4() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[]{}, 1L);

    // Act and Assert
    assertEquals("{\"votes\":[{\"vote_address\":\"3QJmnh\",\"vote_count\":1}]}", voteWitnessParam.toJsonStr());
  }
}
