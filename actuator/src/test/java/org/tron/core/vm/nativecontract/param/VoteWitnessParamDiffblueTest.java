package org.tron.core.vm.nativecontract.param;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Vote;

public class VoteWitnessParamDiffblueTest {
  /**
   * Test {@link VoteWitnessParam#addVote(byte[], long)}.
   *
   * <p>Method under test: {@link VoteWitnessParam#addVote(byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VoteWitnessParam.addVote(byte[], long)"})
  public void testAddVote() throws UnsupportedEncodingException {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();

    // Act
    voteWitnessParam.addVote("AXAXAXAX".getBytes("UTF-8"), 1L);

    // Assert
    List<Vote> votes = voteWitnessParam.getVotes();
    assertEquals(1, votes.size());
    Vote getResult = votes.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(1L, getResult.getVoteCount());
    assertEquals(2, getResult.getAllFields().size());
    assertTrue(getResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link VoteWitnessParam#toJsonStr()}.
   *
   * <ul>
   *   <li>Given {@link VoteWitnessParam} (default constructor).
   *   <li>Then return {@code {"votes":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VoteWitnessParam.toJsonStr()"})
  public void testToJsonStr_givenVoteWitnessParam_thenReturnVotes() {
    // Arrange, Act and Assert
    assertEquals("{\"votes\":[]}", new VoteWitnessParam().toJsonStr());
  }

  /**
   * Test {@link VoteWitnessParam#toJsonStr()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VoteWitnessParam.toJsonStr()"})
  public void testToJsonStr_thenReturnAString() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 2L);
    voteWitnessParam.addVote(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1L);

    // Act and Assert
    assertEquals(
        "{\"votes\":[{\"vote_address\":\"2E9cagwdNSMutUg26\",\"vote_count\":2},{\"vote_address\":\"2E9cagwdNSMutUg26\","
            + "\"vote_count\":1}]}",
        voteWitnessParam.toJsonStr());
  }

  /**
   * Test {@link VoteWitnessParam#toJsonStr()}.
   *
   * <ul>
   *   <li>Then return {@code {"votes":[{"vote_address":"1K31XJSKv6Zgi64","vote_count":1}]}}.
   * </ul>
   *
   * <p>Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VoteWitnessParam.toJsonStr()"})
  public void testToJsonStr_thenReturnVotesVoteAddress1K31XJSKv6Zgi64VoteCount1() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[] {0, 1, 'A', 1, 'A', 1, 'A', 1}, 1L);

    // Act and Assert
    assertEquals(
        "{\"votes\":[{\"vote_address\":\"1K31XJSKv6Zgi64\",\"vote_count\":1}]}",
        voteWitnessParam.toJsonStr());
  }

  /**
   * Test {@link VoteWitnessParam#toJsonStr()}.
   *
   * <ul>
   *   <li>Then return {@code {"votes":[{"vote_address":"2E9cagwdNSMutUg26","vote_count":1}]}}.
   * </ul>
   *
   * <p>Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VoteWitnessParam.toJsonStr()"})
  public void testToJsonStr_thenReturnVotesVoteAddress2E9cagwdNSMutUg26VoteCount1() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1L);

    // Act and Assert
    assertEquals(
        "{\"votes\":[{\"vote_address\":\"2E9cagwdNSMutUg26\",\"vote_count\":1}]}",
        voteWitnessParam.toJsonStr());
  }

  /**
   * Test {@link VoteWitnessParam#toJsonStr()}.
   *
   * <ul>
   *   <li>Then return {@code {"votes":[{"vote_address":"3QJmnh","vote_count":1}]}}.
   * </ul>
   *
   * <p>Method under test: {@link VoteWitnessParam#toJsonStr()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VoteWitnessParam.toJsonStr()"})
  public void testToJsonStr_thenReturnVotesVoteAddress3QJmnhVoteCount1() {
    // Arrange
    VoteWitnessParam voteWitnessParam = new VoteWitnessParam();
    voteWitnessParam.addVote(new byte[] {}, 1L);

    // Act and Assert
    assertEquals(
        "{\"votes\":[{\"vote_address\":\"3QJmnh\",\"vote_count\":1}]}",
        voteWitnessParam.toJsonStr());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VoteWitnessParam}
   *   <li>{@link VoteWitnessParam#setVoterAddress(byte[])}
   *   <li>{@link VoteWitnessParam#getVoterAddress()}
   *   <li>{@link VoteWitnessParam#getVotes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VoteWitnessParam.<init>()",
    "byte[] VoteWitnessParam.getVoterAddress()",
    "List VoteWitnessParam.getVotes()",
    "void VoteWitnessParam.setVoterAddress(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    VoteWitnessParam actualVoteWitnessParam = new VoteWitnessParam();
    byte[] voterAddress = "AXAXAXAX".getBytes("UTF-8");
    actualVoteWitnessParam.setVoterAddress(voterAddress);
    byte[] actualVoterAddress = actualVoteWitnessParam.getVoterAddress();

    // Assert
    assertTrue(actualVoteWitnessParam.getVotes().isEmpty());
    assertSame(voterAddress, actualVoterAddress);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualVoterAddress);
  }
}
