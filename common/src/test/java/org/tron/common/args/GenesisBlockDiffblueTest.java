package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GenesisBlockDiffblueTest {
  /**
   * Method under test: {@link GenesisBlock#getDefault()}
   */
  @Test
  public void testGetDefault() {
    // Arrange and Act
    GenesisBlock actualDefault = GenesisBlock.getDefault();

    // Assert
    List<Account> assets = actualDefault.getAssets();
    assertTrue(assets.isEmpty());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getNumber());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getParentHash());
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualDefault.getTimestamp());
    assertSame(assets, actualDefault.getWitnesses());
  }

  /**
   * Method under test: {@link GenesisBlock#setAssets(List)}
   */
  @Test
  public void testSetAssets() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    ArrayList<Account> assets = new ArrayList<>();

    // Act
    genesisBlock.setAssets(assets);

    // Assert
    assertSame(assets, genesisBlock.getAssets());
  }

  /**
   * Method under test: {@link GenesisBlock#setAssets(List)}
   */
  @Test
  public void testSetAssets2() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("ASSETISSUE");

    ArrayList<Account> assets = new ArrayList<>();
    assets.add(account);

    // Act
    genesisBlock.setAssets(assets);

    // Assert
    assertSame(assets, genesisBlock.getAssets());
  }

  /**
   * Method under test: {@link GenesisBlock#setAssets(List)}
   */
  @Test
  public void testSetAssets3() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("ASSETISSUE");

    Account account2 = new Account();
    account2.setAccountName("Mr John Smith");
    account2.setAccountType("ASSETISSUE");

    ArrayList<Account> assets = new ArrayList<>();
    assets.add(account2);
    assets.add(account);

    // Act
    genesisBlock.setAssets(assets);

    // Assert
    assertSame(assets, genesisBlock.getAssets());
  }

  /**
   * Method under test: {@link GenesisBlock#setTimestamp(String)}
   */
  @Test
  public void testSetTimestamp() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new GenesisBlock()).setTimestamp("Timestamp"));
  }

  /**
   * Method under test: {@link GenesisBlock#setTimestamp(String)}
   */
  @Test
  public void testSetTimestamp2() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setTimestamp(null);

    // Assert
    assertEquals(GenesisBlock.DEFAULT_NUMBER, genesisBlock.getTimestamp());
  }

  /**
   * Method under test: {@link GenesisBlock#setParentHash(String)}
   */
  @Test
  public void testSetParentHash() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setParentHash("Parent Hash");

    // Assert
    assertEquals("Parent Hash", genesisBlock.getParentHash());
  }

  /**
   * Method under test: {@link GenesisBlock#setParentHash(String)}
   */
  @Test
  public void testSetParentHash2() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    // Act
    genesisBlock.setParentHash(null);

    // Assert
    assertEquals(GenesisBlock.DEFAULT_NUMBER, genesisBlock.getParentHash());
  }

  /**
   * Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  public void testSetWitnesses() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    ArrayList<Witness> witnesses = new ArrayList<>();

    // Act
    genesisBlock.setWitnesses(witnesses);

    // Assert
    assertSame(witnesses, genesisBlock.getWitnesses());
  }

  /**
   * Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  public void testSetWitnesses2() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setWitnesses(new ArrayList<>());

    // Act
    genesisBlock.setWitnesses(null);

    // Assert
    assertTrue(genesisBlock.getWitnesses().isEmpty());
  }

  /**
   * Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  public void testSetWitnesses3() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    Witness witness = new Witness();
    witness.setVoteCount(3L);

    ArrayList<Witness> witnesses = new ArrayList<>();
    witnesses.add(witness);

    // Act
    genesisBlock.setWitnesses(witnesses);

    // Assert
    assertSame(witnesses, genesisBlock.getWitnesses());
  }

  /**
   * Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  public void testSetWitnesses4() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();

    Witness witness = new Witness();
    witness.setVoteCount(3L);

    Witness witness2 = new Witness();
    witness2.setVoteCount(1L);

    ArrayList<Witness> witnesses = new ArrayList<>();
    witnesses.add(witness2);
    witnesses.add(witness);

    // Act
    genesisBlock.setWitnesses(witnesses);

    // Assert
    assertSame(witnesses, genesisBlock.getWitnesses());
  }

  /**
   * Method under test: {@link GenesisBlock#setWitnesses(List)}
   */
  @Test
  public void testSetWitnesses5() {
    // Arrange
    GenesisBlock genesisBlock = new GenesisBlock();
    genesisBlock.setAssets(new ArrayList<>());
    genesisBlock.setNumber("42");
    genesisBlock.setParentHash("Parent Hash");
    genesisBlock.setWitnesses(new ArrayList<>());
    COWArrayList<Witness> witnesses = mock(COWArrayList.class);

    // Act
    genesisBlock.setWitnesses(witnesses);

    // Assert
    assertSame(witnesses, genesisBlock.getWitnesses());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GenesisBlock}
   *   <li>{@link GenesisBlock#setNumber(String)}
   *   <li>{@link GenesisBlock#getAssets()}
   *   <li>{@link GenesisBlock#getNumber()}
   *   <li>{@link GenesisBlock#getParentHash()}
   *   <li>{@link GenesisBlock#getTimestamp()}
   *   <li>{@link GenesisBlock#getWitnesses()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GenesisBlock actualGenesisBlock = new GenesisBlock();
    actualGenesisBlock.setNumber("42");
    actualGenesisBlock.getAssets();
    String actualNumber = actualGenesisBlock.getNumber();
    actualGenesisBlock.getParentHash();
    actualGenesisBlock.getTimestamp();
    actualGenesisBlock.getWitnesses();

    // Assert that nothing has changed
    assertEquals(GenesisBlock.DEFAULT_NUMBER, actualNumber);
  }
}
