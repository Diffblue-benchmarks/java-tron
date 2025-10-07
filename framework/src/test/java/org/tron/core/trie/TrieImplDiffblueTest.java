package org.tron.core.trie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.db2.common.ConcurrentHashDB;
import org.tron.core.db2.common.DB;
import org.tron.core.trie.TrieImpl.Node;
import org.tron.core.trie.TrieImpl.NodeType;
import org.tron.core.trie.TrieImpl.ScanAction;

public class TrieImplDiffblueTest {
  /**
   * Test {@link TrieImpl#TrieImpl()}.
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>()"})
  public void testNewTrieImpl() {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl();

    // Assert
    DB<byte[], BytesCapsule> cache = actualTrieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertNull(cache.getDbName());
    assertNull(cache.iterator());
    assertNull(actualTrieImpl.getRoot());
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB)}.
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl(DB)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>(DB)"})
  public void testNewTrieImpl2() {
    // Arrange
    ConcurrentHashDB cache = new ConcurrentHashDB();

    // Act
    TrieImpl actualTrieImpl = new TrieImpl(cache);

    // Assert
    assertNull(actualTrieImpl.getRoot());
    assertSame(cache, actualTrieImpl.getCache());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return RootHash is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl(DB, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>(DB, byte[])"})
  public void testNewTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnRootHashIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl(new ConcurrentHashDB(), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualTrieImpl.getRootHash());
    Node root = actualTrieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return RootHash is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>(byte[])"})
  public void testNewTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnRootHashIsNull2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualTrieImpl.getRootHash());
    Node root = actualTrieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Cache return {@link ConcurrentHashDB}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>(byte[])"})
  public void testNewTrieImpl_whenNull_thenCacheReturnConcurrentHashDB() {
    // Arrange and Act
    TrieImpl actualTrieImpl = new TrieImpl((byte[]) null);

    // Assert
    DB<byte[], BytesCapsule> cache = actualTrieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertNull(cache.getDbName());
    assertNull(cache.iterator());
    assertNull(actualTrieImpl.getRoot());
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        actualTrieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#TrieImpl(DB, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Root is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#TrieImpl(DB, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.<init>(DB, byte[])"})
  public void testNewTrieImpl_whenNull_thenReturnRootIsNull() {
    // Arrange
    ConcurrentHashDB cache = new ConcurrentHashDB();

    // Act
    TrieImpl actualTrieImpl = new TrieImpl(cache, null);

    // Assert
    assertNull(actualTrieImpl.getRoot());
    assertSame(cache, actualTrieImpl.getCache());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        actualTrieImpl.getRootHash());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieImpl#setAsync(boolean)}
   *   <li>{@link TrieImpl#getCache()}
   *   <li>{@link TrieImpl#getRoot()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DB TrieImpl.getCache()",
    "Node TrieImpl.getRoot()",
    "void TrieImpl.setAsync(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setAsync(true);
    DB<byte[], BytesCapsule> actualCache = trieImpl.getCache();

    // Assert
    assertTrue(actualCache instanceof ConcurrentHashDB);
    assertNull(trieImpl.getRoot());
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and one is array
   *       of {@code byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplArrayOfByteWithAAndOneIsArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and one is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplArrayOfByteWithAAndOneIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} empty array of {@code byte} is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplEmptyArrayOfByteIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualGetResult =
        new TrieImpl("AXAXAXAX".getBytes("UTF-8")).get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_whenEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualGetResult = new TrieImpl("AXAXAXAX".getBytes("UTF-8")).get(new byte[] {});

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplWithRootIsEmptyArrayOfByte_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {});

    // Act
    byte[] actualGetResult = trieImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte}.
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImplWithRootIsEmptyArrayOfByte_whenEmptyArrayOfByte() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {});

    // Act
    byte[] actualGetResult = trieImpl.get(new byte[] {});

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link TrieImpl#get(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.get(byte[])"})
  public void testGetWithKey_givenTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualGetResult = new TrieImpl().get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test Node {@link Node#branchNodeCanCompact()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeCanCompact()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.branchNodeCanCompact()"})
  public void testNodeBranchNodeCanCompact_givenA() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertTrue(node.branchNodeCanCompact());
  }

  /**
   * Test Node {@link Node#branchNodeCanCompact()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeCanCompact()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.branchNodeCanCompact()"})
  public void testNodeBranchNodeCanCompact_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertTrue(new TrieImpl().new Node().branchNodeCanCompact());
  }

  /**
   * Test Node {@link Node#branchNodeCompactIdx()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeCompactIdx()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Node.branchNodeCompactIdx()"})
  public void testNodeBranchNodeCompactIdx_givenA() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals(-1, node.branchNodeCompactIdx());
  }

  /**
   * Test Node {@link Node#branchNodeCompactIdx()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeCompactIdx()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Node.branchNodeCompactIdx()"})
  public void testNodeBranchNodeCompactIdx_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertEquals(-1, new TrieImpl().new Node().branchNodeCompactIdx());
  }

  /**
   * Test Node {@link Node#branchNodeGetChild(int)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeGetChild(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeGetChild(int)"})
  public void testNodeBranchNodeGetChild_givenA() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertNull(node.branchNodeGetChild(1));
  }

  /**
   * Test Node {@link Node#branchNodeGetChild(int)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeGetChild(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeGetChild(int)"})
  public void testNodeBranchNodeGetChild_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertNull(new TrieImpl().new Node().branchNodeGetChild(1));
  }

  /**
   * Test Node {@link Node#branchNodeGetValue()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeGetValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.branchNodeGetValue()"})
  public void testNodeBranchNodeGetValue_givenA() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertNull(node.branchNodeGetValue());
  }

  /**
   * Test Node {@link Node#branchNodeGetValue()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeGetValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.branchNodeGetValue()"})
  public void testNodeBranchNodeGetValue_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertNull(new TrieImpl().new Node().branchNodeGetValue());
  }

  /**
   * Test Node {@link Node#branchNodeSetChild(int, Node)}.
   *
   * <p>Method under test: {@link Node#branchNodeSetChild(int, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeSetChild(int, Node)"})
  public void testNodeBranchNodeSetChild() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act
    Node actualBranchNodeSetChildResult = node.branchNodeSetChild(1, new TrieImpl().new Node());

    // Assert
    assertSame(node, actualBranchNodeSetChildResult);
  }

  /**
   * Test Node {@link Node#branchNodeSetChild(int, Node)}.
   *
   * <ul>
   *   <li>Then return {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeSetChild(int, Node)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeSetChild(int, Node)"})
  public void testNodeBranchNodeSetChild_thenReturnNodeWithThis$0IsTrieImpl() {
    // Arrange
    Node node = new TrieImpl().new Node();

    // Act
    Node actualBranchNodeSetChildResult = node.branchNodeSetChild(1, new TrieImpl().new Node());

    // Assert
    assertSame(node, actualBranchNodeSetChildResult);
  }

  /**
   * Test Node {@link Node#branchNodeSetValue(byte[])}.
   *
   * <p>Method under test: {@link Node#branchNodeSetValue(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeSetValue(byte[])"})
  public void testNodeBranchNodeSetValue() throws UnsupportedEncodingException {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act
    Node actualBranchNodeSetValueResult = node.branchNodeSetValue("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(node, actualBranchNodeSetValueResult);
  }

  /**
   * Test Node {@link Node#branchNodeSetValue(byte[])}.
   *
   * <ul>
   *   <li>Then return {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeSetValue(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeSetValue(byte[])"})
  public void testNodeBranchNodeSetValue_thenReturnNodeWithThis$0IsTrieImpl()
      throws UnsupportedEncodingException {
    // Arrange
    Node node = new TrieImpl().new Node();

    // Act
    Node actualBranchNodeSetValueResult = node.branchNodeSetValue("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(node, actualBranchNodeSetValueResult);
  }

  /**
   * Test Node {@link Node#branchNodeSetValue(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#branchNodeSetValue(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.branchNodeSetValue(byte[])"})
  public void testNodeBranchNodeSetValue_whenNull_thenReturnNodeWithThis$0IsTrieImpl() {
    // Arrange
    Node node = new TrieImpl().new Node();

    // Act
    Node actualBranchNodeSetValueResult = node.branchNodeSetValue(null);

    // Assert
    assertSame(node, actualBranchNodeSetValueResult);
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals("IndentPrefixBranchNode\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       hashOrRlp is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {});

    // Act and Assert
    assertEquals("IndentPrefixBranchNode\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code IndentPrefixBranchNode *}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixBranchNode() {
    // Arrange, Act and Assert
    assertEquals(
        "IndentPrefixBranchNode *\n", new TrieImpl().new Node().dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code IndentPrefixBranchNode * [T] = 4111411141114111}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixBranchNodeT4111411141114111() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals(
        "IndentPrefixBranchNode * [T] = 4111411141114111\n", node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code IndentPrefixKVNodeNode * [null] Indent BranchNode *}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixKVNodeNodeNullIndentBranchNode() {
    // Arrange
    Node node = new TrieImpl().new Node(3);
    node.kvNodeSetValueOrNode(new TrieImpl().new Node());

    // Act and Assert
    assertEquals(
        "IndentPrefixKVNodeNode * [null]\nIndent  BranchNode *\n",
        node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpStruct(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code IndentPrefixKVNodeValue * [null] = 4111411141114111}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpStruct(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.dumpStruct(String, String)"})
  public void testNodeDumpStruct_thenReturnIndentPrefixKVNodeValueNull4111411141114111() {
    // Arrange
    Node node = new TrieImpl().new Node(3);
    node.kvNodeSetValue(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals(
        "IndentPrefixKVNodeValue * [null] = 4111411141114111\n",
        node.dumpStruct("Indent", "Prefix"));
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertTrue(node.dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode2() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    node.branchNodeSetChild(1, new TrieImpl().new Node());

    // Act and Assert
    assertTrue(node.dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode3() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertTrue(node.dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       hashOrRlp is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {});

    // Act and Assert
    assertTrue(node.dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, int)} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       length is three.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImplAndLengthIsThree() {
    // Arrange, Act and Assert
    assertTrue(new TrieImpl().new Node(3).dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#dumpTrieNode(boolean)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Node#dumpTrieNode(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List Node.dumpTrieNode(boolean)"})
  public void testNodeDumpTrieNode_givenNodeWithThis$0IsTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TrieImpl().new Node().dumpTrieNode(true).isEmpty());
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetChild(1, new TrieImpl().new Node());

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          -107, -23, -108, -74, '+', -66, -69, 29, 7, '.', -72, -48, 'V', '+', -91, '6', -105, -6,
          -102, -45, -10, '*', -8, 29, '.', -81, -36, 28, -42, -29, -86, -25
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, -107, -23, -108, -74, '+', -66, -69, 29, 7, '.', -72, -48, 'V', '+', -91, '6', -105,
          -6, -102, -45, -10, '*', -8, 29, '.', -81, -36, 28, -42, -29, -86, -25
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode2() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          'd',
          '(',
          -44,
          'X',
          21,
          'H',
          -103,
          'u',
          -52,
          '&',
          -81,
          'J',
          -58,
          -65,
          -84,
          'F',
          -42,
          -126,
          -46,
          -16,
          -26,
          '\b',
          '4',
          -9,
          -71,
          -11,
          -74,
          -62,
          -4,
          ']',
          'I',
          Byte.MAX_VALUE
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96,
          'd',
          '(',
          -44,
          'X',
          21,
          'H',
          -103,
          'u',
          -52,
          '&',
          -81,
          'J',
          -58,
          -65,
          -84,
          'F',
          -42,
          -126,
          -46,
          -16,
          -26,
          '\b',
          '4',
          -9,
          -71,
          -11,
          -74,
          -62,
          -4,
          ']',
          'I',
          Byte.MAX_VALUE
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode3() {
    // Arrange
    Node node = new TrieImpl().new Node();
    Node node2 = new TrieImpl().new Node(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    node.branchNodeSetChild(1, node2);

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          '}', 'Q', '8', -24, -77, -50, ';', 't', -83, 31, -3, -75, '/', -5, -19, -36, '|', '%',
          'G', 29, -62, 'f', -46, -37, -107, -123, 'M', 'l', -48, -41, -25, 'F'
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, '}', 'Q', '8', -24, -77, -50, ';', 't', -83, 31, -3, -75, '/', -5, -19, -36, '|',
          '%', 'G', 29, -62, 'f', -46, -37, -107, -123, 'M', 'l', -48, -41, -25, 'F'
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImpl() {
    // Arrange
    Node node = new TrieImpl().new Node();

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a', 'n',
          -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a',
          'n', -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, int)} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       length is three.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImplAndLengthIsThree_thenReturnNull() {
    // Arrange
    Node node = new TrieImpl().new Node(3);

    // Act and Assert
    assertNull(node.encode());
    assertNull(node.hash);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}
   *       branchNodeSetChild one and {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImplBranchNodeSetChildOneAndNull() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetChild(1, null);

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a', 'n',
          -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a',
          'n', -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}
   *       branchNodeSetValue empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImplBranchNodeSetValueEmptyArrayOfByte() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(new byte[] {});

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a', 'n',
          -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a',
          'n', -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#encode()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}
   *       branchNodeSetValue {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#encode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.encode()"})
  public void testNodeEncode_givenNodeWithThis$0IsTrieImplBranchNodeSetValueNull() {
    // Arrange
    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(null);

    // Act
    byte[] actualEncodeResult = node.encode();

    // Assert
    assertArrayEquals(
        new byte[] {
          -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a', 'n',
          -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        node.hash);
    assertArrayEquals(
        new byte[] {
          -96, -66, 15, 'D', '@', -30, -109, -92, 'q', '`', -71, -79, 'H', -44, -110, 18, -48, 'a',
          'n', -59, -80, -89, '\f', -103, -34, -101, -13, 'e', 21, -43, '.', '\t', 1
        },
        actualEncodeResult);
  }

  /**
   * Test Node {@link Node#getType()}.
   *
   * <p>Method under test: {@link Node#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals(NodeType.BranchNode, node.getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   *
   * <p>Method under test: {@link Node#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType2() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals(NodeType.BranchNode, node.getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       hashOrRlp is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {});

    // Act and Assert
    assertEquals(NodeType.BranchNode, node.getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code BranchNode}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_givenNodeWithThis$0IsTrieImpl_thenReturnBranchNode() {
    // Arrange, Act and Assert
    assertEquals(NodeType.BranchNode, new TrieImpl().new Node().getType());
  }

  /**
   * Test Node {@link Node#getType()}.
   *
   * <ul>
   *   <li>Then return {@code KVNodeValue}.
   * </ul>
   *
   * <p>Method under test: {@link Node#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeType Node.getType()"})
  public void testNodeGetType_thenReturnKVNodeValue() {
    // Arrange, Act and Assert
    assertEquals(NodeType.KVNodeValue, new TrieImpl().new Node(3).getType());
  }

  /**
   * Test Node getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Node#setNodeType(NodeType)}
   *   <li>{@link Node#invalidate()}
   *   <li>{@link Node#getNodeType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NodeType Node.getNodeType()",
    "Node Node.invalidate()",
    "Node Node.setNodeType(NodeType)"
  })
  public void testNodeGettersAndSetters() {
    // Arrange
    Node node = new TrieImpl().new Node();

    // Act
    Node actualSetNodeTypeResult = node.setNodeType(NodeType.BranchNode);
    Node actualInvalidateResult = node.invalidate();

    // Assert
    assertEquals(NodeType.BranchNode, node.getNodeType());
    assertSame(node, actualInvalidateResult);
    assertSame(node, actualSetNodeTypeResult);
  }

  /**
   * Test Node {@link Node#kvNodeGetKey()}.
   *
   * <p>Method under test: {@link Node#kvNodeGetKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TrieKey Node.kvNodeGetKey()"})
  public void testNodeKvNodeGetKey() {
    // Arrange, Act and Assert
    assertNull(new TrieImpl().new Node(3).kvNodeGetKey());
  }

  /**
   * Test Node {@link Node#kvNodeGetValue()}.
   *
   * <p>Method under test: {@link Node#kvNodeGetValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Node.kvNodeGetValue()"})
  public void testNodeKvNodeGetValue() {
    // Arrange, Act and Assert
    assertNull(new TrieImpl().new Node(3).kvNodeGetValue());
  }

  /**
   * Test Node {@link Node#kvNodeGetValueOrNode()}.
   *
   * <p>Method under test: {@link Node#kvNodeGetValueOrNode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Node.kvNodeGetValueOrNode()"})
  public void testNodeKvNodeGetValueOrNode() {
    // Arrange, Act and Assert
    assertNull(new TrieImpl().new Node(3).kvNodeGetValueOrNode());
  }

  /**
   * Test Node {@link Node#kvNodeSetValue(byte[])}.
   *
   * <p>Method under test: {@link Node#kvNodeSetValue(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.kvNodeSetValue(byte[])"})
  public void testNodeKvNodeSetValue() throws UnsupportedEncodingException {
    // Arrange
    Node node = new TrieImpl().new Node(3);

    // Act
    Node actualKvNodeSetValueResult = node.kvNodeSetValue("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(node, actualKvNodeSetValueResult);
  }

  /**
   * Test Node {@link Node#kvNodeSetValueOrNode(Object)}.
   *
   * <p>Method under test: {@link Node#kvNodeSetValueOrNode(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Node Node.kvNodeSetValueOrNode(Object)"})
  public void testNodeKvNodeSetValueOrNode() {
    // Arrange
    Node node = new TrieImpl().new Node(3);

    // Act
    Node actualKvNodeSetValueOrNodeResult = node.kvNodeSetValueOrNode("Value Or Node");

    // Assert
    assertSame(node, actualKvNodeSetValueOrNodeResult);
  }

  /**
   * Test Node {@link Node#Node(TrieImpl)}.
   *
   * <p>Method under test: {@link Node#Node(TrieImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(TrieImpl)"})
  public void testNodeNewNode() {
    // Arrange and Act
    Node actualNode = new TrieImpl().new Node();

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.BranchNode, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, TrieKey, Object)}.
   *
   * <p>Method under test: {@link Node#Node(TrieImpl, TrieKey, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(TrieImpl, TrieKey, Object)"})
  public void testNodeNewNode2() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    TrieKey key = TrieKey.empty(true);

    // Act
    Node actualNode = trieImpl.new Node(key, "Value Or Node");

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.KVNodeValue, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, byte[])}.
   *
   * <p>Method under test: {@link Node#Node(TrieImpl, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(TrieImpl, byte[])"})
  public void testNodeNewNode3() throws UnsupportedEncodingException {
    // Arrange and Act
    Node actualNode = new TrieImpl().new Node("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.BranchNode, actualNode.getType());
  }

  /**
   * Test Node {@link Node#Node(TrieImpl, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link Node#hash} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Node#Node(TrieImpl, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Node.<init>(TrieImpl, int)"})
  public void testNodeNewNode_whenThree_thenReturnHashIsNull() {
    // Arrange and Act
    Node actualNode = new TrieImpl().new Node(3);

    // Assert
    assertNull(actualNode.hash);
    assertNull(actualNode.getNodeType());
    assertEquals(NodeType.KVNodeValue, actualNode.getType());
  }

  /**
   * Test Node {@link Node#resolveCheck()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Node#resolveCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.resolveCheck()"})
  public void testNodeResolveCheck_givenA() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertTrue(node.resolveCheck());
  }

  /**
   * Test Node {@link Node#resolveCheck()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link Node#resolveCheck()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Node.resolveCheck()"})
  public void testNodeResolveCheck_givenNodeWithThis$0IsTrieImpl() {
    // Arrange, Act and Assert
    assertTrue(new TrieImpl().new Node().resolveCheck());
  }

  /**
   * Test Node {@link Node#toString()}.
   *
   * <p>Method under test: {@link Node#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals("BranchNode", node.toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   *
   * <p>Method under test: {@link Node#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString2() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {Byte.MIN_VALUE, 17, 'A', 17, 'A', 17, 'A', 17});

    // Act and Assert
    assertEquals("BranchNode", node.toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl, byte[])} with this$0 is {@link TrieImpl#TrieImpl()} and
   *       hashOrRlp is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Node#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_givenNodeWithThis$0IsTrieImplAndHashOrRlpIsEmptyArrayOfByte() {
    // Arrange
    Node node = new TrieImpl().new Node(new byte[] {});

    // Act and Assert
    assertEquals("BranchNode", node.toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code BranchNode *}.
   * </ul>
   *
   * <p>Method under test: {@link Node#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_givenNodeWithThis$0IsTrieImpl_thenReturnBranchNode() {
    // Arrange, Act and Assert
    assertEquals("BranchNode *", new TrieImpl().new Node().toString());
  }

  /**
   * Test Node {@link Node#toString()}.
   *
   * <ul>
   *   <li>Then return {@code KVNodeValue}.
   * </ul>
   *
   * <p>Method under test: {@link Node#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Node.toString()"})
  public void testNodeToString_thenReturnKVNodeValue() {
    // Arrange, Act and Assert
    assertEquals("KVNodeValue", new TrieImpl().new Node(3).toString());
  }

  /**
   * Test {@link TrieImpl#put(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then {@link TrieImpl#TrieImpl()} Root NodeType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#put(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.put(byte[], byte[])"})
  public void testPutWithByteByte_givenTrieImpl_thenTrieImplRootNodeTypeIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Node root = trieImpl.getRoot();
    assertNull(root.getNodeType());
    assertEquals(NodeType.KVNodeValue, root.getType());
    byte[] rootHash = trieImpl.getRootHash();
    assertArrayEquals(
        new byte[] {
          -52, -74, '\n', ';', '5', '\b', -16, 18, '}', -24, '/', -122, -41, -5, 'x', 'x', -67, 'y',
          4, 'm', -85, 'x', '[', -58, '"', 'm', 21, -119, 'h', -91, -39, '2'
        },
        rootHash);
    assertSame(rootHash, root.hash);
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then {@link TrieImpl#TrieImpl()} Cache size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_givenTrieImpl_thenTrieImplCacheSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl()} Root is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_thenTrieImplRootIsNull() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[] {}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.delete(new byte[] {});

    // Assert
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertNull(trieImpl.getRoot());
    assertEquals(0L, cache.size());
    assertTrue(cache.isEmpty());
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is array of {@code byte} with {@code A}
   *       and one Cache size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_thenTrieImplWithRootIsArrayOfByteWithAAndOneCacheSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertEquals(NodeType.BranchNode, trieImpl.getRoot().getType());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#delete(byte[])} with {@code key}.
   *
   * <ul>
   *   <li>Then {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte} Cache
   *       {@link ConcurrentHashDB}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#delete(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.delete(byte[])"})
  public void testDeleteWithKey_thenTrieImplWithRootIsEmptyArrayOfByteCacheConcurrentHashDB()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {});

    // Act
    trieImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    DB<byte[], BytesCapsule> cache = trieImpl.getCache();
    assertTrue(cache instanceof ConcurrentHashDB);
    assertEquals(0L, cache.size());
    assertEquals(NodeType.BranchNode, trieImpl.getRoot().getType());
    assertTrue(cache.isEmpty());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new TrieImpl("AXAXAXAX".getBytes("UTF-8")).getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then return array of {@code byte} with {@code V} and minus twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_givenTrieImpl_thenReturnArrayOfByteWithVAndMinusTwentyFour() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        new TrieImpl().getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code h} and {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithHAndDot()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'h', '.', -122, 11, -3, 20, -18, -12, -126, '_', '*', '=', -51, -2, 'E', -98, '>', 4, -32,
          'Q', -118, -107, 'h', '9', '4', '?', -73, 30, '\r', 'M', '|', -18
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty and {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusFiftyAndSlash()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          -50, '/', -52, 22, -120, -69, '?', 'I', 'R', 'a', 'x', '$', 2, -99, 'f', -123, -124, -23,
          '1', -2, 'h', '4', 11, 7, '"', -94, -33, '+', -95, '~', 'y', '|'
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus fifty-two and minus seventy-four.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusFiftyTwoAndMinusSeventyFour()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          -52, -74, '\n', ';', '5', '\b', -16, 18, '}', -24, '/', -122, -41, -5, 'x', 'x', -67, 'y',
          4, 'm', -85, 'x', '[', -58, '"', 'm', 21, -119, 'h', -91, -39, '2'
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty and form feed (ff).
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusSixtyAndFormFeed()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          -60, '\f', '4', 28, -74, -2, -117, -83, -88, 'J', 15, 17, -60, 'k', -39, 17, 24, -56, -49,
          '2', -82, -22, -9, -126, -88, 31, -99, -123, 17, -31, -65, -99
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty and minus thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithMinusSixtyAndMinusThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          -60, -36, -82, -122, -53, 'm', -50, '&', -102, -27, 'k', 'H', -55, -61, -57, '1', 'Q',
          -82, -104, 'b', -75, '8', -51, 'y', '?', -76, -91, 't', -16, -98, -88, -15
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#getRootHash()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code s} and minus ninety-two.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#getRootHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TrieImpl.getRootHash()"})
  public void testGetRootHash_thenReturnArrayOfByteWithSAndMinusNinetyTwo()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          's', -92, 'Q', '\t', -38, '}', -99, 'c', 21, -107, -82, -123, -103, 'P', 'l', 14, 'd',
          'd', -81, 'u', ';', '!', -28, -15, '6', 6, ' ', 3, -121, -42, -34, 'n'
        },
        trieImpl.getRootHash());
  }

  /**
   * Test {@link TrieImpl#clear()}.
   *
   * <p>Method under test: {@link TrieImpl#clear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.clear()"})
  public void testClear() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new TrieImpl().clear());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and three is array
   *       of {@code byte} with {@code A} and three.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplArrayOfByteWithAAndThreeIsArrayOfByteWithAAndThree()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3}, new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and three is array
   *       of {@code byte} with {@code A} and three.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplArrayOfByteWithAAndThreeIsArrayOfByteWithAAndThree2()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3},
        new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertTrue(trieImpl.flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(new TrieImpl("AXAXAXAX".getBytes("UTF-8")).flush());
  }

  /**
   * Test {@link TrieImpl#flush()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.flush()"})
  public void testFlush_givenTrieImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TrieImpl().flush());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}, and {@link TrieImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieImpl#equals(Object)}
   *   <li>{@link TrieImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    TrieImpl trieImpl2 = new TrieImpl();

    // Act and Assert
    assertEquals(trieImpl, trieImpl2);
    assertNotEquals(trieImpl.hashCode(), trieImpl2.hashCode());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}, and {@link TrieImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieImpl#equals(Object)}
   *   <li>{@link TrieImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act and Assert
    assertEquals(trieImpl, trieImpl);
    int expectedHashCodeResult = trieImpl.hashCode();
    assertEquals(expectedHashCodeResult, trieImpl.hashCode());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("A A A A ".getBytes("UTF-8"), "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("A A A A ".getBytes("UTF-8"));
    trieImpl.put("A A A A ".getBytes("UTF-8"), "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("A A A A ".getBytes("UTF-8"), "A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(trieImpl, new TrieImpl());
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TrieImpl(), null);
  }

  /**
   * Test {@link TrieImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.equals(Object)", "int TrieImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TrieImpl(), "Different type to TrieImpl");
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "BranchNode *\n  [4] KVNodeValue * [158415841584158T] = 4158415841584158\n",
        trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenA_thenReturnAString() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17},
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "KVNodeNode * [41]\n"
            + "  BranchNode *\n"
            + "    [1] KVNodeValue * [1411141114111T] = 4111411141114111\n"
            + "    [5] KVNodeValue * [8415841584158T] = 4158415841584158\n",
        trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("BranchNode\n", new TrieImpl("AXAXAXAX".getBytes("UTF-8")).dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte}.
   *   <li>Then return {@code BranchNode}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenTrieImplWithRootIsEmptyArrayOfByte_thenReturnBranchNode() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {});

    // Act and Assert
    assertEquals("BranchNode\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code <empty>}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", new TrieImpl().dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Then return {@code BranchNode * [T] = 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_thenReturnBranchNodeT4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("BranchNode * [T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Then return {@code KVNodeValue * [4158415841584158T] = 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_thenReturnKVNodeValue4158415841584158t4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "KVNodeValue * [4158415841584158T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpStructure()}.
   *
   * <ul>
   *   <li>Then return {@code KVNodeValue * [T] = 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpStructure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpStructure()"})
  public void testDumpStructure_thenReturnKVNodeValueT4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(null, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("KVNodeValue * [T] = 4158415841584158\n", trieImpl.dumpStructure());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {
          'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1,
          'A', 1
        },
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x59743f85\n"
            + "0x59743f85 ==> [,,,,0xd04be9eb,,,,,,,,,,,]\n"
            + "0xd04be9eb ==> [<10141014101410141014101410141014101410141014101T>, \"4101410141014101\"]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0xccb60a3b\n0xccb60a3b ==> [<4158415841584158T>, \"4158415841584158\"]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0xc4dcae86\n0xc4dcae86 ==> [,,,,[<158415841584158T>, \"4158415841584158\"],,,,,,,,,,,]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0xce2fcc16\n"
            + "0xce2fcc16 ==> [<41>, 0xc0613c23]\n"
            + "0xc0613c23 ==> [[<1410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>, \"4158415841584158\"],,,,,,,,,,]"
            + "\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean4() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0xc40c341c\n"
            + "0xc40c341c ==> [,,,,0x7766d698,,,,,,,,,,,]\n"
            + "0x7766d698 ==> [<1>, 0xc0613c23]\n"
            + "0xc0613c23 ==> [[<1410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>, \"4158415841584158\"],,,,,,,,,,]"
            + "\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean5() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        "AXAXAXAX".getBytes("UTF-8"),
        new byte[] {
          'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1,
          'A', 1
        });

    // Act and Assert
    assertEquals(
        "Root: 0xb4f3b845\n0xb4f3b845 ==> [<4158415841584158T>, \"4101410141... len 24\"]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean6() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0x73a45109\n"
            + "0x73a45109 ==> [<41>, 0x8e4987dc]\n"
            + "0x8e4987dc ==> [[<14101410141014101410141014101T>, \"4101410141014101\"],,,,,[<8415841584158T>,"
            + " \"4158415841584158\"],,,,,,,,,,]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code <empty>}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", new TrieImpl().dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0x682e860b 0x682e860b ==> [,,,,,,,,,,,,,,,,
   *       "4158415841584158"]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie(boolean)"})
  public void testDumpTrieWithBoolean_thenReturnRoot0x682e860b0x682e860b4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(
        "Root: 0x682e860b\n0x682e860b ==> [,,,,,,,,,,,,,,,, \"4158415841584158\"]\n",
        trieImpl.dumpTrie(true));
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and {@code A} is
   *       array of {@code byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImplArrayOfByteWithAAndAIsArrayOfByteWithAAndOne() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 'A', 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x65075e45\n"
            + "0x65075e45 ==> [<41>, 0x6cbe9eab]\n"
            + "0x6cbe9eab ==> [[<1410141014101T>, \"4101410141014101\"],,,,[<1410141014101T>, \"4101410141014101\"],,,,,,,,,,,]"
            + "\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code X} and one is array
   *       of {@code byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImplArrayOfByteWithXAndOneIsArrayOfByteWithAAndOne() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'X', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x3fd00e3c\n"
            + "0x3fd00e3c ==> [,,,,[<101410141014101T>, \"4101410141014101\"],[<801410141014101T>, \"4101410141014101\""
            + "],,,,,,,,,,]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code X} and one is array
   *       of {@code byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImplArrayOfByteWithXAndOneIsArrayOfByteWithAAndOne2() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'X', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x25df632f\n"
            + "0x25df632f ==> [,,,,[<101410141014101T>, \"4101410141014101\"],[<801410141014101T>, \"41014101410141014"
            + "101410141014101\"],,,,,,,,,,]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>Then return {@code <empty>}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_givenTrieImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals("<empty>", new TrieImpl().dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0x53b4ddb6 0x53b4ddb6 ==> [,,,,[<101410141014101T>,
   *       "4101410141014101"],,,,,,,,,,,]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x53b4ddb60x53b4ddb6101410141014101t4101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x53b4ddb6\n0x53b4ddb6 ==> [,,,,[<101410141014101T>, \"4101410141014101\"],,,,,,,,,,,]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0x6428d458 0x6428d458 ==> [,,,,,,,,,,,,,,,,
   *       "4101410141014101"]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x6428d4580x6428d4584101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(new byte[] {}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x6428d458\n0x6428d458 ==> [,,,,,,,,,,,,,,,, \"4101410141014101\"]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0x8658671d 0x8658671d ==> [<4101410141014101T>,
   *       "4101410141014101"]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x8658671d0x8658671d4101410141014101t4101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x8658671d\n0x8658671d ==> [<4101410141014101T>, \"4101410141014101\"]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0x78540247 0x78540247 ==> [<T>, "4101410141014101"]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0x785402470x78540247T4101410141014101() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[] {}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertEquals(
        "Root: 0x78540247\n0x78540247 ==> [<T>, \"4101410141014101\"]\n", trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#dumpTrie()}.
   *
   * <ul>
   *   <li>Then return {@code Root: 0xb105f65e 0xb105f65e ==> [<4101410141014101T>, "4101410141...
   *       len 24"]}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#dumpTrie()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TrieImpl.dumpTrie()"})
  public void testDumpTrie_thenReturnRoot0xb105f65e0xb105f65e4101410141014101t4101410141Len24() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[] {
          'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1,
          'A', 1
        });

    // Act and Assert
    assertEquals(
        "Root: 0xb105f65e\n0xb105f65e ==> [<4101410141014101T>, \"4101410141... len 24\"]\n",
        trieImpl.dumpTrie());
  }

  /**
   * Test {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)} with {@code node}, {@code k}, {@code
   * scanAction}.
   *
   * <p>Method under test: {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(Node, TrieKey, ScanAction)"})
  public void testScanTreeWithNodeKScanAction() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    Node node = new TrieImpl().new Node(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    node.branchNodeSetValue(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    TrieKey k = TrieKey.empty(false);

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(node, k, scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)} with {@code node}, {@code k}, {@code
   * scanAction}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When empty {@code false}.
   *   <li>Then calls {@link ScanAction#doOnValue(byte[], Node, byte[], byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(Node, TrieKey, ScanAction)"})
  public void testScanTreeWithNodeKScanAction_givenA_whenEmptyFalse_thenCallsDoOnValue() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    TrieKey k = TrieKey.empty(false);

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(node, k, scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)} with {@code node}, {@code k}, {@code
   * scanAction}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(Node, TrieKey, ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(Node, TrieKey, ScanAction)"})
  public void testScanTreeWithNodeKScanAction_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    Node node = new TrieImpl().new Node();
    node.branchNodeSetValue(new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    TrieKey k = TrieKey.empty(true);

    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException())
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(node, k, scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException())
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction3() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction4() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException())
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenA_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17},
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException())
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ScanAction} {@link ScanAction#doOnValue(byte[], Node, byte[], byte[])} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenA_whenScanActionDoOnValueDoesNothing()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17},
        new byte[] {'A', 17, 'A', 17, 'A', 17, 'A', 17});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction, atLeast(1))
        .doOnValue(isNull(), Mockito.<Node>any(), Mockito.<byte[]>any(), Mockito.<byte[]>any());
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_givenTrieImplAxaxaxaxBytesIsUtf8IsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doNothing()
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act
    trieImpl.scanTree(scanAction);

    // Assert
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#scanTree(ScanAction)} with {@code scanAction}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#scanTree(ScanAction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.scanTree(ScanAction)"})
  public void testScanTreeWithScanAction_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    ScanAction scanAction = mock(ScanAction.class);
    doThrow(new RuntimeException())
        .when(scanAction)
        .doOnValue(
            Mockito.<byte[]>any(),
            Mockito.<Node>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> trieImpl.scanTree(scanAction));
    verify(scanAction).doOnValue(isNull(), isA(Node.class), isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    LinkedHashMap<byte[], Node> actualProveResult = trieImpl.prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} array of {@code byte} with {@code A} and one is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplArrayOfByteWithAAndOneIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        "AXAXAXAX".getBytes("UTF-8"));

    // Act
    LinkedHashMap<byte[], Node> actualProveResult = trieImpl.prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} empty array of {@code byte} is array of {@code byte}
   *       with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplEmptyArrayOfByteIsArrayOfByteWithAAndOne()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[] {}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(2, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()} empty array of {@code byte} is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplEmptyArrayOfByteIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    LinkedHashMap<byte[], Node> actualProveResult = trieImpl.prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplWithRootIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LinkedHashMap<byte[], Node> actualProveResult =
        new TrieImpl("AXAXAXAX".getBytes("UTF-8")).prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl(byte[])} with root is empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImplWithRootIsEmptyArrayOfByte_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl(new byte[] {});

    // Act
    LinkedHashMap<byte[], Node> actualProveResult = trieImpl.prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Given {@link TrieImpl#TrieImpl()}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_givenTrieImpl_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    LinkedHashMap<byte[], Node> actualProveResult =
        new TrieImpl().prove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsFour() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(4, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(1, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsThree() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(3, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsThree2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(3, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_thenReturnSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl("AXAXAXAX".getBytes("UTF-8"));
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(2, trieImpl.prove("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    trieImpl.put(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    trieImpl.put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Act
    LinkedHashMap<byte[], Node> actualProveResult = trieImpl.prove(new byte[] {});

    // Assert
    assertNull(actualProveResult);
  }

  /**
   * Test {@link TrieImpl#prove(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#prove(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap TrieImpl.prove(byte[])"})
  public void testProve_whenEmptyArrayOfByte_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, new TrieImpl("AXAXAXAX".getBytes("UTF-8")).prove(new byte[] {}).size());
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()} NodeType is
   *       {@code BranchNode}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_givenNodeWithThis$0IsTrieImplNodeTypeIsBranchNode()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    Node node = new TrieImpl().new Node();
    node.setNodeType(NodeType.BranchNode);

    LinkedHashMap<byte[], Node> nodeMap = new LinkedHashMap<>();
    nodeMap.put("A\bA\bA\bA\b".getBytes("UTF-8"), node);

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, key, nodeMap));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()} NodeType is
   *       {@code BranchNode}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_givenNodeWithThis$0IsTrieImplNodeTypeIsBranchNode_whenNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    Node node = new TrieImpl().new Node();
    node.setNodeType(NodeType.BranchNode);

    LinkedHashMap<byte[], Node> nodeMap = new LinkedHashMap<>();
    nodeMap.put("A\bA\bA\bA\b".getBytes("UTF-8"), node);

    // Act and Assert
    assertFalse(trieImpl.verifyProof(null, key, nodeMap));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(TrieImpl)} with this$0 is {@link TrieImpl#TrieImpl()} NodeType is
   *       {@code BranchNode}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_givenNodeWithThis$0IsTrieImplNodeTypeIsBranchNode_whenNull2()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");

    Node node = new TrieImpl().new Node();
    node.setNodeType(NodeType.BranchNode);

    LinkedHashMap<byte[], Node> nodeMap = new LinkedHashMap<>();
    nodeMap.put("A\bA\bA\bA\b".getBytes("UTF-8"), node);

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, null, nodeMap));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    Node node = new TrieImpl().new Node();
    node.setNodeType(NodeType.BranchNode);

    LinkedHashMap<byte[], Node> nodeMap = new LinkedHashMap<>();
    nodeMap.put("A\bA\bA\bA\b".getBytes("UTF-8"), node);

    // Act and Assert
    assertFalse(trieImpl.verifyProof(new byte[] {}, key, nodeMap));
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenEmptyArrayOfByte2() throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");

    Node node = new TrieImpl().new Node();
    node.setNodeType(NodeType.BranchNode);

    LinkedHashMap<byte[], Node> nodeMap = new LinkedHashMap<>();
    nodeMap.put("A\bA\bA\bA\b".getBytes("UTF-8"), node);

    // Act
    boolean actualVerifyProofResult = trieImpl.verifyProof(rootHash, new byte[] {}, nodeMap);

    // Assert
    assertFalse(actualVerifyProofResult);
  }

  /**
   * Test {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#verifyProof(byte[], byte[], LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TrieImpl.verifyProof(byte[], byte[], LinkedHashMap)"})
  public void testVerifyProof_whenLinkedHashMap_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();
    byte[] rootHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(trieImpl.verifyProof(rootHash, key, new LinkedHashMap<>()));
  }

  /**
   * Test {@link TrieImpl#setRoot(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link TrieImpl#TrieImpl()} RootHash is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#setRoot(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.setRoot(byte[])"})
  public void testSetRoot_whenAxaxaxaxBytesIsUtf8_thenTrieImplRootHashIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setRoot("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(trieImpl.getRootHash());
    Node root = trieImpl.getRoot();
    assertNull(root.hash);
    assertNull(root.getNodeType());
    assertEquals(NodeType.BranchNode, root.getType());
  }

  /**
   * Test {@link TrieImpl#setRoot(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link TrieImpl#TrieImpl()} RootHash is array of {@code byte} with {@code V} and
   *       minus twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link TrieImpl#setRoot(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TrieImpl.setRoot(byte[])"})
  public void testSetRoot_whenNull_thenTrieImplRootHashIsArrayOfByteWithVAndMinusTwentyFour() {
    // Arrange
    TrieImpl trieImpl = new TrieImpl();

    // Act
    trieImpl.setRoot(null);

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          'V', -24, 31, 23, 27, -52, 'U', -90, -1, -125, 'E', -26, -110, -64, -8, 'n', '[', 'H',
          -32, 27, -103, 'l', -83, -64, 1, 'b', '/', -75, -29, 'c', -76, '!'
        },
        trieImpl.getRootHash());
  }
}
